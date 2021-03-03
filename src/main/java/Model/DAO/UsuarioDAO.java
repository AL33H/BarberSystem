package Model.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.Session;

import Model.Entities.Usuario;

public class UsuarioDAO {

	

	public boolean Autenticar(String nome, String senha) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");

		EntityManager em = emf.createEntityManager();


		List lista = em.createNativeQuery("select * from usuario where nome = ?").setParameter(1,"joao").getResultList();
		
		

		if (lista.isEmpty()) {
			return false;

		} else
			return true;

	}
}
