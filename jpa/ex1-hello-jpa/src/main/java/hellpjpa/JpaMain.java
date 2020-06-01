package hellpjpa;

import org.h2.result.UpdatableRow;

import javax.management.relation.Role;
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


            Member member1 = new Member();
            member1.setUsername("Member1");
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("Member2");
            em.persist(member2);

            Product p1 = new Product();
            p1.setName("p1");
            Product p2 = new Product();
            p2.setName("p2");
            em.persist(p1);
            em.persist(p2);

            MemberProduct mp = new MemberProduct();
            mp.setMember(member1);
            mp.setProduct(p1);

            MemberProduct mp2 = new MemberProduct();
            mp2.setMember(member1);
            mp2.setProduct(p2);

            em.persist(mp);
            em.persist(mp2);

//
//            em.flush();
//            em.clear();
//
//            Team findTeam = em.find(Team.class, team.getId());
//            System.out.println(findTeam.getMembers().size());
//
//            System.out.println(team.getMembers().size());

//            Member findMember = em.find(Member.class, member.getId());
//            List<Member> members = findMember.getTeam().getMembers();
//            for(Member m : members){
//                m.setTeam(newTeam);
//                System.out.println(m.getUsername());
//            }
            

            tx.commit();
        } catch (Exception e){
            System.out.println("======================rollback======================");
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
