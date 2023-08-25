package com.itcy.postgresql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @BelongsProject: cyspring
 * @BelongsPackage: com.itcy.postgresql.dto
 * @Author: cuiYong
 * @CreateTime: 2023-08-24  10:02
 * @Description: TODO
 * @Version: 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class IntersectsZIPDTO {

//   geoJson字段
    private String geoJson;

    //表名字
    private String tableName;

    //列名字
    private String field;

    //列值
   List<String> values;



}
