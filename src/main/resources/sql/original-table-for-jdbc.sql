CREATE TABLE users (
	id  INT GENERATED ALWAYS AS IDENTITY,
	username VARCHAR(45) NOT NULL,
	password VARCHAR(45) NOT NULL,
	enabled INT NOT NULL,
PRIMARY KEY (id));

CREATE TABLE authorities (
  id INT GENERATED ALWAYS AS IDENTITY,
  username varchar(45) NOT NULL,
  authority varchar(45) NOT NULL,
  PRIMARY KEY (id));

INSERT INTO users(username, password, enabled) VALUES ('happy', '12345', '1');
INSERT INTO authorities(username, authority) VALUES ('happy', 'write');

select * FROM users;
select * from authorities;