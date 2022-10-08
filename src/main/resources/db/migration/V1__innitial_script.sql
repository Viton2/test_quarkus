CREATE TABLE address(
                        id uuid PRIMARY KEY NOT NULL,
                        cep varchar(10) NOT NULL,
                        complement varchar(100)
);

CREATE TABLE person(
                       id uuid PRIMARY KEY NOT NULL,
                       name varchar(100) NOT NULL,
                       cpf varchar(10) NOT NULL,
                       address_id uuid not null,
                       CONSTRAINT fk_address_person
                           FOREIGN KEY (address_id)
                               REFERENCES address (id)
);
