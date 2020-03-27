drop table if exists member_role;
drop table if exists member;


-- -----------------------------------------------------
-- Table `member`
-- -----------------------------------------------------
CREATE TABLE `member` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'member id',
  `name` VARCHAR(255) NOT NULL COMMENT 'member name',
  `password` VARCHAR(255) NOT NULL COMMENT '암호회된 password',
  `email` VARCHAR(255) NOT NULL UNIQUE COMMENT 'login id, email',
  `create_date` DATETIME NULL DEFAULT NULL COMMENT '등록일',
  `modify_date` DATETIME NULL DEFAULT NULL COMMENT '수정일',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- -----------------------------------------------------
-- Table `member_role`
-- -----------------------------------------------------
CREATE TABLE `member_role` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'role id',
  `member_id` INT(11) NOT NULL COMMENT 'member id fk',
  `role_name` VARCHAR(100) NOT NULL COMMENT 'role 이름 ROLE_ 로 시작하는 값이어야 한다.',
  PRIMARY KEY (`id`),
  FOREIGN KEY (`member_id`)
  REFERENCES `member` (`id`)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8;