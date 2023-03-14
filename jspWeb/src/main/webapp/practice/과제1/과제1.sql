drop database if exists company;
create database company;

create table workers(
	wno int auto_increment primary key, # 사원 번호
	name varchar(5),					# 사원명
    grade varchar(3),					# 직급
    worker varchar(3),					# 고용형태
    department varchar(4),				# 부서
	joinDate	date,					# 입사일
    picture	varchar(50),				# 사진
	retire	date,						# 퇴사일
    reason	varchar(50)					# 퇴사사유
);

