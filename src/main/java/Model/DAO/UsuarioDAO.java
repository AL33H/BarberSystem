package Model.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import org.postgresql.util.PSQLException;

import Model.Entities.Usuario;

public class UsuarioDAO {

	private static UsuarioDAO instance;
	protected EntityManager entityManager;

	public static UsuarioDAO getInstance() {
		if (instance == null) {
			instance = new UsuarioDAO();
		}

		return instance;
	}

	private UsuarioDAO() {
        entityManager = getEntityManager();
      }

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("exemplo-jpa");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}

	public void inserir(Usuario usuario) {

		entityManager.getTransaction().begin();
		entityManager.merge(usuario);
		entityManager.getTransaction().commit();


	}

	public Usuario Autenticar(String nome, String senha) {

		try {

			Usuario usuario = (Usuario) entityManager
					.createNativeQuery("select * from usuario where nome = ? and senha = ?", Usuario.class)
					.setParameter(1, nome).setParameter(2, senha).getSingleResult();

			return usuario;
		} catch (NoResultException nre) {
			return null;
		}
	}

	public Usuario procurarPorId(int id) {
		Usuario usuario = null;
		entityManager.getTransaction().begin();
		usuario = entityManager.find(Usuario.class, id);
		entityManager.getTransaction().commit();
		return usuario;
	}

	public void Remover(int id) {
		entityManager.getTransaction().begin();
		Usuario p = entityManager.find(Usuario.class, id);
		entityManager.remove(p);
		entityManager.getTransaction().commit();
	}

	public void Atualizar(Usuario usuario) {
		entityManager.getTransaction().begin();
		entityManager.merge(usuario);
		entityManager.getTransaction().commit();
	}
}
