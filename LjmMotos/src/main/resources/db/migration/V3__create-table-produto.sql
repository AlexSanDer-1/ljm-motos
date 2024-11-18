CREATE TABLE produtos(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    codigo INT NOT NULL,
    preco DOUBLE NOT NULL,
    quantidade INT NOT NULL,
    descricao VARCHAR(255),
    marca VARCHAR(255),
    tipo_valor ENUM('ATACADO','VAREJO') NOT NULL,
    excesso INT
);