create table if not exists tb_tipo_pessoa (
	codigo bigserial not null,
	descricao varchar(50) not null unique,
	constraint pk_tipo_pessoa primary key (codigo)
);

create table if not exists tb_pessoa (
	codigo bigserial not null,
	id_tipo_pessoa serial not null,
	nome varchar(100) not null,
	constraint pk_pessoa primary key (codigo),
	constraint fk_tipo_pessoa foreign key (id_tipo_pessoa) references tb_tipo_pessoa (codigo)
);