create database java;
use java;
						   #자동번호 부여[pk] pk:식별용도 [중복x, 공백null x]
create table member(
mno int auto_increment primary key,
		#auto_increment : 자동번호 부여 [*pk도 같이써야됨]
        #primary key : 식별 용도 [중복x, 공백(null)x]
mid varchar(20),
mpw varchar(20),
mname varchar(10),
mphone varchar(13)
);

insert into member(mid, mpw , mname, mphone) values('qwe','qwe','유재석','010-4444-4444');
insert into member(mid, mpw , mname, mphone) values('asd','asd','강호동','010-5555-5555');

select * from member;	
				#조건 where절 : 
select * from member where mid = 'asd' and mpw='a'; 

select * from member where mno =3;
select * from member where mno =2;

#모든 회원 비밀번호 업뎃
update member set mpw = 'zxc';

#회원번호가 2 인 패스워드만
update member set mpw = 'zxc' where mno = 2;

#모든 회원 탈퇴
delete from member;
delete from member where mno = 2; #mno 2인 레코드 삭제