package com.laki.gymdemo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("gym_role")
public class Role {
    private Long id;
    private String create_time;
    private String update_time;
    private String name;
    private String remark;
    private Integer status;
    private Integer type;



}
