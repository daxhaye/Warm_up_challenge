/* Tablas */
INSERT INTO users (email, password) VALUES('daxhaye@gmail.com', '12345');
INSERT INTO users (email, password) VALUES('maru_vaque@gmail.com', '12345');

INSERT INTO authorities (user_id, authority) VALUES(1, 'ROLE_USER');

INSERT INTO posts (titulo, contenido, imagen, categoria, create_at, user_id) VALUES('darisa', 'me da mucha risa lo que estoy haciendo', 'davidfachero.jpg', 'comedia', '1993-05-20', 1);
INSERT INTO posts (titulo, contenido, imagen, categoria, create_at, user_id) VALUES('darisa', 'me da mucha risa lo que estoy haciendo', 'davidfachero.jpg', 'drama', '1994-03-19', 1);
INSERT INTO posts (titulo, contenido, imagen, categoria, create_at, user_id) VALUES('darisa', 'me da mucha risa lo que estoy haciendo', 'davidfachero.jpg', 'accion', '1992-02-19', 1);
INSERT INTO posts (titulo, contenido, imagen, categoria, create_at, user_id) VALUES('mama', 'me dadasdas', 'maru.jpg', 'drama', '1993-04-19', 2);
INSERT INTO posts (titulo, contenido, imagen, categoria, create_at, user_id) VALUES('darisa', 'me da mucha risa lo que estoy haciendo', 'davidfachero.jpg', 'comedia', '1993-01-19', 2);