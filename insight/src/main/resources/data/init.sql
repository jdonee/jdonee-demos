SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS tb_user;
CREATE TABLE tb_user (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  login_name varchar(20) COLLATE utf8_bin NOT NULL,
  name varchar(20) COLLATE utf8_bin NOT NULL,
  password varchar(100) COLLATE utf8_bin NOT NULL,
  salt varchar(100) COLLATE utf8_bin NOT NULL,
  roles varchar(50) COLLATE utf8_bin DEFAULT NULL,
  register_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

DROP TABLE IF EXISTS tb_task;
CREATE TABLE tb_task (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  title varchar(100) COLLATE utf8_bin NOT NULL,
  description varchar(500) COLLATE utf8_bin NULL,
  user_id bigint(20) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;