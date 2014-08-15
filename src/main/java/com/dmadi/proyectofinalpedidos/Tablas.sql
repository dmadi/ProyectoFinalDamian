create table zona (id_zona  integer primary key auto_increment,
                     nombre varchar(80));


create table vendedor (id_vendedor  integer primary key auto_increment,
                     nombre varchar(80),
                     edad varchar(80));

create table pedidos (id_pedidos integer primary key auto_increment, id_vendedor integer, producto varchar(80),
                           cantidad  float, precio float,
                           foreign key (id_vendedor) references  
                            vendedor (id_vendedor));