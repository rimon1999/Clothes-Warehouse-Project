create table if not exists ItemModel (
  id int not null auto_increment,
  name varchar(255) not null,
  price decimal not null,
  yearOfCreation int not null,
  brandForm varchar(255) not null,
  primary key (id)
);


