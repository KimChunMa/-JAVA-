# 데이터베이스
drop database if exists boardDb;
create database boardDb;
use boardDb;

# 테이블1
drop table if exists member;
create table member(
	mno  int  auto_increment primary key , # 멤버 번호
    mid varchar(20) not null unique,	# 멤버 아이디
    mpw varchar(10) not null,			# 멤버 패스워드
    mname varchar(30) not null,			# 멤버 이름
    mphone varchar(13) not null			# 멤버 전화번호
);

# 테이블2
drop table if exists category;
create table category(
	cno int auto_increment primary key, 	# 카테고리 번호
    cname varchar(20) not null				# 카테고리 이름
);

# 테이블3
drop table if exists board;
create table board(
	bno int auto_increment primary key, 		# 게시물 번호
    btitle varchar(1000) not null,				# 게시물 제목
    bcontent longtext not null,					# 게시물 내용
    bdate datetime default now() ,				# 게시물 날짜 insert시 날짜/시간대입
    bview int default 0	,						# 조회수
    mno_fk int,									# 멤버 번호
    cno_fk int,									# 카테고리 번호
    foreign key (mno_fk ) references member(mno) on delete set null,	# 회원탈퇴시 널
    foreign key (cno_fk ) references category(cno) on delete cascade	#회원탈퇴시 삭제
);

drop table if exists reply;
create table reply(
	rno int auto_increment primary key,			# 댓글 번호
    rcontent text not null ,					# 댓글 내용
    rdate datetime default now(),				# 댓글 시간
    rindex int ,								# (최상위0, 1~ : 댓글 번호의 대댓글)
	mno_fk int,									# 멤버 번호
    bno_fk int,									# 게시물 번호
    
    foreign key (mno_fk ) references member(mno) on delete set null,	# 회원탈퇴시 널
    foreign key (bno_fk ) references board(bno) on delete cascade	#회원탈퇴시
);