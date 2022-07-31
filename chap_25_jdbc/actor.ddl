CREATE TABLE `actor` (
                         `id` int(11) NOT NULL AUTO_INCREMENT,
                         `name` varchar(32) CHARACTER SET latin1 NOT NULL DEFAULT '',
                         `sex` char(1) CHARACTER SET latin1 NOT NULL DEFAULT '',
                         `borndate` datetime DEFAULT NULL,
                         `phone` varchar(12) CHARACTER SET latin1 DEFAULT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;