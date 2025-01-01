package com.aurora.emby.infrastructure.repository;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class CommonDO {
    /**
     * 创建时间
     */
    @TableField(value = " create_time", fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = " update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

}
