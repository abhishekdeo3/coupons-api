DROP TABLE IF EXISTS member CASCADE;

CREATE TABLE IF NOT EXISTS member
(

    id         SERIAL PRIMARY KEY,
    member_id  VARCHAR(255) NOT NULL UNIQUE,
    last_name  VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NOT NULL
);

create index idx__member__member_id on member (member_id);