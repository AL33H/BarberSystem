package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.ComponentOrientation;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.Box;

public class TelaAgendamento extends JFrame {



	public TelaAgendamento() throws HeadlessException {
		initComponents();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAgendamento frame = new TelaAgendamento();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField txtAaaaa;

	/**
	 * Create the frame.
	 */
	public void initComponents() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 766, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(56, 97, 658, 163);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"ID", "CLIENTE", "FUNCIONARIO", "SERVICO", "VALOR", "HORA"
			}
		));
		
		JLabel lblNewLabel = new JLabel("FILTRO");
		lblNewLabel.setBounds(56, 72, 46, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(97, 69, 503, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("FILTRAR");
		btnNewButton.setBounds(625, 68, 89, 23);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(56, 23, 658, 30);
		contentPane.add(panel);
		
		txtAaaaa = new JTextField();
		txtAaaaa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(txtAaaaa);
		txtAaaaa.setColumns(50);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(54, 263, 660, 44);
		contentPane.add(panel_1);
		
		JButton btnNewButton_1 = new JButton("ADICIONAR");
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("REMOVER");
		panel_1.add(btnNewButton_2);
	}
}
