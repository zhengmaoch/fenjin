/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : fjtms

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 13/03/2019 17:53:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for activitylog
-- ----------------------------
DROP TABLE IF EXISTS `activitylog`;
CREATE TABLE `activitylog`  (
  `Id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID，用GUID唯一标识',
  `ActivityLogTypeId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '活动日志类型Id，引用ActivityLogType的Id',
  `UserId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户Id，引用User的Id',
  `Comment` varchar(4000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '日志内容',
  `CreatedTime` datetime(0) NOT NULL COMMENT '创建时间，记录数据产生的时间',
  `IpAddress` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '当前主机的IP地址',
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `IX_ActivityLogTypeId`(`ActivityLogTypeId`) USING BTREE,
  INDEX `IX_UserId`(`UserId`) USING BTREE,
  CONSTRAINT `FK_ActivityLog_ActivityLogType_ActivityLogTypeId` FOREIGN KEY (`ActivityLogTypeId`) REFERENCES `d_activitylogtype` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_ActivityLog_User_UserId` FOREIGN KEY (`UserId`) REFERENCES `s_user` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户活动日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for activitylogtype
-- ----------------------------
DROP TABLE IF EXISTS `activitylogtype`;
CREATE TABLE `activitylogtype`  (
  `Id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID，用GUID唯一标识',
  `SystemKeyword` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '系统关键字',
  `Name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '日志类型名称',
  `Enabled` tinyint(1) NOT NULL COMMENT '是否允许记录该类型的日志',
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '活动日志类型' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for area
-- ----------------------------
DROP TABLE IF EXISTS `area`;
CREATE TABLE `area`  (
  `Id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID，用GUID唯一标识',
  `Name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '区域名称',
  `Code` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标准编码，用于方便第三方进行数据导入',
  `ExtensionCode` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '扩展编码，用于方便第三方系统对接',
  `Number` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话区号',
  `ParentAreaId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上级Id',
  `Level` int(11) NULL DEFAULT NULL COMMENT '名称',
  `Longitude` double NULL DEFAULT NULL COMMENT '经度',
  `Latitude` double NULL DEFAULT NULL COMMENT '纬度',
  `Altitude` double NULL DEFAULT NULL COMMENT '平均海拔高度',
  `Published` tinyint(1) NOT NULL COMMENT '发布状态，用于控制数据的使用权限',
  `Deleted` tinyint(1) NOT NULL COMMENT '删除状态，用于逻辑删除和恢复数据',
  `DisplayOrder` int(11) NOT NULL COMMENT '显示排序，允许用户自定义显示顺序',
  `CreatedTime` datetime(0) NOT NULL COMMENT '创建时间，记录数据产生的时间',
  `UpdatedTime` datetime(0) NOT NULL COMMENT '更新时间，用于数据一致性同步',
  PRIMARY KEY (`Id`) USING BTREE,
  UNIQUE INDEX `IX_Code`(`Code`) USING BTREE,
  UNIQUE INDEX `IX_Name_ParentAreaId`(`Name`, `ParentAreaId`) USING BTREE,
  INDEX `IX_ParentAreaId`(`ParentAreaId`) USING BTREE,
  CONSTRAINT `FK_Area_Area_ParentAreaId` FOREIGN KEY (`ParentAreaId`) REFERENCES `d_area` (`Id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '区域（省、市、区、县）' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `Id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID，用GUID唯一标识',
  `Name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '分类名称',
  `Alias` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '别名，用户新增工具时作为备用名称选择',
  `Code` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标准编码，用于方便第三方进行数据导入',
  `Specifications` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规格型号：多个数据用“,”分割',
  `ExtensionCode` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '扩展编码，用于方便第三方系统对接',
  `Description` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `ParentCategoryId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上级Id',
  `ProjectCategoryId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目分类Id，引用ProjectCategory的Id',
  `PictureId` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片Id，引用Picture的Id',
  `Published` tinyint(1) NOT NULL COMMENT '发布状态，用于控制数据的使用权限',
  `Deleted` tinyint(1) NOT NULL COMMENT '删除状态，用于逻辑删除和恢复数据',
  `DisplayOrder` int(11) NOT NULL COMMENT '显示排序，允许用户自定义显示顺序',
  `CreatedTime` datetime(0) NOT NULL COMMENT '创建时间，记录数据产生的时间',
  `UpdatedTime` datetime(0) NOT NULL COMMENT '更新时间，用于数据一致性同步',
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `IX_ParentCategoryId`(`ParentCategoryId`) USING BTREE,
  INDEX `IX_ProjectCategoryId`(`ProjectCategoryId`) USING BTREE,
  CONSTRAINT `FK_Category_Category_ParentCategoryId` FOREIGN KEY (`ParentCategoryId`) REFERENCES `p_category` (`Id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Category_ProjectCategory_ProjectCategoryId` FOREIGN KEY (`ProjectCategoryId`) REFERENCES `t_projectcategory` (`Id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '工具分类' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for check
-- ----------------------------
DROP TABLE IF EXISTS `check`;
CREATE TABLE `check`  (
  `Id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID，用GUID唯一标识',
  `UserId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户Id，引用User的Id',
  `WarehouseId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '库房Id，引用Warehouse的Id',
  `Type` int(11) NOT NULL COMMENT '检查类型：0使用前检查，1定检，2零时检查',
  `Deleted` tinyint(1) NOT NULL COMMENT '删除状态，用于逻辑删除和恢复数据',
  `CreatedTime` datetime(0) NOT NULL COMMENT '创建时间，记录数据产生的时间',
  `UpdatedTime` datetime(0) NOT NULL COMMENT '更新时间，用于数据一致性同步',
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `IX_WarehouseId`(`WarehouseId`) USING BTREE,
  CONSTRAINT `FK_Checking_Warehouse_WarehouseId` FOREIGN KEY (`WarehouseId`) REFERENCES `p_warehouse` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '检查单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for checkitem
-- ----------------------------
DROP TABLE IF EXISTS `checkitem`;
CREATE TABLE `checkitem`  (
  `Id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID，用GUID唯一标识',
  `CategoryId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '工具分类Id，引用Category的Id',
  `Name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '检查项名称',
  `Description` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `Published` tinyint(1) NOT NULL COMMENT '发布状态，用于控制数据的使用权限',
  `Deleted` tinyint(1) NOT NULL COMMENT '删除状态，用于逻辑删除和恢复数据',
  `DisplayOrder` int(11) NOT NULL COMMENT '显示排序，允许用户自定义显示顺序',
  `CreatedTime` datetime(0) NOT NULL COMMENT '创建时间，记录数据产生的时间',
  `UpdatedTime` datetime(0) NOT NULL COMMENT '更新时间，用于数据一致性同步',
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `IX_CategoryIdId`(`CategoryId`) USING BTREE,
  CONSTRAINT `FK_CheckItem_CategoryId` FOREIGN KEY (`CategoryId`) REFERENCES `p_category` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '检查项' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for checkrecord
-- ----------------------------
DROP TABLE IF EXISTS `checkrecord`;
CREATE TABLE `checkrecord`  (
  `Id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID，用GUID唯一标识',
  `CheckId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '检查单Id，引用Check的Id',
  `ProductId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片Id，引用Product的Id',
  `RFID` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '工具RFID，引用Product的RFID',
  `Description` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `Status` tinyint(1) NOT NULL COMMENT '工具检查状态',
  `Deleted` tinyint(1) NOT NULL COMMENT '删除状态，用于逻辑删除和恢复数据',
  `CreatedTime` datetime(0) NOT NULL COMMENT '创建时间，记录数据产生的时间',
  `UpdatedTime` datetime(0) NOT NULL COMMENT '更新时间，用于数据一致性同步',
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `IX_CheckId`(`CheckId`) USING BTREE,
  INDEX `IX_ProductId`(`ProductId`) USING BTREE,
  CONSTRAINT `FK_CheckRecord_Check_CheckId` FOREIGN KEY (`CheckId`) REFERENCES `i_check` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_CheckRecord_Product_ProductId` FOREIGN KEY (`ProductId`) REFERENCES `p_product` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '检查记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `Id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID，用GUID唯一标识',
  `Name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门名称',
  `Code` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标准编码，用于方便第三方进行数据导入和数据统计，不同级别编码长度不同，上级编码作为下级编码的前缀',
  `ExtensionCode` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '扩展编码，用于方便第三方系统对接',
  `ParentDepartmentId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上级Id',
  `Level` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门级别：0根部门，1省级，2地市，3县市，4乡镇，5村',
  `AreaId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区域Id，引用Area的Id',
  `DepartmentType` int(11) NULL DEFAULT NULL COMMENT '部门类型：0电网库房部门，1试验中心部门，3第三方部门',
  `Manager` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门联系人名称',
  `PhoneNumber` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门联系电话号码',
  `Published` tinyint(1) NOT NULL COMMENT '发布状态，用于控制数据的使用权限',
  `Deleted` tinyint(1) NOT NULL COMMENT '删除状态，用于逻辑删除和恢复数据',
  `DisplayOrder` int(11) NOT NULL COMMENT '显示排序，允许用户自定义显示顺序',
  `CreatedTime` datetime(0) NOT NULL COMMENT '创建时间，记录数据产生的时间',
  `UpdatedTime` datetime(0) NOT NULL COMMENT '更新时间，用于数据一致性同步',
  PRIMARY KEY (`Id`) USING BTREE,
  UNIQUE INDEX `IX_AreaId_Code`(`Code`, `AreaId`) USING BTREE,
  INDEX `IX_ParentDepartmentId`(`ParentDepartmentId`) USING BTREE,
  INDEX `IX_AreaId`(`AreaId`) USING BTREE,
  CONSTRAINT `FK_Department_Area_AreaId` FOREIGN KEY (`AreaId`) REFERENCES `d_area` (`Id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Department_Department_ParentDepartmentId` FOREIGN KEY (`ParentDepartmentId`) REFERENCES `s_department` (`Id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '组织架构（部门）' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for departmentcategory
-- ----------------------------
DROP TABLE IF EXISTS `departmentcategory`;
CREATE TABLE `departmentcategory`  (
  `Id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID，用GUID唯一标识',
  `Name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `TestCenterId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '试验中心Id，引用TestCenter的Id',
  `Published` tinyint(1) NOT NULL COMMENT '发布状态，用于控制数据的使用权限',
  `Deleted` tinyint(1) NOT NULL COMMENT '删除状态，用于逻辑删除和恢复数据',
  `DisplayOrder` int(11) NOT NULL COMMENT '显示排序，允许用户自定义显示顺序',
  `CreatedTime` datetime(0) NOT NULL COMMENT '创建时间，记录数据产生的时间',
  `UpdatedTime` datetime(0) NOT NULL COMMENT '更新时间，用于数据一致性同步',
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `IX_TestCenterId`(`TestCenterId`) USING BTREE,
  CONSTRAINT `FK_DepartmentCategory_TestCenter_TestCenterId` FOREIGN KEY (`TestCenterId`) REFERENCES `t_testcenter` (`Id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门分类，试验中心对送检单进行分类统计' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for departmentusers
-- ----------------------------
DROP TABLE IF EXISTS `departmentusers`;
CREATE TABLE `departmentusers`  (
  `Id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID，用GUID唯一标识',
  `UserId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户Id，引用User的Id',
  `DepartmentId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门Id，引用Department的Id',
  `Deleted` tinyint(1) NOT NULL COMMENT '删除状态，用于逻辑删除和恢复数据',
  `CreatedTime` datetime(0) NOT NULL COMMENT '创建时间，记录数据产生的时间',
  `UpdatedTime` datetime(0) NOT NULL COMMENT '更新时间，用于数据一致性同步',
  PRIMARY KEY (`UserId`) USING BTREE,
  UNIQUE INDEX `IX_Department_Id_UserId`(`UserId`, `DepartmentId`) USING BTREE,
  INDEX `IX_DepartmentId`(`DepartmentId`) USING BTREE,
  INDEX `IX_UserId`(`UserId`) USING BTREE,
  CONSTRAINT `FK_Department_User_Mapping_DepartmentId` FOREIGN KEY (`DepartmentId`) REFERENCES `s_department` (`Id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Department_User_Mapping_UserId` FOREIGN KEY (`UserId`) REFERENCES `s_user` (`Id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门用户关系' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for download
-- ----------------------------
DROP TABLE IF EXISTS `download`;
CREATE TABLE `download`  (
  `Id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID，用GUID唯一标识',
  `DownloadGuid` char(36) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '文件下载唯一Id',
  `UseDownloadUrl` tinyint(1) NOT NULL COMMENT '使用下载Url地址',
  `DownloadUrl` varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件下载Url地址',
  `DownloadBinary` longblob NULL COMMENT '二进制流文件',
  `ContentType` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件内容类型',
  `Filename` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件名',
  `Extension` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件扩展名',
  `IsNew` tinyint(1) NOT NULL COMMENT '新文件',
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '文件（二进制）' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for equipment
-- ----------------------------
DROP TABLE IF EXISTS `equipment`;
CREATE TABLE `equipment`  (
  `Id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID，用GUID唯一标识',
  `Name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `Code` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '设备编号',
  `DepartmentId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门Id，引用Department的Id',
  `WarehouseId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '库房Id，引用Warehouse的Id',
  `TestCenterId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '试验中心Id，引用TestCenter的Id',
  `EquipmentTypeId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '设备类型Id，引用EquipmentType的Id',
  `Auto` tinyint(1) NULL DEFAULT NULL COMMENT '是否自动试验设备',
  `IsMeasuring` tinyint(1) NULL DEFAULT NULL COMMENT '是否测量设备，测量设备可以获取测量值，用户试验报告数据及库房环境数据获取',
  `ManufacturerId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '厂商Id，引用Manufacturer的Id',
  `Specification` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规格型号',
  `MeasuringRange` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '测量范围',
  `AccuracyValue` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '精度',
  `Uncertainty` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '不确定度',
  `CalibrationMechanism` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '检测机构',
  `ValidityDate` datetime(0) NULL DEFAULT NULL COMMENT '有效日期，超过有效日期需要重新检测',
  `Published` tinyint(1) NOT NULL COMMENT '发布状态，用于控制数据的使用权限',
  `Deleted` tinyint(1) NOT NULL COMMENT '删除状态，用于逻辑删除和恢复数据',
  `DisplayOrder` int(11) NOT NULL COMMENT '显示排序，允许用户自定义显示顺序',
  `CreatedTime` datetime(0) NOT NULL COMMENT '创建时间，记录数据产生的时间',
  `UpdatedTime` datetime(0) NOT NULL COMMENT '更新时间，用于数据一致性同步',
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `IX_WarehouseId`(`WarehouseId`) USING BTREE,
  INDEX `IX_TestCenterId`(`TestCenterId`) USING BTREE,
  INDEX `IX_EquipmentTypeId`(`EquipmentTypeId`) USING BTREE,
  INDEX `IX_ManufacturerId`(`ManufacturerId`) USING BTREE,
  INDEX `IX_DepartmentId`(`DepartmentId`) USING BTREE,
  CONSTRAINT `FK_Equipment_EquipmentType_EquipmentTypeId` FOREIGN KEY (`EquipmentTypeId`) REFERENCES `d_equipmenttype` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Equipment_Manufacturer_DepartmentId` FOREIGN KEY (`DepartmentId`) REFERENCES `s_department` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Equipment_Manufacturer_ManufacturerId` FOREIGN KEY (`ManufacturerId`) REFERENCES `p_manufacturer` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '设备（库房、试验中心）' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for equipmenttype
-- ----------------------------
DROP TABLE IF EXISTS `equipmenttype`;
CREATE TABLE `equipmenttype`  (
  `Id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID，用GUID唯一标识',
  `Name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '设备类型名称',
  `Description` varchar(4000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备描述',
  `PictureId` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备图片Id，引用Picture的Id',
  `Published` tinyint(1) NOT NULL COMMENT '发布状态，用于控制数据的使用权限',
  `Deleted` tinyint(1) NOT NULL COMMENT '删除状态，用于逻辑删除和恢复数据',
  `DisplayOrder` int(11) NOT NULL COMMENT '显示排序，允许用户自定义显示顺序',
  `CreatedTime` datetime(0) NOT NULL COMMENT '创建时间，记录数据产生的时间',
  `UpdatedTime` datetime(0) NOT NULL COMMENT '更新时间，用于数据一致性同步',
  PRIMARY KEY (`Id`) USING BTREE,
  UNIQUE INDEX `IX_Name`(`Name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '设备类型' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for inspection
-- ----------------------------
DROP TABLE IF EXISTS `inspection`;
CREATE TABLE `inspection`  (
  `Id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID，用GUID唯一标识',
  `TestCenterId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '试验中心Id，引用TestCenter的Id',
  `DepartmentId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '委托部门Id，引用Department的Id',
  `EntrustmentDepartment` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '委托部门名称，用于送检单显示送检单位',
  `ConsignerSignaturePictureId` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '委托人签名图片Id，引用Picture的Id',
  `ConsignerPhoneNumber` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '委托人电话号码，用来发送试验短信',
  `SendeeSignaturePictureId` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收样人签名图片Id，引用Picture的Id',
  `Status` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '送检单状态：1已收样；2已试验；3已发样；4已归档',
  `TotalPrice` double NULL DEFAULT NULL COMMENT '试验总费用',
  `Off` double NULL DEFAULT NULL COMMENT '试验费折扣',
  `ReportCode` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '送检单编码',
  `InspectionDownloadId` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '送检单PDF文件Id，引用Download的Id',
  `UserId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户Id，引用User的Id',
  `IsPost` tinyint(1) NOT NULL COMMENT '是否邮寄',
  `IsSendSms` tinyint(1) NOT NULL COMMENT '是否发短信',
  `ExpressName` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '快递名称',
  `TrackingNumber` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '快递单号',
  `Description` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `Deleted` tinyint(1) NOT NULL COMMENT '删除状态，用于逻辑删除和恢复数据',
  `TestedTime` datetime(0) NULL DEFAULT NULL COMMENT '试验完成时间',
  `SendTime` datetime(0) NULL DEFAULT NULL COMMENT '发（取）样时间',
  `CreatedTime` datetime(0) NOT NULL COMMENT '创建时间，记录数据产生的时间',
  `UpdatedTime` datetime(0) NOT NULL COMMENT '更新时间，用于数据一致性同步',
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `IX_TestCenterId`(`TestCenterId`) USING BTREE,
  INDEX `IX_DepartmentId`(`DepartmentId`) USING BTREE,
  INDEX `IX_UserId`(`UserId`) USING BTREE,
  CONSTRAINT `FK_Inspection_Department_DepartmentId` FOREIGN KEY (`DepartmentId`) REFERENCES `s_department` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Inspection_TestCenter_TestCenterId` FOREIGN KEY (`TestCenterId`) REFERENCES `t_testcenter` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Inspection_User_UserId` FOREIGN KEY (`UserId`) REFERENCES `s_user` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '送检单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for inspectionrecord
-- ----------------------------
DROP TABLE IF EXISTS `inspectionrecord`;
CREATE TABLE `inspectionrecord`  (
  `Id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID，用GUID唯一标识',
  `InspectionId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '送检单Id，引用Inspection的Id',
  `CategoryId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '工具分类Id，引用Category的Id',
  `VoltageLevelId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电压等级Id，引用VoltageLevel的Id',
  `Specification` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规格型号：用于区分试验费用',
  `Number` int(11) NOT NULL COMMENT '工具数量',
  `Unit` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单位',
  `Price` double NULL DEFAULT NULL COMMENT '试验费',
  `Check` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '外观检查',
  `Project` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '试验项目',
  `UserId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户Id，引用User的Id',
  `Description` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `Deleted` tinyint(1) NOT NULL COMMENT '删除状态，用于逻辑删除和恢复数据',
  `CreatedTime` datetime(0) NOT NULL COMMENT '创建时间，记录数据产生的时间',
  `UpdatedTime` datetime(0) NOT NULL COMMENT '更新时间，用于数据一致性同步',
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `IX_InspectionId`(`InspectionId`) USING BTREE,
  INDEX `IX_CategoryId`(`CategoryId`) USING BTREE,
  INDEX `IX_UserId`(`UserId`) USING BTREE,
  INDEX `FK_InspectionProducts_VoltageLevel_VoltageLevelId`(`VoltageLevelId`) USING BTREE,
  CONSTRAINT `FK_InspectionProducts_Category_CategoryId` FOREIGN KEY (`CategoryId`) REFERENCES `p_category` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_InspectionProducts_Inspection_InspectionId` FOREIGN KEY (`InspectionId`) REFERENCES `t_inspection` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_InspectionProducts_User_UserId` FOREIGN KEY (`UserId`) REFERENCES `s_user` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_InspectionProducts_VoltageLevel_VoltageLevelId` FOREIGN KEY (`VoltageLevelId`) REFERENCES `p_voltagelevel` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '送检记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log`  (
  `Id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID，用GUID唯一标识',
  `LogLevelId` int(11) NOT NULL COMMENT '日志级别',
  `ShortMessage` varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '日志描述',
  `FullMessage` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '日志详细内容',
  `IpAddress` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '记录日志的主机IP地址',
  `UserId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '当前登录用户Id，引用User的Id',
  `PageUrl` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '当前页面地址',
  `ReferrerUrl` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '引用页面地址',
  `CreatedTime` datetime(0) NOT NULL COMMENT '创建时间，记录数据产生的时间',
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `IX_UserId`(`UserId`) USING BTREE,
  CONSTRAINT `FK_Log_User_UserId` FOREIGN KEY (`UserId`) REFERENCES `s_user` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for manufacturer
-- ----------------------------
DROP TABLE IF EXISTS `manufacturer`;
CREATE TABLE `manufacturer`  (
  `Id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID，用GUID唯一标识',
  `Name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '厂商全名，通过网络验证真实存在的名称',
  `ShortName` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简称，按照使用习惯命名',
  `Area` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地区',
  `Address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '厂商地址',
  `Published` tinyint(1) NOT NULL COMMENT '发布状态，用于控制数据的使用权限',
  `Deleted` tinyint(1) NOT NULL COMMENT '删除状态，用于逻辑删除和恢复数据',
  `DisplayOrder` int(11) NOT NULL COMMENT '显示排序，允许用户自定义显示顺序',
  `CreatedTime` datetime(0) NOT NULL COMMENT '创建时间，记录数据产生的时间',
  `UpdatedTime` datetime(0) NOT NULL COMMENT '更新时间，用于数据一致性同步',
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '厂商' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for oauth_access_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_access_token`;
CREATE TABLE `oauth_access_token`  (
  `token_id` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `token` blob NULL,
  `authentication_id` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_name` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `client_id` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `authentication` blob NULL,
  `refresh_token` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`authentication_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '生成的token' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for oauth_approvals
-- ----------------------------
DROP TABLE IF EXISTS `oauth_approvals`;
CREATE TABLE `oauth_approvals`  (
  `userId` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `clientId` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `scope` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `expiresAt` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `lastModifiedAt` timestamp(0) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details`  (
  `client_id` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `resource_ids` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `client_secret` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `scope` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `authorized_grant_types` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `web_server_redirect_uri` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `authorities` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `access_token_validity` int(11) NULL DEFAULT NULL,
  `refresh_token_validity` int(11) NULL DEFAULT NULL,
  `additional_information` varchar(4096) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `autoapprove` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`client_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '客户端信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of oauth_client_details
-- ----------------------------
INSERT INTO `oauth_client_details` VALUES ('android', NULL, 'android', 'read', 'password,authorization_code,refresh_token', '', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `oauth_client_details` VALUES ('browser', NULL, 'browser', 'read', 'password,refresh_token', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `oauth_client_details` VALUES ('webapp', NULL, 'secret', 'implicit', 'implicit', '', NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for oauth_client_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_token`;
CREATE TABLE `oauth_client_token`  (
  `token_id` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `token` blob NULL,
  `authentication_id` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_name` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `client_id` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`authentication_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for oauth_code
-- ----------------------------
DROP TABLE IF EXISTS `oauth_code`;
CREATE TABLE `oauth_code`  (
  `code` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `authentication` blob NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '授权码' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for oauth_refresh_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_refresh_token`;
CREATE TABLE `oauth_refresh_token`  (
  `token_id` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `token` blob NULL,
  `authentication` blob NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '刷新token' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `Id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID，用GUID唯一标识',
  `Name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `SystemName` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '系统权限名称',
  `Category` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限分类，可用模块名',
  `Deleted` tinyint(1) NOT NULL COMMENT '删除状态，用于逻辑删除和恢复数据',
  `CreatedTime` datetime(0) NOT NULL COMMENT '创建时间，记录数据产生的时间',
  `UpdatedTime` datetime(0) NOT NULL COMMENT '更新时间，用于数据一致性同步',
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('10', 'Manage Users', 'ManageUsers', 'Users', 0, '2019-03-06 17:18:52', '2019-03-06 17:18:52');
INSERT INTO `permission` VALUES ('11', 'Manage Roles', 'ManageRoles', 'Users', 0, '2019-03-06 17:18:52', '2019-03-06 17:18:52');
INSERT INTO `permission` VALUES ('12', 'Manage Permissions', 'ManagePermissions', 'Users', 0, '2019-03-06 17:18:52', '2019-03-06 17:18:52');

-- ----------------------------
-- Table structure for picture
-- ----------------------------
DROP TABLE IF EXISTS `picture`;
CREATE TABLE `picture`  (
  `Id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID，用GUID唯一标识',
  `PictureBinary` longblob NULL COMMENT '图片二进制流文件',
  `MimeType` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片类型',
  `SeoFilename` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片SEO文件名',
  `AltAttribute` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '可选名称',
  `TitleAttribute` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片名称',
  `IsNew` tinyint(1) NOT NULL COMMENT '新图片',
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '图片（二进制）' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `Id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID，用GUID唯一标识',
  `Name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '工具名称即使用编号',
  `RFID` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'RFID唯一编码',
  `CategoryId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '分类Id，引用Category的Id',
  `WarehouseId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '库房Id，引用Warehouse的Id',
  `ManufacturerId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '厂商Id，引用Manufacture的Id',
  `Specification` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规格型号',
  `VoltageLevelId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电压等级Id，引用VoltageLevel的Id',
  `TestDate` datetime(0) NULL DEFAULT NULL COMMENT '试验日期',
  `NextTestDate` datetime(0) NULL DEFAULT NULL COMMENT '下次试验日期=试验日期+试验周期-1天',
  `Status` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工具状态：0新增，1待检，2合格，3不合格，4报废',
  `StockStatus` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '库存状态：0在库，1试验，2抢修，3检修',
  `IsMaster` tinyint(1) NULL DEFAULT NULL COMMENT '主物资：1主物资，0非主物资，配合GroupId使用',
  `GroupId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组合标识：用GUID',
  `ScrapReason` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报废原因',
  `ProductionDate` datetime(0) NULL DEFAULT NULL COMMENT '生产日期',
  `Deleted` tinyint(1) NOT NULL COMMENT '删除状态，用于逻辑删除和恢复数据',
  `CreatedTime` datetime(0) NOT NULL COMMENT '创建时间，记录数据产生的时间',
  `UpdatedTime` datetime(0) NOT NULL COMMENT '更新时间，用于数据一致性同步',
  PRIMARY KEY (`Id`) USING BTREE,
  UNIQUE INDEX `IX_RFID`(`RFID`) USING BTREE,
  INDEX `IX_CategoryId`(`CategoryId`) USING BTREE,
  INDEX `IX_WarehouseId`(`WarehouseId`) USING BTREE,
  INDEX `IX_ManufacturerId`(`ManufacturerId`) USING BTREE,
  INDEX `IX_VoltageLevelId`(`VoltageLevelId`) USING BTREE,
  CONSTRAINT `FK_Product_Category_CategoryId` FOREIGN KEY (`CategoryId`) REFERENCES `p_category` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Product_Manufacturer_ManufacturerId` FOREIGN KEY (`ManufacturerId`) REFERENCES `p_manufacturer` (`Id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Product_VoltageLevel_VoltageLevelId` FOREIGN KEY (`VoltageLevelId`) REFERENCES `p_voltagelevel` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Product_Warehouse_WarehouseId` FOREIGN KEY (`WarehouseId`) REFERENCES `p_warehouse` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '工具（试品）' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project`  (
  `Id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID，用GUID唯一标识',
  `Name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `StandardId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '试验标准Id，引用Standard的Id',
  `ProjectTypeId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目类型Id，引用ProjectType的Id',
  `ProjectCategoryId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '试验项目分类Id，引用ProjectCategory的Id',
  `VoltageLevelId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电压等级Id，引用VoltageLevel的Id',
  `WithstandVoltage` double NOT NULL COMMENT '耐压(kV)',
  `Length` int(11) NOT NULL COMMENT '试验长度(cm)',
  `Duration` int(11) NOT NULL COMMENT '持续时间(s)',
  `PressurizationTimes` int(11) NOT NULL COMMENT '加压次数(次)',
  `MaxLeakageCurrent` double NOT NULL COMMENT '最大泄露电流(mA)，默认20，不等于0',
  `SectionalArea` double NOT NULL COMMENT '截面积(mm²)',
  `Resistance` double NOT NULL COMMENT '电阻(Ω)',
  `Shielding` double NOT NULL COMMENT '屏蔽效率(dB)',
  `RatedLoad` int(11) NOT NULL COMMENT '额定荷载(N)',
  `TestLoad` int(11) NOT NULL COMMENT '试验荷载(N)',
  `RatedPressure` int(11) NOT NULL COMMENT '额定压力(kPa)',
  `Speed` int(11) NOT NULL COMMENT '流量(L/min)',
  `Position` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部位(子分类)',
  `Cycle` int(11) NOT NULL COMMENT '试验周期(月)',
  `Depth` int(11) NOT NULL COMMENT '注水深度（cm）',
  `Requirement` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '试验要求',
  `Description` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '试验说明',
  `Published` tinyint(1) NOT NULL COMMENT '发布状态，用于控制数据的使用权限',
  `Deleted` tinyint(1) NOT NULL COMMENT '删除状态，用于逻辑删除和恢复数据',
  `DisplayOrder` int(11) NOT NULL COMMENT '显示排序，允许用户自定义显示顺序',
  `CreatedTime` datetime(0) NOT NULL COMMENT '创建时间，记录数据产生的时间',
  `UpdatedTime` datetime(0) NOT NULL COMMENT '更新时间，用于数据一致性同步',
  PRIMARY KEY (`Id`) USING BTREE,
  UNIQUE INDEX `IX_Name_StandardId`(`Name`, `StandardId`) USING BTREE,
  INDEX `IX_StandardId`(`StandardId`) USING BTREE,
  INDEX `IX_ProjectTypeId`(`ProjectTypeId`) USING BTREE,
  INDEX `IX_ProjectCategoryId`(`ProjectCategoryId`) USING BTREE,
  INDEX `IX_VoltageLevelId`(`VoltageLevelId`) USING BTREE,
  CONSTRAINT `FK_Project_ProjectCategory_ProjectCategoryId` FOREIGN KEY (`ProjectCategoryId`) REFERENCES `t_projectcategory` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Project_ProjectType_ProjectTypeId` FOREIGN KEY (`ProjectTypeId`) REFERENCES `t_projecttype` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Project_Standard_StandardId` FOREIGN KEY (`StandardId`) REFERENCES `t_standard` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Project_VoltageLevel_VoltageLevelId` FOREIGN KEY (`VoltageLevelId`) REFERENCES `p_voltagelevel` (`Id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '试验项目参数，按照试验规程内置' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for projectcategory
-- ----------------------------
DROP TABLE IF EXISTS `projectcategory`;
CREATE TABLE `projectcategory`  (
  `Id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID，用GUID唯一标识',
  `Name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `Unit` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单位',
  `ParentProjectCategoryId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上级Id',
  `PictureId` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片Id，引用Picture的Id',
  `Description` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `Published` tinyint(1) NOT NULL COMMENT '发布状态，用于控制数据的使用权限',
  `Deleted` tinyint(1) NOT NULL COMMENT '删除状态，用于逻辑删除和恢复数据',
  `DisplayOrder` int(11) NOT NULL COMMENT '显示排序，允许用户自定义显示顺序',
  `CreatedTime` datetime(0) NOT NULL COMMENT '创建时间，记录数据产生的时间',
  `UpdatedTime` datetime(0) NOT NULL COMMENT '更新时间，用于数据一致性同步',
  PRIMARY KEY (`Id`) USING BTREE,
  UNIQUE INDEX `IX_Name_ParentId`(`Name`, `ParentProjectCategoryId`) USING BTREE,
  INDEX `IX_ParentProjectCategoryId`(`ParentProjectCategoryId`) USING BTREE,
  CONSTRAINT `FK_ProjectCategory_ProjectCategory_ParentProjectCategoryId` FOREIGN KEY (`ParentProjectCategoryId`) REFERENCES `t_projectcategory` (`Id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '试验项目分类' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for projecttype
-- ----------------------------
DROP TABLE IF EXISTS `projecttype`;
CREATE TABLE `projecttype`  (
  `Id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID，用GUID唯一标识',
  `Name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `Description` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `Published` tinyint(1) NOT NULL COMMENT '发布状态，用于控制数据的使用权限',
  `Deleted` tinyint(1) NOT NULL COMMENT '删除状态，用于逻辑删除和恢复数据',
  `DisplayOrder` int(11) NOT NULL COMMENT '显示排序，允许用户自定义显示顺序',
  `CreatedTime` datetime(0) NOT NULL COMMENT '创建时间，记录数据产生的时间',
  `UpdatedTime` datetime(0) NOT NULL COMMENT '更新时间，用于数据一致性同步',
  PRIMARY KEY (`Id`) USING BTREE,
  UNIQUE INDEX `IX_Name`(`Name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '试验项目' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `Id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID，用GUID唯一标识',
  `Name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `Active` tinyint(1) NOT NULL COMMENT '激活状态，只有激活的角色才可以使用',
  `IsSystemRole` tinyint(1) NOT NULL COMMENT '系统角色，系统角色是不可以删除的',
  `SystemName` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '系统中角色关键字名称',
  `Deleted` tinyint(1) NOT NULL COMMENT '删除状态，用于逻辑删除和恢复数据',
  `CreatedTime` datetime(0) NOT NULL COMMENT '创建时间，记录数据产生的时间',
  `UpdatedTime` datetime(0) NOT NULL COMMENT '更新时间，用于数据一致性同步',
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '系统管理员', 1, 1, 'Administrators', 0, '2019-03-06 14:12:00', '2019-03-06 14:12:00');
INSERT INTO `role` VALUES ('2', '注册用户', 1, 1, 'Registered', 0, '2019-03-06 14:12:00', '2019-03-06 14:12:00');
INSERT INTO `role` VALUES ('3', '试品管理员', 1, 0, 'ProductManager', 0, '2019-03-06 14:12:00', '2019-03-06 14:12:00');
INSERT INTO `role` VALUES ('4', '试验员', 1, 0, 'Experimenter', 0, '2019-03-06 14:12:00', '2019-03-06 14:12:00');
INSERT INTO `role` VALUES ('5', '试验中心管理员', 1, 0, 'CenterManager', 0, '2019-03-06 14:12:00', '2019-03-06 14:12:00');
INSERT INTO `role` VALUES ('6', '检修员', 1, 0, 'Maintainer', 0, '2019-03-06 14:12:00', '2019-03-06 14:12:00');
INSERT INTO `role` VALUES ('7', '库房管理员', 1, 0, 'WarehouseManager', 0, '2019-03-06 14:12:00', '2019-03-06 14:12:00');
INSERT INTO `role` VALUES ('8', '地市级领导', 1, 0, 'DistrictLeader', 0, '2019-03-06 14:12:00', '2019-03-06 14:12:00');
INSERT INTO `role` VALUES ('9', '省级领导', 1, 0, 'ProvinceLeader', 0, '2019-03-06 14:12:00', '2019-03-06 14:12:00');

-- ----------------------------
-- Table structure for rolepermissions
-- ----------------------------
DROP TABLE IF EXISTS `rolepermissions`;
CREATE TABLE `rolepermissions`  (
  `PermissionId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限Id，引用Permission的Id',
  `RoleId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色Id，引用Role的Id',
  PRIMARY KEY (`PermissionId`, `RoleId`) USING BTREE,
  INDEX `IX_PermissionId`(`PermissionId`) USING BTREE,
  INDEX `IX_RoleId`(`RoleId`) USING BTREE,
  CONSTRAINT `FK2jg5wrpj5n18lh1aksj93yb9e` FOREIGN KEY (`PermissionId`) REFERENCES `permission` (`Id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Permission_Role_Mapping_Permission_Permission_Id` FOREIGN KEY (`PermissionId`) REFERENCES `permission` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Permission_Role_Mapping_Role_Role_Id` FOREIGN KEY (`RoleId`) REFERENCES `role` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKia8sr7knsweh9mw2lfa7bm5qu` FOREIGN KEY (`RoleId`) REFERENCES `role` (`Id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKr13e85jrfttn6upm1517cuig3` FOREIGN KEY (`RoleId`) REFERENCES `role` (`Id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKtkpa50d3c6tbnbiicog371smx` FOREIGN KEY (`PermissionId`) REFERENCES `permission` (`Id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限角色关系' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rolepermissions
-- ----------------------------
INSERT INTO `rolepermissions` VALUES ('10', '1');
INSERT INTO `rolepermissions` VALUES ('11', '1');
INSERT INTO `rolepermissions` VALUES ('12', '1');

-- ----------------------------
-- Table structure for scheduletask
-- ----------------------------
DROP TABLE IF EXISTS `scheduletask`;
CREATE TABLE `scheduletask`  (
  `Id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID，用GUID唯一标识',
  `Name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `Seconds` int(11) NOT NULL COMMENT '间隔时间，单位秒（s）',
  `Type` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '任务类型',
  `Enabled` tinyint(1) NOT NULL COMMENT '启用',
  `StopOnError` tinyint(1) NOT NULL COMMENT '错误停止状态',
  `LeasedByMachineName` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '任务租用机器名',
  `LeasedUntilUtc` datetime(0) NULL DEFAULT NULL COMMENT '任务租用时间',
  `LastStartUtc` datetime(0) NULL DEFAULT NULL COMMENT '最近一次开始时间',
  `LastEndUtc` datetime(0) NULL DEFAULT NULL COMMENT '最近一次结束时间',
  `LastSuccessUtc` datetime(0) NULL DEFAULT NULL COMMENT '最近一次成功执行时间',
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '自动任务' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for setting
-- ----------------------------
DROP TABLE IF EXISTS `setting`;
CREATE TABLE `setting`  (
  `Id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID，用GUID唯一标识',
  `Name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '配置名称',
  `Value` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '配置键值',
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '选项设置' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for smsmessage
-- ----------------------------
DROP TABLE IF EXISTS `smsmessage`;
CREATE TABLE `smsmessage`  (
  `Id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID，用GUID唯一标识',
  `From` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发送者',
  `To` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '接收人',
  `Sign` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '配置键值',
  `TemplateCode` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '模板编号',
  `TemplateParameter` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '模板参数',
  `Content` varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '模板内容',
  `CreatedTime` datetime(0) NOT NULL COMMENT '创建时间，记录数据产生的时间',
  `SendTime` datetime(0) NULL DEFAULT NULL COMMENT '发送时间',
  `Successful` tinyint(1) NOT NULL COMMENT '发送成功',
  `Result` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发送结果',
  `Priority` int(11) NOT NULL COMMENT '发送优先级',
  `Description` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '短信消息模板' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for standard
-- ----------------------------
DROP TABLE IF EXISTS `standard`;
CREATE TABLE `standard`  (
  `Id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID，用GUID唯一标识',
  `Code` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '编号',
  `Name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `StandardTypeId` int(11) NOT NULL COMMENT '标准类型Id，引用StandardType的Id',
  `PublishDate` datetime(0) NOT NULL COMMENT '发布日期',
  `Publisher` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发布机构',
  `EffectiveDate` datetime(0) NOT NULL COMMENT '生效日期',
  `Published` tinyint(1) NOT NULL COMMENT '发布状态，用于控制数据的使用权限',
  `Deleted` tinyint(1) NOT NULL COMMENT '删除状态，用于逻辑删除和恢复数据',
  `DisplayOrder` int(11) NOT NULL COMMENT '显示排序，允许用户自定义显示顺序',
  `CreatedTime` datetime(0) NOT NULL COMMENT '创建时间，记录数据产生的时间',
  `UpdatedTime` datetime(0) NOT NULL COMMENT '更新时间，用于数据一致性同步',
  PRIMARY KEY (`Id`) USING BTREE,
  UNIQUE INDEX `IX_Name`(`Name`) USING BTREE,
  UNIQUE INDEX `IX_Code`(`Code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '试验标准' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for stockinouttype
-- ----------------------------
DROP TABLE IF EXISTS `stockinouttype`;
CREATE TABLE `stockinouttype`  (
  `Id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID，用GUID唯一标识',
  `Name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '出入库类型名称',
  `Published` tinyint(1) NOT NULL COMMENT '发布状态，用于控制数据的使用权限',
  `Deleted` tinyint(1) NOT NULL COMMENT '删除状态，用于逻辑删除和恢复数据',
  `DisplayOrder` int(11) NOT NULL COMMENT '显示排序，允许用户自定义显示顺序',
  `CreatedTime` datetime(0) NOT NULL COMMENT '创建时间，记录数据产生的时间',
  `UpdatedTime` datetime(0) NOT NULL COMMENT '更新时间，用于数据一致性同步',
  PRIMARY KEY (`Id`) USING BTREE,
  UNIQUE INDEX `IX_Name`(`Name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '出入库业务类型' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for stockoutin
-- ----------------------------
DROP TABLE IF EXISTS `stockoutin`;
CREATE TABLE `stockoutin`  (
  `Id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID，用GUID唯一标识',
  `UserId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户Id，引用User的Id',
  `WarehouseId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '库房Id，引用Warehouse的Id',
  `WorkNumber` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '工单编号',
  `Process` tinyint(1) NOT NULL COMMENT '业务处理：1采购、2检修、3抢修、4借用、5报废',
  `IsStockOut` tinyint(1) NOT NULL COMMENT '出入库状态：0出库，1入库',
  `Description` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `Deleted` tinyint(1) NOT NULL COMMENT '删除状态，用于逻辑删除和恢复数据',
  `CreatedTime` datetime(0) NOT NULL COMMENT '创建时间，记录数据产生的时间',
  `UpdatedTime` datetime(0) NOT NULL COMMENT '更新时间，用于数据一致性同步',
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `IX_WarehouseId`(`WarehouseId`) USING BTREE,
  CONSTRAINT `FK_StockOutIn_Warehouse_WarehouseId` FOREIGN KEY (`WarehouseId`) REFERENCES `p_warehouse` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '出入库单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for stockoutinrecord
-- ----------------------------
DROP TABLE IF EXISTS `stockoutinrecord`;
CREATE TABLE `stockoutinrecord`  (
  `Id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID，用GUID唯一标识',
  `StockOutInId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '出入库单编号',
  `ProductId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片Id，引用Product的Id',
  `RFID` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '工具RFID，引用Product的RFID',
  `IsStockOut` tinyint(1) NOT NULL COMMENT '出入库状态：0出库，1入库',
  `Deleted` tinyint(1) NOT NULL COMMENT '删除状态，用于逻辑删除和恢复数据',
  `CreatedTime` datetime(0) NOT NULL COMMENT '创建时间，记录数据产生的时间',
  `UpdatedTime` datetime(0) NOT NULL COMMENT '更新时间，用于数据一致性同步',
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `IX_StockOutInId`(`StockOutInId`) USING BTREE,
  INDEX `IX_ProductId`(`ProductId`) USING BTREE,
  CONSTRAINT `FK_StockOutInRecord_Product_ProductId` FOREIGN KEY (`ProductId`) REFERENCES `p_product` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_StockOutInRecord_StockOutIn_StockOutInId` FOREIGN KEY (`StockOutInId`) REFERENCES `i_stockoutin` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '出入库记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test`  (
  `Id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID，用GUID唯一标识',
  `TestCenterId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '试验中心Id，引用TestCenter的Id',
  `DepartmentId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '送检部门Id，引用Department的Id',
  `EntrustDepartment` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '送检部门名称，用于试验报告显示送检单位',
  `EntrustUser` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '送检人名称',
  `TestStatus` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '试验状态：0未完成;1试验中;2试验完成;3已完成',
  `PercentageOfComplete` int(11) NOT NULL COMMENT '完成百分比=已试验完成工具数量/总数量',
  `ProductCount` int(11) NULL DEFAULT NULL COMMENT '工具数量：冗余字段用于优化查询效率',
  `TestTime` datetime(0) NULL DEFAULT NULL COMMENT '试验日期：用于生成试验报告中的试验日期数据',
  `Tester1` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '试验员1',
  `Tester2` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '试验员2',
  `Temperature` double NULL DEFAULT NULL COMMENT '温度',
  `Humidity` double NULL DEFAULT NULL COMMENT '湿度',
  `Pressure` double NULL DEFAULT NULL COMMENT '气压',
  `ReportCode` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报告编号',
  `ReportDownloadId` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报告下载Id，引用Download的Id',
  `Score` int(11) NULL DEFAULT NULL COMMENT '评价得分，非常满意10，满意8，一般6，不满意3，非常不满意0',
  `Suggestion` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '改进建议',
  `Description` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `Deleted` tinyint(1) NOT NULL COMMENT '删除状态，用于逻辑删除和恢复数据',
  `CreatedTime` datetime(0) NOT NULL COMMENT '创建时间，记录数据产生的时间',
  `UpdatedTime` datetime(0) NOT NULL COMMENT '更新时间，用于数据一致性同步',
  `FirstAuditor` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '说明',
  `FirstApproval` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '说明',
  `FirstAuditTime` datetime(0) NOT NULL COMMENT '说明',
  `CheckPerson` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '说明',
  `SecondAuditor` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '说明',
  `SecondApproval` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '说明',
  `SecondAuditTime` datetime(0) NOT NULL COMMENT '说明',
  `AuditStatus` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '说明',
  `RejectReason` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '说明',
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `IX_TestCenterId`(`TestCenterId`) USING BTREE,
  INDEX `IX_DepartmentId`(`DepartmentId`) USING BTREE,
  CONSTRAINT `FK_Test_Department_DepartmentId` FOREIGN KEY (`DepartmentId`) REFERENCES `s_department` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Test_TestCenter_TestCenterId` FOREIGN KEY (`TestCenterId`) REFERENCES `t_testcenter` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '试验单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for testcenter
-- ----------------------------
DROP TABLE IF EXISTS `testcenter`;
CREATE TABLE `testcenter`  (
  `Id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID，用GUID唯一标识',
  `Name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `DepartmentId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门Id，引用Department的Id',
  `AreaId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区域Id，引用Area的Id',
  `CompanyName` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公司名称',
  `CompanyEnglishName` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司英文名称',
  `Address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司地址',
  `ZipCode` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮编',
  `Email` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `Tel` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司电话',
  `Fax` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '传真',
  `CertificatePictureId` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '证书图片Id，引用Picture的Id',
  `CertificateNumber` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '证书编号',
  `LogoPictureId` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司Logo图片Id',
  `Url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司网址',
  `Code` int(11) NOT NULL COMMENT '试验中心编号，(生成RFID保留位)同一地市内保持唯一',
  `Published` tinyint(1) NOT NULL COMMENT '发布状态，用于控制数据的使用权限',
  `Deleted` tinyint(1) NOT NULL COMMENT '删除状态，用于逻辑删除和恢复数据',
  `DisplayOrder` int(11) NOT NULL COMMENT '显示排序，允许用户自定义显示顺序',
  `CreatedTime` datetime(0) NOT NULL COMMENT '创建时间，记录数据产生的时间',
  `UpdatedTime` datetime(0) NOT NULL COMMENT '更新时间，用于数据一致性同步',
  PRIMARY KEY (`Id`) USING BTREE,
  UNIQUE INDEX `IX_Code_DepartmentId`(`Code`, `DepartmentId`) USING BTREE,
  INDEX `IX_DepartmentId`(`DepartmentId`) USING BTREE,
  INDEX `IX_AreaId`(`AreaId`) USING BTREE,
  CONSTRAINT `FK_TestCenter_Area_AreaId` FOREIGN KEY (`AreaId`) REFERENCES `d_area` (`Id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_TestCenter_Department_DepartmentId` FOREIGN KEY (`DepartmentId`) REFERENCES `s_department` (`Id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '试验中心' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for testcenterdepartments
-- ----------------------------
DROP TABLE IF EXISTS `testcenterdepartments`;
CREATE TABLE `testcenterdepartments`  (
  `Id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID，用GUID唯一标识',
  `TestCenterId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '试验中心Id，引用TestCenter的Id',
  `DepartmentId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门Id，引用Department的Id',
  `DepartmentCategoryId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门性质Id，引用DepartmentCategory的Id，用于试验中心进行统计',
  `Deleted` tinyint(1) NOT NULL COMMENT '删除状态，用于逻辑删除和恢复数据',
  `CreatedTime` datetime(0) NOT NULL COMMENT '创建时间，记录数据产生的时间',
  `UpdatedTime` datetime(0) NOT NULL COMMENT '更新时间，用于数据一致性同步',
  PRIMARY KEY (`Id`) USING BTREE,
  UNIQUE INDEX `IX_TestCenterId_DepartmentId`(`TestCenterId`, `DepartmentId`) USING BTREE,
  INDEX `IX_TestCenterId`(`TestCenterId`) USING BTREE,
  INDEX `IX_DepartmentId`(`DepartmentId`) USING BTREE,
  CONSTRAINT `FK_TestCenter_Department_Mapping_Department_DepartmentId` FOREIGN KEY (`DepartmentId`) REFERENCES `s_department` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_TestCenter_Department_Mapping_TestCenter_TestCenterId` FOREIGN KEY (`TestCenterId`) REFERENCES `t_testcenter` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '试验中心送检单位关系' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for testcenterprojects
-- ----------------------------
DROP TABLE IF EXISTS `testcenterprojects`;
CREATE TABLE `testcenterprojects`  (
  `Id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID，用GUID唯一标识',
  `TestCenterId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '试验中心Id，引用TestCenter的Id',
  `ProjectId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目Id，引用ProjectId的Id',
  `EquipmentId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '设备Id，引用Equipment的Id',
  `Deleted` tinyint(1) NOT NULL COMMENT '删除状态，用于逻辑删除和恢复数据',
  `CreatedTime` datetime(0) NOT NULL COMMENT '创建时间，记录数据产生的时间',
  `UpdatedTime` datetime(0) NOT NULL COMMENT '更新时间，用于数据一致性同步',
  PRIMARY KEY (`Id`) USING BTREE,
  UNIQUE INDEX `IX_TestCenterId_ProjectId_EquipmentId`(`TestCenterId`, `ProjectId`, `EquipmentId`) USING BTREE,
  INDEX `IX_TestCenterId`(`TestCenterId`) USING BTREE,
  INDEX `IX_ProjectId`(`ProjectId`) USING BTREE,
  INDEX `IX_EquipmentId`(`EquipmentId`) USING BTREE,
  CONSTRAINT `FK_TestCenter_Project_Mapping_Equipment_EquipmentId` FOREIGN KEY (`EquipmentId`) REFERENCES `s_equipment` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_TestCenter_Project_Mapping_Project_ProjectId` FOREIGN KEY (`ProjectId`) REFERENCES `t_project` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_TestCenter_Project_Mapping_TestCenter_TestCenterId` FOREIGN KEY (`TestCenterId`) REFERENCES `t_testcenter` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '试验中心试验项目配置' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for testdata
-- ----------------------------
DROP TABLE IF EXISTS `testdata`;
CREATE TABLE `testdata`  (
  `Id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID，用GUID唯一标识',
  `RFID` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '试品RFID',
  `RFIDSource` int(11) NULL DEFAULT NULL COMMENT 'RFID来源，0手持机扫码时模糊匹配；1手持机试验位设置',
  `ProjectId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目Id，引用ProjectId的Id',
  `ProjectCategoryId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '试验项目分类Id，引用ProjectCategory的Id',
  `RateVoltage` double NOT NULL COMMENT '额定电压(kV)',
  `WithstandVoltage` double NOT NULL COMMENT '工频耐压(kV)',
  `PressurizationTimes` int(11) NOT NULL COMMENT '加压次数(次)',
  `MaxLeakageCurrent` double NOT NULL COMMENT '最大泄露电流(mA)',
  `Length` int(11) NOT NULL COMMENT '试验长度(cm)',
  `StaticTension` int(11) NOT NULL COMMENT '试验荷载(N)',
  `Position` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部位',
  `Duration` int(11) NOT NULL COMMENT '持续时间(s)',
  `TestValue` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '试验值',
  `LeakageVoltage` double NOT NULL COMMENT '泄露电压(kV)',
  `LeakageCurrent` double NOT NULL COMMENT '泄露电流(mA)',
  `LeakageTime` int(11) NOT NULL COMMENT '泄露时间(s)',
  `SectionalArea` double NOT NULL COMMENT '截面积(mm²)',
  `Shielding` double NOT NULL COMMENT '屏蔽效率(dB)',
  `Speed` int(11) NOT NULL COMMENT '流量(L/min)',
  `PictureId` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '试验数据的曲线图片Id，引用Picture的Id',
  `Temperature` double NOT NULL COMMENT '温度°C',
  `Humidity` double NOT NULL COMMENT '湿度%',
  `Pressure` double NOT NULL COMMENT '气压kPa',
  `Altitude` double NOT NULL COMMENT '海拔m',
  `IsPass` tinyint(1) NOT NULL COMMENT '合格',
  `UserId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户Id，引用User的Id',
  `TestCenterId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '试验中心Id，引用TestCenter的Id',
  `CreatedTime` datetime(0) NOT NULL COMMENT '创建时间，记录数据产生的时间',
  `UpdatedTime` datetime(0) NOT NULL COMMENT '更新时间，用于数据一致性同步',
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `IX_ProjectId`(`ProjectId`) USING BTREE,
  INDEX `IX_ProjectCategoryId`(`ProjectCategoryId`) USING BTREE,
  INDEX `IX_UserId`(`UserId`) USING BTREE,
  INDEX `IX_TestCenterId`(`TestCenterId`) USING BTREE,
  INDEX `IX_RFID`(`RFID`) USING BTREE,
  CONSTRAINT `FK_TestData_ProjectCategory_ProjectCategoryId` FOREIGN KEY (`ProjectCategoryId`) REFERENCES `t_projectcategory` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_TestData_Project_ProjectId` FOREIGN KEY (`ProjectId`) REFERENCES `t_project` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_TestData_TestCenter_TestCenterId` FOREIGN KEY (`TestCenterId`) REFERENCES `t_testcenter` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_TestData_User_UserId` FOREIGN KEY (`UserId`) REFERENCES `s_user` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '试验数据（自动试验设备获取）' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for testfee
-- ----------------------------
DROP TABLE IF EXISTS `testfee`;
CREATE TABLE `testfee`  (
  `Id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID，用GUID唯一标识',
  `TestCenterId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '试验中心Id，引用TestCenter的Id',
  `CategoryId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '工具分类Id，引用Category的Id',
  `VoltageLevelId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电压等级Id，引用VoltageLevel的Id',
  `Specification` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规格型号：引用s_category中的Specifications',
  `Price` double NOT NULL COMMENT '试验费（单价）',
  `Unit` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单位：从ProjectCategory取Unit',
  `Deleted` tinyint(1) NOT NULL COMMENT '删除状态，用于逻辑删除和恢复数据',
  `CreatedTime` datetime(0) NOT NULL COMMENT '创建时间，记录数据产生的时间',
  `UpdatedTime` datetime(0) NOT NULL COMMENT '更新时间，用于数据一致性同步',
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `IX_TestCenterId`(`TestCenterId`) USING BTREE,
  INDEX `IX_CategoryId`(`CategoryId`) USING BTREE,
  INDEX `IX_VoltageLevelId`(`VoltageLevelId`) USING BTREE,
  CONSTRAINT `FK_TestFee_Category_CategoryId` FOREIGN KEY (`CategoryId`) REFERENCES `p_category` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_TestFee_TestCenter_TestCenterId` FOREIGN KEY (`TestCenterId`) REFERENCES `t_testcenter` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_TestFee_VoltageLevel_VoltageLevelId` FOREIGN KEY (`VoltageLevelId`) REFERENCES `p_voltagelevel` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '试验费' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for testpictures
-- ----------------------------
DROP TABLE IF EXISTS `testpictures`;
CREATE TABLE `testpictures`  (
  `Id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID，用GUID唯一标识',
  `TestId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '试验单Id，引用Test的Id',
  `PictureId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片Id，引用Picture的Id',
  `DisplayOrder` int(11) NOT NULL COMMENT '显示排序，允许用户自定义显示顺序',
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `IX_TestId`(`TestId`) USING BTREE,
  INDEX `IX_PictureId`(`PictureId`) USING BTREE,
  CONSTRAINT `FK_Test_Picture_Maiping_Picture_PictureId` FOREIGN KEY (`PictureId`) REFERENCES `s_picture` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Test_Picture_Maiping_Test_TestId` FOREIGN KEY (`TestId`) REFERENCES `t_test` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '试验单附件图片' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for testposition
-- ----------------------------
DROP TABLE IF EXISTS `testposition`;
CREATE TABLE `testposition`  (
  `Id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID，用GUID唯一标识',
  `TestCenterId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '试验中心Id，引用TestCenter的Id',
  `RFID1` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '试验位1对应的RFID',
  `RFID2` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '试验位2对应的RFID',
  `RFID3` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '试验位3对应的RFID',
  `RFID4` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '试验位4对应的RFID',
  `RFID5` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '试验位5对应的RFID',
  `RFID6` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '试验位6对应的RFID',
  `RFID7` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '试验位7对应的RFID',
  `RFID8` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '试验位8对应的RFID',
  `RFID9` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '试验位9对应的RFID',
  `RFID10` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '试验位10对应的RFID',
  `RFID11` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '试验位11对应的RFID',
  `RFID12` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '试验位12对应的RFID',
  `RFID13` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '试验位13对应的RFID',
  `RFID14` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '试验位14对应的RFID',
  `RFID15` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '试验位15对应的RFID',
  `RFID16` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '试验位16对应的RFID',
  `RFID17` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '试验位17对应的RFID',
  `RFID18` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '试验位18对应的RFID',
  `RFID19` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '试验位19对应的RFID',
  `RFID20` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '试验位20对应的RFID',
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `IX_TestCenterId`(`TestCenterId`) USING BTREE,
  CONSTRAINT `FK_TestPosition_TestCenter_TestCenterId` FOREIGN KEY (`TestCenterId`) REFERENCES `t_testcenter` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '试验位配置' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for testrecord
-- ----------------------------
DROP TABLE IF EXISTS `testrecord`;
CREATE TABLE `testrecord`  (
  `Id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID，用GUID唯一标识',
  `TestId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '试验单Id，引用Test的Id',
  `ProductId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片Id，引用Product的Id',
  `RFID` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '工具RFID，引用Product的RFID',
  `ProjectId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目Id，引用ProjectId的Id',
  `EquipmentId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备Id，引用Equipment的Id',
  `IsPass` tinyint(1) NULL DEFAULT NULL COMMENT '合格',
  `TestTime` datetime(0) NOT NULL COMMENT '试验日期',
  `NextTestTime` datetime(0) NOT NULL COMMENT '下次试验日期',
  `Cycle` int(11) NOT NULL COMMENT '试验周期',
  `TestValue` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '试验值',
  `Duration` int(11) NOT NULL COMMENT '持续时间(s)',
  `PressurizationTimes` int(11) NOT NULL COMMENT '加压次数(次)',
  `LeakageVoltage` double NOT NULL COMMENT '泄露电压(kV)',
  `LeakageCurrent` double NOT NULL COMMENT '泄露电流(mA)',
  `LeakageTime` int(11) NOT NULL COMMENT '泄露时间(s)',
  `SectionalArea` double NOT NULL COMMENT '截面积(mm²)',
  `Shielding` double NOT NULL COMMENT '屏蔽效率(dB)',
  `Speed` int(11) NOT NULL COMMENT '流量(L/min)',
  `TestDataPictureId` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '试验数据的曲线图片',
  `UserId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户Id，引用User的Id',
  `CertificateId` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '合格证号，默认采用RFID号',
  `Deleted` tinyint(1) NOT NULL COMMENT '删除状态，用于逻辑删除和恢复数据',
  `DisplayOrder` int(11) NOT NULL COMMENT '显示排序，允许用户自定义显示顺序',
  `CreatedTime` datetime(0) NOT NULL COMMENT '创建时间，记录数据产生的时间',
  `UpdatedTime` datetime(0) NOT NULL COMMENT '更新时间，用于数据一致性同步',
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `IX_TestId`(`TestId`) USING BTREE,
  INDEX `IX_ProductId`(`ProductId`) USING BTREE,
  INDEX `IX_ProjectId`(`ProjectId`) USING BTREE,
  INDEX `IX_EquipmentId`(`EquipmentId`) USING BTREE,
  INDEX `IX_UserId`(`UserId`) USING BTREE,
  INDEX `IX_RFID`(`RFID`) USING BTREE,
  CONSTRAINT `FK_Record_Equipment_EquipmentId` FOREIGN KEY (`EquipmentId`) REFERENCES `s_equipment` (`Id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Record_Product_ProductId` FOREIGN KEY (`ProductId`) REFERENCES `p_product` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Record_Project_ProjectId` FOREIGN KEY (`ProjectId`) REFERENCES `t_project` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Record_Test_TestId` FOREIGN KEY (`TestId`) REFERENCES `t_test` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Record_User_UserId` FOREIGN KEY (`UserId`) REFERENCES `s_user` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '试验记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for testwarning
-- ----------------------------
DROP TABLE IF EXISTS `testwarning`;
CREATE TABLE `testwarning`  (
  `Id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID，用GUID唯一标识',
  `DepartmentId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门Id，引用Department的Id',
  `ToUser` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接收人',
  `ToPhone` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接收电话',
  `TestTime` datetime(0) NOT NULL COMMENT '预警试品的试验时间',
  `SendTime` datetime(0) NOT NULL COMMENT '发送时间',
  `SmsMessageId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '短信Id',
  `Successful` tinyint(1) NOT NULL COMMENT '发送状态',
  `Description` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `CreatedTime` datetime(0) NOT NULL COMMENT '创建时间，记录数据产生的时间',
  `UpdatedTime` datetime(0) NOT NULL COMMENT '更新时间，用于数据一致性同步',
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `IX_DepartmentId`(`DepartmentId`) USING BTREE,
  INDEX `IX_SmsMessageId`(`SmsMessageId`) USING BTREE,
  CONSTRAINT `FK_TestWarning_Department_DepartmentId` FOREIGN KEY (`DepartmentId`) REFERENCES `s_department` (`Id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_TestWarning_SmsMessage_SmsMessageId` FOREIGN KEY (`SmsMessageId`) REFERENCES `s_smsmessage` (`Id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '试验预警' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `Id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID，用GUID唯一标识',
  `Username` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录账号',
  `FullName` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `Password` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录密码',
  `DepartmentId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门Id，引用Department的Id，默认部门',
  `Post` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位',
  `Phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  `Email` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电子邮箱',
  `RequireReLogin` tinyint(1) NOT NULL COMMENT '重新登录请求',
  `FailedLoginAttempts` int(11) NOT NULL COMMENT '登录失败次数',
  `CannotLoginUntilDate` datetime(0) NULL DEFAULT NULL COMMENT '下次登录时间',
  `Active` tinyint(1) NOT NULL COMMENT '激活状态，只有激活的用户才可以登录系统',
  `Deleted` tinyint(1) NOT NULL COMMENT '删除状态，用于逻辑删除和恢复数据',
  `IsSystemAccount` tinyint(1) NOT NULL COMMENT '系统账号，系统账号不可以删除',
  `LastIpAddress` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最近登录主机IP地址',
  `LastLoginDate` datetime(0) NULL DEFAULT NULL COMMENT '最近一次登录时间',
  `LastActivityDate` datetime(0) NULL DEFAULT NULL COMMENT '最近一次活动时间，最近一次操作时间',
  `CreatedTime` datetime(0) NOT NULL COMMENT '创建时间，记录数据产生的时间',
  `UpdatedTime` datetime(0) NOT NULL COMMENT '更新时间，用于数据一致性同步',
  PRIMARY KEY (`Id`) USING BTREE,
  UNIQUE INDEX `IX_Username`(`Username`) USING BTREE,
  INDEX `IX_DepartmentId`(`DepartmentId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '系统管理员', '$2a$10$WSsvmxr1qzI/4VYxOTgSk.BQpYxW9iZv26yzzEM6TMepRdCLogbQC', NULL, NULL, '18071026720', 'zhengmaoch@qq.com', 0, 0, NULL, 1, 0, 1, '192.168.145.1', '2019-03-06 13:54:19', NULL, '2019-03-06 13:54:19', '2019-03-06 13:54:19');
INSERT INTO `user` VALUES ('402811816941c9480169421198aa0004', 'zhengmaoch', 'string', 'chang781023', NULL, 'string', '18071026720', 'zhengmaoch@qq.com', 1, 0, '2019-03-03 13:34:28', 1, 0, 1, 'string', '2019-03-03 13:34:28', '2019-03-03 13:34:28', '2019-03-03 13:40:43', '2019-03-03 13:40:43');
INSERT INTO `user` VALUES ('402811816975f177016975f8bc150000', 'string', 'string', '$2a$10$WSsvmxr1qzI/4VYxOTgSk.BQpYxW9iZv26yzzEM6TMepRdCLogbQC', NULL, 'string', '18071026720', 'string@aaa.aa', 1, 0, '2019-03-13 15:26:59', 1, 0, 1, 'string', '2019-03-13 15:26:59', '2019-03-13 15:26:59', '2019-03-13 15:33:49', '2019-03-13 15:33:49');

-- ----------------------------
-- Table structure for userroles
-- ----------------------------
DROP TABLE IF EXISTS `userroles`;
CREATE TABLE `userroles`  (
  `UserId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户Id，引用User的Id',
  `RoleId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色Id，引用Role的Id',
  PRIMARY KEY (`UserId`, `RoleId`) USING BTREE,
  INDEX `IX_User_Id`(`UserId`) USING BTREE,
  INDEX `IX_Role_Id`(`RoleId`) USING BTREE,
  CONSTRAINT `FK8hn061fmmoqqo9uiwk9w14ska` FOREIGN KEY (`RoleId`) REFERENCES `role` (`Id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_User_Role_Mapping_Role_Role_Id` FOREIGN KEY (`RoleId`) REFERENCES `role` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_User_Role_Mapping_User_User_Id` FOREIGN KEY (`UserId`) REFERENCES `user` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKjm6sbuu41u4qqs512go52iaed` FOREIGN KEY (`RoleId`) REFERENCES `role` (`Id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKpn1qi6wk6id64sv0f7p4oyibo` FOREIGN KEY (`UserId`) REFERENCES `user` (`Id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKs9yshdmtgmmtyr2m49bkflur5` FOREIGN KEY (`UserId`) REFERENCES `user` (`Id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色关系，以服务器为准进行同步' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userroles
-- ----------------------------
INSERT INTO `userroles` VALUES ('1', '1');
INSERT INTO `userroles` VALUES ('1', '2');
INSERT INTO `userroles` VALUES ('402811816975f177016975f8bc150000', '1');

-- ----------------------------
-- Table structure for voltagelevel
-- ----------------------------
DROP TABLE IF EXISTS `voltagelevel`;
CREATE TABLE `voltagelevel`  (
  `Id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID，用GUID唯一标识',
  `Name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电压等级名称',
  `Code` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标准编码，用于方便第三方进行数据导入',
  `ExtensionCode` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '扩展编码，用于方便第三方系统对接',
  `RateVoltage` double NOT NULL COMMENT '电压等级对应的电压值',
  `VoltageTypeId` int(11) NOT NULL COMMENT '电压类型：10交流，20直流',
  `Published` tinyint(1) NOT NULL COMMENT '发布状态，用于控制数据的使用权限',
  `Deleted` tinyint(1) NOT NULL COMMENT '删除状态，用于逻辑删除和恢复数据',
  `DisplayOrder` int(11) NOT NULL COMMENT '显示排序，允许用户自定义显示顺序',
  `CreatedTime` datetime(0) NOT NULL COMMENT '创建时间，记录数据产生的时间',
  `UpdatedTime` datetime(0) NOT NULL COMMENT '更新时间，用于数据一致性同步',
  PRIMARY KEY (`Id`) USING BTREE,
  UNIQUE INDEX `IX_Name`(`Name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '电压等级' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for warehouse
-- ----------------------------
DROP TABLE IF EXISTS `warehouse`;
CREATE TABLE `warehouse`  (
  `Id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID，用GUID唯一标识',
  `Name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `DepartmentId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门Id，引用Department的Id',
  `IsCabinet` tinyint(1) NOT NULL COMMENT '是否为单个工具柜库房',
  `Published` tinyint(1) NOT NULL COMMENT '发布状态，用于控制数据的使用权限',
  `Deleted` tinyint(1) NOT NULL COMMENT '删除状态，用于逻辑删除和恢复数据',
  `DisplayOrder` int(11) NOT NULL COMMENT '显示排序，允许用户自定义显示顺序',
  `CreatedTime` datetime(0) NOT NULL COMMENT '创建时间，记录数据产生的时间',
  `UpdatedTime` datetime(0) NOT NULL COMMENT '更新时间，用于数据一致性同步',
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `IX_DepartmentId`(`DepartmentId`) USING BTREE,
  CONSTRAINT `FK_Warehouse_Department_DepartmentId` FOREIGN KEY (`DepartmentId`) REFERENCES `s_department` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '库房' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for warehousesetting
-- ----------------------------
DROP TABLE IF EXISTS `warehousesetting`;
CREATE TABLE `warehousesetting`  (
  `Id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID，用GUID唯一标识',
  `WarehouseTypeId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '库房类型Id，引用WarehouseType的Id',
  `CategoryId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '工具分类Id，引用Category的Id',
  `VoltageLevelId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电压等级Id，引用VoltageLevel的Id',
  `Count` int(11) NOT NULL COMMENT '工具数量配置',
  `Published` tinyint(1) NOT NULL COMMENT '发布状态，用于控制数据的使用权限',
  `Deleted` tinyint(1) NOT NULL COMMENT '删除状态，用于逻辑删除和恢复数据',
  `DisplayOrder` int(11) NOT NULL COMMENT '显示排序，允许用户自定义显示顺序',
  `CreatedTime` datetime(0) NOT NULL COMMENT '创建时间，记录数据产生的时间',
  `UpdatedTime` datetime(0) NOT NULL COMMENT '更新时间，用于数据一致性同步',
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `IX_CategoryIdId`(`CategoryId`) USING BTREE,
  INDEX `IX_VoltageLevelId`(`VoltageLevelId`) USING BTREE,
  INDEX `IX_WarehouseTypeId`(`WarehouseTypeId`) USING BTREE,
  CONSTRAINT `FK_WarehouseSetting_CategoryId` FOREIGN KEY (`CategoryId`) REFERENCES `p_category` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_WarehouseSetting_VoltageLevelId` FOREIGN KEY (`VoltageLevelId`) REFERENCES `p_voltagelevel` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_WarehouseSetting_WarehouseTypeId` FOREIGN KEY (`WarehouseTypeId`) REFERENCES `d_warehousetype` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '库房配置' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for warehousetype
-- ----------------------------
DROP TABLE IF EXISTS `warehousetype`;
CREATE TABLE `warehousetype`  (
  `Id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID，用GUID唯一标识',
  `Name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '库房类型名称',
  `Description` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `Published` tinyint(1) NOT NULL COMMENT '发布状态，用于控制数据的使用权限',
  `Deleted` tinyint(1) NOT NULL COMMENT '删除状态，用于逻辑删除和恢复数据',
  `DisplayOrder` int(11) NOT NULL COMMENT '显示排序，允许用户自定义显示顺序',
  `CreatedTime` datetime(0) NOT NULL COMMENT '创建时间，记录数据产生的时间',
  `UpdatedTime` datetime(0) NOT NULL COMMENT '更新时间，用于数据一致性同步',
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '库房类型' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
