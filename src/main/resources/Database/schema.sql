-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema riwi_localstorage
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema riwi_localstorage
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `riwi_localstorage` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `riwi_localstorage` ;

-- -----------------------------------------------------
-- Table `riwi_localstorage`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `riwi_localstorage`.`roles` (
  `id` VARCHAR(255) NOT NULL,
  `description` TINYTEXT NULL DEFAULT NULL,
  `name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `riwi_localstorage`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `riwi_localstorage`.`users` (
  `id` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `firstname` VARCHAR(100) NOT NULL,
  `lastname` VARCHAR(100) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `phone` VARCHAR(20) NULL DEFAULT NULL,
  `rol_id` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKgqf6aajl2lwd68xv9ypxpo7ra` (`rol_id` ASC) VISIBLE,
  CONSTRAINT `FKgqf6aajl2lwd68xv9ypxpo7ra`
    FOREIGN KEY (`rol_id`)
    REFERENCES `riwi_localstorage`.`roles` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `riwi_localstorage`.`stores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `riwi_localstorage`.`stores` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `user_id` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKiw281hibigo41ijsvot42osjj` (`user_id` ASC) VISIBLE,
  CONSTRAINT `FKiw281hibigo41ijsvot42osjj`
    FOREIGN KEY (`user_id`)
    REFERENCES `riwi_localstorage`.`users` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `riwi_localstorage`.`branches`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `riwi_localstorage`.`branches` (
  `id` VARCHAR(255) NOT NULL,
  `city` VARCHAR(50) NULL DEFAULT NULL,
  `country` VARCHAR(50) NULL DEFAULT NULL,
  `email` VARCHAR(50) NULL DEFAULT NULL,
  `phone` VARCHAR(50) NULL DEFAULT NULL,
  `postal_code` VARCHAR(50) NULL DEFAULT NULL,
  `province` VARCHAR(50) NULL DEFAULT NULL,
  `store_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKc2bywqbckf4tnouya6o5q9rbg` (`store_id` ASC) VISIBLE,
  CONSTRAINT `FKc2bywqbckf4tnouya6o5q9rbg`
    FOREIGN KEY (`store_id`)
    REFERENCES `riwi_localstorage`.`stores` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `riwi_localstorage`.`cash_machines`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `riwi_localstorage`.`cash_machines` (
  `id` VARCHAR(255) NOT NULL,
  `branch_id` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK2k8fwg136olx6lyh51o3ysmqk` (`branch_id` ASC) VISIBLE,
  CONSTRAINT `FK2k8fwg136olx6lyh51o3ysmqk`
    FOREIGN KEY (`branch_id`)
    REFERENCES `riwi_localstorage`.`branches` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `riwi_localstorage`.`cash_registers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `riwi_localstorage`.`cash_registers` (
  `id` VARCHAR(255) NOT NULL,
  `cash_id` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKp6tukg2n4xglew0vryouqv0ye` (`cash_id` ASC) VISIBLE,
  CONSTRAINT `FKp6tukg2n4xglew0vryouqv0ye`
    FOREIGN KEY (`cash_id`)
    REFERENCES `riwi_localstorage`.`cash_machines` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `riwi_localstorage`.`categories`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `riwi_localstorage`.`categories` (
  `id` VARCHAR(255) NOT NULL,
  `description` TINYTEXT NULL DEFAULT NULL,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `riwi_localstorage`.`discount`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `riwi_localstorage`.`discount` (
  `id` VARCHAR(255) NOT NULL,
  `amount` DOUBLE NOT NULL,
  `code` VARCHAR(255) NOT NULL,
  `discount_date` DATETIME(6) NOT NULL,
  `is_active` BIT(1) NOT NULL,
  `type` ENUM('FIXED', 'PERCENTAGE') NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `riwi_localstorage`.`inventories`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `riwi_localstorage`.`inventories` (
  `id` VARCHAR(255) NOT NULL,
  `expiration_date` DATETIME(6) NOT NULL,
  `last_update_date` DATETIME(6) NOT NULL,
  `product_id` VARCHAR(255) NOT NULL,
  `quantity` DOUBLE NOT NULL,
  `store_id` VARCHAR(255) NOT NULL,
  `supplier_order_id` VARCHAR(255) NOT NULL,
  `branch_id` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKgs563w23gys2co425wraxaj1o` (`branch_id` ASC) VISIBLE,
  CONSTRAINT `FKgs563w23gys2co425wraxaj1o`
    FOREIGN KEY (`branch_id`)
    REFERENCES `riwi_localstorage`.`branches` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `riwi_localstorage`.`memberships`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `riwi_localstorage`.`memberships` (
  `id` VARCHAR(255) NOT NULL,
  `description` TINYTEXT NULL DEFAULT NULL,
  `price` DOUBLE NOT NULL,
  `type` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `riwi_localstorage`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `riwi_localstorage`.`product` (
  `id` VARCHAR(255) NOT NULL,
  `barcode` VARCHAR(255) NOT NULL,
  `buying_price` DOUBLE NULL DEFAULT NULL,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  `name` VARCHAR(255) NOT NULL,
  `selling_price` DOUBLE NOT NULL,
  `category_id` VARCHAR(255) NULL DEFAULT NULL,
  `inventory_id` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKowomku74u72o6h8q0khj7id8q` (`category_id` ASC) VISIBLE,
  INDEX `FK6rdxa127jnos0svq4qslclvmj` (`inventory_id` ASC) VISIBLE,
  CONSTRAINT `FK6rdxa127jnos0svq4qslclvmj`
    FOREIGN KEY (`inventory_id`)
    REFERENCES `riwi_localstorage`.`inventories` (`id`),
  CONSTRAINT `FKowomku74u72o6h8q0khj7id8q`
    FOREIGN KEY (`category_id`)
    REFERENCES `riwi_localstorage`.`categories` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `riwi_localstorage`.`sale`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `riwi_localstorage`.`sale` (
  `id` VARCHAR(255) NOT NULL,
  `customer` VARCHAR(255) NULL DEFAULT NULL,
  `date` DATETIME(6) NOT NULL,
  `sub_total` DOUBLE NOT NULL,
  `tax` DOUBLE NOT NULL,
  `total` DOUBLE NOT NULL,
  `branch_id` VARCHAR(255) NOT NULL,
  `cash_id` VARCHAR(255) NOT NULL,
  `discount_id` VARCHAR(255) NOT NULL,
  `user_id` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKorbdw0epdrh8k46pvugwmabdy` (`branch_id` ASC) VISIBLE,
  INDEX `FKr4tmpclsq5tgfpgip911xld0h` (`cash_id` ASC) VISIBLE,
  INDEX `FKop9od3rmdfsl8ab46lcxkv53f` (`discount_id` ASC) VISIBLE,
  INDEX `FKa2s1ujlsxsr9sffgbrqst4bgk` (`user_id` ASC) VISIBLE,
  CONSTRAINT `FKa2s1ujlsxsr9sffgbrqst4bgk`
    FOREIGN KEY (`user_id`)
    REFERENCES `riwi_localstorage`.`users` (`id`),
  CONSTRAINT `FKop9od3rmdfsl8ab46lcxkv53f`
    FOREIGN KEY (`discount_id`)
    REFERENCES `riwi_localstorage`.`discount` (`id`),
  CONSTRAINT `FKorbdw0epdrh8k46pvugwmabdy`
    FOREIGN KEY (`branch_id`)
    REFERENCES `riwi_localstorage`.`branches` (`id`),
  CONSTRAINT `FKr4tmpclsq5tgfpgip911xld0h`
    FOREIGN KEY (`cash_id`)
    REFERENCES `riwi_localstorage`.`cash_machines` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `riwi_localstorage`.`sale_detail`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `riwi_localstorage`.`sale_detail` (
  `id` VARCHAR(255) NOT NULL,
  `quantity` DOUBLE NOT NULL,
  `total` DOUBLE NOT NULL,
  `unit_price` DOUBLE NOT NULL,
  `inventory_id` VARCHAR(255) NULL DEFAULT NULL,
  `sale_id` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKns55paqou6wr5so1ahchg6ggj` (`inventory_id` ASC) VISIBLE,
  INDEX `FKgnpg9v1mvi1nyhc18vdcyuh98` (`sale_id` ASC) VISIBLE,
  CONSTRAINT `FKgnpg9v1mvi1nyhc18vdcyuh98`
    FOREIGN KEY (`sale_id`)
    REFERENCES `riwi_localstorage`.`sale` (`id`),
  CONSTRAINT `FKns55paqou6wr5so1ahchg6ggj`
    FOREIGN KEY (`inventory_id`)
    REFERENCES `riwi_localstorage`.`inventories` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `riwi_localstorage`.`subscritions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `riwi_localstorage`.`subscritions` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `end_date` DATE NULL DEFAULT NULL,
  `purchase_date` DATE NULL DEFAULT NULL,
  `status` ENUM('ACTIVE', 'BLOCKED', 'INACTIVE') NULL DEFAULT NULL,
  `membership_id` VARCHAR(255) NOT NULL,
  `user_id` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UKqt3yppvahc6624ui1rdatw38u` (`user_id` ASC) VISIBLE,
  INDEX `FK6ae036fx4m8vssl7swgda4jkj` (`membership_id` ASC) VISIBLE,
  CONSTRAINT `FK349r1jpx4jy1ti51a7l6hv0rn`
    FOREIGN KEY (`user_id`)
    REFERENCES `riwi_localstorage`.`users` (`id`),
  CONSTRAINT `FK6ae036fx4m8vssl7swgda4jkj`
    FOREIGN KEY (`membership_id`)
    REFERENCES `riwi_localstorage`.`memberships` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `riwi_localstorage`.`supplier`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `riwi_localstorage`.`supplier` (
  `id` VARCHAR(255) NOT NULL,
  `address` VARCHAR(255) NOT NULL,
  `contact` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `phone` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `riwi_localstorage`.`supplier_order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `riwi_localstorage`.`supplier_order` (
  `id` VARCHAR(255) NOT NULL,
  `note` VARCHAR(255) NULL DEFAULT NULL,
  `sub_total` DOUBLE NOT NULL,
  `tax` DOUBLE NOT NULL,
  `total` DOUBLE NOT NULL,
  `inventory_id` VARCHAR(255) NULL DEFAULT NULL,
  `supplier_id` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK3yr85rsb12d8c1uml4wmjfpjn` (`inventory_id` ASC) VISIBLE,
  INDEX `FK3rpubvv45ovmdbs8e8eedhj3b` (`supplier_id` ASC) VISIBLE,
  CONSTRAINT `FK3rpubvv45ovmdbs8e8eedhj3b`
    FOREIGN KEY (`supplier_id`)
    REFERENCES `riwi_localstorage`.`supplier` (`id`),
  CONSTRAINT `FK3yr85rsb12d8c1uml4wmjfpjn`
    FOREIGN KEY (`inventory_id`)
    REFERENCES `riwi_localstorage`.`inventories` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
