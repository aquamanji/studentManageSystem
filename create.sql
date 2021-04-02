/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80023
Source Host           : localhost:3306
Source Database       : scoredb

Target Server Type    : MYSQL
Target Server Version : 80023
File Encoding         : 65001

Date: 2021-04-02 17:29:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `authority` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', '20066', '123456', '1');
INSERT INTO `account` VALUES ('2', '20068', '666666', '1');
INSERT INTO `account` VALUES ('3', '20088', '666666', '1');
INSERT INTO `account` VALUES ('4', 'gong-001', '666666', '2');
INSERT INTO `account` VALUES ('5', 'smw', '123456', '2');
INSERT INTO `account` VALUES ('6', 'ls', '123456', '2');
INSERT INTO `account` VALUES ('7', '1111', '123456', '1');
INSERT INTO `account` VALUES ('8', 'dxw', '123456', '2');

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `classNo` char(10) NOT NULL,
  `className` varchar(20) NOT NULL,
  `institute` varchar(20) NOT NULL,
  `grade` int NOT NULL,
  `classNum` int NOT NULL,
  PRIMARY KEY (`classNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES ('20011', '通信201', '通信学院', '1', '5');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `courseNo` char(10) NOT NULL,
  `courseName` varchar(20) NOT NULL,
  `credit` int NOT NULL,
  `courseHour` int NOT NULL,
  `ischoosing` int NOT NULL,
  `volume` int NOT NULL,
  `teachno` varchar(255) NOT NULL,
  `term` varchar(255) NOT NULL,
  PRIMARY KEY (`courseNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('ke-001', '高等数学', '4', '60', '0', '0', 'smw', '2020年春季学期');
INSERT INTO `course` VALUES ('ke-002', '线性代数', '4', '60', '0', '0', 'smw', '2020年春季学期');
INSERT INTO `course` VALUES ('ke-003', '通信原理', '4', '60', '0', '0', 'smw', '2020年春季学期');
INSERT INTO `course` VALUES ('ke-004', '电子技术基础', '4', '60', '0', '0', 'smw', '2020年春季学期');
INSERT INTO `course` VALUES ('ke-005', '电工学', '4', '60', '0', '0', 'smw', '2020年春季学期');
INSERT INTO `course` VALUES ('ke-006', '自动控制原理', '4', '60', '0', '0', 'smw', '2020年春季学期');
INSERT INTO `course` VALUES ('ke-007', '二次元研究', '10', '6', '0', '50', 'smw', '2021年夏季学期');

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `stuNo` char(10) NOT NULL,
  `courseNo` char(10) NOT NULL,
  `term` varchar(10) NOT NULL,
  `score` int DEFAULT NULL,
  PRIMARY KEY (`stuNo`,`courseNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('20066', 'ke-001', '2020年春季学期', '100');
INSERT INTO `score` VALUES ('20066', 'ke-002', '2020年春季学期', '100');
INSERT INTO `score` VALUES ('20066', 'ke-003', '2020年春季学期', '88');
INSERT INTO `score` VALUES ('20066', 'ke-004', '2020年春季学期', '88');
INSERT INTO `score` VALUES ('20066', 'ke-005', '2020年春季学期', '88');
INSERT INTO `score` VALUES ('20066', 'ke-006', '2020年春季学期', '88');
INSERT INTO `score` VALUES ('20068', 'ke-001', '2020年春季学期', '60');
INSERT INTO `score` VALUES ('20068', 'ke-002', '2020年春季学期', '68');
INSERT INTO `score` VALUES ('20068', 'ke-003', '2020年春季学期', '68');
INSERT INTO `score` VALUES ('20068', 'ke-004', '2020年春季学期', '68');
INSERT INTO `score` VALUES ('20068', 'ke-005', '2020年春季学期', '68');
INSERT INTO `score` VALUES ('20068', 'ke-006', '2020年春季学期', '68');
INSERT INTO `score` VALUES ('20088', 'ke-001', '2020年春季学期', '90');
INSERT INTO `score` VALUES ('20088', 'ke-002', '2020年春季学期', '98');
INSERT INTO `score` VALUES ('20088', 'ke-003', '2020年春季学期', '98');
INSERT INTO `score` VALUES ('20088', 'ke-004', '2020年春季学期', '98');
INSERT INTO `score` VALUES ('20088', 'ke-005', '2020年春季学期', '98');
INSERT INTO `score` VALUES ('20088', 'ke-006', '2020年春季学期', '98');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `stuNo` char(10) NOT NULL,
  `stuName` varchar(20) NOT NULL,
  `sex` int NOT NULL,
  `birthday` date NOT NULL,
  `nat` varchar(20) NOT NULL,
  `classNo` varchar(20) NOT NULL,
  PRIMARY KEY (`stuNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1111', 'asd', '1', '1999-09-14', '汉', '20011');
INSERT INTO `student` VALUES ('20066', '王兰花', '2', '2000-01-01', '汉族', '20011');
INSERT INTO `student` VALUES ('20067', '定西为', '1', '1999-09-14', '汉', '20011');
INSERT INTO `student` VALUES ('20068', '李子豪', '1', '2000-06-06', '汉族', '20011');
INSERT INTO `student` VALUES ('20088', '苏梅', '2', '2000-02-12', '汉族', '20011');

-- ----------------------------
-- Table structure for teach
-- ----------------------------
DROP TABLE IF EXISTS `teach`;
CREATE TABLE `teach` (
  `teano` varchar(255) NOT NULL,
  `teaname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`teano`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of teach
-- ----------------------------
INSERT INTO `teach` VALUES ('dxw', '定西为');
INSERT INTO `teach` VALUES ('smw', '邵明为');

-- ----------------------------
-- Table structure for term
-- ----------------------------
DROP TABLE IF EXISTS `term`;
CREATE TABLE `term` (
  `term` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of term
-- ----------------------------
INSERT INTO `term` VALUES ('2020年夏季学期');
INSERT INTO `term` VALUES ('2020年秋季学期');
INSERT INTO `term` VALUES ('2020年冬季学期');
INSERT INTO `term` VALUES ('2020年春季学期');
INSERT INTO `term` VALUES ('2021年春季学期');
INSERT INTO `term` VALUES ('2021年夏季学期');
