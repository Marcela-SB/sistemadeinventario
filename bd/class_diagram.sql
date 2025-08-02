CREATE TABLE `users` (
  `id` CHAR(36) PRIMARY KEY,
  `name` VARCHAR(100) NOT NULL,
  `cpf` VARCHAR(14) NOT NULL UNIQUE,
  `password` VARCHAR(255) NOT NULL
);

CREATE TABLE `items` (
  `id` CHAR(36) PRIMARY KEY,
  `tombo` VARCHAR(20) UNIQUE,
  `name` VARCHAR(100) NOT NULL,
  `description` VARCHAR(255) NOT NULL
);

CREATE TABLE `notes` (
  `id` CHAR(36) PRIMARY KEY,
  `item` CHAR(36) NOT NULL UNIQUE, 
  `text` VARCHAR(255) NOT NULL
);

CREATE TABLE `history` (
  `id` CHAR(36) PRIMARY KEY,
  `item` CHAR(36) NOT NULL,     
  `responsable` CHAR(36) NOT NULL,     
  `origin` VARCHAR(100) NOT NULL,
  `destination` VARCHAR(100) NOT NULL,
  `date_time` DATETIME NOT NULL
);


ALTER TABLE `notes`
ADD CONSTRAINT `fk_note_item`
FOREIGN KEY (`item`) REFERENCES `items` (`id`);

ALTER TABLE `history`
ADD CONSTRAINT `fk_history_user`
FOREIGN KEY (`responsable`) REFERENCES `users` (`id`);

ALTER TABLE `history`
ADD CONSTRAINT `fk_history_item`
FOREIGN KEY (`item`) REFERENCES `items` (`id`);