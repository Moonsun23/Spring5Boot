-- member

create table member2 (
  mno                  int                  auto_increment,
  userid              varchar(18)       unique,
  passwd            varchar(18)       not null,
  name               varchar(10)       not null,
  email               varchar(50)       unique,
  zipcode            char(7)             not null,
  addr1              varchar(100)       not null,
  addr2              varchar(100)       not null,
  phone              varchar(15)        not null,
  regdate            datetime           default current_timestamp,
  primary key (mno)


);

insert into member2
    (userid, passwd, name, email, zipcode, addr1, addr2, phone)
values ('abc123','987xyz','hi1237','hi1237@gmail.com','12345','서울관하하하하','하입보이','010-333-3333');

select * from member2;

-- board
create table board2 (
    bno                     int                     auto_increment,
    title                    varchar(100)       not null,
    userid                  varchar(18)          not null,
    regdate                datetime             default current_timestamp,
    thumbs                 int                     default 0,
    views                   int                     default 0,
    contents               text                   not null,
    ipaddr                  varchar(15)           not null,
    primary key         (bno)
    -- ,foreign key (userid) references member2(userid)
);

alter table board2
    add constraint fkuid                -- 위에 foreign key 대신 여기 alter table로 써줘서 나중에 fkuid라는 값으로만 가져올 수 있게 해줌
        foreign key (userid) references member2 (userid);





INSERT INTO board2 (userid, title, contents, ipaddr)
VALUES ('abc123', '제리와톰', '내용내용내용','115.92.164.155');

INSERT INTO board2 (userid, title, contents, ipaddr)
VALUES ('abc456', '톰과제리', '내용내내용','115.92.164.155');

INSERT INTO board2 (userid, title, contents, ipaddr)
VALUES ('abc789', '공부해요공부', '내용내내내내내용','115.92.164.155');

INSERT INTO board2 (userid, title, contents, ipaddr)
VALUES ('abc123', '오늘은 비가와', '레이니즘레이니즘','115.92.164.155');

INSERT INTO board2 (userid, title, contents, ipaddr)
VALUES ('abc456', '내일도 비가와', '휴휴휴휴휴휴휴','115.92.164.155');

INSERT INTO board2 (userid, title, contents, ipaddr)
VALUES ('abc789', '우비를 입자', '더워죽겠어요','115.92.164.155');

select count(userid) cnt, ceil(count(userid) / 25) from board2;


select * from board2
where title like '%비가%';

-- pds

create table pds (
                     pno                     int                     auto_increment,
                     title                    varchar(100)       not null,
                     userid                  varchar(18)          not null,
                     regdate                datetime             default current_timestamp,
                     thumbs                 int                     default 0,
                     views                   int                     default 0,
                     contents               text                   not null,
                     ipaddr                  varchar(15)           not null,
                     primary key         (pno)

);

alter table pds
    add constraint fkpuid                -- 위에 foreign key 대신 여기 alter table로 써줘서 나중에 fkuid라는 값으로만 가져올 수 있게 해줌
        foreign key (userid) references member2 (userid);

create table pdsattach (
    pano                        int                         auto_increment,
    pno                         int                             not null,   -- 게시글 번호
    fname                       varchar(200)              not null,  --  파일 이름, 날짜도 포함됨, uuid 포함(식별코드/ 이름이 중복될 경우를 대비한 절대중복되지 않는 유일무이한 코드)
    ftype                        varchar(3)                 not null,  -- 파일 종류(jpg등)
    fsize                         float                         not null,
    fdown                       int                            default 0,  -- 다운로드
    primary key (pano)

);

alter table pdsattach
    add constraint fkpno                -- 위에 foreign key 대신 여기 alter table로 써줘서 나중에 fkuid라는 값으로만 가져올 수 있게 해줌
        foreign key (pno) references pds (pno);