-- Table: public.alimentos

-- DROP TABLE IF EXISTS public.alimentos;

CREATE TABLE IF NOT EXISTS public.alimentos
(
    nome character varying(30) COLLATE pg_catalog."default",
    preco double precision,
    local character varying(30) COLLATE pg_catalog."default"
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.alimentos
    OWNER to postgres;