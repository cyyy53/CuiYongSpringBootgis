package com.itcy.postgresql.utlis;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.geotools.geojson.geom.GeometryJSON;
import org.geotools.geometry.jts.JTSFactoryFinder;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.io.WKTReader;
import org.locationtech.jts.io.WKTWriter;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class GeometryUtil {

    /**
     * geometry转geojson
     * @param geometry
     * @return JSONObject
     * @throws IOException
     */
    public static JSONObject toGeoJson(Geometry geometry) {
        try {
            StringWriter sw = new StringWriter();
            // 设置保留6位小数，否则GeometryJSON默认保留4位小数
            GeometryJSON geometryJson = new GeometryJSON(6);
            geometryJson.write(geometry, sw);
            JSONObject geoJson = JSONObject.parseObject(sw.toString());
            sw.close();
            return geoJson;
        }catch(IOException ex){
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * geojson转geometry
     * @param geojson
     * @return Geometry
     */
    public static Geometry toGeometry(JSONObject geojson){
        Geometry geometry = null;
        try {
            GeometryJSON geometryJson = new GeometryJSON(6);
            String jsonStr = JSONObject.toJSONString(geojson);
            StringReader sr = new StringReader(jsonStr);
            geometry = geometryJson.read(sr);
            sr.close();
            return geometry;
        }catch(IOException ex){
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * 字符串转对象
     * @param wktGeometry
     * @return Geometry
     */
    public static Geometry toGeometry(String wktGeometry){
        try {
            GeometryFactory geometryFactory = JTSFactoryFinder.getGeometryFactory(null);
            WKTReader reader = new WKTReader(geometryFactory);
            Geometry geometry = reader.read(wktGeometry);
            return geometry;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public static List<String> arrayListToWktPoint(JSONArray points){
        List<String> strings = new ArrayList<>();
        for (int i=0;i<points.size();i++){
            String result = points.getString(i);
            result = result.substring(0,result.lastIndexOf(",")-1);
            result =  "MULTIPOINT"+result.replace("[","(").replace(","," ")+")";
            strings.add(result);
        }
        return strings;
    }

    public static List<String> arrayListToWktLine(JSONArray lines){
        List<String> strings = new ArrayList<>();
        for (int i=0;i<lines.size();i++){
            String result = lines.getString(i);
            result =  "MULTILINESTRING"+result.replace(","," ").replace(" 0.0] [",",").replace(" 0.0]","]").replace("[","(").replace("]",")");
            strings.add(result);
        }
        return strings;
    }

    public static String shapeToWktPolygon(JSONObject shape){
        String geom = "";
        JSONArray coordinates = shape.getJSONObject("geometry").getJSONArray("coordinates");
        for (int i=0;i<coordinates.size();i++){
            JSONArray zbc = coordinates.getJSONArray(i).getJSONArray(0);
            String zbcstr = "";
            for (int j=0;j<zbc.size();j++){
                JSONArray xy = zbc.getJSONArray(j);
                for (int k=0;k<xy.size();k++){
                    if (k==0){
                        zbcstr += xy.getString(k)+" ";
                    }else if (k==1){
                        zbcstr += xy.getString(k)+",";
                    }
                }
            }
            geom ="MULTIPOLYGON((("+zbcstr.substring(0,zbcstr.lastIndexOf(","))+")))";
        }
        return geom;
    }

    public static String geomToWkt(Geometry geometry) {
        String wkt = null;
        WKTWriter writer = new WKTWriter();
        wkt = writer.write(geometry);
        return wkt;
    }

    public static Geometry wktToGeom(String wkt) throws Exception {
        Geometry geometry = null;
        WKTReader reader = new WKTReader();
        geometry = reader.read(wkt);
        return geometry;
    }


}