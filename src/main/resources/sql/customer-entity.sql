CREATE TABLE customer (
  id INT GENERATED ALWAYS AS IDENTITY,
  email varchar(45) NOT NULL,
  pwd varchar(200) NOT NULL,
  role varchar(45) NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO customer(email, pwd, role)
 VALUES ('nhatle@example.com', '54321', 'admin');