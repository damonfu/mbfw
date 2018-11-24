package com.mbfw.controller.xapp;

import com.mbfw.controller.base.BaseController;
import com.mbfw.entity.app.AppVersionBean;
import com.mbfw.entity.app.AppVersionRequest;
import com.mbfw.entity.app.AppVersionResult;
import com.mbfw.service.app.AppVersionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/xapp")
public class AppVersionController extends BaseController {

    @Resource(name = "appVersionService")
    private AppVersionService appVersionService;


    @RequestMapping(value = "/findLaste")
    @ResponseBody
    public AppVersionResult findLaste(@RequestBody AppVersionRequest request) {
        AppVersionResult result = new AppVersionResult();
        try {
            AppVersionBean bean = appVersionService.findLasteByPack(request);
            result.setSuccess(bean != null);
            result.setAppVersionBean(bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


}
