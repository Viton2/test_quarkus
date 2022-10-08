package br.com.tests.quarkus.model;

import com.sun.istack.NotNull;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Address{

    @Id
    @NotNull
    @Column(name = "id", unique = true)
    @Type(type="org.hibernate.type.PostgresUUIDType")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String cep;

    private String complement;

    public Address(UUID id, String cep, String complement) {
        this.id = id;
        this.cep = cep;
        this.complement = complement;
    }

    public Address() {
    }

    public static AddressBuilder builder() {
        return new AddressBuilder();
    }

    public UUID getId() {
        return this.id;
    }

    public String getCep() {
        return this.cep;
    }

    public String getComplement() {
        return this.complement;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Address)) return false;
        final Address other = (Address) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$cep = this.getCep();
        final Object other$cep = other.getCep();
        if (this$cep == null ? other$cep != null : !this$cep.equals(other$cep)) return false;
        final Object this$complement = this.getComplement();
        final Object other$complement = other.getComplement();
        if (this$complement == null ? other$complement != null : !this$complement.equals(other$complement))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Address;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $cep = this.getCep();
        result = result * PRIME + ($cep == null ? 43 : $cep.hashCode());
        final Object $complement = this.getComplement();
        result = result * PRIME + ($complement == null ? 43 : $complement.hashCode());
        return result;
    }

    public String toString() {
        return "Address(id=" + this.getId() + ", cep=" + this.getCep() + ", complement=" + this.getComplement() + ")";
    }

    public static class AddressBuilder {
        private UUID id;
        private String cep;
        private String complement;

        AddressBuilder() {
        }

        public AddressBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public AddressBuilder cep(String cep) {
            this.cep = cep;
            return this;
        }

        public AddressBuilder complement(String complement) {
            this.complement = complement;
            return this;
        }

        public Address build() {
            return new Address(id, cep, complement);
        }

        public String toString() {
            return "Address.AddressBuilder(id=" + this.id + ", cep=" + this.cep + ", complement=" + this.complement + ")";
        }
    }
}
