SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `dentista`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

CREATE TABLE IF NOT EXISTS `administrador` (
  `nombre` varchar(45) NOT NULL,
  `apPaterno` varchar(45) NOT NULL,
  `apMaterno` varchar(45) NOT NULL,
  `correo` varchar(45) NOT NULL,
  `contrasenia` varchar(45) NOT NULL,
  `nickname` varchar(45) NOT NULL,
  `idAdmin` int(11) NOT NULL,
  PRIMARY KEY (`idAdmin`),
  UNIQUE KEY `idAdmin` (`idAdmin`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `anexoestudios`
--

CREATE TABLE IF NOT EXISTS `anexoestudios` (
  `idEstudiosClinicos` int(11) NOT NULL,
  `estudio` tinyint(1) NOT NULL,
  `pacientes_idPacientes` int(11) NOT NULL,
  PRIMARY KEY (`idEstudiosClinicos`),
  KEY `pacientes_idPacientes` (`pacientes_idPacientes`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `citas`
--

CREATE TABLE IF NOT EXISTS `citas` (
  `idCitas` int(11) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`idCitas`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `doctor`
--

CREATE TABLE IF NOT EXISTS `doctor` (
  `idDoctor` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apPaterno` varchar(45) NOT NULL,
  `apMaterno` varchar(45) NOT NULL,
  `cargo` varchar(45) NOT NULL,
  `nickname` varchar(45) NOT NULL,
  `correo` varchar(45) NOT NULL,
  `contrasenia` varchar(45) NOT NULL,
  `Administrador_idadmin` int(11) NOT NULL,
  PRIMARY KEY (`idDoctor`),
  KEY `Administrador_idadmin` (`Administrador_idadmin`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `monitoreopaciente`
--

CREATE TABLE IF NOT EXISTS `monitoreopaciente` (
  `idMonitoreo` int(11) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `odontograma` int(10) NOT NULL,
  `presionArterial` float NOT NULL,
  `idPacientes` int(11) NOT NULL,
  PRIMARY KEY (`idMonitoreo`),
  KEY `idPacientes` (`idPacientes`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pacientes`
--

CREATE TABLE IF NOT EXISTS `pacientes` (
  `idPaciente` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apPaterno` varchar(45) NOT NULL,
  `apMaterno` varchar(45) NOT NULL,
  `correo` varchar(45) NOT NULL,
  'telefono' int(10) NOT NULL,
  PRIMARY KEY (`idPaciente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `anexoestudios`
--
ALTER TABLE `anexoestudios`
  ADD CONSTRAINT `anexoestudios_ibfk_1` FOREIGN KEY (`pacientes_idPacientes`) REFERENCES `pacientes` (`idPaciente`);

--
-- Filtros para la tabla `doctor`
--
ALTER TABLE `doctor`
  ADD CONSTRAINT `doctor_ibfk_1` FOREIGN KEY (`Administrador_idadmin`) REFERENCES `administrador` (`idAdmin`);

--
-- Filtros para la tabla `monitoreopaciente`
--
ALTER TABLE `monitoreopaciente`
  ADD CONSTRAINT `monitoreopaciente_ibfk_1` FOREIGN KEY (`idPacientes`) REFERENCES `pacientes` (`idPaciente`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

/*Datos prueba */
insert into pacientes (idPaciente, nombre, apPaterno, apMaterno, correo, telefono)
values (01, Ricardo, Perez, Najera, PrezNaj@gmail.com, 5565874525);

SELECT pacientes;
