CREATE TABLE usuario (
    id INT,
    nome VARCHAR(255) NOT NULL COMMENT 'Nome do usuario',
    email VARCHAR(100) NOT NUL LNUIQUE COMMENT 'Email do usuario',
    endereco VARCHAR(50) NOT NULL COMMENT 'Endereco do usuario',
    data_nascimento DATE NOT NULL COMMENT 'Data de nascimento do usuasrio'
);


CREATE TABLE viagem.destino (
    id INT,
    nome VARCHAR(255) NOT NULL,
    descricao VARCHAR(255) NOT NULL
);


CREATE TABLE viagem.reserva (
    id INT,
    id_usuario INT,
    id_destino INT,
    data DATE,
    `status` VARCHAR(255) DEFAULT 'pendente'
);


INSERT INTO
    usuario (id, nome, email, data_nascimento)
VALUES
    (
        1,
        "Jose",
        "user@email.com",
        "1980-01-01",
        "Rua projetada, 1, bairro, cidade"
    );


INSERT INTO
    destino (id, nome, descricao)
VALUES
    (1, 'Praia do Rosa', 'Linda Praia');


INSERT INTO
    reserva (
        id,
        id_usuario,
        id_destino,
        STATUS,
        data
    )
VALUES
    (1, 1, 1, "pendente", "2023-01-01");


ALTER TABLE
    usuario
MODIFY
    COLUMN id INT AUTO_INCREMENT,
ADD
    PRIMARY KEY (id);


ALTER TABLE
    destino
MODIFY
    COLUMN id INT AUTO_INCREMENT,
ADD
    PRIMARY KEY (id);


ALTER TABLE
    reserva
MODIFY
    COLUMN id INT AUTO_INCREMENT,
ADD
    PRIMARY KEY (id);


ALTER TABLE
    reserva
ADD
    CONSTRAINT fk_reserva_usuario FOREIGN KEY (id_usuario) REFERENCES usuario (id);


ALTER TABLE
    reserva
ADD
    CONSTRAINT fk_reserva_destino FOREIGN KEY (id_destino) REFERENCES destino (id);


ALTER TABLE
    reserva
ADD
    CONSTRAINT fk_usuario FOREIGN KEY (id_usuario) REFERENCES usuario (id) ON DELETE CASCADE;


-- create indice
EXPLAIN
SELECT
    *
FROM
    usuario
WHERE
    email = "joao@email.com";


CREATE INDEX idx_nome ON usuario (nome);