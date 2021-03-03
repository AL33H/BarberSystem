import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import Model.DAO.ClienteDAO;
import Model.DAO.UsuarioDAO;
import Model.Entities.Agendamento;
import Model.Entities.Cliente;
import Model.Entities.Funcionario;
import Model.Entities.Servico;
import Model.Entities.Usuario;

public class EntitiesTest {

	public static void main(String[] args) {

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

		Usuario u1 = new Usuario(null, "Aqui", "123", 1);
		Usuario u2 = new Usuario(null, "L", "123", 1);

		UsuarioDAO.getInstance().inserir(u1);
		UsuarioDAO.getInstance().inserir(u2);

		ClienteDAO.getInstance().inserir(c1);

		ClienteDAO.getInstance().inserir(c2);

		List<Cliente> clientes = ClienteDAO.getInstance().procurarTodos();

		for (Cliente cliente : clientes) {
			System.out.println(cliente);
		}

		Cliente cli = ClienteDAO.getInstance().procurarPorId(1);
		cli.setNome("ALEFF MUDADO");
		ClienteDAO.getInstance().inserir(cli);

		List<Cliente> client = ClienteDAO.getInstance().procurarTodos();

		for (Cliente cliente : client) {
			System.out.println(cliente);
		}

		// System.out.println(UsuarioDAO.getInstance().Autenticar("pedro", "123123"));
		// System.out.println(UsuarioDAO.getInstance().Autenticar("Aqui", "123"));
		// System.out.println(UsuarioDAO.getInstance().Autenticar("Aqui", "123"));

	}

}
