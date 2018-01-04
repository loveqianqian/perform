select
cast(datepart(YEAR,date_time) as varchar(4))+'-'+RIGHT('00'+CAST(MONTH(date_time) AS VARCHAR(2)),2)+'-'+RIGHT('00'+CAST(day(date_time) AS VARCHAR(2)),2) as time
,COUNT(*) as countNum from xqjxpt.dbo.zymx_his
where date_time >'2017-11-1' and date_time<'2017-12-5'
group by
cast(datepart(YEAR,date_time) as varchar(4))+'-'+RIGHT('00'+CAST(MONTH(date_time) AS VARCHAR(2)),2)+'-'+RIGHT('00'+CAST(day(date_time) AS VARCHAR(2)),2)
order by time;

select
cast(datepart(YEAR,date_time) as varchar(4))+'-'+RIGHT('00'+CAST(MONTH(date_time) AS VARCHAR(2)),2)+'-'+RIGHT('00'+CAST(day(date_time) AS VARCHAR(2)),2) as time
,COUNT(*) as countNum from xqjxpt.dbo.mzmx_his
where date_time >'2017-11-1' and date_time<'2017-12-5'
group by
cast(datepart(YEAR,date_time) as varchar(4))+'-'+RIGHT('00'+CAST(MONTH(date_time) AS VARCHAR(2)),2)+'-'+RIGHT('00'+CAST(day(date_time) AS VARCHAR(2)),2)
order by time;

select
cast(datepart(YEAR,date_time) as varchar(4))+'-'+RIGHT('00'+CAST(MONTH(date_time) AS VARCHAR(2)),2)+'-'+RIGHT('00'+CAST(day(date_time) AS VARCHAR(2)),2) as time
,COUNT(*) as countNum from xqjxpt.dbo.ssmx_his
where date_time >'2017-11-1' and date_time<'2017-12-5'
group by
cast(datepart(YEAR,date_time) as varchar(4))+'-'+RIGHT('00'+CAST(MONTH(date_time) AS VARCHAR(2)),2)+'-'+RIGHT('00'+CAST(day(date_time) AS VARCHAR(2)),2)
order by time;