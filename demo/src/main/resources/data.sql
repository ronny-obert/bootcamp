DROP TABLE IF EXISTS tbl_equipment;

CREATE TABLE tbl_equipment (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  category VARCHAR(250) DEFAULT NULL,
  brand VARCHAR(250) DEFAULT NULL,
  name VARCHAR(250) DEFAULT NULL,
  stock INT DEFAULT NULL,
  model VARCHAR(250) DEFAULT NULL,
  price DECIMAL DEFAULT NULL
);

INSERT INTO tbl_equipment (category, brand, name, stock, model, price) VALUES
  ('accessory', 'Lowe apline', 'Munkees Folding Knife', 15, 'Folding Knife', 19.90 ),
  ('accessory', 'After Shokz', 'Fenix T5 Aluminium Tactical Pen Black', 3, 'Pen', 96.39),
  ('accessory', 'Stanley', 'BUFF Coolnet', 13, 'Headwear', 95.00);