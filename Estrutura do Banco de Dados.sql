CREATE TABLE public.cliente_tb (
	id_cliente serial4 NOT NULL,
	nome varchar(160) NULL,
	cpf varchar(14) NULL,
	telefone varchar(11) NULL,
	endereco varchar(200) NULL,
	CONSTRAINT cliente_tb_pkey PRIMARY KEY (id_cliente)
);

CREATE TABLE public.carro_tb (
	id_carro serial4 NOT NULL,
	modelo varchar(40) NULL,
	cor varchar(40) NULL,
	fabricante varchar(40) NULL,
	placa varchar(8) NULL,
	valor_diaria numeric(10, 2) NULL,
	CONSTRAINT carro_tb_pkey PRIMARY KEY (id_carro)
);

CREATE TABLE public.solicitacao_tb (
	id_solicitacao serial4 NOT NULL,
	id_cliente int4 NULL,
	id_carro int4 NULL,
	dt_solicitacao timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	dt_retirada timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	dt_dev_prevista date NOT NULL,
	dt_devolucao timestamp NULL,
	qtd_dias_aluguel int4 NULL,
	valor_diaria numeric(10, 2) NULL,
	total_diaria numeric(10, 2) NULL,
	ativo bpchar(1) NOT NULL DEFAULT 'S'::bpchar,
	CONSTRAINT solicitacao_tb_pkey PRIMARY KEY (id_solicitacao),
	CONSTRAINT solicitacao_tb_id_carro_fkey FOREIGN KEY (id_carro) REFERENCES public.carro_tb(id_carro),
	CONSTRAINT solicitacao_tb_id_cliente_fkey FOREIGN KEY (id_cliente) REFERENCES public.cliente_tb(id_cliente)
);