package hellpjpa;

import javax.persistence.*;
import java.util.Date;

@Entity
// @Table(uniqueConstraints = @UniqueConstraint(columnNames = {"name"}))
// @SequenceGenerator(name="MEMBER_SEQ_GENERATOR", sequenceName = "member_seq", initialValue = 1, allocationSize = 50)
//@TableGenerator(name="MEMBER_SEQ_GENERATOR",
//                table="MY_SEQUENCES", // 생성할 테이블 이름
//                pkColumnValue="MEMBER_SEQ", allocationSize = 1)
public class Member {

    @Id @GeneratedValue
    // @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ_GENERATOR")
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name="USERNAME")
    private String username;

    // member 입장에서 n:1 관계이기 때문
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="TEAM_ID")
    private Team team;

    /*
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
    private int temp;*/

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

    public Team getTeam() {
        return team;
    }

    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }

}
