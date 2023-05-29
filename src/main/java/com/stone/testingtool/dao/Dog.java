package com.stone.testingtool.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author guocang.shi
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Dog {
    private String name;
    private Float weight;

}
