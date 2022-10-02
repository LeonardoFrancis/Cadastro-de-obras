CREATE TABLE autor (
	codigo_autor BIGINT PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(100) NOT NULL,
	sexo VARCHAR(12),
	email VARCHAR(100),
	data_nascimento DATE NOT NULL,
	cpf VARCHAR(14),
        codigo_pais_FK BIGINT(3) unsigned NOT NULL,
        FOREIGN KEY (codigo_pais_FK) REFERENCES pais(codigo_pais),
        CONSTRAINT autor_un_email UNIQUE KEY (email),
        CONSTRAINT autor_un_cpf UNIQUE KEY (cpf)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;
