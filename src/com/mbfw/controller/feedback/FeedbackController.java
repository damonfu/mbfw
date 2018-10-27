package com.mbfw.controller.feedback;

import com.mbfw.controller.base.BaseController;
import com.mbfw.entity.feedback.FeedbackBean;
import com.mbfw.entity.feedback.FeedbackResult;
import com.mbfw.service.feedback.FeedbackService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/feedback")
public class FeedbackController extends BaseController {

    @Resource(name="feedbackService")
    private FeedbackService feedbackService;

    @RequestMapping(value = "/save")
    @ResponseBody
    public FeedbackResult save(@RequestBody FeedbackBean bean) {
        FeedbackResult result = new FeedbackResult();
        try {
            bean.setId(this.get32UUID());
            feedbackService.save(bean);
            result.setSuccess(true);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        result.setSuccess(false);
        result.setErrorCode("1000");
        result.setErrorMsg("保存失败");
        return result;
    }
}
