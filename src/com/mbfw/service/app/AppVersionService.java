package com.mbfw.service.app;

import com.mbfw.dao.DaoSupport;
import com.mbfw.entity.Page;
import com.mbfw.entity.app.AppVersionBean;
import com.mbfw.entity.app.AppVersionRequest;
import com.mbfw.util.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("appVersionService")
public class AppVersionService {

    @Resource(name = "daoSupport")
    private DaoSupport dao;

    public List<PageData> list(Page page) throws Exception {
        return (List<PageData>) dao.findForList("AppVersionMapper.datalistPage", page);
    }

    public PageData findById(PageData pd) throws Exception {
        return (PageData) dao.findForObject("AppVersionMapper.findById", pd);
    }

    public void edit(PageData pd) throws Exception {
        dao.update("AppVersionMapper.edit", pd);
    }

    public void save(PageData pd) throws Exception {
        dao.save("AppVersionMapper.save", pd);
    }

    public void delete(PageData pd) throws Exception {
        dao.delete("AppVersionMapper.delete", pd);
    }

    public void deleteAll(String[] ids) throws Exception {
        dao.delete("AppVersionMapper.deleteAll", ids);
    }

    public AppVersionBean findLasteByPack(AppVersionRequest request) throws Exception{
        PageData pd = new PageData();
        pd.put("packageName", request.getPackageName());
        pd.put("versionCode", request.getVersionCode());
        return (AppVersionBean) dao.findForObject("AppVersionMapper.findLaste", pd);
    }
}
