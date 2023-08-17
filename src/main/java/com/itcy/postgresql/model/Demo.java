package com.itcy.postgresql.model;

import lombok.Data;
import org.postgis.Geometry;

import javax.persistence.Column;

/**
 * @author 176
 */
@Data
public class Demo {

    @Column(name = "id_0")
    private Integer id0;

    private Geometry geom;

    private String name;

    private Integer id;

}

