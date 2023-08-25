package com.itcy.postgresql.utlis;

import org.geotools.data.FeatureWriter;
import org.geotools.data.Transaction;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.data.shapefile.ShapefileDataStoreFactory;
import org.geotools.feature.simple.SimpleFeatureTypeBuilder;
import org.geotools.geojson.GeoJSON;
import org.geotools.referencing.CRS;
import org.geotools.referencing.crs.DefaultGeographicCRS;
import org.locationtech.jts.geom.*;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import java.net.URL;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ShapeUtil {

    /**
     * 生成shape文件
     *
     * @param shpPath 生成shape文件路径（包含文件名称）
     * @param encode  编码
     * @param geoType 图幅类型，Point和Rolygon
     * @param geoms   图幅集合
     */
    public static void write2Shape(String shpPath, String encode, String geoType, List<Geometry> geoms) {

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
            tb.setCRS(CRS.decode("EPSG:4528"));

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
            }
            writer.write();

            writer.close();
            ds.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ByteArrayOutputStream writeShape(String shpPath, String encode, String geoType, List<Geometry> geoms) {
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
            tb.setCRS(CRS.decode("EPSG:4528"));

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
    /**
     * 生成shape文件
     *
     * @param shpPath  生成shape文件路径（包含文件名称）
     * @param encode   编码
     * @param geoType  图幅类型，Point和Rolygon
     * @param shpKey   data中图幅的key
     * @param attrKeys 属性key集合
     * @param data     图幅和属性集合
     */
    public static void write2Shape(String shpPath, String encode, String geoType, String shpKey, List<String> attrKeys, List<Map<String, Object>> data) {
        try {
            if (data == null || data.size() == 0) {
                return;
            }
            //创建shape文件对象
            File file = new File(shpPath);
            Map<String, Serializable> params = new HashMap<>();
            params.put(ShapefileDataStoreFactory.URLP.key, file.toURI().toURL());
            ShapefileDataStore ds = (ShapefileDataStore) new ShapefileDataStoreFactory().createNewDataStore(params);

            //定义图形信息和属性信息
            SimpleFeatureTypeBuilder tb = new SimpleFeatureTypeBuilder();
            tb.setCRS(DefaultGeographicCRS.WGS84);
            tb.setName("shapefile");

            if ("Polygon".equals(geoType)) {
                tb.add("the_geom", Polygon.class);
            } else if ("MultiPolygon".equals(geoType)) {
                tb.add("the_geom", MultiPolygon.class);
            } else if ("Point".equals(geoType)) {
                tb.add("the_geom", Point.class);
            } else if ("MultiPoint".equals(geoType)) {
                tb.add("the_geom", MultiPoint.class);
            } else if ("LineString".equals(geoType)) {
                tb.add("the_geom", LineString.class);
            } else if ("MultiLineString".equals(geoType)) {
                tb.add("the_geom", MultiLineString.class);
            } else {
                throw new Exception("Geometry中没有该类型：" + geoType);
            }

            for (String field : attrKeys) {
                tb.add(field.toUpperCase(), String.class);
            }

            ds.createSchema(tb.buildFeatureType());
            //设置编码
            Charset charset = Charset.forName(encode);
            ds.setCharset(charset);
            //设置Writer
            FeatureWriter<SimpleFeatureType, SimpleFeature> writer = ds.getFeatureWriter(ds.getTypeNames()[0], Transaction.AUTO_COMMIT);
            //写入文件信息
            for (int i = 0; i < data.size(); i++) {
                SimpleFeature feature = writer.next();
                Map<String, Object> row = data.get(i);
                Geometry geom = (Geometry) row.get(shpKey);
                feature.setAttribute("the_geom", geom);
                for (String key : row.keySet()) {
                    if (!key.equals(shpKey)) {
                        if (row.get(key) != null) {
                            feature.setAttribute(key.toUpperCase(), row.get(key).toString());
                        } else {
                            feature.setAttribute(key.toUpperCase(), "");
                        }
                    }
                }
            }
            writer.write();
            writer.close();
            ds.dispose();

            //添加到压缩文件
            //zipShapeFile(shpPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 压缩shape文件
     *
     * @param shpPath shape文件路径（包含shape文件名称）
     */
    public static void zipShapeFile(String shpPath) {
        try {
            File shpFile = new File(shpPath);
            String shpRoot = shpFile.getParentFile().getPath();
            String shpName = shpFile.getName().substring(0, shpFile.getName().lastIndexOf("."));

            String zipPath = shpRoot + File.separator + shpName + ".zip";
            File zipFile = new File(zipPath);
            InputStream input = null;
            ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
            // zip的名称为
            zipOut.setComment(shpName);
            String[] shpFiles = new String[]{
                    shpRoot + File.separator + shpName + ".dbf",
                    shpRoot + File.separator + shpName + ".prj",
                    shpRoot + File.separator + shpName + ".shp",
                    shpRoot + File.separator + shpName + ".shx",
                    shpRoot + File.separator + shpName + ".fix"
            };

            for (int i = 0; i < shpFiles.length; i++) {
                File file = new File(shpFiles[i]);
                input = new FileInputStream(file);
                zipOut.putNextEntry(new ZipEntry(file.getName()));
                int temp = 0;
                while ((temp = input.read()) != -1) {
                    zipOut.write(temp);
                }
                input.close();
            }
            zipOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}