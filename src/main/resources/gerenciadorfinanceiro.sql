drop table if exists flyway_schema_history cascade;
drop table if exists tb_tipo_pessoa cascade;
drop table if exists tb_pessoa cascade;
drop table if exists tb_tipo_transacao_financeira cascade;
drop table if exists tb_transacao_financeira cascade;
drop table if exists tb_parcelamento cascade;
drop table if exists tb_produto_servico cascade;
drop table if exists tb_transacao_financeira_produto_servico cascade;
drop table if exists tb_conta_bancaria cascade;
drop table if exists tb_pagamento cascade;
drop table if exists tb_forma_pagamento cascade;
drop table if exists tb_bandeira_cartao cascade;
drop table if exists tb_cartao_bancario cascade;
		
create table if not exists tb_tipo_pessoa (
	codigo bigserial not null,
	descricao varchar(100) not null unique,
	constraint pk_tipo_pessoa primary key (codigo)
);

create table if not exists tb_pessoa (
	codigo bigserial not null,
	id_tipo_pessoa serial not null,
	nome varchar(100) not null unique,
	constraint pk_pessoa primary key (codigo),
	constraint fk_pessoa foreign key (id_tipo_pessoa) references tb_tipo_pessoa (codigo)
);

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
	data_hora_cadastro timestamp not null default current_date, 
	valor_total float not null,
	e_recorrente boolean not null,
	e_pago boolean not null,
	observacao varchar(255),
	constraint pk_transacao_financeira primary key (codigo),
	constraint fk_tipo_transacao_financeira foreign key (id_tipo_transacao_financeira) references tb_tipo_transacao_financeira (codigo),
	constraint fk_pessoa_transacao_pessoa foreign key (id_pessoa_transacao_financeira) references tb_pessoa (codigo),
	constraint fk_pessoa_responsavel foreign key (id_pessoa_responsavel) references tb_pessoa (codigo)
);

create table if not exists tb_produto_servico (
	codigo bigserial not null,
	nome varchar(100) not null unique,
	constraint pk_produto_servico primary key (codigo)
);

create table if not exists tb_transacao_financeira_produto_servico (
	codigo bigserial not null,
	id_transacao_financeira serial not null,
	id_produto_servico serial not null,
	constraint pk_transacao_financeira_produto_servico primary key (codigo),
	constraint fk_transacao_financeira foreign key (id_transacao_financeira) references tb_transacao_financeira (codigo),
	constraint fk_produto_servico foreign key (id_produto_servico) references tb_produto_servico (codigo)
);

create table if not exists tb_parcelamento (
	codigo bigserial not null,
	identificador varchar(50) not null unique,
	numero integer not null,
	valor float not null,
	data_vencimento date not null,
	data_pagamento date not null,
	constraint pk_parcelamento primary key (codigo)
);

create table if not exists tb_conta_bancaria (
	codigo bigserial not null,
	id_pessoa_conta_bancaria serial not null,
	id_pessoa_titular serial not null,
	numero varchar(20) not null,
	agencia integer not null,
	data_inicio_contrato date not null,
	data_fim_contrato date null,
	constraint pk_conta_bancaria primary key (codigo),
	constraint fk_pessoa foreign key (id_pessoa_conta_bancaria) references tb_pessoa (codigo)
);

create table if not exists tb_forma_pagamento (
	codigo bigserial not null,
	descricao varchar(100) not null unique,
	constraint pk_forma_pagamento primary key (codigo)
);

create table if not exists tb_pagamento (
	codigo bigserial not null,
	id_parcelamento serial not null,
	id_transacao_financeira serial not null,
	id_conta_bancaria serial not null,
	id_forma_pagamento serial not null,
	constraint pk_pagamento primary key (codigo),
	constraint fk_parcelamento foreign key (id_parcelamento) references tb_parcelamento (codigo),
	constraint fk_transacao_financeira foreign key (id_transacao_financeira) references tb_transacao_financeira (codigo),
	constraint fk_conta_bancaria foreign key (id_conta_bancaria) references tb_conta_bancaria (codigo),
	constraint fk_forma_pagamento foreign key (id_forma_pagamento) references tb_forma_pagamento (codigo)
);

create table if not exists tb_bandeira_cartao (
	codigo bigserial not null,
	descricao varchar(100) not null unique,
	constraint pk_bandeira_cartao primary key (codigo)
);

create table if not exists tb_cartao_bancario (
	codigo bigserial not null,
	id_conta_bancaria serial not null,
	id_bandeira_cartao serial not null,
	numero varchar(100) not null unique,
	data_validade date not null,
	codigo_serguranca char(3) null,
	constraint pk_cartao_bancario primary key (codigo),
	constraint fk_conta_bancaria foreign key (id_conta_bancaria) references tb_conta_bancaria (codigo),
	constraint fk_bandeira_cartao foreign key (id_bandeira_cartao) references tb_bandeira_cartao (codigo)
);

insert into tb_tipo_pessoa (descricao) values ('Pessoa Física');
insert into tb_tipo_pessoa (descricao) values ('Pessoa Jurídica');

insert into tb_pessoa (id_tipo_pessoa, nome) values (1, 'José Quintinno');
insert into tb_pessoa (id_tipo_pessoa, nome) values (2, 'Banco do Brasil');
insert into tb_pessoa (id_tipo_pessoa, nome) values (2, 'Terabyte Informática (Brazlândia)');
insert into tb_pessoa (id_tipo_pessoa, nome) values (2, 'Posto de Combustível BR (Brazlândia)');

insert into tb_tipo_transacao_financeira (descricao) values ('Receita Fixa');
insert into tb_tipo_transacao_financeira (descricao) values ('Receita Variável');
insert into tb_tipo_transacao_financeira (descricao) values ('Despesa Fixa');
insert into tb_tipo_transacao_financeira (descricao) values ('Despesa Variável');
insert into tb_tipo_transacao_financeira (descricao) values ('Concessão de Empréstimo (Pessoa Física)');
insert into tb_tipo_transacao_financeira (descricao) values ('Adquirição de Empréstimo (Pessoa Física)');
insert into tb_tipo_transacao_financeira (descricao) values ('Adquirição de Empréstimo (Pessoa Jurídica)');

insert into tb_transacao_financeira (id_tipo_transacao_financeira, id_pessoa_transacao_financeira, id_pessoa_responsavel, identificador, quantidade_parcela, data_hora_cadastro, valor_total, e_recorrente, e_pago, observacao) values (1, 3, 1, 'TRANSACAO_FINANCEIRA_0001', 1, now(), 50, false, true, '');
insert into tb_transacao_financeira (id_tipo_transacao_financeira, id_pessoa_transacao_financeira, id_pessoa_responsavel, identificador, quantidade_parcela, data_hora_cadastro, valor_total, e_recorrente, e_pago, observacao) values (4, 4, 1, 'TRANSACAO_FINANCEIRA_0002', 1, '2023-07-16', 50, false, true, '');

insert into tb_parcelamento (identificador, numero, valor, data_vencimento, data_pagamento) values ('TRANSACAO_FINANCEIRA_0001_PARCELA_001', 1, 
	(select valor_total from tb_transacao_financeira where codigo = 1), (select data_hora_cadastro from tb_transacao_financeira where codigo = 1), (select data_hora_cadastro from tb_transacao_financeira where codigo = 1)
);

insert into tb_parcelamento (identificador, numero, valor, data_vencimento, data_pagamento) values ('TRANSACAO_FINANCEIRA_0002_PARCELA_001', 1, 
	(select valor_total from tb_transacao_financeira where codigo = 2), (select data_hora_cadastro from tb_transacao_financeira where codigo = 2), (select data_hora_cadastro from tb_transacao_financeira where codigo = 2)
);

insert into tb_produto_servico (nome) values ('Manutenção de Computador');
insert into tb_produto_servico (nome) values ('Combustível (Gasolina)');

insert into tb_transacao_financeira_produto_servico (id_transacao_financeira, id_produto_servico) values (1, 1);
insert into tb_transacao_financeira_produto_servico (id_transacao_financeira, id_produto_servico) values (2, 2);
		
insert into tb_conta_bancaria (id_pessoa_conta_bancaria, id_pessoa_titular, numero, agencia, data_inicio_contrato, data_fim_contrato) values (2, 1, '1287065-X', '5197', '2020-06-20', null);

insert into tb_bandeira_cartao (descricao) values ('Mastercard');

insert into tb_cartao_bancario (id_conta_bancaria, id_bandeira_cartao, numero, data_validade, codigo_serguranca) values (1, 1, '5254-2306-7819-7596', '2024-03-14', '150');

insert into tb_forma_pagamento (descricao) values ('Dinheiro');
insert into tb_forma_pagamento (descricao) values ('Cartão de Crédito');
insert into tb_forma_pagamento (descricao) values ('Cartão de Débito');

insert into tb_pagamento (id_parcelamento, id_transacao_financeira, id_conta_bancaria, id_forma_pagamento) values (
	1, 1, 1, 1
);

insert into tb_pagamento (id_parcelamento, id_transacao_financeira, id_conta_bancaria, id_forma_pagamento) values (
	2, 2, 1, 1
);

/*
	select * from tb_tipo_pessoa;
	select * from tb_pessoa;
	select * from tb_tipo_transacao_financeira;
	select * from tb_transacao_financeira;
	select * from tb_parcelamento;
	select * from tb_produto_servico;
	select * from tb_transacao_financeira_produto_servico;
	select * from tb_bandeira_cartao;
	select * from tb_cartao_bancario;
	select * from tb_pagamento;
	select * from tb_forma_pagamento;
 	
 	-- Alterar Formatos para Brasil
	set lc_numeric to 'pt_BR'; 
	set lc_monetary to 'pt_BR';
	
	-- Recuperar todos os Produtos ou Serviços vinculados a uma determinada Transação
	select 
		pessoa_transacao_financeira.nome as empresa,
		transacao_financeira.identificador,
		to_char(transacao_financeira.data_hora_cadastro, 'DD/MM/YYYY') as data,
		produto_servico.nome as servico,
		transacao_financeira.valor_total as valor
	-- select *
	from tb_transacao_financeira transacao_financeira
	join tb_transacao_financeira_produto_servico transacao_financeira_produto_servico 
		on transacao_financeira_produto_servico.id_transacao_financeira = transacao_financeira.codigo
	join tb_produto_servico produto_servico on produto_servico.codigo = transacao_financeira_produto_servico.id_produto_servico
	join tb_pessoa pessoa_transacao_financeira on pessoa_transacao_financeira.codigo = transacao_financeira.id_pessoa_transacao_financeira
	where transacao_financeira.data_hora_cadastro between '2023-07-01' and '2023-07-31';

*/

-- Consultar todas as triggers
select * from information_schema.triggers;

-- Trigger
create trigger tg_criar_parcelamento
after insert on tb_transacao_financeira
for each row
execute procedure fc_criar_parcelamento();

select * from tb_parcelamento;

-- Função

create or replace function fc_criar_parcelamento() returns trigger as $$
declare quantidade_parcela_parameter int4;
begin
	select * from tb_transacao_financeira where codigo = new.codigo into quantidade_parcela_parameter;
	insert into tb_parcelamento (identificador, numero, valor, data_vencimento, data_pagamento) values (
			'PARCELA_001', 
			quantidade_parcela_parameter,
			(select valor_total from tb_transacao_financeira),
			(select data_hora_cadastro from tb_transacao_financeira where codigo = new.codigo), 
			(select data_hora_cadastro from tb_transacao_financeira where codigo = new.codigo)
	);
end 
$$ language plpgsql;
