package com.itcy.postgresql.model;
 

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.persistence.Table;


/**
 * @program: postgresql
 * @author: zgr
 * @create: 2019-07-01 14:35
 **/
@Data
@Table(name = "map_element")
public class MapElement {
    
    /**
     * 数据库自增主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
 

    private String[] geom;


}