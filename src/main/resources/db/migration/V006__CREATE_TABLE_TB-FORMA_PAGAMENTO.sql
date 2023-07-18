create table if not exists tb_forma_pagamento (
	codigo bigserial not null,
	descricao varchar(100) not null unique,
	constraint pk_forma_pagamento primary key (codigo)
);