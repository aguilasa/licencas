package br.com.furb.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="categoria") 
public class Categoria {

    private int id;
    private String categoria;

    public Categoria() {

    }

    public Categoria(int id, String categoria) {
        super();
        this.id = id;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

}
