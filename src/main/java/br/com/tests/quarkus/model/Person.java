package br.com.tests.quarkus.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Person extends Model{

    private String name;

    private String cpf;

    @JoinColumn(name = "address_id", referencedColumnName = "id")
    @OneToOne
    private Address address;
}
