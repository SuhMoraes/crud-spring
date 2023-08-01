CREATE TABLE tb_parking_spot(
  id UUID PRIMARY KEY,
  parking_spot_number VARCHAR(10) NOT NULL UNIQUE,
  license_plate_car VARCHAR(7) NOT NULL UNIQUE,
  brand VARCHAR(70) NOT NULL,
  model_car VARCHAR(70) NOT NULL,
  color_car VARCHAR(70) NOT NULL,
  registration_date TIMESTAMP NOT NULL,
  responsible_name VARCHAR(130) NOT NULL,
  apartment VARCHAR(30) NOT NULL,
  block VARCHAR(30) NOT NULL
);