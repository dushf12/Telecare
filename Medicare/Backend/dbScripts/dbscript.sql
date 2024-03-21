-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema medicare
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema medicare
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `medicare` DEFAULT CHARACTER SET utf8 ;
USE `medicare` ;

-- -----------------------------------------------------
-- Table `medicare`.`admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medicare`.`admin` (
  `admin_id` INT(11) NOT NULL,
  `age` INT(11) NULL DEFAULT NULL,
  `alt_contact_number` BIGINT(20) NULL DEFAULT NULL,
  `dob` DATETIME NULL DEFAULT NULL,
  `email_id` VARCHAR(255) NULL DEFAULT NULL,
  `first_name` VARCHAR(255) NULL DEFAULT NULL,
  `gender` VARCHAR(255) NULL DEFAULT NULL,
  `last_name` VARCHAR(255) NULL DEFAULT NULL,
  `contact_number` BIGINT(20) NULL DEFAULT NULL,
  `password` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`admin_id`))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `medicare`.`doctor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medicare`.`doctor` (
  `doctor_id` INT(11) NOT NULL AUTO_INCREMENT,
  `address_line1` VARCHAR(255) NULL DEFAULT NULL,
  `address_line2` VARCHAR(255) NULL DEFAULT NULL,
  `age` INT(11) NULL DEFAULT NULL,
  `alt_contact_number` INT(11) NULL DEFAULT NULL,
  `city` VARCHAR(255) NULL DEFAULT NULL,
  `clinic_name` VARCHAR(255) NULL DEFAULT NULL,
  `zip_code` VARCHAR(255) NULL DEFAULT NULL,
  `degree` VARCHAR(255) NULL DEFAULT NULL,
  `dob` DATETIME NULL DEFAULT NULL,
  `email_id` VARCHAR(255) NULL DEFAULT NULL,
  `first_name` VARCHAR(255) NULL DEFAULT NULL,
  `gender` VARCHAR(255) NULL DEFAULT NULL,
  `last_name` VARCHAR(255) NULL DEFAULT NULL,
  `medicare_service_id` INT(11) NULL DEFAULT NULL,
  `contact_number` INT(11) NULL DEFAULT NULL,
  `password` VARCHAR(255) NULL DEFAULT NULL,
  `specality` VARCHAR(255) NULL DEFAULT NULL,
  `state` VARCHAR(255) NULL DEFAULT NULL,
  `work_hours` VARCHAR(255) NULL DEFAULT NULL,
  `medicare_service` INT(11) NULL DEFAULT NULL,
  `do_status` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`doctor_id`),
  INDEX `FK3kol8wodrxq55uh0mqlqjx668` (`medicare_service` ASC))
ENGINE = MyISAM
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `medicare`.`doctor_patient`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medicare`.`doctor_patient` (
  `dp_do_id` INT(11) NOT NULL AUTO_INCREMENT,
  `dp_pa_id` INT(11) NOT NULL,
  PRIMARY KEY (`dp_do_id`, `dp_pa_id`),
  INDEX `FKilc6aanfnl1t5x49g6dy9sl3h` (`dp_pa_id` ASC))
ENGINE = MyISAM
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `medicare`.`medicare_services`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medicare`.`medicare_services` (
  `medicare_service_id` INT(11) NOT NULL AUTO_INCREMENT,
  `amount` INT(11) NULL DEFAULT NULL,
  `medicare_service` VARCHAR(255) NULL DEFAULT NULL,
  `service_description` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`medicare_service_id`))
ENGINE = MyISAM
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `medicare`.`patient`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medicare`.`patient` (
  `patient_id` INT(11) NOT NULL AUTO_INCREMENT,
  `address_line1` VARCHAR(255) NULL DEFAULT NULL,
  `address_line2` VARCHAR(255) NULL DEFAULT NULL,
  `age` INT(11) NULL DEFAULT NULL,
  `alt_contact_number` BIGINT(20) NULL DEFAULT NULL,
  `city` VARCHAR(255) NULL DEFAULT NULL,
  `zip_code` VARCHAR(255) NULL DEFAULT NULL,
  `dob` DATETIME NULL DEFAULT NULL,
  `email_id` VARCHAR(255) NULL DEFAULT NULL,
  `first_name` VARCHAR(255) NULL DEFAULT NULL,
  `gender` VARCHAR(255) NULL DEFAULT NULL,
  `last_name` VARCHAR(255) NULL DEFAULT NULL,
  `contact_number` BIGINT(20) NULL DEFAULT NULL,
  `password` VARCHAR(255) NULL DEFAULT NULL,
  `state` VARCHAR(255) NULL DEFAULT NULL,
  `pa_status` VARCHAR(255) NULL DEFAULT NULL,
  `dapprove_status` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`patient_id`))
ENGINE = MyISAM
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `medicare`.`patient_report`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medicare`.`patient_report` (
  `pr_da_id` INT(11) NOT NULL,
  `pr_re_id` INT(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`pr_da_id`, `pr_re_id`),
  INDEX `FKhrvxoerpa7ye5kj7peadiwkco` (`pr_re_id` ASC))
ENGINE = MyISAM
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `medicare`.`report`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medicare`.`report` (
  `report_id` INT(11) NOT NULL AUTO_INCREMENT,
  `diag_1_actual_value` VARCHAR(255) NULL DEFAULT NULL,
  `diag_2_actual_value` VARCHAR(255) NULL DEFAULT NULL,
  `diag_3_actual_value` VARCHAR(255) NULL DEFAULT NULL,
  `diag_4_actual_value` VARCHAR(255) NULL DEFAULT NULL,
  `diag_5_actual_value` VARCHAR(255) NULL DEFAULT NULL,
  `doctors_comments` VARCHAR(255) NULL DEFAULT NULL,
  `diag_1_normal_range` VARCHAR(255) NULL DEFAULT NULL,
  `diag_2_normal_range` VARCHAR(255) NULL DEFAULT NULL,
  `diag_3_normal_range` VARCHAR(255) NULL DEFAULT NULL,
  `diag_4_normal_range` VARCHAR(255) NULL DEFAULT NULL,
  `other_info` VARCHAR(255) NULL DEFAULT NULL,
  `service_data` DATE NULL DEFAULT NULL,
  `test_result_date` DATE NULL DEFAULT NULL,
  `customer_id` INT(11) NULL DEFAULT NULL,
  `doctor_id` INT(11) NULL DEFAULT NULL,
  `medicare_id` INT(11) NULL DEFAULT NULL,
  `dapprove_status` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`report_id`))
ENGINE = MyISAM
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `medicare`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medicare`.`role` (
  `ro_id` INT(11) NOT NULL AUTO_INCREMENT,
  `ro_name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`ro_id`))
ENGINE = MyISAM
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `medicare`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medicare`.`user` (
  `us_id` INT(11) NOT NULL AUTO_INCREMENT,
  `us_password` VARCHAR(255) NULL DEFAULT NULL,
  `us_name` VARCHAR(255) NULL DEFAULT NULL,
  `us_approve` VARCHAR(10) NULL DEFAULT NULL,
  PRIMARY KEY (`us_id`))
ENGINE = MyISAM
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `medicare`.`user_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medicare`.`user_role` (
  `ur_us_id` INT(11) NOT NULL,
  `ur_ro_id` INT(11) NOT NULL,
  PRIMARY KEY (`ur_us_id`, `ur_ro_id`),
  INDEX `FKjia4161ecu6h4p0egc2oc04lt` (`ur_ro_id` ASC))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
