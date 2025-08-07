create table item (
item_name varchar2(30),
item_category varchar2(24),
item_price number,
item_sale number,
item_count number,
item_dilivery char(1)
);

insert into item (item_name, item_category, item_price, item_sale, item_count, item_dilivery) values ('비김면', '라면', 16800, null, 2, 'y');
insert into item (item_name, item_category, item_price, item_sale, item_count, item_dilivery) values ('크림대빵', '제과', 6500, null, 2, 'n');
insert into item (item_name, item_category, item_price, item_sale, item_count, item_dilivery) values ('점보도시락', '라면', 8500, 5, 3, 'y');
insert into item (item_name, item_category, item_price, item_sale, item_count, item_dilivery) values ('공간춘', '라면', 12300, 20, 3, 'n');
