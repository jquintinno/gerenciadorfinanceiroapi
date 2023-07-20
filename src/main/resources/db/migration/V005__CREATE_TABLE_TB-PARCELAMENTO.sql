create table if not exists tb_parcelamento (
	codigo bigserial not null,
	identificador varchar(50) not null unique,
	numero varchar(20) not null,
	valor decimal(9,2) not null,
	data_vencimento date null,
	data_pagamento date null,
	constraint pk_parcelamento primary key (codigo)
);