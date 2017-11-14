package br.com.furb.licencas;

import org.json.JSONObject;

import br.com.furb.http.ChamadaHttp;
import br.com.furb.http.Constantes;
import br.com.furb.http.RespostaHttp;
import br.com.furb.model.Licenca;

public class GerenciadorLicencas {

	private static GerenciadorLicencas instancia = new GerenciadorLicencas();

	private GerenciadorLicencas() {
	}

	public static GerenciadorLicencas getInstancia() {
		return instancia;
	}

	public Licenca adquire() throws Exception {
		ChamadaHttp chamada = ChamadaHttp.getInstancia();
		chamada.setUrlBase(Constantes.URL_BASE);
		chamada.limparCabecalhos();
		chamada.addCabecalho("Content-Type", "application/json;charset=utf-8");
		chamada.setCharset("UTF-8");

		RespostaHttp resposta = chamada.get(Constantes.ADQUIRE);
		JSONObject json = new JSONObject(resposta.getConteudo());

		if (json.has("sucesso") && json.getBoolean("sucesso")) {
			Licenca licenca = new Licenca();
			licenca.carregarJson(json);
			return licenca;
		}
		return null;
	}

	public void renova(Licenca licenca) {
	}

	public void atualiza(Licenca licenca) {
	}
}
