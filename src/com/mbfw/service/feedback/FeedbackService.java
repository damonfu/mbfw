package com.mbfw.service.feedback;

import com.mbfw.dao.DaoSupport;
import com.mbfw.entity.Page;
import com.mbfw.entity.feedback.FeedbackBean;
import com.mbfw.util.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("feedbackService")
public class FeedbackService {

    @Resource(name = "daoSupport")
    private DaoSupport dao;

    /**
     * 保存
     * @param bean
     * @throws Exception
     */
    public void save(FeedbackBean bean) throws Exception {
        dao.save("FeedbackMapper.insertFeedback", bean);
    }

    public List<PageData> list(Page page) throws Exception {
        return (List<PageData>) dao.findForList("FeedbackMapper.datalistPage", page);
    }

    public PageData findById(PageData pd) throws Exception {
        return (PageData) dao.findForObject("FeedbackMapper.findById", pd);
    }

    public void edit(PageData pd) throws Exception {
        dao.update("FeedbackMapper.edit", pd);
    }

    public void save(PageData pd) throws Exception {
        dao.save("FeedbackMapper.save", pd);
    }

    public void delete(PageData pd) throws Exception {
        dao.delete("FeedbackMapper.delete", pd);
    }

    public void deleteAll(String[] ids) throws Exception {
        dao.delete("FeedbackMapper.deleteAll", ids);
    }
}
