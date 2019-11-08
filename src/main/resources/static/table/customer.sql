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

 Date: 04/11/2019 09:20:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `tel` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `parent_id` bigint(20) NULL DEFAULT NULL,
  `gmt_create` datetime(0) NULL DEFAULT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  `alipay_account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `alipay_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `commission` decimal(10, 2) NULL DEFAULT NULL,
  `credit` int(10) NULL DEFAULT NULL,
  `token` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `app_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `card_ids` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `group_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `is_enabled` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES (1, 'admin', '$2a$10$XeBOKtlMXfvcMp9CBs0tyOBPSRMQzTGMiuQfApEn0FCGxPUVtDftW', '管理员', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0.00, 0, '86cc456982e64bd1992edd70d5159575', NULL, NULL, NULL, NULL);
INSERT INTO `customer` VALUES (2, 'fengyinchao', '$2a$10$jt.5f5my4CQTOBfszzH83uI8GVcoMX82WTfM8mZSHB6EdWKGw5u6G', 'A', '1', '1', 1, '2019-10-30 19:42:06', '2019-10-31 18:44:31', '1', '1', 0.00, 0, NULL, NULL, NULL, '12', 1);
INSERT INTO `customer` VALUES (3, '15926339107@163.com', '$2a$10$90mV9cmi6WTucPoYjRUFfu3UDnF0.iLLQEZGvHi1NfltzcuS1p.va', 'scm-frontend', NULL, NULL, 1, '2019-10-31 17:28:05', '2019-10-31 17:28:05', NULL, NULL, 0.00, 0, NULL, NULL, NULL, NULL, 1);
INSERT INTO `customer` VALUES (4, '123456', '$2a$10$Ja8hGa2Ce1WlOY0GUplSHu7r23mjYA/sfVZ3ycBcH/XmYuzYgeaQu', '12', NULL, NULL, 1, '2019-10-31 18:31:13', '2019-10-31 18:31:13', NULL, NULL, 0.00, 0, NULL, NULL, NULL, NULL, 1);
INSERT INTO `customer` VALUES (5, '1', '$2a$10$XeBOKtlMXfvcMp9CBs0tyOBPSRMQzTGMiuQfApEn0FCGxPUVtDftW', '测试', NULL, NULL, 1, '2019-11-01 11:20:57', '2019-11-01 11:24:24', NULL, NULL, 0.00, 0, 'a87e68187c6a48f8b31a181ab54c7a2e', NULL, '1', '23291002323092', NULL);
INSERT INTO `customer` VALUES (7, '2', '$2a$10$AP1kpVV/ehVyPn7SX12qmujMtkMCHUJkO80IQUkmNt9jWyJd3db7e', 'string', 'string', 'string', 5, '2019-11-01 11:29:36', '2019-11-01 11:29:36', 'string', 'string', 0.00, 0, '7e4b22406d304e4eadd78d2a37c3e49c', NULL, NULL, 'string', 1);

SET FOREIGN_KEY_CHECKS = 1;
