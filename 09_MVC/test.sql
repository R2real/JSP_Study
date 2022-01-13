select * from all_tables;

drop table board;

create table board(
	bid int primary key,
	writer varchar(20) not null,
	title varchar(30) not null,
	content varchar(50) not null
);

select * from board;

insert into board values(1,'작성자','제목','내용');
insert into board values(2,'티모','탑갈사람','버섯농장');

create table customer(
	customer_number int primary key,
	customer_id varchar(20) not null,
	customer_password varchar(20) not null,
	customer_name varchar(20) not null,
	customer_number varchar(20) not null,
	zip_code varchar(20) not null,
	detailed_address varchar(50) not null
);