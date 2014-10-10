DROP SCHEMA IF EXISTS `aula_virtual`;

CREATE DATABASE  IF NOT EXISTS `aula_virtual` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci */;
USE `aula_virtual`;
-- MySQL dump 10.13  Distrib 5.5.37, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: aulaVirtual
-- ------------------------------------------------------
-- Server version	5.5.37-0ubuntu0.12.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Usuario`
--

DROP TABLE IF EXISTS `Usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Usuario` (
  `usuarioId` int(11) NOT NULL AUTO_INCREMENT,
  `personaId` int(11) NOT NULL,
  `username` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `password` varchar(60) COLLATE utf8_spanish_ci DEFAULT NULL,
  `verificationKey` varchar(60) COLLATE utf8_spanish_ci DEFAULT NULL,
  `status` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `creadoPor` int(11) NOT NULL,
  `fechaCreacion` datetime NOT NULL,
  `modificadoPor` int(11) DEFAULT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  PRIMARY KEY (`usuarioId`),
  KEY `fk_Usuario_Persona1` (`personaId`),
  CONSTRAINT `fk_Usuario_Persona1` FOREIGN KEY (`personaId`) REFERENCES `Persona` (`personaId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuario`
--

LOCK TABLES `Usuario` WRITE;
/*!40000 ALTER TABLE `Usuario` DISABLE KEYS */;
INSERT INTO `Usuario` VALUES (1,1,'superadmin','$2a$10$QUqc3JzXySXJiAcYGLPgmuQgoFay7yCUi9pk0VoKZbVw9pCvM/uY6',NULL,'ACTIVE',0,'2014-07-27 12:35:37',NULL,NULL);
/*!40000 ALTER TABLE `Usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Contenido`
--

DROP TABLE IF EXISTS `Contenido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Contenido` (
  `contenidoId` int(11) NOT NULL AUTO_INCREMENT,
  `moduloId` int(11) NOT NULL,
  `tipoContenidoId` int(11) NOT NULL,
  `nombre` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `descripcion` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `path` varchar(127) COLLATE utf8_spanish_ci DEFAULT NULL,
  `contentType` varchar(127) COLLATE utf8_spanish_ci DEFAULT NULL,
  `archivoMaterial` longblob,
  `creadoPor` int(11) NOT NULL,
  `fechaCreacion` datetime NOT NULL,
  `modificadoPor` int(11) DEFAULT NULL,
  `fechaModificacion` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`contenidoId`),
  KEY `fk_Contenido_TipoContenido1` (`tipoContenidoId`),
  KEY `fk_Contenido_Modulo1` (`moduloId`),
  CONSTRAINT `fk_Contenido_Modulo1` FOREIGN KEY (`moduloId`) REFERENCES `Modulo` (`moduloId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Contenido_TipoContenido1` FOREIGN KEY (`tipoContenidoId`) REFERENCES `TipoContenido` (`tipoContenidoId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Contenido`
--

LOCK TABLES `Contenido` WRITE;
/*!40000 ALTER TABLE `Contenido` DISABLE KEYS */;
/*!40000 ALTER TABLE `Contenido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Curso`
--

DROP TABLE IF EXISTS `Curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Curso` (
  `cursoId` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `objetivo` varchar(500) COLLATE utf8_spanish_ci NOT NULL,
  `audiencia` varchar(500) COLLATE utf8_spanish_ci NOT NULL,
  `habilitado` tinyint(1) NOT NULL DEFAULT '1',
  `creadoPor` int(11) NOT NULL,
  `fechaCreacion` datetime NOT NULL,
  `modificadoPor` int(11) DEFAULT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  PRIMARY KEY (`cursoId`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Curso`
--

LOCK TABLES `Curso` WRITE;
/*!40000 ALTER TABLE `Curso` DISABLE KEYS */;
/*!40000 ALTER TABLE `Curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Alumno`
--

DROP TABLE IF EXISTS `Alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Alumno` (
  `alumnoId` int(11) NOT NULL AUTO_INCREMENT,
  `personaId` int(11) NOT NULL,
  `creadoPor` int(11) NOT NULL,
  `fechaCreacion` datetime NOT NULL,
  `modificadoPor` int(11) DEFAULT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  PRIMARY KEY (`alumnoId`),
  KEY `fk_Alumno_Persona1` (`personaId`),
  CONSTRAINT `fk_Alumno_Persona1` FOREIGN KEY (`personaId`) REFERENCES `Persona` (`personaId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Alumno`
--

LOCK TABLES `Alumno` WRITE;
/*!40000 ALTER TABLE `Alumno` DISABLE KEYS */;
/*!40000 ALTER TABLE `Alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Evaluacion`
--

DROP TABLE IF EXISTS `Evaluacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Evaluacion` (
  `sesionId` int(11) NOT NULL,
  `alumnoId` int(11) NOT NULL,
  `respuestaId` int(11) NOT NULL,
  `creadoPor` int(11) NOT NULL,
  `fechaCreacion` datetime NOT NULL,
  `modificadoPor` int(11) DEFAULT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  PRIMARY KEY (`sesionId`,`alumnoId`,`respuestaId`),
  KEY `fk_SesionAlumno_has_Respuesta_Respuesta1` (`respuestaId`),
  KEY `fk_SesionAlumno_has_Respuesta_SesionAlumno1` (`sesionId`,`alumnoId`),
  CONSTRAINT `fk_SesionAlumno_has_Respuesta_Respuesta1` FOREIGN KEY (`respuestaId`) REFERENCES `Respuesta` (`respuestaId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_SesionAlumno_has_Respuesta_SesionAlumno1` FOREIGN KEY (`sesionId`, `alumnoId`) REFERENCES `SesionAlumno` (`Sesion_sesionId`, `Alumno_alumnoId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Evaluacion`
--

LOCK TABLES `Evaluacion` WRITE;
/*!40000 ALTER TABLE `Evaluacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `Evaluacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SesionAlumno`
--

DROP TABLE IF EXISTS `SesionAlumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SesionAlumno` (
  `Sesion_sesionId` int(11) NOT NULL,
  `Alumno_alumnoId` int(11) NOT NULL,
  `calificacion` decimal(10,0) DEFAULT NULL,
  `creadoPor` int(11) NOT NULL,
  `fechaCreacion` datetime NOT NULL,
  `modificadoPor` int(11) DEFAULT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  PRIMARY KEY (`Sesion_sesionId`,`Alumno_alumnoId`),
  KEY `fk_Sesion_has_Alumno_Alumno1` (`Alumno_alumnoId`),
  KEY `fk_Sesion_has_Alumno_Sesion1` (`Sesion_sesionId`),
  CONSTRAINT `fk_Sesion_has_Alumno_Alumno1` FOREIGN KEY (`Alumno_alumnoId`) REFERENCES `Alumno` (`alumnoId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Sesion_has_Alumno_Sesion1` FOREIGN KEY (`Sesion_sesionId`) REFERENCES `Sesion` (`sesionId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SesionAlumno`
--

LOCK TABLES `SesionAlumno` WRITE;
/*!40000 ALTER TABLE `SesionAlumno` DISABLE KEYS */;
/*!40000 ALTER TABLE `SesionAlumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Perfil`
--

DROP TABLE IF EXISTS `Perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Perfil` (
  `perfilId` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(15) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nombre` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `creadoPor` int(11) NOT NULL,
  `fechaCreacion` datetime NOT NULL,
  `modificadoPor` int(11) DEFAULT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  PRIMARY KEY (`perfilId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Perfil`
--

LOCK TABLES `Perfil` WRITE;
/*!40000 ALTER TABLE `Perfil` DISABLE KEYS */;
INSERT INTO `Perfil` VALUES (1,'SUPER_ADMIN','SuperAdmin',0,'2014-03-09 14:22:51',NULL,NULL),(2,'COORDINADOR','Coordinador CapacitaciÃ³n',0,'2014-07-26 15:43:46',NULL,NULL),(3,'INSTRUCTOR','Instructor',0,'2014-07-26 15:43:46',NULL,NULL),(4,'ALUMNO','Alumno',0,'2014-07-26 15:43:46',NULL,NULL);
/*!40000 ALTER TABLE `Perfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Sesion`
--

DROP TABLE IF EXISTS `Sesion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Sesion` (
  `sesionId` int(11) NOT NULL AUTO_INCREMENT,
  `cursoId` int(11) NOT NULL,
  `instructorId` int(11) DEFAULT NULL,
  `temporal` tinyint(1) NOT NULL DEFAULT '1',
  `fechaInicio` datetime DEFAULT NULL,
  `fechaFin` datetime DEFAULT NULL,
  `ubicacion` varchar(150) COLLATE utf8_spanish_ci DEFAULT NULL,
  `creadoPor` int(11) NOT NULL,
  `fechaCreacion` datetime NOT NULL,
  `modificadoPor` int(11) DEFAULT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  PRIMARY KEY (`sesionId`),
  KEY `fk_Sesion_Curso` (`cursoId`),
  KEY `fk_Sesion_Instructor1` (`instructorId`),
  CONSTRAINT `fk_Sesion_Curso` FOREIGN KEY (`cursoId`) REFERENCES `Curso` (`cursoId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Sesion_Instructor1` FOREIGN KEY (`instructorId`) REFERENCES `Instructor` (`instructorId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Sesion`
--

LOCK TABLES `Sesion` WRITE;
/*!40000 ALTER TABLE `Sesion` DISABLE KEYS */;
/*!40000 ALTER TABLE `Sesion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ExtensionContenido`
--

DROP TABLE IF EXISTS `ExtensionContenido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ExtensionContenido` (
  `extensionContenidoId` int(11) NOT NULL,
  `tipoContenidoId` int(11) NOT NULL,
  `extension` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `creadoPor` int(11) NOT NULL,
  `fechaCreacion` datetime NOT NULL,
  `modificadoPor` int(11) DEFAULT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  PRIMARY KEY (`extensionContenidoId`),
  KEY `fk_ExtensionContenido_TipoContenido1` (`tipoContenidoId`),
  CONSTRAINT `fk_ExtensionContenido_TipoContenido1` FOREIGN KEY (`tipoContenidoId`) REFERENCES `TipoContenido` (`tipoContenidoId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ExtensionContenido`
--

LOCK TABLES `ExtensionContenido` WRITE;
/*!40000 ALTER TABLE `ExtensionContenido` DISABLE KEYS */;
INSERT INTO `ExtensionContenido` VALUES (1,1,'doc',0,'2014-07-26 15:34:19',NULL,NULL),(2,1,'docx',0,'2014-07-26 15:34:19',NULL,NULL),(3,2,'ppt',0,'2014-07-26 15:34:19',NULL,NULL),(4,2,'pptx',0,'2014-07-26 15:34:19',NULL,NULL),(5,3,'pdf',0,'2014-07-26 15:34:19',NULL,NULL);
/*!40000 ALTER TABLE `ExtensionContenido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TipoContenido`
--

DROP TABLE IF EXISTS `TipoContenido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TipoContenido` (
  `tipoContenidoId` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `creadoPor` int(11) NOT NULL,
  `fechaCreacion` datetime NOT NULL,
  `modificadoPor` int(11) DEFAULT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  PRIMARY KEY (`tipoContenidoId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TipoContenido`
--

LOCK TABLES `TipoContenido` WRITE;
/*!40000 ALTER TABLE `TipoContenido` DISABLE KEYS */;
INSERT INTO `TipoContenido` VALUES (1,'Archivo Word',0,'2014-07-26 15:30:06',NULL,NULL),(2,'Archivo PowerPoint',0,'2014-07-26 15:30:06',NULL,NULL),(3,'Archivo PDF',0,'2014-07-26 15:30:06',NULL,NULL);
/*!40000 ALTER TABLE `TipoContenido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `UsuarioPerfil`
--

DROP TABLE IF EXISTS `UsuarioPerfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `UsuarioPerfil` (
  `usuarioId` int(11) NOT NULL,
  `perfilId` int(11) NOT NULL,
  `creadoPor` int(11) NOT NULL,
  `fechaCreacion` datetime NOT NULL,
  `modificadoPor` int(11) DEFAULT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  PRIMARY KEY (`usuarioId`,`perfilId`),
  KEY `fk_Usuario_has_Perfil_Perfil1` (`perfilId`),
  KEY `fk_Usuario_has_Perfil_Usuario1` (`usuarioId`),
  CONSTRAINT `fk_Usuario_has_Perfil_Perfil1` FOREIGN KEY (`perfilId`) REFERENCES `Perfil` (`perfilId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuario_has_Perfil_Usuario1` FOREIGN KEY (`usuarioId`) REFERENCES `Usuario` (`usuarioId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `UsuarioPerfil`
--

LOCK TABLES `UsuarioPerfil` WRITE;
/*!40000 ALTER TABLE `UsuarioPerfil` DISABLE KEYS */;
INSERT INTO `UsuarioPerfil` VALUES (1,1,0,'2014-03-09 15:53:32',NULL,NULL);
/*!40000 ALTER TABLE `UsuarioPerfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Persona`
--

DROP TABLE IF EXISTS `Persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Persona` (
  `personaId` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `apellidoPaterno` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `apellidoMaterno` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `correoElectronico` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `creadoPor` int(11) NOT NULL,
  `fechaCreacion` datetime NOT NULL,
  `modificadoPor` int(11) DEFAULT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  PRIMARY KEY (`personaId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Persona`
--

LOCK TABLES `Persona` WRITE;
/*!40000 ALTER TABLE `Persona` DISABLE KEYS */;
INSERT INTO `Persona` VALUES (1,'SuperAdmin','SuperAdmin','SuperAdmin','capacitacion.ppi@finanzasoaxaca.gob.mx',0,'2014-03-09 15:10:20',NULL,NULL);
/*!40000 ALTER TABLE `Persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Modulo`
--

DROP TABLE IF EXISTS `Modulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Modulo` (
  `moduloId` int(11) NOT NULL AUTO_INCREMENT,
  `cursoId` int(11) NOT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `objetivoGeneral` varchar(1024) COLLATE utf8_spanish_ci DEFAULT NULL,
  `objetivoEspecifico` varchar(1024) COLLATE utf8_spanish_ci DEFAULT NULL,
  `temario` varchar(2048) COLLATE utf8_spanish_ci DEFAULT NULL,
  `habilitado` bit(1) DEFAULT NULL,
  `creadoPor` int(11) NOT NULL,
  `fechaCreacion` datetime NOT NULL,
  `modificadoPor` int(11) DEFAULT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  PRIMARY KEY (`moduloId`),
  KEY `fk_Modulo_Curso1` (`cursoId`),
  CONSTRAINT `fk_Modulo_Curso1` FOREIGN KEY (`cursoId`) REFERENCES `Curso` (`cursoId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Modulo`
--

LOCK TABLES `Modulo` WRITE;
/*!40000 ALTER TABLE `Modulo` DISABLE KEYS */;
/*!40000 ALTER TABLE `Modulo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `RegistroAcceso`
--

DROP TABLE IF EXISTS `RegistroAcceso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `RegistroAcceso` (
  `registroAccesoId` int(11) NOT NULL AUTO_INCREMENT,
  `usuarioId` int(11) NOT NULL,
  `inicioAcceso` datetime DEFAULT NULL,
  `finAcceso` datetime DEFAULT NULL,
  `sessionId` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`registroAccesoId`),
  KEY `fk_RegistroAcceso_Usuario1` (`usuarioId`),
  CONSTRAINT `fk_RegistroAcceso_Usuario1` FOREIGN KEY (`usuarioId`) REFERENCES `Usuario` (`usuarioId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RegistroAcceso`
--

LOCK TABLES `RegistroAcceso` WRITE;
/*!40000 ALTER TABLE `RegistroAcceso` DISABLE KEYS */;
/*!40000 ALTER TABLE `RegistroAcceso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Respuesta`
--

DROP TABLE IF EXISTS `Respuesta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Respuesta` (
  `respuestaId` int(11) NOT NULL AUTO_INCREMENT,
  `preguntaId` int(11) NOT NULL,
  `textoRespuesta` varchar(500) COLLATE utf8_spanish_ci DEFAULT NULL,
  `esRespuestaCorrecta` tinyint(1) DEFAULT NULL,
  `creadoPor` int(11) NOT NULL,
  `fechaCreacion` datetime NOT NULL,
  `modificadoPor` int(11) DEFAULT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  PRIMARY KEY (`respuestaId`),
  KEY `fk_Respuesta_Pregunta1` (`preguntaId`),
  CONSTRAINT `fk_Respuesta_Pregunta1` FOREIGN KEY (`preguntaId`) REFERENCES `Pregunta` (`preguntaId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Respuesta`
--

LOCK TABLES `Respuesta` WRITE;
/*!40000 ALTER TABLE `Respuesta` DISABLE KEYS */;
/*!40000 ALTER TABLE `Respuesta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Pregunta`
--

DROP TABLE IF EXISTS `Pregunta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Pregunta` (
  `preguntaId` int(11) NOT NULL AUTO_INCREMENT,
  `examenId` int(11) NOT NULL,
  `textoPregunta` varchar(500) COLLATE utf8_spanish_ci DEFAULT NULL,
  `creadoPor` int(11) NOT NULL,
  `fechaCreacion` datetime NOT NULL,
  `modificadoPor` int(11) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  PRIMARY KEY (`preguntaId`),
  KEY `fk_Pregunta_Examen1` (`examenId`),
  CONSTRAINT `fk_Pregunta_Examen1` FOREIGN KEY (`examenId`) REFERENCES `Examen` (`examenId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Pregunta`
--

LOCK TABLES `Pregunta` WRITE;
/*!40000 ALTER TABLE `Pregunta` DISABLE KEYS */;
/*!40000 ALTER TABLE `Pregunta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Examen`
--

DROP TABLE IF EXISTS `Examen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Examen` (
  `examenId` int(11) NOT NULL AUTO_INCREMENT,
  `cursoId` int(11) NOT NULL,
  `numPreguntas` smallint(6) NOT NULL,
  `numRespuestasPregunta` smallint(6) NOT NULL,
  `creadoPor` int(11) NOT NULL,
  `fechaCreacion` datetime NOT NULL,
  `modificadoPor` int(11) DEFAULT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  PRIMARY KEY (`examenId`),
  KEY `fk_Examen_Curso1` (`cursoId`),
  CONSTRAINT `fk_Examen_Curso1` FOREIGN KEY (`cursoId`) REFERENCES `Curso` (`cursoId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Examen`
--

LOCK TABLES `Examen` WRITE;
/*!40000 ALTER TABLE `Examen` DISABLE KEYS */;
/*!40000 ALTER TABLE `Examen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Instructor`
--

DROP TABLE IF EXISTS `Instructor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Instructor` (
  `instructorId` int(11) NOT NULL AUTO_INCREMENT,
  `personaId` int(11) NOT NULL,
  `creadoPor` int(11) NOT NULL,
  `fechaCreacion` datetime NOT NULL,
  `modificadoPor` int(11) DEFAULT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  PRIMARY KEY (`instructorId`),
  KEY `fk_Instructor_Persona1` (`personaId`),
  CONSTRAINT `fk_Instructor_Persona1` FOREIGN KEY (`personaId`) REFERENCES `Persona` (`personaId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Instructor`
--

LOCK TABLES `Instructor` WRITE;
/*!40000 ALTER TABLE `Instructor` DISABLE KEYS */;
/*!40000 ALTER TABLE `Instructor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-09-25 10:55:13
