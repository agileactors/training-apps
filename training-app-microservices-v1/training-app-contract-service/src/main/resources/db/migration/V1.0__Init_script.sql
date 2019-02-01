CREATE TABLE contract (
	contract_id binary(16) NOT NULL,
	created_at timestamp NOT NULL,
	updated_at timestamp NULL,
	cost int8 NOT NULL,
	engagement_date timestamp NOT NULL,
	end_date timestamp NULL,
	`name` varchar(255) NOT NULL,
	contract_type varchar(255) NOT NULL,
	customer_id binary(16) NOT NULL,
	PRIMARY KEY (contract_id),
	UNIQUE KEY contract_constraint_1 (`name`)
);