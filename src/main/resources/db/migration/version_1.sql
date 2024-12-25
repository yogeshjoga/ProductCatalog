CREATE TABLE at_instructors
(
    id           BINARY(16)   NOT NULL,
    name         VARCHAR(255) NULL,
    email        VARCHAR(255) NULL,
    phone        VARCHAR(255) NULL,
    is_full_time BIT(1)       NULL,
    prev_company VARCHAR(255) NULL,
    CONSTRAINT pk_at_instructors PRIMARY KEY (id)
);

CREATE TABLE at_mentors
(
    id           BINARY(16)   NOT NULL,
    name         VARCHAR(255) NULL,
    email        VARCHAR(255) NULL,
    phone        VARCHAR(255) NULL,
    is_full_time BIT(1)       NULL,
    prev_company VARCHAR(255) NULL,
    CONSTRAINT pk_at_mentors PRIMARY KEY (id)
);

CREATE TABLE at_tas
(
    id           BINARY(16)   NOT NULL,
    name         VARCHAR(255) NULL,
    email        VARCHAR(255) NULL,
    phone        VARCHAR(255) NULL,
    is_full_time BIT(1)       NULL,
    CONSTRAINT pk_at_tas PRIMARY KEY (id)
);

CREATE TABLE at_users
(
    id    BINARY(16)   NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    phone VARCHAR(255) NULL,
    CONSTRAINT pk_at_users PRIMARY KEY (id)
);

CREATE TABLE in_instructors
(
    id           BINARY(16)   NOT NULL,
    name         VARCHAR(255) NULL,
    email        VARCHAR(255) NULL,
    phone        VARCHAR(255) NULL,
    is_full_time BIT(1)       NULL,
    prev_company VARCHAR(255) NULL,
    CONSTRAINT pk_in_instructors PRIMARY KEY (id)
);

CREATE TABLE in_mentors
(
    id           BINARY(16)   NOT NULL,
    name         VARCHAR(255) NULL,
    email        VARCHAR(255) NULL,
    phone        VARCHAR(255) NULL,
    is_full_time BIT(1)       NULL,
    prev_company VARCHAR(255) NULL,
    CONSTRAINT pk_in_mentors PRIMARY KEY (id)
);

CREATE TABLE in_tas
(
    id           BINARY(16)   NOT NULL,
    name         VARCHAR(255) NULL,
    email        VARCHAR(255) NULL,
    phone        VARCHAR(255) NULL,
    is_full_time BIT(1)       NULL,
    CONSTRAINT pk_in_tas PRIMARY KEY (id)
);

CREATE TABLE jn_instructors
(
    user_id      BINARY(16)   NOT NULL,
    is_full_time BIT(1)       NULL,
    prev_company VARCHAR(255) NULL,
    CONSTRAINT pk_jn_instructors PRIMARY KEY (user_id)
);

CREATE TABLE jn_mentors
(
    user_id      BINARY(16)   NOT NULL,
    is_full_time BIT(1)       NULL,
    prev_company VARCHAR(255) NULL,
    CONSTRAINT pk_jn_mentors PRIMARY KEY (user_id)
);

CREATE TABLE jn_tas
(
    user_id      BINARY(16) NOT NULL,
    is_full_time BIT(1)     NULL,
    CONSTRAINT pk_jn_tas PRIMARY KEY (user_id)
);

CREATE TABLE jn_users
(
    id    BINARY(16)   NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    phone VARCHAR(255) NULL,
    CONSTRAINT pk_jn_users PRIMARY KEY (id)
);

CREATE TABLE mentors
(
    id            BINARY(16)   NOT NULL,
    title         VARCHAR(255) NULL,
    `description` VARCHAR(255) NULL,
    image_url     VARCHAR(255) NULL,
    created_at    datetime     NULL,
    updated_at    datetime     NULL,
    mentor_type   VARCHAR(255) NULL,
    CONSTRAINT pk_mentors PRIMARY KEY (id)
);

CREATE TABLE ss_users
(
    id           BINARY(16)   NOT NULL,
    user_typ     INT          NULL,
    name         VARCHAR(255) NULL,
    email        VARCHAR(255) NULL,
    phone        VARCHAR(255) NULL,
    is_full_time BIT(1)       NULL,
    prev_company VARCHAR(255) NULL,
    CONSTRAINT pk_ss_users PRIMARY KEY (id)
);

CREATE TABLE teaching_ass
(
    id            BINARY(16)   NOT NULL,
    title         VARCHAR(255) NULL,
    `description` VARCHAR(255) NULL,
    image_url     VARCHAR(255) NULL,
    created_at    datetime     NULL,
    updated_at    datetime     NULL,
    ta_type       VARCHAR(255) NULL,
    work_type     VARCHAR(255) NULL,
    CONSTRAINT pk_teaching_ass PRIMARY KEY (id)
);

CREATE TABLE users
(
    id            BINARY(16)   NOT NULL,
    title         VARCHAR(255) NULL,
    `description` VARCHAR(255) NULL,
    image_url     VARCHAR(255) NULL,
    created_at    datetime     NULL,
    updated_at    datetime     NULL,
    username      VARCHAR(255) NOT NULL,
    password      VARCHAR(255) NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

ALTER TABLE users
    ADD CONSTRAINT uc_users_username UNIQUE (username);

ALTER TABLE jn_instructors
    ADD CONSTRAINT FK_JN_INSTRUCTORS_ON_USER FOREIGN KEY (user_id) REFERENCES jn_users (id);

ALTER TABLE jn_mentors
    ADD CONSTRAINT FK_JN_MENTORS_ON_USER FOREIGN KEY (user_id) REFERENCES jn_users (id);

ALTER TABLE jn_tas
    ADD CONSTRAINT FK_JN_TAS_ON_USER FOREIGN KEY (user_id) REFERENCES jn_users (id);