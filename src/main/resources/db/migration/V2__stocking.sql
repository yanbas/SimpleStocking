CREATE TABLE stocking.employee (
	employee_id INT NOT NULL,
	name varchar(50) NOT NULL,
	division VARCHAR(20) NOT NULL,
	`position` varchar(20) NOT NULL,
	created_date DATETIME NULL,
	PRIMARY KEY (employee_id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci
COMMENT='employee table';

CREATE TABLE stocking.users (
	employee_id INT NOT NULL,
	user_id varchar(36) NOT NULL,
	`level` ENUM('user','admin') NOT NULL,
	last_login DATETIME NULL,
	created_date DATETIME NULL,
	PRIMARY KEY (user_id),
	FOREIGN KEY (employee_id) REFERENCES stocking.employee(employee_id) ON DELETE RESTRICT ON UPDATE RESTRICT
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci
COMMENT='users table';
