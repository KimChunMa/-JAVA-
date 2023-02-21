#DML

create database java;
use java;
create table 게시판(제목 varchar(20) , 내용 varchar(20) ) ;

# 예1) insert
insert into 게시판 values('제목 구역', '내용구역');
#	필드명이 명시되어있지 않기에, 순서대로 데이터 삽입


select * from 게시판;
drop database java;

# 예2)
insert into 게시판 (제목,내용) values('제목구역2','내용구역2');
#	필드명이 명시되어, 명시된 필드순서대로 데이터 삽입
select * from 게시판;

# insert 에 매개변수 형식 [JDBC 사용할 예정]
	# ? : 변수가 들어가는 자리를 뜻함
insert into 게시판(제목,내용) value(?,?); # java에서만 실행됨

/*	
	문제3 : 
	1.jsp 라는 데이터베이스 생성/선택
    2. member 테이블 생성 (회원번호[정수] , 아이디[20] ,비밀번호[20])
    3.회원가입 2명 하기
    
    1	,	이젠	,	1234
    2	,	삼성	,	4567
	
    4.확인 및 삭제
*/

create database jsp;
use jsp;
create table member(no int, id varchar(20) , pw varchar(20) );
insert into member(no,id,pw) values (1,'이젠','1234');
insert into member values (2,'삼성','4567');
insert into member (id) value('LG');
select * from member;

drop database jsp;


/*
	문제4
		1. spring 데이터베이스 생성
        2. product 테이블생성 (제품번호, 제품명, 가격)
        3. 제품등록 3개
			1	,	'냉장고'	,	20000
            2	,	'선풍기'	,	30000
            null,	'컴퓨터'	,	null
        4.확인 및 삭제
*/

create database spring;
use spring;
create table product ( pno int , name varchar(20) , price int);
insert into product values (1,'냉장고',20000);
insert into product values (2,'선풍기',30000);
insert into product (name) values ('컴퓨터');

select * from product;

drop database spring;
