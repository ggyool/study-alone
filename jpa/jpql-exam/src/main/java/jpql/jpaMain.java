package jpql;

import javax.persistence.*;
import java.util.List;

public class jpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Member member = new Member();
            member.setUsername("member1");
            member.setAge(10);
            em.persist(member);


            Member findMember = em.createQuery("select m from Member as m where m.username = ?1", Member.class)
                    .setParameter(1, "member1")
                    .getSingleResult();

            System.out.println(findMember.getUsername());


            tx.commit();
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("======================rollback======================");
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
