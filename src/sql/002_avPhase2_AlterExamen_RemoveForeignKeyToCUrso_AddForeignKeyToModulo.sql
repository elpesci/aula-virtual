ALTER TABLE `aula_virtual`.`Examen` DROP INDEX `fk_Examen_Curso1` ;
ALTER TABLE `aula_virtual`.`Examen` DROP COLUMN `cursoId` , ADD COLUMN `moduloId` INT(11) NOT NULL  AFTER `examenId` , 
  ADD CONSTRAINT `fk_Examen_Modulo1`
  FOREIGN KEY (`moduloId` )
  REFERENCES `aula_virtual`.`Modulo` (`moduloId` )
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
, ADD INDEX `fk_Examen_Modulo1` (`moduloId` ASC);

