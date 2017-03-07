package com.sanmina.sys_i.util;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;
import com.sanmina.sys_i.bean.model.SystemInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by kane on 17-3-6.
 */
public class SystemInfoUtil {

    private static Logger logger = LoggerFactory.getLogger(SystemInfoUtil.class);
    private static final String cpuComm = "lscpu | grep -E \"MHz|name\"";
    private static final String ipComm = "ifconfig enp4s0f2 | grep \"inet 地址\" | awk '{ print $2}' | awk -F: '{print $2}'";
    private static final String memComm = "cat /proc/meminfo";
    private static final String hostComm = "hostname";


    public void getHostName(Connection conn, SystemInfo systemInfo){
        try{
            Session session = conn.openSession();
            session.execCommand(hostComm);
            InputStream stdout = new StreamGobbler(session.getStdout());
            BufferedReader br = new BufferedReader(new InputStreamReader(stdout));
            systemInfo.setHostname(br.readLine().trim());
            br.close();
        }catch(Exception e){
            logger.error(e.toString());
        }

    }

    public void getIp(Connection conn, SystemInfo systemInfo){
        try{
            Session session = conn.openSession();
            session.execCommand(ipComm);
            InputStream stdout = new StreamGobbler(session.getStdout());
            BufferedReader br = new BufferedReader(new InputStreamReader(stdout));
            systemInfo.setIpAddr(br.readLine().trim());
            br.close();
        }catch(Exception e){
            logger.error(e.toString());
        }

    }

    public void getCpu(Connection conn, SystemInfo systemInfo){
        try{
            Session session = conn.openSession();
            session.execCommand(cpuComm);
            InputStream stdout = new StreamGobbler(session.getStdout());
            BufferedReader br = new BufferedReader(new InputStreamReader(stdout));
            String line;
            while((line = br.readLine() )!= null) {
                String subLine[];
                if(line.contains("：")){
                    subLine = line.split("：");
                }else{
                    subLine = line.split(":");
                }
                logger.info(subLine[0]+"---------------------"+subLine[1]);
                if ("Model name".equals(subLine[0])) {

                    systemInfo.setCpuModelName(subLine[1].trim());

                } else if ("CPU MHz".equals(subLine[0])) {

                    systemInfo.setCpuMHz(subLine[1].trim());

                }
            }
            br.close();
        }catch(Exception e){
            logger.error(e.toString());
        }
    }

    public void getMem(Connection conn, SystemInfo systemInfo){
        try{
            Session session = conn.openSession();
            session.execCommand(memComm);
            InputStream stdout = new StreamGobbler(session.getStdout());
            BufferedReader br = new BufferedReader(new InputStreamReader(stdout));
            String line;
            while((line = br.readLine() )!= null) {
                String subLine[] = line.split(":");
                if("MemTotal".equals(subLine[0])) {

                    systemInfo.setTotalMem(subLine[1].trim());

                } else if("MemFree".equals(subLine[0])){

                    systemInfo.setFreeMem(subLine[1].trim());

                }

            }
            br.close();
        }catch(Exception e){
            logger.error(e.toString());
        }
    }
}
