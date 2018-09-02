package com.mbfw.controller.qr;

import com.mbfw.controller.base.BaseController;
import com.mbfw.entity.Page;
import com.mbfw.entity.qr.PageLimit;
import com.mbfw.entity.qr.QrcodeImg;
import com.mbfw.entity.qr.QrcodeImgResult;
import com.mbfw.service.qr.QrcodeImgService;
import com.mbfw.util.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.PrintWriter;
import java.util.*;

@Controller
@RequestMapping(value = "/qrman")
public class QrcodeImgManagerController extends BaseController {

    String menuUrl = "qrman/list.do";

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

    @RequestMapping(value = "/list")
    public ModelAndView list(Page page) {
        logBefore(logger, "列表Qrcodeimg");
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
            List<PageData> varList = qrcodeImgService.list(page); // 列出temple列表
            mv.setViewName("qrcode/temple/qrcode_list");
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
        logBefore(logger, "去修改qrcodeimg页面");
        ModelAndView mv = this.getModelAndView();
        PageData pd = new PageData();
        pd = this.getPageData();
        try {
            pd = qrcodeImgService.findById(pd); // 根据ID读取
            mv.setViewName("qrcode/temple/qrcode_edit");
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
        logBefore(logger, "修改qrcodeimg");
        if (!Jurisdiction.buttonJurisdiction(menuUrl, "edit")) {
            return null;
        }
        ModelAndView mv = this.getModelAndView();
        PageData pd = this.getPageData();
        qrcodeImgService.edit(pd);
        mv.addObject("msg", "success");
        mv.setViewName("save_result");
        return mv;
    }

    /**
     * 去新增页面
     */
    @RequestMapping(value = "/goAdd")
    public ModelAndView goAdd() {
        logBefore(logger, "去新增qrimg页面");
        ModelAndView mv = this.getModelAndView();
        PageData pd = new PageData();
        pd = this.getPageData();
        try {
            mv.setViewName("qrcode/temple/qrcode_edit");
            mv.addObject("msg", "save");
            pd.put("x", 0);
            pd.put("y", 0);
            pd.put("rotate", 0);
            pd.put("framesize", 0);
            pd.put("frameoutsize", 0);
            pd.put("frameinsize", 0);
            pd.put("size", 400);
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
        logBefore(logger, "新增qrimg");
        if (!Jurisdiction.buttonJurisdiction(menuUrl, "add")) {
            return null;
        } // 校验权限
        ModelAndView mv = this.getModelAndView();
        PageData pd = new PageData();
        pd = this.getPageData();
        qrcodeImgService.save(pd);
        mv.addObject("msg", "success");
        mv.setViewName("save_result");
        return mv;
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete")
    public void delete(PrintWriter out) {
        logBefore(logger, "删除qrimg");
        if (!Jurisdiction.buttonJurisdiction(menuUrl, "del")) {
            return;
        }
        PageData pd = new PageData();
        try {
            pd = this.getPageData();
            qrcodeImgService.delete(pd);
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
        logBefore(logger, "批量删除qrcodeimg");
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
                qrcodeImgService.deleteAll(ArrayDATA_IDS);
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
