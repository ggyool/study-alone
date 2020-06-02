package hellpjpa;

import hellpjpa.inheritance.Item;
import hellpjpa.inheritance.Movie;
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
            Movie movie = new Movie();
            movie.setDirector("directorA");
            movie.setActor("actorA");
            movie.setName("nameA");
            movie.setPrice(10000);
            em.persist(movie);

            em.flush();
            em.clear();

            Item item = em.find(Item.class, movie.getId());

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
