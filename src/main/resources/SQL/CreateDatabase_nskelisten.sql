use wishlist;
#SET foreign_key_checks = 0;
#drop table if exists users;
#drop table if exists wishes;
#drop table if exists wishlists;
#SET foreign_key_checks = 1;
create table if not exists users
(
    userID   int auto_increment
    primary key,
    username varchar(16) not null,
    password varchar(32) not null,
    constraint userName_UNIQUE
    unique (username)
    )
    charset = big5;

create table if not exists wishlists
(
    wishlistID	int		auto_increment		not null
    primary key,
    userID      int          null,
    list_name			varchar(50) not null,
    description varchar(160) null,
    foreign key (userID) references users(userID)
    );

create table if not exists wishes
(
    wishID          int          not null
    primary key,
    wishlistID      int          null,
    item_name   varchar(45)  not null,
    price_dkk   int          null,
    url         varchar(500)  null,
    description varchar(160) null,
    foreign key (wishlistID) references wishlists(wishlistID)
    );

