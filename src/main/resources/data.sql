INSERT INTO phonebook ( name, surname, city, street, buildnumber,aprove ,numbertel)
VALUES ( 'John',          'Doe',          'Warszawa',     'Aleje Jerozolimskie',     123, true , 481234   ),
       ( 'Alex',          'Doe',          'Kraków',       'Rynek Główny',            456, true , 4823456  ),
       ( 'Alice',         'Smith',        'Gdańsk',       'Długa',                   789, true , 483456   ),
       ( 'Bob',           'Johnson',      'Wrocław',      'Świdnicka',               101, true , 48456    ),
       ( 'Emily',         'Anderson',     'Poznań',       'Stary Rynek',              02, false , 485678   ),
       ( 'Michael',       'Taylor',       'Szczecin',     'Monte Cassino',           303, true , 9234     ),
       ( 'Jane',          'Brown',        'Łódź',         'Piotrkowska',             404, true , 487345   ),
       ( 'John',          'Smith',        'Kraków',       'Floriańska',              505, true , 483456   ),
       ( 'Alice',         'Taylor',       'Warszawa',     'Nowy Świat',              606, true , 48567    ),
       ( 'Bob',          'Anderson',     'Gdańsk',       'Mariacka',                 707, true , 48233    ),
       ( 'Jan',          'Nowak',        'Gdynia',       'Kosciuszki',               808, false , 48244    ),
       ( 'Anna',         'Kowalczyk',    'Płock',        'Sienkiewicza',             909, true , 4835    ),
       ( 'Piotr',        'Wójcik',       'Bydgoszcz',    'Dworcowa',                 111, false , 484666   ),
       ( 'Katarzyna',    'Kowalska',     'Katowice',     'Mariacka',                 222, true , 48777    ),
       ( 'Michał',       'Lewandowski',  'Białystok',    'Lipowa',                   333, false , 486688   ),
       ( 'Alicja',       'Zielińska',    'Radom',        'Narutowicza',              444, true , 489      ),
       ( 'Bartosz',      'Pawlak',       'Olsztyn',      'Dworcowa',                 555, false , 488880   ),
       ( 'Kamila',       'Jankowska',    'Zielona Góra', 'Słowiańska',               666, true , 4899911  ),
       ( 'Kamil',        'Kaczmarek',    'Tarnów',       'Mickiewicza',              777, true , 481222   ),
       ( 'Wiktoria',     'Sikorska',     'Rzeszów',      'Piłsudskiego',             888, true , 48233    );

INSERT INTO
    user_app (first_name, last_name, email, password)
VALUES
    -- superadmin@example.com / hard
    ('Jan', 'Kowalski', 'superadmin@example.com', '{bcrypt}$2a$10$Ruu5GtmSVkfLeuGfz/wHUuzflCcMbwJHSBo/.Wui0EM0KIM52Gs2S'),
    -- john@example.com / dog.8
    ('John', 'Abacki', 'john@example.com', '{MD5}{AlZCLSQMMNLBS5mEO0kSem9V3mxplC6cTjWy9Kj/Gxs=}d9007147eb3a5f727b2665d647d36e35'),
    -- java_lover@example.com / javaiscool
    ('Marek', 'Zalewski', 'java_lover@example.com', '{argon2}$argon2id$v=19$m=4096,t=3,p=1$YBBBwx+kfrNgczYDcLlWYA$LEPgdtfskoobyFtUWTMejaE5SBRyieHYbiE5ZmFKE7I');

INSERT INTO
    user_role (name, description)
VALUES
    ('ADMIN', 'moze edytoqwac i zatwierdzac'),
    ('USER', 'sklada prosbe o dodanie numeru do wreyfikacji');

INSERT INTO
    user_roles (user_id, role_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 2);
