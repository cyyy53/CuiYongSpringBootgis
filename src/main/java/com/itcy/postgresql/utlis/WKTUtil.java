package com.itcy.postgresql.utlis;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.locationtech.jts.io.WKTWriter;

/**
 * wktutil
 *
 * @author tree
 * @date 2022/01/21
 */
public class WKTUtil {


    public static String geomToWkt(Geometry geometry) {
        WKTWriter writer = new WKTWriter();
        return writer.write(geometry);
    }

    public static Geometry wktToGeom(String wkt) throws ParseException {
        Geometry geometry = null;
        WKTReader reader = new WKTReader();
        geometry = reader.read(wkt);
        return geometry;
    }

}
