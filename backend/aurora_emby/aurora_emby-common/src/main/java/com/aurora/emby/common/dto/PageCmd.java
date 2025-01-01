package com.aurora.emby.common.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@ApiModel(value = "PageCmd", description = "分页查询")
public class PageCmd extends Command{

    @ApiModelProperty(value = "每页记录数", name = "pageSize", required = true)
    private int pageSize = 1;

    @ApiModelProperty(value = "分页起始页", name = "pageIndex", required = true)
    private int pageIndex = 1;
}
