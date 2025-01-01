package com.aurora.emby.infrastructure.repository.mapper;

import com.aurora.emby.infrastructure.repository.user.UserDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper  extends BaseMapper<UserDO> {


}
