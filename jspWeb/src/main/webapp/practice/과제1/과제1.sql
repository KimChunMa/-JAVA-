drop database if exists company;
create database company;

use company;

create table workers(
	wno int auto_increment primary key, # 사원 번호
	name varchar(20),					# 사원명
    grade varchar(20),					# 직급
    worker varchar(20),					# 고용형태
    department varchar(20),				# 부서
	joinDate	date,					# 입사일
    picture	varchar(50),				# 사진
	retire	date,						# 퇴사일
    reason	varchar(50)					# 퇴사사유
);

insert into workers (name ,grade, worker, department, joinDate,picture ,retire,reason )
values ('강호동','사원','일용직','인사팀','20230314',null,null,null);
select * from workers;
