//package com.itcy.postgresql.controller;
//
//import com.itcy.postgresql.model.MapElement;
//import com.itcy.postgresql.service.MapService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @author 176
// */
//@RestController
//@RequestMapping("/postgis/test")
//public class MapController {
//
//    /**
//     * 添加地图元素
//     * @param mapElement
//     * @return 添加的地理元素信息
//     *
//     *
//     */
//    @Autowired
//    private MapService mapService;
//    @PostMapping
//    public MapElement addMapElement(@RequestBody MapElement mapElement){
//        mapElement.setGeoStr(geometryToString(mapElement.getLongitude(), mapElement.getLatitude()));
//        mapService.addMapElement(mapElement);
//        Long id = mapElement.getId();
//        return mapService.findById(id);
//    }
//
//
//    private String geometryToString(double longitude, double latitude){
//        String geoStr = "POINT" + "(" + longitude + " " + latitude + ")";
//        return geoStr;
//    }
//}
