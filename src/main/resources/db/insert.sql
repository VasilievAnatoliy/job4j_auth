insert into employee (name, lastname, inn, hired)
            values ('Petr', 'Petrov', '1088547689','2021-07-10T10:15:33.177+00:00');
insert into employee (name, lastname, inn, hired)
            values ('Ivan', 'Ivanov', '5400048812','2022-01-24T09:30:33.177+00:00');
insert into employee (name, lastname, inn, hired)
            values ('Boris', 'Sidorov', '1894484744','2021-08-04T12:03:33.177+00:00');

insert into person (login, password) values ('parsentev', '123');
insert into person (login, password) values ('petrov', '123');
insert into person (login, password) values ('ban', '123');
insert into person (login, password) values ('ivan', '123');

insert into employee_person (employee_id, person_id) values ('1', '1');
insert into employee_person (employee_id, person_id) values ('1', '2');
insert into employee_person (employee_id, person_id) values ('2', '3');
insert into employee_person (employee_id, person_id) values ('3', '4');