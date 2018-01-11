create database ums character set utf8 collate utf8_general_ci;

use ums;

create table t_user(
	user_id varchar(20) not null primary key, /*MEMO variable length QUESTION 20*/
    name varchar(20) not null,
    birth varchar(20) not null,
    address varchar(20) not null,
    pn varchar(20) not null,
    pw varchar(20) not null,
    status varchar(20) not null,
    updated varchar(20) not null
);

insert into t_user values('000a', 'applea', '1991/1/1a', '東京都a', '031112322a', '1234a', 'ACTVa', '6/2/17 14:29a');
/*insert into t_user values('a', 'a', 'a', 'a', 'a', 'a', 'a', 'a');*/
insert into t_user values('b', 'b', 'b', 'b', 'b', 'b', 'b', 'b');


create table t_role(
	user_id varchar(20) not null,
    roles varchar(20) not null, 
    primary key (user_id, roles),
	CONSTRAINT `aaaa` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`)

);

drop table t_role;

insert into t_role values('4545', 'ssssss');

select t_user.user_id, t_user.name, t_user.birth, t_user.address, t_user.pn, t_role.roles, t_user.status from t_user inner join t_role on t_user.user_id=t_role.user_id where t_user.user_id='4535';

