/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : localhost:3306
 Source Schema         : studentmanager

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 21/12/2021 11:53:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`, `username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', '123456', 1);

-- ----------------------------
-- Table structure for attendance
-- ----------------------------
DROP TABLE IF EXISTS `attendance`;
CREATE TABLE `attendance`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `course_id` int(0) NOT NULL,
  `student_id` int(0) NOT NULL,
  `type` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `date` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `attendance_course_foreign_key`(`course_id`) USING BTREE,
  INDEX `attendace_student_foreign_key`(`student_id`) USING BTREE,
  CONSTRAINT `attendace_student_foreign_key` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `attendance_course_foreign_key` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of attendance
-- ----------------------------
INSERT INTO `attendance` VALUES (13, 1, 2, '上午', '2018-09-04');
INSERT INTO `attendance` VALUES (14, 1, 4, '上午', '2018-09-04');
INSERT INTO `attendance` VALUES (15, 2, 2, '上午', '2019-07-02');

-- ----------------------------
-- Table structure for clazz
-- ----------------------------
DROP TABLE IF EXISTS `clazz`;
CREATE TABLE `clazz`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `info` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of clazz
-- ----------------------------
INSERT INTO `clazz` VALUES (1, '软件一班', '软件工程专业');
INSERT INTO `clazz` VALUES (4, '数学一班', '大学数学专业');
INSERT INTO `clazz` VALUES (5, '计算机科学与技术一班', '计算机专业');
INSERT INTO `clazz` VALUES (8, '叠甲1班', '叠甲专业');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `teacher_id` int(0) NOT NULL,
  `course_date` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `selected_num` int(0) NOT NULL DEFAULT 0,
  `max_num` int(0) NOT NULL DEFAULT 50,
  `info` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `course_teacher_foreign`(`teacher_id`) USING BTREE,
  CONSTRAINT `course_teacher_foreign` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, '大学英语', 9, '周三上午8点', 49, 50, '英语');
INSERT INTO `course` VALUES (2, '大学数学', 10, '周三上午10点', 4, 50, '数学');
INSERT INTO `course` VALUES (3, '计算机基础', 11, '周三上午', 3, 50, '计算机课程');
INSERT INTO `course` VALUES (6, '大法师专业', 11, '周九', 0, 50, '大法师专业');

-- ----------------------------
-- Table structure for leave_message
-- ----------------------------
DROP TABLE IF EXISTS `leave_message`;
CREATE TABLE `leave_message`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `student_id` int(0) NOT NULL,
  `info` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` tinyint(1) NOT NULL DEFAULT 0,
  `remark` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `leave_student_foreign_key`(`student_id`) USING BTREE,
  CONSTRAINT `leave_student_foreign_key` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of leave_message
-- ----------------------------
INSERT INTO `leave_message` VALUES (13, 2, '世界这么大，想去看看', 1, '同意，你很6,铁子');
INSERT INTO `leave_message` VALUES (14, 2, '去网吧打游戏', 1, '挺好');

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `student_id` int(0) NOT NULL,
  `course_id` int(0) NOT NULL,
  `score` double(5, 2) NOT NULL,
  `remark` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `selected_course_student_fk`(`student_id`) USING BTREE,
  INDEX `selected_course_course_fk`(`course_id`) USING BTREE,
  CONSTRAINT `score_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `score_ibfk_2` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 69 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES (67, 4, 2, 78.00, '中等');
INSERT INTO `score` VALUES (68, 9, 1, 50.00, '不及格');

-- ----------------------------
-- Table structure for selected_course
-- ----------------------------
DROP TABLE IF EXISTS `selected_course`;
CREATE TABLE `selected_course`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `student_id` int(0) NOT NULL,
  `course_id` int(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `selected_course_student_fk`(`student_id`) USING BTREE,
  INDEX `selected_course_course_fk`(`course_id`) USING BTREE,
  CONSTRAINT `selected_course_course_fk` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `selected_course_student_fk` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of selected_course
-- ----------------------------
INSERT INTO `selected_course` VALUES (18, 2, 1);
INSERT INTO `selected_course` VALUES (19, 2, 2);
INSERT INTO `selected_course` VALUES (20, 2, 3);
INSERT INTO `selected_course` VALUES (21, 4, 3);
INSERT INTO `selected_course` VALUES (22, 4, 1);
INSERT INTO `selected_course` VALUES (24, 9, 1);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `sn` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `clazz_id` int(0) NOT NULL,
  `sex` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '男',
  `mobile` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `qq` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `photo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`, `sn`) USING BTREE,
  INDEX `student_clazz_id_foreign`(`clazz_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1000 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (2, 'S51528202992845', '张成龙', '123456', 1, '男', '11111', '1111', NULL);
INSERT INTO `student` VALUES (4, 'S51528379586807', '张成龙', '111111', 5, '男', '13356565656', '123456', NULL);
INSERT INTO `student` VALUES (9, 'S41528633634989', '张成龙', '1', 5, '男', '13333332133', '131313132323', 'bb12326f-ef6c-4d3d-a2ae-f9eb30a15ad4.jpg');
INSERT INTO `student` VALUES (50, '2019310143150', 'test50', 'test50', 1, '男', '1224', '123123', NULL);
INSERT INTO `student` VALUES (52, '2019310143152', 'test52', 'test52', 1, '男', NULL, NULL, NULL);
INSERT INTO `student` VALUES (53, '2019310143153', 'test53', 'test53', 1, '男', NULL, NULL, NULL);
INSERT INTO `student` VALUES (54, '2019310143154', 'test54', 'test54', 4, '女', NULL, NULL, NULL);
INSERT INTO `student` VALUES (56, '2019310143156', 'test56', 'test56', 4, '女', NULL, NULL, NULL);
INSERT INTO `student` VALUES (58, '2019310143158', 'test58', 'test58', 4, '男', NULL, NULL, NULL);
INSERT INTO `student` VALUES (62, '2019310143162', 'test62', 'test62', 1, '女', NULL, NULL, NULL);
INSERT INTO `student` VALUES (63, '2019310143163', 'test63', 'test63', 1, '男', NULL, NULL, NULL);
INSERT INTO `student` VALUES (64, '2019310143164', 'test64', 'test64', 1, '男', NULL, NULL, NULL);
INSERT INTO `student` VALUES (67, '810975', 'nightwalk', '9992', 4, '女', '13528854103', '1017712271', 'adasd');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `sn` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `clazz_id` int(0) NOT NULL,
  `sex` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '男',
  `mobile` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `qq` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `photo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`, `sn`) USING BTREE,
  INDEX `student_clazz_id_foreign`(`clazz_id`) USING BTREE,
  CONSTRAINT `teacher_ibfk_1` FOREIGN KEY (`clazz_id`) REFERENCES `clazz` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2565 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (9, 'T11528608730648', '张三', '111', 1, '男', '13918655656', '1193284480', NULL);
INSERT INTO `teacher` VALUES (10, 'T11528609224588', '李四老师', '111', 4, '男', '13656565656', '123456', NULL);
INSERT INTO `teacher` VALUES (11, 'T51528617262403', '李老师', '123456', 5, '男', '18989898989', '1456655565', NULL);
INSERT INTO `teacher` VALUES (41, '96589', 'admin', '444a', 1, '男', '123123', '231213', '');

SET FOREIGN_KEY_CHECKS = 1;
