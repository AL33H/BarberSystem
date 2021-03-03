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

	public void inserir(Cliente cliente) {
		

		entityManager.getTransaction().begin();
		entityManager.merge(cliente);
		entityManager.getTransaction().commit();

		
		
	}

	public void remover(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		Cliente cliente = em.find(Cliente.class, id);
		em.remove(cliente);
		em.getTransaction().commit();


	}

	public Cliente procurarPorId(int id) {

		entityManager.getTransaction().begin();
		Cliente cliente = entityManager.find(Cliente.class, id);
		entityManager.getTransaction().commit();


		return cliente;

	}

	public List<Cliente> procurarTodos() {

		entityManager.getTransaction().begin();
		List<Cliente> clientes = entityManager.createNativeQuery("select * from cliente", Cliente.class).getResultList();
		entityManager.getTransaction().commit();

		return clientes;

	}
}
