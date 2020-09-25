-- MySQL dump 10.13  Distrib 8.0.21, for Linux (x86_64)
--
-- Host: localhost    Database: digital_books
-- ------------------------------------------------------
-- Server version	8.0.21-0ubuntu0.20.04.4

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `article` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `type` tinyint(1) DEFAULT '1' COMMENT '文章类型',
  `title` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '标题',
  `summary` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '文章摘要',
  `tags` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '文章标签',
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '内容',
  `category` varchar(25) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '分类',
  `sub_category` varchar(25) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '二级目录',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `open_count` int DEFAULT '0' COMMENT '点击次数',
  `target_link` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '指向外链',
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '文章首图',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `idx_title` (`title`) USING BTREE COMMENT '标题不得重复'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='CMS文章中心';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cms_category`
--

DROP TABLE IF EXISTS `cms_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cms_category` (
  `category_id` bigint NOT NULL,
  `category_name` varchar(200) NOT NULL,
  `parent_id` bigint NOT NULL,
  `priority` int NOT NULL DEFAULT '0' COMMENT '显示顺序',
  `status` int DEFAULT NULL COMMENT '类别状态（1正常，0已删除，默认1）',
  `remark` varchar(500) DEFAULT NULL,
  `category_url` varchar(200) DEFAULT NULL,
  `is_default` int DEFAULT NULL,
  `cover_url` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`category_id`),
  UNIQUE KEY `index_category_id` (`category_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cms_category`
--

LOCK TABLES `cms_category` WRITE;
/*!40000 ALTER TABLE `cms_category` DISABLE KEYS */;
INSERT INTO `cms_category` VALUES (0,'系统分类',-1,1,1,'系统根分类，不许删除',NULL,1,NULL),(1,'中文期刊数据库',0,1,1,'中文期刊（一级栏目）','',1,NULL),(2,'外文期刊数据库',0,2,1,'外文期刊（一级栏目）','',1,NULL),(3,'情报中心产品',0,3,1,'情报中心产品（一级栏目）','',1,NULL),(4,'集团情报产品',0,4,1,'集团情报产品（一级栏目）','',1,NULL),(5,'期刊',0,5,1,'期刊（一级栏目）','',1,NULL),(6,'外购报告',0,6,1,'外购报告（一级栏目）','',1,NULL),(756881722213138432,'CNKI',1,1,1,'CNKI','http://192.168.1.20',0,NULL),(756881843055230976,'维普',1,2,1,'维普','http://192.168.',0,NULL),(756882028128894976,'超星',1,3,1,'超星','http://192.168.',0,NULL),(756883568289906688,'核心会议记录',2,1,1,'核心会议记录','http://192.168.',0,NULL),(756883659272749056,'核心期刊',2,2,1,'核心期刊','http://192.168.',0,NULL),(756883818891182080,'IEEE全文会议期刊',2,3,1,'IEEE全文会议期刊','http://192.168.',0,NULL),(756885144375132160,'专题报告',3,1,1,'集团情报产品>>专题报告','',0,NULL),(756885519010365440,'电子快报',3,2,1,'情报中心产品 >> 电子快报','',0,NULL),(757896232889745408,'半导体光电',5,1,1,'半导体光电','',0,'/res/website/images/1.jpg'),(757897523883933696,'微电子学',5,2,1,'微电子学','',0,'/res/website/images/2.jpg'),(757897752599330816,'磁性材料及器件',5,3,1,'磁性材料及器件','',0,'/res/website/images/3.jpg'),(757897872267018240,'压电与声光',5,4,1,'压电与声光','',0,'/res/website/images/4.jpg');
/*!40000 ALTER TABLE `cms_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cms_channel`
--

DROP TABLE IF EXISTS `cms_channel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cms_channel` (
  `channel_id` bigint NOT NULL,
  `channel_name` varchar(100) NOT NULL COMMENT '栏目名称',
  `model_id` bigint NOT NULL COMMENT '模型ID',
  `parent_id` bigint DEFAULT NULL COMMENT '父栏目ID',
  `channel_path` varchar(50) DEFAULT NULL COMMENT '访问路径',
  `priority` int NOT NULL COMMENT '排列顺序',
  `status` int DEFAULT NULL,
  `is_display` int NOT NULL DEFAULT '1' COMMENT '是否显示(0：否，1：是)',
  PRIMARY KEY (`channel_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cms_channel`
--

LOCK TABLES `cms_channel` WRITE;
/*!40000 ALTER TABLE `cms_channel` DISABLE KEYS */;
INSERT INTO `cms_channel` VALUES (1,'网站根栏目',2,-1,'dddd22',1,1,1),(740110090014556200,'关于贯中2',2,1,'/baidu.com',1,1,1);
/*!40000 ALTER TABLE `cms_channel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cms_channel_banner`
--

DROP TABLE IF EXISTS `cms_channel_banner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cms_channel_banner` (
  `banner_id` int NOT NULL AUTO_INCREMENT,
  `channel_id` bigint NOT NULL,
  `path` varchar(255) DEFAULT NULL COMMENT '图片路径',
  `priority` int DEFAULT NULL COMMENT '展示顺序',
  `link` varchar(255) DEFAULT NULL COMMENT '跳转路径',
  PRIMARY KEY (`banner_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cms_channel_banner`
--

LOCK TABLES `cms_channel_banner` WRITE;
/*!40000 ALTER TABLE `cms_channel_banner` DISABLE KEYS */;
INSERT INTO `cms_channel_banner` VALUES (1,1,'http://oss.maingoo.com.cn/20200804/a7e6355f96e8425a8f98e9af4255dacc.png',1,'pathdddd;baidu.com');
/*!40000 ALTER TABLE `cms_channel_banner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cms_channel_ext`
--

DROP TABLE IF EXISTS `cms_channel_ext`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cms_channel_ext` (
  `channel_id` bigint NOT NULL,
  `title` varchar(255) DEFAULT NULL COMMENT 'TITLE',
  `keywords` varchar(255) DEFAULT NULL COMMENT 'KEYWORDS',
  `description` varchar(255) DEFAULT NULL COMMENT 'DESCRIPTION',
  `link` varchar(255) DEFAULT NULL COMMENT '外部链接',
  `channel_pc_path` varchar(255) DEFAULT NULL COMMENT '栏目页(页面)',
  `channel_pc_content_path` varchar(255) DEFAULT NULL COMMENT '内容页(页面)',
  `channel_mobile_path` varchar(255) DEFAULT NULL COMMENT '手机栏目页(页面)',
  `channel_mobile_content_path` varchar(255) DEFAULT NULL COMMENT '手机内容页(页面)',
  `is_blank` varchar(255) DEFAULT NULL COMMENT '是否新窗口打开',
  `allow_share` int DEFAULT NULL,
  `allow_score` int DEFAULT '0' COMMENT '评分(1:开放;0:关闭,默认0)'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cms_channel_ext`
--

LOCK TABLES `cms_channel_ext` WRITE;
/*!40000 ALTER TABLE `cms_channel_ext` DISABLE KEYS */;
INSERT INTO `cms_channel_ext` VALUES (1,'11','22','33','44','55','66','66','77','0',1,0),(740110090014556200,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0',0,0);
/*!40000 ALTER TABLE `cms_channel_ext` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cms_channel_txt`
--

DROP TABLE IF EXISTS `cms_channel_txt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cms_channel_txt` (
  `channel_id` bigint NOT NULL,
  `txt` longtext,
  `txt1` longtext,
  `txt2` longtext,
  `txt3` longtext,
  `txt4` longtext
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cms_channel_txt`
--

LOCK TABLES `cms_channel_txt` WRITE;
/*!40000 ALTER TABLE `cms_channel_txt` DISABLE KEYS */;
INSERT INTO `cms_channel_txt` VALUES (1,'<p>dddd222</p>',NULL,NULL,NULL,NULL),(740110090014556200,'<p>惺惺惜惺惺2</p>',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `cms_channel_txt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cms_content`
--

DROP TABLE IF EXISTS `cms_content`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cms_content` (
  `content_id` varchar(64) NOT NULL,
  `channel_id` varchar(64) NOT NULL,
  `type_id` int DEFAULT NULL COMMENT '文章类别(除栏目以外的另一种类别)',
  `top_level` int DEFAULT NULL COMMENT '置顶级别',
  `has_title_img` int DEFAULT NULL COMMENT '是否有标题图片（0:否，1:是,默认0）',
  `is_recommend` int DEFAULT '0' COMMENT '是否推荐(0:不推荐，1：推荐，默认0)',
  `status` int DEFAULT '2' COMMENT '状态(0:草稿;1:审核中;2:审核通过;3:回收站；4:投稿，默认2)',
  `views_day` int DEFAULT NULL COMMENT '日观看量',
  `comments_day` int DEFAULT NULL COMMENT '日评论量',
  `downloads_day` int DEFAULT NULL COMMENT '日下载量',
  `ups_day` int DEFAULT NULL COMMENT '日顶量',
  PRIMARY KEY (`content_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cms_content`
--

LOCK TABLES `cms_content` WRITE;
/*!40000 ALTER TABLE `cms_content` DISABLE KEYS */;
/*!40000 ALTER TABLE `cms_content` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cms_content_attachment`
--

DROP TABLE IF EXISTS `cms_content_attachment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cms_content_attachment` (
  `content_id` varchar(64) DEFAULT NULL,
  `priority` int DEFAULT NULL COMMENT '显示顺序',
  `attach_path` varchar(200) DEFAULT NULL COMMENT '附件地址',
  `attach_name` varchar(200) DEFAULT NULL COMMENT '附件名称',
  `attach_size` double DEFAULT NULL COMMENT '附件大小(单位kb)',
  `download_count` int DEFAULT NULL COMMENT '下载次数'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cms_content_attachment`
--

LOCK TABLES `cms_content_attachment` WRITE;
/*!40000 ALTER TABLE `cms_content_attachment` DISABLE KEYS */;
/*!40000 ALTER TABLE `cms_content_attachment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cms_content_ext`
--

DROP TABLE IF EXISTS `cms_content_ext`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cms_content_ext` (
  `content_id` varchar(64) DEFAULT NULL,
  `title` varchar(150) DEFAULT NULL COMMENT '标题',
  `short_ttitle` varchar(150) DEFAULT NULL COMMENT '短标题(副标题)',
  `author` varchar(100) DEFAULT NULL COMMENT '作者',
  `origin` varchar(100) DEFAULT NULL COMMENT '来源',
  `origin_url` varchar(255) DEFAULT NULL COMMENT '来源链接',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `media_type` varchar(255) DEFAULT NULL COMMENT '媒体类型',
  `media_path` varchar(255) DEFAULT NULL COMMENT '媒体路径',
  `title_img` varchar(255) DEFAULT NULL COMMENT '标题图片',
  `content_img` varchar(255) DEFAULT NULL COMMENT '内容图片',
  `link` varchar(255) DEFAULT NULL COMMENT '链接地址',
  `tpl_content` varchar(255) DEFAULT NULL COMMENT '模板路径',
  `release_date` datetime DEFAULT NULL COMMENT '发布时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cms_content_ext`
--

LOCK TABLES `cms_content_ext` WRITE;
/*!40000 ALTER TABLE `cms_content_ext` DISABLE KEYS */;
/*!40000 ALTER TABLE `cms_content_ext` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cms_content_picture`
--

DROP TABLE IF EXISTS `cms_content_picture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cms_content_picture` (
  `content_id` varchar(64) DEFAULT NULL,
  `priority` int DEFAULT NULL COMMENT '显示顺序',
  `img_path` varchar(200) DEFAULT NULL COMMENT '图片地址',
  `description` varchar(255) DEFAULT NULL COMMENT '图片描述'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cms_content_picture`
--

LOCK TABLES `cms_content_picture` WRITE;
/*!40000 ALTER TABLE `cms_content_picture` DISABLE KEYS */;
/*!40000 ALTER TABLE `cms_content_picture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cms_data`
--

DROP TABLE IF EXISTS `cms_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cms_data` (
  `data_id` bigint NOT NULL,
  `category_id` bigint NOT NULL,
  `name` varchar(200) DEFAULT NULL,
  `abstracts` varchar(1000) DEFAULT NULL,
  `content` longtext,
  `cover_img_url` varchar(500) DEFAULT NULL,
  `author` varchar(100) DEFAULT NULL,
  `platform` varchar(100) DEFAULT NULL,
  `source` varchar(100) DEFAULT NULL,
  `public_num` varchar(45) DEFAULT NULL,
  `view_count` int DEFAULT NULL,
  `down_count` int DEFAULT NULL,
  `status` int DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`data_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cms_data`
--

LOCK TABLES `cms_data` WRITE;
/*!40000 ALTER TABLE `cms_data` DISABLE KEYS */;
INSERT INTO `cms_data` VALUES (757736628201455616,756885144375132160,'2222','222',NULL,'/upload_/baobei20200921225326.JPG','2222','222','2222',NULL,0,0,0,'2020-09-21 22:54:52'),(757737941219934208,756884514189344768,'资料名称','资料摘要\n',NULL,'/upload_/baobei20200921225927.JPG','资料作者','发表平台','资料来源','资料编号',0,0,0,'2020-09-21 23:00:03'),(757737993459990528,756884514189344768,'资料名称','资料摘要\n',NULL,'/upload_/baobei20200921225927.JPG','资料作者','发表平台','资料来源','资料编号',0,0,0,'2020-09-21 23:00:16'),(757742612403716096,756884514189344768,'11','11',NULL,'/upload_/baobei20200921231831.JPG','11','11','11','11',0,0,0,'2020-09-21 23:18:37'),(757742659593830400,756884514189344768,'11','11',NULL,'/upload_/baobei20200921231831.JPG','11','11','11','11',0,0,0,'2020-09-21 23:18:48'),(757744397541441536,756884514189344768,'122','122',NULL,NULL,'122','122','122','122',0,0,0,'2020-09-21 23:25:43'),(757748406717251584,756884514189344768,'222','222',NULL,'/upload_/baobei20200921234102.JPG','222','222','222','222',0,0,0,'2020-09-21 23:41:38'),(757766163823329280,0,'2','2',NULL,NULL,'2','2','2','2',0,0,0,'2020-09-22 00:52:12'),(757767749182160896,756884514189344768,'22','22',NULL,'/upload_/baobei20200922005824.JPG','22','22','22','22',0,0,0,'2020-09-22 00:58:30'),(757768002136440832,0,'33','3',NULL,NULL,'3','3','3','3',0,0,0,'2020-09-22 00:59:30'),(757768640341737472,756884677058363392,'d22','22',NULL,'/upload_/baobei20200922010146.JPG','22','22','22','22',0,0,0,'2020-09-22 01:02:03'),(757770910445862912,0,'33','3',NULL,NULL,'33','3','33','3',0,0,0,'2020-09-22 01:11:04'),(757770989030342656,0,'2','2',NULL,'/upload_/baobei20200922141002.JPG','2','2','2','2',0,0,1,'2020-09-22 01:11:22'),(757774373686870016,756884677058363392,'111','111',NULL,'/upload_/baobei20200922012443.JPG','111','111','111','111',0,0,1,'2020-09-22 01:24:49'),(757778683694940160,756884677058363392,'22','22',NULL,'/upload_/baobei20200922014153.JPG','22','22','22','22',0,0,1,'2020-09-22 01:41:57'),(758465995835703296,756885144375132160,'测试电子快报','测试内容先后i',NULL,NULL,NULL,NULL,'路边',NULL,0,0,1,'2020-09-23 23:13:05'),(758595141853249536,4,'的的的','的的的',NULL,NULL,'的的的',NULL,'的的的',NULL,0,0,1,'2020-09-24 07:46:16'),(758596740872929280,758237958653345792,'三','三',NULL,NULL,'三','三','三','三',0,0,1,'2020-09-24 07:52:37'),(758834008212635648,756885144375132160,'测试资料','测试资料测试资料测试资料测试资料测试资料测试资料测试资料测试资料测试资料测试资料测试资料测试资料测试资料测试资料测试资料测试资料测试资料测试资料测试资料测试资料测试资料测试资料测试资料测试资料测试资料测试资料测试资料测试资料测试资料测试资料测试资料测试资料测试资料测试资料测试资料测试资料测试资料测试资料测试资料测试资料测试资料测试资料测试资料测试资料',NULL,NULL,'质科部','中国科学网','135555','No000001',0,0,1,'2020-09-24 23:35:26'),(758958498376581120,757896232889745408,'期刊测试','123456',NULL,NULL,'123456','123456','13638301161','123456',0,0,0,'2020-09-25 07:50:07');
/*!40000 ALTER TABLE `cms_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cms_data_file`
--

DROP TABLE IF EXISTS `cms_data_file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cms_data_file` (
  `file_id` bigint NOT NULL,
  `data_id` bigint NOT NULL,
  `file_name` varchar(500) DEFAULT NULL,
  `file_size` bigint DEFAULT NULL,
  `file_path` varchar(500) DEFAULT NULL,
  `file_type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`file_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cms_data_file`
--

LOCK TABLES `cms_data_file` WRITE;
/*!40000 ALTER TABLE `cms_data_file` DISABLE KEYS */;
INSERT INTO `cms_data_file` VALUES (757744481498824704,757744397541441536,'baobei20200921232535.JPG',6270741,'/upload_/baobei20200921232535.JPG','image/jpeg'),(757748426497589248,757748406717251584,'graphQL20200921234105.png',1921611,'/upload_/graphQL20200921234105.png','image/png'),(757767749203132416,757767749182160896,'graphQL20200922005826.png',1921611,'/upload_/graphQL20200922005826.png','image/png'),(757768640358514688,757768640341737472,'baobei20200922010200.JPG',6270741,'/upload_/baobei20200922010200.JPG','image/jpeg'),(757778683745271808,757778683694940160,'graphQL20200922014155.png',1921611,'/upload_/graphQL20200922014155.png','image/png'),(757966988306808832,757770989030342656,'graphQL20200922141008.png',1921611,'/upload_/graphQL20200922141008.png','image/png'),(759039741579493376,758595141853249536,'51CTO下载-深入浅出学SpringWebMVC20200925131244.pdf',1004249,'/upload_/51CTO下载-深入浅出学SpringWebMVC20200925131244.pdf','application/pdf');
/*!40000 ALTER TABLE `cms_data_file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cms_link`
--

DROP TABLE IF EXISTS `cms_link`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cms_link` (
  `link_id` bigint DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `status` int DEFAULT NULL,
  `priority` varchar(45) DEFAULT NULL,
  `remark` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cms_link`
--

LOCK TABLES `cms_link` WRITE;
/*!40000 ALTER TABLE `cms_link` DISABLE KEYS */;
/*!40000 ALTER TABLE `cms_link` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cms_model`
--

DROP TABLE IF EXISTS `cms_model`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cms_model` (
  `model_id` varchar(64) NOT NULL COMMENT '模型ID',
  `model_name` varchar(50) NOT NULL COMMENT '模型名称,如新闻，视频，图片，单页等',
  `model_path` varchar(200) DEFAULT NULL COMMENT '模型路径',
  `model_content_path` varchar(200) DEFAULT NULL COMMENT '栏目内容对应的路径',
  `title_img_width` int DEFAULT '139' COMMENT '栏目标题图宽度',
  `title_img_height` int DEFAULT '139' COMMENT '栏目标题图高度',
  `content_img_width` int DEFAULT '310' COMMENT '栏目内容图宽度',
  `content_img_height` int DEFAULT '310' COMMENT '栏目内容图高度',
  `priority` int NOT NULL COMMENT '排列顺序',
  `view_style` int NOT NULL DEFAULT '1' COMMENT '页面呈现方式:1新闻列表，2产品图片列表，3案例图片列表，4单篇展示',
  `is_disabled` int NOT NULL DEFAULT '1' COMMENT '是否禁用(0:是，1否)',
  `is_def` int NOT NULL DEFAULT '0' COMMENT '是否是默认的模型（0否，1是，默认0）',
  PRIMARY KEY (`model_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cms_model`
--

LOCK TABLES `cms_model` WRITE;
/*!40000 ALTER TABLE `cms_model` DISABLE KEYS */;
INSERT INTO `cms_model` VALUES ('1','单页','/path/single',NULL,139,139,310,310,1,1,1,0),('2','新闻列表','/path/newslist',NULL,139,139,310,310,2,1,1,0),('3','图片列表','/path/piclist',NULL,139,139,310,310,3,1,1,0),('4','视频列表','/path/videolist',NULL,139,139,310,310,4,1,1,0),('5','招聘','/path/job/list',NULL,139,139,310,310,5,1,1,0);
/*!40000 ALTER TABLE `cms_model` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cms_notice`
--

DROP TABLE IF EXISTS `cms_notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cms_notice` (
  `notice_id` bigint DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `content` longtext,
  `source` varchar(100) DEFAULT NULL,
  `author` varchar(50) DEFAULT NULL,
  `priority` varchar(45) DEFAULT NULL,
  `public_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cms_notice`
--

LOCK TABLES `cms_notice` WRITE;
/*!40000 ALTER TABLE `cms_notice` DISABLE KEYS */;
INSERT INTO `cms_notice` VALUES (757877671475544064,'的的的','<p>的的的的的</p>','的的的','的的的','1','2020-09-22 08:15:18');
/*!40000 ALTER TABLE `cms_notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `msg_reply_rule`
--

DROP TABLE IF EXISTS `msg_reply_rule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `msg_reply_rule` (
  `rule_id` int NOT NULL AUTO_INCREMENT,
  `rule_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '规则名称',
  `match_value` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '匹配的关键词、事件等',
  `exact_match` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否精确匹配',
  `reply_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT 'text' COMMENT '回复消息类型',
  `reply_content` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '回复消息内容',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '规则是否有效',
  `desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '备注说明',
  `effect_time_start` time DEFAULT '00:00:00' COMMENT '生效起始时间',
  `effect_time_end` time DEFAULT '23:59:59' COMMENT '生效结束时间',
  `priority` int unsigned DEFAULT '0' COMMENT '规则优先级',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`rule_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='自动回复规则';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `msg_reply_rule`
--

LOCK TABLES `msg_reply_rule` WRITE;
/*!40000 ALTER TABLE `msg_reply_rule` DISABLE KEYS */;
INSERT INTO `msg_reply_rule` VALUES (1,'关注公众号','subscribe',1,'text','你好，欢迎关注！\n<a href=\"https://github.com/niefy\">点击链接查看我的主页</a>',1,'关注回复','00:00:00','23:59:59',0,'2020-05-20 11:52:16'),(9,'人工-9点前','人工,客服',0,'text','您好，人工在线时间为工作日9:00-17:30。现在是非人工时段，您的咨询，我们将于下一工作日回复。',1,'人工客服','00:00:00','09:00:00',0,'2020-05-20 11:52:16'),(10,'人工-五点半后','人工,客服',0,'text','您好，人工在线时间为工作日9:00-17:30。现在是非人工时段，您的咨询，我们将于下一工作日回复。',1,'人工客服','17:30:00','23:59:59',0,'2020-05-20 11:52:16'),(11,'人工-工作时间','人工',0,'text','人工在线时间为工作日9:00-17:30。如您于工作时间咨询，我们将于工作时间内回复您！',1,'人工客服','09:00:00','17:30:00',0,'2020-05-20 11:52:16');
/*!40000 ALTER TABLE `msg_reply_rule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `msg_template`
--

DROP TABLE IF EXISTS `msg_template`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `msg_template` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `template_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '公众号模板ID',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '模版名称',
  `title` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '标题',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '模板内容',
  `data` json DEFAULT NULL COMMENT '消息内容',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '链接',
  `miniprogram` json DEFAULT NULL COMMENT '小程序信息',
  `status` tinyint unsigned NOT NULL COMMENT '是否有效',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `idx_name` (`name`) USING BTREE COMMENT '模板名称',
  KEY `idx_status` (`status`) USING BTREE COMMENT '模板状态'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='消息模板';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `msg_template`
--

LOCK TABLES `msg_template` WRITE;
/*!40000 ALTER TABLE `msg_template` DISABLE KEYS */;
/*!40000 ALTER TABLE `msg_template` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_captcha`
--

DROP TABLE IF EXISTS `sys_captcha`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_captcha` (
  `uuid` char(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT 'uuid',
  `code` varchar(6) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '验证码',
  `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='系统验证码';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_captcha`
--

LOCK TABLES `sys_captcha` WRITE;
/*!40000 ALTER TABLE `sys_captcha` DISABLE KEYS */;
INSERT INTO `sys_captcha` VALUES ('01169834-363a-489a-8f60-28d516885949','58a6y','2020-07-03 00:32:59'),('024db7c9-7543-4248-84e5-26d6cdea760e','G4Fw','2020-08-11 10:37:37'),('02c7725d-9f91-4621-890e-d31bb1e3a10c','GUyN','2020-08-11 11:33:15'),('0484fc8b-51db-4282-84dc-b7ba7d3ea9d3','XGFK','2020-08-11 11:38:57'),('05e42b2a-d4d4-49b6-84b7-bf7e69e83838','dw365','2020-08-11 06:10:33'),('06c4e2f5-dc2c-4ed3-8ee0-36ba3e2dc678','3n7nc','2020-08-11 05:56:08'),('0856aae6-5539-4f44-8842-e6c67936b1cb','BR8F','2020-08-11 11:56:25'),('08a28d7a-c332-419b-8e50-8ef7a15b9726','8m533','2020-08-29 02:01:20'),('08ca8899-b6b5-4979-8006-497d6b26c23c','xf7g','2020-08-29 02:09:56'),('0e7ea412-945a-49f1-8fd8-ab87fcef0564','2g4d','2020-08-29 02:32:32'),('0f3a72fd-f69e-4a02-8eda-2e6d0ec12690','x7gxe','2020-08-11 06:11:40'),('0ff3d594-8c22-4f95-8c31-27660311cff2','35eab','2020-08-11 05:57:10'),('114d08be-ce21-4b6b-8977-6774cc4fd99c','meme','2020-08-29 02:34:14'),('1213718c-81c3-47de-8b46-8708957cee4c','xgde','2020-08-30 07:59:34'),('123d251e-e8de-483c-8d77-3192b7c2f153','y3exp','2020-07-28 23:34:49'),('129a9411-e45b-43d9-888a-f7bc77071fc7','8ppf','2020-08-29 02:12:58'),('12c0f22a-af0b-4eb0-898d-ff13a0cb70d8','34y2','2020-08-29 02:12:50'),('13a1b5df-d5b2-4c0e-8d9d-ca61daced839','89vk','2020-08-11 12:04:06'),('1710612a-5120-4e0e-8d9b-62c1b0ac9074','adbm','2020-09-19 10:53:19'),('17e20426-8f68-4d12-8fe2-3df8deada3c7','qVPG','2020-08-11 10:37:09'),('1b2074c1-9abe-41e0-8048-7dc45d50b3ec','vCS8','2020-08-11 11:56:10'),('1bb280a6-86da-40f1-815a-4f9b779129e1','egdx','2020-08-29 23:00:11'),('1d6d96f6-08de-4c48-8ee8-7f624129b2f1','88u4','2020-08-11 13:10:45'),('1def6a51-b40f-4082-8329-f4a7d27864b9','bgnm','2020-08-29 02:06:50'),('1f2da9e5-1d62-407d-8430-01929ddaf26d','y6nmp','2020-08-01 06:23:31'),('210ee058-3638-4ccf-852c-ab6b2adeac28','kgCf','2020-08-11 10:38:56'),('223a7241-406b-4ea9-82ab-60b5799c1bd4','nnDK','2020-08-11 11:34:08'),('234748ec-7630-406b-8f24-2bfd7ce47a14','3553','2020-08-30 12:06:51'),('23d57091-5446-469f-832b-f52dc4de1ed5','a85n','2020-08-29 02:08:04'),('24031568-7737-4c4c-830a-ee435e5e4d38','4fyd','2020-08-11 10:27:10'),('24bbdb5f-90a8-4dba-8458-e617bf4d0225','2ccnp','2020-08-02 06:38:08'),('2504253b-afce-44ca-8cc8-c833bc8ac960','bpea','2020-08-29 02:30:01'),('259110ef-339a-44e9-8ad4-ce3814414989','ywaa','2020-08-29 02:29:56'),('259885a2-7fb3-4274-81ea-fc738c85b332','5CaC','2020-08-11 12:03:12'),('2656e9b0-1fd2-44e1-8e28-5026c382f679','23xwy','2020-07-03 23:21:59'),('26dfb9b8-8579-42cd-8b77-345909aba717','abde','2020-08-29 02:09:50'),('27dc2536-821b-4007-863f-06cf4e437f7e','x7pnn','2020-07-07 23:48:02'),('28b42e48-9f1e-45ec-824f-af12bb776d28','nZqt','2020-08-11 11:36:04'),('2d779e97-499e-4c6a-8405-06d61851f7f8','8RWp','2020-08-11 12:13:00'),('2e176250-f2a8-4039-8925-0e1d204f5a66','FeY8','2020-08-11 12:14:40'),('2ed67297-37f3-4a30-8176-10513435b29d','x4yd','2020-08-11 12:23:34'),('2fc45984-ec72-4087-8b5b-f1f3343b5bd4','eeCs','2020-08-11 10:34:44'),('30712cf8-33f1-4c7d-82fc-2a8867462abb','ndb8','2020-08-11 10:26:30'),('3263be9b-9fe5-4075-88ce-e98f49a599be','qHbm','2020-08-11 12:23:34'),('3345f2fd-8adc-4282-88f2-e075d05b3c75','CvkS','2020-08-11 12:03:08'),('338f1ca5-97bc-4c4a-8c3a-41ebb04c20b8','6da8','2020-08-11 10:32:22'),('35e0ac57-e2e1-468c-8f77-32b24c83c7ec','fyen7','2020-08-11 05:59:50'),('3898f1f5-b18c-471c-82e2-224dbb19d531','5dwnb','2020-08-11 06:23:38'),('396f1116-8de8-4b1b-87fc-14dbbb622b15','p547','2020-08-11 11:56:01'),('39e040c8-e204-468f-8db4-c1220e7b1899','exe5','2020-08-11 10:27:06'),('3b587ec6-4d52-42dc-8c0e-58f2b2668930','32xn','2020-08-29 02:09:46'),('3cb37eba-e5ff-4aae-8c1e-960afb729e8b','T7RU','2020-08-11 13:10:52'),('3d684dcc-d773-4df1-8a2f-67b8d6762db1','e5y8','2020-08-29 02:27:53'),('3d8a6e6e-a502-4b4e-8af3-9b1f45283b20','6p8y','2020-08-29 02:06:53'),('404ead1e-3c35-4dc3-822a-09be9c15dbac','mwn6e','2020-08-02 22:49:02'),('410f852a-326b-435c-80f8-708b2b7ec630','D24v','2020-08-11 11:34:03'),('4156c569-5b97-468f-8fa5-50217560c909','by5p','2020-08-29 02:09:06'),('418e5792-f5e3-4a89-8a9d-f00408972ccd','48cdf','2020-08-11 05:55:02'),('449f6f85-1c87-4dcc-8885-364f1b3e3ef6','66f7','2020-09-01 00:31:00'),('44be05d9-29e5-410a-8a32-65ed4936f80f','n38w','2020-08-11 10:19:46'),('44c29f87-a092-4a56-8256-f608bfe44923','b8m5','2020-09-23 13:38:42'),('44c4cdfc-d30d-43f4-8dbf-b7adc2ae36ab','We4y','2020-08-11 11:32:33'),('46622b98-289a-4dc9-8883-cce4827f46ac','2ny2b','2020-08-11 05:56:54'),('47369fd2-95b6-4aa0-8517-e513e603b85a','6d3cn','2020-07-08 22:31:51'),('4c78d421-1bab-4715-8b6a-1ab995f2ee0b','cmxn','2020-08-29 02:32:30'),('4ecf53d1-6fe9-46b2-8b72-8fc759053333','mwD3','2020-08-11 12:03:10'),('520177fe-f618-4510-8064-f586a2e90e89','q6EZ','2020-08-11 11:27:29'),('52766d71-1bf0-4093-8816-0392d99ae07d','sfwA','2020-08-11 12:06:11'),('52fdb41a-4167-4643-86b2-ae27a8f2ab46','f5ae','2020-08-29 02:09:58'),('5305c5e4-101f-42cd-8d1b-d34597b1153b','62mf6','2020-06-25 23:55:55'),('53886979-6635-4f54-81cf-fc1b76497214','T2VE','2020-08-11 11:33:45'),('54297fff-363e-40d6-8991-fd4f86d52773','3y4x','2020-08-29 02:30:01'),('543cf8f7-b303-4bb8-8a14-7a8999d27b2d','Pwbx','2020-08-11 12:06:18'),('54e79730-e9ef-43e0-8a41-c69c53752d29','d8e7','2020-08-29 02:29:57'),('5686172f-6300-4fdd-8513-97dd11036ebc','5een','2020-08-29 02:29:51'),('56dfa68b-f611-4b89-8864-e057ba837790','cmw3y','2020-08-11 06:11:42'),('598a525f-3fa8-4ce2-8186-8a1caab424cf','aZc3','2020-08-11 12:15:11'),('5ac91d36-6737-4c6f-8994-d68d9610cc63','62St','2020-08-11 12:03:15'),('5acfca0e-886a-4158-8e4d-8bc7016ce5c1','2n6e3','2020-08-11 06:11:46'),('60144231-2687-4678-8113-92163a538a91','n323','2020-08-29 02:29:48'),('622a12e1-69ff-49c3-8802-ed6b879a022f','ScWr','2020-08-11 11:23:21'),('6279fa4b-2ce5-43d2-809c-72bf73c38cdc','p8fb','2020-08-29 02:09:53'),('62f7a589-9c84-45b3-827b-a14ba0d3a847','ge24','2020-08-29 02:21:10'),('6eb10dec-b6f6-40d3-8f05-63c7d458299e','fpd2','2020-08-29 02:09:57'),('6fe5e077-89da-494d-8416-2391b23a5d3f','67p35','2020-07-28 23:34:27'),('721186e7-3aee-4998-8d49-7eaea81faa3c','4pbdm','2020-06-26 16:31:37'),('751316d9-c23a-46f0-8436-b5d2fa7dbe82','ndb26','2020-08-11 06:08:51'),('751e9a8e-89d4-43cc-8deb-2695d3e04b37','f8n64','2020-08-02 06:38:16'),('75bdc84e-9ccc-4d9d-883e-bb664fd38b9f','Mas2','2020-08-11 12:23:34'),('7871e84d-7894-4509-8c56-9cb1e5e6e93e','uAVm','2020-08-11 12:09:46'),('78a4b24f-f226-4d40-8a4c-58c4b70b04ce','w6gY','2020-08-11 12:02:10'),('790e5cbf-0882-49dd-8e3d-eb9a6a2d7004','aqt9','2020-08-11 11:40:02'),('7c1f134d-f74c-4389-8f6f-f0eef1512050','bgmw','2020-08-29 02:05:07'),('7d8da7b2-d2d9-4959-8612-e84bc97e655e','ncxn','2020-08-11 10:31:48'),('7dac600f-d401-4a76-8825-a97c8b49935d','c7mb4','2020-06-26 00:01:17'),('7e93f6a2-2d1d-4552-8b2b-92f8f3d7f393','rwW3','2020-08-11 12:06:08'),('801212ef-0f7c-4edf-89f9-dcaf854f839a','a6Uq','2020-08-11 12:02:19'),('8014a011-10e3-4df8-8e52-a6c9a23c6ccb','yg7d','2020-08-29 02:12:54'),('805edd06-027b-4d1d-8fb6-f87cf6960a37','cpnp','2020-08-29 02:09:04'),('8077d93d-371c-4e05-8bcd-9ecf51a15b16','88f4','2020-08-29 02:29:59'),('81c482c0-de90-4c21-8fc0-75a9bb03cb2e','ngwc','2020-08-11 10:19:47'),('821e6f95-6fd2-4e8d-89d0-60adf5f2d4ec','cTf6','2020-08-11 12:52:25'),('84c96e44-f8e2-45ba-832a-1648ef245155','4x8d','2020-08-29 02:31:45'),('867b4690-0345-41b7-83d1-f80ede81055c','f7gen','2020-07-03 23:21:41'),('86800e56-61e9-4e95-8aab-0cf5a26ab9ce','eH74','2020-08-11 11:39:57'),('89a9b330-8a49-4f5a-8890-df86e9384e6a','ffnx','2020-09-01 00:32:30'),('8a6ee74f-4f0f-4486-84f6-c862d41e504a','gw4g','2020-08-11 10:27:55'),('8e730b6e-5fe7-4e9d-819e-fbf711541778','ShUC','2020-08-11 11:31:56'),('8fdce923-c48a-4362-8e64-9fd3812d9ca7','n3822','2020-08-11 05:59:42'),('8ff4dbdc-99b4-4131-809e-cadf075f7bba','3c8e','2020-09-21 12:47:45'),('90d21dba-97a6-4aa0-8b4d-427d6495e1d9','gg52','2020-08-29 02:12:56'),('90df0d26-3990-4a83-8fb1-bf378662356e','x27c7','2020-06-25 23:55:50'),('90f08c3f-0504-47c0-8ced-3cc53f15053b','5n7p','2020-08-29 02:12:59'),('93564504-3271-48bd-8f24-5107e7e919d4','Kp3W','2020-08-11 11:31:19'),('937f4de9-3c88-4765-8d95-b010ea505364','3gwmc','2020-07-25 21:23:31'),('93a45af9-e901-49e0-8c41-2b36d10c1e13','e35m','2020-08-30 07:59:39'),('93fae8d2-440e-4c61-8dfc-0030678228a9','n2e2y','2020-08-11 05:54:26'),('94d44364-969f-4b5c-8e35-ba33daf3719c','xm5n','2020-08-29 02:32:27'),('95ecb8e2-c8d0-4456-8e4f-95420230363e','68mm','2020-09-25 08:26:47'),('965e7d68-1a40-40c7-81ce-f2b305e1907b','napm','2020-09-19 14:14:09'),('96de1333-d81f-4b16-8b97-795a3467666e','6m3ce','2020-08-11 05:54:03'),('97b77b5e-2af3-4ff0-8309-3b50f9b6bbc8','7aam','2020-09-01 00:31:09'),('98a01c96-cf4e-4a6d-8f00-d598220531c7','5dAU','2020-08-11 12:06:02'),('9b71ada1-6f15-422c-8b12-877f13819d58','WBeP','2020-08-11 11:29:10'),('9c506639-9c7d-404e-84a4-b580a45e6516','mpye','2020-08-29 02:16:27'),('9d4eafb3-979e-4165-84ba-1b55ba9f7833','zHz8','2020-08-11 12:03:05'),('a058d35e-9f37-4d34-8001-c1325e2c9c82','nEAY','2020-08-11 11:46:58'),('a3a19440-76b4-4c74-886d-a2148a02fb92','58mf','2020-08-11 10:19:40'),('a42be0b8-ccf5-4222-8aeb-abd6a2250104','g5822','2020-08-11 05:54:14'),('aca7a6e2-afb3-4bfc-8582-edf5f3669628','c3bc','2020-08-30 07:59:36'),('b13004cd-c03d-4b73-859b-7f494341e227','8w8p','2020-08-29 02:09:55'),('b5685edf-8cf0-4923-84a7-10db9ed6440d','7bym5','2020-07-08 22:20:45'),('b57df093-ca0e-4550-84e8-0921b3172917','AvqD','2020-08-11 11:56:04'),('b65766c4-1b23-41df-83f4-afe40869afed','npg3','2020-08-29 02:36:01'),('b881349f-14e1-421c-8cc7-d60e3e5f38d9','fy45','2020-08-29 02:09:01'),('b9c017f9-a396-4e04-8a71-acd624ccd0da','74x5','2020-09-22 14:09:26'),('bd88a54a-e33a-4c2c-80ae-ef071ae83de2','wdaR','2020-08-11 10:42:23'),('bd8e7f4c-097a-4418-832e-603b1308d067','4a54m','2020-08-11 10:14:20'),('beb229e3-9f56-4524-8993-e068bc9177cb','fabf','2020-08-29 02:38:51'),('bf4784f4-88c2-4f57-8442-d0fb50fd7664','5p5d','2020-09-17 22:29:10'),('c017b76a-1936-4fb9-81db-cee9f8d7c64f','r4uW','2020-08-11 11:34:22'),('c1784a22-4c39-4b79-85d5-8f1d2e0f49f6','7nsM','2020-08-11 12:13:04'),('c37a41f8-7670-4a86-880b-c30fe7066ac2','2fenp','2020-08-01 06:23:53'),('c5261862-a9e5-46d9-8773-c835c6ea6d47','psHz','2020-08-11 12:13:00'),('c5555e17-7044-4d1e-8b0f-c074d256c3cf','UEp9','2020-08-11 11:48:06'),('c60939f5-d024-4d76-802f-777265b2f6b7','2f23','2020-08-29 02:10:02'),('c631390b-93d9-4ba7-8bf3-9157f952a5fe','c7dde','2020-07-03 00:32:59'),('c830d3f8-495b-4786-8d9e-790e161d6dc7','VEHs','2020-08-11 11:55:06'),('c8b19583-f5da-4e31-8a70-6f8d4e575279','yEvf','2020-08-11 11:27:32'),('cd5f4089-401b-424c-809d-c417a682286d','c4g2','2020-08-11 11:32:24'),('ce3ec0ac-915a-4b87-8b6c-621b633e68c4','7w6ce','2020-08-11 06:08:36'),('ce54786b-0e73-4180-8185-0b399bcdd416','ngbm','2020-08-29 02:07:30'),('cf48ffcc-1fa1-4e8e-8b8b-d578c5e67cee','c88b5','2020-08-11 06:06:28'),('cfdce0e1-78fb-4ec0-8bcd-12a687a4d4ec','3ndp','2020-08-29 02:27:48'),('d057ddfd-02f7-4996-867c-edfbf34f7d02','Zym2','2020-08-11 11:56:07'),('d1dc5c61-b490-49f7-8a3d-109a8d4e8078','e6nb4','2020-08-11 05:54:50'),('d37c364a-825f-43a2-8621-ec01180ef453','p44wn','2020-08-11 05:58:45'),('d38f67b5-7e10-4def-8c16-9dabfab1c1cb','end3','2020-08-29 02:32:26'),('d500c8b7-3d7c-4f28-82c4-018eb58ee332','n2f2','2020-08-29 02:26:05'),('d6339224-f4d5-4e60-8fc9-93a57c5f123a','ac4wy','2020-08-29 02:02:06'),('d6ed2f97-2fc8-4f9b-8c42-a8c2b53ac493','cftS','2020-08-11 11:33:32'),('d7089258-c5e4-4cbc-86f0-8f5cea0ee14d','6b8w','2020-08-11 10:19:45'),('d7f7a3b3-4b4e-4c88-8d71-380f8ae8b57b','nPds','2020-08-11 12:52:53'),('d80aae8a-0a2f-452e-8166-38006b4e53b9','nmwxw','2020-07-03 00:33:15'),('d857f8c0-aa4a-485d-856b-ce9287a94e00','nyrz','2020-08-11 11:31:33'),('d89b732e-7628-4f45-8e9c-9c36865cc655','gphY','2020-08-11 11:56:13'),('d9fc4ca3-1129-4b4c-87c1-31e3c93beae3','27cd','2020-08-11 10:19:43'),('de416267-ef78-4696-8c8c-0e748bf7f3b6','mSYd','2020-08-11 12:51:43'),('e12ae113-6fa8-41cb-8f74-04fc89af4751','y8ane','2020-06-25 23:55:54'),('e1da3742-5a4b-4d7a-88f7-9b90504a4710','cnmy','2020-08-11 10:37:38'),('e204c550-a6d6-402f-82e2-de24b3fcd370','DSwG','2020-08-11 10:37:40'),('e3ad171c-81e0-4b0f-88ad-ed03be51321b','S7Yb','2020-08-11 11:47:00'),('e4aa947b-044c-40db-8f0e-82821c840762','ppxw4','2020-07-03 00:33:20'),('e4cb3748-ad7c-425d-83f0-2c94dc093aee','5a3d','2020-08-29 02:19:34'),('e5b4c90e-864f-42bc-8e79-56ada8d02a47','pbd2','2020-08-29 02:21:13'),('e7ad9d11-4fbe-4c3b-80f2-86f10dedf851','RsSG','2020-08-11 11:33:06'),('e7dde7df-6710-4e45-85cb-4c11d50a1668','GXkV','2020-08-11 12:03:18'),('e7de0e6f-df78-4a01-8855-93bf18f408cd','ew38','2020-08-29 02:32:39'),('e8a13592-1838-4604-8a04-b2d52a78586f','UPvm','2020-08-11 11:55:58'),('e9a1b593-0c1a-41e0-8a09-64341aa8cc0c','weax3','2020-08-11 10:30:18'),('ee13bccb-a923-4cca-82da-e5922ebea1e5','6my8','2020-08-29 02:29:58'),('f1024410-c365-4aa6-8208-5f3dd66fb2c9','KGX4','2020-08-11 11:21:24'),('f10c39dd-fff1-4233-87b2-21591a458000','wyyn','2020-08-29 02:32:24'),('f1c1030a-7ffe-47b9-85f7-8e18fc361aa9','vGYN','2020-08-11 11:29:19'),('f2ac2282-7f2f-47b0-8474-0fb8f9ea7059','bny8','2020-08-29 02:09:03'),('f45c9224-90b8-4a50-849c-0c76ceadfcaf','7byy','2020-09-01 00:31:00'),('f6f77b09-5d1c-4177-88d6-e5c8769cf954','dm5c','2020-08-29 02:29:53'),('f872a8ca-c92a-44cb-8e4b-75c10e527cfd','fn26e','2020-06-25 23:51:04'),('f96c1496-c6db-4720-82e3-e386e0984252','nb85','2020-08-29 02:08:53'),('fa741724-2235-4ca3-84ca-32c37277354f','e52y','2020-09-19 16:07:56'),('fccf76a8-274c-404c-8653-7dcb8d720b0b','44a6a','2020-08-02 22:49:07'),('fcd386a8-b425-49da-8314-84de2f3ee85f','gbxn','2020-08-29 02:40:14'),('fd5a3044-d62d-478b-8345-0db248d1d498','6nb6','2020-08-29 02:32:28'),('ffdf3b32-cab0-4bf5-8dbf-255b183c5734','6e7n3','2020-07-09 21:50:29');
/*!40000 ALTER TABLE `sys_captcha` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_config`
--

DROP TABLE IF EXISTS `sys_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_config` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `param_key` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'key',
  `param_value` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'value',
  `status` tinyint DEFAULT '1' COMMENT '状态   0：隐藏   1：显示',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `param_key` (`param_key`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='系统配置信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_config`
--

LOCK TABLES `sys_config` WRITE;
/*!40000 ALTER TABLE `sys_config` DISABLE KEYS */;
INSERT INTO `sys_config` VALUES (1,'CLOUD_STORAGE_CONFIG_KEY','{\"type\":3,\"qiniuDomain\":\"\",\"qiniuPrefix\":\"\",\"qiniuAccessKey\":\"\",\"qiniuSecretKey\":\"\",\"qiniuBucketName\":\"\",\"aliyunDomain\":\"\",\"aliyunPrefix\":\"\",\"aliyunEndPoint\":\"\",\"aliyunAccessKeyId\":\"\",\"aliyunAccessKeySecret\":\"\",\"aliyunBucketName\":\"\",\"qcloudDomain\":\"\",\"qcloudPrefix\":\"\",\"qcloudAppId\":\"\",\"qcloudSecretId\":\"\",\"qcloudSecretKey\":\"\",\"qcloudBucketName\":\"\",\"qcloudRegion\":\"ap-guangzhou\"}',0,'云存储配置信息'),(2,'pageSize','1',1,'默认每页显示条数'),(3,'allowFileType','application/pdf,application/msword,application/vnd.ms-excel,application/x-xls,image/jpeg,application/x-jpg,image/png,application/x-png,image/gif,application/wps-office.docx,application/wps-office.xls',1,'允许上传的文件类型');
/*!40000 ALTER TABLE `sys_config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_log`
--

DROP TABLE IF EXISTS `sys_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_log` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户操作',
  `method` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '请求参数',
  `time` bigint DEFAULT NULL COMMENT '执行时长(毫秒)',
  `ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'IP地址',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='系统日志';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_log`
--

LOCK TABLES `sys_log` WRITE;
/*!40000 ALTER TABLE `sys_log` DISABLE KEYS */;
INSERT INTO `sys_log` VALUES (1,'admin','保存菜单','com.github.niefy.modules.sys.controller.SysMenuController.save()','[{\"icon\":\"el-icon-eleme\",\"menuId\":1113,\"name\":\"网站管理\",\"orderNum\":3,\"parentId\":0,\"perms\":\"\",\"type\":0,\"url\":\"\"}]',26,'127.0.0.1','2020-06-26 00:00:25'),(2,'admin','保存菜单','com.github.niefy.modules.sys.controller.SysMenuController.save()','[{\"icon\":\"\",\"menuId\":1114,\"name\":\"模型管理\",\"orderNum\":1,\"parentId\":1113,\"perms\":\"/cms:model:list\",\"type\":1,\"url\":\"/modelManage\"}]',13,'127.0.0.1','2020-06-26 00:02:37'),(3,'admin','保存菜单','com.github.niefy.modules.sys.controller.SysMenuController.save()','[{\"icon\":\"\",\"menuId\":1115,\"name\":\"栏目管理\",\"orderNum\":0,\"parentId\":1113,\"perms\":\"cms:channel:list\",\"type\":1,\"url\":\"/cms/channelManage\"}]',7,'127.0.0.1','2020-06-26 00:03:30'),(4,'admin','保存菜单','com.github.niefy.modules.sys.controller.SysMenuController.save()','[{\"icon\":\"\",\"menuId\":1116,\"name\":\"内容管理\",\"orderNum\":0,\"parentId\":1113,\"perms\":\"cms:content:list\",\"type\":1,\"url\":\"/contentManage\"}]',4,'127.0.0.1','2020-06-26 00:04:25'),(5,'admin','修改菜单','com.github.niefy.modules.sys.controller.SysMenuController.update()','[{\"icon\":\"el-icon-document-copy\",\"menuId\":7,\"name\":\"内容管理\",\"orderNum\":5,\"parentId\":0,\"perms\":\"\",\"type\":0,\"url\":\"\"}]',9,'127.0.0.1','2020-06-26 00:05:00'),(6,'admin','修改菜单','com.github.niefy.modules.sys.controller.SysMenuController.update()','[{\"icon\":\"el-icon-eleme\",\"menuId\":1113,\"name\":\"网站管理\",\"orderNum\":2,\"parentId\":0,\"perms\":\"\",\"type\":0,\"url\":\"\"}]',7,'127.0.0.1','2020-06-26 00:05:19'),(7,'admin','保存菜单','com.github.niefy.modules.sys.controller.SysMenuController.save()','[{\"icon\":\"\",\"menuId\":1117,\"name\":\"文章类别管理\",\"orderNum\":0,\"parentId\":1113,\"perms\":\"\",\"type\":1,\"url\":\"/cms/cartergeray\"}]',8,'127.0.0.1','2020-06-26 00:07:43'),(8,'admin','修改菜单','com.github.niefy.modules.sys.controller.SysMenuController.update()','[{\"icon\":\"\",\"menuId\":1114,\"name\":\"模型管理\",\"orderNum\":1,\"parentId\":1113,\"perms\":\"cms:model:list\",\"type\":1,\"url\":\"wx/cms/model\"}]',48,'127.0.0.1','2020-06-27 11:13:22'),(9,'admin','修改菜单','com.github.niefy.modules.sys.controller.SysMenuController.update()','[{\"icon\":\"\",\"menuId\":1115,\"name\":\"栏目管理\",\"orderNum\":0,\"parentId\":1113,\"perms\":\"cms:channel:list\",\"type\":1,\"url\":\"wx/cms/channel\"}]',78,'127.0.0.1','2020-06-27 11:13:49'),(10,'admin','修改菜单','com.github.niefy.modules.sys.controller.SysMenuController.update()','[{\"icon\":\"\",\"menuId\":1116,\"name\":\"内容管理\",\"orderNum\":0,\"parentId\":1113,\"perms\":\"cms:content:list\",\"type\":1,\"url\":\"wx/cms/content\"}]',139,'127.0.0.1','2020-06-27 11:14:03'),(11,'admin','修改菜单','com.github.niefy.modules.sys.controller.SysMenuController.update()','[{\"icon\":\"\",\"menuId\":1117,\"name\":\"文章类别管理\",\"orderNum\":0,\"parentId\":1113,\"perms\":\"\",\"type\":1,\"url\":\"wx/cms/category\"}]',21,'127.0.0.1','2020-06-27 11:14:48'),(12,'admin','修改菜单','com.github.niefy.modules.sys.controller.SysMenuController.update()','[{\"icon\":\"\",\"menuId\":1117,\"name\":\"文章类别管理\",\"orderNum\":0,\"parentId\":1113,\"perms\":\"cms:category:list\",\"type\":1,\"url\":\"wx/cms/category\"}]',20,'127.0.0.1','2020-06-27 11:15:06'),(13,'admin','修改菜单','com.github.niefy.modules.sys.controller.SysMenuController.update()','[{\"icon\":\"\",\"menuId\":1114,\"name\":\"模型管理\",\"orderNum\":1,\"parentId\":1113,\"perms\":\"cms:model:list\",\"type\":1,\"url\":\"cms/model\"}]',36,'127.0.0.1','2020-06-27 11:29:09'),(14,'admin','修改菜单','com.github.niefy.modules.sys.controller.SysMenuController.update()','[{\"icon\":\"\",\"menuId\":1115,\"name\":\"栏目管理\",\"orderNum\":0,\"parentId\":1113,\"perms\":\"cms:channel:list\",\"type\":1,\"url\":\"cms/channel\"}]',33,'127.0.0.1','2020-06-27 11:29:40'),(15,'admin','修改菜单','com.github.niefy.modules.sys.controller.SysMenuController.update()','[{\"icon\":\"\",\"menuId\":1116,\"name\":\"内容管理\",\"orderNum\":0,\"parentId\":1113,\"perms\":\"cms:content:list\",\"type\":1,\"url\":\"cms/content\"}]',39,'127.0.0.1','2020-06-27 11:29:47'),(16,'admin','修改菜单','com.github.niefy.modules.sys.controller.SysMenuController.update()','[{\"icon\":\"\",\"menuId\":1117,\"name\":\"文章类别管理\",\"orderNum\":0,\"parentId\":1113,\"perms\":\"cms:category:list\",\"type\":1,\"url\":\"cms/category\"}]',22,'127.0.0.1','2020-06-27 11:29:54'),(17,'admin','删除配置','com.github.niefy.modules.sys.controller.SysConfigController.delete()','[[null,null,null,null,null]]',182,'127.0.0.1','2020-08-12 06:52:06'),(18,'admin','修改菜单','com.github.niefy.modules.sys.controller.SysMenuController.update()','[{\"icon\":\"\",\"menuId\":1117,\"name\":\"文章类别管理\",\"orderNum\":4,\"parentId\":1113,\"perms\":\"cms:category:list\",\"type\":1,\"url\":\"cms/category\"}]',10,'127.0.0.1','2020-08-13 07:04:38'),(19,'admin','修改菜单','com.github.niefy.modules.sys.controller.SysMenuController.update()','[{\"icon\":\"\",\"menuId\":1115,\"name\":\"栏目管理\",\"orderNum\":2,\"parentId\":1113,\"perms\":\"cms:channel:list\",\"type\":1,\"url\":\"cms/channel\"}]',7,'127.0.0.1','2020-08-13 07:05:37'),(20,'admin','修改菜单','com.github.niefy.modules.sys.controller.SysMenuController.update()','[{\"icon\":\"\",\"menuId\":1116,\"name\":\"内容管理\",\"orderNum\":3,\"parentId\":1113,\"perms\":\"cms:content:list\",\"type\":1,\"url\":\"cms/content\"}]',6,'127.0.0.1','2020-08-13 07:05:43'),(21,'admin','保存菜单','com.github.niefy.modules.sys.controller.SysMenuController.save()','[{\"icon\":\"ww\",\"menuId\":1118,\"name\":\"wwww\",\"orderNum\":0,\"parentId\":0,\"perms\":\"ww\",\"type\":1,\"url\":\"ww\"}]',20,'127.0.0.1','2020-08-14 07:03:59'),(22,'admin','删除菜单','com.github.niefy.modules.sys.controller.SysMenuController.delete()','[1118]',62,'127.0.0.1','2020-08-14 07:05:48'),(23,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[6]',0,'127.0.0.1','2020-08-29 02:35:55'),(24,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[81]',13,'127.0.0.1','2020-08-29 02:37:24'),(25,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[85]',63,'127.0.0.1','2020-08-29 02:37:32'),(26,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[81]',0,'127.0.0.1','2020-08-29 02:37:36'),(27,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[81]',1,'127.0.0.1','2020-08-29 02:37:50'),(28,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[6]',0,'127.0.0.1','2020-08-29 02:38:06'),(29,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[6]',16,'127.0.0.1','2020-08-29 02:39:07'),(30,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[113]',10,'127.0.0.1','2020-08-29 02:39:12'),(31,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[117]',30,'127.0.0.1','2020-08-29 02:39:19'),(32,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[114]',17,'127.0.0.1','2020-08-29 02:39:23'),(33,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[115]',17,'127.0.0.1','2020-08-29 02:39:28'),(34,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[113]',0,'127.0.0.1','2020-08-29 02:39:32'),(35,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[110]',11,'127.0.0.1','2020-08-29 02:39:40'),(36,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[1111]',68,'127.0.0.1','2020-08-29 02:39:44'),(37,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[108]',4,'127.0.0.1','2020-08-29 02:39:48'),(38,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[109]',15,'127.0.0.1','2020-08-29 02:39:56'),(39,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[104]',14,'127.0.0.1','2020-08-29 02:40:02'),(40,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[105]',9,'127.0.0.1','2020-08-29 02:40:06'),(41,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[107]',25,'127.0.0.1','2020-08-29 02:40:10'),(42,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[72]',28,'127.0.0.1','2020-08-29 02:40:16'),(43,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[73]',19,'127.0.0.1','2020-08-29 02:40:20'),(44,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[74]',11,'127.0.0.1','2020-08-29 02:40:24'),(45,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[75]',21,'127.0.0.1','2020-08-29 02:40:29'),(46,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[67]',9,'127.0.0.1','2020-08-29 02:40:34'),(47,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[68]',19,'127.0.0.1','2020-08-29 02:40:38'),(48,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[69]',13,'127.0.0.1','2020-08-29 02:40:42'),(49,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[70]',15,'127.0.0.1','2020-08-29 02:40:46'),(50,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[35]',47,'127.0.0.1','2020-08-29 02:40:52'),(51,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[102]',9,'127.0.0.1','2020-08-29 02:40:56'),(52,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[1112]',10,'127.0.0.1','2020-08-29 02:40:59'),(53,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[99]',20,'127.0.0.1','2020-08-29 02:41:08'),(54,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[32]',10,'127.0.0.1','2020-08-29 02:41:12'),(55,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[34]',8,'127.0.0.1','2020-08-29 02:41:16'),(56,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[66]',7,'127.0.0.1','2020-08-29 02:41:20'),(57,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[71]',6,'127.0.0.1','2020-08-29 02:41:23'),(58,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[103]',16,'127.0.0.1','2020-08-29 02:41:27'),(59,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[108]',1,'127.0.0.1','2020-08-29 02:41:30'),(60,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[108]',1,'127.0.0.1','2020-08-29 02:41:36'),(61,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[113]',1,'127.0.0.1','2020-08-29 02:41:38'),(62,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[108]',0,'127.0.0.1','2020-08-29 02:41:47'),(63,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[113]',0,'127.0.0.1','2020-08-29 02:41:52'),(64,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[81]',9,'127.0.0.1','2020-08-29 02:41:58'),(65,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[113]',0,'127.0.0.1','2020-08-29 02:42:23'),(66,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[108]',0,'127.0.0.1','2020-08-29 02:43:30'),(67,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[30]',8,'127.0.0.1','2020-08-29 02:44:17'),(68,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[108]',38,'127.0.0.1','2020-08-29 22:44:17'),(69,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[113]',24,'127.0.0.1','2020-08-29 22:44:22'),(70,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[6]',0,'127.0.0.1','2020-08-29 22:44:28'),(71,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[6]',0,'127.0.0.1','2020-08-29 22:44:39'),(72,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[6]',1,'127.0.0.1','2020-08-29 22:45:50'),(73,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[6]',14,'127.0.0.1','2020-08-29 22:47:27'),(74,'admin','修改菜单','com.echuang.modules.sys.controller.SysMenuController.update()','[{\"icon\":\"\",\"menuId\":1117,\"name\":\"资料类别管理\",\"orderNum\":4,\"parentId\":1113,\"perms\":\"cms:category:list\",\"type\":1,\"url\":\"cms/category\"}]',10,'127.0.0.1','2020-08-29 22:48:32'),(75,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[1114]',35,'127.0.0.1','2020-08-29 22:48:49'),(76,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[1115]',15,'127.0.0.1','2020-08-29 22:48:55'),(77,'admin','修改菜单','com.echuang.modules.sys.controller.SysMenuController.update()','[{\"icon\":\"\",\"menuId\":1116,\"name\":\"资料信息管理\",\"orderNum\":3,\"parentId\":1113,\"perms\":\"cms:content:list\",\"type\":1,\"url\":\"cms/content\"}]',6,'127.0.0.1','2020-08-29 22:49:21'),(78,'admin','修改菜单','com.echuang.modules.sys.controller.SysMenuController.update()','[{\"icon\":\"\",\"menuId\":1117,\"name\":\"资料类别管理\",\"orderNum\":1,\"parentId\":1113,\"perms\":\"cms:category:list\",\"type\":1,\"url\":\"cms/category\"}]',3,'127.0.0.1','2020-08-29 22:49:31'),(79,'admin','修改菜单','com.echuang.modules.sys.controller.SysMenuController.update()','[{\"icon\":\"\",\"menuId\":1116,\"name\":\"资料信息管理\",\"orderNum\":2,\"parentId\":1113,\"perms\":\"cms:content:list\",\"type\":1,\"url\":\"cms/content\"}]',8,'127.0.0.1','2020-08-29 22:49:50'),(80,'admin','保存菜单','com.echuang.modules.sys.controller.SysMenuController.save()','[{\"icon\":\"\",\"menuId\":1119,\"name\":\"通知公告管理\",\"orderNum\":3,\"parentId\":1113,\"perms\":\"\",\"type\":1,\"url\":\"/notice\"}]',7,'127.0.0.1','2020-08-29 22:54:01'),(81,'admin','保存菜单','com.echuang.modules.sys.controller.SysMenuController.save()','[{\"icon\":\"\",\"menuId\":1120,\"name\":\"推荐链接\",\"orderNum\":4,\"parentId\":1113,\"perms\":\"\",\"type\":1,\"url\":\"/link\"}]',12,'127.0.0.1','2020-08-29 22:54:56'),(82,'admin','保存角色','com.echuang.modules.sys.controller.SysRoleController.save()','[{\"createTime\":1598744654440,\"createUserId\":1,\"menuIdList\":[7,41,42,43,44,45,9,29,1113,1116,1117,1119,1120],\"remark\":\"\",\"roleId\":1,\"roleName\":\"资料录入员\"}]',204,'127.0.0.1','2020-08-30 07:44:15'),(83,'admin','保存用户','com.echuang.modules.sys.controller.SysUserController.save()','[{\"createTime\":1598744692059,\"createUserId\":1,\"email\":\"test@qq.com\",\"mobile\":\"15310178334\",\"password\":\"01bcc499683f7e0a0c199d6f2923d663943bb53ee1cd36c9253c7449fb5faa44\",\"roleIdList\":[1],\"salt\":\"t4bQvf3ZehlMN4h0YckB\",\"status\":1,\"userId\":2,\"username\":\"haiyan\"}]',99,'127.0.0.1','2020-08-30 07:44:52'),(84,'admin','修改菜单','com.echuang.modules.sys.controller.SysMenuController.update()','[{\"icon\":\"\",\"menuId\":1116,\"name\":\"内容管理\",\"orderNum\":2,\"parentId\":1113,\"perms\":\"cms:content:list\",\"type\":1,\"url\":\"/cms/content\"}]',61,'127.0.0.1','2020-09-01 01:08:57'),(85,'admin','保存菜单','com.echuang.modules.sys.controller.SysMenuController.save()','[{\"icon\":\"\",\"menuId\":1121,\"name\":\"文件管理\",\"orderNum\":5,\"parentId\":1,\"perms\":\"sys:oss:list\",\"type\":1,\"url\":\"filemanage.vue\"}]',113,'127.0.0.1','2020-09-20 09:15:52'),(86,'admin','保存菜单','com.echuang.modules.sys.controller.SysMenuController.save()','[{\"icon\":\"\",\"menuId\":1122,\"name\":\"上传文件\",\"orderNum\":0,\"parentId\":1121,\"perms\":\"sys:oss:upload\",\"type\":2,\"url\":\"\"}]',95,'127.0.0.1','2020-09-20 09:29:31'),(87,'admin','修改菜单','com.echuang.modules.sys.controller.SysMenuController.update()','[{\"icon\":\"\",\"menuId\":1120,\"name\":\"推荐链接\",\"orderNum\":4,\"parentId\":1113,\"perms\":\"\",\"type\":1,\"url\":\"/cms/links\"}]',108,'127.0.0.1','2020-09-22 02:30:24'),(88,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[41]',6,'127.0.0.1','2020-09-22 03:01:52'),(89,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[45]',271,'127.0.0.1','2020-09-22 03:01:59'),(90,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[44]',173,'127.0.0.1','2020-09-22 03:02:02'),(91,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[43]',140,'127.0.0.1','2020-09-22 03:02:06'),(92,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[42]',179,'127.0.0.1','2020-09-22 03:02:09'),(93,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[41]',1,'127.0.0.1','2020-09-22 03:02:13'),(94,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[41]',0,'127.0.0.1','2020-09-22 03:02:22'),(95,'admin','删除菜单','com.echuang.modules.sys.controller.SysMenuController.delete()','[41]',0,'127.0.0.1','2020-09-22 03:02:30'),(96,'admin','修改菜单','com.echuang.modules.sys.controller.SysMenuController.update()','[{\"icon\":\"\",\"menuId\":1119,\"name\":\"通知公告\",\"orderNum\":3,\"parentId\":1113,\"perms\":\"\",\"type\":1,\"url\":\"/cms/notice\"}]',66,'127.0.0.1','2020-09-22 03:05:01'),(97,'admin','修改菜单','com.echuang.modules.sys.controller.SysMenuController.update()','[{\"icon\":\"\",\"menuId\":1117,\"name\":\"资料类别\",\"orderNum\":1,\"parentId\":1113,\"perms\":\"cms:category:list\",\"type\":1,\"url\":\"/cms/category\"}]',100,'127.0.0.1','2020-09-22 03:05:11'),(98,'admin','修改菜单','com.echuang.modules.sys.controller.SysMenuController.update()','[{\"icon\":\"\",\"menuId\":1119,\"name\":\"通知公告\",\"orderNum\":3,\"parentId\":1113,\"perms\":\"cms:notice:list\",\"type\":1,\"url\":\"/cms/notice\"}]',107,'127.0.0.1','2020-09-22 03:05:47'),(99,'admin','修改菜单','com.echuang.modules.sys.controller.SysMenuController.update()','[{\"icon\":\"\",\"menuId\":1120,\"name\":\"推荐链接\",\"orderNum\":4,\"parentId\":1113,\"perms\":\"cms:links:list\",\"type\":1,\"url\":\"/cms/links\"}]',62,'127.0.0.1','2020-09-22 03:06:05'),(100,'admin','删除用户','com.echuang.modules.sys.controller.SysUserController.delete()','[[2]]',94,'0:0:0:0:0:0:0:1','2020-09-22 13:54:32'),(101,'admin','保存用户','com.echuang.modules.sys.controller.SysUserController.save()','[{\"createTime\":1600754107010,\"createUserId\":1,\"email\":\"249590716@qq.com\",\"mobile\":\"13666655555\",\"password\":\"80d44761620c4965425a77b70011500b2a5136c779c5581e87848d9e284a35b1\",\"roleIdList\":[1],\"salt\":\"j6wU1Q7K3yQHd2uqVl5W\",\"status\":1,\"userId\":3,\"username\":\"haiyan\"}]',333,'0:0:0:0:0:0:0:1','2020-09-22 13:55:07'),(102,'admin','保存配置','com.echuang.modules.sys.controller.SysConfigController.save()','[{\"id\":2,\"paramKey\":\"pageSize\",\"paramValue\":\"10\",\"remark\":\"默认每页显示条数\"}]',130,'0:0:0:0:0:0:0:1','2020-09-25 06:17:45'),(103,'admin','修改配置','com.echuang.modules.sys.controller.SysConfigController.update()','[{\"id\":2,\"paramKey\":\"pageSize\",\"paramValue\":\"1\",\"remark\":\"默认每页显示条数\"}]',154,'0:0:0:0:0:0:0:1','2020-09-25 06:30:38'),(104,'admin','保存配置','com.echuang.modules.sys.controller.SysConfigController.save()','[{\"id\":3,\"paramKey\":\"allowFileType\",\"paramValue\":\"application/pdf,application/msword,application/vnd.ms-excel,application/x-xls,image/jpeg,application/x-jpg,image/png,application/x-png,image/gif,application/wps-office.docx,application/wps-office.xls\",\"remark\":\"允许上传的文件类型\"}]',152,'127.0.0.1','2020-09-25 13:33:49');
/*!40000 ALTER TABLE `sys_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_menu`
--

DROP TABLE IF EXISTS `sys_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_menu` (
  `menu_id` bigint NOT NULL AUTO_INCREMENT,
  `parent_id` bigint DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '菜单图标',
  `order_num` int DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1123 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='菜单管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_menu`
--

LOCK TABLES `sys_menu` WRITE;
/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;
INSERT INTO `sys_menu` VALUES (1,0,'系统管理',NULL,NULL,0,'el-icon-s-tools',0),(2,1,'管理员列表','sys/user',NULL,1,'admin',1),(3,1,'角色管理','sys/role',NULL,1,'role',2),(4,1,'菜单管理','sys/menu',NULL,1,'menu',3),(9,0,'日志报表','','',0,'el-icon-s-order',4),(15,2,'查看',NULL,'sys:user:list,sys:user:info',2,NULL,0),(16,2,'新增',NULL,'sys:user:save,sys:role:select',2,NULL,0),(17,2,'修改',NULL,'sys:user:update,sys:role:select',2,NULL,0),(18,2,'删除',NULL,'sys:user:delete',2,NULL,0),(19,3,'查看',NULL,'sys:role:list,sys:role:info',2,NULL,0),(20,3,'新增',NULL,'sys:role:save,sys:menu:list',2,NULL,0),(21,3,'修改',NULL,'sys:role:update,sys:menu:list',2,NULL,0),(22,3,'删除',NULL,'sys:role:delete',2,NULL,0),(23,4,'查看',NULL,'sys:menu:list,sys:menu:info',2,NULL,0),(24,4,'新增',NULL,'sys:menu:save,sys:menu:select',2,NULL,0),(25,4,'修改',NULL,'sys:menu:update,sys:menu:select',2,NULL,0),(26,4,'删除',NULL,'sys:menu:delete',2,NULL,0),(27,1,'参数管理','sys/config','sys:config:list,sys:config:info,sys:config:save,sys:config:update,sys:config:delete',1,'config',6),(29,9,'系统日志','sys/log','sys:log:list',1,'log',7),(1113,0,'网站管理','','',0,'el-icon-eleme',2),(1116,1113,'内容管理','/cms/content','cms:content:list',1,'',2),(1117,1113,'资料类别','/cms/category','cms:category:list',1,'',1),(1119,1113,'通知公告','/cms/notice','cms:notice:list',1,'',3),(1120,1113,'推荐链接','/cms/links','cms:links:list',1,'',4),(1121,1,'文件管理','filemanage.vue','sys:oss:list',1,'',5),(1122,1121,'上传文件','','sys:oss:upload',2,'',0);
/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_oss`
--

DROP TABLE IF EXISTS `sys_oss`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_oss` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'URL地址',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='文件上传';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_oss`
--

LOCK TABLES `sys_oss` WRITE;
/*!40000 ALTER TABLE `sys_oss` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_oss` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role` (
  `role_id` bigint NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '备注',
  `create_user_id` bigint DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='角色';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES (1,'资料录入员','',1,'2020-08-30 07:44:14');
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_menu`
--

DROP TABLE IF EXISTS `sys_role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role_menu` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `role_id` bigint DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='角色与菜单对应关系';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_menu`
--

LOCK TABLES `sys_role_menu` WRITE;
/*!40000 ALTER TABLE `sys_role_menu` DISABLE KEYS */;
INSERT INTO `sys_role_menu` VALUES (1,1,7),(2,1,41),(7,1,9),(8,1,29),(9,1,1113),(10,1,1116),(11,1,1117),(12,1,1119),(13,1,1120);
/*!40000 ALTER TABLE `sys_role_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_user` (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '密码',
  `salt` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '盐',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '手机号',
  `status` tinyint DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `create_user_id` bigint DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE KEY `username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='系统用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES (1,'admin','cdac762d0ba79875489f6a8b430fa8b5dfe0cdd81da38b80f02f33328af7fd4a','YzcmCZNvbXocrsz9dm8e','niefy@qq.com','16666666666',1,1,'2016-11-11 11:11:11'),(3,'haiyan','80d44761620c4965425a77b70011500b2a5136c779c5581e87848d9e284a35b1','j6wU1Q7K3yQHd2uqVl5W','249590716@qq.com','13666655555',1,1,'2020-09-22 13:55:07');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_role`
--

DROP TABLE IF EXISTS `sys_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_user_role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='用户与角色对应关系';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_role`
--

LOCK TABLES `sys_user_role` WRITE;
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
INSERT INTO `sys_user_role` VALUES (1,2,1),(2,3,1);
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_token`
--

DROP TABLE IF EXISTS `sys_user_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_user_token` (
  `user_id` bigint NOT NULL,
  `token` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT 'token',
  `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE KEY `token` (`token`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='系统用户Token';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_token`
--

LOCK TABLES `sys_user_token` WRITE;
/*!40000 ALTER TABLE `sys_user_token` DISABLE KEYS */;
INSERT INTO `sys_user_token` VALUES (1,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyTmFtZSI6ImFkbWluIiwiZXhwIjoxNjAxNTk4MzkyLCJ1c2VySWQiOiIxIn0.HheYCxon6-v1gOmR5Af5yVHa_5EiXeBaSkfn3ILH-WM','2020-09-25 20:26:32','2020-09-25 08:26:32'),(2,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyTmFtZSI6ImhhaXlhbiIsImV4cCI6MTU5OTQ5NDUxMiwidXNlcklkIjoiMiJ9.ifol43Q8gqk1wamCAvCjBIlffmhHbmnvbM1ZKWDgtO0','2020-09-01 11:59:54','2020-08-31 23:59:54');
/*!40000 ALTER TABLE `sys_user_token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `template_msg_log`
--

DROP TABLE IF EXISTS `template_msg_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `template_msg_log` (
  `log_id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `touser` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户openid',
  `template_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'templateid',
  `data` json DEFAULT NULL COMMENT '消息数据',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '消息链接',
  `miniprogram` json DEFAULT NULL COMMENT '小程序信息',
  `send_time` datetime DEFAULT NULL COMMENT '发送时间',
  `send_result` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '发送结果',
  PRIMARY KEY (`log_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='微信模版消息发送记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `template_msg_log`
--

LOCK TABLES `template_msg_log` WRITE;
/*!40000 ALTER TABLE `template_msg_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `template_msg_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wx_msg`
--

DROP TABLE IF EXISTS `wx_msg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wx_msg` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `openid` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '微信用户ID',
  `in_out` tinyint unsigned DEFAULT NULL COMMENT '消息方向',
  `msg_type` char(25) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '消息类型',
  `detail` json DEFAULT NULL COMMENT '消息详情',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='微信消息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wx_msg`
--

LOCK TABLES `wx_msg` WRITE;
/*!40000 ALTER TABLE `wx_msg` DISABLE KEYS */;
/*!40000 ALTER TABLE `wx_msg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wx_qr_code`
--

DROP TABLE IF EXISTS `wx_qr_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wx_qr_code` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `is_temp` tinyint(1) DEFAULT NULL COMMENT '是否为临时二维码',
  `scene_str` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '场景值ID',
  `ticket` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '二维码ticket',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '二维码图片解析后的地址',
  `expire_time` datetime DEFAULT NULL COMMENT '该二维码失效时间',
  `create_time` datetime DEFAULT NULL COMMENT '该二维码创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='公众号带参二维码';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wx_qr_code`
--

LOCK TABLES `wx_qr_code` WRITE;
/*!40000 ALTER TABLE `wx_qr_code` DISABLE KEYS */;
/*!40000 ALTER TABLE `wx_qr_code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wx_user`
--

DROP TABLE IF EXISTS `wx_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wx_user` (
  `openid` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '微信openid',
  `phone` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
  `nickname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '昵称',
  `sex` tinyint DEFAULT NULL COMMENT '性别(0-未知、1-男、2-女)',
  `city` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '城市',
  `province` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '省份',
  `headimgurl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '头像',
  `subscribe_time` datetime DEFAULT NULL COMMENT '订阅时间',
  `subscribe` tinyint unsigned DEFAULT '1' COMMENT '是否关注',
  `unionid` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'unionid',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  `tagid_list` json DEFAULT NULL COMMENT '标签ID列表',
  `subscribe_scene` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '关注场景',
  `qr_scene_str` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '扫码场景值',
  PRIMARY KEY (`openid`) USING BTREE,
  KEY `idx_unionid` (`unionid`) USING BTREE COMMENT 'unionid'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wx_user`
--

LOCK TABLES `wx_user` WRITE;
/*!40000 ALTER TABLE `wx_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `wx_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-25 13:57:13
