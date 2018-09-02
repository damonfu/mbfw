package com.mbfw.service.qr;

import com.mbfw.dao.DaoSupport;
import com.mbfw.entity.Page;
import com.mbfw.entity.qr.PageLimit;
import com.mbfw.entity.qr.QrcodeImg;
import com.mbfw.util.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "qrcodeImgService")
public class QrcodeImgService {

    @Resource(name = "daoSupport")
    private DaoSupport dao;

    /**
     * 分类查找
     * @param pageLimit
     * @return
     * @throws Exception
     */
    public List<QrcodeImg> findByLimitPage(PageLimit pageLimit) throws Exception {
        return (List<QrcodeImg>) dao.findForList("QrcodeMapper.findByLimitPage", pageLimit);
    }

    /**
     * 查找所有
     * @param pageLimit
     * @return
     * @throws Exception
     */
    public List<QrcodeImg> findAllByLimitPage(PageLimit pageLimit) throws Exception {
        return (List<QrcodeImg>) dao.findForList("QrcodeMapper.findAllByLimitPage", pageLimit);
    }

    /**
     * 删除
     * @param _id
     * @throws Exception
     */
    public void deleteQrcodeImg(int _id) throws Exception {
        dao.delete("QrcodeMapper.deleteQrcode", _id);
    }

    public List<PageData> list(Page page) throws Exception {
        return (List<PageData>) dao.findForList("QrcodeMapper.datalistPage", page);
    }

    public void save(PageData pd) throws Exception {
        dao.save("QrcodeMapper.save", pd);
    }
}
