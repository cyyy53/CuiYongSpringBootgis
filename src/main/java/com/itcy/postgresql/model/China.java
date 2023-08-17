package com.itcy.postgresql.model;

import lombok.Data;

import org.postgis.Geometry;
import org.postgis.MultiPolygon;

import javax.persistence.Column;


/**
 * @author 176
 */
@Data
public class China {
    @Column(name = "id")
    private String id;
    @Column(name = "geom")
    private Geometry geom;
    @Column(name = "area")
    private Double area;
    @Column(name = "perimeter")
    private Double perimeter;
    @Column(name = "province")
    private Long province;
    @Column(name = "name")
    private String name;
    @Column(name = "ename")
    private String eName;
    @Column(name = "gb1999")
    private Long gb1999;
    @Column(name = "towns")
    private Double towns;
    @Column(name = "community")
    private Double community;
    @Column(name = "families")
    private Double families;
    @Column(name = "fam_cou")
    private Double famCou;
    @Column(name = "popu")
    private Long poPu;
    @Column(name = "pop_cou")
    private Double popCou;
    @Column(name = "pop_work")
    private Double popWork;
    @Column(name = "pop_clab")
    private Double popClab;
    @Column(name = "pop_agri")
    private Double popAgri;
    @Column(name = "power_agri")
    private Double powerAgri;
    @Column(name = "fam_tel")
    private Double famTel;
    @Column(name = "product")
    private Double product;
    @Column(name = "product_1")
    private Double product1;
    @Column(name = "product_2")
    private Double product2;
    @Column(name = "finaincome")
    private Double finaincome;
    @Column(name = "finaout")
    private Double finaout;
    @Column(name = "deposits")
    private Double deposits;
    @Column(name = "bank")
    private Double bank;
    @Column(name = "corpproduc")
    private Double corpproduc;
    @Column(name = "cottonprod")
    private Double cottonprod;
    @Column(name = "oilproduct")
    private Double oilproduct;
    @Column(name = "metaproduc")
    private Double metaproduc;
    @Column(name = "firms")
    private Double firms;
    @Column(name = "firms_prod")
    private Double firmsProd;
    @Column(name = "facilitiy")
    private Double facilitiy;
    @Column(name = "junior")
    private Double junior;
    @Column(name = "elementery")
    private Double elementery;
    @Column(name = "popu_per_l")
    private Double popuPerl;
    @Column(name = "bed")
    private Double bed;
    @Column(name = "finainco_1")
    private Double finainco1;
    @Column(name = "social")
    private Double social;
    @Column(name = "popu_94")
    private Long popu94;
    @Column(name = "social_bed")
    private Double socialBed;
    @Column(name = "finaout_94")
    private Long finaout94;
    @Column(name = "page")
    private Double page;
    @Column(name = "stu_per_po")
    private Double stuPerPo;
    @Column(name = "popu10000")
    private Long popu10000;
    @Column(name = "induproduc")
    private Long induproduc;
    @Column(name = "popuPer_1")
    private Double popuPer1;
    @Column(name = "lightprodu")
    private Long lightprodu;
    @Column(name = "popucou_pe")
    private Double popucouPe;
    @Column(name = "stuPer1")
    private Double stuPer1;
    @Column(name = "popwork_pe")
    private Double popworkPe;
    @Column(name = "tel_per_fa")
    private Double telPerFa;
    @Column(name = "post_")
    private Long post;
}
