package Model.DAO;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Entities.Agendamento;
import Model.Entities.Funcionario;

public class AgendamentoDAO {

	private static AgendamentoDAO instance;
	protected EntityManager entityManager;
	
	public static AgendamentoDAO getInstance() {
		if (instance == null) {
			instance = new AgendamentoDAO();
		}

		return instance;
	}
	
	private AgendamentoDAO() {
        entityManager = getEntityManager();
      }

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("exemplo-jpa");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}
	
	public void inserir(Agendamento agendamento) {
		entityManager.getTransaction().begin();;
		entityManager.merge(agendamento);
		entityManager.getTransaction().commit();
	}
	
	public void remover(Agendamento agendamento) {
		entityManager.getTransaction().begin();
		Agendamento agen = entityManager.find(Agendamento.class, agendamento.getId());
		entityManager.remove(agen);
		entityManager.getTransaction().commit();
	}
	
	public List<Agendamento> listarPorDia(LocalDate data) {
		
		entityManager.getTransaction().begin();
		List<Agendamento> agendamentos = entityManager.createNativeQuery("SELECT * FROM agendamento a where a.data = ?", Agendamento.class).setParameter(1,data).getResultList();
		return agendamentos;
	}
	
	public void listarPorFuncionario(Funcionario funcionario) {}
	
	
	
	
}
