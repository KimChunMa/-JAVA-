/*
	- 테이블 [표 - 열[필드/속성] 행[레코드] ]
		*여러개의 자료들을 효율적 관리하기위해 관계형 데이터베이스 [표]
        
       -필드1[얄1 - colum]
        아이디	비밀번호
        qwe		qwe			- 레코드 1 [행1 - row]
        asd		asd			- 레도크 2 [행2]
        zxc		zxc			- 레도크 3 [행3]
*/

#테이블 생성 [데이터베이스 선택]

create database java;		-- 1. 데이터베이스 생성
use java;					-- 2. 데이터베이스 선택
create table member(		-- 3. 선택된 데이터베이스의 표 만들기
	
#필드명 타입 키워드
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