package com.example.mybatisplusgenerator;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MybatisPlusGeneratorApplication {

    static DbTableInfo[] tableInfos = {
            new DbTableInfo("tb_user", "tb_"),
            new DbTableInfo("tb_company", "tb_")
    };

    static String projectPath = System.getProperty("user.dir");

    public static GlobalConfig getGlobalConfig() {

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("links");
        gc.setActiveRecord(true);
        gc.setFileOverride(true);
        gc.setOpen(false);
        return gc;
    }

    public static DataSourceConfig getDataSourceConfig() {
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&useSSL=false&characterEncoding=utf8");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("11111111");
        return dsc;
    }

    public static PackageConfig getPackageConfig() {
        // 包配置
        PackageConfig pc = new PackageConfig();
//        pc.setModuleName(scanner("模块名"));
        pc.setParent("com.example.demo");
        pc.setController("api.controller");
        return pc;
    }

    public static TemplateConfig getTemplateConfig(){
        TemplateConfig templateConfig = new TemplateConfig();
//        templateConfig.setXml(null);
        return templateConfig;
    }

    public static InjectionConfig getInjectionConfig(){
        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + "/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        return cfg;
    }

    public static StrategyConfig getStrategyConfig() {
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();

        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//		strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
//      strategy.setEntityColumnConstant(true);
//		strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");
//      strategyConfig.setSuperEntityColumns("id");

        strategy.setControllerMappingHyphenStyle(true);
        return strategy;
    }

    public static void main(String[] args) {

        AutoGenerator mpg = new AutoGenerator();

        mpg.setGlobalConfig(getGlobalConfig());

        mpg.setDataSource(getDataSourceConfig());

        mpg.setPackageInfo(getPackageConfig());

        mpg.setTemplate(getTemplateConfig());

        mpg.setCfg(getInjectionConfig());

        StrategyConfig strategyConfig = getStrategyConfig();

        String[] tableNames = new String[tableInfos.length];
        String[] tablePrefixes = new String[tableInfos.length];
        for (int i = 0; i < tableInfos.length ; i++) {
            tableNames[i] = tableInfos[i].getTableName();
            tablePrefixes[i] = tableInfos[i].getTablePrefix();
        }
        strategyConfig.setInclude(tableNames);
        strategyConfig.setTablePrefix(tablePrefixes);
        mpg.setStrategy(strategyConfig);

        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}
