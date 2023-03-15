drop database if exists jspweb;
create database jspweb;
use jspweb;

drop table if exists member;
create table member(
	mno int auto_increment primary key, # 멤버번호
    mid varchar(30) not null unique,	# 아이디
    mpwd varchar(20) not null,			# 비번
    mimg  longtext ,		 			# 서버에 저장된 사진 경로 
    memail varchar(100) 				# 이메일
);

drop table if exists friend;
create table friend(
	fno int auto_increment primary key, #식별 번호
    ffrom int,	# 친구 신청한 사람
    fto int,	# 친구 신청 받은 사람
    foreign key (ffrom) references member(mno) on delete set null,
    foreign key (fto) references member(mno) on delete set null
);

drop table if exists mpoint;
create table mpoint(
	mpno int auto_increment primary key ,	# 포인트 내역 식별
    mpcomment varchar(1000) not null,		# 포인트 내역 내용
    mpamount int default 0,					# 포인트 수량
    mpdate datetime default now(),			# 포인트 받은날
    mno	int ,								# 포인트 주인
    foreign key (mno) references member(mno) on delete set null
);
select * from member  where mid ='qwe123' and mpwd='qwe123';
select * from member;
select * from friend;
select * from mpoint;

delete from member where mid = 'qwe123' and mpwd='qwe123';

select m.mno , m.mid , m.mimg , m.memail , sum(p.mpamount) as mpoint from member m , mpoint p where m.mno = p.mno and m.mid = 'qwe123';
                

# insert into member (mid,mpwd) values ('qwe','qwe');
# insert into member (mid,mpwd,ming,memail) values ('qwe123','qwe123','2.png','memail');

select * from member m , mpoint p where m.mno = p.mno;

# 포인트 삽입
# insert into mpoint(  mpcomment,  mpamount , mno ) values('회원가입축하',100,1);
# insert into mpoint(  mpcomment,  mpamount , mno ) values('포인트결제구매',5000,1);
# insert into mpoint(  mpcomment,  mpamount , mno ) values('제품구매',-3000,1);
# insert into mpoint(  mpcomment,  mpamount , mno ) values('회원가입축하',100,2);


select * from mpoint where mno = 1;
select * from mpoint where mno = 2;

#포인트 총합
select sum(mpamount) from mpoint ; # 전체
select sum(mpamount) from mpoint where mno=1; #1만

select * from member m , mpoint p where  m.mno = p.mno;

select * from member m natural join mpoint; # 암묵적 결합

#포인트별 집계 
select m.mno , m.mid , m.mimg , m.memail , sum(p.mpamount) as mpoint
from member m , mpoint p 
where m.mno = p.mno and m.mno = 2;



# 특정 1명 회원정보