insert into roles(nombre) values ("ROLE_USER");
insert into roles(nombre) values ("ROLE_ADMIN");

insert into usuarios(usuario, password) values ("armando", "$2a$10$gBYrEJl3IJ6B8IPtHT.ZRODhMVVXL7mj0oo/sSKkA6lsPcg16hAbi");
insert into usuarios(usuario, password) values ("administrador", "$2a$10$gBYrEJl3IJ6B8IPtHT.ZRODhMVVXL7mj0oo/sSKkA6lsPcg16hAbi");

insert into usuariosroles(idrol, idusuario) values (1, 2);
insert into usuariosroles(idrol, idusuario) values (2, 1);
insert into usuariosroles(idrol, idusuario) values (1, 1);

insert into comentarios(idusuario, contenido) values (1, "Comenta lo que quieras!");