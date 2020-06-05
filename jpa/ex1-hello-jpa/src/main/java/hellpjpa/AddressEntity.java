package hellpjpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class AddressEntity {

    @Id @GeneratedValue
    private Long id;

    private Address addresss;

    public AddressEntity() {
    }

    public AddressEntity(String city, String street, String zipcode) {
        this.addresss = new Address(city, street, zipcode);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressEntity that = (AddressEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(addresss, that.addresss);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getAddress() {
        return addresss;
    }

    public void setAddress(Address address) {
        this.addresss = address;
    }



    @Override
    public int hashCode() {
        return Objects.hash(id, addresss);
    }

    @Override
    public String toString() {
        return "AddressEntity{" +
                "id=" + id +
                ", addresss.getCity()=" + addresss.getCity() +
                '}';
    }
}
