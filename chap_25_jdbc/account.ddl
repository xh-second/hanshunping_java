CREATE TABLE ACCOUNT(
   id int primary key auto_increment,
   name varchar(32) not null default '',
   balance double not null default 0
) ENGINE=Innodb charset=utf8;

insert into account values(null,'马云',3000);
insert into account values(null,'马化腾',10000);