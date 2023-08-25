package com.itcy.postgresql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @BelongsProject: cyspring
 * @BelongsPackage: com.itcy.postgresql.dto
 * @Author: cuiYong
 * @CreateTime: 2023-08-25  09:09
 * @Description: TODO
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ZIPDTO {

    private String type;

    private String properties;

    private String id;

    private String geometry;

}
