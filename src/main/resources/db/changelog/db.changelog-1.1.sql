-- liquibase formatted sql
-- changeset tienva:1.1

create table "inventory"
(
    id bigserial
        constraint inventory_pk
            primary key,
    sku_code varchar(255),
    quantity integer,
    created_at timestamp default now(),
    updated_at timestamp default now(),
    is_deleted boolean default false
);




