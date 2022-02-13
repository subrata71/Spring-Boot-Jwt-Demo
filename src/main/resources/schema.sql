CREATE TABLE employee (
  id          INTEGER PRIMARY KEY auto_increment,
  name VARCHAR(64) NOT NULL,
  designation   VARCHAR(64) NOT NULL,
  position   VARCHAR(64) NOT NULL
  );

CREATE TABLE application_user (
  id          INTEGER PRIMARY KEY auto_increment,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(512) NOT NULL
);