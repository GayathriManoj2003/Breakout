CREATE DATABASE IF NOT EXISTS Breakout;

USE Breakout;

CREATE TABLE IF NOT EXISTS Player (
    Username VARCHAR(20),
    Password VARCHAR(30),
    PRIMARY KEY(Username)
);

CREATE TABLE IF NOT EXISTS Score (
    Username VARCHAR(20),
    Game_Level   ENUM("Easy", "Medium", "Hard"),
    Score   INT,
    Game_Timestamp  TIMESTAMP,
    PRIMARY KEY(Username, Game_Level, Game_Timestamp),
    FOREIGN KEY(Username) REFERENCES Player(Username)
);