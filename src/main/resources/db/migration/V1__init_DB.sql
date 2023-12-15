create sequence bucket_seq start with 1 increment by 1;
create sequence category_seq start with 1 increment by 1;
create sequence order_details_seq start with 1 increment by 1;
create sequence order_seq start with 1 increment by 1;
create sequence products_seq start with 1 increment by 1;
create sequence reviews_seq start with 1 increment by 1;
create sequence user_seq start with 1 increment by 1;
create table buckets
(
    id      bigint not null,
    user_id bigint unique,
    primary key (id)
);
create table buckets_products
(
    bucket_id  bigint not null,
    product_id bigint not null
);
create table categories
(
    id    bigint not null,
    title varchar(255),
    primary key (id)
);
create table orders
(
    sum     numeric(38, 2),
    updated timestamp,
    id      bigint not null,
    created timestamp,
    user_id bigint,
    address varchar(500),
    status  varchar(255) check (status in ('NEW', 'APPROVED', 'CANCELED', 'PAID', 'CLOSED')),
    primary key (id)
);
create table orders_details
(
    amount     integer,
    price      numeric(38, 2),
    details_id bigint not null unique,
    id         bigint not null,
    order_id   bigint,
    product_id bigint,
    primary key (id)
);
create table product_documentation
(
    file_size          bigint,
    product_id         bigint not null,
    content_type       varchar(255),
    original_file_name varchar(255),
    storage_object_id  varchar(255),
    storage_path       varchar(255)
);
create table products
(
    amount          integer,
    price           numeric(38, 2),
    id              bigint  not null,
    title           varchar(500),
    characteristics varchar(1500),
    description     varchar(1500),
    primary key (id)
);
create table products_categories
(
    category_id bigint not null,
    product_id  bigint not null
);
create table reviews
(
    id         bigint not null,
    product_id bigint,
    comment    varchar(1500),
    username   varchar(255),
    primary key (id)
);
create table users
(
    archive   boolean not null,
    bucket_id bigint unique,
    id        bigint  not null,
    email     varchar(255),
    name      varchar(255),
    password  varchar(255),
    role      varchar(255) check (role in ('CLIENT', 'MANAGER', 'ADMIN')),
    primary key (id)
);
alter table if exists buckets add constraint fk_buckets_users foreign key (user_id) references users;
alter table if exists buckets_products add constraint fk_buckets_products_products foreign key (product_id) references products;
alter table if exists buckets_products add constraint fk_buckets_products_buckets foreign key (bucket_id) references buckets;
alter table if exists orders add constraint fk_orders_users foreign key (user_id) references users;
alter table if exists orders_details add constraint fk_orders_details_orders foreign key (order_id) references orders;
alter table if exists orders_details add constraint fk_orders_details_products foreign key (product_id) references products;
alter table if exists orders_details add constraint fk_orders_details_details foreign key (details_id) references orders_details;
alter table if exists product_documentation add constraint fk_product_documentation_products foreign key (product_id) references products;
alter table if exists products_categories add constraint fk_products_categories_categories foreign key (category_id) references categories;
alter table if exists products_categories add constraint fk_products_categories_products foreign key (product_id) references products;
alter table if exists reviews add constraint fk_reviews_products foreign key (product_id) references products;
alter table if exists users add constraint fk_users_buckets foreign key (bucket_id) references buckets;