DROP TABLE IF EXISTS authors;
DROP TABLE IF EXISTS genres;
DROP TABLE IF EXISTS books;

CREATE TABLE authors(
                          author_id SERIAL PRIMARY KEY NOT NULL,
                          author_name CHARACTER VARYING(100) NOT NULL, 
                          age INTEGER NOT NULL);
                                                 
                          
CREATE TABLE books(
                          book_id SERIAL PRIMARY KEY NOT NULL,
                          book_name CHARACTER VARYING(100) NOT NULL, 
                          price DECIMAL NOT NULL);
                          
ALTER TABLE books ADD COLUMN author_id INTEGER;   
ALTER TABLE books ADD COLUMN genre_id INTEGER; 
  
ALTER TABLE books ALTER COLUMN author_id SET DEFAULT 1;
ALTER TABLE books ALTER COLUMN genre_id SET DEFAULT 1;

                      
                          
ALTER TABLE books ADD CONSTRAINT fk_auth_constraint FOREIGN KEY (author_id) REFERENCES authors (author_id);                         
                          
CREATE TABLE authors_books(
                          author_id int REFERENCES authors (author_id) ON UPDATE CASCADE,
                          book_id int REFERENCES books (book_id) ON UPDATE CASCADE ON DELETE CASCADE,
                          amount NUMERIC NOT NULL DEFAULT 1, 
                          CONSTRAINT author_book_p_key PRIMARY KEY (book_id, author_id)
                          );
                         
 CREATE TABLE genres(
                     genre_id SERIAL PRIMARY KEY NOT NULL, 
                     genre_name CHARACTER VARYING(100) NOT NULL
                    );                         
                          
