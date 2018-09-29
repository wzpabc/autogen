/**
 * Copyright (c) 2011-2020, hubin (jobob@qq.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.tupperware.auto.generator.config.rules;

/**
 * <p>
 * 表数据查询
 * </p>
 *
 * @author hubin, tangguo
 * @since 2016-04-25
 */
public enum QuerySQL {
    MYSQL("mysql", "show tables", "show table status",
            "show full fields from %s",
            "NAME", "COMMENT", "FIELD", "TYPE", "COMMENT", "KEY"),

    ORACLE("oracle", "SELECT * FROM USER_TABLES", "SELECT * FROM USER_TAB_COMMENTS",
            "SELECT A.COLUMN_NAME, CASE WHEN A.DATA_TYPE='NUMBER' THEN " +
            "(CASE WHEN A.DATA_PRECISION IS NULL THEN A.DATA_TYPE " +
            "WHEN NVL(A.DATA_SCALE, 0) > 0 THEN A.DATA_TYPE||'('||A.DATA_PRECISION||','||A.DATA_SCALE||')' " +
            "ELSE A.DATA_TYPE||'('||A.DATA_PRECISION||')' END) " +
            "ELSE A.DATA_TYPE END DATA_TYPE, B.COMMENTS,DECODE(C.POSITION, '1', 'PRI') KEY " +
            "FROM USER_TAB_COLUMNS A INNER JOIN USER_COL_COMMENTS B ON A.TABLE_NAME = B.TABLE_NAME" +
            " AND A.COLUMN_NAME = B.COLUMN_NAME LEFT JOIN USER_CONSTRAINTS D " +
            "ON D.TABLE_NAME = A.TABLE_NAME AND D.CONSTRAINT_TYPE = 'P' " +
            "LEFT JOIN USER_CONS_COLUMNS C ON C.CONSTRAINT_NAME = D.CONSTRAINT_NAME " +
            "AND C.COLUMN_NAME=A.COLUMN_NAME WHERE A.TABLE_NAME = '%s' ",
            "TABLE_NAME", "COMMENTS", "COLUMN_NAME", "DATA_TYPE", "COMMENTS", "KEY"),

    SQLSERVER("sqlserver",
    	
            "SELECT TABLE_SCHEMA,TABLE_NAME,t.TABLE_NAME COMMENTS FROM INFORMATION_SCHEMA.TABLES AS t",
				
            "SELECT TABLE_SCHEMA, TABLE_NAME,cast(isnull([value],TABLE_NAME) as nvarchar(200))COMMENTS \n"
				+ "FROM INFORMATION_SCHEMA.TABLES AS t \n"
				+ "LEFT JOIN sys.extended_properties ON major_id=OBJECT_ID(t.TABLE_SCHEMA+'.'+t.TABLE_NAME) AND sys.extended_properties.minor_id=0",
				   
			"SELECT    c.TABLE_SCHEMA,c.TABLE_NAME ,  \n"
				+ "        c.COLUMN_NAME ,  \n"
				+ "        cast(ISNULL(p.[value],c.COLUMN_NAME) as nvarchar(50)) COMMENTS ,  \n"
				+ "        c.DATA_TYPE ,  \n"
				+ "        ISNULL([KEY], '') [KEY]  \n"
				+ "FROM    INFORMATION_SCHEMA.[COLUMNS] AS c  \n"
				+ "LEFT JOIN ( SELECT  u.TABLE_SCHEMA ,  \n"
				+ "		u.TABLE_NAME ,  \n"
				+ "		u.COLUMN_NAME ,  \n"
				+ "		u.CONSTRAINT_NAME ,  \n"
				+ "		'PRI' [KEY]  \n"
				+ "FROM    INFORMATION_SCHEMA.CONSTRAINT_COLUMN_USAGE u  \n"
				+ "  WHERE substring(u.CONSTRAINT_NAME,1,2) = 'PK'  \n"
				+ ") t ON t.TABLE_SCHEMA = c.TABLE_SCHEMA AND t.TABLE_NAME = c.TABLE_NAME AND t.COLUMN_NAME = c.COLUMN_NAME  \n"
				+ " \n"
				+ "LEFT JOIN sys.extended_properties p ON major_id=OBJECT_ID(c.TABLE_SCHEMA+'.'+c.TABLE_NAME) AND c.ORDINAL_POSITION=p.minor_id AND p.name='MS_Description' \n"
				+ "WHERE   c.TABLE_NAME = '%s' and c.TABLE_SCHEMA='%s' \n"
				+ "ORDER BY c.ORDINAL_POSITION","TABLE_NAME","COMMENTS","COLUMN_NAME","DATA_TYPE","COMMENTS","KEY");

    private final String dbType;
    private final String tablesSql;
    private final String tableCommentsSql;
    private final String tableFieldsSql;
    private final String tableName;
    private final String tableComment;
    private final String fieldName;
    private final String fieldType;
    private final String fieldComment;
    private final String fieldKey;
    private final String tableSchema="TABLE_SCHEMA";
    
    


    QuerySQL(final String dbType, final String tablesSql, final String tableCommentsSql,
             final String tableFieldsSql, final String tableName, final String tableComment, final String fieldName,
             final String fieldType, final String fieldComment, final String fieldKey) {
        this.dbType = dbType;
        this.tablesSql = tablesSql;
        this.tableCommentsSql = tableCommentsSql;
        this.tableFieldsSql = tableFieldsSql;
        this.tableName = tableName;
        this.tableComment = tableComment;
        this.fieldName = fieldName;
        this.fieldType = fieldType;
        this.fieldComment = fieldComment;
        this.fieldKey = fieldKey;
    }

    public String getTableSchema() {
		return tableSchema;
	}

	public String getDbType() {
        return dbType;
    }

    public String getTablesSql() {
        return tablesSql;
    }

    public String getTableCommentsSql() {
        return tableCommentsSql;
    }

    public String getTableFieldsSql() {
        return tableFieldsSql;
    }

    public String getTableName() {
        return tableName;
    }

    public String getTableComment() {
        return tableComment;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getFieldType() {
        return fieldType;
    }

    public String getFieldComment() {
        return fieldComment;
    }

    public String getFieldKey() {
        return fieldKey;
    }

}
