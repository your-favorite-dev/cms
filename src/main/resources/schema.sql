DROP ALL OBJECTS DELETE FILES;

CREATE TABLE IF NOT EXISTS customer
(
  id INT NOT NULL ,
  first_name VARCHAR2(255) NULL ,
  last_name VARCHAR2(255) NULL ,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS address
(
  id INT NOT NULL,
  street_address VARCHAR2(255) NOT NULL,
  city VARCHAR2(255) NOT NULL,
  state VARCHAR2(12) NOT NULL,
  mailing_postal_code VARCHAR2 (64) NOT NULL ,
  mailing_country VARCHAR2(4) NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS customer_address
(
  customer_id INT,
  address_id INT,
  type VARCHAR2(64) NULL,
  FOREIGN KEY (customer_id) REFERENCES customer(id),
  FOREIGN KEY (address_id) REFERENCES address(id),
  PRIMARY KEY(customer_id, address_id)
);


CREATE TABLE IF NOT EXISTS product
(
  id INT NOT NULL ,
  product_name VARCHAR2(255) NULL ,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS customer_product
(
  customer_id INT NOT NULL,
  product_id INT NOT NULL ,
  purchase_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (customer_id) REFERENCES customer(id),
  FOREIGN KEY (product_id) REFERENCES product(id),
  PRIMARY KEY(customer_id, product_id)
);
