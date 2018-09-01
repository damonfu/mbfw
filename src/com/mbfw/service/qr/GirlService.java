package com.mbfw.service.qr;

import com.mbfw.dao.DaoSupport;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("girlService")
public class GirlService {

    @Resource(name = "daoSupport")
    private DaoSupport dao;

}
