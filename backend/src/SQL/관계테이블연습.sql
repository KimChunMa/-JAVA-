/*
	메모리
		주기억 장치 : RAM 휘발성 전기O 저장O - 현재 실행중인 명령어
			- jvm , 게임중
        보조기억장치 : ROM 비휘발벙 전기X 저장O - 모든 명령어 저장
			-DB , 파일 ,c드라이브 , cd , use , 게임설치
            
    데이터베이스 
		1. 데이터 베이스 [자료모임] -> 표 -> 관계형[열/행] 데이터 베이스
        2. [워드, 엑셀, 한글] 마우스 표 제작 vs [데이터베이스] 대화식[명령어] 표 제작
        
        pk(primary key | 기본키 ): 중복,null X , 효율적일것
        
        fk(foreign key | 외래캐): 중복O, pk내 데이터만 가능[무결성]
        
*/
drop database if exists 관계테이블연습;
create database 관계테이블연습;
use 관계테이블연습;

drop table if exists 회원;
create table 회원(회원번호 int primary key , 아이디 varchar(20),비밀번호 varchar(10)  );

drop table if exists 제품;
create table 제품(제품번호 int primary key , 제품이름 varchar(20), 제품가격 int  );

drop table if exists 구매내역;
create table 구매내역( 
	구매번호 int primary key , 
    구매일자 datetime, 
    회원번호_fk int,
    제품번호_fk int,
	foreign key(회원번호_fk) references 회원(회원번호),
    foreign key(제품번호_fk) references 제품(제품번호)
    );
