package com.baomidou.samples.injector.methods;

import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.springframework.stereotype.Component;

public class UpdateBatch extends AbstractMethod {

    String sqlStr = "<script>\n" +
        "<foreach collection=\"list\" item=\"item\" separator=\";\">\n" +
        "UPDATE %s %s %s %s\n" +
        "</foreach>\n" +
        "</script>";

    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        String sql = String.format(sqlStr, tableInfo.getTableName(),
            sqlSet(true, true, tableInfo, true, "item", "item."),
            sqlWhereEntityWrapper(true, tableInfo),
            sqlComment());
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);
        return this.addUpdateMappedStatement(mapperClass, modelClass, getMethod(null), sqlSource);
    }

    @Override
    public String getMethod(SqlMethod sqlMethod) {
        return "updateBatch";
    }
}
