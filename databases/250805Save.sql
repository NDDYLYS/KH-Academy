insert into pokemon(no, name, type) values(4, '파이리', '불');

select * from pokemon;

select * from country;

UPDATE country SET COUNTRY_POPULATION = 250000000
WHERE COUNTRY_NAME  = '미국';

select * from item;

drop table item;

create table medalist (
medalist_name varchar2(10),
medalist_category varchar2(10),
medalist_event varchar2(20),
medalist_gold number(4),
medalist_silver number(4),
medalist_bronze number(4)
);


create table item (
item_name varchar2(30) not null unique,
item_category varchar2(24) not null,
item_price number not null,
item_sale number null,
item_count number not null,
item_dilivery char(1) not null
);

create table country (
country_name varchar2(60),
country_capital varchar2(45),
country_population number
);

create table item (
item_name varchar2(30) not null unique,
item_category varchar2(24) not null,
item_price number not null,
item_sale number null,
item_count number not null,
item_dilivery char(1) not null,
check (regexp_like(item_name, '^[가-힣0-9A-Za-z]{1,20}$')),
check (item_category in ('제과', '라면', '음료')),
check (item_price >= 0),
check (item_sale >= 0 and item_sale <= 100),
check (item_count >= 0)
);

insert into item (item_name, item_category, item_price, item_sale, item_count, item_dilivery) values ('비김면', '라면', 16800, null, 2, 'y');
insert into item (item_name, item_category, item_price, item_sale, item_count, item_dilivery) values ('크림대빵', '제과', 6500, null, 2, 'n');
insert into item (item_name, item_category, item_price, item_sale, item_count, item_dilivery) values ('점보도시락', '라면', 8500, 5, 3, 'y');
insert into item (item_name, item_category, item_price, item_sale, item_count, item_dilivery) values ('공간춘!@', '숙주', 12300, 20, 3, 'n');


insert into country (country_name, country_capital, country_population) values ('한국', '서울', 50000000);
insert into country (country_name, country_capital, country_population) values ('일본', '도쿄', 120000000);
insert into country (country_name, country_capital, country_population) values ('중국', '베이징', 1400000000);
insert into country (country_name, country_capital, country_population) values ('미국', '워싱턴', 25000000);


insert into medalist (name, category, event, gold, silver, bronze) values ('진종오', '하계', '사격', 4, 2, 0);
insert into medalist (name, category, event, gold, silver, bronze) values ('김수녕', '하계', '양궁', 4, 1, 1);
insert into medalist (name, category, event, gold, silver, bronze) values ('김우진', '하계', '양궁', 5, 0, 0);
insert into medalist (name, category, event, gold, silver, bronze) values ('전이경', '동계', '쇼트트랙', 4, 0, 1);


insert into medalist (medalist_name, medalist_category, medalist_event, medalist_gold, medalist_silver, medalist_bronze) values ('진종오', '하계', '사격', 4, 2, 0);
insert into medalist (medalist_name, medalist_category, medalist_event, medalist_gold, medalist_silver, medalist_bronze) values ('김수녕', '하계', '양궁', 4, 1, 1);
insert into medalist (medalist_name, medalist_category, medalist_event, medalist_gold, medalist_silver, medalist_bronze) values ('김우진', '하계', '양궁', 5, 0, 0);
insert into medalist (medalist_name, medalist_category, medalist_event, medalist_gold, medalist_silver, medalist_bronze) values ('전이경', '동계', '쇼트트랙', 4, 0, 1);


create table phone (
phone_name varchar2(30) not null unique,
phone_telecom varchar2(12) not null,
phone_price number not null,
phone_agreement varchar2(12) null,
check (regexp_like(phone_name, '^[가-힣0-9A-Za-z]{1,10}$')),
check (phone_telecom in ('SK', 'KT', 'LG', '알뜰폰')),
check (phone_price >= 0),
check (phone_agreement in ('미설정', '24개월', '30개월', '36개월'))
);

drop table phone;

create table phone (
phone_name varchar2(30) not null,
phone_telecom varchar2(12) not null,
phone_price number not null,
phone_agreement varchar2(12) null,
check (regexp_like(phone_name, '^[가-힣0-9A-Za-z]{1,10}$')),
check (phone_telecom in ('SK', 'KT', 'LG', '알뜰폰')),
check (phone_price >= 0),
check (phone_agreement in ('미설정', '24개월', '30개월', '36개월'))
);

insert into phone (phone_name, phone_telecom, phone_price, phone_agreement) values ('갤럭시Fold7', 'SK', 2200000, '미설정');
insert into phone (phone_name, phone_telecom, phone_price, phone_agreement) values ('갤럭시Fold7', 'KT', 2150000, '24개월'); 
insert into phone (phone_name, phone_telecom, phone_price, phone_agreement) values ('아이폰17', 'LG', 2100000, '36개월');
insert into phone (phone_name, phone_telecom, phone_price, phone_agreement) values ('아이폰17', 'SK', 2150000, '미설정');

insert into phone (phone_name, phone_telecom, phone_price, phone_agreement) values ('갤럭시Fold7a!@@#', 'SLT', 100, '30000');

create table goods (
goods_name varchar2(60),
goods_price number,
// 알까지 지정할 경우
goods_begin timestamp,
goods_end timestamp,
goods_reg timestamp
);

create table goods (
goods_name varchar2(60),
goods_price number,
goods_begin timestamp,
goods_end timestamp,
goods_reg timestamp default systimestamp
);
Date, TimeStamp

// 날짜 등록시 문자열 변환 명령 사용

// date -> to_date(항목, 형식)
// timestamp -> to_timestamp(항목, 형식)
// 현재 시간을 구해주는 도구 (sysdate, systimestamp)

drop table goods;
select * from goods;
insert into goods (goods_name, goods_price, goods_begin, goods_end, goods_reg) values 
('이름', 1000, to_timestamp('2025-08-09 09:00:00', 'YYYY-MM-DD HH24:MI:SS'), to_timestamp('2025-08-31 18:00', 'YYYY-MM-DD HH24:MI'), systimestamp);


