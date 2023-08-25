package com.itcy.postgresql.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itcy.postgresql.dto.IntersectsZIPDTO;
import com.itcy.postgresql.model.Demo;
import com.itcy.postgresql.vo.DataInfoVO;
import com.itcy.postgresql.vo.DemoArea;
import com.itcy.postgresql.vo.IntersectVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 176
 */
@Mapper
public interface DemoMapper extends BaseMapper<Demo> {



    Demo findGeoJsonById(Integer id,String name);

    Object getST_AsGeoJSON(String name);

    List<Demo> getByGeom(String geom);

    List<Demo> getByGeoJson(String geoJson);

    List<IntersectVO> getIntersect(String geoJson);

    Integer insertGeoJson(DataInfoVO dataInfoVO);

    Demo getFieldProperty( String tableName,String field, String value);

    DemoArea getArea(String name);

    List<DemoArea> getIntersectArea(String geoJson);

    DemoArea get3DArea(String name);

    List<IntersectVO > getIntersectsZIP(IntersectsZIPDTO zipDto);

    /*List<IntersectVO> getAllZIP(IntersectsZIPDTO zipDto);*/
}
