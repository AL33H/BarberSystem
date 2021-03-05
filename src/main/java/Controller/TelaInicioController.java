package Controller;

import View.TelaCliente;
import View.TelaInicio;


public class TelaInicioController {

	private final TelaInicio view;

	public TelaInicioController(TelaInicio view) {
		this.view = view;
	}

	public void chamarTelaCliente() {

		if (TelaCliente.instance == null) {
			new TelaCliente().setVisible(true);
		} else {
			TelaCliente.instance.dispose();

		}

	}

}
