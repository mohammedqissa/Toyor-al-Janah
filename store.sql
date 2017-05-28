CREATE DATABASE  IF NOT EXISTS `Store` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `Store`;
-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: Store
-- ------------------------------------------------------
-- Server version	5.7.11

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
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `idcustomer` int(11) NOT NULL AUTO_INCREMENT,
  `customercol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idcustomer`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,' '),(2,' '),(3,' '),(4,' '),(5,' '),(6,' '),(7,' '),(8,' ');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manager`
--

DROP TABLE IF EXISTS `manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manager` (
  `idmanager` int(11) NOT NULL,
  PRIMARY KEY (`idmanager`),
  CONSTRAINT `salerID` FOREIGN KEY (`idmanager`) REFERENCES `saler` (`salerID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manager`
--

LOCK TABLES `manager` WRITE;
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
INSERT INTO `manager` VALUES (1),(14);
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `managerBuy`
--

DROP TABLE IF EXISTS `managerBuy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `managerBuy` (
  `idmanagerBuy` int(11) NOT NULL AUTO_INCREMENT,
  `managerId` int(11) NOT NULL,
  `preorderID` int(11) NOT NULL,
  `managerBuyDate` varchar(45) NOT NULL,
  PRIMARY KEY (`idmanagerBuy`),
  KEY `managerId_idx` (`managerId`),
  KEY `IdOfPreOrder_idx` (`preorderID`),
  CONSTRAINT `IdOfPreOrder` FOREIGN KEY (`preorderID`) REFERENCES `preorder` (`idpreorder`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idmanager` FOREIGN KEY (`managerId`) REFERENCES `manager` (`idmanager`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `managerBuy`
--

LOCK TABLES `managerBuy` WRITE;
/*!40000 ALTER TABLE `managerBuy` DISABLE KEYS */;
INSERT INTO `managerBuy` VALUES (3,1,1,'2016/05/22'),(4,1,9,'2016/05/22'),(5,1,10,'2016/05/23'),(6,1,1,'2016/05/23'),(7,1,2,'2016/05/23'),(8,1,3,'2016/05/23'),(9,1,7,'2016/05/23'),(10,1,8,'2016/05/23'),(11,1,9,'2016/05/23'),(12,1,11,'2016/05/23'),(13,1,7,'2016/05/23'),(14,1,8,'2016/05/23'),(15,1,15,'2016/05/25'),(16,1,15,'2016/05/25'),(17,1,7,'2016/11/26');
/*!40000 ALTER TABLE `managerBuy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `postOrder`
--

DROP TABLE IF EXISTS `postOrder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `postOrder` (
  `idpostOrder` int(11) NOT NULL AUTO_INCREMENT,
  `postOrderPrice` double NOT NULL,
  PRIMARY KEY (`idpostOrder`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `postOrder`
--

LOCK TABLES `postOrder` WRITE;
/*!40000 ALTER TABLE `postOrder` DISABLE KEYS */;
INSERT INTO `postOrder` VALUES (23,0),(24,0),(25,0),(26,0),(27,0),(28,0),(29,0),(30,0),(31,0),(32,0),(33,0),(34,0),(35,0),(36,0),(37,0),(38,0),(39,0),(40,0),(41,0),(42,0),(43,0),(44,0),(45,0),(46,0);
/*!40000 ALTER TABLE `postOrder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `postorderConsistofProduct`
--

DROP TABLE IF EXISTS `postorderConsistofProduct`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `postorderConsistofProduct` (
  `idpostorderConsistofProduct` int(11) NOT NULL AUTO_INCREMENT,
  `idOfProduct` int(11) DEFAULT NULL,
  `idOfpostorder` int(11) DEFAULT NULL,
  PRIMARY KEY (`idpostorderConsistofProduct`),
  KEY `idOfProduct_idx` (`idOfProduct`),
  KEY `idOfPostorder_idx` (`idOfpostorder`),
  KEY `PostorderId_idx` (`idOfpostorder`),
  CONSTRAINT `PostorderId` FOREIGN KEY (`idOfpostorder`) REFERENCES `postOrder` (`idpostOrder`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idOfProduct` FOREIGN KEY (`idOfProduct`) REFERENCES `product` (`idproduct`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `postorderConsistofProduct`
--

LOCK TABLES `postorderConsistofProduct` WRITE;
/*!40000 ALTER TABLE `postorderConsistofProduct` DISABLE KEYS */;
INSERT INTO `postorderConsistofProduct` VALUES (22,5,24),(23,5,25),(24,1,25),(27,1,27),(29,13,27),(30,1,28),(31,1,29),(32,3,29),(34,1,31),(35,9,31),(36,9,32),(41,16,37),(42,5,37);
/*!40000 ALTER TABLE `postorderConsistofProduct` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `preorder`
--

DROP TABLE IF EXISTS `preorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `preorder` (
  `idpreorder` int(11) NOT NULL AUTO_INCREMENT,
  `preorderprice` double NOT NULL,
  PRIMARY KEY (`idpreorder`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preorder`
--

LOCK TABLES `preorder` WRITE;
/*!40000 ALTER TABLE `preorder` DISABLE KEYS */;
INSERT INTO `preorder` VALUES (1,30),(2,0),(3,0),(7,0),(8,0),(9,0),(10,0),(11,0),(12,0),(13,0),(14,0),(15,0),(16,0);
/*!40000 ALTER TABLE `preorder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `preorderConsistOfProduct`
--

DROP TABLE IF EXISTS `preorderConsistOfProduct`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `preorderConsistOfProduct` (
  `idpreorderConsistOfProduct` int(11) NOT NULL AUTO_INCREMENT,
  `idofproduct` int(11) DEFAULT NULL,
  `idofpreorder` int(11) DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`idpreorderConsistOfProduct`),
  KEY `preorderid_idx` (`idofpreorder`),
  CONSTRAINT `preorderid` FOREIGN KEY (`idofpreorder`) REFERENCES `preorder` (`idpreorder`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preorderConsistOfProduct`
--

LOCK TABLES `preorderConsistOfProduct` WRITE;
/*!40000 ALTER TABLE `preorderConsistOfProduct` DISABLE KEYS */;
INSERT INTO `preorderConsistOfProduct` VALUES (1,13,10,2),(2,14,3,3),(3,1,1,4),(4,3,1,5),(5,4,2,2),(6,5,3,3),(7,6,NULL,2),(8,15,15,5),(9,16,15,3);
/*!40000 ALTER TABLE `preorderConsistOfProduct` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `idproduct` int(11) NOT NULL AUTO_INCREMENT,
  `productPrice` double NOT NULL,
  `productColor` varchar(45) NOT NULL,
  `productDiscription` varchar(800) NOT NULL,
  `productCatagory` varchar(45) NOT NULL,
  `productSizes` varchar(45) NOT NULL,
  `productPic` varchar(300) DEFAULT NULL,
  `kind` varchar(45) NOT NULL,
  PRIMARY KEY (`idproduct`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,20,'blue','for girls','dress','s','/Users/mohammedissa/Documents/Clothes/1','female'),(2,25,'red','for boys','pants','m','/Users/mohammedissa/Documents/Clothes/2','male'),(3,20,'red','for girls','t-shirt','m','/Users/mohammedissa/Documents/Clothes/3','female'),(4,100,'black','for men','shirt','l','/Users/mohammedissa/Documents/Clothes/4','male'),(5,55,'brown','for boys','shirt','s','/Users/mohammedissa/Documents/Clothes/5','male'),(6,70,'white','for boys','pants','xl','/Users/mohammedissa/Documents/Clothes/6','male'),(7,30,'red','for girls','dress','s','/Users/mohammedissa/Documents/Clothes/7','female'),(8,40,'pink','for women','shirt','l','/Users/mohammedissa/Documents/Clothes/8','female'),(9,55,'green','for boys','t-shirt','l','/Users/mohammedissa/Documents/Clothes/9','male'),(10,35,'pink','for women','dress','m','/Users/mohammedissa/Documents/Clothes/10','female'),(11,10,'blue','for boys','shirt','s','/Users/mohammedissa/Documents/Clothes/11','male'),(13,55,'white','for girls','dress','l','/Users/mohammedissa/Documents/Clothes/8.jpg','female'),(14,23,'blue','for boys','shirt','s','/Users/mohammedissa/Documents/Clothes/7.jpg','male'),(15,25,'adasa','asdasf','shirt','l','/Users/mohammedissa/Documents/Clothes/3.jpg','null'),(16,30,'red','asdasd','dress','m','/Users/mohammedissa/Documents/Clothes/5.jpg','female');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `relative`
--

DROP TABLE IF EXISTS `relative`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `relative` (
  `supplierId` int(11) NOT NULL,
  `preorderId` int(11) NOT NULL,
  `relativecol` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`relativecol`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `relative`
--

LOCK TABLES `relative` WRITE;
/*!40000 ALTER TABLE `relative` DISABLE KEYS */;
INSERT INTO `relative` VALUES (1,3,1),(2,9,2),(2,12,3),(2,13,4),(0,14,5),(2,15,6),(1,16,7);
/*!40000 ALTER TABLE `relative` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `saler`
--

DROP TABLE IF EXISTS `saler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `saler` (
  `salerID` int(11) NOT NULL AUTO_INCREMENT,
  `salerName` varchar(45) NOT NULL,
  `SalerPhone` varchar(45) NOT NULL,
  `SBDate` varchar(45) NOT NULL,
  `salerPass` varchar(45) NOT NULL,
  PRIMARY KEY (`salerID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saler`
--

LOCK TABLES `saler` WRITE;
/*!40000 ALTER TABLE `saler` DISABLE KEYS */;
INSERT INTO `saler` VALUES (1,'mohammed','05937364','7-9-1995','123'),(2,'ahmad','023424','3-3-2004','111'),(14,'sundud','06542356','2016-05-01','12311'),(15,'gfsgdgdf','8687564563','2016-05-08','1122');
/*!40000 ALTER TABLE `saler` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salerSale`
--

DROP TABLE IF EXISTS `salerSale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salerSale` (
  `idsalerSale` int(11) NOT NULL AUTO_INCREMENT,
  `idOfCustomer` int(11) DEFAULT NULL,
  `idOfPostorder` int(11) DEFAULT NULL,
  `idOfSaler` int(11) DEFAULT NULL,
  `salerSaledate` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idsalerSale`),
  KEY `salerID_idx` (`idOfSaler`),
  KEY `IDofSaler_idx` (`idOfSaler`),
  KEY `idofcustomer_idx` (`idOfCustomer`),
  KEY `idofpostorder_idx` (`idOfPostorder`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salerSale`
--

LOCK TABLES `salerSale` WRITE;
/*!40000 ALTER TABLE `salerSale` DISABLE KEYS */;
INSERT INTO `salerSale` VALUES (1,5,29,1,'2016/05/25'),(2,6,30,2,'2016/05/25'),(5,7,31,15,'2016/05/25'),(6,8,37,1,'2016/05/25');
/*!40000 ALTER TABLE `salerSale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop`
--

DROP TABLE IF EXISTS `shop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shop` (
  `idshop` int(11) NOT NULL AUTO_INCREMENT,
  `shopname` varchar(45) NOT NULL,
  `shopaddress` varchar(45) NOT NULL,
  PRIMARY KEY (`idshop`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop`
--

LOCK TABLES `shop` WRITE;
/*!40000 ALTER TABLE `shop` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopConsistOfPreorder`
--

DROP TABLE IF EXISTS `shopConsistOfPreorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shopConsistOfPreorder` (
  `idshopConsistOfPreorder` int(11) NOT NULL,
  `idOfShop` int(11) DEFAULT NULL,
  `idOfPreorder` int(11) DEFAULT NULL,
  PRIMARY KEY (`idshopConsistOfPreorder`),
  KEY `idofShop_idx` (`idOfShop`),
  CONSTRAINT `idofShop` FOREIGN KEY (`idOfShop`) REFERENCES `shop` (`idshop`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopConsistOfPreorder`
--

LOCK TABLES `shopConsistOfPreorder` WRITE;
/*!40000 ALTER TABLE `shopConsistOfPreorder` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopConsistOfPreorder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supplier` (
  `idsupplier` int(11) NOT NULL AUTO_INCREMENT,
  `suppliername` varchar(45) NOT NULL,
  `supplierPhone` varchar(45) NOT NULL,
  `supplierEmal` varchar(45) NOT NULL,
  `supplierAddress` varchar(45) NOT NULL,
  PRIMARY KEY (`idsupplier`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES (1,'ahmad hamdan','056789332','madss@hotmail.com','jerusalem'),(2,'rami mahmood','052345783','hfad@yahoo.com','birzeit'),(3,'mahmood','059234232','moasdd@gmail.com','ramallah');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-28  8:48:30
