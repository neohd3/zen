CREATE TABLE tlds (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(16) NOT NULL,
  price BIGINT NOT NULL
);
 
INSERT INTO tlds (id, name, price) VALUES
  (1, 'com', 899),
  (2, 'club', 1599),
  (3, 'net', 999);

CREATE TABLE domains (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  tld BIGINT NOT NULL,
  CONSTRAINT FK_DOMAIN_TLD FOREIGN KEY (tld) REFERENCES tlds(id)
);


INSERT INTO domains (name, tld) VALUES
  ('existing', 1);