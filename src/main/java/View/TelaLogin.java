package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.TelaLoginController;


import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import java.awt.HeadlessException;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;


public class TelaLogin extends JFrame {

	private final TelaLoginController controller;



	public TelaLogin() throws HeadlessException {
		initComponents();
		controller = new TelaLoginController(this);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPanel panel_1;
	private JPasswordField txtSenha;
	
	private void initComponents() {

		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBounds(58, 79, 149, 60);
		panel.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(7, 10, 36, 14);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(50, 7, 86, 20);
		txtUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setBounds(7, 35, 30, 14);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(50, 31, 86, 20);
		txtSenha.setColumns(10);
		panel_1.setLayout(null);
		panel_1.add(lblNewLabel);
		panel_1.add(txtUsuario);
		panel_1.add(lblNewLabel_1);
		panel_1.add(txtSenha);
		
		JButton btnLogar = new JButton("Logar");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.pegarUsuarioDaView();
			}
		});
		btnLogar.setBounds(89, 150, 89, 23);
		panel.add(btnLogar);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(TelaLogin.class.getResource("/View/imagens/All natural unisex apothecary handmade in Brooklyn NY since 2012_.jpg")));
		lblNewLabel_2.setBounds(0, 0, 288, 264);
		panel.add(lblNewLabel_2);
		
		
	}

	public JTextField getTxtUsuario() {
		return txtUsuario;
	}

	public void setTxtUsuario(JTextField txtUsuario) {
		this.txtUsuario = txtUsuario;
	}

	public JPasswordField getTxtSenha() {
		return txtSenha;
	}

	public void setTxtSenha(JPasswordField txtSenha) {
		this.txtSenha = txtSenha;
	}
}
