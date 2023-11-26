package com.iweb.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Min
 * @date 2023/11/15 18:21
 */
@Data
@NoArgsConstructor

public class Grade {
    private Integer id;
    private String subject;
    private double score;
    private Integer sid;
}
