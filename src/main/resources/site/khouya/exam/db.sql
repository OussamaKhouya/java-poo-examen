use db2024;
-- Table Client
CREATE TABLE Client (
                        id INT PRIMARY KEY AUTO_INCREMENT,
                        nom VARCHAR(100) NOT NULL
);

-- Table PlatPrincipal
CREATE TABLE PlatPrincipal (
                               id INT PRIMARY KEY AUTO_INCREMENT,
                               nom VARCHAR(100) NOT NULL
);

-- Table Ingredient
CREATE TABLE Ingredient (
                            id INT PRIMARY KEY AUTO_INCREMENT,
                            nom VARCHAR(100) NOT NULL,
                            prix DECIMAL(10, 2) NOT NULL
);
CREATE TABLE PlatPrincipal_Ingredient (
                              platPrincipalId INT NOT NULL,
                              ingredientId INT NOT NULL,
                              quantite DECIMAL(10, 2) NOT NULL,
                              PRIMARY KEY (platPrincipalId, ingredientId),
                              FOREIGN KEY (platPrincipalId) REFERENCES PlatPrincipal(id),
                              FOREIGN KEY (ingredientId) REFERENCES Ingredient(id)
);

-- Table Supplement
CREATE TABLE Supplement (
                            id INT PRIMARY KEY AUTO_INCREMENT,
                            nom VARCHAR(100) NOT NULL,
                            prix DECIMAL(10, 2) NOT NULL
);

-- Table Repas
CREATE TABLE Repas (
                       id INT PRIMARY KEY AUTO_INCREMENT,
                       nom VARCHAR(100) NOT NULL,
                       platPrincipalId INT NOT NULL,
                       FOREIGN KEY (platPrincipalId) REFERENCES PlatPrincipal(id)
);

-- Table Repas_Ingredient (Many-to-Many relationship between Repas and Ingredient)
CREATE TABLE Repas_Ingredient (
                                  repasId INT NOT NULL,
                                  ingredientId INT NOT NULL,
                                  quantite DECIMAL(10, 2) NOT NULL,
                                  PRIMARY KEY (repasId, ingredientId),
                                  FOREIGN KEY (repasId) REFERENCES Repas(id),
                                  FOREIGN KEY (ingredientId) REFERENCES Ingredient(id)
);

-- Table Repas_Supplement (Many-to-Many relationship between Repas and Supplement)
CREATE TABLE Repas_Supplement (
                                  repasId INT NOT NULL,
                                  supplementId INT NOT NULL,
                                  PRIMARY KEY (repasId, supplementId),
                                  FOREIGN KEY (repasId) REFERENCES Repas(id) ON DELETE NO ACTION ,
                                  FOREIGN KEY (supplementId) REFERENCES Supplement(id) ON DELETE NO ACTION
);

-- Table Commande
CREATE TABLE Commande (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          clientId INT NOT NULL,
                          FOREIGN KEY (clientId) REFERENCES Client(id)
);

-- Table Commande_Repas (One-to-Many relationship between Commande and Repas)
CREATE TABLE Commande_Repas (
                                commandeId INT NOT NULL,
                                repasId INT NOT NULL,
                                PRIMARY KEY (commandeId, repasId),
                                FOREIGN KEY (commandeId) REFERENCES Commande(id),
                                FOREIGN KEY (repasId) REFERENCES Repas(id)
);

CREATE TABLE PlatPrincipal_Ingredient (
                                  repasId INT NOT NULL,
                                  ingredientId INT NOT NULL,
                                  quantite DECIMAL(10, 2) NOT NULL,
                                  PRIMARY KEY (repasId, ingredientId),
                                  FOREIGN KEY (repasId) REFERENCES Repas(id),
                                  FOREIGN KEY (ingredientId) REFERENCES Ingredient(id)
);