CREATE TABLE autor (
	codigo_autor BIGINT PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(100) NOT NULL,
	sexo VARCHAR(12),
	email VARCHAR(100),
	data_nascimento VARCHAR(12),
	nacionalidade VARCHAR(50) NOT NULL,
	cpf VARCHAR(14),
        CONSTRAINT autor_un_email UNIQUE KEY (email)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;
