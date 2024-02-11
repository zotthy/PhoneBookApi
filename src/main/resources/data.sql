INSERT INTO phonebook ( name, surname, city, street, buildnumber,aprove ,numbertel)
VALUES ( 'John',          'Doe',          'Warszawa',     'Aleje Jerozolimskie',     123, true , 48890123321),
       ( 'Alex',          'Doe',          'Kraków',       'Rynek Główny',            456, true , 48223244554),
       ( 'Alice',         'Smith',        'Gdańsk',       'Długa',                   789, true , 48345632312),
       ( 'Bob',           'Johnson',      'Wrocław',      'Świdnicka',               101, true , 48453232323),
       ( 'Emily',         'Anderson',     'Poznań',       'Stary Rynek',              02, false, 48567831231),
       ( 'Michael',       'Taylor',       'Szczecin',     'Monte Cassino',           303, true , 48344343443),
       ( 'Jane',          'Brown',        'Łódź',         'Piotrkowska',             404, true , 48734532134),
       ( 'John',          'Smith',        'Kraków',       'Floriańska',              505, true , 48345643432),
       ( 'Alice',         'Taylor',       'Warszawa',     'Nowy Świat',              606, true , 48567423422),
       ( 'Bob',          'Anderson',     'Gdańsk',       'Mariacka',                 707, true , 48233757567),
       ( 'Jan',          'Nowak',        'Gdynia',       'Kosciuszki',               808, false, 48244456544),
       ( 'Anna',         'Kowalczyk',    'Płock',        'Sienkiewicza',             909, true , 48354353453),
       ( 'Piotr',        'Wójcik',       'Bydgoszcz',    'Dworcowa',                 111, false, 48466622234),
       ( 'Katarzyna',    'Kowalska',     'Katowice',     'Mariacka',                 222, true , 48777432543),
       ( 'Michał',       'Lewandowski',  'Białystok',    'Lipowa',                   333, false, 48668843444),
       ( 'Alicja',       'Zielińska',    'Radom',        'Narutowicza',              444, true , 48911111113),
       ( 'Bartosz',      'Pawlak',       'Olsztyn',      'Dworcowa',                 555, false, 48888022233),
       ( 'Kamila',       'Jankowska',    'Zielona Góra', 'Słowiańska',               666, true , 48999113333),
       ( 'Kamil',        'Kaczmarek',    'Tarnów',       'Mickiewicza',              777, true , 48122243434),
       ( 'Wiktoria',     'Sikorska',     'Rzeszów',      'Piłsudskiego',             888, true , 48233323232);

INSERT INTO
    user_app (first_name, last_name, email, password)
VALUES
    -- admin@admin.com / admin
    ('admin', 'admin', 'admin@admin.com', '$2a$13$9kqnZ.VftG7t2z7R5LiVJeMDZ1/lWbbI/XjoNtoGsyvlupmKrBfri'),
    -- user@user.com / user
    ('user', 'user', 'user@user.com', '$2a$13$JCluwrAdOFZoz4BniHaL5eH0.9wzTLU.aEGA78bEJprmIHhFLPOD2');

INSERT INTO
    user_role (name, description)
VALUES
    ('ADMIN', 'moze edytoqwac i zatwierdzac'),
    ('USER', 'sklada prosbe o dodanie numeru do wreyfikacji');

INSERT INTO
    user_roles (user_id, role_id)
VALUES
    (1, 1),
    (2, 2);
