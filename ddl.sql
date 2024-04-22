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
    StartGame_Timestamp  TIMESTAMP,
    EndGame_Timestamp  TIMESTAMP,
    PRIMARY KEY(Username, Game_Level, StartGame_Timestamp),
    FOREIGN KEY(Username) REFERENCES Player(Username)
);


INSERT INTO Score (Username, Game_Level, Score, StartGame_Timestamp, EndGame_Timestamp) VALUES
('Gayathri', 'Easy', 100, '2024-04-22 10:00:00', '2024-04-22 10:10:00'),
('Gayathri', 'Easy', 95, '2024-04-22 10:30:00', '2024-04-22 10:40:00'),
('Gayathri', 'Easy', 110, '2024-04-22 11:00:00', '2024-04-22 11:15:00'),
('Gayathri', 'Easy', 105, '2024-04-22 11:30:00', '2024-04-22 11:45:00'),
('Gayathri', 'Easy', 120, '2024-04-22 12:00:00', '2024-04-22 12:20:00'),
('Gayathri', 'Easy', 115, '2024-04-22 12:30:00', '2024-04-22 12:45:00'),
('Gayathri', 'Easy', 90, '2024-04-22 13:00:00', '2024-04-22 13:10:00'),
('Gayathri', 'Easy', 100, '2024-04-22 13:30:00', '2024-04-22 13:40:00'),
('Gayathri', 'Easy', 115, '2024-04-22 14:00:00', '2024-04-22 14:15:00'),
('Gayathri', 'Easy', 95, '2024-04-22 14:30:00', '2024-04-22 14:40:00'),
('Gayathri', 'Easy', 105, '2024-04-22 15:00:00', '2024-04-22 15:15:00'),
('Gayathri', 'Easy', 110, '2024-04-22 15:30:00', '2024-04-22 15:45:00'),
('Gayathri', 'Easy', 120, '2024-04-22 16:00:00', '2024-04-22 16:20:00'),
('Gayathri', 'Easy', 100, '2024-04-22 16:30:00', '2024-04-22 16:40:00'),
('Gayathri', 'Easy', 95, '2024-04-22 17:00:00', '2024-04-22 17:10:00'),
('Gayathri', 'Easy', 110, '2024-04-22 17:30:00', '2024-04-22 17:45:00'),
('Gayathri', 'Easy', 105, '2024-04-22 18:00:00', '2024-04-22 18:15:00'),
('Gayathri', 'Easy', 100, '2024-04-22 18:30:00', '2024-04-22 18:40:00'),
('Gayathri', 'Easy', 115, '2024-04-22 19:00:00', '2024-04-22 19:15:00'),
('Gayathri', 'Easy', 120, '2024-04-22 19:30:00', '2024-04-22 19:50:00');


SELECT Username,
Score,
TIMEDIFF(EndGame_Timestamp, StartGame_Timestamp) AS Duration
FROM Score WHERE Game_Level = "Easy" ORDER BY Score DESC,
TIMEDIFF(EndGame_Timestamp, StartGame_Timestamp) ASC LIMIT 8;

"SELECT StartGame_Timestamp, Score,
TIMEDIFF(EndGame_Timestamp, StartGame_Timestamp) AS Duration
FROM Score WHERE Game_Level = ? AND Username = ? ORDER BY StartGame_Timestamp DESC LIMIT 8;"