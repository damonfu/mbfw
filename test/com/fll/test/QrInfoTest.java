package com.fll.test;

import com.mbfw.entity.qr.Girl;
import com.mbfw.entity.qr.GirlResult;
import com.mbfw.service.qr.GirlService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/spring/ApplicationContext.xml")
public class QrInfoTest {

    @Resource
    GirlService girlService;

    @Test
    public void testInsertDataList() {
        String json = readFile();
        System.out.println(json);
        List<Girl> girls = json2List(json, Girl.class);
        System.out.println("size = "+girls.size());
        try {
            girlService.saveList(girls);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLimit() throws Exception {
        List<Girl> girls = girlService.findByLimitPage(0, 10);
        System.out.println("size = "+girls.size());
    }


    public static <T> List<T> json2List(String jsonStr, Class<T> objectClass) {
        if (StringUtils.isNotBlank(jsonStr)) {
            JSONArray jsonArray = JSONArray.fromObject(jsonStr);
            List<T> list = (List<T>) JSONArray.toCollection(jsonArray, objectClass);
            return list;
        }
        return null;
    }

    public String readFile() {
        // 需要读取的文件，参数是文件的路径名加文件名
        File file = new File("obj.json");
        if (file.isFile()) {
            // 以字节流方法读取文件
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(file);
                // 设置一个，每次 装载信息的容器
                byte[] buf = new byte[1024];
                // 定义一个StringBuffer用来存放字符串
                StringBuffer sb = new StringBuffer();
                // 开始读取数据
                int len = 0;// 每次读取到的数据的长度
                while ((len = fis.read(buf)) != -1) {// len值为-1时，表示没有数据了
                    // append方法往sb对象里面添加数据
                    sb.append(new String(buf, 0, len, "utf-8"));
                }
                // 输出字符串
                return sb.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("文件不存在！");
        }
        return "";
    }
}
