package com.itcy.postgresql;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.itcy.postgresql.mapper.DemoMapper;
import com.itcy.postgresql.model.Demo;


import com.itcy.postgresql.utlis.GeometryUtil;
import com.itcy.postgresql.utlis.ShapeUtil;
import com.itcy.postgresql.utlis.WKTUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Polygon;
import org.locationtech.jts.io.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: cyspring
 * @BelongsPackage: com.itcy.postgresql
 * @Author: cuiYong
 * @CreateTime: 2023-08-22  14:18
 * @Description: TODO
 * @Version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class testSpringboot {

    @Autowired
    private DemoMapper demoMapper;


    @Test
    public void test() throws Exception {
     /*   List<String> list = new ArrayList<>();
        String tableName = "demo";
        String field = "name";
        String value = "杭州市";

        String asText = demoMapper.ST_AsText(value);
        list.add(asText);
        System.out.println(asText);

        List<Geometry> geometryList = new ArrayList<>();
        for (String str : list) {
            Geometry geom = GeometryUtil.wktToGeom(str);
            geometryList.add(geom);
        }
        String url = "E:\\sjy\\SHP\\ceshi88889999.shp";
        File file = new File(url);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        ShapeUtil.write2Shape(url, "utf-8", "POLYGON", geometryList);
        ShapeUtil.zipShapeFile(url);
    }*/
    }
}