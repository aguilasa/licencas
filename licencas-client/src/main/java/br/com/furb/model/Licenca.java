package br.com.furb.model;

public class Licenca {

    private int id;
    private String nome;

    public Licenca() {

    }

    public Licenca(int id, String nome) {
        super();
        this.id = id;
        this.nome = nome;
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

}
