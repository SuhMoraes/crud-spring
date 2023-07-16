CREATE TABLE books (
  id INT PRIMARY KEY UNIQUE NOT NULL,
  name TEXT NOT NULL,
  author TEXT NOT NULL,
  theme TEXT NOT NULL,
  number_pages INT NOT NULL
);

INSERT INTO books (id, name, author, theme, number_pages) VALUES
  (1, 'O Senhor dos Anéis', 'J.R.R. Tolkien', 'Fantasia', 1178),
  (2, '1984', 'George Orwell', 'Distopia', 328),
  (3, 'Dom Quixote', 'Miguel de Cervantes', 'Romance', 1072),
  (4, 'Orgulho e Preconceito', 'Jane Austen', 'Romance', 432),
  (5, 'A Revolução dos Bichos', 'George Orwell', 'Sátira', 144),
  (6, 'A Menina que Roubava Livros', 'Markus Zusak', 'Drama', 480),
  (7, 'Cem Anos de Solidão', 'Gabriel García Márquez', 'Realismo Mágico', 417),
  (8, 'Harry Potter e a Pedra Filosofal', 'J.K. Rowling', 'Fantasia', 223),
  (9, 'Crime e Castigo', 'Fiódor Dostoiévski', 'Romance', 551),
  (10, 'A Culpa é das Estrelas', 'John Green', 'Romance', 313),
  (11, 'O Pequeno Príncipe', 'Antoine de Saint-Exupéry', 'Infantil', 96),
  (12, 'A Metamorfose', 'Franz Kafka', 'Ficção Absurda', 55),
  (13, 'Harry Potter e o Cálice de Fogo', 'J.K. Rowling', 'Fantasia', 636),
  (14, 'O Alquimista', 'Paulo Coelho', 'Autoajuda', 176),
  (15, 'O Hobbit', 'J.R.R. Tolkien', 'Fantasia', 310),
  (16, 'Memórias Póstumas de Brás Cubas', 'Machado de Assis', 'Realismo', 251),
  (17, 'A Revolução Industrial', 'Eric Hobsbawm', 'História', 400),
  (18, 'O Retrato de Dorian Gray', 'Oscar Wilde', 'Ficção Gótica', 254),
  (19, 'A Odisséia', 'Homero', 'Épico', 484),
  (20, 'O Código Da Vinci', 'Dan Brown', 'Mistério', 589);

