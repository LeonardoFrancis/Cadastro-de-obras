CREATE TABLE obra (
	codigo_obra BIGINT PRIMARY KEY AUTO_INCREMENT,
        nome VARCHAR(100) NOT NULL,
	descricao VARCHAR(240) NOT NULL,
	data_publicacao DATE,
	data_exposicao DATE,
	codigo_autor_FK BIGINT NOT NULL,
	FOREIGN KEY (codigo_autor_FK) REFERENCES autor(codigo_autor)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;