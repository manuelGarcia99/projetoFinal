CREATE TABLE Baralhos(
NomeBaralho VARCHAR(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
PRIMARY KEY(NomeBaralho)
);

INSERT INTO Baralhos (NomeBaralho) VALUES ('SampleDeck1'), ('SampleDeck2'), ('SampleDeck3');

SELECT * FROM Baralhos;



TRUNCATE  Baralhos;