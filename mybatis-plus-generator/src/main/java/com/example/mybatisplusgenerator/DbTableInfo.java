package com.example.mybatisplusgenerator;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DbTableInfo {

    private String tableName;
    private String tablePrefix;
}
