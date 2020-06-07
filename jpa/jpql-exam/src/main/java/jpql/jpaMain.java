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

            Member member = new Member();
            member.setUsername("member1");
            member.setAge(10);
            member.setTeam(teamA);
            member.setType(MemberType.ADMIN);
            em.persist(member);

            Member member2 = new Member();
            member2.setUsername("member2");
            member2.setAge(20);
            member2.setTeam(teamB);
            member2.setType(MemberType.USER);
            em.persist(member2);

            Member member3 = new Member();
            member3.setUsername("member3");
            member3.setAge(60);
            member3.setTeam(teamC);
            member3.setType(MemberType.ADMIN);
            em.persist(member3);

            em.flush();
            em.clear();


            String query = "select m.username from Team t join t.members m";

            List<Collection> result = em.createQuery(query, Collection.class)
                    .getResultList();

            for(int i=0; i<result.size(); ++i){
                System.out.println(result.get(0));
            }
            // 아래 처럼 탐색하면 안되는데 왜인지는 모르겠다.
//            for (Collection collection : result) {
//                System.out.println((Member)collection);;
//            }






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
