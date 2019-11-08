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

 Date: 04/11/2019 09:20:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for rebate_rule
-- ----------------------------
DROP TABLE IF EXISTS `rebate_rule`;
CREATE TABLE `rebate_rule`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gmt_create` datetime(0) NULL DEFAULT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  `package_id` bigint(20) NULL DEFAULT NULL,
  `money` decimal(10, 2) NULL DEFAULT NULL,
  `customer_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rebate_rule
-- ----------------------------
INSERT INTO `rebate_rule` VALUES (1, '2019-10-31 17:19:40', '2019-10-31 17:19:40', 1, 1.00, 1);
INSERT INTO `rebate_rule` VALUES (2, '2019-11-01 11:45:08', '2019-11-01 11:45:08', 2, 2.00, 4);
INSERT INTO `rebate_rule` VALUES (3, '2019-11-01 11:45:08', '2019-11-01 11:45:08', 2, 2.00, 5);

SET FOREIGN_KEY_CHECKS = 1;
