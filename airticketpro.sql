/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : airticketpro

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2018-11-28 09:09:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `flight`
-- ----------------------------
DROP TABLE IF EXISTS `flight`;
CREATE TABLE `flight` (
  `flight_id` int(11) NOT NULL AUTO_INCREMENT,
  `flight_name` varchar(6) DEFAULT NULL,
  `flight_start` varchar(20) DEFAULT NULL,
  `flight_end` varchar(20) DEFAULT NULL,
  `flight_time` datetime DEFAULT NULL,
  PRIMARY KEY (`flight_id`),
  KEY `flight_name` (`flight_name`)
) ENGINE=InnoDB AUTO_INCREMENT=162 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of flight
-- ----------------------------
INSERT INTO `flight` VALUES ('1', 'F1001', '南京', '北京', '2018-11-29 11:00:00');
INSERT INTO `flight` VALUES ('2', 'F1002', '南京', '西安', '2018-11-29 12:00:00');
INSERT INTO `flight` VALUES ('3', 'F1003', '南京', '上海', '2018-11-28 13:00:00');
INSERT INTO `flight` VALUES ('4', 'F1004', '上海', '北京', '2018-11-28 14:30:29');
INSERT INTO `flight` VALUES ('5', 'F1005', '北京', '青岛', '2018-11-30 14:31:52');
INSERT INTO `flight` VALUES ('6', 'F1006', '南京', '北京', '2018-11-30 20:26:29');
INSERT INTO `flight` VALUES ('7', 'F1007', '南京', '北京', '2018-11-30 15:20:30');
INSERT INTO `flight` VALUES ('8', 'F1008', '南京', '上海', '2018-11-29 12:45:30');
INSERT INTO `flight` VALUES ('9', 'F1009', '南京', '天津', '2018-11-29 11:05:25');
INSERT INTO `flight` VALUES ('10', 'F1010', '南京', '河北', '2018-11-29 12:30:30');
INSERT INTO `flight` VALUES ('11', 'F1011', '南京', '武汉', '2018-11-30 10:25:35');
INSERT INTO `flight` VALUES ('12', 'F1012', '南京', '成都', '2018-11-29 10:30:30');
INSERT INTO `flight` VALUES ('13', 'F1013', '南京', '四川', '2018-11-28 11:45:45');
INSERT INTO `flight` VALUES ('14', 'F1014', '南京', '厦门', '2018-11-28 11:25:30');
INSERT INTO `flight` VALUES ('15', 'F1015', '南京', '海南', '2018-11-28 13:30:35');
INSERT INTO `flight` VALUES ('16', 'F1016', '南京', '香港', '2018-11-29 14:05:50');
INSERT INTO `flight` VALUES ('17', 'F1017', '南京', '台湾', '2018-11-30 15:25:35');
INSERT INTO `flight` VALUES ('18', 'F1018', '南京', '东北', '2018-11-29 13:45:50');
INSERT INTO `flight` VALUES ('19', 'F1019', '南京', '山东', '2018-11-29 14:15:05');
INSERT INTO `flight` VALUES ('20', 'F1020', '南京', '深圳', '2018-11-29 15:45:45');
INSERT INTO `flight` VALUES ('21', 'F1021', '北京', '南京', '2018-11-30 11:05:10');
INSERT INTO `flight` VALUES ('22', 'F1022', '上海', '南京', '2018-11-30 13:15:10');
INSERT INTO `flight` VALUES ('23', 'F1023', '天津', '南京', '2018-11-29 14:25:35');
INSERT INTO `flight` VALUES ('24', 'F1024', '河北', '南京', '2018-12-06 15:50:50');
INSERT INTO `flight` VALUES ('25', 'F1025', '武汉', '南京', '2018-11-30 16:20:40');
INSERT INTO `flight` VALUES ('26', 'F1026', '成都', '南京', '2018-11-22 17:25:35');
INSERT INTO `flight` VALUES ('27', 'F1027', '四川', '南京', '2018-12-02 18:30:50');
INSERT INTO `flight` VALUES ('28', 'F1028', '厦门', '南京', '2018-12-03 18:30:35');
INSERT INTO `flight` VALUES ('29', 'F1029', '海南', '南京', '2018-12-03 20:20:30');
INSERT INTO `flight` VALUES ('30', 'F1030', '香港', '南京', '2018-12-02 16:25:30');
INSERT INTO `flight` VALUES ('31', 'F1031', '台湾', '南京', '2018-12-14 10:50:30');
INSERT INTO `flight` VALUES ('32', 'F1032', '东北', '南京', '2018-11-29 21:40:30');
INSERT INTO `flight` VALUES ('33', 'F1033', '深圳', '南京', '2018-11-30 14:15:05');
INSERT INTO `flight` VALUES ('34', 'F1034', '山东', '南京', '2018-11-30 06:20:30');
INSERT INTO `flight` VALUES ('35', 'F1035', '上海', '四川', '2019-01-29 10:30:30');
INSERT INTO `flight` VALUES ('36', 'F1036', '上海', '北京', '2018-11-29 17:20:30');
INSERT INTO `flight` VALUES ('37', 'F1037', '上海', '天津', '2018-12-13 15:45:30');
INSERT INTO `flight` VALUES ('38', 'F1038', '上海', '河北', '2018-12-08 11:25:30');
INSERT INTO `flight` VALUES ('39', 'F1039', '上海', '武汉', '2018-12-02 15:20:30');
INSERT INTO `flight` VALUES ('40', 'F1040', '上海', '成都', '2018-12-06 04:55:30');
INSERT INTO `flight` VALUES ('41', 'F1041', '上海', '香港', '2018-11-28 15:20:30');
INSERT INTO `flight` VALUES ('42', 'F1042', '上海', '厦门', '2018-11-28 05:30:30');
INSERT INTO `flight` VALUES ('43', 'F1043', '上海', '海南', '2018-11-28 15:20:30');
INSERT INTO `flight` VALUES ('44', 'F1044', '上海', '台湾', '2018-12-06 09:20:30');
INSERT INTO `flight` VALUES ('45', 'F1045', '上海', '东北', '2019-01-03 23:20:30');
INSERT INTO `flight` VALUES ('46', 'F1046', '上海', '深圳', '2018-11-29 08:20:30');
INSERT INTO `flight` VALUES ('47', 'F1047', '上海', '山东', '2018-11-30 11:25:30');
INSERT INTO `flight` VALUES ('48', 'F1048', '上海', '北京', '2018-11-28 21:20:30');
INSERT INTO `flight` VALUES ('49', 'F1049', '北京', '四川', '2018-11-28 14:15:05');
INSERT INTO `flight` VALUES ('50', 'F1050', '北京', '天津', '2018-11-28 22:20:30');
INSERT INTO `flight` VALUES ('51', 'F1051', '北京', '河北', '2018-11-28 10:30:30');
INSERT INTO `flight` VALUES ('52', 'F1052', '北京', '武汉', '2018-11-28 07:25:30');
INSERT INTO `flight` VALUES ('53', 'F1053', '北京', '成都', '2018-11-28 02:20:30');
INSERT INTO `flight` VALUES ('54', 'F1054', '北京', '香港', '2018-11-28 20:45:30');
INSERT INTO `flight` VALUES ('55', 'F1055', '北京', '厦门', '2018-11-29 03:20:30');
INSERT INTO `flight` VALUES ('56', 'F1056', '北京', '福建', '2018-11-30 04:20:30');
INSERT INTO `flight` VALUES ('57', 'F1057', '北京', '澳门', '2018-11-28 14:15:05');
INSERT INTO `flight` VALUES ('58', 'F1001', '南京', '北京', '2018-11-29 15:20:30');
INSERT INTO `flight` VALUES ('59', 'F1002', '南京', '杭州', '2018-11-28 16:30:30');
INSERT INTO `flight` VALUES ('60', 'F1003', '南京', '天津', '2018-11-28 17:00:00');
INSERT INTO `flight` VALUES ('61', 'F1004', '南京', '郑州', '2018-11-28 17:20:30');
INSERT INTO `flight` VALUES ('62', 'F1005', '南京', '北京', '2018-11-28 17:20:30');
INSERT INTO `flight` VALUES ('63', 'F1006', '南京', '深圳', '2018-11-28 17:30:30');
INSERT INTO `flight` VALUES ('64', 'F1007', '南京', '厦门', '2018-11-28 17:40:30');
INSERT INTO `flight` VALUES ('65', 'F1008', '南京', '三亚', '2018-11-28 18:00:30');
INSERT INTO `flight` VALUES ('66', 'F1009', '南京', '澳门', '2018-11-29 18:20:30');
INSERT INTO `flight` VALUES ('67', 'F1010', '南京', '台北', '2018-11-28 18:30:30');
INSERT INTO `flight` VALUES ('68', 'F1011', '南京', '武汉', '2018-11-28 18:40:30');
INSERT INTO `flight` VALUES ('69', 'F1012', '南京', '长沙', '2018-11-29 19:00:30');
INSERT INTO `flight` VALUES ('70', 'F1013', '南京', '澳门', '2018-11-28 19:30:30');
INSERT INTO `flight` VALUES ('71', 'F1014', '南京', '台北', '2018-11-29 19:30:30');
INSERT INTO `flight` VALUES ('72', 'F1015', '南京', '武汉', '2018-11-29 19:40:30');
INSERT INTO `flight` VALUES ('73', 'F1016', '南京', '郑州', '2018-11-28 19:40:30');
INSERT INTO `flight` VALUES ('74', 'F1017', '北京', '台北', '2018-11-29 19:40:30');
INSERT INTO `flight` VALUES ('75', 'F1018', '北京', '杭州', '2018-11-29 19:50:30');
INSERT INTO `flight` VALUES ('76', 'F1019', '北京', '厦门', '2018-11-28 19:50:30');
INSERT INTO `flight` VALUES ('77', 'F1020', '南京', '昆明', '2018-11-28 19:50:30');
INSERT INTO `flight` VALUES ('78', 'F1021', '南京', '上海浦东', '2018-11-29 19:50:30');
INSERT INTO `flight` VALUES ('79', 'F1022', '上海', '昆明', '2018-11-30 20:00:30');
INSERT INTO `flight` VALUES ('80', 'F1023', '上海', '厦门', '2018-11-29 20:10:30');
INSERT INTO `flight` VALUES ('81', 'F1024', '上海', '南京', '2018-11-28 20:10:30');
INSERT INTO `flight` VALUES ('82', 'F1025', '上海', '北京', '2018-11-30 20:30:30');
INSERT INTO `flight` VALUES ('83', 'F1026', '上海', '三亚', '2018-11-29 20:50:30');
INSERT INTO `flight` VALUES ('84', 'F1027', '上海', '郑州', '2018-11-30 21:00:30');
INSERT INTO `flight` VALUES ('85', 'F1028', '上海', '天津', '2018-11-28 21:20:30');
INSERT INTO `flight` VALUES ('86', 'F1029', '上海', '武汉', '2018-11-29 21:40:30');
INSERT INTO `flight` VALUES ('87', 'F1030', '上海', '深圳', '2018-11-30 22:30:30');
INSERT INTO `flight` VALUES ('88', 'F1031', '南京', '北京', '2018-11-29 15:20:30');
INSERT INTO `flight` VALUES ('89', 'F1032', '南京', '杭州', '2018-11-29 16:30:30');
INSERT INTO `flight` VALUES ('90', 'F1033', '南京', '天津', '2018-11-29 17:00:00');
INSERT INTO `flight` VALUES ('91', 'F1034', '南京', '郑州', '2018-11-28 17:20:30');
INSERT INTO `flight` VALUES ('92', 'F1035', '南京', '北京', '2018-12-04 17:20:30');
INSERT INTO `flight` VALUES ('93', 'F1036', '南京', '深圳', '2018-11-29 17:30:30');
INSERT INTO `flight` VALUES ('94', 'F1037', '南京', '厦门', '2018-11-30 17:40:30');
INSERT INTO `flight` VALUES ('95', 'F1038', '南京', '三亚', '2018-11-29 18:00:30');
INSERT INTO `flight` VALUES ('96', 'F1039', '南京', '澳门', '2018-11-28 18:20:30');
INSERT INTO `flight` VALUES ('97', 'F1040', '南京', '台北', '2018-11-29 18:30:30');
INSERT INTO `flight` VALUES ('98', 'F1041', '南京', '上海浦东', '2018-11-30 19:50:30');
INSERT INTO `flight` VALUES ('99', 'F1042', '上海', '昆明', '2018-11-28 20:00:30');
INSERT INTO `flight` VALUES ('100', 'F1043', '上海', '厦门', '2018-11-30 20:10:30');
INSERT INTO `flight` VALUES ('101', 'F1044', '上海', '南京', '2018-11-29 20:10:30');
INSERT INTO `flight` VALUES ('102', 'F1045', '上海', '北京', '2018-11-29 20:30:30');
INSERT INTO `flight` VALUES ('103', 'F1046', '上海', '三亚', '2018-11-30 20:50:30');
INSERT INTO `flight` VALUES ('104', 'F1047', '上海', '郑州', '2018-11-30 21:00:30');
INSERT INTO `flight` VALUES ('105', 'F1048', '上海', '天津', '2018-11-29 21:20:30');
INSERT INTO `flight` VALUES ('106', 'F1049', '上海', '武汉', '2018-11-29 21:40:30');
INSERT INTO `flight` VALUES ('107', 'F1050', '上海', '深圳', '2018-11-28 22:30:30');
INSERT INTO `flight` VALUES ('108', 'F1001', '南京', '北京', '2018-11-28 15:20:30');
INSERT INTO `flight` VALUES ('109', 'F1002', '南京', '杭州', '2018-11-29 16:30:30');
INSERT INTO `flight` VALUES ('110', 'F1003', '南京', '天津', '2018-11-28 17:00:00');
INSERT INTO `flight` VALUES ('111', 'F1004', '南京', '郑州', '2018-11-29 17:20:30');
INSERT INTO `flight` VALUES ('112', 'F1005', '南京', '北京', '2018-11-28 17:20:30');
INSERT INTO `flight` VALUES ('113', 'F1006', '南京', '深圳', '2018-11-29 17:30:30');
INSERT INTO `flight` VALUES ('114', 'F1007', '南京', '厦门', '2018-11-28 17:40:30');
INSERT INTO `flight` VALUES ('115', 'F1008', '南京', '三亚', '2018-11-29 18:00:30');
INSERT INTO `flight` VALUES ('116', 'F1009', '南京', '澳门', '2018-11-28 18:20:30');
INSERT INTO `flight` VALUES ('117', 'F1010', '南京', '台北', '2018-11-29 18:30:30');
INSERT INTO `flight` VALUES ('118', 'F1011', '南京', '武汉', '2018-11-28 18:40:30');
INSERT INTO `flight` VALUES ('119', 'F1012', '南京', '长沙', '2018-11-29 19:00:30');
INSERT INTO `flight` VALUES ('120', 'F1013', '南京', '澳门', '2018-11-28 19:30:30');
INSERT INTO `flight` VALUES ('121', 'F1014', '南京', '台北', '2018-11-29 19:30:30');
INSERT INTO `flight` VALUES ('122', 'F1015', '南京', '武汉', '2018-11-30 19:40:30');
INSERT INTO `flight` VALUES ('123', 'F1016', '南京', '郑州', '2018-11-30 19:40:30');
INSERT INTO `flight` VALUES ('124', 'F1017', '北京', '台北', '2018-12-01 19:40:30');
INSERT INTO `flight` VALUES ('125', 'F1018', '北京', '杭州', '2018-11-28 19:50:30');
INSERT INTO `flight` VALUES ('126', 'F1019', '北京', '厦门', '2018-11-29 19:50:30');
INSERT INTO `flight` VALUES ('127', 'F1020', '南京', '昆明', '2018-11-21 19:50:30');
INSERT INTO `flight` VALUES ('128', 'F1021', '南京', '上海浦东', '2018-11-30 19:50:30');
INSERT INTO `flight` VALUES ('129', 'F1022', '上海', '昆明', '2018-11-30 20:00:30');
INSERT INTO `flight` VALUES ('130', 'F1023', '上海', '厦门', '2018-12-01 20:10:30');
INSERT INTO `flight` VALUES ('131', 'F1024', '上海', '南京', '2018-12-28 20:10:30');
INSERT INTO `flight` VALUES ('132', 'F1025', '上海', '北京', '2018-11-29 20:30:30');
INSERT INTO `flight` VALUES ('133', 'F1026', '上海', '三亚', '2018-12-03 20:50:30');
INSERT INTO `flight` VALUES ('134', 'F1027', '上海', '郑州', '2018-12-04 21:00:30');
INSERT INTO `flight` VALUES ('135', 'F1028', '上海', '天津', '2018-12-03 21:20:30');
INSERT INTO `flight` VALUES ('136', 'F1029', '上海', '武汉', '2018-12-04 21:40:30');
INSERT INTO `flight` VALUES ('137', 'F1030', '上海', '深圳', '2018-11-28 22:30:30');
INSERT INTO `flight` VALUES ('138', 'F1031', '南京', '北京', '2018-11-29 15:20:30');
INSERT INTO `flight` VALUES ('139', 'F1032', '南京', '杭州', '2018-11-29 16:30:30');
INSERT INTO `flight` VALUES ('140', 'F1033', '南京', '天津', '2018-11-28 17:00:00');
INSERT INTO `flight` VALUES ('141', 'F1034', '南京', '郑州', '2018-11-29 17:20:30');
INSERT INTO `flight` VALUES ('142', 'F1035', '南京', '北京', '2018-11-28 17:20:30');
INSERT INTO `flight` VALUES ('143', 'F1036', '南京', '深圳', '2018-11-28 17:30:30');
INSERT INTO `flight` VALUES ('144', 'F1037', '南京', '厦门', '2018-11-29 17:40:30');
INSERT INTO `flight` VALUES ('145', 'F1038', '南京', '三亚', '2018-12-29 18:00:30');
INSERT INTO `flight` VALUES ('146', 'F1039', '南京', '澳门', '2018-11-30 18:20:30');
INSERT INTO `flight` VALUES ('147', 'F1040', '南京', '台北', '2018-11-30 18:30:30');
INSERT INTO `flight` VALUES ('148', 'F1041', '南京', '上海浦东', '2018-11-30 19:50:30');
INSERT INTO `flight` VALUES ('149', 'F1042', '上海', '昆明', '2018-11-30 20:00:30');
INSERT INTO `flight` VALUES ('150', 'F1043', '上海', '厦门', '2018-11-28 20:10:30');
INSERT INTO `flight` VALUES ('151', 'F1044', '上海', '南京', '2018-11-29 20:10:30');
INSERT INTO `flight` VALUES ('152', 'F1045', '上海', '北京', '2018-11-28 20:30:30');
INSERT INTO `flight` VALUES ('153', 'F1046', '上海', '三亚', '2018-12-02 20:50:30');
INSERT INTO `flight` VALUES ('154', 'F1047', '上海', '郑州', '2018-12-01 21:00:30');
INSERT INTO `flight` VALUES ('155', 'F1048', '上海', '天津', '2018-12-02 21:20:30');
INSERT INTO `flight` VALUES ('157', 'F1050', '上海', '深圳', '2018-12-03 22:30:30');
INSERT INTO `flight` VALUES ('158', 'F1222', '南京', '北京', '2018-11-28 00:00:00');
INSERT INTO `flight` VALUES ('159', 'F1444', '12312', '12312', '2018-11-28 00:00:00');
INSERT INTO `flight` VALUES ('160', 'da', 'da', 'da', '1111-11-11 11:11:11');
INSERT INTO `flight` VALUES ('161', '达到', '打', '打', '2018-12-12 12:12:12');

-- ----------------------------
-- Table structure for `ordermap`
-- ----------------------------
DROP TABLE IF EXISTS `ordermap`;
CREATE TABLE `ordermap` (
  `order_id` varchar(100) NOT NULL,
  `order_user` int(11) DEFAULT NULL,
  `order_state` int(11) DEFAULT NULL,
  `order_Ticknum` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  UNIQUE KEY `un_id` (`order_id`),
  KEY `fk_user` (`order_user`),
  CONSTRAINT `fk_user` FOREIGN KEY (`order_user`) REFERENCES `user` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ordermap
-- ----------------------------

-- ----------------------------
-- Table structure for `person`
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `person_id` int(11) NOT NULL AUTO_INCREMENT,
  `person_name` varchar(255) DEFAULT NULL,
  `person_num` varchar(255) NOT NULL DEFAULT '',
  `person_user` int(11) DEFAULT NULL,
  PRIMARY KEY (`person_id`,`person_num`),
  KEY `person_id` (`person_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of person
-- ----------------------------

-- ----------------------------
-- Table structure for `ticket`
-- ----------------------------
DROP TABLE IF EXISTS `ticket`;
CREATE TABLE `ticket` (
  `ticket_id` int(11) NOT NULL AUTO_INCREMENT,
  `ticket_flight` int(11) NOT NULL,
  `ticket_order` varchar(100) NOT NULL,
  `ticket_person` int(11) DEFAULT NULL,
  PRIMARY KEY (`ticket_id`),
  KEY `fk_order` (`ticket_order`) USING BTREE,
  KEY `fk_flight` (`ticket_flight`),
  KEY `fk_person` (`ticket_person`),
  CONSTRAINT `fk_flight` FOREIGN KEY (`ticket_flight`) REFERENCES `flight` (`flight_id`),
  CONSTRAINT `fk_order` FOREIGN KEY (`ticket_order`) REFERENCES `ordermap` (`order_id`) ON DELETE CASCADE,
  CONSTRAINT `fk_person` FOREIGN KEY (`ticket_person`) REFERENCES `person` (`person_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ticket
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) NOT NULL,
  `user_pwd` varchar(20) NOT NULL,
  `user_phone` varchar(11) DEFAULT NULL,
  `user_limit` int(1) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `unique_name` (`user_name`),
  UNIQUE KEY `unique_phone` (`user_phone`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('3', 'admin', '1234', null, '3');
INSERT INTO `user` VALUES ('4', 'nimt', '1234', '12321312312', '2');
