ALTER TABLE accesses
	ADD COLUMN read_data boolean default false,
	ADD COLUMN delete_data boolean default false,
	ADD COLUMN create_data boolean default false,
	ADD COLUMN update_data boolean default false;
	