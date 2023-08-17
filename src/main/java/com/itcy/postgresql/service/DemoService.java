package com.itcy.postgresql.service;


import com.itcy.postgresql.common.Result;
import com.itcy.postgresql.model.Demo;
import com.itcy.postgresql.vo.IntersectVO;

import java.util.List;

/**
 * @author 176
 */
public interface DemoService {

/*
    List<China> findIntersectingEntities(Geometry geometry);

    List<China> findAll();

    boolean checkIntersect(Long id1, Long id2);
*/


    /**
     * 传入geometry数据查询位置相交关系*/
    List<Demo> getByGeom(String geom);

    /**
     * 传入geojson数据类型查询相交情况*/
    List<Demo> getByGeoJson(String geoJson);

    /**
     * @description:
     * @author: cuiYong
     * @date: 2023/8/11 10:07
     * @param: [geoJson]
     * @return: java.util.List<com.itcy.postgresql.vo.IntersectVO>
     *     查出相交数据
     **/
    List<IntersectVO> getIntersect(String geoJson);

    /**
     * @description:
     * @author: cuiYong
     * @date: 2023/8/9 15:01
     * @param: [tableName, geoJson]
     * @return: com.itcy.postgresql.model.MapElement
     **/
    Result insertGeoJson(String  insertGeoJson);

    Result getFieldProperty(String tableName, String field, String value);

    Result getArea(String name);

    Result getIntersectArea(String geoJson);

    Result get3DArea(String name);
}
