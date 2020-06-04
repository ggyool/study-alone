package hellpjpa;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Member2 {

    @Id @GeneratedValue
    private Long id;
    private String name;

    @Embedded
    private Period workPeriod;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name="city", column = @Column(name="home_city")),
        @AttributeOverride(name="street", column = @Column(name="home_street")),
        @AttributeOverride(name="zipcode", column = @Column(name="home_zipcode"))
    })
    private Address homeAddress;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="city", column = @Column(name="work_city")),
            @AttributeOverride(name="street", column = @Column(name="work_street")),
            @AttributeOverride(name="zipcode", column = @Column(name="work_zipcode"))
    })
    private Address workAddress;
}
