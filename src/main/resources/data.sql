DROP SEQUENCE IF EXISTS global_seq;
DROP TABLE IF EXISTS rooms CASCADE ;
DROP TABLE IF EXISTS items CASCADE ;
DROP TABLE IF EXISTS vendors CASCADE ;




CREATE SEQUENCE global_seq START WITH 100000;

CREATE TABLE vendors
(
    id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name             VARCHAR                 NOT NULL
);
CREATE UNIQUE INDEX vendors_unique_name_idx ON vendors (name);

CREATE TABLE rooms
(
    id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    number           INTEGER                 NOT NULL
);
CREATE UNIQUE INDEX room_unique_idx ON rooms (number);

CREATE TABLE items
(
    id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name             VARCHAR                 NOT NULL,
    vendor_id        INTEGER                 NOT NULL,
    room_id          INTEGER                 NOT NULL,
    quantity          INTEGER                 NOT NULL,
    code             VARCHAR                 NOT NULL,
    CONSTRAINT item_room_idx UNIQUE (name, room_id),
    CONSTRAINT item_vendor_idx UNIQUE (name, vendor_id),
    FOREIGN KEY (vendor_id) REFERENCES vendors(id) ON DELETE CASCADE ,
    FOREIGN KEY (room_id) REFERENCES rooms(id) ON DELETE CASCADE
);

INSERT INTO vendors(name)
VALUES ('ABB'),
       ('Siemens'),
       ('GE')