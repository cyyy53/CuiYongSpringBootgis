package com.itcy.postgresql.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@ApiModel("返回结果")
public class Result {
    @ApiModelProperty("返回成功")
    private boolean success;
    @ApiModelProperty("编码")
    private int code;
    @ApiModelProperty("错误信息")
    private String msg;
    @ApiModelProperty("数据")
    private Object data;

    @ApiModelProperty("成功方法")
    public static Result success(Object data){
        return new Result(true,200,"success",data);
    }
    @ApiModelProperty("失败方法")
    public static Result fail(int code, String msg){
        return new Result(false,code,msg,null);
    }
}
