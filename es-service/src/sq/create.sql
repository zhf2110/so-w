create table user(
  id bigint(20) not null COMMENT '主键',
  name varchar(30) DEFAULT null COMMENT '姓名',
  age int(11) DEFAULT null COMMENT '年龄',
  email varchar(50) DEFAULT null COMMENT '邮箱',
  PRIMARY KEY (id)
) engine=InnoDB DEFAULT CHARSET=utf8;


insert into user(id,name,age,email)
VALUES
  (1,'永动机',15,'ydj@126.com'),
  (2,'孤帆及',15,'gfji@126.com'),
  (3,'骆驼该',15,'ltuoe@126.com'),
  (4,'你是水',15,'nishil@126.com'),
  (5,'我是谁',15,'gesl@126.com'),
  (6,'他们雅',15,'gesex@126.com');