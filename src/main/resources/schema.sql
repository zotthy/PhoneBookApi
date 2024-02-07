drop table if exists phoneBook;
drop table if exists user_app;
drop table if exists user_role;
drop table if exists user_roles;

CREATE TABLE phoneBook (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    surname VARCHAR(255),
    city VARCHAR(255),
    street VARCHAR(255),
    buildnumber INTEGER,
    aprove BOOLEAN,
    numbertel VARCHAR(11)
);
CREATE TABLE user_app (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          first_name VARCHAR(50) NOT NULL,
                          last_name VARCHAR(50) NOT NULL,
                          email VARCHAR(100) NOT NULL UNIQUE,
                          password VARCHAR(200) NOT NULL
);

CREATE TABLE user_role (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           name VARCHAR(30) NOT NULL,
                           description VARCHAR(200) NOT NULL
);

CREATE TABLE user_roles (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            user_id BIGINT NOT NULL,
                            role_id BIGINT NOT NULL,
                            FOREIGN KEY (user_id) REFERENCES user_app(id),
                            FOREIGN KEY (role_id) REFERENCES user_role(id)
);