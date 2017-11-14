package br.com.furb.http;

import java.util.LinkedHashMap;
import java.util.Map;

public class RespostaHttp {
	private int codigo;
	private String conteudo;
	private Map<String, String> cabecalhos = new LinkedHashMap<String, String>();

	public RespostaHttp() {

	}

	public RespostaHttp(int codigo) {
		this(codigo, "");
	}

	public RespostaHttp(int codigo, String mensagem) {
		this.codigo = codigo;
		this.conteudo = mensagem;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public void addCabecalho(String nome, String valor) {
		cabecalhos.put(nome, valor);
	}

	public String getCabecalho(String nome) {
		if (cabecalhos.containsKey(nome)) {
			return cabecalhos.get(nome);
		}
		return "";
	}

	public Map<String, String> getCabecalhos() {
		return cabecalhos;
	}

	public boolean hasCabecalho(String nome) {
		return cabecalhos.containsKey(nome);
	}
}
