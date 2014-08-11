

CREATE TABLE Alumno (
  alumnoId integer NOT NULL,
  personaId integer NOT NULL,
  creadoPor integer NOT NULL,
  fechaCreacion datetime NOT NULL,
  modificadoPor integer DEFAULT NULL,
  fechaModificacion datetime DEFAULT NULL,
  PRIMARY KEY (alumnoId)
  CONSTRAINT fk_Alumno_Persona1 FOREIGN KEY (personaId) REFERENCES Persona (personaId) ON DELETE NO ACTION ON UPDATE NO ACTION
);




CREATE TABLE Contenido (
  contenidoId integer NOT NULL,
  tipoContenidoId integer NOT NULL,
  cursoId integer NOT NULL,
  nombre varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  descripcion varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  archivoMaterial blob,
  creadoPor integer NOT NULL,
  fechaCreacion datetime NOT NULL,
  modificadoPor integer DEFAULT NULL,
  fechaModificacion varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (contenidoId)
  CONSTRAINT fk_Contenido_Curso1 FOREIGN KEY (cursoId) REFERENCES Curso (cursoId) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT fk_Contenido_TipoContenido1 FOREIGN KEY (tipoContenidoId) REFERENCES TipoContenido (tipoContenidoId) ON DELETE NO ACTION ON UPDATE NO ACTION
);


CREATE TABLE Curso (
  cursoId integer NOT NULL,
  nombre varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  objetivo varchar(500) COLLATE utf8_spanish_ci NOT NULL,
  audiencia varchar(500) COLLATE utf8_spanish_ci NOT NULL,
  habilitado tinyint(1) NOT NULL DEFAULT '1',
  creadoPor integer NOT NULL,
  fechaCreacion datetime NOT NULL,
  modificadoPor integer DEFAULT NULL,
  fechaModificacion datetime DEFAULT NULL,
  PRIMARY KEY (cursoId)
);


CREATE TABLE Evaluacion (
  sesionId integer NOT NULL,
  alumnoId integer NOT NULL,
  respuestaId integer NOT NULL,
  creadoPor integer NOT NULL,
  fechaCreacion datetime NOT NULL,
  modificadoPor integer DEFAULT NULL,
  fechaModificacion datetime DEFAULT NULL,
  PRIMARY KEY (sesionId,alumnoId,respuestaId)
  CONSTRAINT fk_SesionAlumno_has_Respuesta_Respuesta1 FOREIGN KEY (respuestaId) REFERENCES Respuesta (respuestaId) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT fk_SesionAlumno_has_Respuesta_SesionAlumno1 FOREIGN KEY (sesionId, alumnoId) REFERENCES SesionAlumno (Sesion_sesionId, Alumno_alumnoId) ON DELETE NO ACTION ON UPDATE NO ACTION
);




CREATE TABLE Examen (
  examenId integer NOT NULL,
  cursoId integer NOT NULL,
  numPreguntas smallint(6) NOT NULL,
  numRespuestasPregunta smallint(6) NOT NULL,
  creadoPor integer NOT NULL,
  fechaCreacion datetime NOT NULL,
  modificadoPor integer DEFAULT NULL,
  fechaModificacion datetime DEFAULT NULL,
  PRIMARY KEY (examenId)
  CONSTRAINT fk_Examen_Curso1 FOREIGN KEY (cursoId) REFERENCES Curso (cursoId) ON DELETE NO ACTION ON UPDATE NO ACTION
);




CREATE TABLE ExtensionContenido (
  extensionContenidoId integer NOT NULL,
  tipoContenidoId integer NOT NULL,
  extension varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  creadoPor integer NOT NULL,
  fechaCreacion datetime NOT NULL,
  modificadoPor integer DEFAULT NULL,
  fechaModificacion datetime DEFAULT NULL,
  PRIMARY KEY (extensionContenidoId)
  CONSTRAINT fk_ExtensionContenido_TipoContenido1 FOREIGN KEY (tipoContenidoId) REFERENCES TipoContenido (tipoContenidoId) ON DELETE NO ACTION ON UPDATE NO ACTION
);


INSERT INTO ExtensionContenido (extensionContenidoId, tipoContenidoId, extension, creadoPor, fechaCreacion, modificadoPor, fechaModificacion) VALUES (1,1,'.doc',0,'2014-07-26 15:34:19',NULL,NULL);
INSERT INTO ExtensionContenido (extensionContenidoId, tipoContenidoId, extension, creadoPor, fechaCreacion, modificadoPor, fechaModificacion) VALUES (2,1,'.docx',0,'2014-07-26 15:34:19',NULL,NULL);
INSERT INTO ExtensionContenido (extensionContenidoId, tipoContenidoId, extension, creadoPor, fechaCreacion, modificadoPor, fechaModificacion) VALUES (3,2,'.ppt',0,'2014-07-26 15:34:19',NULL,NULL);
INSERT INTO ExtensionContenido (extensionContenidoId, tipoContenidoId, extension, creadoPor, fechaCreacion, modificadoPor, fechaModificacion) VALUES (4,2,'.pptx',0,'2014-07-26 15:34:19',NULL,NULL);
INSERT INTO ExtensionContenido (extensionContenidoId, tipoContenidoId, extension, creadoPor, fechaCreacion, modificadoPor, fechaModificacion) VALUES (5,3,'.pdf',0,'2014-07-26 15:34:19',NULL,NULL);


CREATE TABLE Instructor (
  instructorId integer NOT NULL,
  personaId integer NOT NULL,
  creadoPor integer NOT NULL,
  fechaCreacion datetime NOT NULL,
  modificadoPor integer DEFAULT NULL,
  fechaModificacion datetime DEFAULT NULL,
  PRIMARY KEY (instructorId)
  CONSTRAINT fk_Instructor_Persona1 FOREIGN KEY (personaId) REFERENCES Persona (personaId) ON DELETE NO ACTION ON UPDATE NO ACTION
);




CREATE TABLE Perfil (
  perfilId integer NOT NULL,
  codigo varchar(15) COLLATE utf8_spanish_ci DEFAULT NULL,
  nombre varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  creadoPor integer NOT NULL,
  fechaCreacion datetime NOT NULL,
  modificadoPor integer DEFAULT NULL,
  fechaModificacion datetime DEFAULT NULL,
  PRIMARY KEY (perfilId)
);


INSERT INTO Perfil (perfilId, codigo, nombre, creadoPor, fechaCreacion, modificadoPor, fechaModificacion) VALUES (1,'SUPER_ADMIN','SuperAdmin',0,'2014-03-09 14:22:51',NULL,NULL);
INSERT INTO Perfil (perfilId, codigo, nombre, creadoPor, fechaCreacion, modificadoPor, fechaModificacion) VALUES (2,'COORDINADOR','Coordinador Capacitación',0,'2014-07-26 15:43:46',NULL,NULL);
INSERT INTO Perfil (perfilId, codigo, nombre, creadoPor, fechaCreacion, modificadoPor, fechaModificacion) VALUES (3,'INSTRUCTOR','Instructor',0,'2014-07-26 15:43:46',NULL,NULL);
INSERT INTO Perfil (perfilId, codigo, nombre, creadoPor, fechaCreacion, modificadoPor, fechaModificacion) VALUES (4,'ALUMNO','Alumno',0,'2014-07-26 15:43:46',NULL,NULL);


CREATE TABLE Persona (
  personaId integer NOT NULL,
  nombre varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  apellidoPaterno varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  apellidoMaterno varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  correoElectronico varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  creadoPor integer NOT NULL,
  fechaCreacion datetime NOT NULL,
  modificadoPor integer DEFAULT NULL,
  fechaModificacion datetime DEFAULT NULL,
  PRIMARY KEY (personaId)
);


INSERT INTO Persona (personaId, nombre, apellidoPaterno, apellidoMaterno, correoElectronico, creadoPor, fechaCreacion, modificadoPor, fechaModificacion) VALUES (1,'SuperAdmin','SuperAdmin','SuperAdmin','aulaVirtualAdmin@gmail.com',0,'2014-03-09 15:10:20',NULL,NULL);


CREATE TABLE Pregunta (
  preguntaId integer NOT NULL,
  examenId integer NOT NULL,
  textoPregunta varchar(500) COLLATE utf8_spanish_ci DEFAULT NULL,
  creadoPor integer NOT NULL,
  fechaCreacion datetime NOT NULL,
  modificadoPor integer DEFAULT NULL,
  fecha datetime DEFAULT NULL,
  PRIMARY KEY (preguntaId)
  CONSTRAINT fk_Pregunta_Examen1 FOREIGN KEY (examenId) REFERENCES Examen (examenId) ON DELETE NO ACTION ON UPDATE NO ACTION
);




CREATE TABLE RegistroAcceso (
  registroAccesoId integer NOT NULL,
  usuarioId integer NOT NULL,
  inicioAcceso datetime DEFAULT NULL,
  finAcceso datetime DEFAULT NULL,
  sessionId varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (registroAccesoId)
  CONSTRAINT fk_RegistroAcceso_Usuario1 FOREIGN KEY (usuarioId) REFERENCES Usuario (usuarioId) ON DELETE NO ACTION ON UPDATE NO ACTION
);




CREATE TABLE Respuesta (
  respuestaId integer NOT NULL,
  preguntaId integer NOT NULL,
  textoRespuesta varchar(500) COLLATE utf8_spanish_ci DEFAULT NULL,
  esRespuestaCorrecta tinyint(1) DEFAULT NULL,
  creadoPor integer NOT NULL,
  fechaCreacion datetime NOT NULL,
  modificadoPor integer DEFAULT NULL,
  fechaModificacion datetime DEFAULT NULL,
  PRIMARY KEY (respuestaId)
  CONSTRAINT fk_Respuesta_Pregunta1 FOREIGN KEY (preguntaId) REFERENCES Pregunta (preguntaId) ON DELETE NO ACTION ON UPDATE NO ACTION
);




CREATE TABLE Sesion (
  sesionId integer NOT NULL,
  cursoId integer NOT NULL,
  instructorId integer DEFAULT NULL,
  temporal tinyint(1) NOT NULL DEFAULT '1',
  fechaInicio datetime DEFAULT NULL,
  fechaFin datetime DEFAULT NULL,
  ubicacion varchar(150) COLLATE utf8_spanish_ci DEFAULT NULL,
  creadoPor integer NOT NULL,
  fechaCreacion datetime NOT NULL,
  modificadoPor integer DEFAULT NULL,
  fechaModificacion datetime DEFAULT NULL,
  PRIMARY KEY (sesionId)
  CONSTRAINT fk_Sesion_Curso FOREIGN KEY (cursoId) REFERENCES Curso (cursoId) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT fk_Sesion_Instructor1 FOREIGN KEY (instructorId) REFERENCES Instructor (instructorId) ON DELETE NO ACTION ON UPDATE NO ACTION
);




CREATE TABLE SesionAlumno (
  Sesion_sesionId integer NOT NULL,
  Alumno_alumnoId integer NOT NULL,
  calificacion decimal(10,0) DEFAULT NULL,
  creadoPor integer NOT NULL,
  fechaCreacion datetime NOT NULL,
  modificadoPor integer DEFAULT NULL,
  fechaModificacion datetime DEFAULT NULL,
  PRIMARY KEY (Sesion_sesionId,Alumno_alumnoId)
  CONSTRAINT fk_Sesion_has_Alumno_Alumno1 FOREIGN KEY (Alumno_alumnoId) REFERENCES Alumno (alumnoId) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT fk_Sesion_has_Alumno_Sesion1 FOREIGN KEY (Sesion_sesionId) REFERENCES Sesion (sesionId) ON DELETE NO ACTION ON UPDATE NO ACTION
);




CREATE TABLE TipoContenido (
  tipoContenidoId integer NOT NULL,
  descripcion varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  creadoPor integer NOT NULL,
  fechaCreacion datetime NOT NULL,
  modificadoPor integer DEFAULT NULL,
  fechaModificacion datetime DEFAULT NULL,
  PRIMARY KEY (tipoContenidoId)
);


INSERT INTO TipoContenido (tipoContenidoId, descripcion, creadoPor, fechaCreacion, modificadoPor, fechaModificacion) VALUES (1,'Archivo Word',0,'2014-07-26 15:30:06',NULL,NULL);
INSERT INTO TipoContenido (tipoContenidoId, descripcion, creadoPor, fechaCreacion, modificadoPor, fechaModificacion) VALUES (2,'Archivo PowerPoint',0,'2014-07-26 15:30:06',NULL,NULL);
INSERT INTO TipoContenido (tipoContenidoId, descripcion, creadoPor, fechaCreacion, modificadoPor, fechaModificacion) VALUES (3,'Archivo PDF',0,'2014-07-26 15:30:06',NULL,NULL);


CREATE TABLE Usuario (
  usuarioId integer NOT NULL,
  personaId integer NOT NULL,
  username varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  password varchar(60) COLLATE utf8_spanish_ci DEFAULT NULL,
  habilitado tinyint(1) NOT NULL DEFAULT '1',
  creadoPor integer NOT NULL,
  fechaCreacion datetime NOT NULL,
  modificadoPor integer DEFAULT NULL,
  fechaModificacion datetime DEFAULT NULL,
  PRIMARY KEY (usuarioId)
  CONSTRAINT fk_Usuario_Persona1 FOREIGN KEY (personaId) REFERENCES Persona (personaId) ON DELETE NO ACTION ON UPDATE NO ACTION
);


INSERT INTO Usuario (usuarioId, personaId, username, password, habilitado, creadoPor, fechaCreacion, modificadoPor, fechaModificacion) VALUES (1,1,'superadmin','$2a$10$QUqc3JzXySXJiAcYGLPgmuQgoFay7yCUi9pk0VoKZbVw9pCvM/uY6',1,0,'2014-07-27 12:35:37',NULL,NULL);
INSERT INTO Usuario (usuarioId, personaId, username, password, habilitado, creadoPor, fechaCreacion, modificadoPor, fechaModificacion) VALUES (2,3,'','$2a$10$8eigiOR1frP/BVW9b5/nqeYbHGrtk2YAlK2VzR/HNYJ6is2C7DaiC',1,0,'2014-08-04 23:40:57',NULL,NULL);
INSERT INTO Usuario (usuarioId, personaId, username, password, habilitado, creadoPor, fechaCreacion, modificadoPor, fechaModificacion) VALUES (3,4,'tesateasgd',NULL,1,0,'2014-08-06 01:07:36',NULL,NULL);
INSERT INTO Usuario (usuarioId, personaId, username, password, habilitado, creadoPor, fechaCreacion, modificadoPor, fechaModificacion) VALUES (4,5,'prueba','$2a$10$G0RPXKkhY1Uq/HfFdalxhu8dUPb5quUFsjhRlWN26G4S4MharwefG',1,0,'2014-08-06 01:18:50',NULL,NULL);
INSERT INTO Usuario (usuarioId, personaId, username, password, habilitado, creadoPor, fechaCreacion, modificadoPor, fechaModificacion) VALUES (5,6,'lll','$2a$10$dQr8H8JiLW.0.27AD3sEvOtyrL5IuGnnQEDhhLlGFktAPSYSmVCiC',1,0,'2014-08-06 23:00:44',0,NULL);
INSERT INTO Usuario (usuarioId, personaId, username, password, habilitado, creadoPor, fechaCreacion, modificadoPor, fechaModificacion) VALUES (8,9,'kkk','$2a$10$BGQBVR6nrvvF1CyFCYhwyu9w.GRJhYLpnxhT9j.8Y.rkMbuLho53a',1,0,'2014-08-06 23:40:12',0,NULL);
INSERT INTO Usuario (usuarioId, personaId, username, password, habilitado, creadoPor, fechaCreacion, modificadoPor, fechaModificacion) VALUES (9,10,'lll','$2a$10$FdntWHxd8IVEcuTKpBtyD.JvATfTVAVIzrN7Gp38M.Xm8Qh2Q7g8u',1,0,'2014-08-07 01:28:25',0,NULL);


CREATE TABLE UsuarioPerfil (
  usuarioId integer NOT NULL,
  perfilId integer NOT NULL,
  creadoPor integer NOT NULL,
  fechaCreacion datetime NOT NULL,
  modificadoPor integer DEFAULT NULL,
  fechaModificacion datetime DEFAULT NULL,
  PRIMARY KEY (usuarioId,perfilId)
  CONSTRAINT fk_Usuario_has_Perfil_Perfil1 FOREIGN KEY (perfilId) REFERENCES Perfil (perfilId) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT fk_Usuario_has_Perfil_Usuario1 FOREIGN KEY (usuarioId) REFERENCES Usuario (usuarioId) ON DELETE NO ACTION ON UPDATE NO ACTION
);


INSERT INTO UsuarioPerfil (usuarioId, perfilId, creadoPor, fechaCreacion, modificadoPor, fechaModificacion) VALUES (1,1,0,'2014-03-09 15:53:32',NULL,NULL);


