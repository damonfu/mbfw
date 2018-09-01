package com.mbfw.controller.qr;

import com.mbfw.controller.base.BaseController;
import com.mbfw.entity.qr.GirlResult;
import com.mbfw.service.qr.GirlService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/girl")
public class GirlController extends BaseController {

    @Resource(name = "girlService")
    private GirlService girlService;


    /**
     * 获取福利图片内容接口
     * @param count  个数
     * @param page   页数
     * @return
     */
    @RequestMapping(value = "/findByPage/{count}/{page}")
    @ResponseBody
    public GirlResult getGrilsByPage(@PathVariable("count") String count, @PathVariable("page") String page) {
        GirlResult result = new GirlResult();
        result.setError(true);
        return result;
    }
}
