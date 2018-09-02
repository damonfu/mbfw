package com.mbfw.service.qr;

import com.mbfw.dao.DaoSupport;
import com.mbfw.entity.qr.PageLimit;
import com.mbfw.entity.qr.QrcodeImg;
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
     * 保存
     * @param qrcodeImg
     * @throws Exception
     */
    public void saveQrcodeImg(QrcodeImg qrcodeImg) throws Exception {
        dao.save("QrcodeMapper.insertQrcode", qrcodeImg);
    }

    /**
     * 更新
     * @param qrcodeImg
     * @throws Exception
     */
    public void updateQrcodeImg(QrcodeImg qrcodeImg) throws Exception {
        dao.update("QrcodeMapper.updateQrcode", qrcodeImg);
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
}
