alter table admin
    drop constraint address_id;

alter table admin_roles
    drop constraint admin_id;

alter table client_action
    drop constraint app_id;

alter table client_session_client_action
    drop constraint client_action_id;

alter table client_session
    drop constraint client_id;

alter table client_session_client_action
    drop constraint client_session_id;

alter table admin_roles
    drop constraint role_id;

drop table address;

drop table admin;

drop table admin_roles;

drop table app;

drop table client;

drop table client_action;

drop table client_session;

drop table client_session_client_action;

drop table role;


ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD HH24:MI:SS';
--to_date('2021-12-04 12:04:41')

--CREATE TABLE--
    create table address (
       id integer not null,
        apartment_number integer not null,
        city varchar(36) not null,
        country varchar(36) not null,
        created_date date,
        last_modified_date date,
        local_number integer not null,
        postal_code integer not null,
        street varchar(36) not null,
        primary key (id)
    );

    
    create table admin (
       id integer not null,
        age integer not null,
        created_date date,
        email varchar(36) not null,
        first_name varchar(36) not null,
        last_modified_date date,
        phone_number varchar(9) not null,
        surname varchar(36) not null,
        address_id integer,
        primary key (id)
    );

    
    create table admin_roles (
       admin_id integer not null,
        role_id integer not null
    );

    
    create table app (
       id integer not null,
        created_date date,
        last_modified_date date,
        name varchar(36) not null,
        primary key (id)
    );

    
    create table client (
       id integer not null,
        created_date date,
        last_modified_date date,
        username varchar(36) not null,
        primary key (id)
    );

    
    create table client_action (
       id integer not null,
        created_date date,
        endpoint varchar(255),
        server_request integer,
        server_response integer,
        app_id integer,
        primary key (id)
    );

    
    create table client_session (
       id integer not null,
        address_ip varchar(255),
        created_date date,
        last_modified_date date,
        screen_resolution_x integer,
        screen_resolution_y integer,
        session_end integer,
        session_start integer,
        client_id integer,
        primary key (id)
    );

    
    create table client_session_client_action (
       client_session_id integer not null,
       client_action_id integer not null
    );

    
    create table role (
       id integer not null,
        name varchar(36) not null,
        primary key (id)
    );

--CREATE TABLE--
--MAKE FIELDS UNIQUE--

    alter table admin
       add constraint admin_email_unique unique (email);

    alter table app 
       add constraint app_name_unique unique (name);

    alter table client 
       add constraint client_username_unique unique (username);

    alter table role 
       add constraint role_name_unique unique (name);

--MAKE FIELDS UNIQUE--
--ADD FOREIGN KEY--

    alter table admin 
       add constraint address_id
       foreign key (address_id)
       references address;
    
    alter table admin_roles 
       add constraint role_id
       foreign key (role_id)
       references role;
    
    alter table admin_roles 
       add constraint admin_id
       foreign key (admin_id)
       references admin;
    
    alter table client_action 
       add constraint app_id
       foreign key (app_id)
       references app;
    
    alter table client_session 
       add constraint client_id
       foreign key (client_id)
       references client;
    
--    alter table client_session_client_action
--       add constraint client_action_id
--       foreign key (client_action_id)
--       references client_action;
--
--    alter table client_session_client_action
--       add constraint client_session_id
--       foreign key (client_session_id)
--       references client_session;
ALTER TABLE client_session_client_action
ADD CONSTRAINT client_action_id
FOREIGN KEY (client_action_id)
    REFERENCES client_action (id);

ALTER TABLE client_session_client_action
ADD CONSTRAINT client_session_id
FOREIGN KEY (client_session_id)
    REFERENCES client_session (id);
--ADD FOREIGN KEY--
--ADD VALUES--
    insert 
    into
        role
--        (id, name)
    values
        (1, 'admin');

    insert
    into
        role
--        (id, name)
    values
        (2, 'super_admin');


    insert
    into
        role
--        (id, name)
    values
         (3, 'view_customer');



    insert
    into
        role
--        (id, name)
    values
         (4, 'edit_customer');



    insert 
    into
        address
--        (id, apartment_number, city, country, created_date, last_modified_date, local_number, postal_code, street)
    values
        (1, 3, 'Warszawa', 'Poland', TO_DATE('2021-12-04 12:04:41'), TO_DATE('2021-12-04 12:04:41'), 45, 12354, 'Street');



    insert
    into
        address
--        (id, apartment_number, city, country, created_date, last_modified_date, local_number, postal_code, street)
    values
        (2, 6, 'Wroclaw', 'Poland', TO_DATE('2021-09-06 15:20:23'), TO_DATE('2021-09-06 15:20:23'), 5, 00123, 'Super Street');



    insert
    into
        address
--        (id, apartment_number, city, country, created_date, last_modified_date, local_number, postal_code, street)
    values
        (3, 1, 'Warszawa', 'Poland', TO_DATE('2021-09-06 15:20:23'), TO_DATE('2021-09-06 15:20:23'), 123, 01323, 'Smocza');



    insert
    into
        address
--        (id, apartment_number, city, country, created_date, last_modified_date, local_number, postal_code, street)
    values
        (4, 2, 'Krakow', 'Poland', TO_DATE('2021-09-06 15:20:23'), TO_DATE('2021-09-06 15:20:23'), 4, 02345, 'Good Street');



    insert 
    into
        admin
--        (id, age, created_date, email, first_name, last_modified_date, phone_number, surname, address_id)
    values
        (1, 20, TO_DATE('2021-12-04 12:04:41'), 'damian@appmonitoring.com', 'Damian', TO_DATE('2021-12-04 12:04:41'), 777888999, 'Kowalski', 1);



    insert
    into
        admin
--        (id, age, created_date, email, first_name, last_modified_date, phone_number, surname, address_id)
    values
        (2, 45, TO_DATE('2021-11-20 15:54:09'), 'admin@appmonitoring.com', 'Adam', TO_DATE('2021-01-10 06:02:11'), 888123345, 'Nowak', 2);



    insert
    into
        admin
--        (id, age, created_date, email, first_name, last_modified_date, phone_number, surname, address_id)
    values
        (3, 51, TO_DATE('2021-11-20 15:54:09'), 'customer@appmonitoring.com', 'Wojtek', TO_DATE('2021-01-10 06:02:11'), 523432123, 'Nowak', 3);



    insert
    into
        admin
--        (id, age, created_date, email, first_name, last_modified_date, phone_number, surname, address_id)
    values
        (4, 36, TO_DATE('2021-11-20 15:54:09'), 'customer2@appmonitoring.com', 'Adam', TO_DATE('2021-01-10 06:02:11'), 897654321, 'Nowak', 4);



    insert 
    into
        admin_roles
--        (admin_id, role_id)
    values
        (1, 1);



    insert
    into
        admin_roles
--        (admin_id, role_id)
    values
        (1, 2);



    insert
    into
        admin_roles
--        (admin_id, role_id)
    values
        (2, 2);



    insert
    into
        admin_roles
--        (admin_id, role_id)
    values
        (2, 1);



    insert
    into
        admin_roles
--        (admin_id, role_id)
    values
        (3, 3);



    insert
    into
        admin_roles
--        (admin_id, role_id)
    values
        (4, 4);



    insert
    into
        admin_roles
--        (admin_id, role_id)
    values
        (4, 3);

    

    insert 
    into
        app
--        (id, created_date, last_modified_date, name)
    values
        (1, to_date('2021-12-04 12:04:41'), to_date('2021-12-04 13:05:42'), 'Jira');
    

    insert 
    into
        app
--        (id, created_date, last_modified_date, name)
    values
        (2, to_date('2021-12-04 12:04:41'), to_date('2021-12-04 12:04:41'), 'Confluence');



    insert
    into
        app
--        (id, created_date, last_modified_date, name)
    values
        (3, to_date('2021-05-05 15:56:42'), to_date('2021-05-05 15:56:42'), 'Payment SYS');



    insert
    into
        app
--        (id, created_date, last_modified_date, name)
    values
        (4, to_date('2021-05-05 15:56:42'), to_date('2021-05-05 15:56:42'), 'Message Generator');

    

    insert 
    into
        client
--        (id, created_date, last_modified_date, username)
    values
        (1, to_date('2021-12-04 12:04:41'), to_date('2021-12-04 12:06:54'), 'ClientA');

    

    insert 
    into
        client
--        (id, created_date, last_modified_date, username)
    values
        (2, to_date('2021-12-04 12:04:41'), to_date('2021-12-04 12:06:54'), 'ClientB');

    

    insert 
    into
        client
--        (id, created_date, last_modified_date, username)
    values
        (3, to_date('2021-12-05 13:04:41'), to_date('2021-12-06 12:06:54'), 'ClientC');



    insert
    into
        client
--        (id, created_date, last_modified_date, username)
         values
            (4, to_date('2021-12-05 13:04:41'), to_date('2021-12-06 12:06:54'), 'ClientD');

    

    insert 
    into
        client_action
--        (id, created_date, endpoint, server_request, server_response, app_id) 
    values
        (1, to_date('2021-12-05 13:04:41'), '/api/v2/dashboard', 8934, 9032, 1);

    

    insert 
    into
        client_action
--        (id, created_date, endpoint, server_request, server_response, app_id) 
    values
        (2, to_date('2021-12-04 12:04:41'), '/api/v2/dashboard', 500, 2352, 1);

    

    insert 
    into
        client_action
--        (id, created_date, endpoint, server_request, server_response, app_id) 
    values
        (3, to_date('2021-12-04 12:04:41'), '/api/v3/task', 644, 6752, 2);

    

    insert 
    into
        client_action
--        (id, created_date, endpoint, server_request, server_response, app_id) 
    values
        (4, to_date('2021-12-04 12:04:41'), '/api/v2/user', 1235, 1908, 1);

    

    insert 
    into
        client_action
--        (id, created_date, endpoint, server_request, server_response, app_id)
    values
        (5, to_date('2021-04-04 15:05:41'), '/api/v2/user/1234', 1236, 6342, 2);

    

    insert 
    into
        client_action
--        (id, created_date, endpoint, server_request, server_response, app_id)
    values
        (6, to_date('2021-12-04 12:04:41'), '/api/v2/login', 1236, 6342, 1);

    

    insert 
    into
        client_action
--        (id, created_date, endpoint, server_request, server_response, app_id)
    values
        (7, to_date('2021-12-04 12:04:41'), '/api/v2/settings', 1236, 6342, 2);



    insert 
    into
        client_session
--        (id, address_ip, created_date, last_modified_date, screen_resolution_x, screen_resolution_y, session_end, session_start, client_id)
    values
        (1, '192.168.5.123', to_date('2021-12-04 12:04:41'), to_date('2021-12-04 12:04:41'), 1920, 1080, 1638615896631, 1638615881631, 1);

    insert 
    into
        client_session_client_action
        (client_session_id, client_action_id) 
    values
        (1, 1);

    insert 
    into
        client_session_client_action
        (client_session_id, client_action_id) 
    values
        (1, 2);

    insert 
    into
        client_session_client_action
        (client_session_id, client_action_id) 
    values
        (1, 4);

    

    insert 
    into
        client_session
        (id, address_ip, created_date, last_modified_date, screen_resolution_x, screen_resolution_y, session_end, session_start, client_id) 
    values
        (2, '192.168.5.557', to_date('2021-12-04 12:04:41'), to_date('2021-12-04 12:04:41'), 1920, 1080, 1638615902952, 1638615881631, 1);



    insert 
    into
        client_session_client_action
        (client_session_id, client_action_id) 
    values
        (2, 7);

    insert 
    into
        client_session_client_action
        (client_session_id, client_action_id) 
    values
        (2, 2);

    insert 
    into
        client_session_client_action
        (client_session_id, client_action_id) 
    values
        (2, 5);

    

    insert 
    into
        client_session
        (id, address_ip, created_date, last_modified_date, screen_resolution_x, screen_resolution_y, session_end, session_start, client_id) 
    values
        (3, '192.168.1.421', to_date('2021-12-04 12:04:41'), to_date('2021-12-04 12:04:41'), 1920, 1080, 1638615882631, 1638615881631, 2);

    insert 
    into
        client_session_client_action
        (client_session_id, client_action_id) 
    values
        (3, 6);

    insert 
    into
        client_session_client_action
        (client_session_id, client_action_id) 
    values
        (3, 5);

    insert 
    into
        client_session_client_action
        (client_session_id, client_action_id) 
    values
        (3, 5);

    

    insert 
    into
        client_session
        (id, address_ip, created_date, last_modified_date, screen_resolution_x, screen_resolution_y, session_end, session_start, client_id) 
    values
        (4, '192.168.9.567', to_date('2021-12-04 12:04:41'), to_date('2021-12-04 12:04:41'), 1920, 1080, 1638615881631, 1638615881631, 4);

    insert 
    into
        client_session_client_action
        (client_session_id, client_action_id) 
    values
        (4, 5);

    insert 
    into
        client_session_client_action
        (client_session_id, client_action_id) 
    values
        (4, 2);

    insert 
    into
        client_session_client_action
        (client_session_id, client_action_id) 
    values
        (4, 4);

    

    insert 
    into
        client_session
        (id, address_ip, created_date, last_modified_date, screen_resolution_x, screen_resolution_y, session_end, session_start, client_id) 
    values
        (5, '192.168.6.677', to_date('2021-12-04 12:04:41'), to_date('2021-12-04 12:04:41'), 1920, 1080, 1638615884874, 1638615881631, 3);

    insert 
    into
        client_session_client_action
        (client_session_id, client_action_id) 
    values
        (5, 6);

    insert 
    into
        client_session_client_action
        (client_session_id, client_action_id) 
    values
        (5, 2);

    insert 
    into
        client_session_client_action
        (client_session_id, client_action_id) 
    values
        (5, 3);

    

    insert 
    into
        client_session
        (id, address_ip, created_date, last_modified_date, screen_resolution_x, screen_resolution_y, session_end, session_start, client_id) 
    values
        (6, '192.168.2.324', to_date('2021-12-04 12:04:41'), to_date('2021-12-04 12:04:41'), 1920, 1080, 1638615887943, 1638615881631, 2);

    insert 
    into
        client_session_client_action
        (client_session_id, client_action_id) 
    values
        (6, 5);

    insert 
    into
        client_session_client_action
        (client_session_id, client_action_id) 
    values
        (6, 6);

    insert 
    into
        client_session_client_action
        (client_session_id, client_action_id) 
    values
        (6, 7);

    

    insert 
    into
        client_session
        (id, address_ip, created_date, last_modified_date, screen_resolution_x, screen_resolution_y, session_end, session_start, client_id) 
    values
        (7, '192.168.4.677', to_date('2021-12-04 12:04:41'), to_date('2021-12-04 12:04:41'), 1920, 1080, 1638615896631, 1638615881631, 3);

    insert 
    into
        client_session_client_action
        (client_session_id, client_action_id) 
    values
        (7, 3);

    insert 
    into
        client_session_client_action
        (client_session_id, client_action_id) 
    values
        (7, 2);

    insert 
    into
        client_session_client_action
        (client_session_id, client_action_id) 
    values
        (7, 5);

    

    insert 
    into
        client_session
        (id, address_ip, created_date, last_modified_date, screen_resolution_x, screen_resolution_y, session_end, session_start, client_id) 
    values
        (8, '192.168.1.562', to_date('2021-12-04 12:04:41'), to_date('2021-12-04 12:04:41'), 1920, 1080, 1638615881631, 1638615881631, 4);

    insert 
    into
        client_session_client_action
        (client_session_id, client_action_id) 
    values
        (8, 6);

    insert 
    into
        client_session_client_action
        (client_session_id, client_action_id) 
    values
        (8, 2);

    insert 
    into
        client_session_client_action
        (client_session_id, client_action_id) 
    values
        (8, 4);
--ADD VALUES--
--select * from address;
--select * from admin;
--select * from admin_roles;
--select * from app;
--select * from client;
--select * from client_action;
--select * from client_session;
--select * from client_session_client_action;