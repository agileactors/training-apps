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