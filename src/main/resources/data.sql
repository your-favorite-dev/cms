INSERT INTO customer (id, first_name, last_name) VALUES
  (1, 'George', 'Brown'),
  (2, 'Mike', 'Black'),
  (3, 'Barry', 'White'),
  (4, 'Mr', 'Gray');

INSERT INTO address (id, street_address, city, state, mailing_postal_code, mailing_country) VALUES
  (1, '1 Bond St', 'New York', 'NY', '11212','US'),
  (2, '15 Bloor St', 'Toronto','ON', 'M5Y,5Y8','US'),
  (3, '11 Maiden Ln', 'Chicago', 'IL','66420','US'),
  (4, '15 Wall St', 'New York', 'NY','10001','US'),
  (5, '1000 Broome St', 'Sydney', 'NSW','00000000','AUS');

INSERT INTO customer_address (customer_id, address_id, type) VALUES
  (1, 1, 'MAILING'),
  (2, 2, 'MAILING'),
  (2, 3, 'BILLING'),
  (3, 3, 'MAILING'),
  (3, 4, 'BILLING'),
  (4, 4, 'BILLING'),
  (1, 5, 'BILLING');

INSERT INTO product (id, product_name) VALUES
  (1, 'CD'),
  (2, 'DVD'),
  (3, 'iPod'),
  (4, 'Record'),
  (5, 'Tape'),
  (6, 'MP3'),
  (7, 'WAV'),
  (8, 'Radio'),
  (9, 'Walkman'),
  (10, 'Discman'),
  (11, 'Laser Disc'),
  (12, 'Blue Ray');

INSERT INTO customer_product (customer_id, product_id, purchase_date) VALUES
  (1, 1, '2015-03-25 13:40:03'),
  (2, 2, '2018-02-25 13:40:03'),
  (3, 3, '2018-02-15 13:40:03'),
  (4, 4, '2018-02-15 13:40:03'),
  (1, 5, '2018-02-16 13:40:03'),
  (2, 6, '2015-03-25 13:40:03'),
  (3, 7, '2018-02-15 13:40:03'),
  (4, 8, '2018-01-15 13:40:03'),
  (1, 9, '2018-01-31 13:40:03'),
  (2, 10, '2015-03-25 13:40:03'),
  (3, 11, '2018-02-15 13:40:03'),
  (4, 12, '2018-02-15 13:40:03'),
  (1, 12, '2017-12-25 13:40:03'),
  (2, 11, '2015-03-25 13:40:03'),
  (3, 10, '2018-02-15 13:40:03'),
  (4, 9, '2018-01-15 13:40:03'),
  (1, 8, '2018-02-02 13:40:03'),
  (2, 7, '2015-03-25 13:40:03'),
  (3, 6, '2018-02-15 13:40:03'),
  (4, 5, '2018-02-15 13:40:03'),
  (1, 4, '2015-03-25 13:40:03'),
  (2, 3, '2017-11-25 13:40:03'),
  (3, 2, '2017-02-15 13:40:03'),
  (4, 1, '2018-02-01 13:40:03');