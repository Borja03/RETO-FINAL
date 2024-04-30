-- Creación de la base de datos
CREATE DATABASE IF NOT EXISTS coches;
USE coches;

-- Tabla para almacenar información de usuarios
CREATE TABLE IF NOT EXISTS Usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
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

CREATE USER 'ahedo'@'localhost' IDENTIFIED BY 'contra';
GRANT ALL PRIVILEGES ON *.* TO 'ahedo'@'localhost' WITH GRANT OPTION;
FLUSH PRIVILEGES;


-- Insertar datos de prueba
INSERT INTO Usuarios (nombre, apellido, correo, contraseña) VALUES
('Juan', 'Pérez', 'juan@example.com', 'contraseña123'),
('María', 'García', 'maria@example.com', 'contraseña456');



INSERT INTO Vehiculos (marca, modelo, año, numero_placa, propietario_id) VALUES
('Toyota', 'Corolla', 2018, 'ABC123', 1),
('Honda', 'Civic', 2020, 'XYZ789', 2);
