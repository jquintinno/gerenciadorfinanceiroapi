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