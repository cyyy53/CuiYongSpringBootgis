package com.itcy.postgresql.vo;

import lombok.Data;

/**
 * @BelongsProject: cyspring
 * @BelongsPackage: com.itcy.postgresql.model
 * @Author: cuiYong
 * @CreateTime: 2023-08-08  09:51
 * @Description: TODO
 * @Version: 1.0
 */
@Data
public class IntersectVO {

    /**与想交区域的名字*/
    private String name;

    /**相交区域的geometry*/
    private String intersectionGeom;


}
