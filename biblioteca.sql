/*
 Navicat Premium Data Transfer

 Source Server         : LOCALHOST(MySQL5)
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : localhost:3307
 Source Schema         : biblioteca

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 28/07/2019 23:02:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for livros
-- ----------------------------
DROP TABLE IF EXISTS `livros`;
CREATE TABLE `livros`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(60) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `genero` varchar(60) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `autor` varchar(60) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `editora` varchar(60) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `edicao` int(3) NULL DEFAULT NULL,
  `dataLancamento` varchar(10) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of livros
-- ----------------------------
INSERT INTO `livros` VALUES (3, 'Silmarilo', 'Aventura, Ação', 'J.R.R. Tolkien', 'Abril', 3, '05/01/1990');

SET FOREIGN_KEY_CHECKS = 1;
