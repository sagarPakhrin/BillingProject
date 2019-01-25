SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


--
-- Table structure for table `feereport_accountant`
--

CREATE TABLE IF NOT EXISTS `feereport_accountant` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `contactno` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) AUTO_INCREMENT=1 ;

--
-- Dumping data for table `feereport_accountant`
--

INSERT INTO `feereport_accountant` (`id`, `name`, `password`, `email`, `contactno`) VALUES
(1, 'sagar', 'sagar', 'sagar@gmail.com', '9813651256');

