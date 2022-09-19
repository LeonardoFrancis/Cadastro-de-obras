CREATE TABLE obra_autor (
	codigo BIGINT PRIMARY KEY AUTO_INCREMENT,
	codigo_autor_fk BIGINT NOT NULL,
        codigo_obra_fk BIGINT NOT NULL,
	FOREIGN KEY (codigo_autor_fk) REFERENCES autor(codigo),
        FOREIGN KEY (codigo_obra_fk) REFERENCES obra(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;



INSERT INTO obra_autor (codigo_autor_fk, codigo_obra_fk) values (1, 1);
INSERT INTO obra_autor (codigo_autor_fk, codigo_obra_fk) values (1, 2);
INSERT INTO obra_autor (codigo_autor_fk, codigo_obra_fk) values (2, 3);
INSERT INTO obra_autor (codigo_autor_fk, codigo_obra_fk) values (3, 4);
INSERT INTO obra_autor (codigo_autor_fk, codigo_obra_fk) values (4, 5);
INSERT INTO obra_autor (codigo_autor_fk, codigo_obra_fk) values (5, 6);