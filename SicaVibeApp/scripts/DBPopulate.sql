USE SicaVibe;
INSERT INTO Hotel (Nome, Descricao, Img, Endereco)
VALUES ('SicaVibe Faro', 'Description Faro', LOAD_FILE('/var/lib/mysql-files/SicaVibeImgs/hotelFaro.jpg'), 'Address Faro'),
       ('SicaVibe Porto', 'Description Porto', LOAD_FILE('/var/lib/mysql-files/SicaVibeImgs/hotelPorto.jpg'), 'Address Porto'),
       ('SicaVibe Lisboa', 'Description Lisboa', LOAD_FILE('/var/lib/mysql-files/SicaVibeImgs/hotelLisboa.jpg'), 'Address Lisboa');


INSERT INTO Hospede (Email, Password, Nome, DataNascimento, Morada, NTelemovel, Cc, Nif)
VALUES ('email1@example.com', 'password1', 'John Doe', '1990-01-01', 'Address 1', '123456789', 'CC123', 'NIF123'),
       ('email2@example.com', 'password2', 'Jane Smith', '1995-05-10', 'Address 2', '987654321', 'CC456', 'NIF456'),
       ('email3@example.com', 'password3', 'Alice Johnson', '1988-12-25', 'Address 3', '111111111', 'CC789', 'NIF789');


INSERT INTO TipoDeQuarto (Nome, Capacidade, Preco, Descricao, Img)
VALUES ('Standard Room', 2, 100.00, 'Standard room description', LOAD_FILE('/var/lib/mysql-files/SicaVibeImgs/hotelFaro.jpg')),
       ('Deluxe Room', 3, 150.00, 'Deluxe room description', LOAD_FILE('/var/lib/mysql-files/SicaVibeImgs/hotelFaro.jpg')),
       ('Suite', 4, 200.00, 'Suite description', LOAD_FILE('/var/lib/mysql-files/SicaVibeImgs/hotelFaro.jpg'));


INSERT INTO Quarto (TipoDeQuartoID, HotelID, NPorta, Estado)
SELECT
  (SELECT ID FROM TipoDeQuarto ORDER BY RAND() LIMIT 1),
  (SELECT ID FROM Hotel ORDER BY RAND() LIMIT 1),
  FLOOR(1 + RAND() * 100),
  CASE FLOOR(1 + RAND() * 3)
    WHEN 1 THEN 'LIVRE'
    WHEN 2 THEN 'OCUPADO'
    WHEN 3 THEN 'POR_LIMPAR'
  END
FROM
  (SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3) numbers;



INSERT INTO Reserva (HospedeID, HotelID, DataEntrada, DataSaida, DataCheckIn, DataCheckout, Preco)
SELECT
  (SELECT ID FROM Hospede ORDER BY RAND() LIMIT 1),
  (SELECT ID FROM Hotel ORDER BY RAND() LIMIT 1),
  CURDATE() + INTERVAL FLOOR(1 + RAND() * 10) DAY,
  CURDATE() + INTERVAL FLOOR(11 + RAND() * 20) DAY,
  CURDATE() + INTERVAL FLOOR(1 + RAND() * 5) DAY,
  CURDATE() + INTERVAL FLOOR(6 + RAND() * 10) DAY,
  FLOOR(50 + RAND() * 150)
FROM
  (SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3) numbers;



INSERT INTO Funcionario (HotelID, Email, Password, Nome, DataNascimento, Morada, NTelemovel, Estado)
SELECT
  (SELECT ID FROM Hotel ORDER BY RAND() LIMIT 1),
  CONCAT('employee', numbers.num, '@example.com'),
  CONCAT('password', numbers.num),
  CONCAT('Employee', numbers.num),
  CURDATE() - INTERVAL FLOOR(20 + RAND() * 30) YEAR,
  CONCAT('Address ', numbers.num),
  CONCAT('9', FLOOR(RAND() * 9) + 1, FLOOR(RAND() * 10000000)),
  CASE FLOOR(1 + RAND() * 3)
    WHEN 1 THEN 'ATIVO'
    WHEN 2 THEN 'INATIVO'
    WHEN 3 THEN 'EM_PAUSA'
  END
FROM
  (SELECT 1 AS num UNION ALL SELECT 2 AS num UNION ALL SELECT 3 AS num) numbers;



INSERT INTO ServicoExtra (Nome, Preco)
VALUES ('Extra Service 1', 10.00),
       ('Extra Service 2', 20.00),
       ('Extra Service 3', 30.00);



INSERT INTO Hotel_ServicoExtra (HotelID, ServicoExtraID)
SELECT
  (SELECT ID FROM Hotel ORDER BY RAND() LIMIT 1),
  (SELECT ID FROM ServicoExtra ORDER BY RAND() LIMIT 1)
FROM
  (SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3) numbers;



INSERT INTO Hotel_TipoDeQuarto (HotelID, TipoDeQuartoID)
SELECT
  (SELECT ID FROM Hotel ORDER BY RAND() LIMIT 1),
  (SELECT ID FROM TipoDeQuarto ORDER BY RAND() LIMIT 1)
FROM
  (SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3) numbers;



INSERT INTO Reserva_Quarto (ReservaID, QuartoID)
SELECT
  (SELECT ID FROM Reserva ORDER BY RAND() LIMIT 1),
  (SELECT ID FROM Quarto ORDER BY RAND() LIMIT 1)
FROM
  (SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3) numbers;



INSERT INTO Reserva_ServicoExtra (ReservaID, ServicoExtraID)
SELECT
  (SELECT ID FROM Reserva ORDER BY RAND() LIMIT 1),
  (SELECT ID FROM ServicoExtra ORDER BY RAND() LIMIT 1)
FROM
  (SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3) numbers;
