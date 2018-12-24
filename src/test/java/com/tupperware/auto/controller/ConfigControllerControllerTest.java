package com.tupperware.auto.controller;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.parser.ParserException;
import com.alibaba.druid.sql.visitor.SchemaStatVisitor;
import com.alibaba.druid.stat.TableStat;
import com.alibaba.druid.stat.TableStat.Column;
import com.alibaba.druid.stat.TableStat.Condition;
import com.alibaba.druid.stat.TableStat.Name;
import com.alibaba.druid.util.JdbcConstants;
import com.tupperware.auto.form.ConditionHelper;
import com.tupperware.auto.form.ControllerGenerator;
import com.tupperware.auto.form.OrderbyHelper;
import com.tupperware.auto.generator.AutoGenerator;
import com.tupperware.auto.generator.InjectionConfig;
import com.tupperware.auto.generator.config.StrategyConfig;
import com.tupperware.auto.generator.config.rules.NamingStrategy;
import com.tupperware.auto.mysql.model.ConfigController;
import com.tupperware.auto.service.IConfigControllerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.regex.Pattern;

@RunWith(SpringRunner.class)
@SpringBootTest

public class ConfigControllerControllerTest {
    private Generator cgenerator = new Generator();

    @Autowired
    private IConfigControllerService service;

    private ControllerGenerator generator;

    private static final Logger logger = LoggerFactory.getLogger(ConfigControllerControllerTest.class);

    private AutoGenerator mpg;


    @Autowired
    private IConfigControllerService configControllerService;

    @Test
    public void list() {

        logger.debug("==============================");
        for (ConfigController c : configControllerService.list()
        ) {
            logger.debug(c.toString());
            System.out.println(c.getQuery());
        }
        System.out.println(configControllerService.list().toString());
        System.out.println(configControllerService.list().size());
    }


    public String[] getController() {
        Set<String> set = new HashSet<>();
        for (ConfigController c : service.list()) {
            set.add(c.getTableName());
        }
        return set.toArray(new String[set.size()]);
    }

    public static String sql2notes(String sql) {
        String result_lcase = null;
        try {
            result_lcase = SQLUtils.format(sql, JdbcConstants.MYSQL, SQLUtils.DEFAULT_LCASE_FORMAT_OPTION);
        } catch (Exception e) {
            // TODO: handle exception
        }
        result_lcase = (null == result_lcase ? sql : result_lcase);
        return Pattern.compile("\n|\r").matcher(result_lcase).replaceAll("  \\\\n");
    }

    @Before
    public void setProps() {
        cgenerator.setGlobalConfig();
        cgenerator.setDataSourceConfig();
        cgenerator.setPackageConfig();
        cgenerator.setInjectionConfig();
        cgenerator.setCfg(setInjectionConfig());
        cgenerator.setSc(getStrategyConfig());
        cgenerator.setTemplateConfig();
        mpg = cgenerator.setAutoGenerator();
    }

    private StrategyConfig getStrategyConfig() {
        StrategyConfig strategy = new StrategyConfig();
        //strategy.setTablePrefix("bmd_");// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        //strategy.setExclude(String.valueOf("config_controller").split(",")); // 需要排除生成的表
        strategy.setInclude(getController());
        // 字段名生成策略
        strategy.setFieldNaming(NamingStrategy.underline_to_camel);
        return strategy;
    }

    public InjectionConfig setInjectionConfig() {
        // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
        return new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }

            public void initMap(String table) {
                logger.info(String.format("=============%s=============", table));

                List<ConfigController> configs = service.selectController(table);
                List<ControllerGenerator> generator = new ArrayList<>();
                for (ConfigController config : configs) {
                    System.out.println(config.toString());
                    logger.info(String.format("==========================", table));
                    generator.add(parser2Controller(config));
                }
                this.setController(generator);
            }
        };
    }


    public ControllerGenerator parser2Controller(ConfigController config) {
        logger.info(String.format("===============%s================", "parser2Controller"));
        String sql = config.getQuery();
        String dbType = JdbcConstants.SQL_SERVER;
        List<SQLStatement> stmtList = SQLUtils.parseStatements(sql, dbType);
        SQLStatement stmt = stmtList.get(0);
        SchemaStatVisitor statVisitor = SQLUtils.createSchemaStatVisitor(dbType);
        stmt.accept(statVisitor);
        Map<TableStat.Name, TableStat> table = statVisitor.getTables();
        Set<TableStat.Name> keySet = table.keySet();
        Iterator<TableStat.Name> itt = keySet.iterator();
        if (itt.hasNext()
                && ((TableStat) table.get((TableStat.Name) itt.next())).toString().toLowerCase().equals("select")) {
            logger.info(String.format("===============%s================", "select"));

            Collection<Column> columns = statVisitor.getColumns();
            Iterator<Column> it = columns.iterator();
            Map<String, String> select = new HashMap<>();
            while (it.hasNext()) {
                Column column = (Column) it.next();
                select.put(column.getName(), it.hasNext() ? "," : "");
            }
            logger.info(String.format("===============%s================", "Condition"));

            List<Condition> conds = statVisitor.getConditions();
            List<ConditionHelper> helper = new ArrayList<>();
            Iterator<Condition> itc = conds.iterator();
            while (itc.hasNext()) {
                Condition con = (Condition) itc.next();
                helper.add(new ConditionHelper(con.getColumn().getName(), con.getOperator(),
                        String.format("'%s'", con.getValues().get(0)), itc.hasNext() ? "," : ""));

            }
            logger.info(String.format("===============%s================", "orderit"));

            if (statVisitor.getOrderByColumns().size() > 0) {
                Iterator<Column> orderit = statVisitor.getOrderByColumns().iterator();
                List<OrderbyHelper> order = new ArrayList<>();
                while (orderit.hasNext()) {
                    Column cl = orderit.next();
                    order.add(new OrderbyHelper(cl.getName(), " asc "));
                }
                generator = new ControllerGenerator(helper, select, config, order);
            } else {
                generator = new ControllerGenerator(helper, select, config);
            }
            logger.info(String.format("===============%s================", "return"));

            logger.info(String.format("===============%s================", generator.toString()));
            return generator;
        }
        return null;
    }

    @Test
    public void execute() {
        // 执行生成
       mpg.execute();
    }
    @Test
    public void clear() {
        // 执行生成
        mpg.clear();
    }


    @Test
    public void testFormatSql() {
        List<String> sqls = new ArrayList<>();
        for (ConfigController c : configControllerService.list()) {
            sqls.add(c.getQuery());
            try {

                String result_lcase = SQLUtils.format(c.getQuery(), JdbcConstants.MYSQL,
                        SQLUtils.DEFAULT_LCASE_FORMAT_OPTION);
            } catch (ParserException e) {
                logger.error(String.format("===========format fail:%s===============", c.getQuery()));
            }
        }

        for (String sql : sqls) {
            String plaintext = Pattern.compile("\\r\n").matcher(String.format(" \"%s\"", sql)).replaceAll("  \\\\n\"\r\n+\"");
            parser(sql);
        }

    }

    public void parser(String sql) {
        String dbType = JdbcConstants.MYSQL;
        List<SQLStatement> stmtList = SQLUtils.parseStatements(sql, dbType);
        SQLStatement stmt = stmtList.get(0);
        SchemaStatVisitor statVisitor = SQLUtils.createSchemaStatVisitor(dbType);
        stmt.accept(statVisitor);
        Collection<Column> columns = statVisitor.getColumns();
        Iterator<Column> it = columns.iterator();
        logger.info("=====================columns===========================");
        while (it.hasNext()) {
            Column column = (Column) it.next();
            System.out.println(column.getName());
        }
        Map<Name, TableStat> table = statVisitor.getTables();
        Set<Name> keySet = table.keySet();
        Iterator<Name> itt = keySet.iterator();
        logger.info("=====================Name===========================");
        while (itt.hasNext()) {
            TableStat ts = (TableStat) table.get((Name) itt.next());
            System.out.println(ts.toString());
        }
        List<Condition> conds = statVisitor.getConditions();
        logger.info("=====================Condition===========================");
        for (Condition con : conds) {
            System.out.print(con.getColumn().getName());
            System.out.print(con.getOperator());
            System.out.println(String.format("'%s'", con.getValues().get(0)));
        }
    }

}