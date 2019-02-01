CREATE TABLE customer (
	customer_id uuid NOT NULL,
	created_at timestamp NOT NULL,
	updated_at timestamp NULL,
	address varchar(255) NOT NULL,
	first_name varchar(255) NOT NULL,
	last_name varchar(255) NOT NULL,
	email varchar(255) NOT NULL,
	CONSTRAINT customer_pkey PRIMARY KEY (customer_id),
	CONSTRAINT customer_constraint_1 UNIQUE (email)
)
WITH (
	OIDS=FALSE
) ;
