package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.TelaClienteController;

import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TelaCliente extends JFrame {

	private final TelaClienteController controller;
	public static TelaCliente instance = null;

	public TelaCliente(){
		initComponents();
		controller = new TelaClienteController(this);
		controller.preencherTabela();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					TelaCliente frame = new TelaCliente();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JPanel contentPane;
	private JTable tableCLIENTE;
	private JTextField textField;
	
	
	
	
	/**
	 * Create the frame.
	 */
	
	public void initComponents() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {

				instance = null;

			}
		});

		instance = this;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 135, 668, 179);
		contentPane.add(scrollPane);

		tableCLIENTE = new JTable();
		tableCLIENTE.setShowGrid(false);
		tableCLIENTE.setShowHorizontalLines(false);
		tableCLIENTE.setShowVerticalLines(false);
		scrollPane.setViewportView(tableCLIENTE);
		tableCLIENTE.setModel(new DefaultTableModel(
				new Object[][] {
						{ "1", "ALEFF REMBERTO FREIRE", "MASCULINO", "11/06/1994", "88999996720",
								"TABULEIRO DO NORTE" },
						{ "2", "ANDREA KARLA TAVARES", "FEMININO", "26/02/1994", "88999599343", "TABULEIRO DO NORTE" },
						{ "3", "RIERICK TAVARES", "MASCULINO", "28/01/2019", "88953423232", "TABULEIRO DO NORTE" }, },
				new String[] { "ID", "NOME", "SEXO", "DATA DE NASCIMENTO", "TELEFONE", "CIDADE" }));
		tableCLIENTE.getColumnModel().getColumn(0).setPreferredWidth(40);
		tableCLIENTE.getColumnModel().getColumn(1).setPreferredWidth(140);
		tableCLIENTE.getColumnModel().getColumn(2).setPreferredWidth(99);
		tableCLIENTE.getColumnModel().getColumn(3).setPreferredWidth(131);
		tableCLIENTE.getColumnModel().getColumn(4).setPreferredWidth(111);
		tableCLIENTE.getColumnModel().getColumn(5).setPreferredWidth(100);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(-1, 1, 686, 80);
		contentPane.add(panel);

		JLabel lblNewLabel = new JLabel("CLIENTES");
		lblNewLabel.setForeground(SystemColor.window);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("FILTRAR POR NOME");
		lblNewLabel_1.setBounds(8, 93, 131, 14);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(125, 89, 431, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("PESQUISAR");
		btnNewButton.setBounds(566, 90, 106, 23);
		contentPane.add(btnNewButton);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.window);
		panel_1.setBounds(6, 320, 668, 41);
		contentPane.add(panel_1);

		JButton btnNewButton_1 = new JButton("ADICIONAR");
		panel_1.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("REMOVER");
		panel_1.add(btnNewButton_2);

		JButton btnNewButton_4 = new JButton("EDITAR");
		panel_1.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("VOLTAR");
		panel_1.add(btnNewButton_5);

		this.setLocationRelativeTo(null);


	}

	public JTable getTableCLIENTE() {
		return tableCLIENTE;
	}

	public void setTableCLIENTE(JTable tableCLIENTE) {
		this.tableCLIENTE = tableCLIENTE;
	}

}
