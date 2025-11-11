-- Table: public.estabelecimento

-- DROP TABLE IF EXISTS public.estabelecimento;

CREATE TABLE IF NOT EXISTS public.estabelecimento
(
    nome character varying(20) COLLATE pg_catalog."default",
    local character varying(30) COLLATE pg_catalog."default",
    cardapio character varying(300) COLLATE pg_catalog."default"
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.estabelecimento
    OWNER to postgres;