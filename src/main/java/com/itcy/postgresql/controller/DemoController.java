package com.itcy.postgresql.controller;

import com.itcy.postgresql.common.Result;

import com.itcy.postgresql.service.DemoService;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



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
@Api(tags = "鄞州规划设计院demo接口")
public class DemoController {

    @Autowired
    private DemoService demoService;


    /**
     * 传入geometry数据查询位置相交关系
     */
    @ApiOperation("传入geometry数据查询位置相交情况接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "geom", value = "几何对象", required = true),

    })
    @GetMapping("/getByGeom")
    public Result getByGeom(@RequestParam String geom) {
        return Result.success(demoService.getByGeom(geom));
    }

    /**
     * 传入geojson数据类型查询相交情况
     */
    @ApiOperation("传入geoJson数据查询位置相交情况接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "geoJson", value = "geoJson数据", required = true),

    })
    @PostMapping("/getByGeoJson")
    public Result getByGeoJson(@RequestBody String geoJson) {
        return Result.success(demoService.getByGeoJson(geoJson));
    }

    @ApiOperation("传入geoJson查询数据库,返回与该数据相交每一块的数据接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "geoJson", value = "geoJson数据", required = true),
    })
    @PostMapping("/getIntersect")
    public Result getIntersect(@RequestBody String geoJson) {
        return Result.success(demoService.getIntersect(geoJson));
    }

    @ApiOperation("向数据库插入geoJson和tableName数据接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "insertGeoJson", value = "插入的数据", required = true),
    })
    @PostMapping("/insertGeoJson")
    public Result insertGeoJson(@RequestBody String insertGeoJson) {
        return demoService.insertGeoJson(insertGeoJson);
    }




    @ApiOperation("通过名字查询接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tableName", value = "表名", required = true),
            @ApiImplicitParam(name = "field", value = "列名", required = true),
            @ApiImplicitParam(name = "value", value = "值", required = true),

    })
    @GetMapping("/getFieldProperty")
    public Result getFieldProperty(@RequestParam("tableName") String tableName,
                                   @RequestParam("field") String field,
                                   @RequestParam("value") String value) {


        return demoService.getFieldProperty(tableName, field, value);
    }

    @ApiOperation("计算投影面面积接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "名字", required = true),
    })
    @GetMapping("/getArea")
    public Result getArea(@RequestParam("name") String name) {
        return demoService.getArea(name);
    }

    @ApiOperation("计算3D面积接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "名字", required = true),
    })
    @GetMapping("/get3DArea")
    public Result get3DArea(@RequestParam("name") String name) {
        return demoService.get3DArea(name);
    }

    @ApiOperation("计算相交部分的面积接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "geoJson", value = "geoJson数据", required = true),
    })
    @GetMapping("/getIntersectArea")
    public Result getIntersectArea(@RequestBody String geoJson) {
        return demoService.getIntersectArea(geoJson);
    }

    @ApiOperation("将相交区域或合并区域打包成shp文件并压缩接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "fileProperty", value = "文件数据", required = true),
    })
    @PostMapping("getIntersectsZIP")
    public Result getIntersectsZIP(@RequestBody String fileProperty) throws Exception {
        return demoService.getIntersectsZIP(fileProperty);
    }
}
