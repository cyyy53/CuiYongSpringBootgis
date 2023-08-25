package com.itcy.postgresql.model;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;


/**
 * @author 176
 */
@Data
@ApiModel("地理信息表")
@AllArgsConstructor
@NoArgsConstructor
//@TableName("autoResultMap = true")
public class Demo {

    @ApiModelProperty("主键")
    @Column(name = "id_0")
    private Integer id0;

    @ApiModelProperty("geometry地理数据")
    private String geom;

    @ApiModelProperty("名字")
    private String name;
    @ApiModelProperty("id")
    @TableField(value = "id")
    private Integer id;

}

