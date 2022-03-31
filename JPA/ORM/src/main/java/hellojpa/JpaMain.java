package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            // 수정 -> JPA가 관리하기 때문에. 바뀌면 이걸 감지한다. 변경 감지.
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("HelloJPA");

            List<Member> findMembers = em.createQuery("select m from Member as m", Member.class)
                    .getResultList();
            for (Member findMember : findMembers) {
                System.out.println("findMember = " + findMember.getName());
            }

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally{
            em.close();
        }

        emf.close();
    }
}
