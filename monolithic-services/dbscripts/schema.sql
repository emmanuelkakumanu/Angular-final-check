create database moviecruiser;
use moviecruiser;

create table user(
us_id int NOT NULL auto_increment,
us_username varchar(45) NOT NULL,
us_password varchar(200) NOT NULL,
PRIMARY KEY (`us_id`)
);



create table role(
ro_id int NOT NULL auto_increment,
ro_name varchar(45) NOT NULL,
PRIMARY KEY (`ro_id`)
);

CREATE TABLE IF NOT EXISTS user_role(
  `ur_id` INT NOT NULL AUTO_INCREMENT,
  `ur_us_id` INT NULL,
  `ur_ro_id` INT NULL,
  PRIMARY KEY (`ur_id`),
  INDEX `ur_us_fk_idx` (`ur_us_id` ASC),
  INDEX `ur_ro_fk_idx` (`ur_ro_id` ASC),
  CONSTRAINT `ur_us_fk`
    FOREIGN KEY (`ur_us_id`)
    REFERENCES user (`us_id`)
   ,
  CONSTRAINT `ur_ro_fk`
    FOREIGN KEY (`ur_ro_id`)
    REFERENCES role(`ro_id`)
    )
ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS movie (
  `mo_id` INT NOT NULL AUTO_INCREMENT,
  `mo_name` VARCHAR(100) NULL,
  `mo_box_office` BIGINT NULL,
  `mo_active` BOOLEAN NULL,
  `mo_date_of_launch` DATE NULL,
  `mo_genre` VARCHAR(45) NULL,
  `mo_has_teaser` BOOLEAN NULL,
  `mo_image_url` VARCHAR(200) NULL,
  `mo_teaser_url` VARCHAR(200) NULL,
  PRIMARY KEY (`mo_id`))
ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS favorites (
  `fa_id` INT NOT NULL AUTO_INCREMENT,
  `fa_us_id` INT NULL,
  `fa_mo_id` INT NULL,
  PRIMARY KEY (`fa_id`),
  INDEX `fa_us_fk_idx` (`fa_us_id` ASC),
  INDEX `fa_mo_fk_idx` (`fa_mo_id` ASC),
  CONSTRAINT `fa_us_fk`
    FOREIGN KEY (`fa_us_id`)
    REFERENCES user (`us_id`),
  CONSTRAINT `fa_mo_fk`
    FOREIGN KEY (`fa_mo_id`)
    REFERENCES movie (`mo_id`)
   )
ENGINE = InnoDB;


show tables;