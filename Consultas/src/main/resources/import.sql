insert into curso (id, nombre, tutor) values (1, '1º DAM', 'Miguel Campos');
insert into curso (id, nombre, tutor) values (2, '2º DAM', 'Luis Miguel López');

insert into asignatura (id, nombre, profesor, curso_id) values (1, 'Bases de datos', 'Luis Miguel López', 1);
insert into asignatura (id, nombre, profesor, curso_id) values (2, 'Entornos de Desarrollo', 'Luis Miguel López', 1);
insert into asignatura (id, nombre, profesor, curso_id) values (3, 'Programación', 'Ángel Naranjo', 1);
insert into asignatura (id, nombre, profesor, curso_id) values (4, 'Lenguajes de Marcas', 'Rafael Villar', 1);
insert into asignatura (id, nombre, profesor, curso_id) values (5, 'Sistemas Informáticos', 'Miguel Campos', 1);
insert into asignatura (id, nombre, profesor, curso_id) values (6, 'Formación y Orientación Laboral', 'Jesús Casanova', 1);
insert into asignatura (id, nombre, profesor, curso_id) values (7, 'Formación y Orientación Personal', 'Fernando Fanegas', 1);
insert into asignatura (id, nombre, profesor, curso_id) values (8, 'Acceso a Datos', 'Luis Miguel López', 2);
insert into asignatura (id, nombre, profesor, curso_id) values (9, 'Programación de Servicios y Procesos', 'Luis Miguel López', 2);
insert into asignatura (id, nombre, profesor, curso_id) values (10, 'Sistemas de Gestión Empresarial', 'Luis Miguel López', 2);
insert into asignatura (id, nombre, profesor, curso_id) values (11, 'Desarrollo de interfaces', 'Miguel Campos', 2);
insert into asignatura (id, nombre, profesor, curso_id) values (12, 'Programación Multimedia y Dispositivos Móviles', 'Miguel Campos', 2);
insert into asignatura (id, nombre, profesor, curso_id) values (13, 'Empresa e Iniciativa Emprendedora', 'Jesús Casanova', 2);
insert into asignatura (id, nombre, profesor, curso_id) values (14, 'Inglés', 'Javier Bernal', 2);
insert into asignatura (id, nombre, profesor, curso_id) values (15, 'Formación y Orientación Personal', 'Fco. José Pérez', 2);


insert into alumno (id, nombre, apellidos, email, curso_id) values (1, 'Antonio Manuel', 'Fuentes Segura','ertitoantonio@gmail.com', 1);
insert into alumno (id, nombre, apellidos, email, curso_id) values (2, 'Su Primo', 'Sur Mano','sucolega@gmail.com', 1);

ALTER SEQUENCE hibernate_sequence RESTART WITH 1000;