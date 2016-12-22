create database customer;

use customer;

--Customer Registration
create table customer_registration (
customer_id varchar(150) not null,
name varchar(50) not null,
email_id varchar(50) not null,
contact_number varchar(10) not null,
rating int(2),
labelled_address varchar(255),
status varchar(10) not null,
created_on datetime(3) not null,
updated_on datetime(3) not null,
constraint pk_customer_id primary key (customer_id),
KEY email_id_idx (email_id)
);