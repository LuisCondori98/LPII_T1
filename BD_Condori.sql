USE bd1_Condori;

SELECT * FROM usuario;

INSERT INTO Usuario VALUES
			(1, 'lcond@gmail.com', 'Luis Enrique'),
            (2, 'javi868@gmail.com', 'Javier Ventocilla'),
            (3, 'Hugo_96@gmail.com', 'Hugo Lara');
            
SELECT * FROM Libro;

DROP TABLE Prestamo;

INSERT INTO Libro VALUES
			(1, '1992-08-01', 'Mario Vargas', 'La ciudad y los perros'),
            (2, '1980-05-28', 'Jose Maria Arguedas', 'Runa rupay'),
            (3, '1789-11-17', 'Ciro Alegria', 'Lazaro');