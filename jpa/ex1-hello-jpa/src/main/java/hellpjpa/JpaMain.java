package hellpjpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
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

//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(10)
//                    .setMaxResults(20)
//                    .getResultList();
//
//            for(Member member : result){
//                System.out.println("memberName = " + member.getName());
//            }

            Member member1 = new Member(3L, "C");
            Member member2 = new Member(4L, "D");

            em.persist(member1);
            em.persist(member2);

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
