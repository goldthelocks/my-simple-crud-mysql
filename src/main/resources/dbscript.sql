CREATE TABLE dbsimplecrud.users (
	`id` BIGINT NOT NULL AUTO_INCREMENT,
	firstName varchar(100) NULL,
	lastName varchar(100) NULL,
	CONSTRAINT users_PK PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARSET=latin1
COLLATE=latin1_swedish_ci ;
