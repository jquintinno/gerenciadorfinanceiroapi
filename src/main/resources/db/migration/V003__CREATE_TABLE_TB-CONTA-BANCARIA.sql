create table if not exists tb_conta_bancaria (
	codigo bigserial not null,
	id_pessoa_conta_bancaria serial not null,
	id_pessoa_titular serial not null,
	numero varchar(20) not null unique,
	agencia varchar(10) not null unique,
	data_inicio_contrato date null,
	data_fim_contrato date null,
	constraint pk_conta_bancaria primary key (codigo),
	constraint fk_pessoa_conta_bancaria foreign key (id_pessoa_conta_bancaria) references tb_pessoa (codigo),
	constraint fk_pessoa_titular foreign key (id_pessoa_titular) references tb_pessoa (codigo)
);