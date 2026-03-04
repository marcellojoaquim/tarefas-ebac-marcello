CREATE TABLE animal (
  id INT AUTO_INCREMENT NOT NULL,
  nome_provisorio VARCHAR(255) NOT NULL,
  idade_estimada INT NOT NULL,
  raca VARCHAR(255) NOT NULL,
  data_entrada DATE NOT NULL,
  data_adocao DATE,
  data_obito DATE,
  condicoes_chegada VARCHAR(255) NOT NULL,
  nome_recebedor VARCHAR(255) NOT NULL,
  porte VARCHAR(255) NOT NULL,
  CONSTRAINT pk_animal PRIMARY KEY (id)
);