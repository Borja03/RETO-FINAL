-- Crear la base de datos
CREATE DATABASE Libros;

-- Usar la base de datos recién creada
USE Libros;

GRANT CREATE ROLE ON *.* TO 'root'@'localhost';

-- Crear la tabla de usuarios
CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    email VARCHAR(100)
);

-- Crear la tabla de libros
CREATE TABLE libros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100),
    autor VARCHAR(100),
    anio_publicacion INT
);

-- Insertar datos en la tabla de usuarios
INSERT INTO usuarios (nombre, email) VALUES
('Juan Pérez', 'juan@example.com'),
('María García', 'maria@example.com'),
('Luis Martínez', 'luis@example.com'),
('Luis Martinez', 'luis@example.com'),
('borja', '1234');

-- Insertar datos en la tabla de libros
INSERT INTO libros (titulo, autor, anio_publicacion) VALUES
('El Señor de los Anillos', 'J.R.R. Tolkien', 1954),
('Cien años de soledad', 'Gabriel García Márquez', 1967),
('Harry Potter y la piedra filosofal', 'J.K. Rowling', 1997);

-- Crear los roles
CREATE ROLE admin_role_libros;
CREATE ROLE usuario_role_libros;

-- Asignar permisos a los roles
GRANT ALL PRIVILEGES ON Libros.* TO admin_role_libros;
GRANT SELECT ON Libros.* TO usuario_role_libros;

-- Crear usuarios y asignar roles
CREATE USER 'admin_libros'@'localhost' IDENTIFIED BY 'admin';
CREATE USER 'usuario_libros'@'localhost' IDENTIFIED BY 'usuario';

GRANT admin_role_libros TO 'admin_libros'@'localhost';
GRANT usuario_role_libros TO 'usuario_libros'@'localhost';
