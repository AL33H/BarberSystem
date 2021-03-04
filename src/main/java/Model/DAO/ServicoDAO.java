package Model.DAO;

import java.util.List;

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
	
	public Servico salvar(Servico servico) {	
		try {
			entityManager.getTransaction().begin();
			if (servico.getId() == null) {			
				entityManager.persist(servico);
			} else {
				entityManager.merge(servico);
			}

			entityManager.getTransaction().commit();
			return servico;
			
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}


	public void remover(int id) {
		try {
			entityManager.getTransaction().begin();
			Servico servico = entityManager.find(Servico.class, id);
			entityManager.remove(servico);
			entityManager.getTransaction().commit();
			
		}catch(Exception e) {
			e.getMessage();
			entityManager.getTransaction().rollback();
		}
	}
	

	public Servico procurarPorId(int id) {		
		return entityManager.find(Servico.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Servico> procurarTodos() {
		return entityManager.createNativeQuery("select * from servico", Servico.class)
				.getResultList();
	}


}
