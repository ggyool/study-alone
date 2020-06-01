package hellpjpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {
    @Id @GeneratedValue
    @Column(name="PRODUCT_ID")
    private Long id;
    private String name;

    @OneToMany(mappedBy = "product")
    List<MemberProduct> memberProducts = new ArrayList<MemberProduct>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
