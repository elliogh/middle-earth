CREATE TABLE IF NOT EXISTS race (
    id                  SERIAL PRIMARY KEY,
    name                TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS biome (
    id                  SERIAL PRIMARY KEY,
    name                TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS location (
    id                  SERIAL PRIMARY KEY,
    name                TEXT NOT NULL,
    biome_id            INTEGER REFERENCES biome ON DELETE CASCADE ON UPDATE CASCADE,
    race_id             INTEGER REFERENCES race ON DELETE CASCADE ON UPDATE CASCADE,
    visit_time          INTEGER NOT NULL,
    description         TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS neighbours (
    first_location_id    INTEGER REFERENCES location ON DELETE CASCADE ON UPDATE CASCADE NOT NULL,
    second_location_id   INTEGER REFERENCES location ON DELETE CASCADE ON UPDATE CASCADE NOT NULL,
    PRIMARY KEY (first_location_id, second_location_id)
);

CREATE TABLE IF NOT EXISTS danger (
    id                  SERIAL PRIMARY KEY,
    name                TEXT NOT NULL,
    description         TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS location_danger (
    location_id         INTEGER REFERENCES location ON DELETE CASCADE ON UPDATE CASCADE NOT NULL,
    danger_id           INTEGER REFERENCES danger ON DELETE CASCADE ON UPDATE CASCADE NOT NULL,
    PRIMARY KEY (location_id, danger_id)
);

CREATE TABLE IF NOT EXISTS equipment (
    id                  SERIAL PRIMARY KEY,
    name                TEXT NOT NULL,
    price               INTEGER NOT NULL CHECK ( price >= 0 )
);

CREATE TABLE IF NOT EXISTS biome_equipment (
    biome_id            INTEGER REFERENCES biome ON DELETE CASCADE ON UPDATE CASCADE NOT NULL,
    equipment_id        INTEGER REFERENCES equipment ON DELETE CASCADE ON UPDATE CASCADE NOT NULL,
    PRIMARY KEY (biome_id, equipment_id)
);

CREATE TABLE IF NOT EXISTS danger_equipment (
    danger_id           INTEGER REFERENCES danger ON DELETE CASCADE ON UPDATE CASCADE NOT NULL,
    equipment_id        INTEGER REFERENCES equipment ON DELETE CASCADE ON UPDATE CASCADE NOT NULL,
    PRIMARY KEY (danger_id, equipment_id)
);

CREATE TABLE IF NOT EXISTS resistance_to_danger (
    race_id             INTEGER REFERENCES race ON DELETE CASCADE ON UPDATE CASCADE NOT NULL,
    danger_id           INTEGER REFERENCES danger ON DELETE CASCADE ON UPDATE CASCADE NOT NULL,
    PRIMARY KEY (race_id, danger_id)
);

CREATE TABLE IF NOT EXISTS speed_bonus (
    race_id             INTEGER REFERENCES  race ON DELETE CASCADE ON UPDATE CASCADE NOT NULL,
    biome_id            INTEGER REFERENCES biome ON DELETE CASCADE ON UPDATE CASCADE NOT NULL,
    value               NUMERIC(5, 2) NOT NULL CHECK ( value > 0 ),
	PRIMARY KEY (race_id, biome_id)
);

CREATE TABLE IF NOT EXISTS relationship (
    first_race_id       INTEGER REFERENCES race ON DELETE CASCADE ON UPDATE CASCADE NOT NULL,
    second_race_id      INTEGER REFERENCES race ON DELETE CASCADE ON UPDATE CASCADE NOT NULL,
    pass_price          INTEGER NOT NULL CHECK ( pass_price >= 0 ),
    PRIMARY KEY (first_race_id , second_race_id)
)