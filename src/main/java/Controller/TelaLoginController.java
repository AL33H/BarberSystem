package Controller;

import javax.swing.JOptionPane;

import Model.DAO.UsuarioDAO;
import View.TelaInicio;
import View.TelaLogin;

public class TelaLoginController {

	private final TelaLogin view;

	public TelaLoginController(TelaLogin view) {
		this.view = view;
	}

	public void pegarUsuarioDaView() {

		if (UsuarioDAO.getInstance().Autenticar(view.getTxtUsuario().getText(), view.getTxtSenha().getText()) != null) {
			TelaInicio telainicio = new TelaInicio();
			telainicio.setVisible(true);
			view.dispose();

		} else {
			JOptionPane.showMessageDialog(view, "Usuario ou senha incorreto");
		}

	}

}
