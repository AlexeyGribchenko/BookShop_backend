delete from t_usr_role;
delete from t_user;

insert into t_user(id, active, birth_date, first_name, last_name, password, profile_picture_name, username) values
(1, true, null, 'Алексей', 'Грибченко', 123, 'default_profile_img.png', '123'),
(2, true, null, 'Виктор', 'Герасимов', 1, 'default_profile_img.png', '1');

insert into t_usr_role(usr_id, roles) values
(1, 'ROLE_USER'),
(1, 'ROLE_ADMIN'),
(1, 'ROLE_SUPER_ADMIN'),
(2, 'ROLE_USER');

create extension if not exists pgcrypto;

update t_user set password = crypt(password, gen_salt('bf'));