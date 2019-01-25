SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--

-- --------------------------------------------------------

--
-- Table structure for table `feereport_student`
--

CREATE TABLE IF NOT EXISTS `student` (
  `rollno` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `grade` int(10) NOT NULL,
  `fee` int(10) NOT NULL,
  `paid` int(10) NOT NULL,
  `due` int(10) NOT NULL,
  `address` varchar(300) NOT NULL,
  `city` varchar(200) NOT NULL,
  `state` varchar(200) NOT NULL,
  `country` varchar(100) NOT NULL,
  `contactno` varchar(20) NOT NULL,
  `registereddate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`rollno`)
)AUTO_INCREMENT=1;

--
-- Dumping data for table `feereport_student`
--