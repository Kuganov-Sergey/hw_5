create table restaurants
(
    id          int primary key auto_increment,
    name        varchar(20) unique not null,
    description varchar(255)       not null
);