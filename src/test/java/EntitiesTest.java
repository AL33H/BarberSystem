import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import Model.DAO.AgendamentoDAO;
import Model.DAO.ClienteDAO;
import Model.DAO.FuncionarioDAO;
import Model.DAO.ServicoDAO;
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

		Cliente cliente = ClienteDAO.getInstance().salvar(c1);

		System.out.println(cliente);

		cliente.setNome("Thiago");

		Cliente cliente2 = ClienteDAO.getInstance().salvar(cliente);

		List<Cliente> clientes = ClienteDAO.getInstance().procurarTodos();

		for (Cliente cliente3 : clientes) {
			System.out.println(cliente3);
		}

		System.out.println(cliente);
		System.out.println(cliente2);



		Usuario u1 = new Usuario(null, "Aqui", "123", 1);
		Usuario u2 = new Usuario(null, "L", "123", 1);

		Scanner ler = new Scanner(System.in);
		int escolha = 0;

		while (escolha != 6) {
			System.out.println("Escolha um numero");
			escolha = ler.nextInt();

			switch (escolha) {

			case 1:
				u1 = UsuarioDAO.getInstance().salvar(u1);
				u2 = UsuarioDAO.getInstance().salvar(u2);
				System.out.println("Usuario adicionado!");
				break;
			case 2:
				c1 = ClienteDAO.getInstance().salvar(c1);
				c2 = ClienteDAO.getInstance().salvar(c2);
				System.out.println("Cliente adicionado!");
				break;
			case 3:
				s1 = ServicoDAO.getInstance().salvar(s1);
				s2 = ServicoDAO.getInstance().salvar(s2);
				System.out.println("Servico adicionado!");
				break;
			case 4:
				f1 = FuncionarioDAO.getInstance().salvar(f1);
				f2 = FuncionarioDAO.getInstance().salvar(f2);
				System.out.println("Funcionario adicionado!");
				break;

			case 5:
				Agendamento a1 = new Agendamento(null, c1, f1, s1, 25.00, LocalDate.now(), LocalTime.now(), 1);
				Agendamento a2 = new Agendamento(null, c2, f2, s2, 15.00, LocalDate.now(), LocalTime.now(), 1);
				Agendamento a3 = new Agendamento(null, c1, f1, s1, 15.00, LocalDate.now(), LocalTime.now(), 1);
				Agendamento a4 = new Agendamento(null, c2, f2, s1, 15.00, LocalDate.now(), LocalTime.now(), 1);
				Agendamento a5 = new Agendamento(null, c1, f1, s2, 15.00, LocalDate.now(), LocalTime.now(), 1);
				
				
				
				AgendamentoDAO.getInstance().salvar(a1);
				AgendamentoDAO.getInstance().salvar(a2);
				AgendamentoDAO.getInstance().salvar(a3);
				AgendamentoDAO.getInstance().salvar(a4);
				AgendamentoDAO.getInstance().salvar(a5);
				break;
			case 6:
				break;

			}
		}

		// AgendamentoDAO.getInstance().inserir(a1);
		// AgendamentoDAO.getInstance().inserir(a2);

	}

}
