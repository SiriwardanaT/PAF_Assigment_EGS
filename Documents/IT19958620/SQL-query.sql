use powergriddb;
create table customer (
    id  int not null primary key auto_increment,
    firstName varchar(50) not null,
    lastName varchar(50) not null,
    Nic  varchar(12) not null,
    email varchar(20) not null,
    Street varchar(10) not null,
    state varchar(10) not null,
    postalCode varchar(10) not null,
    status int not null,
    createBy int,
    createDate datetime,
    modifiedBy int,
    modifiedDate datetime
);
create table user (
     id int not null primary key auto_increment,
     password varchar(30) not null,
     role varchar(20) not null,
     Uid int not null,
     status int not null,
     createBy int,
     createDate datetime ,
     modifiedBy int ,
     modifiedDate datetime ,
     FOREIGN KEY (Uid) REFERENCES customer(id)
);
create table accounts (
   Macc varchar(50) not null primary key,
   install_address varchar(30),
   install_date datetime,
   Uid  int,
   FOREIGN KEY (Uid) REFERENCES customer(id)
);
create table consumption (
    id  int not null primary key auto_increment,
    units float not null,
    date datetime not null,
    unitPrice float not null,
    lsReading int not null,
    cuReading int not null,
    Macc varchar(50) not null,
    status int not null,
    createBy int,
    createDate datetime,
    modifiedBy int,
    modifiedDate datetime,
    FOREIGN KEY (Macc) REFERENCES accounts(Macc)
);
create table payment (
    id int not null primary key auto_increment,
    amount float not null,
    date datetime not null ,
    Cid int not null,
    pStatus int,
    IsApproved boolean not null,
    status int not null,
    createBy int,
    createDate datetime,
    modifiedBy int,
    modifiedDate datetime,
    FOREIGN KEY (Cid) REFERENCES consumption(id)
);
create table Inquery (
    id int not null primary key auto_increment,
    subject varchar(20) not null,
    content varchar(30) not null,
    uid int not null,
    status int not null,
    createBy int,
    createDate datetime,
    modifiedBy int,
    modifiedDate datetime,
    FOREIGN KEY (uid) REFERENCES customer(id)
);

insert into customer values ('')



select * from consumption
select cuReading from consumption where Macc = 'AC3000' order by id desc limit 1







