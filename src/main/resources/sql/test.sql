USE student;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS `test_table`;
CREATE TABLE `test_table`  (
     `username` varchar(10) NOT NULL,
     `id` int(11) NOT NULL AUTO_INCREMENT,
     `password` varchar(16) NOT NULL,
     PRIMARY KEY (`id`) USING BTREE,
     UNIQUE INDEX `username-unique`(`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;
SET FOREIGN_KEY_CHECKS = 1;