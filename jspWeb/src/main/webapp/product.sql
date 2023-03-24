#제품 테이블 (가격, 설명, 위치, 상태, 조회수, 누가찜, 사진1~4, 쪽지내용)

# 제품 테이블
drop table if exists product;
create table product(
	pno int auto_increment primary key, #제품번호
    pname varchar(500) not null,# 제품명  
	pcomment text not null,#제품설명
    pprice bigint not null,#제품가격
    pstate int default 1, #상태 [1:판매중 2:거래중 3:판매완료]
    plat varchar(100) not null, #위도
    plng varchar(100) not null, #경도
    pview int default 0, #조회수
    pdate datetime default now() #등록일
);
select * from product;

# 찜하기
drop table if exists plike;								
create table plike (
	plinkno bigint auto_increment primary key, #식별키
    mno int, # 누가
    pno int,  # 어떤제품
    foreign key (mno) references member(mno),
    foreign key (pno) references product(pno)
);
select * from plike;
#사진 테이블

#찜하기 테이블

#쪽지 테이블