
    create table project1.users (
        token_expires_on date,
        token_issued_on date,
        user_id integer generated by default as identity,
        name varchar(255),
        password varchar(255),
        role varchar(255),
        token_id varchar(255),
        token_password varchar(255),
        primary key (user_id)
    );
