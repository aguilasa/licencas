package br.com.furb.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class ChamadaHttp {

	private static ChamadaHttp instancia = new ChamadaHttp();

	private String urlBase;
	private HttpClient clienteHttp = HttpClientBuilder.create().build();
	private Map<String, String> cabecalhos = new LinkedHashMap<>();
	private String charset;

	private ChamadaHttp() {
	}

	public String getUrlBase() {
		return urlBase;
	}

	public void setUrlBase(String urlBase) {
		this.urlBase = urlBase;
	}

	public void addCabecalho(String nome, String valor) {
		cabecalhos.put(nome, valor);
	}

	public void limparCabecalhos() {
		cabecalhos.clear();
	}

	public RespostaHttp post(String metodo, String parametros) throws IOException {
		HttpPost req = new HttpPost(urlBase + "/" + metodo);

		for (Map.Entry<String, String> entry : cabecalhos.entrySet()) {
			req.addHeader(entry.getKey(), entry.getValue());
		}

		req.setEntity(new StringEntity(parametros, getCharset()));
		HttpResponse response = clienteHttp.execute(req);
		BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		StringBuilder conteudo = new StringBuilder();
		String line = "";
		while ((line = reader.readLine()) != null) {
			conteudo.append(line);
		}

		return new RespostaHttp(response.getStatusLine().getStatusCode(), conteudo.toString());
	}

	public RespostaHttp get(String metodo) throws IOException {
		HttpGet req = new HttpGet(urlBase + "/" + metodo);

		for (Map.Entry<String, String> entry : cabecalhos.entrySet()) {
			req.addHeader(entry.getKey(), entry.getValue());
		}

		HttpResponse response = clienteHttp.execute(req);

		RespostaHttp respostaHttp = new RespostaHttp(response.getStatusLine().getStatusCode());

		Header[] headers = response.getAllHeaders();
		for (Header h : headers) {
			respostaHttp.addCabecalho(h.getName(), h.getValue());
		}

		if (response.getEntity() != null) {
			StringBuilder conteudo = new StringBuilder();
			BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

			String line = "";
			String quebraLinha = System.getProperty("line.separator");
			while ((line = reader.readLine()) != null) {
				conteudo.append(line).append(quebraLinha);
			}
			respostaHttp.setConteudo(conteudo.toString());
		}

		return respostaHttp;
	}

	public static ChamadaHttp getInstancia() {
		return instancia;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charet) {
		this.charset = charet;
	}
}
