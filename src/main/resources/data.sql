insert into course(id, fullname,created_date,last_updated_date) VALUES(10001,'JPA in 50 steps', sysdate(), sysdate());
insert into course(id, fullname,created_date,last_updated_date) VALUES(10002,'Spring in 50 steps', sysdate(), sysdate());
insert into course(id, fullname,created_date,last_updated_date) VALUES(10003,'Spring Boot in 100 steps', sysdate(), sysdate());
insert into course(id, fullname,created_date,last_updated_date) VALUES(10004,'Dummy 1', sysdate(), sysdate());
insert into course(id, fullname,created_date,last_updated_date) VALUES(10005,'Dummy 2', sysdate(), sysdate());
insert into course(id, fullname,created_date,last_updated_date) VALUES(10006,'Dummy 3', sysdate(), sysdate());
insert into course(id, fullname,created_date,last_updated_date) VALUES(10007,'Dummy 4', sysdate(), sysdate());
insert into course(id, fullname,created_date,last_updated_date) VALUES(10008,'Dummy 5', sysdate(), sysdate());

insert into passport(id, name) VALUES(40001,'E123456');
insert into passport(id, name) VALUES(40002,'N123457');
insert into passport(id, name) VALUES(40003,'L123890');

insert into student(id, name, passport_id) VALUES(20001,'Ranga',40001);
insert into student(id, name, passport_id) VALUES(20002,'Adam',40002);
insert into student(id, name, passport_id) VALUES(20003,'Jame',40003);



insert into review(id, rating, description, course_id) VALUES(50001,'5','Great Course',10001);
insert into review(id, rating, description, course_id) VALUES(50002,'4','Wonderful Course',10001);
insert into review(id, rating, description, course_id) VALUES(50003,'5','Awesome Course', 10003);

insert into student_course(student_id, course_id) VALUES(20001,10001);
insert into student_course(student_id, course_id) VALUES(20002,10001);
insert into student_course(student_id, course_id) VALUES(20003,10001);
insert into student_course(student_id, course_id) VALUES(20001,10003);