DROP DATABASE IF EXISTS bdagencia;

create database if not exists bdAgencia;

use bdAgencia;

CREATE TABLE passageiro (
    nome_passageiro varchar(40),
    CPF varchar(15) PRIMARY KEY,
    passaporte varchar(20),
    email varchar(40),
    telefone varchar(20)
);

CREATE TABLE pedido (
    num_pedido INT PRIMARY KEY auto_increment,
    dt_pedido varchar(15),
    forma_pgmto varchar(20),
    CPF varchar(30),
    FOREIGN KEY(CPF) REFERENCES passageiro(CPF)
);

CREATE TABLE passagem (
    id_passagem INT PRIMARY KEY auto_increment,
    quantidade INT,
    origem varchar(30),
    destino varchar(30),
    num_pedido INT,
	valor_passagem float(7,2),
    FOREIGN KEY(num_pedido) REFERENCES pedido(num_pedido)
);

-- salvando(create) os dados

insert into passageiro (nome_passageiro, CPF, passaporte, email, telefone) values

('Augusto Roberto', '12345678900', 'AB123456', 'roberto@email.com','87994568522' ),

('Mariana Farias', '12345678901', 'AC123456', 'farias123@email.com','83994548242' );

insert into passageiro (nome_passageiro, CPF, passaporte, email, telefone) values

('Silvio Santos', '12812812812', 'DF123444', 'silvio@email.com','86994368323' );
 

insert into pedido (dt_pedido, forma_pgmto, CPF) values

('18/09/2023', 'boleto bancario', '12345678900'),

('04/02/2022', 'PIX', '12345678901');


insert into passagem (quantidade, origem, destino,num_pedido, valor_passagem) values 

(2, 'Sao Paulo', 'Pernambuco', 1 , 800.00),
(2, 'Paraiba', 'Amazonas', 2 , 750.00);

 

-- consulta(read) dos dados

select * from passageiro;

select * from pedido;

select * from passagem;

 
-- atualizando(updade) os dados

UPDATE passageiro SET nome_passageiro = 'Daniel Tavares',passaporte = 'MN123456', email = 'tavares2023@email', telefone = '62896953265' WHERE CPF = '12345678901';
UPDATE passagem SET quantidade = 3, origem = 'Porto Velho', destino = 'Gramado', valor_passagem = 500.00 WHERE id_passagem = 2;
UPDATE pedido SET dt_pedido = '10/09/2023', forma_pgmto = 'cartao de credito' WHERE num_pedido = 2;

 

-- deletando(delete) os dados

DELETE FROM passageiro WHERE CPF = '12345678902';

DELETE FROM passagem WHERE id_passagem = 2;

DELETE FROM pedido WHERE num_pedido = 2;