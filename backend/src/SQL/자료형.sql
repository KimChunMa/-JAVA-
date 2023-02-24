drop table if exists testtype;
create table testtype(
	tinyint_col tinyint, -- 1바이트, +-128
    smallint_col smallint, -- 2바이트 +-3만
    int_col int , 			-- 4바이트 +-21억
    int_col2 unsigned int,	-- 음수사용x
    bigint_col bigint,		-- 8바이트 +- 21억
    char_col char(10),		-- char(1~255) :고정
    varchar_col varchar(10), -- varchar(1~16383) :가변
	text_col text,			-- 1~65535
    longtext_col longtext,	-- 1~42억
    float_col float,		-- 소수점 7자리 저장
    double_col double,		-- 소수점 15자리 저wkd
    date_col date,			-- 날짜저장 yyyy-mm-dd
    time_col time,			-- 시간 hh:mm:ss
    datetime_col datetime	-- yyyy-mm-dd hh:mm:ss
);