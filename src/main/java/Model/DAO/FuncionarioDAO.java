package Model.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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

	public void inserir(Funcionario funcionario) {
		entityManager.getTransaction().begin();
		entityManager.merge(funcionario);
		entityManager.getTransaction().commit();
	}
}
