/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.1.54-community : Database - db_jat
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_jat` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `db_jat`;

/*Table structure for table `authorities` */

DROP TABLE IF EXISTS `authorities`;

CREATE TABLE `authorities` (
  `id` varchar(32) COLLATE utf8_bin NOT NULL,
  `name` varchar(20) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `authorities` */

insert  into `authorities`(`id`,`name`) values ('1312869365835e2baaac768e4c079c14','发贴'),('13128693bb8a5e2baaac768e4c057d23','进入系统'),('13128693bb8a5e2baaac768e4c079c14','删帖');

/*Table structure for table `authorities_resources` */

DROP TABLE IF EXISTS `authorities_resources`;

CREATE TABLE `authorities_resources` (
  `id` varchar(32) COLLATE utf8_bin NOT NULL,
  `authorities` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `resource` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK401C1687FD16C4F1` (`authorities`),
  KEY `FK401C1687CA1700A2` (`resource`),
  CONSTRAINT `FK401C1687CA1700A2` FOREIGN KEY (`resource`) REFERENCES `resources` (`id`),
  CONSTRAINT `FK401C1687FD16C4F1` FOREIGN KEY (`authorities`) REFERENCES `authorities` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `authorities_resources` */

insert  into `authorities_resources`(`id`,`authorities`,`resource`) values ('1312869365835e2baabbaaeeec079c14','1312869365835e2baaac768e4c079c14','1312869365835e2baaacaaae4c079c14'),('13128693bb8b3e2bacdc768e4c057d23','13128693bb8a5e2baaac768e4c057d23','13128abcbb8bbe55abac768e4c079c14'),('13128abcbb8aaa2daaac768e4c079c14','13128693bb8a5e2baaac768e4c079c14','13128abcbb8a5e23aaac768e4c079c14');

/*Table structure for table `jbpm4_deployment` */

DROP TABLE IF EXISTS `jbpm4_deployment`;

CREATE TABLE `jbpm4_deployment` (
  `DBID_` bigint(20) NOT NULL,
  `NAME_` longtext COLLATE utf8_bin,
  `TIMESTAMP_` bigint(20) DEFAULT NULL,
  `STATE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`DBID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `jbpm4_deployment` */

insert  into `jbpm4_deployment`(`DBID_`,`NAME_`,`TIMESTAMP_`,`STATE_`) values (1,NULL,0,'active'),(16,NULL,0,'active'),(31,NULL,0,'active'),(46,NULL,0,'active'),(61,NULL,0,'active'),(76,NULL,0,'active'),(91,NULL,0,'active'),(10001,NULL,0,'active');

/*Table structure for table `jbpm4_deployprop` */

DROP TABLE IF EXISTS `jbpm4_deployprop`;

CREATE TABLE `jbpm4_deployprop` (
  `DBID_` bigint(20) NOT NULL,
  `DEPLOYMENT_` bigint(20) DEFAULT NULL,
  `OBJNAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `STRINGVAL_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `LONGVAL_` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`DBID_`),
  KEY `IDX_DEPLPROP_DEPL` (`DEPLOYMENT_`),
  KEY `FK_DEPLPROP_DEPL` (`DEPLOYMENT_`),
  CONSTRAINT `FK_DEPLPROP_DEPL` FOREIGN KEY (`DEPLOYMENT_`) REFERENCES `jbpm4_deployment` (`DBID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `jbpm4_deployprop` */

insert  into `jbpm4_deployprop`(`DBID_`,`DEPLOYMENT_`,`OBJNAME_`,`KEY_`,`STRINGVAL_`,`LONGVAL_`) values (3,1,'leave','langid','jpdl-4.4',NULL),(4,1,'leave','pdid','leave-1',NULL),(5,1,'leave','pdkey','leave',NULL),(6,1,'leave','pdversion',NULL,1),(18,16,'leave','langid','jpdl-4.4',NULL),(19,16,'leave','pdid','leave-2',NULL),(20,16,'leave','pdkey','leave',NULL),(21,16,'leave','pdversion',NULL,2),(33,31,'leave','langid','jpdl-4.4',NULL),(34,31,'leave','pdid','leave-3',NULL),(35,31,'leave','pdkey','leave',NULL),(36,31,'leave','pdversion',NULL,3),(48,46,'leave','langid','jpdl-4.4',NULL),(49,46,'leave','pdid','leave-4',NULL),(50,46,'leave','pdkey','leave',NULL),(51,46,'leave','pdversion',NULL,4),(63,61,'leave','langid','jpdl-4.4',NULL),(64,61,'leave','pdid','leave-5',NULL),(65,61,'leave','pdkey','leave',NULL),(66,61,'leave','pdversion',NULL,5),(78,76,'leave','langid','jpdl-4.4',NULL),(79,76,'leave','pdid','leave-6',NULL),(80,76,'leave','pdkey','leave',NULL),(81,76,'leave','pdversion',NULL,6),(93,91,'leave','langid','jpdl-4.4',NULL),(94,91,'leave','pdid','leave-7',NULL),(95,91,'leave','pdkey','leave',NULL),(96,91,'leave','pdversion',NULL,7),(10003,10001,'leave','langid','jpdl-4.4',NULL),(10004,10001,'leave','pdid','leave-8',NULL),(10005,10001,'leave','pdkey','leave',NULL),(10006,10001,'leave','pdversion',NULL,8);

/*Table structure for table `jbpm4_execution` */

DROP TABLE IF EXISTS `jbpm4_execution`;

CREATE TABLE `jbpm4_execution` (
  `DBID_` bigint(20) NOT NULL,
  `CLASS_` varchar(255) COLLATE utf8_bin NOT NULL,
  `DBVERSION_` int(11) NOT NULL,
  `ACTIVITYNAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PROCDEFID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HASVARS_` bit(1) DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `STATE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `SUSPHISTSTATE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PRIORITY_` int(11) DEFAULT NULL,
  `HISACTINST_` bigint(20) DEFAULT NULL,
  `PARENT_` bigint(20) DEFAULT NULL,
  `INSTANCE_` bigint(20) DEFAULT NULL,
  `SUPEREXEC_` bigint(20) DEFAULT NULL,
  `SUBPROCINST_` bigint(20) DEFAULT NULL,
  `PARENT_IDX_` int(11) DEFAULT NULL,
  PRIMARY KEY (`DBID_`),
  UNIQUE KEY `ID_` (`ID_`),
  KEY `IDX_EXEC_SUBPI` (`SUBPROCINST_`),
  KEY `IDX_EXEC_PARENT` (`PARENT_`),
  KEY `IDX_EXEC_SUPEREXEC` (`SUPEREXEC_`),
  KEY `IDX_EXEC_INSTANCE` (`INSTANCE_`),
  KEY `FK_EXEC_SUBPI` (`SUBPROCINST_`),
  KEY `FK_EXEC_INSTANCE` (`INSTANCE_`),
  KEY `FK_EXEC_SUPEREXEC` (`SUPEREXEC_`),
  KEY `FK_EXEC_PARENT` (`PARENT_`),
  CONSTRAINT `FK_EXEC_INSTANCE` FOREIGN KEY (`INSTANCE_`) REFERENCES `jbpm4_execution` (`DBID_`),
  CONSTRAINT `FK_EXEC_PARENT` FOREIGN KEY (`PARENT_`) REFERENCES `jbpm4_execution` (`DBID_`),
  CONSTRAINT `FK_EXEC_SUBPI` FOREIGN KEY (`SUBPROCINST_`) REFERENCES `jbpm4_execution` (`DBID_`),
  CONSTRAINT `FK_EXEC_SUPEREXEC` FOREIGN KEY (`SUPEREXEC_`) REFERENCES `jbpm4_execution` (`DBID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `jbpm4_execution` */

insert  into `jbpm4_execution`(`DBID_`,`CLASS_`,`DBVERSION_`,`ACTIVITYNAME_`,`PROCDEFID_`,`HASVARS_`,`NAME_`,`KEY_`,`ID_`,`STATE_`,`SUSPHISTSTATE_`,`PRIORITY_`,`HISACTINST_`,`PARENT_`,`INSTANCE_`,`SUPEREXEC_`,`SUBPROCINST_`,`PARENT_IDX_`) values (37,'pvm',2,'经理审核','leave-3','',NULL,'1315299813218749cb60781443be8def','leave.1315299813218749cb60781443be8def','active-root',NULL,0,45,NULL,37,NULL,NULL,NULL),(52,'pvm',2,'经理审核','leave-4','',NULL,'131530002642a696074fee6540e3a343','leave.131530002642a696074fee6540e3a343','active-root',NULL,0,60,NULL,52,NULL,NULL,NULL),(67,'pvm',2,'经理审核','leave-5','',NULL,'1315300123677cd7c357acc549b6b68b','leave.1315300123677cd7c357acc549b6b68b','active-root',NULL,0,75,NULL,67,NULL,NULL,NULL),(82,'pvm',2,'经理审核','leave-6','',NULL,'131530013296e7ada020c30245aaa460','leave.131530013296e7ada020c30245aaa460','active-root',NULL,0,90,NULL,82,NULL,NULL,NULL),(97,'pvm',2,'经理审核','leave-7','',NULL,'1315362882647af7185bab9547108e51','leave.1315362882647af7185bab9547108e51','active-root',NULL,0,105,NULL,97,NULL,NULL,NULL),(10007,'pvm',2,'经理审核','leave-8','',NULL,'131536292410ea76803694db4eec8c9d','leave.131536292410ea76803694db4eec8c9d','active-root',NULL,0,10015,NULL,10007,NULL,NULL,NULL);

/*Table structure for table `jbpm4_hist_actinst` */

DROP TABLE IF EXISTS `jbpm4_hist_actinst`;

CREATE TABLE `jbpm4_hist_actinst` (
  `DBID_` bigint(20) NOT NULL,
  `CLASS_` varchar(255) COLLATE utf8_bin NOT NULL,
  `DBVERSION_` int(11) NOT NULL,
  `HPROCI_` bigint(20) DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ACTIVITY_NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `START_` datetime DEFAULT NULL,
  `END_` datetime DEFAULT NULL,
  `DURATION_` bigint(20) DEFAULT NULL,
  `TRANSITION_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `NEXTIDX_` int(11) DEFAULT NULL,
  `HTASK_` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`DBID_`),
  KEY `IDX_HTI_HTASK` (`HTASK_`),
  KEY `IDX_HACTI_HPROCI` (`HPROCI_`),
  KEY `FK_HACTI_HPROCI` (`HPROCI_`),
  KEY `FK_HTI_HTASK` (`HTASK_`),
  CONSTRAINT `FK_HACTI_HPROCI` FOREIGN KEY (`HPROCI_`) REFERENCES `jbpm4_hist_procinst` (`DBID_`),
  CONSTRAINT `FK_HTI_HTASK` FOREIGN KEY (`HTASK_`) REFERENCES `jbpm4_hist_task` (`DBID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `jbpm4_hist_actinst` */

insert  into `jbpm4_hist_actinst`(`DBID_`,`CLASS_`,`DBVERSION_`,`HPROCI_`,`TYPE_`,`EXECUTION_`,`ACTIVITY_NAME_`,`START_`,`END_`,`DURATION_`,`TRANSITION_`,`NEXTIDX_`,`HTASK_`) values (12,'task',1,7,'task','leave.1315299606904e2a82c929064b6fa327','填写请假单','2011-09-07 11:10:54','2011-09-07 11:10:54',484,'jbpm_no_task_outcome_specified_jbpm',1,11),(13,'excl',0,7,'decision','leave.1315299606904e2a82c929064b6fa327','是不是经理','2011-09-07 11:10:54','2011-09-07 11:10:54',0,'否',1,NULL),(15,'task',1,7,'task','leave.1315299606904e2a82c929064b6fa327','经理审核','2011-09-07 11:10:54','2011-09-07 17:24:36',22422640,'经理批准',1,14),(27,'task',1,22,'task','leave.131529969629c20cccb56e3f4b3eab95','填写请假单','2011-09-07 11:20:31','2011-09-07 11:20:31',656,'jbpm_no_task_outcome_specified_jbpm',1,26),(28,'excl',0,22,'decision','leave.131529969629c20cccb56e3f4b3eab95','是不是经理','2011-09-07 11:20:31','2011-09-07 11:20:31',0,'否',1,NULL),(30,'task',1,22,'task','leave.131529969629c20cccb56e3f4b3eab95','经理审核','2011-09-07 11:20:31','2011-09-07 17:25:34',21903281,'经理批准',1,29),(42,'task',1,37,'task','leave.1315299813218749cb60781443be8def','填写请假单','2011-09-07 11:22:03','2011-09-07 11:22:03',187,'jbpm_no_task_outcome_specified_jbpm',1,41),(43,'excl',0,37,'decision','leave.1315299813218749cb60781443be8def','是不是经理','2011-09-07 11:22:03','2011-09-07 11:22:03',0,'否',1,NULL),(45,'task',0,37,'task','leave.1315299813218749cb60781443be8def','经理审核','2011-09-07 11:22:03',NULL,0,NULL,1,44),(57,'task',1,52,'task','leave.131530002642a696074fee6540e3a343','填写请假单','2011-09-07 11:22:15','2011-09-07 11:22:15',468,'jbpm_no_task_outcome_specified_jbpm',1,56),(58,'excl',0,52,'decision','leave.131530002642a696074fee6540e3a343','是不是经理','2011-09-07 11:22:15','2011-09-07 11:22:15',0,'否',1,NULL),(60,'task',0,52,'task','leave.131530002642a696074fee6540e3a343','经理审核','2011-09-07 11:22:15',NULL,0,NULL,1,59),(72,'task',1,67,'task','leave.1315300123677cd7c357acc549b6b68b','填写请假单','2011-09-07 11:22:32','2011-09-07 11:22:32',296,'jbpm_no_task_outcome_specified_jbpm',1,71),(73,'excl',0,67,'decision','leave.1315300123677cd7c357acc549b6b68b','是不是经理','2011-09-07 11:22:32','2011-09-07 11:22:32',0,'否',1,NULL),(75,'task',0,67,'task','leave.1315300123677cd7c357acc549b6b68b','经理审核','2011-09-07 11:22:32',NULL,0,NULL,1,74),(87,'task',1,82,'task','leave.131530013296e7ada020c30245aaa460','填写请假单','2011-09-07 11:23:17','2011-09-07 11:23:17',968,'jbpm_no_task_outcome_specified_jbpm',1,86),(88,'excl',0,82,'decision','leave.131530013296e7ada020c30245aaa460','是不是经理','2011-09-07 11:23:18','2011-09-07 11:23:18',0,'否',1,NULL),(90,'task',0,82,'task','leave.131530013296e7ada020c30245aaa460','经理审核','2011-09-07 11:23:18',NULL,0,NULL,1,89),(102,'task',1,97,'task','leave.1315362882647af7185bab9547108e51','填写请假单','2011-09-07 11:24:15','2011-09-07 11:24:15',640,'jbpm_no_task_outcome_specified_jbpm',1,101),(103,'excl',0,97,'decision','leave.1315362882647af7185bab9547108e51','是不是经理','2011-09-07 11:24:15','2011-09-07 11:24:15',0,'否',1,NULL),(105,'task',0,97,'task','leave.1315362882647af7185bab9547108e51','经理审核','2011-09-07 11:24:15',NULL,0,NULL,1,104),(10012,'task',1,10007,'task','leave.131536292410ea76803694db4eec8c9d','填写请假单','2011-09-07 11:58:57','2011-09-07 11:58:57',234,'jbpm_no_task_outcome_specified_jbpm',1,10011),(10013,'excl',0,10007,'decision','leave.131536292410ea76803694db4eec8c9d','是不是经理','2011-09-07 11:58:57','2011-09-07 11:58:57',15,'否',1,NULL),(10015,'task',0,10007,'task','leave.131536292410ea76803694db4eec8c9d','经理审核','2011-09-07 11:58:57',NULL,0,NULL,1,10014);

/*Table structure for table `jbpm4_hist_detail` */

DROP TABLE IF EXISTS `jbpm4_hist_detail`;

CREATE TABLE `jbpm4_hist_detail` (
  `DBID_` bigint(20) NOT NULL,
  `CLASS_` varchar(255) COLLATE utf8_bin NOT NULL,
  `DBVERSION_` int(11) NOT NULL,
  `USERID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TIME_` datetime DEFAULT NULL,
  `HPROCI_` bigint(20) DEFAULT NULL,
  `HPROCIIDX_` int(11) DEFAULT NULL,
  `HACTI_` bigint(20) DEFAULT NULL,
  `HACTIIDX_` int(11) DEFAULT NULL,
  `HTASK_` bigint(20) DEFAULT NULL,
  `HTASKIDX_` int(11) DEFAULT NULL,
  `HVAR_` bigint(20) DEFAULT NULL,
  `HVARIDX_` int(11) DEFAULT NULL,
  `MESSAGE_` longtext COLLATE utf8_bin,
  `OLD_STR_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `NEW_STR_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `OLD_INT_` int(11) DEFAULT NULL,
  `NEW_INT_` int(11) DEFAULT NULL,
  `OLD_TIME_` datetime DEFAULT NULL,
  `NEW_TIME_` datetime DEFAULT NULL,
  `PARENT_` bigint(20) DEFAULT NULL,
  `PARENT_IDX_` int(11) DEFAULT NULL,
  PRIMARY KEY (`DBID_`),
  KEY `IDX_HDET_HVAR` (`HVAR_`),
  KEY `IDX_HDET_HACTI` (`HACTI_`),
  KEY `IDX_HDET_HTASK` (`HTASK_`),
  KEY `IDX_HDET_HPROCI` (`HPROCI_`),
  KEY `FK_HDETAIL_HVAR` (`HVAR_`),
  KEY `FK_HDETAIL_HPROCI` (`HPROCI_`),
  KEY `FK_HDETAIL_HTASK` (`HTASK_`),
  KEY `FK_HDETAIL_HACTI` (`HACTI_`),
  CONSTRAINT `FK_HDETAIL_HACTI` FOREIGN KEY (`HACTI_`) REFERENCES `jbpm4_hist_actinst` (`DBID_`),
  CONSTRAINT `FK_HDETAIL_HPROCI` FOREIGN KEY (`HPROCI_`) REFERENCES `jbpm4_hist_procinst` (`DBID_`),
  CONSTRAINT `FK_HDETAIL_HTASK` FOREIGN KEY (`HTASK_`) REFERENCES `jbpm4_hist_task` (`DBID_`),
  CONSTRAINT `FK_HDETAIL_HVAR` FOREIGN KEY (`HVAR_`) REFERENCES `jbpm4_hist_var` (`DBID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `jbpm4_hist_detail` */

/*Table structure for table `jbpm4_hist_procinst` */

DROP TABLE IF EXISTS `jbpm4_hist_procinst`;

CREATE TABLE `jbpm4_hist_procinst` (
  `DBID_` bigint(20) NOT NULL,
  `DBVERSION_` int(11) NOT NULL,
  `ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PROCDEFID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `START_` datetime DEFAULT NULL,
  `END_` datetime DEFAULT NULL,
  `DURATION_` bigint(20) DEFAULT NULL,
  `STATE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ENDACTIVITY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `NEXTIDX_` int(11) DEFAULT NULL,
  PRIMARY KEY (`DBID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `jbpm4_hist_procinst` */

insert  into `jbpm4_hist_procinst`(`DBID_`,`DBVERSION_`,`ID_`,`PROCDEFID_`,`KEY_`,`START_`,`END_`,`DURATION_`,`STATE_`,`ENDACTIVITY_`,`NEXTIDX_`) values (7,1,'leave.1315299606904e2a82c929064b6fa327','leave-1','1315299606904e2a82c929064b6fa327','2011-09-07 11:10:54','2011-09-07 17:24:37',22423921,'confirm','结束',1),(22,1,'leave.131529969629c20cccb56e3f4b3eab95','leave-2','131529969629c20cccb56e3f4b3eab95','2011-09-07 11:20:31','2011-09-07 17:25:34',21903453,'confirm','结束',1),(37,0,'leave.1315299813218749cb60781443be8def','leave-3','1315299813218749cb60781443be8def','2011-09-07 11:22:03',NULL,NULL,'active',NULL,1),(52,0,'leave.131530002642a696074fee6540e3a343','leave-4','131530002642a696074fee6540e3a343','2011-09-07 11:22:15',NULL,NULL,'active',NULL,1),(67,0,'leave.1315300123677cd7c357acc549b6b68b','leave-5','1315300123677cd7c357acc549b6b68b','2011-09-07 11:22:32',NULL,NULL,'active',NULL,1),(82,0,'leave.131530013296e7ada020c30245aaa460','leave-6','131530013296e7ada020c30245aaa460','2011-09-07 11:23:17',NULL,NULL,'active',NULL,1),(97,0,'leave.1315362882647af7185bab9547108e51','leave-7','1315362882647af7185bab9547108e51','2011-09-07 11:24:15',NULL,NULL,'active',NULL,1),(10007,0,'leave.131536292410ea76803694db4eec8c9d','leave-8','131536292410ea76803694db4eec8c9d','2011-09-07 11:58:57',NULL,NULL,'active',NULL,1);

/*Table structure for table `jbpm4_hist_task` */

DROP TABLE IF EXISTS `jbpm4_hist_task`;

CREATE TABLE `jbpm4_hist_task` (
  `DBID_` bigint(20) NOT NULL,
  `DBVERSION_` int(11) NOT NULL,
  `EXECUTION_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `OUTCOME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ASSIGNEE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PRIORITY_` int(11) DEFAULT NULL,
  `STATE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CREATE_` datetime DEFAULT NULL,
  `END_` datetime DEFAULT NULL,
  `DURATION_` bigint(20) DEFAULT NULL,
  `NEXTIDX_` int(11) DEFAULT NULL,
  `SUPERTASK_` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`DBID_`),
  KEY `IDX_HSUPERT_SUB` (`SUPERTASK_`),
  KEY `FK_HSUPERT_SUB` (`SUPERTASK_`),
  CONSTRAINT `FK_HSUPERT_SUB` FOREIGN KEY (`SUPERTASK_`) REFERENCES `jbpm4_hist_task` (`DBID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `jbpm4_hist_task` */

insert  into `jbpm4_hist_task`(`DBID_`,`DBVERSION_`,`EXECUTION_`,`OUTCOME_`,`ASSIGNEE_`,`PRIORITY_`,`STATE_`,`CREATE_`,`END_`,`DURATION_`,`NEXTIDX_`,`SUPERTASK_`) values (11,1,'leave.1315299606904e2a82c929064b6fa327','jbpm_no_task_outcome_specified_jbpm','writeForm',0,'completed','2011-09-07 11:10:54','2011-09-07 11:10:54',484,1,NULL),(14,1,'leave.1315299606904e2a82c929064b6fa327','经理批准','xi',0,'completed','2011-09-07 11:10:54','2011-09-07 17:24:36',22422640,1,NULL),(26,1,'leave.131529969629c20cccb56e3f4b3eab95','jbpm_no_task_outcome_specified_jbpm','writeForm',0,'completed','2011-09-07 11:20:31','2011-09-07 11:20:31',671,1,NULL),(29,1,'leave.131529969629c20cccb56e3f4b3eab95','经理批准','xi',0,'completed','2011-09-07 11:20:31','2011-09-07 17:25:34',21903296,1,NULL),(41,1,'leave.1315299813218749cb60781443be8def','jbpm_no_task_outcome_specified_jbpm','writeForm',0,'completed','2011-09-07 11:22:03','2011-09-07 11:22:03',203,1,NULL),(44,0,'leave.1315299813218749cb60781443be8def',NULL,'xi',0,NULL,'2011-09-07 11:22:03',NULL,0,1,NULL),(56,1,'leave.131530002642a696074fee6540e3a343','jbpm_no_task_outcome_specified_jbpm','writeForm',0,'completed','2011-09-07 11:22:15','2011-09-07 11:22:15',468,1,NULL),(59,0,'leave.131530002642a696074fee6540e3a343',NULL,'xi',0,NULL,'2011-09-07 11:22:15',NULL,0,1,NULL),(71,1,'leave.1315300123677cd7c357acc549b6b68b','jbpm_no_task_outcome_specified_jbpm','writeForm',0,'completed','2011-09-07 11:22:32','2011-09-07 11:22:32',312,1,NULL),(74,0,'leave.1315300123677cd7c357acc549b6b68b',NULL,'xi',0,NULL,'2011-09-07 11:22:32',NULL,0,1,NULL),(86,1,'leave.131530013296e7ada020c30245aaa460','jbpm_no_task_outcome_specified_jbpm','writeForm',0,'completed','2011-09-07 11:23:17','2011-09-07 11:23:17',984,1,NULL),(89,0,'leave.131530013296e7ada020c30245aaa460',NULL,'xi',0,NULL,'2011-09-07 11:23:18',NULL,0,1,NULL),(101,1,'leave.1315362882647af7185bab9547108e51','jbpm_no_task_outcome_specified_jbpm','writeForm',0,'completed','2011-09-07 11:24:15','2011-09-07 11:24:15',656,1,NULL),(104,0,'leave.1315362882647af7185bab9547108e51',NULL,'xi',0,NULL,'2011-09-07 11:24:15',NULL,0,1,NULL),(10011,1,'leave.131536292410ea76803694db4eec8c9d','jbpm_no_task_outcome_specified_jbpm','writeForm',0,'completed','2011-09-07 11:58:57','2011-09-07 11:58:57',234,1,NULL),(10014,0,'leave.131536292410ea76803694db4eec8c9d',NULL,'xi',0,NULL,'2011-09-07 11:58:57',NULL,0,1,NULL);

/*Table structure for table `jbpm4_hist_var` */

DROP TABLE IF EXISTS `jbpm4_hist_var`;

CREATE TABLE `jbpm4_hist_var` (
  `DBID_` bigint(20) NOT NULL,
  `DBVERSION_` int(11) NOT NULL,
  `PROCINSTID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTIONID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `VARNAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `VALUE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HPROCI_` bigint(20) DEFAULT NULL,
  `HTASK_` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`DBID_`),
  KEY `IDX_HVAR_HTASK` (`HTASK_`),
  KEY `IDX_HVAR_HPROCI` (`HPROCI_`),
  KEY `FK_HVAR_HPROCI` (`HPROCI_`),
  KEY `FK_HVAR_HTASK` (`HTASK_`),
  CONSTRAINT `FK_HVAR_HPROCI` FOREIGN KEY (`HPROCI_`) REFERENCES `jbpm4_hist_procinst` (`DBID_`),
  CONSTRAINT `FK_HVAR_HTASK` FOREIGN KEY (`HTASK_`) REFERENCES `jbpm4_hist_task` (`DBID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `jbpm4_hist_var` */

/*Table structure for table `jbpm4_id_group` */

DROP TABLE IF EXISTS `jbpm4_id_group`;

CREATE TABLE `jbpm4_id_group` (
  `DBID_` bigint(20) NOT NULL,
  `DBVERSION_` int(11) NOT NULL,
  `ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PARENT_` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`DBID_`),
  KEY `IDX_GROUP_PARENT` (`PARENT_`),
  KEY `FK_GROUP_PARENT` (`PARENT_`),
  CONSTRAINT `FK_GROUP_PARENT` FOREIGN KEY (`PARENT_`) REFERENCES `jbpm4_id_group` (`DBID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `jbpm4_id_group` */

/*Table structure for table `jbpm4_id_membership` */

DROP TABLE IF EXISTS `jbpm4_id_membership`;

CREATE TABLE `jbpm4_id_membership` (
  `DBID_` bigint(20) NOT NULL,
  `DBVERSION_` int(11) NOT NULL,
  `USER_` bigint(20) DEFAULT NULL,
  `GROUP_` bigint(20) DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`DBID_`),
  KEY `IDX_MEM_GROUP` (`GROUP_`),
  KEY `IDX_MEM_USER` (`USER_`),
  KEY `FK_MEM_GROUP` (`GROUP_`),
  KEY `FK_MEM_USER` (`USER_`),
  CONSTRAINT `FK_MEM_GROUP` FOREIGN KEY (`GROUP_`) REFERENCES `jbpm4_id_group` (`DBID_`),
  CONSTRAINT `FK_MEM_USER` FOREIGN KEY (`USER_`) REFERENCES `jbpm4_id_user` (`DBID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `jbpm4_id_membership` */

/*Table structure for table `jbpm4_id_user` */

DROP TABLE IF EXISTS `jbpm4_id_user`;

CREATE TABLE `jbpm4_id_user` (
  `DBID_` bigint(20) NOT NULL,
  `DBVERSION_` int(11) NOT NULL,
  `ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PASSWORD_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `GIVENNAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `FAMILYNAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `BUSINESSEMAIL_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`DBID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `jbpm4_id_user` */

/*Table structure for table `jbpm4_job` */

DROP TABLE IF EXISTS `jbpm4_job`;

CREATE TABLE `jbpm4_job` (
  `DBID_` bigint(20) NOT NULL,
  `CLASS_` varchar(255) COLLATE utf8_bin NOT NULL,
  `DBVERSION_` int(11) NOT NULL,
  `DUEDATE_` datetime DEFAULT NULL,
  `STATE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ISEXCLUSIVE_` bit(1) DEFAULT NULL,
  `LOCKOWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `LOCKEXPTIME_` datetime DEFAULT NULL,
  `EXCEPTION_` longtext COLLATE utf8_bin,
  `RETRIES_` int(11) DEFAULT NULL,
  `PROCESSINSTANCE_` bigint(20) DEFAULT NULL,
  `EXECUTION_` bigint(20) DEFAULT NULL,
  `CFG_` bigint(20) DEFAULT NULL,
  `SIGNAL_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `EVENT_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `REPEAT_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`DBID_`),
  KEY `IDX_JOBRETRIES` (`RETRIES_`),
  KEY `IDX_JOBDUEDATE` (`DUEDATE_`),
  KEY `IDX_JOBLOCKEXP` (`LOCKEXPTIME_`),
  KEY `IDX_JOB_CFG` (`CFG_`),
  KEY `IDX_JOB_EXE` (`EXECUTION_`),
  KEY `IDX_JOB_PRINST` (`PROCESSINSTANCE_`),
  KEY `FK_JOB_CFG` (`CFG_`),
  CONSTRAINT `FK_JOB_CFG` FOREIGN KEY (`CFG_`) REFERENCES `jbpm4_lob` (`DBID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `jbpm4_job` */

/*Table structure for table `jbpm4_lob` */

DROP TABLE IF EXISTS `jbpm4_lob`;

CREATE TABLE `jbpm4_lob` (
  `DBID_` bigint(20) NOT NULL,
  `DBVERSION_` int(11) NOT NULL,
  `BLOB_VALUE_` longblob,
  `DEPLOYMENT_` bigint(20) DEFAULT NULL,
  `NAME_` longtext COLLATE utf8_bin,
  PRIMARY KEY (`DBID_`),
  KEY `IDX_LOB_DEPLOYMENT` (`DEPLOYMENT_`),
  KEY `FK_LOB_DEPLOYMENT` (`DEPLOYMENT_`),
  CONSTRAINT `FK_LOB_DEPLOYMENT` FOREIGN KEY (`DEPLOYMENT_`) REFERENCES `jbpm4_deployment` (`DBID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `jbpm4_lob` */

insert  into `jbpm4_lob`(`DBID_`,`DBVERSION_`,`BLOB_VALUE_`,`DEPLOYMENT_`,`NAME_`) values (2,0,'<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n<process key=\"leave\" name=\"leave\" xmlns=\"http://jbpm.org/4.4/jpdl\" >\r\n   <start g=\"201,14,48,48\" name=\"开始\">\r\n      <transition g=\"-42,-10\" name=\"请假\" to=\"填写请假单\"/>\r\n   </start>\r\n   <task assignee=\"writeForm\" g=\"178,87,92,52\" name=\"填写请假单\">\r\n      <transition g=\"-97,2\" name=\"判断是不是经理\" to=\"是不是经理\"/>\r\n   </task>\r\n   <decision expr=\"#{manager}\" g=\"204,158,48,48\" name=\"是不是经理\">\r\n      <transition g=\"-23,-11\" name=\"否\" to=\"经理审核\"/>\r\n      <transition g=\"14,-11\" name=\"是\" to=\"老板审批\"/>\r\n   </decision>\r\n   <task assignee=\"#{username}\" g=\"103,252,92,52\" name=\"经理审核\">\r\n      <transition g=\"150,450:10,-21\" name=\"经理批准\" to=\"结束\"/>\r\n      <transition g=\"-22,-22\" name=\"请假天数>5\" to=\"老板审批\"/>\r\n      <transition g=\"149,114:-55,82\" name=\"经理驳回\" to=\"填写请假单\"/>\r\n   </task>\r\n   \r\n   <!-- 这里只有一个老板，所以写死了，如果有多个老板，写法同上,业务就会改变 -->\r\n   <task assignee=\"sux\" g=\"278,251,92,52\" name=\"老板审批\">\r\n      <transition g=\"326,450:-58,-24\" name=\"老板批准\" to=\"结束\"/>\r\n      <transition g=\"323,114:13,61\" name=\"老板驳回\" to=\"填写请假单\"/>\r\n   </task>\r\n   <end g=\"219,429,48,48\" name=\"结束\" state=\"confirm\"/>\r\n</process>',1,'/leave.jpdl.xml'),(17,0,'<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n<process key=\"leave\" name=\"leave\" xmlns=\"http://jbpm.org/4.4/jpdl\" >\r\n   <start g=\"201,14,48,48\" name=\"开始\">\r\n      <transition g=\"-42,-10\" name=\"请假\" to=\"填写请假单\"/>\r\n   </start>\r\n   <task assignee=\"writeForm\" g=\"178,87,92,52\" name=\"填写请假单\">\r\n      <transition g=\"-97,2\" name=\"判断是不是经理\" to=\"是不是经理\"/>\r\n   </task>\r\n   <decision expr=\"#{manager}\" g=\"204,158,48,48\" name=\"是不是经理\">\r\n      <transition g=\"-23,-11\" name=\"否\" to=\"经理审核\"/>\r\n      <transition g=\"14,-11\" name=\"是\" to=\"老板审批\"/>\r\n   </decision>\r\n   <task assignee=\"#{username}\" g=\"103,252,92,52\" name=\"经理审核\">\r\n      <transition g=\"150,450:10,-21\" name=\"经理批准\" to=\"结束\"/>\r\n      <transition g=\"-22,-22\" name=\"请假天数>5\" to=\"老板审批\"/>\r\n      <transition g=\"149,114:-55,82\" name=\"经理驳回\" to=\"填写请假单\"/>\r\n   </task>\r\n   \r\n   <!-- 这里只有一个老板，所以写死了，如果有多个老板，写法同上,业务就会改变 -->\r\n   <task assignee=\"sux\" g=\"278,251,92,52\" name=\"老板审批\">\r\n      <transition g=\"326,450:-58,-24\" name=\"老板批准\" to=\"结束\"/>\r\n      <transition g=\"323,114:13,61\" name=\"老板驳回\" to=\"填写请假单\"/>\r\n   </task>\r\n   <end g=\"219,429,48,48\" name=\"结束\" state=\"confirm\"/>\r\n</process>',16,'/leave.jpdl.xml'),(32,0,'<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n<process key=\"leave\" name=\"leave\" xmlns=\"http://jbpm.org/4.4/jpdl\" >\r\n   <start g=\"201,14,48,48\" name=\"开始\">\r\n      <transition g=\"-42,-10\" name=\"请假\" to=\"填写请假单\"/>\r\n   </start>\r\n   <task assignee=\"writeForm\" g=\"178,87,92,52\" name=\"填写请假单\">\r\n      <transition g=\"-97,2\" name=\"判断是不是经理\" to=\"是不是经理\"/>\r\n   </task>\r\n   <decision expr=\"#{manager}\" g=\"204,158,48,48\" name=\"是不是经理\">\r\n      <transition g=\"-23,-11\" name=\"否\" to=\"经理审核\"/>\r\n      <transition g=\"14,-11\" name=\"是\" to=\"老板审批\"/>\r\n   </decision>\r\n   <task assignee=\"#{username}\" g=\"103,252,92,52\" name=\"经理审核\">\r\n      <transition g=\"150,450:10,-21\" name=\"经理批准\" to=\"结束\"/>\r\n      <transition g=\"-22,-22\" name=\"请假天数>5\" to=\"老板审批\"/>\r\n      <transition g=\"149,114:-55,82\" name=\"经理驳回\" to=\"填写请假单\"/>\r\n   </task>\r\n   \r\n   <!-- 这里只有一个老板，所以写死了，如果有多个老板，写法同上,业务就会改变 -->\r\n   <task assignee=\"sux\" g=\"278,251,92,52\" name=\"老板审批\">\r\n      <transition g=\"326,450:-58,-24\" name=\"老板批准\" to=\"结束\"/>\r\n      <transition g=\"323,114:13,61\" name=\"老板驳回\" to=\"填写请假单\"/>\r\n   </task>\r\n   <end g=\"219,429,48,48\" name=\"结束\" state=\"confirm\"/>\r\n</process>',31,'/leave.jpdl.xml'),(47,0,'<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n<process key=\"leave\" name=\"leave\" xmlns=\"http://jbpm.org/4.4/jpdl\" >\r\n   <start g=\"201,14,48,48\" name=\"开始\">\r\n      <transition g=\"-42,-10\" name=\"请假\" to=\"填写请假单\"/>\r\n   </start>\r\n   <task assignee=\"writeForm\" g=\"178,87,92,52\" name=\"填写请假单\">\r\n      <transition g=\"-97,2\" name=\"判断是不是经理\" to=\"是不是经理\"/>\r\n   </task>\r\n   <decision expr=\"#{manager}\" g=\"204,158,48,48\" name=\"是不是经理\">\r\n      <transition g=\"-23,-11\" name=\"否\" to=\"经理审核\"/>\r\n      <transition g=\"14,-11\" name=\"是\" to=\"老板审批\"/>\r\n   </decision>\r\n   <task assignee=\"#{username}\" g=\"103,252,92,52\" name=\"经理审核\">\r\n      <transition g=\"150,450:10,-21\" name=\"经理批准\" to=\"结束\"/>\r\n      <transition g=\"-22,-22\" name=\"请假天数>5\" to=\"老板审批\"/>\r\n      <transition g=\"149,114:-55,82\" name=\"经理驳回\" to=\"填写请假单\"/>\r\n   </task>\r\n   \r\n   <!-- 这里只有一个老板，所以写死了，如果有多个老板，写法同上,业务就会改变 -->\r\n   <task assignee=\"sux\" g=\"278,251,92,52\" name=\"老板审批\">\r\n      <transition g=\"326,450:-58,-24\" name=\"老板批准\" to=\"结束\"/>\r\n      <transition g=\"323,114:13,61\" name=\"老板驳回\" to=\"填写请假单\"/>\r\n   </task>\r\n   <end g=\"219,429,48,48\" name=\"结束\" state=\"confirm\"/>\r\n</process>',46,'/leave.jpdl.xml'),(62,0,'<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n<process key=\"leave\" name=\"leave\" xmlns=\"http://jbpm.org/4.4/jpdl\" >\r\n   <start g=\"201,14,48,48\" name=\"开始\">\r\n      <transition g=\"-42,-10\" name=\"请假\" to=\"填写请假单\"/>\r\n   </start>\r\n   <task assignee=\"writeForm\" g=\"178,87,92,52\" name=\"填写请假单\">\r\n      <transition g=\"-97,2\" name=\"判断是不是经理\" to=\"是不是经理\"/>\r\n   </task>\r\n   <decision expr=\"#{manager}\" g=\"204,158,48,48\" name=\"是不是经理\">\r\n      <transition g=\"-23,-11\" name=\"否\" to=\"经理审核\"/>\r\n      <transition g=\"14,-11\" name=\"是\" to=\"老板审批\"/>\r\n   </decision>\r\n   <task assignee=\"#{username}\" g=\"103,252,92,52\" name=\"经理审核\">\r\n      <transition g=\"150,450:10,-21\" name=\"经理批准\" to=\"结束\"/>\r\n      <transition g=\"-22,-22\" name=\"请假天数>5\" to=\"老板审批\"/>\r\n      <transition g=\"149,114:-55,82\" name=\"经理驳回\" to=\"填写请假单\"/>\r\n   </task>\r\n   \r\n   <!-- 这里只有一个老板，所以写死了，如果有多个老板，写法同上,业务就会改变 -->\r\n   <task assignee=\"sux\" g=\"278,251,92,52\" name=\"老板审批\">\r\n      <transition g=\"326,450:-58,-24\" name=\"老板批准\" to=\"结束\"/>\r\n      <transition g=\"323,114:13,61\" name=\"老板驳回\" to=\"填写请假单\"/>\r\n   </task>\r\n   <end g=\"219,429,48,48\" name=\"结束\" state=\"confirm\"/>\r\n</process>',61,'/leave.jpdl.xml'),(77,0,'<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n<process key=\"leave\" name=\"leave\" xmlns=\"http://jbpm.org/4.4/jpdl\" >\r\n   <start g=\"201,14,48,48\" name=\"开始\">\r\n      <transition g=\"-42,-10\" name=\"请假\" to=\"填写请假单\"/>\r\n   </start>\r\n   <task assignee=\"writeForm\" g=\"178,87,92,52\" name=\"填写请假单\">\r\n      <transition g=\"-97,2\" name=\"判断是不是经理\" to=\"是不是经理\"/>\r\n   </task>\r\n   <decision expr=\"#{manager}\" g=\"204,158,48,48\" name=\"是不是经理\">\r\n      <transition g=\"-23,-11\" name=\"否\" to=\"经理审核\"/>\r\n      <transition g=\"14,-11\" name=\"是\" to=\"老板审批\"/>\r\n   </decision>\r\n   <task assignee=\"#{username}\" g=\"103,252,92,52\" name=\"经理审核\">\r\n      <transition g=\"150,450:10,-21\" name=\"经理批准\" to=\"结束\"/>\r\n      <transition g=\"-22,-22\" name=\"请假天数>5\" to=\"老板审批\"/>\r\n      <transition g=\"149,114:-55,82\" name=\"经理驳回\" to=\"填写请假单\"/>\r\n   </task>\r\n   \r\n   <!-- 这里只有一个老板，所以写死了，如果有多个老板，写法同上,业务就会改变 -->\r\n   <task assignee=\"sux\" g=\"278,251,92,52\" name=\"老板审批\">\r\n      <transition g=\"326,450:-58,-24\" name=\"老板批准\" to=\"结束\"/>\r\n      <transition g=\"323,114:13,61\" name=\"老板驳回\" to=\"填写请假单\"/>\r\n   </task>\r\n   <end g=\"219,429,48,48\" name=\"结束\" state=\"confirm\"/>\r\n</process>',76,'/leave.jpdl.xml'),(92,0,'<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n<process key=\"leave\" name=\"leave\" xmlns=\"http://jbpm.org/4.4/jpdl\" >\r\n   <start g=\"201,14,48,48\" name=\"开始\">\r\n      <transition g=\"-42,-10\" name=\"请假\" to=\"填写请假单\"/>\r\n   </start>\r\n   <task assignee=\"writeForm\" g=\"178,87,92,52\" name=\"填写请假单\">\r\n      <transition g=\"-97,2\" name=\"判断是不是经理\" to=\"是不是经理\"/>\r\n   </task>\r\n   <decision expr=\"#{manager}\" g=\"204,158,48,48\" name=\"是不是经理\">\r\n      <transition g=\"-23,-11\" name=\"否\" to=\"经理审核\"/>\r\n      <transition g=\"14,-11\" name=\"是\" to=\"老板审批\"/>\r\n   </decision>\r\n   <task assignee=\"#{username}\" g=\"103,252,92,52\" name=\"经理审核\">\r\n      <transition g=\"150,450:10,-21\" name=\"经理批准\" to=\"结束\"/>\r\n      <transition g=\"-22,-22\" name=\"请假天数>5\" to=\"老板审批\"/>\r\n      <transition g=\"149,114:-55,82\" name=\"经理驳回\" to=\"填写请假单\"/>\r\n   </task>\r\n   \r\n   <!-- 这里只有一个老板，所以写死了，如果有多个老板，写法同上,业务就会改变 -->\r\n   <task assignee=\"sux\" g=\"278,251,92,52\" name=\"老板审批\">\r\n      <transition g=\"326,450:-58,-24\" name=\"老板批准\" to=\"结束\"/>\r\n      <transition g=\"323,114:13,61\" name=\"老板驳回\" to=\"填写请假单\"/>\r\n   </task>\r\n   <end g=\"219,429,48,48\" name=\"结束\" state=\"confirm\"/>\r\n</process>',91,'/leave.jpdl.xml'),(10002,0,'<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n<process key=\"leave\" name=\"leave\" xmlns=\"http://jbpm.org/4.4/jpdl\" >\r\n   <start g=\"201,14,48,48\" name=\"开始\">\r\n      <transition g=\"-42,-10\" name=\"请假\" to=\"填写请假单\"/>\r\n   </start>\r\n   <task assignee=\"writeForm\" g=\"178,87,92,52\" name=\"填写请假单\">\r\n      <transition g=\"-97,2\" name=\"判断是不是经理\" to=\"是不是经理\"/>\r\n   </task>\r\n   <decision expr=\"#{manager}\" g=\"204,158,48,48\" name=\"是不是经理\">\r\n      <transition g=\"-23,-11\" name=\"否\" to=\"经理审核\"/>\r\n      <transition g=\"14,-11\" name=\"是\" to=\"老板审批\"/>\r\n   </decision>\r\n   <task assignee=\"#{username}\" g=\"103,252,92,52\" name=\"经理审核\">\r\n      <transition g=\"150,450:10,-21\" name=\"经理批准\" to=\"结束\"/>\r\n      <transition g=\"-22,-22\" name=\"请假天数>5\" to=\"老板审批\"/>\r\n      <transition g=\"149,114:-55,82\" name=\"经理驳回\" to=\"填写请假单\"/>\r\n   </task>\r\n   \r\n   <!-- 这里只有一个老板，所以写死了，如果有多个老板，写法同上,业务就会改变 -->\r\n   <task assignee=\"sux\" g=\"278,251,92,52\" name=\"老板审批\">\r\n      <transition g=\"326,450:-58,-24\" name=\"老板批准\" to=\"结束\"/>\r\n      <transition g=\"323,114:13,61\" name=\"老板驳回\" to=\"填写请假单\"/>\r\n   </task>\r\n   <end g=\"219,429,48,48\" name=\"结束\" state=\"confirm\"/>\r\n</process>',10001,'/leave.jpdl.xml');

/*Table structure for table `jbpm4_participation` */

DROP TABLE IF EXISTS `jbpm4_participation`;

CREATE TABLE `jbpm4_participation` (
  `DBID_` bigint(20) NOT NULL,
  `DBVERSION_` int(11) NOT NULL,
  `GROUPID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `USERID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TASK_` bigint(20) DEFAULT NULL,
  `SWIMLANE_` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`DBID_`),
  KEY `IDX_PART_TASK` (`TASK_`),
  KEY `FK_PART_SWIMLANE` (`SWIMLANE_`),
  KEY `FK_PART_TASK` (`TASK_`),
  CONSTRAINT `FK_PART_SWIMLANE` FOREIGN KEY (`SWIMLANE_`) REFERENCES `jbpm4_swimlane` (`DBID_`),
  CONSTRAINT `FK_PART_TASK` FOREIGN KEY (`TASK_`) REFERENCES `jbpm4_task` (`DBID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `jbpm4_participation` */

/*Table structure for table `jbpm4_property` */

DROP TABLE IF EXISTS `jbpm4_property`;

CREATE TABLE `jbpm4_property` (
  `KEY_` varchar(255) COLLATE utf8_bin NOT NULL,
  `VERSION_` int(11) NOT NULL,
  `VALUE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`KEY_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `jbpm4_property` */

insert  into `jbpm4_property`(`KEY_`,`VERSION_`,`VALUE_`) values ('next.dbid',2,'20001');

/*Table structure for table `jbpm4_swimlane` */

DROP TABLE IF EXISTS `jbpm4_swimlane`;

CREATE TABLE `jbpm4_swimlane` (
  `DBID_` bigint(20) NOT NULL,
  `DBVERSION_` int(11) NOT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ASSIGNEE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`DBID_`),
  KEY `IDX_SWIMLANE_EXEC` (`EXECUTION_`),
  KEY `FK_SWIMLANE_EXEC` (`EXECUTION_`),
  CONSTRAINT `FK_SWIMLANE_EXEC` FOREIGN KEY (`EXECUTION_`) REFERENCES `jbpm4_execution` (`DBID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `jbpm4_swimlane` */

/*Table structure for table `jbpm4_task` */

DROP TABLE IF EXISTS `jbpm4_task`;

CREATE TABLE `jbpm4_task` (
  `DBID_` bigint(20) NOT NULL,
  `CLASS_` char(1) COLLATE utf8_bin NOT NULL,
  `DBVERSION_` int(11) NOT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DESCR_` longtext COLLATE utf8_bin,
  `STATE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `SUSPHISTSTATE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ASSIGNEE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `FORM_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PRIORITY_` int(11) DEFAULT NULL,
  `CREATE_` datetime DEFAULT NULL,
  `DUEDATE_` datetime DEFAULT NULL,
  `PROGRESS_` int(11) DEFAULT NULL,
  `SIGNALLING_` bit(1) DEFAULT NULL,
  `EXECUTION_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ACTIVITY_NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HASVARS_` bit(1) DEFAULT NULL,
  `SUPERTASK_` bigint(20) DEFAULT NULL,
  `EXECUTION_` bigint(20) DEFAULT NULL,
  `PROCINST_` bigint(20) DEFAULT NULL,
  `SWIMLANE_` bigint(20) DEFAULT NULL,
  `TASKDEFNAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`DBID_`),
  KEY `IDX_TASK_SUPERTASK` (`SUPERTASK_`),
  KEY `FK_TASK_SWIML` (`SWIMLANE_`),
  KEY `FK_TASK_SUPERTASK` (`SUPERTASK_`),
  CONSTRAINT `FK_TASK_SUPERTASK` FOREIGN KEY (`SUPERTASK_`) REFERENCES `jbpm4_task` (`DBID_`),
  CONSTRAINT `FK_TASK_SWIML` FOREIGN KEY (`SWIMLANE_`) REFERENCES `jbpm4_swimlane` (`DBID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `jbpm4_task` */

insert  into `jbpm4_task`(`DBID_`,`CLASS_`,`DBVERSION_`,`NAME_`,`DESCR_`,`STATE_`,`SUSPHISTSTATE_`,`ASSIGNEE_`,`FORM_`,`PRIORITY_`,`CREATE_`,`DUEDATE_`,`PROGRESS_`,`SIGNALLING_`,`EXECUTION_ID_`,`ACTIVITY_NAME_`,`HASVARS_`,`SUPERTASK_`,`EXECUTION_`,`PROCINST_`,`SWIMLANE_`,`TASKDEFNAME_`) values (44,'T',1,'经理审核',NULL,'open',NULL,'xi',NULL,0,'2011-09-07 11:22:03',NULL,NULL,'','leave.1315299813218749cb60781443be8def','经理审核','\0',NULL,37,37,NULL,'经理审核'),(59,'T',1,'经理审核',NULL,'open',NULL,'xi',NULL,0,'2011-09-07 11:22:15',NULL,NULL,'','leave.131530002642a696074fee6540e3a343','经理审核','\0',NULL,52,52,NULL,'经理审核'),(74,'T',1,'经理审核',NULL,'open',NULL,'xi',NULL,0,'2011-09-07 11:22:32',NULL,NULL,'','leave.1315300123677cd7c357acc549b6b68b','经理审核','\0',NULL,67,67,NULL,'经理审核'),(89,'T',1,'经理审核',NULL,'open',NULL,'xi',NULL,0,'2011-09-07 11:23:18',NULL,NULL,'','leave.131530013296e7ada020c30245aaa460','经理审核','\0',NULL,82,82,NULL,'经理审核'),(104,'T',1,'经理审核',NULL,'open',NULL,'xi',NULL,0,'2011-09-07 11:24:15',NULL,NULL,'','leave.1315362882647af7185bab9547108e51','经理审核','\0',NULL,97,97,NULL,'经理审核'),(10014,'T',1,'经理审核',NULL,'open',NULL,'xi',NULL,0,'2011-09-07 11:58:57',NULL,NULL,'','leave.131536292410ea76803694db4eec8c9d','经理审核','\0',NULL,10007,10007,NULL,'经理审核');

/*Table structure for table `jbpm4_variable` */

DROP TABLE IF EXISTS `jbpm4_variable`;

CREATE TABLE `jbpm4_variable` (
  `DBID_` bigint(20) NOT NULL,
  `CLASS_` varchar(255) COLLATE utf8_bin NOT NULL,
  `DBVERSION_` int(11) NOT NULL,
  `KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CONVERTER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HIST_` bit(1) DEFAULT NULL,
  `EXECUTION_` bigint(20) DEFAULT NULL,
  `TASK_` bigint(20) DEFAULT NULL,
  `LOB_` bigint(20) DEFAULT NULL,
  `DATE_VALUE_` datetime DEFAULT NULL,
  `DOUBLE_VALUE_` double DEFAULT NULL,
  `CLASSNAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `LONG_VALUE_` bigint(20) DEFAULT NULL,
  `STRING_VALUE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TEXT_VALUE_` longtext COLLATE utf8_bin,
  `EXESYS_` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`DBID_`),
  KEY `IDX_VAR_EXESYS` (`EXESYS_`),
  KEY `IDX_VAR_TASK` (`TASK_`),
  KEY `IDX_VAR_EXECUTION` (`EXECUTION_`),
  KEY `IDX_VAR_LOB` (`LOB_`),
  KEY `FK_VAR_EXESYS` (`EXESYS_`),
  KEY `FK_VAR_LOB` (`LOB_`),
  KEY `FK_VAR_TASK` (`TASK_`),
  KEY `FK_VAR_EXECUTION` (`EXECUTION_`),
  CONSTRAINT `FK_VAR_EXECUTION` FOREIGN KEY (`EXECUTION_`) REFERENCES `jbpm4_execution` (`DBID_`),
  CONSTRAINT `FK_VAR_EXESYS` FOREIGN KEY (`EXESYS_`) REFERENCES `jbpm4_execution` (`DBID_`),
  CONSTRAINT `FK_VAR_LOB` FOREIGN KEY (`LOB_`) REFERENCES `jbpm4_lob` (`DBID_`),
  CONSTRAINT `FK_VAR_TASK` FOREIGN KEY (`TASK_`) REFERENCES `jbpm4_task` (`DBID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `jbpm4_variable` */

insert  into `jbpm4_variable`(`DBID_`,`CLASS_`,`DBVERSION_`,`KEY_`,`CONVERTER_`,`HIST_`,`EXECUTION_`,`TASK_`,`LOB_`,`DATE_VALUE_`,`DOUBLE_VALUE_`,`CLASSNAME_`,`LONG_VALUE_`,`STRING_VALUE_`,`TEXT_VALUE_`,`EXESYS_`) values (38,'string',0,'username',NULL,'\0',37,NULL,NULL,NULL,NULL,NULL,NULL,'xi',NULL,NULL),(39,'string',0,'manager',NULL,'\0',37,NULL,NULL,NULL,NULL,NULL,NULL,'否',NULL,NULL),(40,'string',0,'leaveId',NULL,'\0',37,NULL,NULL,NULL,NULL,NULL,NULL,'1315299813218749cb60781443be8def',NULL,NULL),(53,'string',0,'username',NULL,'\0',52,NULL,NULL,NULL,NULL,NULL,NULL,'xi',NULL,NULL),(54,'string',0,'manager',NULL,'\0',52,NULL,NULL,NULL,NULL,NULL,NULL,'否',NULL,NULL),(55,'string',0,'leaveId',NULL,'\0',52,NULL,NULL,NULL,NULL,NULL,NULL,'131530002642a696074fee6540e3a343',NULL,NULL),(68,'string',0,'username',NULL,'\0',67,NULL,NULL,NULL,NULL,NULL,NULL,'xi',NULL,NULL),(69,'string',0,'manager',NULL,'\0',67,NULL,NULL,NULL,NULL,NULL,NULL,'否',NULL,NULL),(70,'string',0,'leaveId',NULL,'\0',67,NULL,NULL,NULL,NULL,NULL,NULL,'1315300123677cd7c357acc549b6b68b',NULL,NULL),(83,'string',0,'username',NULL,'\0',82,NULL,NULL,NULL,NULL,NULL,NULL,'xi',NULL,NULL),(84,'string',0,'manager',NULL,'\0',82,NULL,NULL,NULL,NULL,NULL,NULL,'否',NULL,NULL),(85,'string',0,'leaveId',NULL,'\0',82,NULL,NULL,NULL,NULL,NULL,NULL,'131530013296e7ada020c30245aaa460',NULL,NULL),(98,'string',0,'username',NULL,'\0',97,NULL,NULL,NULL,NULL,NULL,NULL,'xi',NULL,NULL),(99,'string',0,'manager',NULL,'\0',97,NULL,NULL,NULL,NULL,NULL,NULL,'否',NULL,NULL),(100,'string',0,'leaveId',NULL,'\0',97,NULL,NULL,NULL,NULL,NULL,NULL,'1315362882647af7185bab9547108e51',NULL,NULL),(10008,'string',0,'username',NULL,'\0',10007,NULL,NULL,NULL,NULL,NULL,NULL,'xi',NULL,NULL),(10009,'string',0,'manager',NULL,'\0',10007,NULL,NULL,NULL,NULL,NULL,NULL,'否',NULL,NULL),(10010,'string',0,'leaveId',NULL,'\0',10007,NULL,NULL,NULL,NULL,NULL,NULL,'131536292410ea76803694db4eec8c9d',NULL,NULL);

/*Table structure for table `leaved` */

DROP TABLE IF EXISTS `leaved`;

CREATE TABLE `leaved` (
  `id` varchar(32) COLLATE utf8_bin NOT NULL,
  `add_time` bigint(20) NOT NULL,
  `apply_time` bigint(20) DEFAULT NULL,
  `content` varchar(200) COLLATE utf8_bin NOT NULL,
  `day` int(11) NOT NULL,
  `status` int(1) DEFAULT '0',
  `users` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `taskId` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `start_time` bigint(20) NOT NULL,
  `end_time` bigint(20) NOT NULL,
  `audit_content` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKBE08885B91105E6A` (`users`),
  CONSTRAINT `FKBE08885B91105E6A` FOREIGN KEY (`users`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `leaved` */

insert  into `leaved`(`id`,`add_time`,`apply_time`,`content`,`day`,`status`,`users`,`taskId`,`start_time`,`end_time`,`audit_content`) values ('1315299606904e2a82c929064b6fa327',1315299482921,1315367936906,'sdfd',1,3,'1312869365235e1b9c4c768e4c079c15',NULL,1315299471000,1315385873000,''),('131529969629c20cccb56e3f4b3eab95',1315299696296,1315367936906,'sdfd',1,3,'1312869365235e1b9c4c768e4c079c15',NULL,1315299471000,1315385873000,'234234'),('1315299813218749cb60781443be8def',1315299723125,1315367936906,'234234',1,1,'1312869365235e1b9c4c768e4c079c15',NULL,1315386117000,1315472519000,NULL),('131530002642a696074fee6540e3a343',1315299829640,1315367936906,'234234',1,1,'1312869365235e1b9c4c768e4c079c15',NULL,1315386117000,1315472519000,NULL),('1315300123677cd7c357acc549b6b68b',1315299926390,1315367936906,'sdfd',1,1,'1312869365235e1b9c4c768e4c079c15',NULL,1315299922000,1315386324000,NULL),('131530013296e7ada020c30245aaa460',1315300039968,1315367936906,'sdfd',1,1,'1312869365235e1b9c4c768e4c079c15',NULL,1315300035000,1315386437000,NULL),('1315362882647af7185bab9547108e51',1315362882625,1315367936906,'234234',2,1,'1312869365235e1b9c4c768e4c079c15',NULL,1315362876000,1315535678000,NULL),('131536292410ea76803694db4eec8c9d',1315362924109,1315367936906,'23423',3,1,'1312869365235e1b9c4c768e4c079c15',NULL,1315362919000,1315535721000,NULL),('131536579267ef33300442194fcf9e0a',1315365792656,NULL,'2342sdf',3,0,'1312869365235e1b9c4c768e4c079c15',NULL,1315365786000,1315538587000,NULL),('131537385323a5c2873d9bd843aaa730',1315373853218,NULL,'234',3,0,'1312869365235e1b9c4c768e4c079c15',NULL,1315373847000,1315633049000,NULL),('13153739213460b9cc669d7e4152b7bf',1315373921343,NULL,'2423',4,0,'1312869365235e1b9c3c768e4c079c14',NULL,1315373913000,1315719516000,NULL);

/*Table structure for table `menu` */

DROP TABLE IF EXISTS `menu`;

CREATE TABLE `menu` (
  `id` varchar(32) COLLATE utf8_bin NOT NULL,
  `text` varchar(20) COLLATE utf8_bin NOT NULL,
  `parent` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `leaf` int(1) NOT NULL DEFAULT '1',
  `url` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `icon` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `menu` */

insert  into `menu`(`id`,`text`,`parent`,`leaf`,`url`,`icon`) values ('1312863325335e11234c128e4caa9c14','请假管理','1312863325335e1b9c3c128e4caa9c14',1,'web/jbpm/leaveList.jsp',NULL),('1312863325335e123c3c768e4c0abc14','用户信息','1312863325335e1b9c3c768e4c0abc14',1,'web/authority/userList.jsp',NULL),('1312863325335e1b9c3c128e4caa9c14','工作流管理','1312863325335e1b9c3c768e4caa9c14',0,NULL,NULL),('1312863325335e1b9c3c768e4c0abc14','权限管理','1312863325335e1b9c3c768e4caa9c14',0,NULL,NULL),('1312863325335e1b9c3c768e4caa9c14','JAT系统','1',0,NULL,NULL);

/*Table structure for table `resources` */

DROP TABLE IF EXISTS `resources`;

CREATE TABLE `resources` (
  `id` varchar(32) COLLATE utf8_bin NOT NULL,
  `describle` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `enabled` int(11) DEFAULT NULL,
  `name` varchar(32) COLLATE utf8_bin NOT NULL,
  `url` varchar(20) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `resources` */

insert  into `resources`(`id`,`describle`,`enabled`,`name`,`url`) values ('1312869365835e2baaacaaae4c079c14',NULL,1,'发贴','/post.action'),('13128abcbb8a5e23aaac768e4c079c14',NULL,1,'删帖','/delete.action'),('13128abcbb8bbe55abac768e4c079c14',NULL,1,'进入系统','/index.jsp');

/*Table structure for table `role_authorities` */

DROP TABLE IF EXISTS `role_authorities`;

CREATE TABLE `role_authorities` (
  `id` varchar(32) COLLATE utf8_bin NOT NULL,
  `authorities` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `role` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKD255F0D8FD16C4F1` (`authorities`),
  KEY `FKD255F0D881751D22` (`role`),
  CONSTRAINT `FKD255F0D881751D22` FOREIGN KEY (`role`) REFERENCES `roles` (`id`),
  CONSTRAINT `FKD255F0D8FD16C4F1` FOREIGN KEY (`authorities`) REFERENCES `authorities` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `role_authorities` */

insert  into `role_authorities`(`id`,`authorities`,`role`) values ('13128633253bbaab9c3c768e4c079c14','1312869365835e2baaac768e4c079c14','1312863325335e1b9c3c768e4c079c14'),('1312869363835e2babcd768e4c079c14','13128693bb8a5e2baaac768e4c079c14','1312863325335e1b9c3c768e4c079c14'),('1312869365835e2b4cab76834c079c45','1312869365835e2baaac768e4c079c14','1312869365835e2b4c3c768e4c079c14'),('13128693bb8a5e2baaac768ejcab7d23','13128693bb8a5e2baaac768e4c057d23','1312869365835e2b4c3c768e4c079c14'),('13128693ew8a5e2maaac768e4c057d23','13128693bb8a5e2baaac768e4c057d23','1312863325335e1b9c3c768e4c079c14');

/*Table structure for table `roles` */

DROP TABLE IF EXISTS `roles`;

CREATE TABLE `roles` (
  `id` varchar(32) COLLATE utf8_bin NOT NULL,
  `name` varchar(30) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `roles` */

insert  into `roles`(`id`,`name`) values ('1312863325335e1b9c3c768e4c079c14','管理员'),('1312869365835e2b4c3c768e4c079c14','普通用户');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` varchar(32) COLLATE utf8_bin NOT NULL,
  `enabled` int(11) NOT NULL,
  `password` varchar(50) COLLATE utf8_bin NOT NULL,
  `username` varchar(20) COLLATE utf8_bin NOT NULL,
  `role` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `position` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '职位',
  PRIMARY KEY (`id`),
  KEY `FK6A68E0881751D22` (`role`),
  CONSTRAINT `FK6A68E0881751D22` FOREIGN KEY (`role`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `users` */

insert  into `users`(`id`,`enabled`,`password`,`username`,`role`,`position`) values ('1312869365235e1b9c3c768e4c079c14',1,'1daca3122ee2ad16a959d40103448f5e','xi','1312863325335e1b9c3c768e4c079c14','经理'),('1312869365235e1b9c4c768e4c079c15',1,'47a733d60998c719cf3526ae7d106d13','user','1312869365835e2b4c3c768e4c079c14','职员'),('1312869bb5235e1babec768e4c079c15',1,'cc8333dc987840663ada37b9ebccabbc','sux','1312863325335e1b9c3c768e4c079c14','老板');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
