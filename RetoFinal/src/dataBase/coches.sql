-- Creación de la base de datos
CREATE DATABASE IF NOT EXISTS coches;
USE coches;

-- Tabla para almacenar información de usuarios
CREATE TABLE IF NOT EXISTS Usuarios (
    id INT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    correo VARCHAR(100) NOT NULL UNIQUE,
    contraseña VARCHAR(100) NOT NULL
);

-- Tabla para almacenar información de vehículos
CREATE TABLE IF NOT EXISTS Vehiculos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    marca VARCHAR(50) NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    año INT NOT NULL,
    numero_placa VARCHAR(20) NOT NULL UNIQUE,
    propietario_id INT,
    FOREIGN KEY (propietario_id) REFERENCES Usuarios(id) ON DELETE CASCADE
);

-- Insertar datos de prueba
INSERT INTO Usuarios (id,nombre, apellido, correo, contraseña) VALUES
(1,'Juan', 'Pérez', 'juan@example.com', 'contraseña123'),
(2,'María', 'García', 'maria@example.com', 'contraseña456');

INSERT INTO Usuarios (id,nombre, apellido, correo, contraseña) VALUES
(3,'1', '1', 'juasn@example.com', '1');

INSERT INTO Vehiculos (marca, modelo, año, numero_placa, propietario_id) VALUES
('Toyota', 'Corolla', 2018, 'ABC123', 1),
('Honda', 'Civic', 2020, 'XYZ789', 2);

select * from Usuarios;
select * from Vehiculos;
-- UPDATE Usuarios SET nombre="prueb", apellido="prueba",correo="prueba",contraseña="prueba" WHERE nombre= "María";

-- CREATE USER 'ahedo'@'localhost' IDENTIFIED BY 'contra';
-- GRANT ALL PRIVILEGES ON *.* TO 'ahedo'@'localhost' WITH GRANT OPTION;
-- FLUSH PRIVILEGES;

GRANT SELECT, UPDATE ON coches.* TO 'ahedo'@'localhost';
FLUSH PRIVILEGES;


