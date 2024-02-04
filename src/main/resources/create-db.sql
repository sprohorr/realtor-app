-- MySQL Workbench Forward Engineering

SET
@OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET
@OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET
@OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema realtor_app
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `realtor_app` DEFAULT CHARACTER SET utf8;
USE
`realtor_app` ;


-- -----------------------------------------------------
-- Table `realtor_app`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `realtor_app`.`role`
(
    `id`
    INT
    NOT
    NULL
    AUTO_INCREMENT,
    `name`
    VARCHAR
(
    255
) NOT NULL,
    PRIMARY KEY
(
    `id`
));


-- -----------------------------------------------------
-- Table `realtor_app`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `realtor_app`.`user`
(
    `id`
    INT
    NOT
    NULL
    AUTO_INCREMENT,
    `name`
    VARCHAR
(
    45
) NULL,
    `surname` VARCHAR
(
    45
) NULL,
    `email` VARCHAR
(
    255
) NULL,
    `login` VARCHAR
(
    45
) NOT NULL,
    `password` VARCHAR
(
    64
) NOT NULL,
    `create_time` DATETIME NULL,
    `update_time` DATETIME NULL,
    `role_id` INT NOT NULL,
    PRIMARY KEY
(
    `id`
),
    INDEX `fk_client_role1_idx`
(
    `role_id` ASC
) VISIBLE,
    UNIQUE INDEX `login_UNIQUE`
(
    `login` ASC
) VISIBLE,
    CONSTRAINT `fk_client_role1`
    FOREIGN KEY
(
    `role_id`
)
    REFERENCES `realtor_app`.`role`
(
    `id`
)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `realtor_app`.`building`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `realtor_app`.`building`
(
    `id`
    INT
    NOT
    NULL
    AUTO_INCREMENT,
    `address`
    VARCHAR
(
    255
) NULL,
    `floors` INT NULL,
    `land_area` DOUBLE NULL,
    `building_area` DOUBLE NULL,
    `quantity_apartments` INT NULL,
    `year` INT NULL,
    `parking` CHAR
(
    1
) NULL,
    `description` VARCHAR
(
    255
) NULL,
    PRIMARY KEY
(
    `id`
));


-- -----------------------------------------------------
-- Table `realtor_app`.`realty_agent`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `realtor_app`.`realty_agent`
(
    `id`
    INT
    NOT
    NULL
    AUTO_INCREMENT,
    `name`
    VARCHAR
(
    255
) NULL,
    `tel` INT NULL,
    `email` VARCHAR
(
    45
) NULL,
    `address` VARCHAR
(
    45
) NULL,
    PRIMARY KEY
(
    `id`
));


-- -----------------------------------------------------
-- Table `realtor_app`.`apartment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `realtor_app`.`apartment`
(
    `id`
    INT
    NOT
    NULL
    AUTO_INCREMENT,
    `number_apartment`
    INT
    NULL,
    `quantity_rooms`
    INT
    NULL,
    `apartment_area`
    DOUBLE
    NULL,
    `price`
    DOUBLE
    NULL,
    `status`
    CHAR
(
    1
) NULL,
    `description` VARCHAR
(
    255
) NULL,
    `building_id` INT NOT NULL,
    `realty_agent_id` INT NOT NULL,
    PRIMARY KEY
(
    `id`
),
    INDEX `fk_apartment_building1_idx`
(
    `building_id` ASC
) VISIBLE,
    INDEX `fk_apartment_realty_agent1_idx`
(
    `realty_agent_id` ASC
) VISIBLE,
    CONSTRAINT `fk_apartment_building1`
    FOREIGN KEY
(
    `building_id`
)
    REFERENCES `realtor_app`.`building`
(
    `id`
)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_apartment_realty_agent1`
    FOREIGN KEY
(
    `realty_agent_id`
)
    REFERENCES `realtor_app`.`realty_agent`
(
    `id`
)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `realtor_app`.`status_order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `realtor_app`.`status_order`
(
    `id`
    INT
    NOT
    NULL
    AUTO_INCREMENT,
    `name`
    VARCHAR
(
    45
) NULL,
    PRIMARY KEY
(
    `id`
));


-- -----------------------------------------------------
-- Table `realtor_app`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `realtor_app`.`order`
(
    `id`
    INT
    ZEROFILL
    NOT
    NULL
    AUTO_INCREMENT,
    `open_time`
    DATETIME
    NULL,
    `close_time`
    DATETIME
    NULL,
    `user_id`
    INT
    NOT
    NULL,
    `status_order_id`
    INT
    NOT
    NULL,
    `apartment_id`
    INT
    NOT
    NULL,
    PRIMARY
    KEY
(
    `id`
),
    INDEX `fk_order_user1_idx`
(
    `user_id` ASC
) VISIBLE,
    INDEX `fk_order_status_order1_idx`
(
    `status_order_id` ASC
) VISIBLE,
    INDEX `fk_order_apartment1_idx`
(
    `apartment_id` ASC
) VISIBLE,
    CONSTRAINT `fk_order_user1`
    FOREIGN KEY
(
    `user_id`
)
    REFERENCES `realtor_app`.`user`
(
    `id`
)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_order_status_order1`
    FOREIGN KEY
(
    `status_order_id`
)
    REFERENCES `realtor_app`.`status_order`
(
    `id`
)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_order_apartment1`
    FOREIGN KEY
(
    `apartment_id`
)
    REFERENCES `realtor_app`.`apartment`
(
    `id`
)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `realtor_app`.`feedback`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `realtor_app`.`feedback`
(
    `id`
    INT
    NOT
    NULL
    AUTO_INCREMENT,
    `description`
    VARCHAR
(
    255
) NULL,
    `grade` INT NULL,
    `create_time` DATETIME NULL,
    `user_id` INT NOT NULL,
    `apartment_id` INT NOT NULL,
    PRIMARY KEY
(
    `id`
),
    INDEX `fk_feedback_user1_idx`
(
    `user_id` ASC
) VISIBLE,
    INDEX `fk_feedback_apartment1_idx`
(
    `apartment_id` ASC
) VISIBLE,
    CONSTRAINT `fk_feedback_user1`
    FOREIGN KEY
(
    `user_id`
)
    REFERENCES `realtor_app`.`user`
(
    `id`
)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_feedback_apartment1`
    FOREIGN KEY
(
    `apartment_id`
)
    REFERENCES `realtor_app`.`apartment`
(
    `id`
)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


SET
SQL_MODE=@OLD_SQL_MODE;
SET
FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET
UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;