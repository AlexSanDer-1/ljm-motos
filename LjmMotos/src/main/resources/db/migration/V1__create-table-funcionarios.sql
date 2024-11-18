create table funcionarios(
   id BIGINT AUTO_INCREMENT PRIMARY KEY,
       nome VARCHAR(255) NOT NULL,
       idade INT NOT NULL,
       cargo ENUM('ESTOQUE','SEPARADOR','VENDEDOR','EXPEDICAO','CONFERENTE_VAREJO','CONFERENTE_ENTREGA')NOT NULL,
       salario DECIMAL(15, 2),
       data_emisao DATE
);