ALTER TABLE `aula_virtual`.`Usuario`
 ADD COLUMN `habilitado` BIT(1) NOT NULL DEFAULT 1  AFTER `status` ;
