insert into users(username, password, enabled) values 
    ("volunteer", "password", 1),
    ("manager", "password", 1);

insert into authorities(username, authority) values
    ("volunteer", "ROLE_USER"),
    ("manager", "ROLE_ADMIN");
