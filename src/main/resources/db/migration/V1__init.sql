CREATE SEQUENCE bank_seq;
CREATE SEQUENCE agency_seq;
CREATE SEQUENCE manager_seq;
CREATE SEQUENCE client_seq;
CREATE SEQUENCE account_seq;

CREATE TABLE bank (
  id BIGINT PRIMARY KEY,
  name VARCHAR,
  cnpj VARCHAR,
  public_place VARCHAR,
  complement VARCHAR,
  number INTEGER
);

CREATE TABLE agency (
  id BIGINT PRIMARY KEY,
  name VARCHAR,
  cnpj VARCHAR,
  number VARCHAR,
  bank_id BIGINT,
  FOREIGN KEY (bank_id) REFERENCES bank (id)
);

CREATE TABLE manager (
  id BIGINT PRIMARY KEY,
  name VARCHAR,
  cpf VARCHAR,
  number VARCHAR,
  ddd VARCHAR,
  agency_id BIGINT,
  FOREIGN KEY (agency_id) REFERENCES agency (id)
);

CREATE TABLE client (
  id BIGINT PRIMARY KEY,
  name VARCHAR,
  cpf VARCHAR,
  number VARCHAR,
  ddd VARCHAR,
  agency_id BIGINT,
  FOREIGN KEY (agency_id) REFERENCES agency (id)
);

CREATE TABLE account (
  id BIGINT PRIMARY KEY,
  number VARCHAR,
  amount NUMERIC(14,3),
  created_at TIMESTAMP,
  client_id BIGINT,
  FOREIGN KEY (client_id) REFERENCES client (id)
);


