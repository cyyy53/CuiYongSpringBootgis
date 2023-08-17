package com.itcy.postgresql.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @BelongsProject: cyspring
 * @BelongsPackage: com.itcy.postgresql.vo
 * @Author: cuiYong
 * @CreateTime: 2023-08-11  09:43
 * @Description: TODO
 * @Version: 1.0
 */
@Data
@Table(name = "demo")
public class DemoArea {

    @Column(name = "id_0")
    private Integer id0;


    private String geom;

    private String name;

    private Integer id;

    private Long area;
}
