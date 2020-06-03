package jpabook.jpashop;

import com.sun.tools.corba.se.idl.constExpr.Or;
import jpabook.jpashop.domain.Book;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpashop");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Book book = new Book();
            book.setName("book1");
            book.setAuthor("p1");
            em.persist(book);


            tx.commit();
        } catch(Exception e){
            System.out.println("=============rollback===============");
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
