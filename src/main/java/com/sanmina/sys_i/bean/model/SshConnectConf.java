package com.sanmina.sys_i.bean.model;

/**
 * Created by kane on 17-3-6.
 * Ssh连接的实体类
 */
public class SshConnectConf {
    private String ip;
    private Integer port;
    private String username;
    private String password;

    public SshConnectConf(){}

    public SshConnectConf(String ip,Integer port,String username,String password){
        this.ip = ip;
        this.port = port;
        this.username = username;
        this.password = password;
    }




    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
