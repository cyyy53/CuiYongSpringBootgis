//package com.itcy.postgresql.service.impl;
//
//
//import com.itcy.postgresql.mapper.MapElementMapper;
//import com.itcy.postgresql.model.MapElement;
//import com.itcy.postgresql.service.MapService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Map;
//
///**
// * @program: postgresql
// * @description: map服务
// * @author: zgr
// * @create: 2019-07-01 14:39
// **/
//@Service
//public class MapServiceImpl implements MapService {
//
//    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
//    @Autowired
//    private MapElementMapper mapElementMapper;
//
//
//
//
//    @Override
//    public void addMapElement(MapElement mapElement) {
//        mapElementMapper.addMapElement(mapElement);
//    }
//
//    @Override
//    public MapElement findById(Long id) {
//        return mapElementMapper.findById(id);
//    }
//
//
//
//
//}