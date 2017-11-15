package br.com.furb.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import br.com.furb.licencas.GerenciadorLicencas;
import br.com.furb.model.Licenca;
import br.com.furb.swing.TimerLabel;

public class Compilador extends JFrame implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1359695500729986589L;
	private JPanel contentPane;

	private JButton btnAdquirir;
	private JButton btnRenovar;
	private JButton btnCompilar;
	private TimerLabel lblTimer;
	private Licenca licenca;
	private JTextArea codigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Compilador frame = new Compilador();
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
	public Compilador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Licen\u00E7a", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel, BorderLayout.PAGE_START);

		btnAdquirir = new JButton("Adquirir");
		btnAdquirir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adquirirLicenca();
			}
		});
		panel.add(btnAdquirir);

		btnRenovar = new JButton("Renovar");
		btnRenovar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				renovarLicenca();
			}
		});
		panel.add(btnRenovar);

		lblTimer = new TimerLabel();
		panel.add(lblTimer);

		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel_1, BorderLayout.PAGE_END);

		btnCompilar = new JButton("Compilar");
		btnCompilar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				compilar();
			}
		});
		panel_1.add(btnCompilar);

		codigo = new JTextArea();
		contentPane.add(codigo, BorderLayout.CENTER);

		GerenciadorLicencas.getInstancia().addObserver(this);
		habilitarComponentes();
	}

	private void adquirirLicenca() {
		GerenciadorLicencas.getInstancia().adquire();
	}

	private void renovarLicenca() {
		GerenciadorLicencas.getInstancia().renova();
	}

	private void compilar() {
		boolean valido = codigo.getText().length() > 0;
		JOptionPane.showMessageDialog(this, String.format("Compilado com: %s", valido ? "sucesso" : "erro"));
	}

	private void setarRestante() {
		lblTimer.setFinalDate(licenca != null ? licenca.getExpiraEm() : null);
	}

	private void habilitarComponentes() {
		boolean valido = GerenciadorLicencas.getInstancia().validar();
		btnAdquirir.setEnabled(!valido);
		btnRenovar.setEnabled(valido);
		btnCompilar.setEnabled(valido);
	}

	@Override
	public void update(Observable o, Object arg) {
		GerenciadorLicencas g = (GerenciadorLicencas) o;
		licenca = g.getLicenca();
		setarRestante();
		habilitarComponentes();
	}

}
