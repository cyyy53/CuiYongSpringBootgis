package com.itcy.postgresql.vo;

import com.bedatadriven.jackson.datatype.jts.GeoJson;
import lombok.Data;

/**
 * @BelongsProject: cyspring
 * @BelongsPackage: com.itcy.postgresql.model
 * @Author: cuiYong
 * @CreateTime: 2023-08-09  14:35
 * @Description: TODO
 * @Version: 1.0
 */
@Data
public class DataInfoVO {

    private Integer id;

    private String tableName;

    private String geoJson;
}
