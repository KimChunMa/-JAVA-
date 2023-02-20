/*
	- 테이블 [표 - 열[필드/속성] 행[레코드] ]
		*여러개의 자료들을 효율적 관리하기위해 관계형 데이터베이스 [표]
        
       -필드1[얄1 - colum]
        아이디	비밀번호
        qwe		qwe			- 레코드 1 [행1 - row]
        asd		asd			- 레도크 2 [행2]
        zxc		zxc			- 레도크 3 [행3]
        
	- 빌드 타입
		1.정수형 : int			: 정수
        2.문자형 : varchar(길이)	: 길이 만큼 문자열 저장가능
        3.실수형 : float, double	: 실수
        4.날짜형 : data, time, datatime
        5.대용량 : text
*/

#테이블 생성 [데이터베이스 선택]

create database java;		-- 1. 데이터베이스 생성
use java;					-- 2. 데이터베이스 선택
create table member(		-- 3. 선택된 데이터베이스의 표 만들기
	
#   필드명 타입 키워드
	아이디 text,
    비밀번호 text
);

# create : 생성 , table: 테이블 , member : 테이블명[아무거나]
# create table 테이블명 (필드명 타입 제약조건 , ...);

#테이블 검색
select * from member;
# select : 검색 	*: 모든 필드 [와일드카드]		from 테이블명
# select 필드명 from 테이블명 ; 


create database java;		
use java;	
create table member2(아이디 text,비밀번호 text);
select * from member2;
 
create database java;		
use java;	
create table member3(아이디 text,비밀번호 text);
select * from member3;


drop table member;
drop table member2;
drop table member3;
drop table java;

/*
	문제 1 : 웹개발 하는데 DB저장소 [스키마] 'jsp' 이름으로 생성
    1. 테이블 2개  [member,board]
    2.member 필드 id,pw
    3.board  필드 title, content
    
*/

create database jsp;
use jsp;
create table member(id varchar(100), pw varchar(100));
create table board(title varchar(100), content varchar(100));
select * from member;
select * from board;
drop database jsp;

/*
	문제2
	1. spring 데이터베이스 생성
    2. member 테이블 생성 [회원번호[정수], id[문자(20) , pw[문자(20)]  ]
    3. product 테이블 생성 [제품번호[정수], name[문자열(30)], price[정수]  ]
    4. 생성한 테이블 2개 검색[확인]
    5.데이터베이스 삭제
    
*/

create database sping;
use sping;
create table member(회원번호 int , id varchar(20) , pw varchar(20) ) ;
create table product(제품번호 int , name varchar(30) , price int ) ;
select * from member;
select * from product;
drop database sping;

