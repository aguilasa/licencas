package br.com.furb.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import br.com.furb.licencas.GerenciadorLicencas;
import br.com.furb.swing.TimerLabel;

public class Compilador extends JFrame implements Observer, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1359695500729986589L;
	private JPanel contentPane;

	private JButton btnAdquirir;
	private JButton btnRenovar;
	private JButton btnCompilar;
	private TimerLabel lblTimer;
	private JTextArea codigo;
	private boolean esperando = false;
	private GerenciadorLicencas gerenciador = GerenciadorLicencas.getInstancia();
	private JLabel lblAguardando;
	private int contador = 0;

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
		setResizable(false);
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

		lblAguardando = new JLabel("Aguardando Licen\u00E7a");
		lblAguardando.setForeground(Color.RED);
		lblAguardando.setVisible(false);
		panel.add(lblAguardando);

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

		gerenciador.addObserver(this);
		habilitarComponentes();
		Timer t = new Timer(1000, this);
		t.start();
	}

	private void adquirirLicenca() {
		gerenciador.adquire();
		esperando = gerenciador.getLicenca() == null;
		contador = 0;
	}

	private void renovarLicenca() {
		gerenciador.renova();
	}

	private void compilar() {
		boolean valido = codigo.getText().length() > 0;
		JOptionPane.showMessageDialog(this, String.format("Compilado com: %s", valido ? "sucesso" : "erro"));
	}

	private void setarRestante() {
		lblTimer.setFinalDate(gerenciador.getLicenca() != null ? gerenciador.getLicenca().getExpiraEm() : null);
	}

	private void habilitarComponentes() {
		boolean valido = gerenciador.validar();
		btnAdquirir.setEnabled(!valido && !esperando);
		btnRenovar.setEnabled(valido);
		btnCompilar.setEnabled(valido);
		// lblAguardando.setVisible(esperando);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (esperando) {
			esperando = gerenciador.getLicenca() == null;
		}
		setarRestante();
		habilitarComponentes();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean visible = false;
		if (esperando) {
			visible = !lblAguardando.isVisible();
			if (contador < 180) {
				if ((contador % 5) == 0) {
					gerenciador.adquire();
					esperando = gerenciador.getLicenca() == null;
					if (!esperando) {
						visible = false;
					}
				}
				contador++;
			} else {
				contador = 0;
				esperando = false;
				visible = false;
			}
			System.out.println(contador);
		}

		lblAguardando.setVisible(visible);
		habilitarComponentes();
	}

}
