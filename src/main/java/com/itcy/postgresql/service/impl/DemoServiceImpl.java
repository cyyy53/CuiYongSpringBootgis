package com.itcy.postgresql.service.impl;


import com.alibaba.fastjson.JSON;
import com.itcy.postgresql.common.Result;
import com.itcy.postgresql.mapper.DemoMapper;
import com.itcy.postgresql.model.Demo;
import com.itcy.postgresql.service.DemoService;
import com.itcy.postgresql.vo.DataInfoVO;
import com.itcy.postgresql.vo.IntersectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 176
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoMapper demoMapper;

  /**  @Override
    public List<China> findIntersectingEntities( Geometry geometry) {
        return demoMapper.findIntersectingEntities(geometry);
    }

    @Override
    public List<China> findAll() {
        return demoMapper.findAll();
    }

    @Override
    public boolean checkIntersect(Long id1, Long id2) {
        return demoMapper.checkIntersect(id1,id2);
    }
*/
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

    @Transactional
    @Override
    public Result insertGeoJson(String insertGeoJson) {

        DataInfoVO dataInfoVO = JSON.parseObject(insertGeoJson, DataInfoVO.class);
        Integer num = demoMapper.insertGeoJson(dataInfoVO);
        Integer id = dataInfoVO.getId();
        System.out.println(id);
        if (num >0){
            return Result.success(id);
        }
        return Result.fail(500,"插入失敗");


    }

    @Override
    public Result getFieldProperty(String tableName, String field, String value) {

      return Result.success( demoMapper.getFieldProperty(tableName, field, value)) ;
    }

    @Override
    public Result getArea(String name) {


        return Result.success(demoMapper.getArea(name));
    }

    @Override
    public Result getIntersectArea(String geoJson) {
        return Result.success(demoMapper.getIntersectArea(geoJson));
    }

    @Override
    public Result get3DArea(String name) {
        return Result.success(demoMapper.get3DArea(name));
    }
}
