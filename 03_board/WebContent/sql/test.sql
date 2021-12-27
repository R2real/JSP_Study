select * from all_tables;

create table member(
   mid varchar(20) primary key,
   mpw varchar(20) not null,
   mname varchar(15) not null
);
create table board(
   bid int primary key,
   mid varchar(20) not null,
   msg varchar(50) not null,
   favcnt int default 0
);
create table reply(
   rid int primary key,
   bid int not null,
   mid varchar(20) not null,
   rmsg varchar(30) not null,
   constraint board_fk foreign key(bid) references board(bid) on delete cascade
);

insert into board values(1,'아이디1','메세지1',0);
insert into board values(2,'아이디2','메세지2',0);
insert into board values(3,'아이디3','메세지3',0);
insert into board values(4,'아이디1','1',0);
insert into board values(5,'아이디1','2',0);
insert into board values(6,'아이디1','3',0);
insert into board values(7,'아이디1','4',0);
insert into board values(8,'아이디1','5',0);
insert into board values(9,'아이디1','6',0);
select * from board;
insert into reply values(1,1,'아이디4','메세지4');
insert into reply values(2,1,'아이디5','메세지5');
insert into reply values(3,3,'아이디6','메세지6');
insert into reply values(4,1,'아이디1','!!!');
select * from reply;
select * from member;

insert into member values('아이디1',1234,'이름아이디');

drop table member;
drop table board;