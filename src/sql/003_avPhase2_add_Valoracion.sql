CREATE TABLE `Valoracion` (
  `examenId` int(11) NOT NULL DEFAULT '0',
  `usuarioId` int(11) NOT NULL DEFAULT '0',
  `preguntasExamen` int(11) DEFAULT NULL,
  `preguntasCorrectas` int(11) DEFAULT NULL,
  `examen` blob,
  `creadoPor` int(11) DEFAULT NULL,
  `fechaCreacion` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`examenId`,`usuarioId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8