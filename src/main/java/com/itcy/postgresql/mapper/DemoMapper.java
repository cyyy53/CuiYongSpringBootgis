package com.itcy.postgresql.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.itcy.postgresql.common.Result;
import com.itcy.postgresql.model.China;
import com.itcy.postgresql.model.Demo;
import com.itcy.postgresql.vo.DataInfoVO;
import com.itcy.postgresql.vo.DemoArea;
import com.itcy.postgresql.vo.IntersectVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.locationtech.jts.geom.Geometry;

import java.util.List;

@Mapper
public interface DemoMapper extends BaseMapper<China> {
    @Select("SELECT * FROM china WHERE geometry = #{geometry}")
    List<China> findIntersectingEntities(@Param("geometry") Geometry geometry);


    List<China> findAll();

    boolean checkIntersect(Long id1, Long id2);

    List<Demo> getByGeom(String geom);

    List<Demo> getByGeoJson(String geoJson);

    List<IntersectVO> getIntersect(String geoJson);

    Integer insertGeoJson(DataInfoVO dataInfoVO);

    Object getFieldProperty( String tableName,String field, String value);

    DemoArea getArea(String name);

    List<DemoArea> getIntersectArea(String geoJson);

    DemoArea get3DArea(String name);
}
