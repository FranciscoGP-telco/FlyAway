CREATE TABLE airlines(
  airline_id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL UNIQUE,
  PRIMARY KEY (airline_id)
);

CREATE TABLE flights(
  flight_id INT NOT NULL AUTO_INCREMENT,
  source VARCHAR(50) NOT NULL,
  destiny VARCHAR(50) NOT NULL,
  airline_id INT,
  flight_date DATE NOT NULL,
  price FLOAT(6,2) NOT NULL,
  PRIMARY KEY (flight_id),
  FOREIGN KEY (airline_id)
    REFERENCES airline(airline_id) 
      ON DELETE SET NULL 
      ON UPDATE CASCADE
);

CREATE TABLE purchases(
  purchase_id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(60) NOT NULL,
  last_name VARCHAR(60),
  tlfn_number INT(9) NOT NULL,
  email VARCHAR(50) NOT NULL,
  n_passengers INT NOT NULL,
  card_number VARCHAR(16) NOT NULL,
  flight_id INT,
  PRIMARY KEY (purchase_id),
  FOREIGN KEY (flight_id)
    REFERENCES flights(flight_id) 
      ON DELETE RESTRICT 
      ON UPDATE CASCADE
);

CREATE TABLE admins(
  admin_id INT NOT NULL AUTO_INCREMENT,
  username VARCHAR(20) NOT NULL UNIQUE,
  email VARCHAR(50) NOT NULL UNIQUE,
  password VARCHAR(30) NOT NULL,
  PRIMARY KEY (admin_id)
);