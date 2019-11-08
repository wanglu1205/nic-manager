/*
 Navicat Premium Data Transfer

 Source Server         : 112.33.22.155
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : 112.33.22.155:3306
 Source Schema         : nic

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 04/11/2019 09:20:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for package
-- ----------------------------
DROP TABLE IF EXISTS `package`;
CREATE TABLE `package`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `standard` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `gmt_create` datetime(0) NULL DEFAULT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of package
-- ----------------------------
INSERT INTO `package` VALUES (1, 'AB', 1.00, '12M', '2019-10-30 19:38:18', '2019-10-30 19:38:28');
INSERT INTO `package` VALUES (2, '15元/2M/半年', 20.00, '12M', '2019-11-01 11:18:52', '2019-11-01 11:18:52');

SET FOREIGN_KEY_CHECKS = 1;
