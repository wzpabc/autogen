USE [TUPDW]
GO
/****** Object:  Table [dbo].[config_controller]    Script Date: 2018/5/18 15:02:23 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[config_controller](
	[id] [int] NOT NULL,
	[group_id] [nvarchar](10) NULL,
	[table_schema] [varchar](300) NOT NULL,
	[table_name] [varchar](150) NOT NULL,
	[table_type] [varchar](50) NOT NULL,
	[table_desc] [varchar](160) NOT NULL,
	[api_value] [varchar](120) NOT NULL,
	[notes] [nvarchar](1000) NULL,
	[flag] [nvarchar](100) NULL,
	[producers] [varchar](160) NOT NULL,
	[require] [nvarchar](11) NULL,
	[isdisable] [int] NULL DEFAULT ((0)),
	[construct] [nvarchar](11) NULL DEFAULT ((0)),
	[ignore] [int] NOT NULL,
	[request_path] [varchar](110) NOT NULL,
	[request_method] [varchar](40) NOT NULL,
	[function_name] [varchar](110) NOT NULL,
	[query] [nvarchar](4000) NULL,
	[auth] [int] NOT NULL,
	[update_date] [datetime] NOT NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[config_controller] ([id], [group_id], [table_schema], [table_name], [table_type], [table_desc], [api_value], [notes], [flag], [producers], [require], [isdisable], [construct], [ignore], [request_path], [request_method], [function_name], [query], [auth], [update_date]) VALUES (1, N'01', N'dbo', N't_datetime_week', N'table', N'财务周划分', N'查询起止时间', N'查询财务周起止时间表', N'"A).Tag System"', N'application/json', N'true', 0, N'no', 0, N'curtweek', N'POST', N'currentweek', N'select
 	tdw.year_week,
 	tdw.year,
 	tdw.quarter,
 	tdw.month,
 	tdw.week,
 	tdw.date_begin,
 	tdw.date_end
 from
 	t_datetime_week as tdw
 where tdw.year_week=''y2017w03''', 1, CAST(N'2018-04-17 15:35:48.450' AS DateTime))
INSERT [dbo].[config_controller] ([id], [group_id], [table_schema], [table_name], [table_type], [table_desc], [api_value], [notes], [flag], [producers], [require], [isdisable], [construct], [ignore], [request_path], [request_method], [function_name], [query], [auth], [update_date]) VALUES (2, N'02', N'dbo', N't_organ_kpi_week', N'table', N'每周指标', N'查询机构一周指标', N'查询机构一周指标', N'"D).Tag Outlet","C).Tag DB"', N'application/json', N'true', 0, N'yes', 0, N'curWeekKpi', N'POST', N'currentweekKpi', N'SELECT
 	tokw.year_week,
 	tokw.year_month,
 	tokw.year,
 	tokw.month,
 	tokw.week,
 	tokw.organ_no,
 	tokw.organ_name,
 	tokw.organ_type,
 	tokw.order_amt,
 	tokw.actual_amt,
 	tokw.net_amt,
 	tokw.OIO,
 	tokw.new_outlet,
 	tokw.close_outlet,
 	tokw.new_member_total,
 	tokw.db_qty,
 	tokw.discount_amt,
 	tokw.first_order,
 	tokw.valid_common_member_count,
 	tokw.valid_vip_member_count,
 	tokw.online_member_count,
 	tokw.recruit_common_member_count,
 	tokw.recruit_vip_member_count,
 	tokw.upgrade_normal_count,
 	tokw.upgrade_enter_count,
 	tokw.upgrade_out_count,
 	tokw.transfer_out_common_member_count,
 	tokw.transfer_in_common_member_count,
 	tokw.transfer_out_vip_member_count,
 	tokw.transfer_int_vip_member_count,
 	tokw.common_member_quit_count,
 	tokw.vip_member_quit_count,
 	tokw.new_member_normal,
 	tokw.new_member_vip,
 	tokw.member_active,
 	tokw.breakeven_point,
 	tokw.counter_sale_amts,
 	tokw.lijia_sales_amts,
 	tokw.grpb_sales_amts,
 	tokw.customised_sales_amts,
 	tokw.others_sales_amts,
 	tokw.deal_amts,
 	tokw.total_sales_amts,
 	tokw.natural_customer_no,
 	tokw.comeback_customer_no,
 	tokw.customised_customer_no,
 	tokw.total_customer_no,
 	tokw.lijia_prstt_times,
 	tokw.imdtly_prstt_times,
 	tokw.water_purifier_sales_amts,
 	tokw.total_prstt_times,
 	tokw.total_order_amt,
 	tokw.lijia_fulltime_consutant_no,
 	tokw.weekend_stock_amt,
 	tokw.report_desc,
 	tokw.decoration_charge,
 	tokw.operation_charge,
 	tokw.labor_charge,
 	tokw.room_charge,
 	tokw.light_water_charge,
 	tokw.promo_charge,
 	tokw.phone_charge,
 	tokw.logistical_charge,
 	tokw.tax_charge,
 	tokw.others_charge,
 	tokw.discoun_amt,
 	tokw.group_amt,
 	tokw.group_real_amt,
 	tokw.group_net_amt,
 	tokw.Promotion_amt,
 	tokw.Promotion_real_amt,
 	tokw.Promotion_net_amt
 FROM
 	t_organ_kpi_week AS tokw
 WHERE tokw.organ_no=''200037''AND tokw.week=13 AND tokw.organ_type=''OL'' AND tokw.year=2018 
 ', 1, CAST(N'2018-04-17 15:36:50.047' AS DateTime))
INSERT [dbo].[config_controller] ([id], [group_id], [table_schema], [table_name], [table_type], [table_desc], [api_value], [notes], [flag], [producers], [require], [isdisable], [construct], [ignore], [request_path], [request_method], [function_name], [query], [auth], [update_date]) VALUES (3, N'02', N'dbo', N't_organ_kpi_week', N'table', N'每周指标', N'查询机构累计周指标', N'查询累计周指标', N'"D).Tag Outlet","C).Tag DB"', N'application/json', N'true', 0, N'yes', 0, N'accWeekKpi', N'POST', N'AcctWeekKpi', N'
  SELECT
 	tokw.year_week,
 	tokw.year_month,
 	tokw.year,
 	tokw.month,
 	tokw.week,
 	tokw.organ_no,
 	tokw.organ_name,
 	tokw.organ_type,
 	tokw.order_amt,
 	tokw.actual_amt,
 	tokw.net_amt,
 	tokw.OIO 
 FROM
 	t_organ_kpi_week AS tokw
 WHERE tokw.organ_no=''200037'' AND tokw.week<=11 AND tokw.organ_type=''OL''   AND tokw.year=2017
 order by year_week', 1, CAST(N'2018-04-17 15:36:50.430' AS DateTime))
INSERT [dbo].[config_controller] ([id], [group_id], [table_schema], [table_name], [table_type], [table_desc], [api_value], [notes], [flag], [producers], [require], [isdisable], [construct], [ignore], [request_path], [request_method], [function_name], [query], [auth], [update_date]) VALUES (4, N'03', N'member', N't_hot_item_chart', N'table', N'主推产品销售情况', N'查询单店当月主推汇总', N'查询单店当月主推汇总', N'"D).Tag Outlet","C).Tag DB"', N'application/json', N'true', 0, N'yes', 0, N'outletSale', N'POST', N'outletSale', N'select
	thic.year,
	thic.month, 
	thic.organ_no,
	thic.organ_name,
	thic.organ_type,
	thic.cls_no,
	thic.cls_name,
	thic.cls_no_s,
	thic.cls_name_s,
	thic.payment_amount,
	thic.quantity,
	thic.benefit_money_amount
	from
	member.t_hot_item_chart as thic
	where 
	thic.organ_no =''208507'' 
	and thic.month=11 
	and thic.organ_type=''ol''
	and thic.year=2017 
	order by  
	thic.organ_no,thic.cls_no, 
	thic.cls_no_s', 1, CAST(N'2018-04-17 15:36:50.430' AS DateTime))
INSERT [dbo].[config_controller] ([id], [group_id], [table_schema], [table_name], [table_type], [table_desc], [api_value], [notes], [flag], [producers], [require], [isdisable], [construct], [ignore], [request_path], [request_method], [function_name], [query], [auth], [update_date]) VALUES (5, N'04', N'member', N't_outlet_item_chart', N'table', N'单店产品销售情况', N'查询单店产品销售金额 top10', N'查询单店产品销售金额 top10', N'"D).Tag Outlet"', N'application/json', N'true', 0, N'yes', 0, N'outlettopten', N'POST', N'outletTopTen', N'	select
	toic.year,
	toic.month,
	toic.organ_no,
	toic.organ_name,
	toic.organ_type,
	toic.product_code,
	toic.product_name_cn,
	toic.payment_amount, 
	toic.odr_payment_amount, 
	toic.update_time
	from
	member.t_outlet_item_chart as toic
	where  
	organ_no=''201410''
	and month=10
	and organ_type=''ol'' 
	and  toic.odr_payment_amount<=10 
	and year=2017
	order by toic.odr_payment_amount', 1, CAST(N'2018-04-20 00:00:00.000' AS DateTime))
INSERT [dbo].[config_controller] ([id], [group_id], [table_schema], [table_name], [table_type], [table_desc], [api_value], [notes], [flag], [producers], [require], [isdisable], [construct], [ignore], [request_path], [request_method], [function_name], [query], [auth], [update_date]) VALUES (6, N'04', N'member', N't_outlet_item_chart', N'table', N'单店产品销售情况', N'查询单店产品销售量top10', N'单店查询产品销售量top10', N'"D).Tag Outlet"', N'application/json', N'true', 0, N'yes', 0, N'outletTopQty', N'POST', N'outletTopQty', N'
   
select
toic.year,
toic.month,
toic.organ_no,
toic.organ_name,
toic.organ_type,
toic.product_code,
toic.product_name_cn,
toic.payment_amount,
toic.quantity, 
toic.odr_quantity, 
toic.update_time
from
member.t_outlet_item_chart as toic
where    
organ_no=''201410''
and month=10 
and organ_type=''ol'' 
and year=2017
and   toic.odr_quantity<=10 
order by toic.odr_quantity
   ', 1, CAST(N'2017-01-01 00:00:00.000' AS DateTime))
INSERT [dbo].[config_controller] ([id], [group_id], [table_schema], [table_name], [table_type], [table_desc], [api_value], [notes], [flag], [producers], [require], [isdisable], [construct], [ignore], [request_path], [request_method], [function_name], [query], [auth], [update_date]) VALUES (7, N'05', N'member', N't_outlet_sale_chart', N'table', N'单店销售情况', N'查询门店销售构成', N'查询门店销售构成', N'"D).Tag Outlet"', N'application/json', N'true', 0, N'no', 0, N'dbSale', N'POST', N'dbSale', N' select
  tosc.db_no,
  tosc.db_name,
  tosc.outlet_no,
  tosc.outlet_name,
  tosc.year,
  tosc.month,
  tosc.week,
  tosc.total,
  tosc.val,
  tosc.kpi,
  tosc.precent
 from
  member.t_outlet_sale_chart as tosc
  
 where tosc.year=2017 and week=50 and tosc.db_no=''12930''', 1, CAST(N'2017-01-01 00:00:00.000' AS DateTime))
INSERT [dbo].[config_controller] ([id], [group_id], [table_schema], [table_name], [table_type], [table_desc], [api_value], [notes], [flag], [producers], [require], [isdisable], [construct], [ignore], [request_path], [request_method], [function_name], [query], [auth], [update_date]) VALUES (8, N'06', N'member', N't_member_sale_chart', N'table', N'会员消费情况', N'查询单店会员消费占比', N'查询单店会员消费占比', N'"D).Tag Outlet","C).Tag DB","B).Tag Member"', N'application/json', N'true', 0, N'yes', 0, N'memberSale', N'POST', N'memberSale', N'select
 tmsc.year,
 tmsc.month,
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
  tmsc.organ_no=''200564'' and tmsc.month=1 and tmsc.organ_type=''ol'' AND tmsc.year=2018 ', 1, CAST(N'2017-01-01 00:00:00.000' AS DateTime))
INSERT [dbo].[config_controller] ([id], [group_id], [table_schema], [table_name], [table_type], [table_desc], [api_value], [notes], [flag], [producers], [require], [isdisable], [construct], [ignore], [request_path], [request_method], [function_name], [query], [auth], [update_date]) VALUES (9, N'07', N'dbo', N'view_db_kpi_week', N'view', N'分销商KPI视图', N'查询门店销售金额排行', N'查询门店销售金额排行', N'"C).Tag DB"', N'application/json', N'true', 0, N'yes', 0, N'dbSaleAmt', N'POST', N'dbSaleAmt', N' select
            	vdkw.year,
            	vdkw.month,
            	vdkw.week,
            	vdkw.db_no,
            	vdkw.db_name,
            	vdkw.organ_type,
            	vdkw.organ_no,
            	vdkw.organ_name,
            	vdkw.actual_amt 
            from
            	view_db_kpi_week as vdkw
            	   where  
              vdkw.db_no = ''10001''
            AND  vdkw.week = 50
              and vdkw.organ_type = ''ol''
                 and vdkw.year = 2017
            and vdkw.oio = 1
            ORDER BY actual_amt', 1, CAST(N'2017-01-01 00:00:00.000' AS DateTime))
INSERT [dbo].[config_controller] ([id], [group_id], [table_schema], [table_name], [table_type], [table_desc], [api_value], [notes], [flag], [producers], [require], [isdisable], [construct], [ignore], [request_path], [request_method], [function_name], [query], [auth], [update_date]) VALUES (10, N'08', N'dbo', N't_organ_golive', N'table', N'新旧编码对照', N'检验并是否为旧编码', N'检验并是否为旧编码,真则返回该行', N'"A).Tag System"', N'application/json', N'true', 0, N'no', 0, N'checkOrganno', N'POST', N'checkOrganno', N' select  	tog.organ_no,
 	tog.organ_name,
 	tog.jde_id,
 	tog.organ_type,
 	tog.effect_date,
 	tog.is_fmsID from t_organ_golive as tog
 where tog.organ_no=''215367''  and tog.organ_type=''ol''', 1, CAST(N'2018-04-20 00:00:00.000' AS DateTime))
INSERT [dbo].[config_controller] ([id], [group_id], [table_schema], [table_name], [table_type], [table_desc], [api_value], [notes], [flag], [producers], [require], [isdisable], [construct], [ignore], [request_path], [request_method], [function_name], [query], [auth], [update_date]) VALUES (11, N'08', N'dbo', N't_organ_golive', N'table', N'新旧编码对照', N'检验并是否为JDE编码', N'检验并是否为JDE编码,真则返回该行', N'"A).Tag System"', N'application/json', N'true', 0, N'no', 0, N'checkJDEID', N'POST', N'checkJDEID', N'  select  	tog.organ_no,
 	tog.organ_name,
 	tog.jde_id,
 	tog.organ_type,
 	tog.effect_date,
 	tog.is_fmsID from t_organ_golive as tog
 where  tog.jde_id=''39957'' and tog.organ_type=''ol''
  ORDER BY jde_id', 1, CAST(N'2018-01-10 00:00:00.000' AS DateTime))
INSERT [dbo].[config_controller] ([id], [group_id], [table_schema], [table_name], [table_type], [table_desc], [api_value], [notes], [flag], [producers], [require], [isdisable], [construct], [ignore], [request_path], [request_method], [function_name], [query], [auth], [update_date]) VALUES (12, N'09', N'dbo', N't_organ_db_weekly_flow', N'table', N'分销商级别情况', N'分销商级别情况', N'分销商级别情况', N'"C).Tag DB"', N'application/json', N'true', 0, N'no', 0, N'dbWeekFlow', N'POST', N'dbWeekFlow', N'select
	todwf.ext_extractfrom,
	todwf.year,
	todwf.month,
	todwf.week,
	todwf.organ_no,
	todwf.grade_no,
	todwf.channel_type,
	todwf.grade_type,
	todwf.year_week,
	todwf.grade_name,
	todwf.fms_grade_type
from
	t_organ_db_weekly_flow as todwf
where todwf.organ_no=''10001'' and todwf.year=2018 and todwf.week=11', 1, CAST(N'2018-01-01 00:00:00.000' AS DateTime))
INSERT [dbo].[config_controller] ([id], [group_id], [table_schema], [table_name], [table_type], [table_desc], [api_value], [notes], [flag], [producers], [require], [isdisable], [construct], [ignore], [request_path], [request_method], [function_name], [query], [auth], [update_date]) VALUES (13, N'10', N'dbo', N'view_db_team_structure', N'view', N'分销商团队组成', N'分销商团队', N'分销商团队', N'"C).Tag DB"', N'application/json', N'true', 0, N'no', 0, N'dbteam', N'POST', N'dbteam', N'select
	vdts.year,
	vdts.month,
	vdts.week,
	vdts.organ_no,
	vdts.grade_no,
	vdts.grade_type,
	vdts.grade_name,
	vdts.outlet_no,
	vdts.outlet_name,
	vdts.linkman,
	vdts.channel_type,
	vdts.outlet_type,
	vdts.owner_name,
	vdts.city,
	vdts.first_order_date,
	vdts.open_date,
	vdts.close_date
from
	view_db_team_structure as vdts 
where  organ_no=''10001'' and  year=2018 and  week=1', 1, CAST(N'2018-01-01 00:00:00.000' AS DateTime))
INSERT [dbo].[config_controller] ([id], [group_id], [table_schema], [table_name], [table_type], [table_desc], [api_value], [notes], [flag], [producers], [require], [isdisable], [construct], [ignore], [request_path], [request_method], [function_name], [query], [auth], [update_date]) VALUES (14, N'11', N'dbo', N't_organ_outlet_weekly_report', N'table', N'周报基础数据', N'周报基础数据', N'周报基础数据', N'"D).Tag Outlet"', N'application/json', N'true', 0, N'no', 0, N'outletWeekRpt', N'POST', N'outletWeekRpt', N' select
 	toowr.ext_extractfrom,
 	toowr.p_year,
 	toowr.p_month,
 	toowr.p_week,
 	toowr.p_customer_id,
 	toowr.p_store_type,
 	toowr.p_report_type,
 	toowr.p_report_status,
 	toowr.ext_business_status,
 	toowr.p_breakeven_point,
 	toowr.p_counter_sale_amts,
 	toowr.p_lijia_sales_amts,
 	toowr.p_grpb_sales_amts,
 	toowr.p_customised_sales_amts,
 	toowr.p_others_sales_amts,
 	toowr.p_deal_amts,
 	toowr.p_total_sales_amts,
 	toowr.p_natural_customer_no,
 	toowr.p_comeback_customer_no,
 	toowr.p_customised_customer_no,
 	toowr.p_total_customer_no,
 	toowr.p_lijia_prstt_times,
 	toowr.p_imdtly_prstt_times,
 	toowr.p_water_purifier_sales_amts,
 	toowr.p_total_prstt_times,
 	toowr.p_total_order_amt,
 	toowr.p_lijia_fulltime_consutant_no,
 	toowr.p_weekend_stock_amt,
 	toowr.p_is_manager,
 	toowr.p_manager_name,
 	toowr.p_manager_type,
 	toowr.p_report_desc,
 	toowr.p_decoration_charge,
 	toowr.p_operation_charge,
 	toowr.p_labor_charge,
 	toowr.p_room_charge,
 	toowr.p_light_water_charge,
 	toowr.p_promo_charge,
 	toowr.p_phone_charge,
 	toowr.p_logistical_charge,
 	toowr.p_tax_charge,
 	toowr.p_others_charge,
 	toowr.year_week,
 	toowr.p_lijia_customer_no,
 	toowr.p_com_order_amt,
 	toowr.p_db_order_amt,
 	toowr.p_franchise_transfer_amt,
 	toowr.p_has_wechat,
 	toowr.p_wechat_grp_no,
 	toowr.p_wechat_members_no,
 	toowr.p_wechat_moments_members_no,
 	toowr.p_experice_card_price50_no,
 	toowr.p_experice_card_price500_no,
 	toowr.p_lijia_team_course_no,
 	toowr.p_hshs_foods_carnival_no,
 	toowr.p_onlinesaleamt,
 	toowr.p_customised_prstt_times,
 	toowr.p_transfer_amt,
 	toowr.p_psm_charge,
 	toowr.p_warehouse_charge,
 	toowr.online_sales_amt,
 	toowr.fromdb_order_amt
 from
 	t_organ_outlet_weekly_report as toowr
 where toowr.p_year=2018 and toowr.p_week=11
 and toowr.p_customer_id=''200037''
 ', 1, CAST(N'2018-01-01 00:00:00.000' AS DateTime))
INSERT [dbo].[config_controller] ([id], [group_id], [table_schema], [table_name], [table_type], [table_desc], [api_value], [notes], [flag], [producers], [require], [isdisable], [construct], [ignore], [request_path], [request_method], [function_name], [query], [auth], [update_date]) VALUES (15, N'12', N'dbo', N't_datetime_month', N'table', N'财务月划分', N'查询财务月起止时间', N'查询财务月起止时间表', N'"A).Tag System"', N'application/json', N'true', 0, N'no', 0, N'curtMonth', N'POST', N'currentMonth', N' select
 	tdm.year_month,
 	tdm.year,
 	tdm.quarter,
 	tdm.month,
 	tdm.date_begin,
 	tdm.date_end
 from
 	t_datetime_month as tdm where tdm.year=2018 and tdm.month=1', 1, CAST(N'2018-04-17 15:35:48.450' AS DateTime))
INSERT [dbo].[config_controller] ([id], [group_id], [table_schema], [table_name], [table_type], [table_desc], [api_value], [notes], [flag], [producers], [require], [isdisable], [construct], [ignore], [request_path], [request_method], [function_name], [query], [auth], [update_date]) VALUES (16, N'02', N'dbo', N't_organ_kpi_week', N'table', N'会员招募累计', N'会员招募累计', N'会员招募累计', N'"B).Tag Member"', N'application/json', N'true', 0, N'no', 0, N'accMember', N'POST', N'accumulateMember', N' select tokw.year_week, tokw.year_month, tokw.year, tokw.month, tokw.week
,tokw.valid_common_member_count, tokw.valid_vip_member_count,
tokw.online_member_count, tokw.recruit_common_member_count,
tokw.recruit_vip_member_count, tokw.common_member_quit_count,
tokw.vip_member_quit_count, tokw.new_member_normal, tokw.new_member_vip,
tokw.member_active
from t_organ_kpi_week tokw
where tokw.organ_no = ''200037''
and tokw.week <= 11
and tokw.organ_type = ''OL''
and tokw.year = 2017
order by year_week', 1, CAST(N'2018-01-01 00:00:00.000' AS DateTime))
INSERT [dbo].[config_controller] ([id], [group_id], [table_schema], [table_name], [table_type], [table_desc], [api_value], [notes], [flag], [producers], [require], [isdisable], [construct], [ignore], [request_path], [request_method], [function_name], [query], [auth], [update_date]) VALUES (17, N'02', N'dbo', N't_organ_kpi_week', N'table', N'会员招募', N'会员招募', N'会员招募', N'"B).Tag Member"', N'application/json', N'true', 0, N'no', 0, N'curMember', N'POST', N'currentMember', N'  select tokw.year_week, tokw.year_month, tokw.year, tokw.month, tokw.week
,tokw.valid_common_member_count, tokw.valid_vip_member_count,
tokw.online_member_count, tokw.recruit_common_member_count,
tokw.recruit_vip_member_count, tokw.common_member_quit_count,
tokw.vip_member_quit_count, tokw.new_member_normal, tokw.new_member_vip,
tokw.member_active
from t_organ_kpi_week tokw
where tokw.organ_no = ''200037''
and tokw.week  = 11
and tokw.organ_type = ''OL''
and tokw.year = 2017
order by year_week', 1, CAST(N'2018-01-01 00:00:00.000' AS DateTime))
INSERT [dbo].[config_controller] ([id], [group_id], [table_schema], [table_name], [table_type], [table_desc], [api_value], [notes], [flag], [producers], [require], [isdisable], [construct], [ignore], [request_path], [request_method], [function_name], [query], [auth], [update_date]) VALUES (18, N'13', N'dbo', N't_transfer_outlet', N'table', N'转让店查询', N'转让店查询', N'转让店查询', N'"D).Tag Outlet"', N'application/json', N'true', 0, N'no', 0, N'transferOutlet', N'POST', N'transferOutlet', N'    SELECT
    	tto.datasource,
    	tto.old_outlet,
    	tto.new_outlet,
    	tto.jydate,
    	tto.firstorder_date,
    	tto.update_oper,
    	tto.update_date,
    	tto.practise_date
    FROM
    	t_transfer_outlet AS tto WHERE tto.old_outlet=''204130''', 1, CAST(N'2018-04-17 15:35:48.450' AS DateTime))
INSERT [dbo].[config_controller] ([id], [group_id], [table_schema], [table_name], [table_type], [table_desc], [api_value], [notes], [flag], [producers], [require], [isdisable], [construct], [ignore], [request_path], [request_method], [function_name], [query], [auth], [update_date]) VALUES (19, N'14', N'dbo', N't_orderdetail', N'table', N'订单明细查询', N'订单明细查询', N'订单明细查询', N'"D).Tag Outlet"', N'application/json', N'true', 0, N'no', 0, N'orderDetail', N'POST', N'orderDetail', N' select
 	tod.row_number,
 	tod.item_no,
 	tod.item_name,
 	tod.real_price_s,
 	tod.real_qty_s,
 	tod.real_qty_b,
 	tod.unit,
 	tod.amt,
 	tod.pay_amt,
 	tod.unit_factor,
 	tod.organ_no,
 	tod.organ_name,
 	tod.organ_discount,
 	tod.sheet_no,
 	tod.sheet_type,
 	tod.create_date,
 	tod.approve_date_fa,
 	tod.discount_flag,
 	tod.item_cls,
 	tod.province_name,
 	tod.p_sheet_no,
 	tod.type,
 	tod.detail_memo,
 	tod.memo,
 	tod.approve_date,
 	tod.region_name,
 	tod.real_integral,
 	tod.real_int_subtotal,
 	tod.ship_to,
 	tod.discount48_flag,
 	tod.real_discount,
 	tod.real_amt,
 	tod.db_no,
 	tod.datasource,
 	tod.approve_date_fa_date
 from
 	t_orderdetail as tod
 	 	where  tod.approve_date_fa_date >=   ''2017-09-05''and   tod.approve_date_fa_date<=''2017-10-05'' 
 	and tod.organ_no=''216739'' ', 1, CAST(N'2018-04-17 15:36:50.047' AS DateTime))
INSERT [dbo].[config_controller] ([id], [group_id], [table_schema], [table_name], [table_type], [table_desc], [api_value], [notes], [flag], [producers], [require], [isdisable], [construct], [ignore], [request_path], [request_method], [function_name], [query], [auth], [update_date]) VALUES (20, N'14', N'dbo', N't_orderdetail', N'table', N'按单号查询订单明细', N'按单号查询订单明细', N'按单号查询订单明细', N'"D).Tag Outlet"', N'application/json', N'true', 0, N'no', 0, N'orderDetailBySheetno', N'POST', N'orderDetailBySheetno', N'	 select
 	tod.row_number,
 	tod.item_no,
 	tod.item_name,
 	tod.real_price_s,
 	tod.real_qty_s,
 	tod.real_qty_b,
 	tod.unit,
 	tod.amt,
 	tod.pay_amt,
 	tod.unit_factor,
 	tod.organ_no,
 	tod.organ_name,
 	tod.organ_discount,
 	tod.sheet_no,
 	tod.sheet_type,
 	tod.create_date,
 	tod.approve_date_fa,
 	tod.discount_flag,
 	tod.item_cls,
 	tod.province_name,
 	tod.p_sheet_no,
 	tod.type,
 	tod.detail_memo,
 	tod.memo,
 	tod.approve_date,
 	tod.region_name,
 	tod.real_integral,
 	tod.real_int_subtotal,
 	tod.ship_to,
 	tod.discount48_flag,
 	tod.real_discount,
 	tod.real_amt,
 	tod.db_no,
 	tod.datasource,
 	tod.approve_date_fa_date
 from
 	t_orderdetail as tod
 	 where tod.sheet_no=''f-s21700016047''', 1, CAST(N'2018-04-17 15:36:50.430' AS DateTime))
INSERT [dbo].[config_controller] ([id], [group_id], [table_schema], [table_name], [table_type], [table_desc], [api_value], [notes], [flag], [producers], [require], [isdisable], [construct], [ignore], [request_path], [request_method], [function_name], [query], [auth], [update_date]) VALUES (21, N'15', N'dbo', N't_orderheader', N'table', N'订单头查询', N'订单头查询', N'订单头查询', N'"D).Tag Outlet"', N'application/json', N'true', 0, N'no', 0, N'orderHeader', N'POST', N'orderHeader', N'
 
 	select
 		to1.datasource,
 		to1.region_name,
 		to1.sheet_no,
 		to1.create_date,
 		to1.approve_date_fa,
 		to1.payment_date,
 		to1.submit_date,
 		to1.sheet_amt,
 		to1.pay_amt,
 		to1.net_amount,
 		to1.discount_amt,
 		to1.normal_amt,
 		to1.organ_no,
 		to1.payment_flag,
 		to1.is_tranfree,
 		to1.organ_name,
 		to1.organ_name2,
 		to1.order_status,
 		to1.sheet_type,
 		to1.memo,
 		to1.organ_discount,
 		to1.province_name,
 		to1.sheet_integral,
 		to1.ship_to,
 		to1.discount48_flag,
 		to1.real_discount,
 		to1.real_int,
 		to1.real_amt,
 		to1.return_int,
 		to1.db_no,
 		to1.is_sample,
 		to1.is_db_agent,
 		to1.fs_no,
 		to1.fs_name,
 		to1.outlet_type,
 		to1.grade_no,
 		to1.approve_date_fa_date
 	from
 		t_orderheader as to1
 	where to1.approve_date_fa_date >= ''2017-09-05''
 	
 	and to1.approve_date_fa_date<=''2017-10-05''
 	and to1.organ_no=''216739''', 1, CAST(N'2018-04-17 15:36:50.430' AS DateTime))
INSERT [dbo].[config_controller] ([id], [group_id], [table_schema], [table_name], [table_type], [table_desc], [api_value], [notes], [flag], [producers], [require], [isdisable], [construct], [ignore], [request_path], [request_method], [function_name], [query], [auth], [update_date]) VALUES (22, N'15', N'dbo', N't_orderheader', N'table', N'按单号查询订单头', N'按单号查询订单头', N'按单号查询订单头', N'"D).Tag Outlet"', N'application/json', N'true', 0, N'no', 0, N'orderHeaderBySheetno', N'POST', N'orderHeaderBySheetno', N'	select
 		to1.datasource,
 		to1.region_name,
 		to1.sheet_no,
 		to1.create_date,
 		to1.approve_date_fa,
 		to1.payment_date,
 		to1.submit_date,
 		to1.sheet_amt,
 		to1.pay_amt,
 		to1.net_amount,
 		to1.discount_amt,
 		to1.normal_amt,
 		to1.organ_no,
 		to1.payment_flag,
 		to1.is_tranfree,
 		to1.organ_name,
 		to1.organ_name2,
 		to1.order_status,
 		to1.sheet_type,
 		to1.memo,
 		to1.organ_discount,
 		to1.province_name,
 		to1.sheet_integral,
 		to1.ship_to,
 		to1.discount48_flag,
 		to1.real_discount,
 		to1.real_int,
 		to1.real_amt,
 		to1.return_int,
 		to1.db_no,
 		to1.is_sample,
 		to1.is_db_agent,
 		to1.fs_no,
 		to1.fs_name,
 		to1.outlet_type,
 		to1.grade_no,
 		to1.approve_date_fa_date
 	from
 		t_orderheader as to1
 where to1.sheet_no=''f-s21700016047''', 1, CAST(N'2018-04-20 00:00:00.000' AS DateTime))
INSERT [dbo].[config_controller] ([id], [group_id], [table_schema], [table_name], [table_type], [table_desc], [api_value], [notes], [flag], [producers], [require], [isdisable], [construct], [ignore], [request_path], [request_method], [function_name], [query], [auth], [update_date]) VALUES (23, N'04', N'member', N't_outlet_item_chart', N'table', N'单店产品销售情况', N'查询单店产品销售量top10', N'单店查询产品销售量top10', N'"D).Tag Outlet"', N'application/json', N'true', 1, N'yes', 0, N'outletTopQty', N'POST', N'outletTopQty', N'
   
select
toic.year,
toic.month,
toic.organ_no,
toic.organ_name,
toic.organ_type,
toic.product_code,
toic.product_name_cn,
toic.payment_amount,
toic.quantity, 
toic.odr_quantity, 
toic.update_time
from
member.t_outlet_item_chart as toic
where    
organ_no=''201410''
and month=10 
and organ_type=''ol'' 
and year=2017
and   toic.odr_quantity<=10 
order by toic.odr_quantity
   ', 1, CAST(N'2017-01-01 00:00:00.000' AS DateTime))
INSERT [dbo].[config_controller] ([id], [group_id], [table_schema], [table_name], [table_type], [table_desc], [api_value], [notes], [flag], [producers], [require], [isdisable], [construct], [ignore], [request_path], [request_method], [function_name], [query], [auth], [update_date]) VALUES (24, N'05', N'member', N't_outlet_sale_chart', N'table', N'单店销售情况', N'查询门店销售构成', N'查询门店销售构成', N'"D).Tag Outlet"', N'application/json', N'true', 1, N'no', 0, N'dbSale', N'POST', N'dbSale', N' select
  tosc.db_no,
  tosc.db_name,
  tosc.outlet_no,
  tosc.outlet_name,
  tosc.year,
  tosc.month,
  tosc.week,
  tosc.total,
  tosc.val,
  tosc.kpi,
  tosc.precent
 from
  member.t_outlet_sale_chart as tosc
  
 where tosc.year=2017 and week=50 and tosc.db_no=''12930''', 1, CAST(N'2017-01-01 00:00:00.000' AS DateTime))
INSERT [dbo].[config_controller] ([id], [group_id], [table_schema], [table_name], [table_type], [table_desc], [api_value], [notes], [flag], [producers], [require], [isdisable], [construct], [ignore], [request_path], [request_method], [function_name], [query], [auth], [update_date]) VALUES (25, N'06', N'member', N't_member_sale_chart', N'table', N'会员消费情况', N'查询单店会员消费占比', N'查询单店会员消费占比', N'"D).Tag Outlet","C).Tag DB","B).Tag Member"', N'application/json', N'true', 1, N'yes', 0, N'memberSale', N'POST', N'memberSale', N'select
 tmsc.year,
 tmsc.month,
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
  tmsc.organ_no=''200564'' and tmsc.month=1 and tmsc.organ_type=''ol'' AND tmsc.year=2018 ', 1, CAST(N'2017-01-01 00:00:00.000' AS DateTime))
INSERT [dbo].[config_controller] ([id], [group_id], [table_schema], [table_name], [table_type], [table_desc], [api_value], [notes], [flag], [producers], [require], [isdisable], [construct], [ignore], [request_path], [request_method], [function_name], [query], [auth], [update_date]) VALUES (26, N'07', N'dbo', N'view_db_kpi_week', N'view', N'分销商KPI视图', N'查询门店销售金额排行', N'查询门店销售金额排行', N'"C).Tag DB"', N'application/json', N'true', 1, N'yes', 0, N'dbSaleAmt', N'POST', N'dbSaleAmt', N' select
            	vdkw.year,
            	vdkw.month,
            	vdkw.week,
            	vdkw.db_no,
            	vdkw.db_name,
            	vdkw.organ_type,
            	vdkw.organ_no,
            	vdkw.organ_name,
            	vdkw.actual_amt 
            from
            	view_db_kpi_week as vdkw
            	   where  
              vdkw.db_no = ''10001''
            AND  vdkw.week = 50
              and vdkw.organ_type = ''ol''
                 and vdkw.year = 2017
            and vdkw.oio = 1
            ORDER BY actual_amt', 1, CAST(N'2017-01-01 00:00:00.000' AS DateTime))
INSERT [dbo].[config_controller] ([id], [group_id], [table_schema], [table_name], [table_type], [table_desc], [api_value], [notes], [flag], [producers], [require], [isdisable], [construct], [ignore], [request_path], [request_method], [function_name], [query], [auth], [update_date]) VALUES (27, N'08', N'dbo', N't_organ_golive', N'table', N'新旧编码对照', N'检验并是否为旧编码', N'检验并是否为旧编码,真则返回该行', N'"A).Tag System"', N'application/json', N'true', 1, N'no', 0, N'checkOrganno', N'POST', N'checkOrganno', N' select  	tog.organ_no,
 	tog.organ_name,
 	tog.jde_id,
 	tog.organ_type,
 	tog.effect_date,
 	tog.is_fmsID from t_organ_golive as tog
 where tog.organ_no=''215367''  and tog.organ_type=''ol''', 1, CAST(N'2018-04-20 00:00:00.000' AS DateTime))
INSERT [dbo].[config_controller] ([id], [group_id], [table_schema], [table_name], [table_type], [table_desc], [api_value], [notes], [flag], [producers], [require], [isdisable], [construct], [ignore], [request_path], [request_method], [function_name], [query], [auth], [update_date]) VALUES (28, N'08', N'dbo', N't_organ_golive', N'table', N'新旧编码对照', N'检验并是否为JDE编码', N'检验并是否为JDE编码,真则返回该行', N'"A).Tag System"', N'application/json', N'true', 1, N'no', 0, N'checkJDEID', N'POST', N'checkJDEID', N'  select  	tog.organ_no,
 	tog.organ_name,
 	tog.jde_id,
 	tog.organ_type,
 	tog.effect_date,
 	tog.is_fmsID from t_organ_golive as tog
 where  tog.jde_id=''39957'' and tog.organ_type=''ol''
  ORDER BY jde_id', 1, CAST(N'2018-01-10 00:00:00.000' AS DateTime))
INSERT [dbo].[config_controller] ([id], [group_id], [table_schema], [table_name], [table_type], [table_desc], [api_value], [notes], [flag], [producers], [require], [isdisable], [construct], [ignore], [request_path], [request_method], [function_name], [query], [auth], [update_date]) VALUES (29, N'09', N'dbo', N't_organ_db_weekly_flow', N'table', N'分销商级别情况', N'分销商级别情况', N'分销商级别情况', N'"C).Tag DB"', N'application/json', N'true', 1, N'no', 0, N'dbWeekFlow', N'POST', N'dbWeekFlow', N'select
	todwf.ext_extractfrom,
	todwf.year,
	todwf.month,
	todwf.week,
	todwf.organ_no,
	todwf.grade_no,
	todwf.channel_type,
	todwf.grade_type,
	todwf.year_week,
	todwf.grade_name,
	todwf.fms_grade_type
from
	t_organ_db_weekly_flow as todwf
where todwf.organ_no=''10001'' and todwf.year=2018 and todwf.week=11', 1, CAST(N'2018-01-01 00:00:00.000' AS DateTime))
INSERT [dbo].[config_controller] ([id], [group_id], [table_schema], [table_name], [table_type], [table_desc], [api_value], [notes], [flag], [producers], [require], [isdisable], [construct], [ignore], [request_path], [request_method], [function_name], [query], [auth], [update_date]) VALUES (30, N'10', N'dbo', N'view_db_team_structure', N'view', N'分销商团队组成', N'分销商团队', N'分销商团队', N'"C).Tag DB"', N'application/json', N'true', 1, N'no', 0, N'dbteam', N'POST', N'dbteam', N'select
	vdts.year,
	vdts.month,
	vdts.week,
	vdts.organ_no,
	vdts.grade_no,
	vdts.grade_type,
	vdts.grade_name,
	vdts.outlet_no,
	vdts.outlet_name,
	vdts.linkman,
	vdts.channel_type,
	vdts.outlet_type,
	vdts.owner_name,
	vdts.city,
	vdts.first_order_date,
	vdts.open_date,
	vdts.close_date
from
	view_db_team_structure as vdts 
where  organ_no=''10001'' and  year=2018 and  week=1', 1, CAST(N'2018-01-01 00:00:00.000' AS DateTime))
INSERT [dbo].[config_controller] ([id], [group_id], [table_schema], [table_name], [table_type], [table_desc], [api_value], [notes], [flag], [producers], [require], [isdisable], [construct], [ignore], [request_path], [request_method], [function_name], [query], [auth], [update_date]) VALUES (31, N'11', N'dbo', N't_organ_outlet_weekly_report', N'table', N'周报基础数据', N'周报基础数据', N'周报基础数据', N'"D).Tag Outlet"', N'application/json', N'true', 1, N'no', 0, N'outletWeekRpt', N'POST', N'outletWeekRpt', N' select
 	toowr.ext_extractfrom,
 	toowr.p_year,
 	toowr.p_month,
 	toowr.p_week,
 	toowr.p_customer_id,
 	toowr.p_store_type,
 	toowr.p_report_type,
 	toowr.p_report_status,
 	toowr.ext_business_status,
 	toowr.p_breakeven_point,
 	toowr.p_counter_sale_amts,
 	toowr.p_lijia_sales_amts,
 	toowr.p_grpb_sales_amts,
 	toowr.p_customised_sales_amts,
 	toowr.p_others_sales_amts,
 	toowr.p_deal_amts,
 	toowr.p_total_sales_amts,
 	toowr.p_natural_customer_no,
 	toowr.p_comeback_customer_no,
 	toowr.p_customised_customer_no,
 	toowr.p_total_customer_no,
 	toowr.p_lijia_prstt_times,
 	toowr.p_imdtly_prstt_times,
 	toowr.p_water_purifier_sales_amts,
 	toowr.p_total_prstt_times,
 	toowr.p_total_order_amt,
 	toowr.p_lijia_fulltime_consutant_no,
 	toowr.p_weekend_stock_amt,
 	toowr.p_is_manager,
 	toowr.p_manager_name,
 	toowr.p_manager_type,
 	toowr.p_report_desc,
 	toowr.p_decoration_charge,
 	toowr.p_operation_charge,
 	toowr.p_labor_charge,
 	toowr.p_room_charge,
 	toowr.p_light_water_charge,
 	toowr.p_promo_charge,
 	toowr.p_phone_charge,
 	toowr.p_logistical_charge,
 	toowr.p_tax_charge,
 	toowr.p_others_charge,
 	toowr.year_week,
 	toowr.p_lijia_customer_no,
 	toowr.p_com_order_amt,
 	toowr.p_db_order_amt,
 	toowr.p_franchise_transfer_amt,
 	toowr.p_has_wechat,
 	toowr.p_wechat_grp_no,
 	toowr.p_wechat_members_no,
 	toowr.p_wechat_moments_members_no,
 	toowr.p_experice_card_price50_no,
 	toowr.p_experice_card_price500_no,
 	toowr.p_lijia_team_course_no,
 	toowr.p_hshs_foods_carnival_no,
 	toowr.p_onlinesaleamt,
 	toowr.p_customised_prstt_times,
 	toowr.p_transfer_amt,
 	toowr.p_psm_charge,
 	toowr.p_warehouse_charge,
 	toowr.online_sales_amt,
 	toowr.fromdb_order_amt
 from
 	t_organ_outlet_weekly_report as toowr
 where toowr.p_year=2018 and toowr.p_week=11
 and toowr.p_customer_id=''200037''
 ', 1, CAST(N'2018-01-01 00:00:00.000' AS DateTime))
INSERT [dbo].[config_controller] ([id], [group_id], [table_schema], [table_name], [table_type], [table_desc], [api_value], [notes], [flag], [producers], [require], [isdisable], [construct], [ignore], [request_path], [request_method], [function_name], [query], [auth], [update_date]) VALUES (32, N'12', N'dbo', N't_datetime_month', N'table', N'财务月划分', N'查询财务月起止时间', N'查询财务月起止时间表', N'"A).Tag System"', N'application/json', N'true', 1, N'no', 0, N'curtMonth', N'POST', N'currentMonth', N' select
 	tdm.year_month,
 	tdm.year,
 	tdm.quarter,
 	tdm.month,
 	tdm.date_begin,
 	tdm.date_end
 from
 	t_datetime_month as tdm where tdm.year=2018 and tdm.month=1', 1, CAST(N'2018-04-17 15:35:48.450' AS DateTime))
INSERT [dbo].[config_controller] ([id], [group_id], [table_schema], [table_name], [table_type], [table_desc], [api_value], [notes], [flag], [producers], [require], [isdisable], [construct], [ignore], [request_path], [request_method], [function_name], [query], [auth], [update_date]) VALUES (33, N'02', N'dbo', N't_organ_kpi_week', N'table', N'会员招募累计', N'会员招募累计', N'会员招募累计', N'"B).Tag Member"', N'application/json', N'true', 1, N'no', 0, N'accMember', N'POST', N'accumulateMember', N' select tokw.year_week, tokw.year_month, tokw.year, tokw.month, tokw.week
,tokw.valid_common_member_count, tokw.valid_vip_member_count,
tokw.online_member_count, tokw.recruit_common_member_count,
tokw.recruit_vip_member_count, tokw.common_member_quit_count,
tokw.vip_member_quit_count, tokw.new_member_normal, tokw.new_member_vip,
tokw.member_active
from t_organ_kpi_week tokw
where tokw.organ_no = ''200037''
and tokw.week <= 11
and tokw.organ_type = ''OL''
and tokw.year = 2017
order by year_week', 1, CAST(N'2018-01-01 00:00:00.000' AS DateTime))
INSERT [dbo].[config_controller] ([id], [group_id], [table_schema], [table_name], [table_type], [table_desc], [api_value], [notes], [flag], [producers], [require], [isdisable], [construct], [ignore], [request_path], [request_method], [function_name], [query], [auth], [update_date]) VALUES (34, N'02', N'dbo', N't_organ_kpi_week', N'table', N'会员招募', N'会员招募', N'会员招募', N'"B).Tag Member"', N'application/json', N'true', 1, N'no', 0, N'curMember', N'POST', N'currentMember', N'  select tokw.year_week, tokw.year_month, tokw.year, tokw.month, tokw.week
,tokw.valid_common_member_count, tokw.valid_vip_member_count,
tokw.online_member_count, tokw.recruit_common_member_count,
tokw.recruit_vip_member_count, tokw.common_member_quit_count,
tokw.vip_member_quit_count, tokw.new_member_normal, tokw.new_member_vip,
tokw.member_active
from t_organ_kpi_week tokw
where tokw.organ_no = ''200037''
and tokw.week  = 11
and tokw.organ_type = ''OL''
and tokw.year = 2017
order by year_week', 1, CAST(N'2018-01-01 00:00:00.000' AS DateTime))
