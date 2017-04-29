-- MySQL Script generated by MySQL Workbench
-- sex 28 abr 2017 22:12:01 -03
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema almoxarifado
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema almoxarifado
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `almoxarifado` DEFAULT CHARACTER SET utf8 ;
USE `almoxarifado` ;

-- -----------------------------------------------------
-- Table `almoxarifado`.`enderecos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `almoxarifado`.`enderecos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cidade` VARCHAR(255) NOT NULL,
  `bairro` VARCHAR(255) NULL,
  `cep` VARCHAR(40) NOT NULL,
  `numero` VARCHAR(45) NOT NULL,
  `complemento` VARCHAR(255) NULL,
  `logradouro` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almoxarifado`.`contatos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `almoxarifado`.`contatos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  `telefone` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almoxarifado`.`fornecedores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `almoxarifado`.`fornecedores` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `razao_social` VARCHAR(255) NOT NULL,
  `nome_fantasia` VARCHAR(255) NOT NULL,
  `cnpj` VARCHAR(45) NOT NULL,
  `endereco` INT NOT NULL,
  `contato` INT NOT NULL,
  PRIMARY KEY (`id`, `endereco`, `contato`),
  INDEX `fk_fornecedores_enderecos1_idx` (`endereco` ASC),
  INDEX `fk_fornecedores_contatos1_idx` (`contato` ASC),
  CONSTRAINT `fk_fornecedores_enderecos1`
    FOREIGN KEY (`endereco`)
    REFERENCES `almoxarifado`.`enderecos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_fornecedores_contatos1`
    FOREIGN KEY (`contato`)
    REFERENCES `almoxarifado`.`contatos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almoxarifado`.`naturezas_despesas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `almoxarifado`.`naturezas_despesas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `codigo` VARCHAR(45) NOT NULL,
  `subitem` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almoxarifado`.`empenhos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `almoxarifado`.`empenhos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `emissao` DATE NOT NULL,
  `numero` VARCHAR(30) NOT NULL,
  `especie` VARCHAR(255) NOT NULL,
  `fornecedor` INT NOT NULL,
  `endereco` INT NOT NULL,
  `observacao` VARCHAR(255) NULL,
  `valor` DECIMAL(10,2) NOT NULL,
  `natureza_despesa` INT NOT NULL,
  `sequencia` INT NULL,
  `quantidade` DOUBLE NOT NULL,
  `valor_unitario` DOUBLE NOT NULL,
  `valor_sequencia` DOUBLE NULL,
  `embalagem` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(400) NOT NULL,
  `item_processo` VARCHAR(45) NULL,
  `marca` VARCHAR(255) NOT NULL,
  `item_material` VARCHAR(45) NULL,
  PRIMARY KEY (`id`, `fornecedor`, `endereco`, `natureza_despesa`),
  INDEX `fk_empenhos_fornecedores1_idx` (`fornecedor` ASC),
  INDEX `fk_empenhos_enderecos1_idx` (`endereco` ASC),
  INDEX `fk_empenhos_natureza_despesa1_idx` (`natureza_despesa` ASC),
  CONSTRAINT `fk_empenhos_fornecedores1`
    FOREIGN KEY (`fornecedor`)
    REFERENCES `almoxarifado`.`fornecedores` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_empenhos_enderecos1`
    FOREIGN KEY (`endereco`)
    REFERENCES `almoxarifado`.`enderecos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_empenhos_natureza_despesa1`
    FOREIGN KEY (`natureza_despesa`)
    REFERENCES `almoxarifado`.`naturezas_despesas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almoxarifado`.`servidores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `almoxarifado`.`servidores` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  `siape` VARCHAR(255) NOT NULL,
  `funcao` VARCHAR(255) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almoxarifado`.`produtos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `almoxarifado`.`produtos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(255) NOT NULL,
  `validade` DATE NOT NULL,
  `valor_unitario` DOUBLE NOT NULL,
  `marca` VARCHAR(255) NOT NULL,
  `lote` VARCHAR(255) NOT NULL,
  `peso` DOUBLE NULL,
  `dimensao` DOUBLE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almoxarifado`.`estoque`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `almoxarifado`.`estoque` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `produto` INT NOT NULL,
  `minimo` DOUBLE NOT NULL,
  `quantidade` DOUBLE NOT NULL,
  PRIMARY KEY (`id`, `produto`),
  INDEX `fk_estoque_produtos1_idx` (`produto` ASC),
  CONSTRAINT `fk_estoque_produtos1`
    FOREIGN KEY (`produto`)
    REFERENCES `almoxarifado`.`produtos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almoxarifado`.`setores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `almoxarifado`.`setores` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almoxarifado`.`alunos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `almoxarifado`.`alunos` (
  `id` INT NOT NULL,
  `nome` VARCHAR(255) NOT NULL,
  `matricula` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almoxarifado`.`visitantes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `almoxarifado`.`visitantes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `quantidade` INT NOT NULL,
  `setor` INT NOT NULL,
  PRIMARY KEY (`id`, `setor`),
  INDEX `fk_visitantes_setores1_idx` (`setor` ASC),
  CONSTRAINT `fk_visitantes_setores1`
    FOREIGN KEY (`setor`)
    REFERENCES `almoxarifado`.`setores` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almoxarifado`.`entradas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `almoxarifado`.`entradas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `quantidade` DOUBLE NOT NULL,
  `preco_unitario` DOUBLE NOT NULL,
  `produto` INT NOT NULL,
  `data` DATETIME NOT NULL,
  PRIMARY KEY (`id`, `produto`),
  INDEX `fk_entradas_produtos1_idx` (`produto` ASC),
  CONSTRAINT `fk_entradas_produtos1`
    FOREIGN KEY (`produto`)
    REFERENCES `almoxarifado`.`produtos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almoxarifado`.`requisicoes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `almoxarifado`.`requisicoes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `setor` INT NOT NULL,
  `quantidade` DOUBLE NOT NULL,
  PRIMARY KEY (`id`, `setor`),
  INDEX `fk_requisicoes_setores1_idx` (`setor` ASC),
  CONSTRAINT `fk_requisicoes_setores1`
    FOREIGN KEY (`setor`)
    REFERENCES `almoxarifado`.`setores` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almoxarifado`.`saidas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `almoxarifado`.`saidas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `quantidade_geral` DOUBLE NOT NULL,
  `preco_unitario` DOUBLE NOT NULL,
  `requisicao` INT NOT NULL,
  PRIMARY KEY (`id`, `requisicao`),
  INDEX `fk_saidas_requisicoes1_idx` (`requisicao` ASC),
  CONSTRAINT `fk_saidas_requisicoes1`
    FOREIGN KEY (`requisicao`)
    REFERENCES `almoxarifado`.`requisicoes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almoxarifado`.`servidores_has_setores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `almoxarifado`.`servidores_has_setores` (
  `servidores_id` INT NOT NULL,
  `setores_id` INT NOT NULL,
  PRIMARY KEY (`servidores_id`, `setores_id`),
  INDEX `fk_servidores_has_setores_setores1_idx` (`setores_id` ASC),
  INDEX `fk_servidores_has_setores_servidores_idx` (`servidores_id` ASC),
  CONSTRAINT `fk_servidores_has_setores_servidores`
    FOREIGN KEY (`servidores_id`)
    REFERENCES `almoxarifado`.`servidores` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_servidores_has_setores_setores1`
    FOREIGN KEY (`setores_id`)
    REFERENCES `almoxarifado`.`setores` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almoxarifado`.`fornecedores_has_produtos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `almoxarifado`.`fornecedores_has_produtos` (
  `fornecedores_id` INT NOT NULL,
  `produtos_id` INT NOT NULL,
  PRIMARY KEY (`fornecedores_id`, `produtos_id`),
  INDEX `fk_fornecedores_has_produtos_produtos1_idx` (`produtos_id` ASC),
  INDEX `fk_fornecedores_has_produtos_fornecedores1_idx` (`fornecedores_id` ASC),
  CONSTRAINT `fk_fornecedores_has_produtos_fornecedores1`
    FOREIGN KEY (`fornecedores_id`)
    REFERENCES `almoxarifado`.`fornecedores` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_fornecedores_has_produtos_produtos1`
    FOREIGN KEY (`produtos_id`)
    REFERENCES `almoxarifado`.`produtos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almoxarifado`.`requisicoes_has_produtos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `almoxarifado`.`requisicoes_has_produtos` (
  `requisicoes_id` INT NOT NULL,
  `produtos_id` INT NOT NULL,
  PRIMARY KEY (`requisicoes_id`, `produtos_id`),
  INDEX `fk_requisicoes_has_produtos_produtos1_idx` (`produtos_id` ASC),
  INDEX `fk_requisicoes_has_produtos_requisicoes1_idx` (`requisicoes_id` ASC),
  CONSTRAINT `fk_requisicoes_has_produtos_requisicoes1`
    FOREIGN KEY (`requisicoes_id`)
    REFERENCES `almoxarifado`.`requisicoes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_requisicoes_has_produtos_produtos1`
    FOREIGN KEY (`produtos_id`)
    REFERENCES `almoxarifado`.`produtos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almoxarifado`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `almoxarifado`.`usuarios` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `servidores` INT NOT NULL,
  PRIMARY KEY (`id`, `servidores`),
  INDEX `fk_usuarios_servidores1_idx` (`servidores` ASC),
  CONSTRAINT `fk_usuarios_servidores1`
    FOREIGN KEY (`servidores`)
    REFERENCES `almoxarifado`.`servidores` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
