package Model.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Entities.Cliente;

public class ClienteDAO {

	private static ClienteDAO instance;
	protected EntityManager entityManager;

	public static ClienteDAO getInstance() {
		if (instance == null) {
			instance = new ClienteDAO();
		}

		return instance;
	}

	private ClienteDAO() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("exemplo-jpa");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}

	public Cliente salvar(Cliente cliente) {	
		try {
			entityManager.getTransaction().begin();
			if (cliente.getId() == null) {			
				entityManager.persist(cliente);
			} else {
				entityManager.merge(cliente);
			}

			entityManager.getTransaction().commit();
			return cliente;
			
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}


	public void remover(int id) {
		try {
			entityManager.getTransaction().begin();
			Cliente cliente = entityManager.find(Cliente.class, id);
			entityManager.remove(cliente);
			entityManager.getTransaction().commit();
			
		}catch(Exception e) {
			e.getMessage();
			entityManager.getTransaction().rollback();
		}
	}
	

	public Cliente procurarPorId(int id) {		
		return entityManager.find(Cliente.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> procurarTodos() {
		return entityManager.createNativeQuery("select * from cliente", Cliente.class)
				.getResultList();
	}
}
