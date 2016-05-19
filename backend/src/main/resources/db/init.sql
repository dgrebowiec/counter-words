CREATE TABLE system_user (
  user_id SERIAL PRIMARY KEY,
  login VARCHAR
);

CREATE TABLE word (
  word_id SERIAL PRIMARY KEY
);

CREATE TABLE learn (
  learn_id SERIAL PRIMARY KEY,
  word_id INTEGER,
  user_id INTEGER,
  learned BOOLEAN,

  FOREIGN KEY (word_id) REFERENCES word (word_id),
  FOREIGN KEY (user_id) REFERENCES system_user (user_id)
);

CREATE TABLE translate (
  translate_id SERIAL PRIMARY KEY,
  word_id INTEGER,
  value VARCHAR,
  language VARCHAR,

  FOREIGN KEY (word_id) REFERENCES word (word_id)
);


CREATE UNIQUE INDEX translate_uniq_idx ON translate (value, language);

