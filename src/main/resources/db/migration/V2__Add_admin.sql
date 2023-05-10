insert into t_user (id, active, birth_date, first_name, last_name, password, username, profile_picture_name)
    values(1, true, null, 'Алексей', 'Грибченко', 123, 123, 'billy-billy-herrington.gif');

insert into t_usr_role(usr_id, roles) values
(1, 'ROLE_USER'),
(1, 'ROLE_ADMIN'),
(1, 'ROLE_SUPER_ADMIN');