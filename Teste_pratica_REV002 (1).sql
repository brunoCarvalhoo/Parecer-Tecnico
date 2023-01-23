create schema Teste_pratica_REV002;
use Teste_pratica_REV002;

create table if not exists equipamento (
	id int auto_increment,
	aparelho varchar(100),
	primary key (id)
);

create table if not exists cliente (
	id int auto_increment,
	nome_cliente varchar(100),
	data_insercao date,
	primary key (id)
);

create table if not exists defeito (
	id int auto_increment,
	tipo_defeito varchar(100),
	primary key (id)
);

create table if not exists tecnico (
	id int auto_increment,
	nome_tecnico varchar(100),
	primary key (id)
);

create table if not exists parecer (
	id int auto_increment,
	parecer varchar(500),
	marca varchar(100),
	id_defeito int, /* chave estrangeira  */
	id_tecnico int, /* chave estrangeira  */
	id_equipamento int, /* chave estrangeira  */
	id_cliente int, /* chave estrangeira  */
	primary key (id),
	constraint fk_id_defeito foreign key(id_defeito) references defeito(id), 
	constraint fk_id_tecnico foreign key(id_tecnico) references tecnico(id), 
	constraint fk_id_equipamento foreign key(id_equipamento) references equipamento(id),
	constraint fk_id_cliente foreign key(id_cliente) references cliente(id)
);

insert into equipamento (aparelho) values ('Smartphone');
insert into equipamento (aparelho) values ('Smartwhatch');
insert into equipamento (aparelho) values ('Smart TV');
insert into equipamento (aparelho) values ('Tablet');
insert into equipamento (aparelho) values ('Notebook');

insert into defeito (tipo_defeito) values ('tela');
insert into defeito (tipo_defeito) values ('display');
insert into defeito (tipo_defeito) values ('não liga/carrega');
insert into defeito (tipo_defeito) values ('Sem sinal');
insert into defeito (tipo_defeito) values ('Software');
insert into defeito (tipo_defeito) values ('Oxidação');
insert into defeito (tipo_defeito) values ('Carcaça');
insert into defeito (tipo_defeito) values ('Botão');
insert into defeito (tipo_defeito) values ('Alto-falante');
insert into defeito (tipo_defeito) values ('Fonte de energia')
