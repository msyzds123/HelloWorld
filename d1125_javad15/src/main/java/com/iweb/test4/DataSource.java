package com.iweb.test4;

import lombok.Data;

import java.sql.Connection;

/**
 * @author Min
 * @date 2023/11/25 11:46
 */
@Data
public class DataSource {
    private Connection connection;
}
