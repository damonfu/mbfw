package com.mbfw.service.qr;

import com.mbfw.dao.DaoSupport;
import com.mbfw.entity.Page;
import com.mbfw.entity.qr.Girl;
import com.mbfw.entity.qr.PageLimit;
import com.mbfw.util.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("girlService")
public class GirlService {

    @Resource(name = "daoSupport")
    private DaoSupport dao;

    /**
     * 保存
     * @param girl
     * @throws Exception
     */
    public void save(Girl girl) throws Exception {
        dao.save("GirlMapper.insertGril", girl);
    }

    /**
     * 批量保存
     * @param list
     * @throws Exception
     */
    public void saveList(List<Girl> list) throws Exception {
        dao.batchSave("GirlMapper.insertGrils", list);
    }

    /**
     * 分页获取数据
     * @param start
     * @param count
     * @return
     * @throws Exception
     */
    public List<Girl> findByLimitPage(int start, int count) throws Exception {
        return (List<Girl>) dao.findForList("GirlMapper.findByLimitPage", new PageLimit(start, count));
    }

    public List<PageData> list(Page page) throws Exception {
        return (List<PageData>) dao.findForList("GirlMapper.datalistPage", page);
    }

    public PageData findById(PageData pd) throws Exception {
        return (PageData) dao.findForObject("GirlMapper.findById", pd);
    }

    public void edit(PageData pd) throws Exception {
        dao.update("GirlMapper.edit", pd);
    }

    public void save(PageData pd) throws Exception {
        dao.save("GirlMapper.save", pd);
    }

    public void delete(PageData pd) throws Exception {
        dao.delete("GirlMapper.delete", pd);
    }

    public void deleteAll(String[] ids) throws Exception {
        dao.delete("GirlMapper.deleteAll", ids);
    }
}
