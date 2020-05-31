package hellpjpa;

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
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("Member1");
            member.changeTeam(team);
            em.persist(member);


            em.flush();
            em.clear();

            Team findTeam = em.find(Team.class, team.getId());
            System.out.println(findTeam.getMembers().size());

            System.out.println(team.getMembers().size());

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
