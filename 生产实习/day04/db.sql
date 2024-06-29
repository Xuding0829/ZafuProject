#创建库
create database emp charset=utf8;
#进入库
use emp;
#创建雇员表
create table t_emp(
 id int primary key auto_increment,
 name varchar(25),
 salary decimal(10,2),
 job  varchar(25)
);
#添加数据
INSERT INTO t_emp VALUES(null,'tom',31000,'manager');
  alter table t_emp add pwd varchar(25);
  update t_emp set pwd='123'