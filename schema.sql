create database second_hand;

use second_hand;

create table postings(
    posting_id varchar (64),

    posting_date date not null,

    name varchar(64) not null,

    email varchar(128),

    phone varchar(64),

    title varchar(256),

    description text,

    image varchar (256)
)