package com.mbfw.service.qr;

import com.mbfw.dao.DaoSupport;
import com.mbfw.entity.qr.Girl;
import com.mbfw.entity.qr.PageLimit;
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
}
