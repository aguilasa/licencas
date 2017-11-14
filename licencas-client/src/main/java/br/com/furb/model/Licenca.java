package br.com.furb.model;

import java.util.Date;

import org.json.JSONObject;

import br.com.furb.utils.DateParser;

public class Licenca {

	private int id;
	private String nome;
	private Date expiraEm = null;

	public Licenca() {

	}

	public Licenca(int id, String nome, Date expiraEm) {
		this.id = id;
		this.nome = nome;
		this.expiraEm = expiraEm;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getExpiraEm() {
		return expiraEm;
	}

	public void setExpiraEm(Date expiraEm) {
		this.expiraEm = expiraEm;
	}

	public void carregarJson(JSONObject json) {
		setExpiraEm(DateParser.parse(json.getString("expiraEm")));
		JSONObject jsonObject = json.getJSONObject("licenca");
		setId(jsonObject.getInt("id"));
		setNome(jsonObject.getString("nome"));
	}

}
