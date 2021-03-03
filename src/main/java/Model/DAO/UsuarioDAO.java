package Model.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import org.postgresql.util.PSQLException;

import Model.Entities.Usuario;

public class UsuarioDAO {


	public Usuario Autenticar(String nome, String senha) {
		
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
			EntityManager em = emf.createEntityManager();
			
			Usuario usuario = (Usuario) em
					.createNativeQuery("select * from usuario where nome = ? and senha = ?", Usuario.class)
					.setParameter(1, nome).setParameter(2, senha).getSingleResult();
			
			em.close();
			emf.close();
			return usuario;
		} catch (NoResultException nre) {
			return null;
		} 
	}

	public void Inserir(Usuario usuario) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();

		em.close();
		emf.close();

	}

	public Usuario procurarPorId(int id) {

		Usuario usuario = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		usuario = em.find(Usuario.class, id);
		em.getTransaction().commit();

		em.close();
		emf.close();

		return usuario;

	}

	public void Remover(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		Usuario p = em.find(Usuario.class, id);
		em.remove(p);
		em.getTransaction().commit();

		em.close();
		emf.close();

	}

	public void Atualizar(Usuario usuario) throws PSQLException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(usuario);
		em.getTransaction().commit();

		em.close();
		emf.close();

	}
}
