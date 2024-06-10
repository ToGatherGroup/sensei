CREATE TABLE IF NOT EXISTS classificacao_vo2_tb (
      id BIGINT NOT NULL,
      classificacao VARCHAR(255),
      idade_min INT,
      idade_max INT,
      resultado_min DOUBLE PRECISION,
      resultado_max DOUBLE PRECISION,
      sexo CHAR(1),
      PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS classificacao_abdominais_tb (
    id BIGINT NOT NULL,
    classificacao VARCHAR(255),
    idade_min INT,
    idade_max INT,
    resultado_min INT,
    resultado_max INT,
    sexo CHAR(1),
    PRIMARY KEY (id)
);

-- Inicia uma transação para garantir a atomicidade das operações
START TRANSACTION;

-- Dados para Mulheres (sexo = 'F')
INSERT IGNORE INTO classificacao_vo2_tb (id, classificacao, idade_min, idade_max, resultado_min, resultado_max, sexo) VALUES
    (1, 'Muito Fraca', 13, 19, 0, 25.0, 'F'),
    (2, 'Fraca', 13, 19, 25.1, 30.9, 'F'),
    (3, 'Regular', 13, 19, 31.0, 34.9, 'F'),
    (4, 'Boa', 13, 19, 35.0, 38.9, 'F'),
    (5, 'Excelente', 13, 19, 39.0, 41.9, 'F'),
    (6, 'Superior', 13, 19, 42.0, 100, 'F'),
    (7, 'Muito Fraca', 20, 29, 0, 23.6, 'F'),
    (8, 'Fraca', 20, 29, 23.7, 28.9, 'F'),
    (9, 'Regular', 20, 29, 29.0, 32.9, 'F'),
    (10, 'Boa', 20, 29, 33.0, 36.9, 'F'),
    (11, 'Excelente', 20, 29, 37.0, 40.9, 'F'),
    (12, 'Superior', 20, 29, 41.0, 100, 'F'),
    (13, 'Muito Fraca', 30, 39, 0, 22.8, 'F'),
    (14, 'Fraca', 30, 39, 22.9, 26.9, 'F'),
    (15, 'Regular', 30, 39, 27.0, 31.4, 'F'),
    (16, 'Boa', 30, 39, 31.5, 35.6, 'F'),
    (17, 'Excelente', 30, 39, 35.7, 40.0, 'F'),
    (18, 'Superior', 30, 39, 40.1, 100, 'F'),
    (19, 'Muito Fraca', 40, 49, 0, 21.0, 'F'),
    (20, 'Fraca', 40, 49, 21.1, 24.4, 'F'),
    (21, 'Regular', 40, 49, 24.5, 28.9, 'F'),
    (22, 'Boa', 40, 49, 29.0, 32.8, 'F'),
    (23, 'Excelente', 40, 49, 32.9, 36.9, 'F'),
    (24, 'Superior', 40, 49, 37.0, 100, 'F'),
    (25, 'Muito Fraca', 50, 59, 0, 20.2, 'F'),
    (26, 'Fraca', 50, 59, 20.3, 22.7, 'F'),
    (27, 'Regular', 50, 59, 22.8, 26.9, 'F'),
    (28, 'Boa', 50, 59, 27.0, 31.4, 'F'),
    (29, 'Excelente', 50, 59, 31.5, 35.7, 'F'),
    (30, 'Superior', 50, 59, 35.8, 100, 'F'),
    (31, 'Muito Fraca', 60, 150, 0, 17.5, 'F'),
    (32, 'Fraca', 60, 150, 17.6, 20.1, 'F'),
    (33, 'Regular', 60, 150, 20.2, 24.4, 'F'),
    (34, 'Boa', 60, 150, 24.5, 30.2, 'F'),
    (35, 'Excelente', 60, 150, 30.3, 31.4, 'F'),
    (36, 'Superior', 60, 150, 31.5, 100, 'F');

-- Dados para Homens (sexo = 'M')
INSERT IGNORE INTO classificacao_vo2_tb (id, classificacao, idade_min, idade_max, resultado_min, resultado_max, sexo) VALUES
    (37, 'Muito Fraca', 13, 19, 0, 35.0, 'M'),
    (38, 'Fraca', 13, 19, 35.1, 38.3, 'M'),
    (39, 'Regular', 13, 19, 38.4, 45.1, 'M'),
    (40, 'Boa', 13, 19, 45.2, 50.9, 'M'),
    (41, 'Excelente', 13, 19, 51.0, 55.9, 'M'),
    (42, 'Superior', 13, 19, 56.0, 100, 'M'),
    (43, 'Muito Fraca', 20, 29, 0, 33.0, 'M'),
    (44, 'Fraca', 20, 29, 33.1, 36.4, 'M'),
    (45, 'Regular', 20, 29, 36.5, 42.4, 'M'),
    (46, 'Boa', 20, 29, 42.5, 46.4, 'M'),
    (47, 'Excelente', 20, 29, 46.5, 52.4, 'M'),
    (48, 'Superior', 20, 29, 52.5, 100, 'M'),
    (49, 'Muito Fraca', 30, 39, 0, 31.5, 'M'),
    (50, 'Fraca', 30, 39, 31.6, 35.4, 'M'),
    (51, 'Regular', 30, 39, 35.5, 40.9, 'M'),
    (52, 'Boa', 30, 39, 41.0, 45.0, 'M'),
    (53, 'Excelente', 30, 39, 45.1, 49.9, 'M'),
    (54, 'Superior', 30, 39, 50.0, 100, 'M'),
    (55, 'Muito Fraca', 40, 49, 0, 30.2, 'M'),
    (56, 'Fraca', 40, 49, 30.3, 33.5, 'M'),
    (57, 'Regular', 40, 49, 33.6, 38.9, 'M'),
    (58, 'Boa', 40, 49, 39.0, 43.7, 'M'),
    (59, 'Excelente', 40, 49, 43.8, 48.0, 'M'),
    (60, 'Superior', 40, 49, 48.1, 100, 'M'),
    (61, 'Muito Fraca', 50, 59, 0, 26.1, 'M'),
    (62, 'Fraca', 50, 59, 26.2, 30.1, 'M'),
    (63, 'Regular', 50, 59, 30.2, 35.7, 'M'),
    (64, 'Boa', 50, 59, 35.8, 41.0, 'M'),
    (65, 'Excelente', 50, 59, 41.1, 45.0, 'M'),
    (66, 'Superior', 50, 59, 45.1, 100, 'M'),
    (67, 'Muito Fraca', 60, 150, 0, 20.5, 'M'),
    (68, 'Fraca', 60, 150, 20.6, 26.0, 'M'),
    (69, 'Regular', 60, 150, 26.1, 32.3, 'M'),
    (70, 'Boa', 60, 150, 32.4, 36.3, 'M'),
    (71, 'Excelente', 60, 150, 36.4, 44.2, 'M'),
    (72, 'Superior', 60, 150, 44.3, 100, 'M');

-- Tabela classificacao Abdominais
-- Dados para Homens (sexo = 'M')
INSERT IGNORE INTO classificacao_abdominais_tb (id, classificacao, idade_min, idade_max, resultado_min, resultado_max, sexo) VALUES
	(1, 'Excelente', 15, 19, 48, 100, 'M'),
	(2, 'Acima da média', 15, 19, 42, 47, 'M'),
	(3, 'Média', 15, 19, 38, 41, 'M'),
	(4, 'Abaixo da média', 15, 19, 33, 37, 'M'),
	(5, 'Fraco', 15, 19, 0, 32, 'M'),

	(6, 'Excelente', 20, 29, 43, 100, 'M'),
	(7, 'Acima da média', 20, 29, 37, 42, 'M'),
	(8, 'Média', 20, 29, 33, 36, 'M'),
	(9, 'Abaixo da média', 20, 29, 29, 32, 'M'),
	(10, 'Fraco', 20, 29, 0, 28, 'M'),

	(11, 'Excelente', 30, 39, 36, 100, 'M'),
	(12, 'Acima da média', 30, 39, 31, 35, 'M'),
	(13, 'Média', 30, 39, 27, 30, 'M'),
	(14, 'Abaixo da média', 30, 39, 22, 26, 'M'),
	(15, 'Fraco', 30, 39, 0, 21, 'M'),

	(16, 'Excelente', 40, 49, 31, 100, 'M'),
	(17, 'Acima da média', 40, 49, 26, 30, 'M'),
	(18, 'Média', 40, 49, 22, 25, 'M'),
	(19, 'Abaixo da média', 40, 49, 17, 21, 'M'),
	(20, 'Fraco', 40, 49, 0, 16, 'M'),

	(21, 'Excelente', 50, 59, 26, 100, 'M'),
	(22, 'Acima da média', 50, 59, 22, 25, 'M'),
	(23, 'Média', 50, 59, 18, 21, 'M'),
	(24, 'Abaixo da média', 50, 59, 13, 17, 'M'),
	(25, 'Fraco', 50, 59, 0, 12, 'M'),

	(26, 'Excelente', 60, 69, 23, 100, 'M'),
	(27, 'Acima da média', 60, 69, 17, 22, 'M'),
	(28, 'Média', 60, 69, 12, 16, 'M'),
	(29, 'Abaixo da média', 60, 69, 7, 11, 'M'),
	(30, 'Fraco', 60, 69, 0, 6, 'M'),

-- Dados para Mulheres (sexo = 'F')
	(31, 'Excelente', 15, 19, 42, 100, 'F'),
	(32, 'Acima da média', 15, 19, 36, 41, 'F'),
	(33, 'Média', 15, 19, 32, 35, 'F'),
	(34, 'Abaixo da média', 15, 19, 27, 31, 'F'),
	(35, 'Fraco', 15, 19, 0, 26, 'F'),

	(36, 'Excelente', 20, 29, 36, 100, 'F'),
	(37, 'Acima da média', 20, 29, 31, 35, 'F'),
	(38, 'Média', 20, 29, 25, 30, 'F'),
	(39, 'Abaixo da média', 20, 29, 21, 24, 'F'),
	(40, 'Fraco', 20, 29, 0, 20, 'F'),

	(41, 'Excelente', 30, 39, 29, 100, 'F'),
	(42, 'Acima da média', 30, 39, 24, 28, 'F'),
	(43, 'Média', 30, 39, 20, 23, 'F'),
	(44, 'Abaixo da média', 30, 39, 15, 19, 'F'),
	(45, 'Fraco', 30, 39, 0, 14, 'F'),

	(46, 'Excelente', 40, 49, 25, 100, 'F'),
	(47, 'Acima da média', 40, 49, 20, 24, 'F'),
	(48, 'Média', 40, 49, 15, 19, 'F'),
	(49, 'Abaixo da média', 40, 49, 7, 14, 'F'),
	(50, 'Fraco', 40, 49, 0, 6, 'F'),

	(51, 'Excelente', 50, 59, 19, 100, 'F'),
	(52, 'Acima da média', 50, 59, 12, 18, 'F'),
	(53, 'Média', 50, 59, 5, 11, 'F'),
	(54, 'Abaixo da média', 50, 59, 3, 4, 'F'),
	(55, 'Fraco', 50, 59, 0, 2, 'F'),

	(56, 'Excelente', 60, 69, 16, 100, 'F'),
	(57, 'Acima da média', 60, 69, 12, 15, 'F'),
	(58, 'Média', 60, 69, 4, 11, 'F'),
	(59, 'Abaixo da média', 60, 69, 2, 3, 'F'),
	(60, 'Fraco', 60, 69, 0, 1, 'F');

-- Confirma a transação
COMMIT;