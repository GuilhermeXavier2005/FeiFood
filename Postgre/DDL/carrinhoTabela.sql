-- Table: public.carrinho

-- DROP TABLE IF EXISTS public.carrinho;

CREATE TABLE IF NOT EXISTS public.carrinho
(
    idpedido double precision NOT NULL,
    pagamento character varying(15) COLLATE pg_catalog."default",
    avaliacao integer,
    total double precision,
    CONSTRAINT carrinho_pkey PRIMARY KEY (idpedido)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.carrinho
    OWNER to postgres;