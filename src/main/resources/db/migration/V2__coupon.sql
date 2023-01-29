DROP TABLE IF EXISTS coupon CASCADE;

CREATE TABLE IF NOT EXISTS coupon
(

    id          SERIAL PRIMARY KEY,
    coupon_id   VARCHAR(255) NOT NULL UNIQUE,
    valid_from  DATE         NOT NULL,
    valid_until DATE         NOT NULL,
    latitude    double precision,
    longitude   double precision,
    city        VARCHAR(255)
);

create index idx__coupon__coupon_id on coupon (coupon_id);