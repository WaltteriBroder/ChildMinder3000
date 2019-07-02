CREATE SCHEMA IF NOT EXISTS childminder;

set search_path to childminder;

grant usage on schema childminder to aldojawaldo;

CREATE TABLE childgroup (

    childgroup_id      BIGSERIAL PRIMARY KEY  NOT NULL,
    name               VARCHAR(255) NOT NULL
);

CREATE TABLE child (

    child_id           BIGSERIAL PRIMARY KEY  NOT NULL,
    birthday           DATE,
    first_name         VARCHAR(255)         NOT NULL,
    present            BOOLEAN,
    childgroup_id      BIGINT,
    constraint fk_childgroup_id foreign key(childgroup_id) references childgroup(childgroup_id)
);


CREATE TABLE child_schedule (

    schedule_id        BIGSERIAL PRIMARY KEY  NOT NULL,
    arrive             TIME,
    date               DATE,
    departure          TIME,
    child_id           BIGINT,
    constraint fk_child_id foreign key(child_id) references child(child_id)
);

CREATE TABLE teacher (

    teacher_id      BIGSERIAL PRIMARY KEY  NOT NULL,
    name            VARCHAR(255) NOT NULL
);

CREATE TABLE teacher_childgroup (

    teacher_id      BIGINT NOT NULL,
    childgroup_id   BIGINT NOT NULL,
    constraint fk_teacher_id foreign key(teacher_id) references teacher(teacher_id),
    constraint fk_childgroup2_id foreign key(childgroup_id) references childgroup(childgroup_id)
);