import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Entities.Cliente;

public class EntitiesTest {

	public static void main(String[] args) {
		
		Cliente c1 = new Cliente(null,"Aleff", "Masculino", LocalDate.of(1994, 6, 11),"88243023","Tabuleiro do Norte");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction();
		em.persist(c1);
		em.co
		
	}

}
