CREATE TABLE tarefa (
  tarefa_id serial  NOT NULL,
  titulo VARCHAR(50) NOT NULL,
  descricao VARCHAR(100) NOT NULL,
  deadline date,
  status BOOLEAN DEFAULT FALSE NOT NULL,
  usuario_id serial NOT NULL,
 prioridade integer not null
);

CREATE TABLE usuario(
    id serial NOT NULL,
    nome varchar(100)
);