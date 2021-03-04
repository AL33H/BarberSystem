package Model.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

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

	public Usuario salvar(Usuario usuario) {	
		try {
			entityManager.getTransaction().begin();
			if (usuario.getId() == null) {			
				entityManager.persist(usuario);
			} else {
				entityManager.merge(usuario);
			}

			entityManager.getTransaction().commit();
			return usuario;
			
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}


	public void remover(int id) {
		try {
			entityManager.getTransaction().begin();
			Usuario usuario = entityManager.find(Usuario.class, id);
			entityManager.remove(usuario);
			entityManager.getTransaction().commit();
			
		}catch(Exception e) {
			e.getMessage();
			entityManager.getTransaction().rollback();
		}
	}
	

	public Usuario procurarPorId(int id) {		
		return entityManager.find(Usuario.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> procurarTodos() {
		return entityManager.createNativeQuery("select * from usuario", Usuario.class)
				.getResultList();
	}

	

}
