CREATE TABLE obra (
	codigo BIGINT PRIMARY KEY AUTO_INCREMENT,
        nome VARCHAR(100) NOT NULL,
	descricao VARCHAR(240) NOT NULL,
	data_publicacao VARCHAR(12),
	data_exposicao VARCHAR(12),
	codigo_autor BIGINT,
	FOREIGN KEY (codigo_autor) REFERENCES autor(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;