package Model.DAO;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Entities.Agendamento;
import Model.Entities.Agendamento;
import Model.Entities.Funcionario;
import Model.Entities.Servico;

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

	public Agendamento salvar(Agendamento agendamento) {

		try {
			entityManager.getTransaction().begin();
			if (agendamento.getId() == null) {
				entityManager.persist(agendamento);
			} else {
				entityManager.merge(agendamento);
			}

			entityManager.getTransaction().commit();
			return agendamento;

		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public void remover(int id) {
		try {
			entityManager.getTransaction().begin();
			Agendamento agendamento = entityManager.find(Agendamento.class, id);
			entityManager.remove(agendamento);
			entityManager.getTransaction().commit();

		} catch (Exception e) {
			e.getMessage();
			entityManager.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Agendamento> listarPorDia(LocalDate data) {
		return entityManager.createNativeQuery("SELECT * FROM agendamento a where a.data = ?", Agendamento.class)
				.setParameter(1, data).getResultList();
	}

}
