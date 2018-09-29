
 CREATE VIEW view_ol_member_sale 
 AS 
 select
 tmsc.[year],
 tmsc.[month],
 tmsc.organ_no,
 tmsc.organ_name,
 tmsc.organ_type,
 tmsc.group_id,
 tmsc.payment_amount,
 tmsc.quantity, 
 tmsc.update_date
from
 member.t_member_sale_chart as tmsc
where 
tmsc.[year]=2018 and tmsc.[month]=1 and tmsc.organ_type='ol' and tmsc.organ_no='200564'


 
declare @tablename nvarchar(100)='view_ol_member_sale'
SELECT  N'execute sp_addextendedproperty ''MS_Description'','''+t.table_name+''',''user'','''+t.TABLE_SCHEMA+''','''+case  t.TABLE_TYPE WHEN'view' then t.table_type ELSE'table' end+''','''+t.table_name+''',null,null'
FROM INFORMATION_SCHEMA.TABLES AS t  
WHERE t.TABLE_NAME=@tablename 
UNION ALL
SELECT    N'execute sp_addextendedproperty ''MS_Description'','''+c.column_name+''',''user'','''+t.TABLE_SCHEMA+''','''+case  t.TABLE_TYPE WHEN'view' then t.table_type ELSE'table' end+''','''+t.table_name+''',''column'','''+c.column_name+''''  sql     FROM INFORMATION_SCHEMA.TABLES AS t INNER JOIN INFORMATION_SCHEMA.[COLUMNS] AS c ON c.TABLE_CATALOG = t.TABLE_CATALOG AND c.TABLE_SCHEMA = t.TABLE_SCHEMA
AND c.TABLE_NAME = t.TABLE_NAME
WHERE c.TABLE_NAME=@tablename 
union all
SELECT  N'execute sp_updateextendedproperty ''MS_Description'','''+t.table_name+''',''user'','''+t.TABLE_SCHEMA+''','''+case  t.TABLE_TYPE WHEN'view' then t.table_type ELSE'table' end+''','''+t.table_name+''',null,null'
FROM INFORMATION_SCHEMA.TABLES AS t  
WHERE t.TABLE_NAME=@tablename 
UNION ALL
SELECT    N'execute sp_updateextendedproperty ''MS_Description'','''+c.column_name+''',''user'','''+t.TABLE_SCHEMA+''','''+case  t.TABLE_TYPE WHEN'view' then t.table_type ELSE'table' end+''','''+t.table_name+''',''column'','''+c.column_name+''''  sql     FROM INFORMATION_SCHEMA.TABLES AS t INNER JOIN INFORMATION_SCHEMA.[COLUMNS] AS c ON c.TABLE_CATALOG = t.TABLE_CATALOG AND c.TABLE_SCHEMA = t.TABLE_SCHEMA
AND c.TABLE_NAME = t.TABLE_NAME
WHERE c.TABLE_NAME=@tablename 

SELECT * FROM sys.extended_properties  WHERE major_id=OBJECT_ID(@tablename )


view_db_hot_by_item
view_db_hot_item
view_db_member_anl
view_db_member_sale
view_db_trend
view_month_kpi_rawdata
view_ol_hot_item 
view_ol_sale_amt_sort
view_ol_sale_amt_top10
view_ol_sale_sort
view_ol_sale_structure
view_ol_sale_top10
view_ol_trend