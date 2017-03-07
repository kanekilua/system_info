package com.sanmina.sys_i.service;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.ConnectionInfo;
import com.sanmina.sys_i.bean.model.SshConnectConf;
import com.sanmina.sys_i.bean.model.SystemInfo;
import com.sanmina.sys_i.util.SystemInfoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


/**
 * Created by kane on 17-3-6.
 */
@Service
public class SystemInfoService {

    private static Logger logger = LoggerFactory.getLogger(SystemInfoService.class);

    public SystemInfo getSystemInfo(SshConnectConf sshConnectConf){
        SystemInfo systemInfo = new SystemInfo();
        SystemInfoUtil systemInfoUtil = new SystemInfoUtil();
        try{
            Connection conn = new Connection(sshConnectConf.getIp(),sshConnectConf.getPort());
            ConnectionInfo info = conn.connect();
            boolean connResult = conn.authenticateWithPassword(sshConnectConf.getUsername(), sshConnectConf.getPassword());

            systemInfoUtil.getHostName(conn,systemInfo);
            systemInfoUtil.getIp(conn,systemInfo);
            systemInfoUtil.getCpu(conn,systemInfo);
            systemInfoUtil.getMem(conn,systemInfo);
            conn.close();
            return systemInfo;
        }catch (Exception e){
            logger.error(e.toString());
        }
        return null;
    }
}
