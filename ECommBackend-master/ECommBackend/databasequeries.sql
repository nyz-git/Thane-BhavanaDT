CREATE TABLE category(
id IDENTITY;
name varchar(50);
description varchar(50),
image_url VARCHAR(50)
is_active BOOLEAN,
CONSTRAINT pk_category_id
);