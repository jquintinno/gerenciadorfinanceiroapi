create table if not exists tb_produto_servico (
	codigo bigserial not null,
	nome varchar(100) not null unique,
	constraint pk_produto_servico primary key (codigo)
);

create table if not exists tb_transacao_financeira_produto_servico (
	codigo bigserial not null,
	id_transacao_financeira serial not null,
	id_produto_servico serial not null,
	valor float not null,
	constraint pk_transacao_financeira_produto_servico primary key (codigo),
	constraint fk_transacao_financeira foreign key (id_transacao_financeira) references tb_transacao_financeira (codigo),
	constraint fk_produto_servico foreign key (id_produto_servico) references tb_produto_servico (codigo)
);