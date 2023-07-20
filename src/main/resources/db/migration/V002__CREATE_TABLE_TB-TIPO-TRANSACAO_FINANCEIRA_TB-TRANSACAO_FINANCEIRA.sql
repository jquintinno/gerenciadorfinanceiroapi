create table if not exists tb_tipo_transacao_financeira (
	codigo bigserial not null,
	descricao varchar(100) not null unique,
	constraint pk_tipo_transacao_financeira primary key (codigo)
);

create table if not exists tb_transacao_financeira (
	codigo bigserial not null,
	id_tipo_transacao_financeira serial not null,
	id_pessoa_transacao_financeira serial not null,
	id_pessoa_responsavel serial not null,
	identificador varchar(50) not null,
	quantidade_parcela integer not null,
	data_hora_cadastro timestamp not null,
	valor_unitario decimal(9,2) not null, 
	dia_vencimento integer null,
	e_recorrente boolean not null,
	e_totalmente_pago boolean not null,
	observacao varchar(255),
	constraint pk_transacao_financeira primary key (codigo),
	constraint fk_tipo_transacao_financeira foreign key (id_tipo_transacao_financeira) references tb_tipo_transacao_financeira (codigo),
	constraint fk_pessoa_transacao_pessoa foreign key (id_pessoa_transacao_financeira) references tb_pessoa (codigo),
	constraint fk_pessoa_responsavel foreign key (id_pessoa_responsavel) references tb_pessoa (codigo)
);

insert into tb_tipo_transacao_financeira (descricao) values ('Receita Fixa');
insert into tb_tipo_transacao_financeira (descricao) values ('Receita Variável');
insert into tb_tipo_transacao_financeira (descricao) values ('Despesa Fixa');
insert into tb_tipo_transacao_financeira (descricao) values ('Despesa Variável');
insert into tb_tipo_transacao_financeira (descricao) values ('Concessão de Empréstimo (Pessoa Física)');
insert into tb_tipo_transacao_financeira (descricao) values ('Adquirição de Empréstimo (Pessoa Física)');
insert into tb_tipo_transacao_financeira (descricao) values ('Adquirição de Empréstimo (Pessoa Jurídica)');
