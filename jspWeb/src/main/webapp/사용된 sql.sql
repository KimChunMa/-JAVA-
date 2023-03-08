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

select * from member;
select * from friend;
select * from mpoint;

