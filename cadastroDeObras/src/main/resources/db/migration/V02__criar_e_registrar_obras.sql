CREATE TABLE obra (
	codigo BIGINT PRIMARY KEY AUTO_INCREMENT,
        nome VARCHAR(100) NOT NULL,
	descricao VARCHAR(240) NOT NULL,
	data_publicacao VARCHAR(12),
	data_exposicao VARCHAR(12),
	codigo_autor BIGINT NOT NULL,
	FOREIGN KEY (codigo_autor) REFERENCES autor(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;



INSERT INTO obra (nome, descricao, data_publicacao, data_exposicao, codigo_autor) values ('Luvre', 'Representa a história antiga de Luvre', '05/04/2000', '25/01/1999', 1);
INSERT INTO obra (nome, descricao, data_publicacao, data_exposicao, codigo_autor) values ('MarcoPollo', 'Representa a história antiga de Marcopollo', '05/04/2002', '25/03/2003', 1);
INSERT INTO obra (nome, descricao, data_publicacao, data_exposicao, codigo_autor) values ('Jesus', 'Representa a história antiga de Jesus', '05/04/1999', '25/04/1999', 2);
INSERT INTO obra (nome, descricao, data_publicacao, data_exposicao, codigo_autor) values ('DaviStar', 'Representa a história antiga de Davi', '06/04/1998', '05/05/1998', 3);
INSERT INTO obra (nome, descricao, data_publicacao, data_exposicao, codigo_autor) values ('Xunin', 'Representa a história antiga de Xunin', '05/04/2010', '25/01/2011', 4);
INSERT INTO obra (nome, descricao, data_publicacao, data_exposicao, codigo_autor) values ('Hanabi', 'Representa a história antiga de Hanabi', '05/04/2022', '07/09/2022', 5);