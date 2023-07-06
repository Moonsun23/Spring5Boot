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