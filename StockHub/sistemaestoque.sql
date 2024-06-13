-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 13/06/2024 às 02:12
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `sistemaestoque`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `tb_clientes`
--

CREATE TABLE `tb_clientes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `rg` varchar(30) DEFAULT NULL,
  `cpf` varchar(20) NOT NULL,
  `email` varchar(200) NOT NULL,
  `telefone` varchar(30) DEFAULT NULL,
  `celular` varchar(30) DEFAULT NULL,
  `cep` varchar(100) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `complemento` varchar(200) DEFAULT NULL,
  `bairro` varchar(100) DEFAULT NULL,
  `cidade` varchar(100) DEFAULT NULL,
  `estado` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Estrutura para tabela `tb_fornecedores`
--

CREATE TABLE `tb_fornecedores` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `cnpj` varchar(100) NOT NULL,
  `email` varchar(200) NOT NULL,
  `telefone` varchar(30) DEFAULT NULL,
  `celular` varchar(30) DEFAULT NULL,
  `cep` varchar(100) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `complemento` varchar(200) DEFAULT NULL,
  `bairro` varchar(100) DEFAULT NULL,
  `cidade` varchar(100) DEFAULT NULL,
  `estado` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Estrutura para tabela `tb_funcionarios`
--

CREATE TABLE `tb_funcionarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `rg` varchar(30) DEFAULT NULL,
  `cpf` varchar(20) NOT NULL,
  `email` varchar(200) NOT NULL,
  `senha` varchar(10) NOT NULL,
  `cargo` varchar(100) NOT NULL,
  `nivel_acesso` varchar(50) NOT NULL,
  `telefone` varchar(30) DEFAULT NULL,
  `celular` varchar(30) DEFAULT NULL,
  `cep` varchar(100) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `complemento` varchar(200) DEFAULT NULL,
  `bairro` varchar(100) DEFAULT NULL,
  `cidade` varchar(100) DEFAULT NULL,
  `estado` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Estrutura para tabela `tb_parcelas`
--

CREATE TABLE `tb_parcelas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cliente_id` int(11) NOT NULL,
  `data_venda` datetime DEFAULT NULL,
  `total` decimal(10,2) DEFAULT NULL,
  `parcela` decimal(10,2) DEFAULT NULL,
  `obs` varchar(100) DEFAULT NULL,
  `num_parcelas` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cliente_id` (`cliente_id`),
  CONSTRAINT `tb_parcelas_ibfk_1` FOREIGN KEY (`cliente_id`) REFERENCES `tb_clientes` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Estrutura para tabela `tb_produtos`
--

CREATE TABLE `tb_produtos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(100) NOT NULL,
  `preco` decimal(10,2) NOT NULL,
  `qtd_estoque` int(11) NOT NULL,
  `for_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `for_id` (`for_id`),
  CONSTRAINT `tb_produtos_ibfk_1` FOREIGN KEY (`for_id`) REFERENCES `tb_fornecedores` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Estrutura para tabela `tb_vendas`
--

CREATE TABLE `tb_vendas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cliente_id` int(11) NOT NULL,
  `data_venda` datetime DEFAULT NULL,
  `total_venda` decimal(10,2) DEFAULT NULL,
  `observacoes` text DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cliente_id` (`cliente_id`),
  CONSTRAINT `tb_vendas_ibfk_1` FOREIGN KEY (`cliente_id`) REFERENCES `tb_clientes` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Estrutura para tabela `tb_itensvendas`
--

CREATE TABLE `tb_itensvendas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `venda_id` int(11) NOT NULL,
  `produto_id` int(11) NOT NULL,
  `qtd` int(11) NOT NULL,
  `subtotal` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `venda_id` (`venda_id`),
  KEY `produto_id` (`produto_id`),
  CONSTRAINT `tb_itensvendas_ibfk_1` FOREIGN KEY (`venda_id`) REFERENCES `tb_vendas` (`id`),
  CONSTRAINT `tb_itensvendas_ibfk_2` FOREIGN KEY (`produto_id`) REFERENCES `tb_produtos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- AUTO_INCREMENT para tabelas
--

ALTER TABLE `tb_clientes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

ALTER TABLE `tb_fornecedores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

ALTER TABLE `tb_funcionarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

ALTER TABLE `tb_itensvendas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=216;

ALTER TABLE `tb_parcelas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;

ALTER TABLE `tb_produtos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

ALTER TABLE `tb_vendas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=257;

COMMIT;

--
-- Despejando dados para a tabela `tb_clientes`
--

INSERT INTO `tb_clientes` (`id`, `nome`, `rg`, `cpf`, `email`, `telefone`, `celular`, `cep`, `endereco`, `numero`, `complemento`, `bairro`, `cidade`, `estado`) VALUES
(9, 'Gabriel Martins', '22.222.222', '111.111.111-11', 'gabriel@martinsgmail.com', '(11)1111-1111', '(99)9 9999-9999', '11111-111', 'rua1', 1, 'casa', 'rua2', 'sete lagoas', 'MG'),
(12, 'André Luiz', '11.111.111', '111.111.111-13', 'andre@luizgmail.com', '(11)1111-1111', '(99)9 9999-9999', '11111-111', 'rua1', 1, 'casa', 'Vila Vitória', 'Raposos', 'MG'),
(13, 'Otaviano', '11.111.111', '111.111.111-12', 'Otaviano@gmail.com', '(11)1111-1111', '(99)9 9999-9999', '11111-111', 'rua3', 1, 'casa', 'centro', 'Betim', 'MG'),
(14, 'Rejane', '11.111.111', '111.111.111-12', 'rejane@gmail.com', '(11)1111-1111', '(99)9 9999-9999', '11111-111', 'rua2', 2, 'casa', 'centro', 'Contagem', 'MG'),
(15, 'Flávia', '11.111.111', '111.111.111-13', 'flavia@gmail.com', '(11)1111-1111', '(99)9 9999-9999', '11111-111', 'rua4', 4, 'casa', 'centro', 'Belo Horizonte', 'MG');

--
-- Despejando dados para a tabela `tb_fornecedores`
--

INSERT INTO `tb_fornecedores` (`id`, `nome`, `cnpj`, `email`, `telefone`, `celular`, `cep`, `endereco`, `numero`, `complemento`, `bairro`, `cidade`, `estado`) VALUES
(2, 'Sony', '00.000.000/0001-91', 'sony@gmail.com', '(11)1111-1111', '(11)9 9999-9999', '11111-111', 'Rua1', 1, 'casa', 'centro', 'Belo Horizonte', 'MG'),
(4, 'Samsung', '00.000.000/0001-99', 'samsung@gmail.com', '(11)1111-1111', '(11)9 9999-9999', '11111-111', 'Rua2', 2, 'casa', 'centro', 'Contagem', 'MG'),
(5, 'Panasonic', '00.000.000/0001-12', 'panasonic@gmail.com', '(11)1111-1111', '(11)9 9999-9999', '11111-111', 'Rua3', 3, 'casa', 'centro', 'Betim', 'MG');

--
-- Despejando dados para a tabela `tb_funcionarios`
--

INSERT INTO `tb_funcionarios` (`id`, `nome`, `rg`, `cpf`, `email`, `senha`, `cargo`, `nivel_acesso`, `telefone`, `celular`, `cep`, `endereco`, `numero`, `complemento`, `bairro`, `cidade`, `estado`) VALUES
(2, 'Gabriel Martins', '22.222.222', '111.111.111-11', 'gabriel@martinsgmail.com', '22222', 'gerente', 'Administrador', '(11)1111-1111', '(99)9 9999-9999', '11111-111', 'rua1', 1, 'casa', 'rua2', 'sete lagoas', 'MG'),
(3, 'Luiz Santos', '22.222.222', '111.111.111-11', 'luiz@santosgmail.com', '12345', 'Atendente', 'Usuario', '(11)1111-1111', '(99)9 9999-9999', '11111-111', 'rua3', 3, 'casa', 'centro', 'Betim', 'MG'),
(4, 'Marta Silva', '22.222.222', '111.111.111-11', 'marta@silvagmail.com', '54321', 'Atendente', 'Usuario', '(11)1111-1111', '(99)9 9999-9999', '11111-111', 'rua4', 4, 'casa', 'centro', 'Contagem', 'MG');

--
-- Despejando dados para a tabela `tb_parcelas`
--

INSERT INTO `tb_parcelas` (`id`, `cliente_id`, `data_venda`, `total`, `parcela`, `obs`, `num_parcelas`) VALUES
(1, 13, '2024-02-21 21:11:23', '200.00', '66.66', 'Parcela 1 de 3', 3),
(2, 14, '2024-02-22 11:30:45', '300.00', '100.00', 'Parcela 1 de 3', 3),
(3, 15, '2024-02-23 15:55:12', '450.00', '150.00', 'Parcela 1 de 3', 3);

--
-- Despejando dados para a tabela `tb_produtos`
--

INSERT INTO `tb_produtos` (`id`, `descricao`, `preco`, `qtd_estoque`, `for_id`) VALUES
(1, 'Playstation 5', '5000.00', 10, 2),
(2, 'Televisão Samsung', '3000.00', 15, 4),
(3, 'Microondas Panasonic', '800.00', 20, 5);

--
-- Despejando dados para a tabela `tb_vendas`
--

INSERT INTO `tb_vendas` (`id`, `cliente_id`, `data_venda`, `total_venda`, `observacoes`) VALUES
(1, 9, '2024-06-01 10:20:30', '1500.00', 'Venda realizada com sucesso'),
(2, 12, '2024-06-02 12:45:00', '2000.00', 'Venda com desconto especial'),
(3, 13, '2024-06-03 14:15:45', '2500.00', 'Cliente VIP');

--
-- Despejando dados para a tabela `tb_itensvendas`
--

INSERT INTO `tb_itensvendas` (`id`, `venda_id`, `produto_id`, `qtd`, `subtotal`) VALUES
(1, 1, 1, 1, '5000.00'),
(2, 2, 2, 1, '3000.00'),
(3, 3, 3, 2, '1600.00');

