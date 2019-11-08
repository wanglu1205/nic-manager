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

 Date: 04/11/2019 09:20:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for rebate_record
-- ----------------------------
DROP TABLE IF EXISTS `rebate_record`;
CREATE TABLE `rebate_record`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gmt_create` datetime(0) NULL DEFAULT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  `customer_id` bigint(20) NULL DEFAULT NULL,
  `card_id` bigint(20) NULL DEFAULT NULL,
  `package_id` bigint(20) NULL DEFAULT NULL,
  `rebate_customer_id` bigint(20) NULL DEFAULT NULL,
  `money` decimal(10, 2) NULL DEFAULT NULL,
  `rebate_money` decimal(10, 2) NULL DEFAULT NULL,
  `order_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
