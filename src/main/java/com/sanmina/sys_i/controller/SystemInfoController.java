package com.sanmina.sys_i.controller;

import com.sanmina.sys_i.bean.model.JsonResult;
import com.sanmina.sys_i.bean.model.SshConnectConf;
import com.sanmina.sys_i.bean.model.SystemInfo;
import com.sanmina.sys_i.service.SystemInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by kane on 17-3-7.
 */
@RestController
@RequestMapping(path = "/systemInfo")
public class SystemInfoController {

    @Autowired
    private SystemInfoService systemInfoService;

    @PostMapping
    public JsonResult getSystemInfo(@RequestBody @Valid SshConnectConf sshConnectConf){
        JsonResult jsonResult = new JsonResult();
        SystemInfo systemInfo = systemInfoService.getSystemInfo(sshConnectConf);
        jsonResult.setData(systemInfo);
        if(systemInfo != null) {
            jsonResult.setMessage("Getting system infomation success");
            jsonResult.setSuccess(true);
        }else{
            jsonResult.setMessage("Getting system infomation faild");
            jsonResult.setSuccess(false);
        }
//        String result = systemInfo.getHostname() + systemInfo.getCpuMHz() +systemInfo.getFreeMem();
        return jsonResult;
    }
}
