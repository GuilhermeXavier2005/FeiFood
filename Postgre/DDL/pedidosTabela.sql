-- Table: public.pedidos

-- DROP TABLE IF EXISTS public.pedidos;

CREATE TABLE IF NOT EXISTS public.pedidos
(
    produto character varying(30) COLLATE pg_catalog."default",
    idproduto double precision NOT NULL,
    estabelecimento character varying(30) COLLATE pg_catalog."default",
    preco double precision,
    usuario character varying(30) COLLATE pg_catalog."default",
    idpedido double precision,
    CONSTRAINT pedidos_pkey PRIMARY KEY (idproduto)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.pedidos
    OWNER to postgres;