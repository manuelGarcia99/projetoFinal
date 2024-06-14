CREATE TABLE Cartas(
    ID INT AUTO_INCREMENT,
    Pergunta VARCHAR(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
    Resposta VARCHAR(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
    IntervaloAnterior INT NULL,
    OrdemDaRepeticao INT  NULL,
    EF DECIMAL(10,2) NOT NULL,
    DataUltimoUso DATETIME NULL,
    Def1 VARCHAR(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL,
    Def2 VARCHAR(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL,
    NomeBaralho VARCHAR(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
    Intervalo INT  NULL,
    PrimeiroTermo VARCHAR(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL,
    SegundoTermo VARCHAR(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL,
    PRIMARY KEY (ID)
) DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

SELECT EF ,Intervalo FROM cartas WHERE NomeBaralho = 'Teste10v6';

DROP TABLE Cartas;

SELECT user();

ALTER USER 'root'@'localhost' IDENTIFIED BY 'SimpsonsTheMovie2012';
FLUSH PRIVILEGES;

ALTER TABLE cartas MODIFY COLUMN EF DECIMAL(10, 2);

show variables;

SHOW DATABASES;