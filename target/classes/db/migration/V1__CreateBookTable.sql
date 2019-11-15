
CREATE TABLE Book (
                                     id LONG AUTO_INCREMENT PRIMARY KEY,
                                     title VARCHAR(255),
                                     author VARCHAR(255),
                                     subject VARCHAR(255),
                                     edition VARCHAR(255),
                                     year numeric,
                                     description TEXT,
                                     school_id LONG
)
