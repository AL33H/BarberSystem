import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.postgresql.util.PSQLException;

import Model.DAO.UsuarioDAO;
import Model.Entities.Agendamento;
import Model.Entities.Cliente;
import Model.Entities.Funcionario;
import Model.Entities.Servico;
import Model.Entities.Usuario;

public class EntitiesTest {

	public static void main(String[] args){

		Cliente c1 = new Cliente(null, "Aleff", "Masculino", LocalDate.of(1994, 6, 11), "88243023",
				"Tabuleiro do Norte");
		Cliente c2 = new Cliente(null, "Andrea", "Feminino", LocalDate.of(1993, 5, 12), "88243023",
				"Tabuleiro do Norte");
		Funcionario f1 = new Funcionario(null, "Maria", "Feminino", "Cabelereira");
		Funcionario f2 = new Funcionario(null, "Joselia", "Feminino", "Cabelereira");
		Servico s1 = new Servico(null, "Corte degradê", 20.00, 25);
		Servico s2 = new Servico(null, "Corte normal", 10.00, 15);
		Agendamento a1 = new Agendamento(null, c1, f1, s1, 25.00, LocalDate.now(), LocalTime.now(), 1);
		Agendamento a2 = new Agendamento(null, c2, f2, s2, 15.00, LocalDate.now(), LocalTime.now(), 1);
		Agendamento a3 = new Agendamento(null, c1, f1, s1, 15.00, LocalDate.now(), LocalTime.now(), 1);
		Agendamento a4 = new Agendamento(null, c2, f2, s1, 15.00, LocalDate.now(), LocalTime.now(), 1);
		Agendamento a5 = new Agendamento(null, c1, f1, s2, 15.00, LocalDate.now(), LocalTime.now(), 1);

		Usuario u1 = new Usuario(null, "aajoao", "123", 1);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");

		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		/*
		 * em.persist(c1); em.persist(f1); em.persist(s1); em.persist(c2);
		 * em.persist(f2); em.persist(s2);
		 * 
		 * 
		 * em.persist(a1); em.persist(a2); em.persist(a3); em.persist(a4);
		 * em.persist(a5);
		 * 
		 * em.persist(u1);
		 * 
		 * 
		 */
		em.getTransaction().commit();

		Agendamento agendamento1 = em.find(Agendamento.class, 1);

		List agendamentos = em.createQuery("from Agendamento").getResultList();

		UsuarioDAO usuariodao = new UsuarioDAO();

////////////////////////////////////////////////////////////////
		

		System.out.println(agendamento1.getCliente().getNome());
		System.out.println(agendamentos.size());
		System.out.println(usuariodao.Autenticar("pedro", "123123"));
		System.out.println(usuariodao.Autenticar("joao", "123"));
		System.out.println(usuariodao.Autenticar("joao", "1234"));

		em.close();
		emf.close();

	}

}
