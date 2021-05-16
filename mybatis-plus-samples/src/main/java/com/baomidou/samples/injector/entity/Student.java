package com.baomidou.samples.injector.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 学生实体
 *
 * @author nieqiurong 2018/8/11 20:20.
 */
@Data
@NoArgsConstructor
public class Student {

    private Long id;

    private String uName;

    private Integer uAge;
}
