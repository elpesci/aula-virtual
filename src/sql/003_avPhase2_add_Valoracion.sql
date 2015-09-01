CREATE TABLE `Valoracion` (
  `examenId` int(11) NOT NULL DEFAULT '0',
  `usuarioId` int(11) NOT NULL DEFAULT '0',
  `preguntasExamen` int(11) DEFAULT NULL,
  `preguntasCorrectas` int(11) DEFAULT NULL,
  `examen` blob,
  `creadoPor` int(11) DEFAULT NULL,
  `fechaCreacion` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`examenId`,`usuarioId`),
  KEY `Valoracion_fk2` (`usuarioId`),
  CONSTRAINT `Valoracion_fk2` FOREIGN KEY (`usuarioId`) REFERENCES `Usuario` (`usuarioId`),
  CONSTRAINT `Valoracion_fk1` FOREIGN KEY (`examenId`) REFERENCES `Examen` (`examenId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8