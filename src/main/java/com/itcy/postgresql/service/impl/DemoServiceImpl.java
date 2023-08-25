package com.itcy.postgresql.service.impl;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.api.R;
import com.itcy.postgresql.common.Result;
import com.itcy.postgresql.dto.IntersectsZIPDTO;
import com.itcy.postgresql.dto.ZIPDTO;
import com.itcy.postgresql.mapper.DemoMapper;
import com.itcy.postgresql.model.Demo;
import com.itcy.postgresql.service.DemoService;
import com.itcy.postgresql.utlis.GeometryUtil;
import com.itcy.postgresql.utlis.ShapeUtil;
import com.itcy.postgresql.utlis.text;
import com.itcy.postgresql.vo.DataInfoVO;
import com.itcy.postgresql.vo.IntersectVO;
import org.locationtech.jts.geom.Geometry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author 176
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoMapper demoMapper;


    @Override
    public List<Demo> getByGeom(String geom) {
        return demoMapper.getByGeom(geom);
    }


    @Override
    public List<Demo> getByGeoJson(String geoJson) {
        return demoMapper.getByGeoJson(geoJson);
    }


    @Override
    public List<IntersectVO> getIntersect(String geoJson) {
        return demoMapper.getIntersect(geoJson);
    }


    /**
     * @description:
     * @author: cuiYong
     * @date: 2023/8/9 15:01
     * @param: [tableName, geoJson]
     * @return: com.itcy.postgresql.model.MapElement
     * 插入geoJson数据
     **/
    @Transactional
    @Override
    public Result insertGeoJson(String insertGeoJson) {

        DataInfoVO dataInfoVO = JSON.parseObject(insertGeoJson, DataInfoVO.class);
        Integer num = demoMapper.insertGeoJson(dataInfoVO);
        Integer id = dataInfoVO.getId();
        System.out.println(id);
        if (num > 0) {
            return Result.success(id);
        }
        return Result.fail(500, "插入失敗");


    }

    @Override
    public Result getFieldProperty(String tableName, String field, String value) {
        Demo result = demoMapper.getFieldProperty(tableName, field, value);
        System.out.println("result===>" + result);
        return Result.success(demoMapper.getFieldProperty(tableName, field, value));
    }

    /**
     * @description:
     * @author: cuiYong
     * @date: 2023/8/21 9:05
     * @param: [name]
     * @return: com.itcy.postgresql.common.Result
     * 计算面积
     **/
    @Override
    public Result getArea(String name) {


        return Result.success(demoMapper.getArea(name));
    }

    /**
     * @description:
     * @author: cuiYong
     * @date: 2023/8/21 9:05
     * @param: [geoJson]
     * @return: com.itcy.postgresql.common.Result
     * 获取相交区域的面积
     **/
    @Override
    public Result getIntersectArea(String geoJson) {
        return Result.success(demoMapper.getIntersectArea(geoJson));
    }

    /**
     * @description:
     * @author: cuiYong
     * @date: 2023/8/21 9:06
     * @param: [name]
     * @return: com.itcy.postgresql.common.Result
     * 计算测底线3D面积
     **/
    @Override
    public Result get3DArea(String name) {
        return Result.success(demoMapper.get3DArea(name));
    }

    @Override
    public Result getIntersectsZIP(String fileProperty) throws Exception {

        IntersectsZIPDTO zipDto = JSON.parseObject(fileProperty, IntersectsZIPDTO.class);
        List<IntersectVO> result = demoMapper.getIntersectsZIP(zipDto);
        System.out.println("======" + result.toString());
        System.out.println(result);
        if (result == null || result.size() == 0) {

            return Result.fail(500, "没有相交");
        }

        //获取getIntersectionGeom的值
        List<String> list = result.stream().map(IntersectVO::getIntersectionGeom)
                //奖结果收集到list中
                .collect(Collectors.toList());


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

        ShapeUtil.write2Shape(url, "utf-8", "Polygon", geometryList);
        ShapeUtil.zipShapeFile(url);


        ByteArrayOutputStream polygon = ShapeUtil.writeShape(url, "utf-8", "Polygon", geometryList);
        System.out.println("======>" + polygon);
        ZIPDTO zipdto = JSON.parseObject(String.valueOf(polygon), ZIPDTO.class);
        String rs = zipdto.getGeometry();
        System.out.println("geometry====>" + zipdto.getGeometry());
        return Result.success(rs);
    }


}
