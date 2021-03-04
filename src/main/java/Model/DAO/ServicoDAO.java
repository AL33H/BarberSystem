package Model.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Entities.Servico;

public class ServicoDAO {
	
	private static ServicoDAO instance;
	protected EntityManager entityManager;
	
	public static ServicoDAO getInstance() {
		if (instance == null) {
			instance = new ServicoDAO();
		}

		return instance;
	}
	
	private ServicoDAO() {
        entityManager = getEntityManager();
      }

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("exemplo-jpa");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}
	
	public void inserir(Servico servico) {
		entityManager.getTransaction().begin();
		entityManager.merge(servico);
		entityManager.getTransaction().commit();
		
	}

}
