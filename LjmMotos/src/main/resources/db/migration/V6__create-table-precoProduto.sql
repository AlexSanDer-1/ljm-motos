CREATE TABLE preco_Produtos(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    icms DOUBLE NOT NULL,
    margem_de_Lucro  DOUBLE NOT NULL,
    produto_id BIGINT,
    FOREIGN KEY (produto_id) REFERENCES produtos(id) ON DELETE CASCADE

);