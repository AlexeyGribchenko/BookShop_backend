create sequence t_order_seq start with 1 increment by 1;
create sequence t_product_seq start with 1 increment by 1;
create sequence t_user_seq start with 1 increment by 1;

create table t_book (
    id bigint not null,
    author varchar(255),
    description varchar(2048),
    img_name varchar(255),
    name varchar(255),
    price integer,
    primary key (id)
);

create table t_cart (
    usr_id bigint not null,
    book_id bigint not null
);

create table t_order (
    id bigint not null,
    order_date timestamp(6),
    total_price integer,
    user_id bigint,
    primary key (id)
);

create table t_order_books (
    order_id bigint not null,
    book_id bigint not null
);

create table t_user (
    id bigint not null,
    active boolean,
    birth_date timestamp(6),
    first_name varchar(255),
    last_name varchar(255),
    password varchar(255),
    profile_picture_name varchar(255),
    username varchar(255),
    primary key (id)
);

create table t_usr_role (
    usr_id bigint not null,
    roles varchar(255)
);

create table t_wishlist (
    usr_id bigint not null,
    book_id bigint not null
);

alter table if exists t_cart
    add constraint book_cart_fk
    foreign key (book_id) references t_book;

alter table if exists t_cart
    add constraint cart_user_fk
    foreign key (usr_id) references t_user;

alter table if exists t_order
    add constraint order_user_fk
    foreign key (user_id) references t_user;

alter table if exists t_order_books
    add constraint order_book_fk
    foreign key (book_id) references t_book;

alter table if exists t_order_books
    add constraint book_order_fk
    foreign key (order_id) references t_order;

alter table if exists t_usr_role
    add constraint user_role_user_fk
    foreign key (usr_id) references t_user;

alter table if exists t_wishlist
    add constraint wishlist_book_fk
    foreign key (book_id) references t_book;

alter table if exists t_wishlist
    add constraint wishlist_user_fk
    foreign key (usr_id) references t_user;