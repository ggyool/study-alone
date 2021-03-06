package hellpjpa;

import hellpjpa.inheritance.Item;
import hellpjpa.inheritance.Movie;
import org.h2.result.UpdatableRow;
import org.hibernate.Hibernate;

import javax.management.relation.Role;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        // emf는 어플리케이션 로딩 시점에 하나만 만들어야 한다.
        // em은 db 쿼리를 날리고 커밋하는 한 일관적인 과정마다 만들어야 한다.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try{



            List<Member> result = em.createQuery(
                    // Member 는 테이블이름이 아니라 엔티티 이름
                    "select m from Member as m where m.username like '%kim%'",
                    Member.class
            ).getResultList();

            for (Member member : result) {

            }





            // 이렇게 하지 말자 - 값 타입이므로
            // findMember.getHomeAddress().setCity("newCity");

            // embeded 멤버 교체
            // 통으로 갈아껴야 한다.
            //Address old = findMember.getHomeAddress();
            //findMember.setHomeAddress(new Address("newCity", old.getStreet(), old.getZipcode()));

            // 컬렉션 교체 사탕을 candy로 바꾸기
//             findMember.getFavoriteFoods().remove("사탕");
//             findMember.getFavoriteFoods().add("candy");

            // old1을 new1으로 바꾸기 (통쨰로 바꿔야 한다)

            //findMember.getAddressHistory().add(new AddressEntity("new1",  "old1", "10000"));
            System.out.println("======commit========");
            tx.commit();
        } catch (Exception e){
            System.out.println("======================rollback======================");
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
