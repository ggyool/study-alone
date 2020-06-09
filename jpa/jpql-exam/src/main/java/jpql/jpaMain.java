package jpql;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

public class jpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{

            Team teamA = new Team();
            teamA.setName("teamA");
            em.persist(teamA);

            Team teamB = new Team();
            teamB.setName("teamB");
            em.persist(teamB);

            Team teamC = new Team();
            teamC.setName("teamC");
            em.persist(teamC);

            Member member2 = new Member();
            member2.setUsername("member2");
            member2.setAge(20);
            member2.setTeam(teamA);
            em.persist(member2);

            Member member3 = new Member();
            member3.setUsername("member3");
            member3.setAge(60);
            member3.setTeam(teamB);
            em.persist(member3);

//            em.flush();
//            em.clear();


            Member member = new Member();
            member.setUsername("member1");
            member.setAge(10);
            member.setTeam(teamA);
            em.persist(member);

            // 이 시점에서 flush 호출


            int resultCount = em.createQuery("update Member m set m.age=20")
                    .executeUpdate();
            em.clear();

            Member findMember = em.find(Member.class, member.getId());
            System.out.println(findMember);




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
