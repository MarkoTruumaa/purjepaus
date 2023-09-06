-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-09-05 12:43:28.616

-- tables
-- Table: booking
CREATE TABLE booking (
    id serial  NOT NULL,
    user_id int  NOT NULL,
    vessel_id int  NOT NULL,
    harbour_id int  NOT NULL,
    start_time date  NOT NULL,
    end_time date  NOT NULL,
    CONSTRAINT booking_pk PRIMARY KEY (id)
);

-- Table: contact
CREATE TABLE contact (
    id serial  NOT NULL,
    first_name varchar(255)  NOT NULL,
    last_name varchar(255)  NOT NULL,
    email varchar(255)  NOT NULL,
    telephone varchar(255)  NULL,
    address varchar(255)  NULL,
    is_captain boolean  NOT NULL,
    CONSTRAINT contact_pk PRIMARY KEY (id)
);

-- Table: county
CREATE TABLE county (
    id serial  NOT NULL,
    name varchar(255)  NOT NULL,
    CONSTRAINT county_pk PRIMARY KEY (id)
);

-- Table: extra
CREATE TABLE extra (
    id serial  NOT NULL,
    name varchar(255)  NOT NULL,
    CONSTRAINT extra_pk PRIMARY KEY (id)
);

-- Table: harbour
CREATE TABLE harbour (
    id serial  NOT NULL,
    location_id int  NOT NULL,
    contact_id int  NOT NULL,
    name varchar(255)  NOT NULL,
    homepage varchar(255)  NULL,
    navigation_start date  NOT NULL,
    navigation_end date  NOT NULL,
    min_depth decimal(4,2)  NOT NULL,
    min_width decimal(4,2)  NOT NULL,
    spots int  NOT NULL,
    phone_number varchar(255)  NOT NULL,
    status char(1)  NOT NULL,
    CONSTRAINT harbour_pk PRIMARY KEY (id)
);

-- Table: harbour_extra
CREATE TABLE harbour_extra (
    id serial  NOT NULL,
    extra_id int  NOT NULL,
    harbour_id int  NOT NULL,
    CONSTRAINT harbour_extra_pk PRIMARY KEY (id)
);

-- Table: harbour_picture
CREATE TABLE harbour_picture (
    id serial  NOT NULL,
    picture_id int  NOT NULL,
    harbor_id int  NOT NULL,
    CONSTRAINT harbour_picture_pk PRIMARY KEY (id)
);

-- Table: location
CREATE TABLE location (
    id serial  NOT NULL,
    county_id int  NOT NULL,
    address varchar(255)  NOT NULL,
    longitude decimal(9,6)  NOT NULL,
    latitude decimal(9,6)  NOT NULL,
    CONSTRAINT location_pk PRIMARY KEY (id)
);

-- Table: picture
CREATE TABLE picture (
    id serial  NOT NULL,
    picture_data bytea  NOT NULL,
    CONSTRAINT picture_pk PRIMARY KEY (id)
);

-- Table: role
CREATE TABLE role (
    id serial  NOT NULL,
    name varchar(255)  NOT NULL,
    CONSTRAINT role_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user" (
    id serial  NOT NULL,
    contact_id int  NOT NULL,
    role_id int  NOT NULL,
    username varchar(255)  NOT NULL,
    password varchar(255)  NOT NULL,
    status char(1)  NOT NULL,
    CONSTRAINT user_pk PRIMARY KEY (id)
);

-- Table: vessel
CREATE TABLE vessel (
    id serial  NOT NULL,
    user_id int  NOT NULL,
    name varchar(255)  NOT NULL,
    length decimal(4,2)  NOT NULL,
    width decimal(4,2)  NOT NULL,
    draft decimal(3,2)  NOT NULL,
    status char(1)  NOT NULL,
    country varchar(255)  NOT NULL,
    CONSTRAINT vessel_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: boat_user (table: vessel)
ALTER TABLE vessel ADD CONSTRAINT boat_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: booking_harbour (table: booking)
ALTER TABLE booking ADD CONSTRAINT booking_harbour
    FOREIGN KEY (harbour_id)
    REFERENCES harbour (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: booking_user (table: booking)
ALTER TABLE booking ADD CONSTRAINT booking_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: booking_vessel (table: booking)
ALTER TABLE booking ADD CONSTRAINT booking_vessel
    FOREIGN KEY (vessel_id)
    REFERENCES vessel (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: harbor_contact (table: harbour)
ALTER TABLE harbour ADD CONSTRAINT harbor_contact
    FOREIGN KEY (contact_id)
    REFERENCES contact (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: harbor_extra_extra (table: harbour_extra)
ALTER TABLE harbour_extra ADD CONSTRAINT harbor_extra_extra
    FOREIGN KEY (extra_id)
    REFERENCES extra (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: harbor_extra_harbour (table: harbour_extra)
ALTER TABLE harbour_extra ADD CONSTRAINT harbor_extra_harbour
    FOREIGN KEY (harbour_id)
    REFERENCES harbour (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: harbor_location (table: harbour)
ALTER TABLE harbour ADD CONSTRAINT harbor_location
    FOREIGN KEY (location_id)
    REFERENCES location (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: harbour_picture_harbor (table: harbour_picture)
ALTER TABLE harbour_picture ADD CONSTRAINT harbour_picture_harbor
    FOREIGN KEY (harbor_id)
    REFERENCES harbour (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: harbour_picture_picture (table: harbour_picture)
ALTER TABLE harbour_picture ADD CONSTRAINT harbour_picture_picture
    FOREIGN KEY (picture_id)
    REFERENCES picture (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: location_county (table: location)
ALTER TABLE location ADD CONSTRAINT location_county
    FOREIGN KEY (county_id)
    REFERENCES county (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: user_contact (table: user)
ALTER TABLE "user" ADD CONSTRAINT user_contact
    FOREIGN KEY (contact_id)
    REFERENCES contact (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: user_role (table: user)
ALTER TABLE "user" ADD CONSTRAINT user_role
    FOREIGN KEY (role_id)
    REFERENCES role (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.

