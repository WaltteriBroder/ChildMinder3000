CREATE TABLE child_group (

    child_group_id      BIGSERIAL PRIMARY KEY  NOT NULL,
    name               VARCHAR(255) NOT NULL
);

CREATE TABLE child (

    child_id           BIGSERIAL PRIMARY KEY  NOT NULL,
    birthday           DATE,
    first_name         VARCHAR(255)         NOT NULL,
    present            BOOLEAN,
    child_group_id      BIGINT,
    constraint fk_child_group_id foreign key(child_group_id) references child_group(child_group_id)
);


CREATE TABLE child_schedule (

    schedule_id        BIGSERIAL PRIMARY KEY  NOT NULL,
    arrive             TIME,
    date       DATE,
    departure          TIME,
    child_id           BIGINT,
    constraint fk_child_id foreign key(child_id) references child(child_id),
    UNIQUE (date, child_id)
);

CREATE TABLE teacher (

    teacher_id      BIGSERIAL PRIMARY KEY  NOT NULL,
    name            VARCHAR(255) NOT NULL
);

CREATE TABLE teacher_child_group (

    teacher_id      BIGINT NOT NULL,
    child_group_id   BIGINT NOT NULL,
    constraint fk_teacher_id foreign key(teacher_id) references teacher(teacher_id),
    constraint fk_child_group2_id foreign key(child_group_id) references child_group(child_group_id)
);