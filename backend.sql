/*
 Navicat Premium Data Transfer

 Source Server         :  本地
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : backend

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 16/09/2018 21:49:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for system_log
-- ----------------------------
DROP TABLE IF EXISTS `system_log`;
CREATE TABLE `system_log`  (
  `database_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `module` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `remark` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `param` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`database_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of system_log
-- ----------------------------
INSERT INTO `system_log` VALUES (1, NULL, '登录', '参数列表:{\"password\":\"123456\",\"vrcode\":\"xy6y\",\"id\":\"55be1024f32c49f3a56eea601ff1c60c\",\"username\":\"admin\"}', '2018-09-16 21:43:02', '0:0:0:0:0:0:0:1', '{\"password\":\"123456\",\"vrcode\":\"xy6y\",\"id\":\"55be1024f32c49f3a56eea601ff1c60c\",\"username\":\"admin\"}');
INSERT INTO `system_log` VALUES (2, NULL, '登录', '参数列表:{\"password\":\"123456\",\"vrcode\":\"ygnc\",\"id\":\"55be1024f32c49f3a56eea601ff1c60c\",\"username\":\"admin\"}', '2018-09-16 21:43:09', '0:0:0:0:0:0:0:1', '{\"password\":\"123456\",\"vrcode\":\"ygnc\",\"id\":\"55be1024f32c49f3a56eea601ff1c60c\",\"username\":\"admin\"}');
INSERT INTO `system_log` VALUES (3, NULL, '登录', '参数列表:{\"password\":\"123456\",\"vrcode\":\"5xna\",\"id\":\"7fcb97f0043f4613abdfb607ba3afa67\",\"username\":\"admin\"}', '2018-09-16 21:45:26', '0:0:0:0:0:0:0:1', '{\"password\":\"123456\",\"vrcode\":\"5xna\",\"id\":\"7fcb97f0043f4613abdfb607ba3afa67\",\"username\":\"admin\"}');

-- ----------------------------
-- Table structure for system_user
-- ----------------------------
DROP TABLE IF EXISTS `system_user`;
CREATE TABLE `system_user`  (
  `database_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `last_login_time` datetime(0) NULL DEFAULT NULL,
  `role_type` int(10) NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `wx` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `zfb` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `father_user_id` bigint(20) NULL DEFAULT NULL,
  `father_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`database_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of system_user
-- ----------------------------
INSERT INTO `system_user` VALUES (1, 'admin', 'b36c7e2677490a366bce068862c4432c', '2018-09-16 01:47:37', '2018-09-16 01:47:45', -1, NULL, NULL, NULL, 1, 'admin');

SET FOREIGN_KEY_CHECKS = 1;
