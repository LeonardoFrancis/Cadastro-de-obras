CREATE TABLE obra_autor (
	codigo BIGINT PRIMARY KEY AUTO_INCREMENT,
	codigo_autor_fk BIGINT NOT NULL,
        codigo_obra_fk BIGINT NOT NULL,
	FOREIGN KEY (codigo_autor_fk) REFERENCES autor(codigo),
        FOREIGN KEY (codigo_obra_fk) REFERENCES obra(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;