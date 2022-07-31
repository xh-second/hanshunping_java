CREATE TABLE admin2(
    name varchar(32) not null unique,
    pwd varchar(32) not null default ''
) ENGINE=Innodb CHARSET=utf8;