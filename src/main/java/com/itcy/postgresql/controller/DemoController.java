package com.itcy.postgresql.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.itcy.postgresql.common.Result;
import com.itcy.postgresql.model.Demo;
import com.itcy.postgresql.service.DemoService;
import com.itcy.postgresql.vo.DataInfoVO;
import com.itcy.postgresql.vo.IntersectVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @BelongsProject: cyspring
 * @BelongsPackage: com.itcy.postgresql.controller
 * @Author: cuiYong
 * @CreateTime: 2023-08-07  09:25
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    /**
     * 传入geometry数据查询位置相交关系*/
    @GetMapping("/getByGeom")
    public Result getByGeom(@RequestParam String  geom){
        return Result.success(demoService.getByGeom(geom));
    }
    /**
     * 传入geojson数据类型查询相交情况*/
    @PostMapping("/getByGeoJson")
    public Result getByGeoJson(@RequestBody String geoJson){
        return Result.success(demoService.getByGeoJson(geoJson)) ;
    }

    @PostMapping("/getIntersect")
    public Result getIntersect(@RequestBody String geoJson){
        return Result.success(demoService.getIntersect(geoJson));
    }


    @PostMapping("/insertGeoJson")
    public Result insertGeoJson(@RequestBody String insertGeoJson){
        return demoService.insertGeoJson(insertGeoJson);
    }


    @GetMapping("/getFieldProperty")
    public Result getFieldProperty(@RequestParam("tableName") String tableName,@RequestParam("field") String field,@RequestParam("value") String value){


        return  demoService.getFieldProperty(tableName,field,value);
    }

    @GetMapping("/getArea")
    public Result getArea(@RequestParam("name") String name){
        return demoService.getArea(name);
    }

    @GetMapping("/get3DArea")
    public Result get3DArea(@RequestParam("name") String name){
        return demoService.get3DArea(name);
    }

    @GetMapping("/getIntersectArea")
    public Result getIntersectArea(@RequestBody String geoJson){
        return demoService.getIntersectArea(geoJson);
    }



  /**  @GetMapping("/test")
    public List<China> findIntersectingEntities(@RequestParam("geometry") Geometry geometry)throws ParseException{
//        List<China> chinaList = demoService.findIntersectingEntities(geometryWKT);
//        return "查询成功";

        return demoService.findIntersectingEntities(geometry);
    }

    @GetMapping("/list")
    public List<China> findAll(){
        return demoService.findAll();
    }

    @GetMapping("/check")
    public boolean checkIntersect(@RequestParam("id1") Long id1, @RequestParam("id2") Long id2) {
        return demoService.checkIntersect(id1, id2);
    }*/

}
