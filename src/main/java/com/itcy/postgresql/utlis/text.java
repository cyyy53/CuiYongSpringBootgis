package com.itcy.postgresql.utlis;

import org.geotools.data.FeatureWriter;
import org.geotools.data.Transaction;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.data.shapefile.ShapefileDataStoreFactory;
import org.geotools.feature.simple.SimpleFeatureTypeBuilder;
import org.geotools.geojson.GeoJSON;
import org.geotools.referencing.CRS;
import org.locationtech.jts.geom.*;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: cyspring
 * @BelongsPackage: com.itcy.postgresql.utlis
 * @Author: cuiYong
 * @CreateTime: 2023-08-25  08:33
 * @Description: TODO
 * @Version: 1.0
 */
public class text {

    public static ByteArrayOutputStream write2Shape(String shpPath, String encode, String geoType, List<Geometry> geoms) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            //创建shape文件对象
            File file = new File(shpPath);
            Map<String, Serializable> params = new HashMap<>();
            params.put(ShapefileDataStoreFactory.URLP.key, file.toURI().toURL());
            ShapefileDataStore ds = (ShapefileDataStore) new ShapefileDataStoreFactory().createNewDataStore(params);
            //定义图形信息和属性信息
            SimpleFeatureTypeBuilder tb = new SimpleFeatureTypeBuilder();
            /**
             *  //方式一
             *	CRS.decode("EPSG:4326");
             *  //方式二
             *	DefaultGeographicCRS.WGS84;
             *
             *  EPSG:4490为大地坐标系_国家2000大地坐标系CGCS2000
             *  EPSG:4326支持一种默认的定义方式, 坐标系WGS84
             */
            tb.setCRS(CRS.decode("EPSG:4326"));

            tb.setName("shapefile");

            if ("Polygon".equals(geoType) || "polygon".equals(geoType)) {
                tb.add("the_geom", Polygon.class);
            } else if ("MultiPolygon".equals(geoType)) {
                tb.add("the_geom", MultiPolygon.class);
            } else if ("Point".equals(geoType) || "point".equals(geoType)) {
                tb.add("the_geom", Point.class);
            } else if ("MultiPoint".equals(geoType)) {
                tb.add("the_geom", MultiPoint.class);
            } else if ("LineString".equals(geoType)) {
                tb.add("the_geom", LineString.class);
            } else if ("MultiLineString".equals(geoType) || "Polyline".equals(geoType) || "polyline".equals(geoType)) {
                tb.add("the_geom", MultiLineString.class);
            } else {
                throw new Exception("Geometry中没有该类型：" + geoType);
            }

            ds.createSchema(tb.buildFeatureType());
            //设置编码
            Charset charset = Charset.forName(encode);
            ds.setCharset(charset);
            //设置Writer

            FeatureWriter<SimpleFeatureType, SimpleFeature> writer = ds.getFeatureWriter(ds.getTypeNames()[0], Transaction.AUTO_COMMIT);
            for (Geometry geom : geoms) {
                //String type = geom.getGeometryType();

                //写下一条
                SimpleFeature feature = writer.next();

                feature.setAttribute("the_geom", geom);

                GeoJSON.write(feature,outputStream);
            }
            writer.write();

            writer.close();

            ds.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return outputStream;
    }

}
