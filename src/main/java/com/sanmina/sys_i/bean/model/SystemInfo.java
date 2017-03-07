package com.sanmina.sys_i.bean.model;

/**
 * computer's
 * Created by kane on 17-3-6.
 */
public class SystemInfo {

    private String hostname;
    private String ipAddr;
    private String cpuModelName;
    private String cpuMHz;
    private String totalMem;
    private String freeMem;




    public String getTotalMem() {
        return totalMem;
    }

    public void setTotalMem(String totalMem) {
        this.totalMem = totalMem;
    }



    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }



    public String getCpuModelName() {
        return cpuModelName;
    }

    public void setCpuModelName(String cpuModelName) {
        this.cpuModelName = cpuModelName;
    }

    public String getCpuMHz() {
        return cpuMHz;
    }

    public void setCpuMHz(String cpuMHz) {
        this.cpuMHz = cpuMHz;
    }

    public String getFreeMem() {
        return freeMem;
    }

    public void setFreeMem(String freeMem) {
        this.freeMem = freeMem;
    }


    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

}


