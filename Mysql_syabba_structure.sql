/*
SQLyog Enterprise v12.2.6 (64 bit)
MySQL - 5.1.73-community : Database - syabbs
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`syabbs` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `syabbs`;

/*Table structure for table `cn_comment` */

DROP TABLE IF EXISTS `cn_comment`;

CREATE TABLE `cn_comment` (
  `comment_id` varchar(100) NOT NULL COMMENT '评论ID',
  `post_id` varchar(100) NOT NULL COMMENT '贴子ID',
  `user_id` varchar(100) NOT NULL COMMENT '用户ID',
  `comment_status` varchar(100) NOT NULL COMMENT '状态',
  `comment_body` text COMMENT '评论内容',
  `comment_create_time` varchar(20) DEFAULT NULL COMMENT '评论创建时间',
  `comment_last_modify_time` varchar(20) DEFAULT NULL COMMENT '评论最近修改时间',
  PRIMARY KEY (`comment_id`),
  KEY `NewIndex1` (`post_id`),
  KEY `NewIndex2` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `cn_post` */

DROP TABLE IF EXISTS `cn_post`;

CREATE TABLE `cn_post` (
  `post_id` varchar(100) NOT NULL COMMENT '贴子ID',
  `plate_id` varchar(100) NOT NULL COMMENT '板块ID',
  `user_id` varchar(100) NOT NULL COMMENT '用户ID',
  `post_status` varchar(100) NOT NULL COMMENT '贴子状态',
  `post_title` varchar(500) DEFAULT NULL COMMENT '贴子标题',
  `post_body` text COMMENT '贴子内容65k2w汉字',
  `post_create_time` varchar(20) DEFAULT NULL COMMENT '贴子创建时间',
  `post_last_modify_time` varchar(20) DEFAULT NULL COMMENT '贴子最近修改时间',
  PRIMARY KEY (`post_id`),
  KEY `user_id_key` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `cn_user` */

DROP TABLE IF EXISTS `cn_user`;

CREATE TABLE `cn_user` (
  `user_id` varchar(100) NOT NULL COMMENT '用户ID',
  `user_name` varchar(100) DEFAULT NULL COMMENT '用户名',
  `user_password` varchar(100) DEFAULT NULL COMMENT '密码',
  `user_mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `user_token` varchar(100) DEFAULT NULL COMMENT '令牌',
  PRIMARY KEY (`user_id`),
  KEY `NewIndex1` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `cn_user_info` */

DROP TABLE IF EXISTS `cn_user_info`;

CREATE TABLE `cn_user_info` (
  `user_id` varchar(100) NOT NULL COMMENT '用户ID',
  `user_nick` varchar(100) DEFAULT NULL COMMENT '用户昵称',
  `user_QQ` varchar(100) DEFAULT NULL COMMENT 'QQ',
  `user_email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `user_birth` varchar(100) DEFAULT NULL COMMENT '生日',
  `user_sex` varchar(100) DEFAULT NULL COMMENT '性别',
  `user_lv` varchar(100) DEFAULT NULL COMMENT '等级',
  `user_sign_time` varchar(100) DEFAULT NULL COMMENT '注册时间',
  `user_login_time` varchar(100) DEFAULT NULL COMMENT '最近登录时间',
  `user_post` varchar(100) DEFAULT NULL COMMENT '发帖数',
  `user_reply` varchar(100) DEFAULT NULL COMMENT '回帖数',
  `user_point` varchar(100) DEFAULT NULL COMMENT '用户积分',
  `user_prestige` varchar(100) DEFAULT NULL COMMENT '用户威望',
  `user_head` text COMMENT '用户头像',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `test` */

DROP TABLE IF EXISTS `test`;

CREATE TABLE `test` (
  `modtime` bigint(20) DEFAULT NULL COMMENT '时间戳测试'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
