USE SicaVibe;

INSERT INTO Imagem (Nome, Data)
VALUES  ('SicaVibe Faro'              , LOAD_FILE('/var/lib/mysql-files/SicaVibeImgs/hotelFaro.jpg')),
        ('SicaVibe Porto'             , LOAD_FILE('/var/lib/mysql-files/SicaVibeImgs/hotelPorto.jpg')),
        ('SicaVibe Lisboa'            , LOAD_FILE('/var/lib/mysql-files/SicaVibeImgs/hotelLisboa.jpg')),
        ('SicaVibe Coimbra'           , LOAD_FILE('/var/lib/mysql-files/SicaVibeImgs/hotelCoimbra.jpg')),
        ('SicaVibe Single Room'       , LOAD_FILE('/var/lib/mysql-files/SicaVibeImgs/singleRoom.jpg')),
        ('SicaVibe Twin Room'         , LOAD_FILE('/var/lib/mysql-files/SicaVibeImgs/twinRoom.jpg')),
        ('SicaVibe Deluxe Room'       , LOAD_FILE('/var/lib/mysql-files/SicaVibeImgs/doubleRoom.jpg')),
        ('SicaVibe Presidential Suite', LOAD_FILE('/var/lib/mysql-files/SicaVibeImgs/presidentialRomm.jpg'));



INSERT INTO Hotel (ImagemID, Nome, Descricao, Endereco)
VALUES (1, 'SicaVibe Faro'  , 'a', 'Rua da Praia, 323, Faro, Portugal Faro'),
       (2, 'SicaVibe Porto' , 'a', 'Rua da Boavista, 123, Porto, Portugal'),
       (3, 'SicaVibe Lisboa', 'a', 'Rua Augusta, 789, Lisbon, Portugal'),
       (4, 'SicaVibe Coimbra', 'a', 'Rua Miguel Torga, 257, Coimbra, Portugal');

UPDATE Hotel
SET Descricao = 'Explore the enchantment of SicaVibe Faro, a contemporary hotel nestled in the heart of charming Faro, Portugal. Immerse yourself in modern comfort and local authenticity as you discover the captivating beauty of the Algarve region. Relax in our stylish and well-appointed rooms, designed to provide a tranquil haven after a day of exploration. Indulge in delectable cuisine at our on-site restaurant, showcasing a fusion of local and international flavors. Unwind and socialize in our inviting lounge area or take a refreshing dip in our sparkling outdoor pool. With a prime location near pristine beaches, historic sites, and lively markets, SicaVibe Faro offers the perfect gateway to discover the Algarves treasures.\nImmerse yourself in the coastal charm, from the scenic Ria Formosa to the captivating old town. Experience the vibrant energy and warm hospitality of Faro at SicaVibe, where modern comfort meets the authentic charm of the Algarve.'
WHERE ID = 1;

UPDATE Hotel
SET Descricao = 'Discover the allure of SicaVibe Porto, a modern hotel nestled in the heart of vibrant Porto, Portugal. Immerse yourself in contemporary comfort and local authenticity as you explore the rich cultural heritage of this captivating city. Unwind in our stylish and well-appointed rooms, designed to create a serene retreat amidst the bustling city. Indulge in delectable cuisine at our on-site restaurant, showcasing a fusion of local and international flavors. Relax and socialize in our vibrant lounge area, or soak up panoramic views from our rooftop terrace.\nImmerse yourself in the citys charm, from the historic Ribeira district to the famous port wine cellars. Our dedicated team is committed to ensuring your stay is exceptional, providing personalized service and local recommendations. Experience the vibrant energy and warm hospitality of Porto at SicaVibe, where modern comfort meets authentic Portuguese charm.'
WHERE ID = 2;

UPDATE Hotel
SET Descricao = 'Experience the allure of SicaVibe Lisboa, a contemporary hotel nestled in the heart of vibrant Lisbon, Portugal. Immerse yourself in modern comfort and local authenticity as you explore the rich history and vibrant culture of this captivating city. Relax in our stylish and well-appointed rooms, designed to provide a tranquil retreat amidst the urban energy. Indulge in delectable cuisine at our on-site restaurant, where a fusion of local and international flavors awaits. Unwind and socialize in our inviting lounge area, or take in panoramic views of the city from our rooftop terrace.\nImmerse yourself in the charm of the historic Alfama district, explore the vibrant nightlife of Bairro Alto, or discover the architectural wonders of Belém. Experience the vibrant energy and warm hospitality of Lisbon, where modern comfort meets the authentic charm of Portugals capital city.'
WHERE ID = 3;

UPDATE Hotel
SET Descricao = 'Experience the enchantment of SicaVibe Coimbra, a contemporary hotel nestled in the heart of vibrant Coimbra, Portugal. Immerse yourself in modern comfort and local authenticity as you explore the rich history and vibrant culture of this captivating city. Relax in our stylish and well-appointed rooms, designed to provide a tranquil retreat amidst the urban energy. Indulge in delectable cuisine at our on-site restaurant, where a fusion of local and international flavors awaits. Unwind and socialize in our inviting lounge area, or take in panoramic views of the city from our rooftop terrace.\nImmerse yourself in the charm of the historic Alfama district, explore the vibrant nightlife of Bairro Alto, or discover the architectural wonders of Belém. Experience the vibrant energy and warm hospitality of Coimbra, where modern comfort meets the authentic charm of Coimbra.'
WHERE ID = 4;




INSERT INTO Utilizador (HotelID, Email, Password, Salt, Nome, DataNascimento, NTelemovel, Morada, Cc, Nif, Estado, Discriminator)
VALUES (null, 'hospede1@example.com', '33e69e7270efae510fba1c24526a929a52b61dbfd290253bec70fd18a8ba8d80', 'cnqoqx', 'John Doe 1'     , '1990-01-01', '123456789', 'John Street nº5'  ,  '100100100', '100100100', null   , 'Hospede'),
       (null, 'hospede2@example.com', '33e69e7270efae510fba1c24526a929a52b61dbfd290253bec70fd18a8ba8d80', 'cnqoqx', 'John Doe 2'     , '1990-01-01', '123456789', 'John Street nº5'  ,  '100100101', '100100101', null   , 'Hospede'),
       (null, 'hospede3@example.com', '33e69e7270efae510fba1c24526a929a52b61dbfd290253bec70fd18a8ba8d80', 'cnqoqx', 'John Doe 3'     , '1990-01-01', '123456789', 'John Street nº5'  ,  '100100102', '100100102', null   , 'Hospede'),
       (null, 'hospede4@example.com', '33e69e7270efae510fba1c24526a929a52b61dbfd290253bec70fd18a8ba8d80', 'cnqoqx', 'John Doe 4'     , '1990-01-01', '123456789', 'John Street nº5'  ,  '100100103', '100100103', null   , 'Hospede'),
       (null, 'hospede5@example.com', '33e69e7270efae510fba1c24526a929a52b61dbfd290253bec70fd18a8ba8d80', 'cnqoqx', 'John Doe 5'     , '1990-01-01', '123456789', 'John Street nº5'  ,  '100100104', '100100104', null   , 'Hospede'),
       (null, 'hospede6@example.com', '33e69e7270efae510fba1c24526a929a52b61dbfd290253bec70fd18a8ba8d80', 'cnqoqx', 'John Doe 6'     , '1990-01-01', '123456789', 'John Street nº5'  ,  '100100105', '100100105', null   , 'Hospede'),
       (null, 'hospede7@example.com', '33e69e7270efae510fba1c24526a929a52b61dbfd290253bec70fd18a8ba8d80', 'cnqoqx', 'John Doe 7'     , '1990-01-01', '123456789', 'John Street nº5'  ,  '100100106', '100100106', null   , 'Hospede'),
       (null, 'hospede8@example.com', '33e69e7270efae510fba1c24526a929a52b61dbfd290253bec70fd18a8ba8d80', 'cnqoqx', 'John Doe 8'     , '1990-01-01', '123456789', 'John Street nº5'  ,  '100100107', '100100107', null   , 'Hospede'),
       (null, 'admin1@example.com'   , '33e69e7270efae510fba1c24526a929a52b61dbfd290253bec70fd18a8ba8d80', 'cnqoqx', 'Jane Smith 1'   , '1995-05-10', '987654321', 'Jane Street nº30' ,  '200200200', '200200200', null   , 'Administrador'),
       (null, 'admin2@example.com'   , '33e69e7270efae510fba1c24526a929a52b61dbfd290253bec70fd18a8ba8d80', 'cnqoqx', 'Jane Smith 2'   , '1995-05-10', '987654321', 'Jane Street nº30' ,  '200200201', '200200201', null   , 'Administrador'),
       (null, 'admin3@example.com'   , '33e69e7270efae510fba1c24526a929a52b61dbfd290253bec70fd18a8ba8d80', 'cnqoqx', 'Jane Smith 3'   , '1995-05-10', '987654321', 'Jane Street nº30' ,  '200200202', '200200202', null   , 'Administrador'),
       (1   , 'funcionario1@example.com'  , '33e69e7270efae510fba1c24526a929a52b61dbfd290253bec70fd18a8ba8d80', 'cnqoqx', 'Alice Johnson 1', '1988-12-25', '111111111', 'Alice Street nº10',  '300300300', '300300300', 'ATIVO', 'Funcionario'),
       (2   , 'funcionario2@example.com'  , '33e69e7270efae510fba1c24526a929a52b61dbfd290253bec70fd18a8ba8d80', 'cnqoqx', 'Alice Johnson 2', '1988-12-25', '111111111', 'Alice Street nº10',  '300300301', '300300301', 'ATIVO', 'Funcionario'),
       (3   , 'funcionario3@example.com'  , '33e69e7270efae510fba1c24526a929a52b61dbfd290253bec70fd18a8ba8d80', 'cnqoqx', 'Alice Johnson 3', '1988-12-25', '111111111', 'Alice Street nº10',  '300300302', '300300302', 'ATIVO', 'Funcionario'),
       (4   , 'funcionario4@example.com'  , '33e69e7270efae510fba1c24526a929a52b61dbfd290253bec70fd18a8ba8d80', 'cnqoqx', 'Alice Johnson 4', '1988-12-25', '111111111', 'Alice Street nº10',  '300300303', '300300303', 'ATIVO', 'Funcionario'),
       (2   , 'funcionario5@example.com'  , '33e69e7270efae510fba1c24526a929a52b61dbfd290253bec70fd18a8ba8d80', 'cnqoqx', 'Alice Johnson 5', '1988-12-25', '111111111', 'Alice Street nº10',  '300300304', '300300304', 'INATIVO', 'Funcionario'),
       (3   , 'funcionario6@example.com'  , '33e69e7270efae510fba1c24526a929a52b61dbfd290253bec70fd18a8ba8d80', 'cnqoqx', 'Alice Johnson 6', '1988-12-25', '111111111', 'Alice Street nº10',  '300300305', '300300305', 'EM_PAUSA', 'Funcionario');




INSERT INTO TipoDeQuarto (ImagemID, Nome, Capacidade, Preco, Descricao)
VALUES (5, 'Single Room', 1, 50.00, 'Welcome to our cozy single room, a comfortable retreat designed for solo travelers. Enjoy a restful nights sleep on a cozy bed, relax in a well-appointed space, and make use of modern amenities. Experience a tranquil and convenient stay in our inviting single room.'),
       (6, 'Twin Room', 2, 100.00, 'Our twin room offers comfort and functionality with a cozy ambiance. Rest peacefully on a comfortable bed, enjoy modern amenities, and refresh in the en-suite bathroom. Experience a delightful blend of comfort and convenience in our standard room.'),
       (7, 'Deluxe Room', 3, 150.00, 'Indulge in our deluxe room, where luxury meets relaxation. Experience spacious comfort, elegant decor, and upscale amenities. Unwind in style, enjoy the plush bedding, and rejuvenate in the lavish en-suite bathroom. Escape to a haven of tranquility in our deluxe room.'),
       (8, 'Presidential Suite', 4, 200.00, 'Indulge in luxury with our suite room, a haven of elegance and sophistication. Enjoy spacious accommodations, a separate living area, and upscale amenities. Retreat to a plush bedroom, relax in style, and experience the pinnacle of comfort and refinement in our exquisite suite room.');



INSERT INTO Quarto (HotelID, TipoDeQuartoID, NPorta, Estado)
VALUES  (1,1,101  ,'LIVRE'), (1,1,102  ,'LIVRE'), (1,1,103  ,'OCUPADO'),
        (1,1,104  ,'OCUPADO'), (1,1,201  ,'LIVRE'), (1,1,202  ,'POR_LIMPAR'),
        (1,2,105  ,'LIVRE'), (1,2,106  ,'LIVRE'), (1,2,203  ,'LIVRE'),
        (1,2,204  ,'POR_LIMPAR'), (1,2,205  ,'POR_LIMPAR'), (1,2,206  ,'OCUPADO'),
        (1,3,301  ,'OCUPADO'), (1,3,302  ,'LIVRE'), (1,3,303  ,'LIVRE'), (1,4,304  ,'LIVRE'),

        (2,1,101  ,'LIVRE'), (2,1,102  ,'LIVRE'), (2,1,103  ,'POR_LIMPAR'),
        (2,1,104  ,'POR_LIMPAR'), (2,1,201  ,'LIVRE'), (2,1,202  ,'LIVRE'),
        (2,2,105  ,'LIVRE'), (2,2,106  ,'POR_LIMPAR'), (2,2,203  ,'LIVRE'),
        (2,2,204  ,'OCUPADO'), (2,2,205  ,'LIVRE'), (2,2,206  ,'LIVRE'),
        (2,3,301  ,'LIVRE'), (2,3,302  ,'LIVRE'), (2,3,303  ,'POR_LIMPAR'), (2,3,304  ,'LIVRE'),

        (3,1,101  ,'LIVRE'), (3,1,102  ,'LIVRE'), (3,1,103  ,'LIVRE'),
        (3,1,104  ,'POR_LIMPAR'), (3,1,201  ,'LIVRE'), (3,1,202  ,'LIVRE'),
        (3,2,105  ,'LIVRE'), (3,2,106  ,'POR_LIMPAR'), (3,2,203  ,'LIVRE'),
        (3,2,204  ,'POR_LIMPAR'), (3,2,205  ,'LIVRE'), (3,2,206  ,'POR_LIMPAR'),
        (3,3,301  ,'LIVRE'), (3,3,302  ,'LIVRE'), (3,3,303  ,'LIVRE'), (3,4,304  ,'POR_LIMPAR'),

        (4,1,101  ,'LIVRE'), (4,1,102  ,'LIVRE'), (4,1,103  ,'LIVRE'),
        (4,1,104  ,'LIVRE'), (4,1,201  ,'POR_LIMPAR'), (4,1,202  ,'LIVRE'),
        (4,2,105  ,'POR_LIMPAR'), (4,2,106  ,'LIVRE'), (4,2,203  ,'LIVRE'),
        (4,2,204  ,'LIVRE'), (4,2,205  ,'POR_LIMPAR'), (4,2,206  ,'POR_LIMPAR'),
        (4,3,301  ,'LIVRE'), (4,3,302  ,'LIVRE'), (4,3,303  ,'LIVRE'), (4,3,304  ,'LIVRE');




INSERT INTO Reserva (UtilizadorID, HotelID, DataEntrada, DataSaida, DataCheckIn, DataCheckout, Preco, Estado)
VALUES (1, 1, '2023-07-23', '2023-07-30', null, null, 365.00, 'MARCADA'),
       (1, 1, '2023-06-12', '2023-06-16', '2023-06-12 14:00:00', '2023-06-16 11:00:00', 210.00, 'TERMINADA'),
       (1, 2, '2023-06-12', '2023-06-16', null, null, 200.00, 'CANCELADA'),

       (2, 3, '2023-06-26', '2023-06-30', null, null, 815.00, 'MARCADA'),
       (2, 4, '2023-06-16', '2023-06-20', '2023-06-16 14:00:00', '2023-06-20 11:00:00', 400.00, 'TERMINADA'),
       (2, 4, '2023-06-05', '2023-06-07', '2023-06-05 14:00:00', '2023-06-07 11:00:00', 400.00, 'TERMINADA'),

       (3, 2, '2023-06-20', '2023-06-26', '2023-06-20 14:00:00', null, 600.00, 'A_DECORRER'),
       (3, 3, '2023-06-16', '2023-06-22',  null, null, 400.00, 'CANCELADA'),

       (4, 1, '2023-06-26', '2023-06-30',  null, null, 200.00, 'MARCADA'),

       (5, 1, '2023-06-22', '2023-06-29', '2023-06-22 12:00:00', null, 1425.00, 'A_DECORRER'),
       (5, 1, '2023-06-02', '2023-06-06', '2023-06-02 14:00:00', '2023-06-06 11:00:00', 410.00, 'TERMINADA'),
       (5, 1, '2023-06-10', '2023-06-14', '2023-06-10 14:00:00', '2023-06-14 11:00:00', 410.00, 'TERMINADA');



INSERT INTO ServicoExtra (Nome, Preco)
VALUES ('Breakfast', 15.00),
       ('Parking', 10.00),
       ('Gym Access', 20.00),
       ('Laundry Service', 10.00),
       ('Spa',40.00),
       ('Pool Access',25.00);



INSERT INTO Hotel_ServicoExtra (HotelID, ServicoExtraID)
VALUES (1, 1),(1, 2),(1, 4),(1, 5),(1, 6),
       (2, 1),(2, 2),(2, 4),(2, 3),
       (3, 1),(3, 2),(3, 4),(3, 3),
       (4, 1),(4, 2),(4, 4),(4, 5);



INSERT INTO Reserva_Quarto (ReservaID, QuartoID)
VALUES (1, 3),(1, 4),
       (2, 7),
       (3, 18),

       (4, 36),(4, 37),
       (5, 52),
       (6, 60),(6, 61),(6, 62),

       (7, 28),
       (8, 40),

       (9, 14),

       (10, 12),(10, 13),
       (11, 7),
       (12, 22);


INSERT INTO Reserva_ServicoExtra (ReservaID, ServicoExtraID)
VALUES (1, 5),(1, 6),
       (2, 1),
       (4, 1),(4, 2),
       (6, 3),(6, 4),(6, 5),
       (10, 2),
       (12, 4);
