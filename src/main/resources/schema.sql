-- Create syntax for TABLE 'billing'
DROP TABLE IF EXISTS `billing`;
CREATE TABLE `billing` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `street_name` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
-- Create syntax for TABLE 'supplies'
DROP TABLE IF EXISTS `supplies`;
CREATE TABLE `supplies` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `supply_code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
-- Create syntax for TABLE 'department'
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `department` varchar(255) DEFAULT NULL,
  `departmentCode` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
-- Create syntax for TABLE 'customer'
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(255) DEFAULT NULL,
  `ssn` varchar(255) DEFAULT NULL,
  `billing_id` bigint(20) DEFAULT NULL,
  `supplies_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_supplies` FOREIGN KEY (`supplies_id`) REFERENCES `supplies` (`id`),
  CONSTRAINT `FK_billing` FOREIGN KEY (`billing_id`) REFERENCES `billing` (`id`)
);
-- Create syntax for TABLE 'customer_department'
DROP TABLE IF EXISTS `customer_department`;
CREATE TABLE `customer_department` (
  `customer_id` bigint(20) NOT NULL,
  `department_id` bigint(20) NOT NULL,
  CONSTRAINT `FK_customer` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `FK_department` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`)
);