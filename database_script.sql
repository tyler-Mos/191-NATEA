DROP DATABASE IF EXISTS NATEA;
CREATE DATABASE NATEA;
USE NATEA;

DROP TABLE IF EXISTS members;
CREATE TABLE members (
    id INTEGER NOT NULL AUTO_INCREMENT,
    firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    address VARCHAR(200) NOT NULL,
    phone VARCHAR(50) NOT NULL,
    role VARCHAR(50) NOT NULL,
    chapter VARCHAR(50),
    facebook VARCHAR(2083),
    linkedin VARCHAR(2083),
    photo VARCHAR(2083),
    workPlace VARCHAR(50),
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS accounts;
CREATE TABLE accounts (
    memberId INTEGER NOT NULL,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(20) NOT NULL,
    PRIMARY KEY (memberId),
    FOREIGN KEY (memberId) REFERENCES members(id)
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS events;
CREATE TABLE events (
    id INTEGER NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    location VARCHAR(200) NOT NULL,
    startTime DATETIME NOT NULL,
    endTime DATETIME NOT NULL,
    capacity INTEGER,
    type VARCHAR(20),
    description TEXT,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS orders;
CREATE TABLE orders (
    id INTEGER NOT NULL AUTO_INCREMENT,
    memberId INTEGER NOT NULL,
    createdAt DATETIME NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (memberId) REFERENCES members(id)
        ON DELETE NO ACTION -- might be change to cascade later --
);

DROP TABLE IF EXISTS tickets;
CREATE TABLE tickets (
    id INTEGER NOT NULL AUTO_INCREMENT,
    eventId INTEGER NOT NULL,
    price DECIMAL(19,4) NOT NULL,
    type VARCHAR(20),
    PRIMARY KEY (id),
    FOREIGN KEY (eventId) REFERENCES events(id)
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS packages;
CREATE TABLE packages (
    id INTEGER NOT NULL AUTO_INCREMENT,
    type VARCHAR(50) NOT NULL,
    fund DECIMAL(19,4) NOT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS sponsors;
CREATE TABLE sponsors (
    id INTEGER NOT NULL AUTO_INCREMENT,
    packageId INTEGER NOT NULL,
    name VARCHAR(50) NOT NULL,
    contactName VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    phone VARCHAR(50),
    PRIMARY KEY (id),
    FOREIGN KEY (packageId) REFERENCES packages(id)
        ON DELETE CASCADE -- might change later --
);
