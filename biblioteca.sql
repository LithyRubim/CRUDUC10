/*
 Navicat Premium Data Transfer

 Source Server         : SERVER(MYSQL5)
 Source Server Type    : MySQL
 Source Server Version : 100138
 Source Host           : localhost:3307
 Source Schema         : biblioteca

 Target Server Type    : MySQL
 Target Server Version : 100138
 File Encoding         : 65001

 Date: 26/07/2019 17:29:54
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
  `dataLancamento` varchar(10) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of livros
-- ----------------------------
INSERT INTO `livros` VALUES (1, 'Teste de Livro', 'Ação', 'Alex', 'Maia', '05/08/2019');

SET FOREIGN_KEY_CHECKS = 1;
