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

 Date: 04/11/2019 09:20:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for order_record
-- ----------------------------
DROP TABLE IF EXISTS `order_record`;
CREATE TABLE `order_record`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gmt_create` datetime(0) NULL DEFAULT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  `customer_id` bigint(20) NULL DEFAULT NULL,
  `card_id` bigint(20) NULL DEFAULT NULL,
  `channel` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `handing_time` datetime(0) NULL DEFAULT NULL,
  `money` decimal(10, 2) NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `order_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `rebate` decimal(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
