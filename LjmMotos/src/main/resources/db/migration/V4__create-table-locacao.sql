create table locacao(
       id BIGINT AUTO_INCREMENT PRIMARY KEY,
       partilheira VARCHAR(255) NOT NULL,
       direcao_partilheira VARCHAR(255) NOT NULL,
       nivel VARCHAR(255) NOT NULL,
       coluna VARCHAR(255) NOT NULL,
       limite_armazenamento INT NOT NULL,
       quantidade INT,
       produto_id BIGINT,
       FOREIGN KEY (produto_id) REFERENCES produtos(id) ON DELETE CASCADE
);