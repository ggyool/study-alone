package hellpjpa;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"NAME"}))
public class Member {

    @Id
    private Long id;

    @Column(name="name")
    private String username;

    private Integer age;


    // @Enumerated 만쓰면 기본 옵션으로 0 1 2 db 에 숫자로 전달되는데
    // enum에 인자가 추가되면 012가 바뀔수 있다. 그래서 무조건 String으로
    // String 그대로 db에 들어간다.
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    // Temporal.Date, Time, Timestamp
    // 3가지 종류가 있고, 순서대로 날짜, 시간, 날짜+시간
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob
    private String description;

    // db에 컬럼으로 생기지 않게 하고 싶을 때
    @Transient
    private int temp;

    public Member() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }
}
