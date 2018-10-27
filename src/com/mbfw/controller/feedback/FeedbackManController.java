package com.mbfw.controller.feedback;

import com.mbfw.controller.base.BaseController;
import com.mbfw.entity.Page;
import com.mbfw.service.feedback.FeedbackService;
import com.mbfw.util.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.PrintWriter;
import java.util.*;

@Controller
@RequestMapping(value = "/fbman")
public class FeedbackManController extends BaseController {

    String menuUrl = "fbman/list.do";

    @Resource(name="feedbackService")
    FeedbackService feedbackService;

    @RequestMapping(value = "/list")
    public ModelAndView list(Page page) {
        logBefore(logger, "列表fbs");
        ModelAndView mv = this.getModelAndView();
        PageData pd;
        try {
            pd = this.getPageData();

            String KEYW = pd.getString("keyword");

            if (null != KEYW && !"".equals(KEYW)) {
                KEYW = KEYW.trim();
                pd.put("KEYW", KEYW);
            }

            page.setPd(pd);
            List<PageData> varList = feedbackService.list(page); // 列出temple列表
            mv.setViewName("qrcode/feedback/feedback_list");
            mv.addObject("varList", varList);
            mv.addObject("pd", pd);
            mv.addObject(Const.SESSION_QX, this.getHC()); // 按钮权限
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }
        return mv;
    }

    /**
     * 去修改页面
     */
    @RequestMapping(value = "/goEdit")
    public ModelAndView goEdit() {
        logBefore(logger, "去修改fb页面");
        ModelAndView mv = this.getModelAndView();
        PageData pd = new PageData();
        pd = this.getPageData();
        try {
            pd = feedbackService.findById(pd); // 根据ID读取
            mv.setViewName("qrcode/feedback/feedback_edit");
            mv.addObject("msg", "edit");
            mv.addObject("pd", pd);
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }
        return mv;
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/edit")
    public ModelAndView edit() throws Exception {
        logBefore(logger, "修改fb");
        if (!Jurisdiction.buttonJurisdiction(menuUrl, "edit")) {
            return null;
        }
        ModelAndView mv = this.getModelAndView();
        PageData pd = this.getPageData();
        pd.put("USED", true);
        pd.put("PUBLISHEDAT", Tools.date2Str(new Date()));
        feedbackService.edit(pd);
        mv.addObject("msg", "success");
        mv.setViewName("save_result");
        return mv;
    }

    /**
     * 去新增页面
     */
    @RequestMapping(value = "/goAdd")
    public ModelAndView goAdd() {
        logBefore(logger, "去新增fb页面");
        ModelAndView mv = this.getModelAndView();
        PageData pd = new PageData();
        pd = this.getPageData();
        try {
            mv.setViewName("qrcode/feedback/feedback_edit");
            mv.addObject("msg", "save");
            mv.addObject("pd", pd);
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }
        return mv;
    }

    /**
     * 新增
     */
    @RequestMapping(value = "/save")
    public ModelAndView save() throws Exception {
        logBefore(logger, "新增fb");
        if (!Jurisdiction.buttonJurisdiction(menuUrl, "add")) {
            return null;
        } // 校验权限
        ModelAndView mv = this.getModelAndView();
        PageData pd = this.getPageData();
        pd.put("_ID", this.get32UUID()); // 主键
        pd.put("CREATEDAT", Tools.date2Str(new Date())); // 创建时间
        pd.put("USED", true);
        pd.put("PUBLISHEDAT", Tools.date2Str(new Date()));
        feedbackService.save(pd);
        mv.addObject("msg", "success");
        mv.setViewName("save_result");
        return mv;
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete")
    public void delete(PrintWriter out) {
        logBefore(logger, "删除fb");
        if (!Jurisdiction.buttonJurisdiction(menuUrl, "del")) {
            return;
        }
        PageData pd;
        try {
            pd = this.getPageData();
            feedbackService.delete(pd);
            out.write("success");
            out.close();
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }

    }

    /**
     * 批量删除
     */
    @RequestMapping(value = "/deleteAll")
    @ResponseBody
    public Object deleteAll() {
        logBefore(logger, "批量删除fb");
        if (!Jurisdiction.buttonJurisdiction(menuUrl, "del")) {
            return null;
        }
        PageData pd = null;
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            pd = this.getPageData();
            List<PageData> pdList = new ArrayList<PageData>();
            String DATA_IDS = pd.getString("DATA_IDS");
            if (null != DATA_IDS && !"".equals(DATA_IDS)) {
                String ArrayDATA_IDS[] = DATA_IDS.split(",");
                feedbackService.deleteAll(ArrayDATA_IDS);
                pd.put("msg", "ok");
            } else {
                pd.put("msg", "no");
            }
            pdList.add(pd);
            map.put("list", pdList);
        } catch (Exception e) {
            logger.error(e.toString(), e);
        } finally {
            logAfter(logger);
        }
        return AppUtil.returnObject(pd, map);
    }

    /* ===============================权限================================== */
    public Map<String, String> getHC() {
        Subject currentUser = SecurityUtils.getSubject(); // shiro管理的session
        Session session = currentUser.getSession();
        return (Map<String, String>) session.getAttribute(Const.SESSION_QX);
    }
    /* ===============================权限================================== */
}
