create table if not exists tb_forma_pagamento (
	codigo bigserial not null,
	descricao varchar(100) not null unique,
	constraint pk_forma_pagamento primary key (codigo)
);

insert into tb_forma_pagamento (descricao) values ('Dinheiro');
insert into tb_forma_pagamento (descricao) values ('Cartão de Crédito');
insert into tb_forma_pagamento (descricao) values ('Cartão de Débito');
insert into tb_forma_pagamento (descricao) values ('Transferência Bancária (TED-DOC)');
insert into tb_forma_pagamento (descricao) values ('Transferência Bancária (PIX)');
