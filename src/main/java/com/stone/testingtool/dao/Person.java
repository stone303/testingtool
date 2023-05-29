package com.stone.testingtool.dao;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


/***
 *
 * 以下是我们可以与 @JSONField 注解一起使用的最基本参数列表，以便自定义转换过程：
 *
 * 参数格 format 用于正确格式化日期属性
 * 默认情况下，fastjson 库完全序列化Java bean，但我们可以使用参数 -serialize来忽略特定字段的序列化
 * 参数 ordinal 用于指定字段顺序
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    // 忽略序列化和反序列化

    @JSONField(name = "AGE", serialize = false, deserialize = false)
    private int age;

    // ordinal指定顺序

    @JSONField(name = "LAST NAME", ordinal = 2)
    private String lastName;

    @JSONField(name = "FIRST NAME", ordinal = 1)
    private String firstName;

    // format格式化

    @JSONField(name = "DATE OF BIRTH", format = "dd/MM/yyyy",ordinal = 3)
    private Date dateOfBirth;
}
