package ejb.in.ear.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton @Startup public class CheckDatabase {

  @PersistenceContext(unitName = "postgres") private EntityManager em;

  @PostConstruct private void checkDatabase() {
    Object singleResult = em.createNativeQuery("select 1").getSingleResult();
    System.out.println("Database query returned: " + singleResult);
  }
}
