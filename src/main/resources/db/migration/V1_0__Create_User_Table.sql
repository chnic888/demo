create table user
(
	id int auto_increment,
	name varchar(32) not null,
	gender int not null,
	birthday date not null,
	mobile varchar(20) not null,
	email varchar(50) null,
	remark varchar(100) null,
	constraint user_pk
		primary key (id)
);