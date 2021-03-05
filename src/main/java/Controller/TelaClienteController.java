package Controller;

import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Model.DAO.ClienteDAO;
import Model.Entities.Cliente;
import View.TelaCliente;

public class TelaClienteController {

	private final TelaCliente view;
	
	public TelaClienteController(TelaCliente view) {
		this.view = view;
		
	}
	
	
	public void preencherTabela() {
		
		List<Cliente> clientes = ClienteDAO.getInstance().procurarTodos();
		
		DefaultTableModel tableCliente = (DefaultTableModel) view.getTableCLIENTE().getModel();
		
		tableCliente.setRowCount(0);
		
		for (Cliente cliente : clientes) {
			tableCliente.addRow(new Object[] {
				cliente.getId(),
				cliente.getNome(),
				cliente.getSexo(),
				cliente.getDatadenascimento(),
				cliente.getTelefone(),
				cliente.getCidade()});
			
		}
		
	}
	
	
}
