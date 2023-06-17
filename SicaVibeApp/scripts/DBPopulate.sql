USE SicaVibe;

INSERT INTO Imagem (Nome, Data)
VALUES  ('SicaVibe Faro'              , LOAD_FILE('/var/lib/mysql-files/SicaVibeImgs/hotelFaro.jpg')),
        ('SicaVibe Porto'             , LOAD_FILE('/var/lib/mysql-files/SicaVibeImgs/hotelPorto.jpg')),
        ('SicaVibe Lisboa'            , LOAD_FILE('/var/lib/mysql-files/SicaVibeImgs/hotelLisboa.jpg')),
        ('SicaVibe Single Room'       , LOAD_FILE('/var/lib/mysql-files/SicaVibeImgs/singleRoom.jpg')),
        ('SicaVibe Twin Room'         , LOAD_FILE('/var/lib/mysql-files/SicaVibeImgs/twinRoom.jpg')),
        ('SicaVibe Deluxe Room'       , LOAD_FILE('/var/lib/mysql-files/SicaVibeImgs/doubleRoom.jpg')),
        ('SicaVibe Presidential Suite', LOAD_FILE('/var/lib/mysql-files/SicaVibeImgs/presidentialRoom.jpg'));



INSERT INTO Hotel (ImagemID, Nome, Descricao, Endereco)
VALUES (1, 'SicaVibe Faro'  , 'a', 'Rua da Praia, 323, Faro, Portugal Faro'),
       (2, 'SicaVibe Porto' , 'a', 'Rua da Boavista, 123, Porto, Portugal'),
       (3, 'SicaVibe Lisboa', 'a', 'Rua Augusta, 789, Lisbon, Portugal');

UPDATE Hotel
SET Descricao = 'Discover the allure of SicaVibe Porto, a modern hotel nestled in the heart of vibrant Porto, Portugal. Immerse yourself in contemporary comfort and local authenticity as you explore the rich cultural heritage of this captivating city. Unwind in our stylish and well-appointed rooms, designed to create a serene retreat amidst the bustling city. Indulge in delectable cuisine at our on-site restaurant, showcasing a fusion of local and international flavors. Relax and socialize in our vibrant lounge area, or soak up panoramic views from our rooftop terrace.\nImmerse yourself in the citys charm, from the historic Ribeira district to the famous port wine cellars. Our dedicated team is committed to ensuring your stay is exceptional, providing personalized service and local recommendations. Experience the vibrant energy and warm hospitality of Porto at SicaVibe, where modern comfort meets authentic Portuguese charm.'
WHERE ID = 2;

UPDATE Hotel
SET Descricao = 'Explore the enchantment of SicaVibe Faro, a contemporary hotel nestled in the heart of charming Faro, Portugal. Immerse yourself in modern comfort and local authenticity as you discover the captivating beauty of the Algarve region. Relax in our stylish and well-appointed rooms, designed to provide a tranquil haven after a day of exploration. Indulge in delectable cuisine at our on-site restaurant, showcasing a fusion of local and international flavors. Unwind and socialize in our inviting lounge area or take a refreshing dip in our sparkling outdoor pool. With a prime location near pristine beaches, historic sites, and lively markets, SicaVibe Faro offers the perfect gateway to discover the Algarves treasures.\nImmerse yourself in the coastal charm, from the scenic Ria Formosa to the captivating old town. Experience the vibrant energy and warm hospitality of Faro at SicaVibe, where modern comfort meets the authentic charm of the Algarve.'
WHERE ID = 1;

UPDATE Hotel
SET Descricao = 'Experience the allure of SicaVibe Lisboa, a contemporary hotel nestled in the heart of vibrant Lisbon, Portugal. Immerse yourself in modern comfort and local authenticity as you explore the rich history and vibrant culture of this captivating city. Relax in our stylish and well-appointed rooms, designed to provide a tranquil retreat amidst the urban energy. Indulge in delectable cuisine at our on-site restaurant, where a fusion of local and international flavors awaits. Unwind and socialize in our inviting lounge area, or take in panoramic views of the city from our rooftop terrace.\nImmerse yourself in the charm of the historic Alfama district, explore the vibrant nightlife of Bairro Alto, or discover the architectural wonders of Belém. Experience the vibrant energy and warm hospitality of Lisbon, where modern comfort meets the authentic charm of Portugals capital city.'
WHERE ID = 3;




INSERT INTO Utilizador (HotelID, Email, Password, Salt, Nome, DataNascimento, NTelemovel, Morada, Cc, Nif, Estado, Discriminator)
VALUES (null, 'hospede@example.com', '33e69e7270efae510fba1c24526a929a52b61dbfd290253bec70fd18a8ba8d80', 'cnqoqx', 'John Doe'     , '1990-01-01', '123456789', 'John Street nº5'  ,  '123123123', '111111111', null   , 'Hospede'),
       (null, 'jane@example.com'   , '33e69e7270efae510fba1c24526a929a52b61dbfd290253bec70fd18a8ba8d80', 'cnqoqx', 'Jane Smith'   , '1995-05-10', '987654321', 'Jane Street nº30' ,  '321321321', '222222222', null   , 'Administador'),
       (1   , 'alice@example.com'  , '33e69e7270efae510fba1c24526a929a52b61dbfd290253bec70fd18a8ba8d80', 'cnqoqx', 'Alice Johnson', '1988-12-25', '111111111', 'Alice Street nº10',  '456456456', '333333333', 'ATIVO', 'Funcionario');



INSERT INTO TipoDeQuarto (ImagemID, Nome, Capacidade, Preco, Descricao)
VALUES (4, 'Single Room', 1, 50.00, 'Welcome to our cozy single room, a comfortable retreat designed for solo travelers. Enjoy a restful nights sleep on a cozy bed, relax in a well-appointed space, and make use of modern amenities. Experience a tranquil and convenient stay in our inviting single room.'),
       (5, 'Twin Room', 2, 100.00, 'Our twin room offers comfort and functionality with a cozy ambiance. Rest peacefully on a comfortable bed, enjoy modern amenities, and refresh in the en-suite bathroom. Experience a delightful blend of comfort and convenience in our standard room.'),
       (6, 'Deluxe Room', 3, 150.00, 'Indulge in our deluxe room, where luxury meets relaxation. Experience spacious comfort, elegant decor, and upscale amenities. Unwind in style, enjoy the plush bedding, and rejuvenate in the lavish en-suite bathroom. Escape to a haven of tranquility in our deluxe room.'),
       (7, 'Presidential Suite', 4, 200.00, 'Indulge in luxury with our suite room, a haven of elegance and sophistication. Enjoy spacious accommodations, a separate living area, and upscale amenities. Retreat to a plush bedroom, relax in style, and experience the pinnacle of comfort and refinement in our exquisite suite room.');



INSERT INTO Quarto (TipoDeQuartoID, HotelID, NPorta, Estado)
VALUES  (1,1,1  ,'LIVRE'), 
        (1,1,2  ,'LIVRE'), 
        (1,1,3  ,'OCUPADO'), 
        (2,1,10 ,'OCUPADO'),
        (2,1,11 ,'LIVRE'),
        (2,1,12 ,'LIVRE'),
        (2,1,13 ,'POR_LIMPAR'),
        (3,1,20 ,'POR_LIMPAR'),
        (3,1,21 ,'LIVRE'),
        (3,1,22 ,'LIVRE'),
        (3,1,23 ,'OCUPADO'),
        (3,1,24 ,'OCUPADO'), 
        (1,2,1  ,'LIVRE'), 
        (1,2,2  ,'LIVRE'), 
        (1,2,3  ,'LIVRE'), 
        (1,2,4  ,'LIVRE'), 
        (1,2,5  ,'OCUPADO'), 
        (1,2,6  ,'LIVRE'), 
        (1,2,7  ,'OCUPADO'), 
        (2,2,10 ,'OCUPADO'),
        (2,2,11 ,'LIVRE'),
        (2,2,12 ,'LIVRE'),
        (2,2,13 ,'POR_LIMPAR'),
        (3,2,20 ,'POR_LIMPAR'),
        (3,2,21 ,'LIVRE'),
        (3,2,22 ,'LIVRE'),
        (3,2,23 ,'OCUPADO'),
        (3,2,24 ,'OCUPADO'), 
        (3,2,100,'LIVRE'),
        (1,3,1  ,'LIVRE'), 
        (1,3,2  ,'LIVRE'), 
        (1,3,3  ,'OCUPADO'), 
        (2,3,10 ,'OCUPADO'),
        (2,3,11 ,'LIVRE'),
        (2,3,12 ,'LIVRE'),
        (2,3,13 ,'POR_LIMPAR'),
        (3,3,20 ,'POR_LIMPAR'),
        (3,3,21 ,'LIVRE'),
        (3,3,22 ,'LIVRE'),
        (3,3,23 ,'OCUPADO'),
        (3,3,24 ,'OCUPADO'), 
        (3,3,100,'LIVRE'),
        (3,3,101,'OCUPADO');



INSERT INTO Reserva (UtilizadorID, HotelID, DataEntrada, DataSaida, DataCheckIn, DataCheckout, Preco, Estado)
VALUES (1, 1, '2023-06-17', '2023-06-20', '2023-06-17 12:00:00', '2023-06-20 10:00:00', 50.00, 'MARCADA'),
       (1, 1, '2023-06-18', '2023-06-22', '2023-06-18 14:00:00', '2023-06-22 11:00:00', 100.00, 'A_DECORRER'),
       (1, 2, '2023-06-18', '2023-06-22', '2023-06-18 14:00:00', '2023-06-22 11:00:00', 150.00, 'CANCELADA'),
       (1, 2, '2023-06-18', '2023-06-22', '2023-06-18 14:00:00', '2023-06-22 11:00:00', 200.00, 'TERMINADA');



INSERT INTO ServicoExtra (Nome, Preco)
VALUES ('Breakfast', 15.00),
       ('Parking', 10.00),
       ('Gym Access', 20.00),
       ('Laundry Service', 25.00);



INSERT INTO Hotel_ServicoExtra (HotelID, ServicoExtraID)
VALUES (1, 1),
       (1, 2),
       (2, 1),
       (2, 2),
       (2, 3),
       (3, 1),
       (3, 2),
       (3, 3),
       (3, 4);



INSERT INTO Reserva_Quarto (ReservaID, QuartoID)
VALUES (1, 1),
       (2, 2),
       (3, 3),
       (4, 4);



INSERT INTO Reserva_ServicoExtra (ReservaID, ServicoExtraID)
VALUES (1, 1),
       (2, 2),
       (3, 3),
       (4, 4);
