create table test_data (
  id bigserial not null,
  data varchar(255) not null,
  created_at timestamp default current_timestamp,
  primary key (id)
);