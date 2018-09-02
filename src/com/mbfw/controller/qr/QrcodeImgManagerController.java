package com.mbfw.controller.qr;

import com.mbfw.controller.base.BaseController;
import com.mbfw.entity.qr.PageLimit;
import com.mbfw.entity.qr.QrcodeImg;
import com.mbfw.entity.qr.QrcodeImgResult;
import com.mbfw.service.qr.QrcodeImgService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/qrman")
public class QrcodeImgManagerController extends BaseController {

    @Resource(name = "qrcodeImgService")
    private QrcodeImgService qrcodeImgService;

    @RequestMapping(value = "/findAllByPage/{count}/{page}")
    @ResponseBody
    public QrcodeImgResult findAllQrcodeImgsByPage(@PathVariable("count") int count, @PathVariable("page") int page) {
        QrcodeImgResult result = new QrcodeImgResult();
        PageLimit pageLimit = new PageLimit((page - 1) * count, count);
        try {
            List<QrcodeImg> qrcodeImgs = qrcodeImgService.findAllByLimitPage(pageLimit);
            result.setQrcodeImgs(qrcodeImgs);
        } catch (Exception e) {
            e.printStackTrace();
            result.setError(true);
        }
        return result;
    }
}
