package com.jacklu.mybatisplus.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
//类名一定要跟数据库的表名一致
public class User_1 {
    private String name1;
    private String name2;
    private Date date1;
    private Date date2;
}
