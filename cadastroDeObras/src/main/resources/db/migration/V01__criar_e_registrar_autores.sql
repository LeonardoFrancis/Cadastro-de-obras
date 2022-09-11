CREATE TABLE autor (
	codigo BIGINT PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(100) NOT NULL,
	sexo VARCHAR(12),
	email VARCHAR(100),
	data_nascimento VARCHAR(12),
	nacionalidade VARCHAR(50),
	cpf VARCHAR(14)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;



INSERT INTO autor (nome, sexo, email, data_nascimento, nacionalidade, cpf) values ('Noberto Fredda', 'Masculino', 'noberto_freda@gmail.com', '05/04/1982', 'Brasil', '032.754.897-06');
INSERT INTO autor (nome, sexo, email, data_nascimento, nacionalidade, cpf) values ('Richard Town', 'Masculino', 'richard@gmail.com', '05/047/1992', 'Estados Unidos', '056.784.802-16');
INSERT INTO autor (nome, sexo, email, data_nascimento, nacionalidade, cpf) values ('Yudi Tamashiro', 'Masculino', 'tamashiro@hotmail.com', '15/02/1997', 'Japão', '120.800.001-06');
INSERT INTO autor (nome, sexo, email, data_nascimento, nacionalidade, cpf) values ('Maria Gonzalez', 'Feminino', 'maria@outlook.com.br', '05/12/1979', 'Espanha', '332.123.741-26');
INSERT INTO autor (nome, sexo, email, data_nascimento, nacionalidade, cpf) values ('Martina Telles', 'Feminino', 'martininha@yahoo.com.br', '25/04/1959', 'Rússia', '222.774.900-89');
