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
            Member member1 = new Member();
            member1.setUsername("user01");
            em.persist(member1);

            em.flush();
            em.clear();

            Member refMember = em.getReference(Member.class, member1.getId());
            System.out.println("refMember.getClass() = " + refMember.getClass());
            System.out.println("before:  " + emf.getPersistenceUnitUtil().isLoaded(refMember));

            // refMember.getUsername(); // 강제 초기화 역할로 사용
            Hibernate.initialize(refMember);

            System.out.println("after:  " + emf.getPersistenceUnitUtil().isLoaded(refMember));
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
