-- Создание таблицы authors
CREATE TABLE authors (
    id BIGINT NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Создание таблицы journals
CREATE TABLE journals (
    id BIGINT NOT NULL PRIMARY KEY,
    title VARCHAR(255) NOT NULL
);

-- Создание таблицы papers
CREATE TABLE papers (
    id BIGINT NOT NULL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    journal_id BIGINT,
    FOREIGN KEY (journal_id) REFERENCES journals(id)
);

-- Создание таблицы author_journal_links
CREATE TABLE author_paper_links (
    author_id BIGINT,
    paper_id BIGINT,
    FOREIGN KEY (author_id) REFERENCES authors(id),
    FOREIGN KEY (paper_id) REFERENCES papers(id)
);

-- Вставка авторов
INSERT INTO authors (id, name) VALUES (1, 'Author 1');
INSERT INTO authors (id, name) VALUES (2, 'Author 2');
INSERT INTO authors (id, name) VALUES (3, 'Author 3');

-- Вставка журналов
INSERT INTO journals (id, title) VALUES (1, 'Journal of Science');
INSERT INTO journals (id, title) VALUES (2, 'Journal of Technology');

-- Вставка работ
INSERT INTO papers (id, title, journal_id) VALUES (1, 'Paper on Quantum Physics', 1);
INSERT INTO papers (id, title, journal_id) VALUES (2, 'Advancements in AI', 2);

-- Вставка связей между авторами и работами
INSERT INTO author_paper_links (author_id, paper_id) VALUES (1, 1);
INSERT INTO author_paper_links (author_id, paper_id) VALUES (2, 1);
INSERT INTO author_paper_links (author_id, paper_id) VALUES (2, 2);
INSERT INTO author_paper_links (author_id, paper_id) VALUES (3, 2);
