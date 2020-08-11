/* default password is "password" */
insert into users(username, password, enabled) values 
    ("volunteer", "$2a$10$PL/lz5eiEJ6gCE7WpyyyROT7w02TZBSklkxx2295SV8JNEwGgg7SW", 1),
    ("manager", "$2a$10$PL/lz5eiEJ6gCE7WpyyyROT7w02TZBSklkxx2295SV8JNEwGgg7SW", 1);

insert into authorities(username, authority) values
    ("volunteer", "ROLE_VOLUNTEER"),
    ("manager", "ROLE_MANAGER");
