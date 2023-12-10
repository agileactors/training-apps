CREATE TABLE customer (
	customer_id uuid NOT NULL,
	created_at timestamp NOT NULL,
	updated_at timestamp NOT NULL,
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

CREATE TABLE contract (
	contract_id uuid NOT NULL,
	created_at timestamp NOT NULL,
	updated_at timestamp NOT NULL,
	cost int8 NOT NULL,
	engagement_date timestamp NOT NULL,
	end_date timestamp NULL,
	"name" varchar(255) NOT NULL,
	contract_type varchar(255) NOT NULL,
	customer_id uuid NOT NULL,
	CONSTRAINT contract_pkey PRIMARY KEY (contract_id),
	CONSTRAINT contract_constraint_1 UNIQUE (name),
	CONSTRAINT contract_constraint_fk_1 FOREIGN KEY (customer_id) REFERENCES trainingapp.customer(customer_id))
WITH (
	OIDS=FALSE
) ;

CREATE TABLE audit_log (
	audit_log_id uuid NOT NULL,
	created_at timestamp NOT NULL,
	updated_at timestamp NOT NULL,
	resource_id uuid NOT NULL,
	audit_log_type varchar(255) NOT NULL,
  CONSTRAINT audit_log_pkey PRIMARY KEY (audit_log_id)
)
WITH (
	OIDS=FALSE
) ;

CREATE TABLE users (
	user_id uuid NOT NULL,
	created_at timestamp NOT NULL,
	updated_at timestamp NULL,
	active bool NULL,
	email varchar(255) NULL,
	last_name varchar(255) NULL,
	"name" varchar(255) NULL,
	password varchar(255) NULL,
	protected bool NOT NULL default false,
  user_type varchar(50) NOT NULL,
  roles text[] NOT NULL,
  CONSTRAINT users_pkey PRIMARY KEY (user_id)
)
WITH (
	OIDS=FALSE
) ;

INSERT INTO users
(user_id, created_at, updated_at, active, email, "name", last_name, password, protected, user_type, roles)
VALUES('8f57ed62-4ec8-4132-ba13-99c3ce098868', now(), now(), true, 'admin@agileactors.com', 'Super',' Admin', '$2a$10$C2iG0IWESa8E/prPAbdpAOLju3WVYv31frFGdxlfnbihic843OVTe', true, 'SUPER_ADMIN',
'{  "CUSTOMERS_READ",
    "CUSTOMERS_WRITE",
    "CONTRACTS_READ",
    "CONTRACTS_WRITE",
    "USERS_READ",
    "USERS_WRITE",
    "SETTINGS_WRITE",
    "SETTINGS_READ"
}');
