package Model.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Entities.Cliente;
import Model.Entities.Funcionario;
import Model.Entities.Servico;

public class FuncionarioDAO {
	private static FuncionarioDAO instance;
	protected EntityManager entityManager;

	public static FuncionarioDAO getInstance() {
		if (instance == null) {
			instance = new FuncionarioDAO();
		}

		return instance;
	}

	private FuncionarioDAO() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("exemplo-jpa");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}

	public Funcionario salvar(Funcionario funcionario) {
		try {

			entityManager.getTransaction().begin();
			if (funcionario.getId() == null) {

				entityManager.persist(funcionario);
			} else {

				entityManager.merge(funcionario);
			}

			entityManager.getTransaction().commit();
			return funcionario;

		} catch (Exception e) {
			e.getMessage();
			return null;

		}

	}

	public void remover(int id) {
		try {
			entityManager.getTransaction().begin();
			Funcionario funcionario = entityManager.find(Funcionario.class, id);
			entityManager.remove(funcionario);
			entityManager.getTransaction().commit();

		} catch (Exception e) {
			e.getMessage();
			entityManager.getTransaction().rollback();
		}
	}

	public Funcionario procurarPorId(int id) {
		return entityManager.find(Funcionario.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> procurarTodos() {
		return entityManager.createNativeQuery("select * from funcionario", Funcionario.class)
				.getResultList();
	}
	
}
