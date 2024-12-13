CREATE TABLE person
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    address    VARCHAR(80) NOT NULL,
    first_name VARCHAR(80) NOT NULL,
    gender     VARCHAR(6)  NOT NULL,
    last_name  VARCHAR(80) NOT NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);