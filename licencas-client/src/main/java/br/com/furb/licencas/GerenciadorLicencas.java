package br.com.furb.licencas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Date;
import java.util.Observable;

import javax.swing.Timer;

import org.json.JSONObject;

import br.com.furb.http.ChamadaHttp;
import br.com.furb.http.Constantes;
import br.com.furb.http.RespostaHttp;
import br.com.furb.model.Licenca;
import br.com.furb.utils.DateParser;

public class GerenciadorLicencas extends Observable implements ActionListener {

	private static GerenciadorLicencas instancia = new GerenciadorLicencas();

	private Licenca licenca = null;
	private boolean notificou = false;

	private GerenciadorLicencas() {
		Timer t = new Timer(1000, this);
		t.start();
	}

	public static GerenciadorLicencas getInstancia() {
		return instancia;
	}

	private ChamadaHttp http() {
		ChamadaHttp chamada = ChamadaHttp.getInstancia();
		chamada.setUrlBase(Constantes.URL_BASE);
		chamada.limparCabecalhos();
		chamada.addCabecalho("Content-Type", "application/json");
		chamada.setCharset("UTF-8");
		return chamada;
	}

	public Licenca getLicenca() {
		return licenca;
	}

	public void adquire() {
		ChamadaHttp chamada = http();

		RespostaHttp resposta;
		try {
			resposta = chamada.get(Constantes.ADQUIRE);
			JSONObject json = new JSONObject(resposta.getConteudo());

			if (json.has("sucesso") && json.getBoolean("sucesso")) {
				licenca = new Licenca();
				licenca.carregarJson(json);
			} else {
				licenca = null;
			}
		} catch (IOException e) {
			licenca = null;
		}
		notificou = false;
		notificar();
	}

	private void notificar() {
		setChanged();
		notifyObservers();
	}

	public void renova() {
		ChamadaHttp chamada = http();
		String metodo = String.format("%s/%d", Constantes.RENOVA, licenca.getId());
		RespostaHttp resposta;
		try {
			resposta = chamada.get(metodo);
			JSONObject json = new JSONObject(resposta.getConteudo());

			if (json.has("sucesso") && json.getBoolean("sucesso")) {
				licenca.setExpiraEm(DateParser.parse(json.getString("expiraEm")));
			}
		} catch (IOException e) {
			licenca = null;
		}
		notificou = false;
		notificar();
	}

	private void atualiza() {
		ChamadaHttp chamada = http();
		String metodo = String.format("%s/%d", Constantes.ATUALIZA, licenca.getId());
		RespostaHttp resposta;
		try {
			resposta = chamada.post(metodo, "");
			JSONObject json = new JSONObject(resposta.getConteudo());

			if (json.has("sucesso")) {
				licenca = null;
			}
		} catch (IOException e) {
			licenca = null;
		}
	}

	public boolean validar() {
		return licenca != null && new Date().getTime() < licenca.getExpiraEm().getTime();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!notificou && licenca != null && !validar()) {
			atualiza();
			notificou = true;
			notificar();
		}
	}
}
