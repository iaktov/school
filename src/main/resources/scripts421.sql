
ALTER TABLE student
    ADD CONSTRAINT age_constraint CHECK ( age > 16 );


ALTER TABLE student
    ALTER COLUMN name SET NOT NULL,
    ADD CONSTRAINT name_unique UNIQUE (name);

-- при создании более сокращенного варианта запроса выше выдал следующую ошибку(возможно потому, что сначала вызвал тот запрос,
-- но я удалил name_unique и проблема осталась актуальной):
--     ERROR: multiple primary keys for table "student" are not allowed
-- ALTER TABLE student
--     ADD PRIMARY KEY (name);

ALTER TABLE faculty
    ADD CONSTRAINT name_color_unique UNIQUE (name, color);

ALTER TABLE student
    ALTER COLUMN age SET DEFAULT 20;








