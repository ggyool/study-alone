package jpabook.jpashop;

import com.sun.tools.corba.se.idl.constExpr.Or;
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
//            Member member = new Member();
//            member.setName("dummy name");
//            em.persist(member);
//            // 양방향으로 구축해 놓은 경우
////            Order order = new Order();
////            order.addOrderItem(new OrderItem());
//
//
//            // 단방향으로 구성 해 놓은 경우
//            Order order = new Order();
//            em.persist(order);
//            System.out.println("11111111");
//            OrderItem orderItem = new OrderItem();
//            orderItem.setOrder(order);
//            em.persist(orderItem);
//            System.out.println("2222222222");
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
