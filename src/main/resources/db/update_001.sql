drop table employee_person;
drop table person;
drop table employee;

create table if not exists employee (
    id serial primary key,
    name        varchar(2000),
    lastname    varchar(2000),
    inn         bigint,
    hired       timestamp
);

create table if not exists person (
    id serial primary key,
    login       varchar(2000),
    password    varchar(2000)
);

create table if not exists employee_person(
    employee_id int not null references employee(id),
    person_id int not null references person(id)
);
