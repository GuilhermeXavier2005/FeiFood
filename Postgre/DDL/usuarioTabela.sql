-- Table: public.usuario

-- DROP TABLE IF EXISTS public.usuario;

CREATE TABLE IF NOT EXISTS public.usuario
(
    nome character varying(30) COLLATE pg_catalog."default",
    cpf character varying(15) COLLATE pg_catalog."default",
    contato character varying(15) COLLATE pg_catalog."default",
    senha character varying(15) COLLATE pg_catalog."default"
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.usuario
    OWNER to postgres;