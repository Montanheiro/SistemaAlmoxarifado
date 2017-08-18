-- MySQL Script generated by MySQL Workbench
-- Sex 18 Ago 2017 02:48:20 BRT
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema almoxarifado
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `almoxarifado` ;

-- -----------------------------------------------------
-- Schema almoxarifado
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `almoxarifado` DEFAULT CHARACTER SET utf8 ;
USE `almoxarifado` ;

-- -----------------------------------------------------
-- Table `almoxarifado`.`fornecedores`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `almoxarifado`.`fornecedores` ;

CREATE TABLE IF NOT EXISTS `almoxarifado`.`fornecedores` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `razao_social` VARCHAR(255) NOT NULL,
  `nome_fantasia` VARCHAR(255) NOT NULL,
  `cnpj` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almoxarifado`.`empenhos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `almoxarifado`.`empenhos` ;

CREATE TABLE IF NOT EXISTS `almoxarifado`.`empenhos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fornecedor` INT NOT NULL,
  `emissao` TIMESTAMP NOT NULL,
  `numero` VARCHAR(30) NOT NULL,
  `observacao` VARCHAR(255) NULL,
  `valor_total` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`id`, `fornecedor`),
  INDEX `fk_empenhos_fornecedores1_idx` (`fornecedor` ASC),
  CONSTRAINT `fk_empenhos_fornecedores1`
    FOREIGN KEY (`fornecedor`)
    REFERENCES `almoxarifado`.`fornecedores` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almoxarifado`.`setores`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `almoxarifado`.`setores` ;

CREATE TABLE IF NOT EXISTS `almoxarifado`.`setores` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  `sigla` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almoxarifado`.`servidores`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `almoxarifado`.`servidores` ;

CREATE TABLE IF NOT EXISTS `almoxarifado`.`servidores` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `setor` INT NOT NULL,
  `nome` VARCHAR(255) NOT NULL,
  `siape` VARCHAR(255) NOT NULL,
  `funcao` VARCHAR(255) NULL,
  PRIMARY KEY (`id`, `setor`),
  INDEX `fk_servidores_setores1_idx` (`setor` ASC),
  CONSTRAINT `fk_servidores_setores1`
    FOREIGN KEY (`setor`)
    REFERENCES `almoxarifado`.`setores` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almoxarifado`.`enderecos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `almoxarifado`.`enderecos` ;

CREATE TABLE IF NOT EXISTS `almoxarifado`.`enderecos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fornecedor` INT NOT NULL,
  `cidade` VARCHAR(255) NOT NULL,
  `bairro` VARCHAR(255) NULL,
  `cep` VARCHAR(40) NOT NULL,
  `numero` VARCHAR(45) NOT NULL,
  `complemento` VARCHAR(255) NULL,
  `logradouro` VARCHAR(255) NOT NULL,
  `estado` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`, `fornecedor`),
  INDEX `fk_enderecos_fornecedores1_idx` (`fornecedor` ASC),
  CONSTRAINT `fk_enderecos_fornecedores1`
    FOREIGN KEY (`fornecedor`)
    REFERENCES `almoxarifado`.`fornecedores` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almoxarifado`.`unidades`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `almoxarifado`.`unidades` ;

CREATE TABLE IF NOT EXISTS `almoxarifado`.`unidades` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  `abreviacao` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almoxarifado`.`produtos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `almoxarifado`.`produtos` ;

CREATE TABLE IF NOT EXISTS `almoxarifado`.`produtos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `unidade` INT NOT NULL,
  `descricao` VARCHAR(255) NOT NULL,
  `estoque` DOUBLE NOT NULL,
  `estoque_minimo` DOUBLE NULL,
  PRIMARY KEY (`id`, `unidade`),
  INDEX `fk_produtos_unidades1_idx` (`unidade` ASC),
  CONSTRAINT `fk_produtos_unidades1`
    FOREIGN KEY (`unidade`)
    REFERENCES `almoxarifado`.`unidades` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almoxarifado`.`alunos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `almoxarifado`.`alunos` ;

CREATE TABLE IF NOT EXISTS `almoxarifado`.`alunos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  `matricula` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almoxarifado`.`visitantes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `almoxarifado`.`visitantes` ;

CREATE TABLE IF NOT EXISTS `almoxarifado`.`visitantes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `setor` INT NOT NULL,
  `quantidade` INT NOT NULL,
  PRIMARY KEY (`id`, `setor`),
  INDEX `fk_visitantes_setores1_idx` (`setor` ASC),
  CONSTRAINT `fk_visitantes_setores1`
    FOREIGN KEY (`setor`)
    REFERENCES `almoxarifado`.`setores` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almoxarifado`.`contatos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `almoxarifado`.`contatos` ;

CREATE TABLE IF NOT EXISTS `almoxarifado`.`contatos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fornecedor` INT NOT NULL,
  `nome` VARCHAR(255) NOT NULL,
  `telefone` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`, `fornecedor`),
  INDEX `fk_contatos_fornecedores1_idx` (`fornecedor` ASC),
  CONSTRAINT `fk_contatos_fornecedores1`
    FOREIGN KEY (`fornecedor`)
    REFERENCES `almoxarifado`.`fornecedores` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almoxarifado`.`entradas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `almoxarifado`.`entradas` ;

CREATE TABLE IF NOT EXISTS `almoxarifado`.`entradas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `nf_numero` VARCHAR(255) NULL,
  `origem` TINYINT NOT NULL,
  `observacao` VARCHAR(255) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almoxarifado`.`entrada_itens`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `almoxarifado`.`entrada_itens` ;

CREATE TABLE IF NOT EXISTS `almoxarifado`.`entrada_itens` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `produto` INT NOT NULL,
  `entrada` INT NOT NULL,
  `quantidade` DOUBLE NOT NULL,
  `validade` TIMESTAMP NOT NULL,
  `lote` VARCHAR(255) NULL,
  `considerar_valorempenho` TINYINT NOT NULL,
  `valor_unitario` DOUBLE NOT NULL,
  PRIMARY KEY (`id`, `produto`, `entrada`),
  INDEX `fk_entradas_produtos1_idx` (`produto` ASC),
  INDEX `fk_entrada_itens_entradas1_idx` (`entrada` ASC),
  CONSTRAINT `fk_entradas_produtos1`
    FOREIGN KEY (`produto`)
    REFERENCES `almoxarifado`.`produtos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_entrada_itens_entradas1`
    FOREIGN KEY (`entrada`)
    REFERENCES `almoxarifado`.`entradas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almoxarifado`.`requisicoes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `almoxarifado`.`requisicoes` ;

CREATE TABLE IF NOT EXISTS `almoxarifado`.`requisicoes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `servidor` INT NOT NULL,
  `data` TIMESTAMP NOT NULL,
  `observacao` VARCHAR(300) NULL,
  PRIMARY KEY (`id`, `servidor`),
  INDEX `fk_requisicoes_servidores1_idx` (`servidor` ASC),
  CONSTRAINT `fk_requisicoes_servidores1`
    FOREIGN KEY (`servidor`)
    REFERENCES `almoxarifado`.`servidores` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almoxarifado`.`produtos_fornecedores`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `almoxarifado`.`produtos_fornecedores` ;

CREATE TABLE IF NOT EXISTS `almoxarifado`.`produtos_fornecedores` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `fornecedores` INT NOT NULL,
  `produtos` INT NOT NULL,
  PRIMARY KEY (`id`, `fornecedores`, `produtos`),
  INDEX `fk_fornecedores_has_produtos_produtos1_idx` (`produtos` ASC),
  INDEX `fk_fornecedores_has_produtos_fornecedores1_idx` (`fornecedores` ASC),
  CONSTRAINT `fk_fornecedores_has_produtos_fornecedores1`
    FOREIGN KEY (`fornecedores`)
    REFERENCES `almoxarifado`.`fornecedores` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_fornecedores_has_produtos_produtos1`
    FOREIGN KEY (`produtos`)
    REFERENCES `almoxarifado`.`produtos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almoxarifado`.`produtos_requisicoes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `almoxarifado`.`produtos_requisicoes` ;

CREATE TABLE IF NOT EXISTS `almoxarifado`.`produtos_requisicoes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `requisicao` INT NOT NULL,
  `produto` INT NOT NULL,
  `quantidade` DOUBLE NOT NULL,
  PRIMARY KEY (`id`, `requisicao`, `produto`),
  INDEX `fk_requisicoes_has_produtos_produtos1_idx` (`produto` ASC),
  INDEX `fk_requisicoes_has_produtos_requisicoes1_idx` (`requisicao` ASC),
  CONSTRAINT `fk_requisicoes_has_produtos_requisicoes1`
    FOREIGN KEY (`requisicao`)
    REFERENCES `almoxarifado`.`requisicoes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_requisicoes_has_produtos_produtos1`
    FOREIGN KEY (`produto`)
    REFERENCES `almoxarifado`.`produtos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almoxarifado`.`naturezas_despesas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `almoxarifado`.`naturezas_despesas` ;

CREATE TABLE IF NOT EXISTS `almoxarifado`.`naturezas_despesas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `codigo` VARCHAR(45) NOT NULL,
  `subitem` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almoxarifado`.`usuarios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `almoxarifado`.`usuarios` ;

CREATE TABLE IF NOT EXISTS `almoxarifado`.`usuarios` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `servidor` INT NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `senha` VARCHAR(255) NOT NULL,
  `status` TINYINT NOT NULL,
  `admin` TINYINT NOT NULL,
  PRIMARY KEY (`id`, `servidor`),
  INDEX `fk_usuarios_servidores1_idx` (`servidor` ASC),
  CONSTRAINT `fk_usuarios_servidores1`
    FOREIGN KEY (`servidor`)
    REFERENCES `almoxarifado`.`servidores` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almoxarifado`.`itens_empenho`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `almoxarifado`.`itens_empenho` ;

CREATE TABLE IF NOT EXISTS `almoxarifado`.`itens_empenho` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `produto` INT NOT NULL,
  `empenho` INT NOT NULL,
  `natureza_despesa` INT NOT NULL,
  `sequencia` INT NOT NULL,
  `quantidade` DOUBLE NOT NULL,
  `valor_unitario` DOUBLE NOT NULL,
  `item_processo` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`, `produto`, `empenho`, `natureza_despesa`),
  INDEX `fk_produtos_empenho_empenhos1_idx` (`empenho` ASC),
  INDEX `fk_produtos_empenho_naturezas_despesas1_idx` (`natureza_despesa` ASC),
  INDEX `fk_itens_empenho_produtos1_idx` (`produto` ASC),
  CONSTRAINT `fk_produtos_empenho_empenhos1`
    FOREIGN KEY (`empenho`)
    REFERENCES `almoxarifado`.`empenhos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_produtos_empenho_naturezas_despesas1`
    FOREIGN KEY (`natureza_despesa`)
    REFERENCES `almoxarifado`.`naturezas_despesas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_itens_empenho_produtos1`
    FOREIGN KEY (`produto`)
    REFERENCES `almoxarifado`.`produtos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almoxarifado`.`entradas_itensempenho`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `almoxarifado`.`entradas_itensempenho` ;

CREATE TABLE IF NOT EXISTS `almoxarifado`.`entradas_itensempenho` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `itens_empenho` INT NOT NULL,
  `entrada` INT NOT NULL,
  PRIMARY KEY (`id`, `itens_empenho`, `entrada`),
  INDEX `fk_produtos_empenho_has_entradas_entradas1_idx` (`entrada` ASC),
  INDEX `fk_produtos_empenho_has_entradas_produtos_empenho1_idx` (`itens_empenho` ASC),
  CONSTRAINT `fk_produtos_empenho_has_entradas_produtos_empenho1`
    FOREIGN KEY (`itens_empenho`)
    REFERENCES `almoxarifado`.`itens_empenho` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_produtos_empenho_has_entradas_entradas1`
    FOREIGN KEY (`entrada`)
    REFERENCES `almoxarifado`.`entrada_itens` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almoxarifado`.`tipos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `almoxarifado`.`tipos` ;

CREATE TABLE IF NOT EXISTS `almoxarifado`.`tipos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almoxarifado`.`doacoes_ou_transferencias`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `almoxarifado`.`doacoes_ou_transferencias` ;

CREATE TABLE IF NOT EXISTS `almoxarifado`.`doacoes_ou_transferencias` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tipo` INT NOT NULL,
  `responsavel` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`, `tipo`),
  INDEX `fk_doacoes_ou_transferencias_table11_idx` (`tipo` ASC),
  CONSTRAINT `fk_doacoes_ou_transferencias_table11`
    FOREIGN KEY (`tipo`)
    REFERENCES `almoxarifado`.`tipos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almoxarifado`.`entradas_doacaotransferencia`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `almoxarifado`.`entradas_doacaotransferencia` ;

CREATE TABLE IF NOT EXISTS `almoxarifado`.`entradas_doacaotransferencia` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `entrada` INT NOT NULL,
  `doacao_ou_transferencia` INT NOT NULL,
  PRIMARY KEY (`id`, `entrada`, `doacao_ou_transferencia`),
  INDEX `fk_entradas_has_doacao_ou_transferencia_doacao_ou_transfere_idx` (`doacao_ou_transferencia` ASC),
  INDEX `fk_entradas_has_doacao_ou_transferencia_entradas1_idx` (`entrada` ASC),
  CONSTRAINT `fk_entradas_has_doacao_ou_transferencia_entradas1`
    FOREIGN KEY (`entrada`)
    REFERENCES `almoxarifado`.`entrada_itens` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_entradas_has_doacao_ou_transferencia_doacao_ou_transferenc1`
    FOREIGN KEY (`doacao_ou_transferencia`)
    REFERENCES `almoxarifado`.`doacoes_ou_transferencias` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almoxarifado`.`saidas_produtos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `almoxarifado`.`saidas_produtos` ;

CREATE TABLE IF NOT EXISTS `almoxarifado`.`saidas_produtos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `produto_requisicao` INT NOT NULL,
  `quantidade` DOUBLE NOT NULL,
  `data` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`, `produto_requisicao`),
  INDEX `fk_saidasprodutos_produtos_requisicoes1_idx` (`produto_requisicao` ASC),
  CONSTRAINT `fk_saidasprodutos_produtos_requisicoes1`
    FOREIGN KEY (`produto_requisicao`)
    REFERENCES `almoxarifado`.`produtos_requisicoes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almoxarifado`.`patrimonio_atual`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `almoxarifado`.`patrimonio_atual` ;

CREATE TABLE IF NOT EXISTS `almoxarifado`.`patrimonio_atual` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `produto` INT NOT NULL,
  `quantidade` DOUBLE NOT NULL,
  `valortotal` DOUBLE NOT NULL,
  PRIMARY KEY (`id`, `produto`),
  INDEX `fk_entradas_mensais_produtos1_idx` (`produto` ASC),
  CONSTRAINT `fk_entradas_mensais_produtos1`
    FOREIGN KEY (`produto`)
    REFERENCES `almoxarifado`.`produtos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almoxarifado`.`historico_relatorios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `almoxarifado`.`historico_relatorios` ;

CREATE TABLE IF NOT EXISTS `almoxarifado`.`historico_relatorios` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `produto` INT NOT NULL,
  `mes` TIMESTAMP NOT NULL,
  `quantidade` DOUBLE NOT NULL,
  `valortotal` DOUBLE NOT NULL,
  PRIMARY KEY (`id`, `produto`),
  INDEX `fk_historico_relatorios_produtos1_idx` (`produto` ASC),
  CONSTRAINT `fk_historico_relatorios_produtos1`
    FOREIGN KEY (`produto`)
    REFERENCES `almoxarifado`.`produtos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almoxarifado`.`logs_erros`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `almoxarifado`.`logs_erros` ;

CREATE TABLE IF NOT EXISTS `almoxarifado`.`logs_erros` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `usuario` INT NOT NULL,
  `data` TIMESTAMP NOT NULL,
  `erro` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`id`, `usuario`),
  INDEX `fk_logs_erros_usuarios1_idx` (`usuario` ASC),
  CONSTRAINT `fk_logs_erros_usuarios1`
    FOREIGN KEY (`usuario`)
    REFERENCES `almoxarifado`.`usuarios` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
