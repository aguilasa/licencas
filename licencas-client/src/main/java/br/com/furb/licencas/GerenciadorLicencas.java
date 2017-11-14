package br.com.furb.licencas;

import org.json.JSONObject;

import br.com.furb.http.ChamadaHttp;
import br.com.furb.http.Constantes;
import br.com.furb.http.RespostaHttp;
import br.com.furb.model.Licenca;
import br.com.furb.utils.DateParser;

public class GerenciadorLicencas {

	private static GerenciadorLicencas instancia = new GerenciadorLicencas();

	private GerenciadorLicencas() {
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

	public Licenca adquire() throws Exception {
		ChamadaHttp chamada = http();

		RespostaHttp resposta = chamada.get(Constantes.ADQUIRE);
		JSONObject json = new JSONObject(resposta.getConteudo());

		if (json.has("sucesso") && json.getBoolean("sucesso")) {
			Licenca licenca = new Licenca();
			licenca.carregarJson(json);
			return licenca;
		}
		return null;
	}

	public void renova(Licenca licenca) throws Exception {
		ChamadaHttp chamada = http();

		String metodo = String.format("%s/%d", Constantes.RENOVA, licenca.getId());
		RespostaHttp resposta = chamada.get(metodo);
		JSONObject json = new JSONObject(resposta.getConteudo());

		if (json.has("sucesso") && json.getBoolean("sucesso")) {
			licenca.setExpiraEm(DateParser.parse(json.getString("expiraEm")));
		}
	}

	public void atualiza(Licenca licenca) {
	}
}
