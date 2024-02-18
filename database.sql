CREATE DATABASE asset_management;
USE asset_management;

CREATE TABLE Asset (
    id INT PRIMARY KEY AUTO_INCREMENT,
    asset_name VARCHAR(255) NOT NULL,
    purchase_date DATE NOT NULL,
    purchase_price DECIMAL(10, 2) NOT NULL,
    current_value DECIMAL(10, 2),
    status VARCHAR(20),
    vendor_id INT,
    FOREIGN KEY (vendor_id) REFERENCES Vendor(id)
);

CREATE TABLE Maintenance (
    id INT PRIMARY KEY AUTO_INCREMENT,
    asset_id INT,
    maintenance_date DATE NOT NULL,
    description TEXT,
    cost DECIMAL(10, 2),
    FOREIGN KEY (asset_id) REFERENCES Asset(id)
);

CREATE TABLE Sale (
    id INT PRIMARY KEY AUTO_INCREMENT,
    asset_id INT,
    sale_date DATE NOT NULL,
    selling_price DECIMAL(10, 2) NOT NULL,
    buyer_name VARCHAR(255),
    FOREIGN KEY (asset_id) REFERENCES Asset(id)
);

CREATE TABLE Vendor (
    id INT PRIMARY KEY AUTO_INCREMENT,
    vendor_name VARCHAR(255) NOT NULL
);

-- Inserting vendors
INSERT INTO Vendor (vendor_name) VALUES ('Vendor A');
INSERT INTO Vendor (vendor_name) VALUES ('Vendor B');
INSERT INTO Vendor (vendor_name) VALUES ('Vendor C');

-- Inserting assets
INSERT INTO Asset (asset_name, purchase_date, purchase_price, current_value, status, vendor_id)
VALUES ('Laptop', '2023-01-15', 1200.00, 1000.00, 'Active', 1);

INSERT INTO Asset (asset_name, purchase_date, purchase_price, current_value, status, vendor_id)
VALUES ('Printer', '2023-02-20', 500.00, 400.00, 'Active', 2);

-- Inserting maintenance records
INSERT INTO Maintenance (asset_id, maintenance_date, description, cost)
VALUES (3, '2023-03-10', 'Replaced battery', 50.00);

INSERT INTO Maintenance (asset_id, maintenance_date, description, cost)
VALUES (4, '2023-04-05', 'Replaced toner cartridge', 100.00);

-- Inserting sale records
INSERT INTO Sale (asset_id, sale_date, selling_price, buyer_name)
VALUES (3, '2024-01-20', 900.00, 'John Doe');

INSERT INTO Sale (asset_id, sale_date, selling_price, buyer_name)
VALUES (4, '2024-02-05', 350.00, 'Jane Smith');

select * from Vendor; select * from Asset; select * from Maintenance; select * from Sale;




