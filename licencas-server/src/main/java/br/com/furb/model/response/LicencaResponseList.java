package br.com.furb.model.response;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import br.com.furb.model.Licenca;

@XmlRootElement
@XmlSeeAlso(Licenca.class)
public class LicencaResponseList extends ResponseList<Licenca> {
	public LicencaResponseList() {
	}

	public LicencaResponseList(int tipo, String mensagem, String erro, List<Licenca> lista) {
		super(tipo, mensagem, erro, lista);
	}

	public LicencaResponseList(int tipo, String mensagem, List<Licenca> lista) {
		super(tipo, mensagem, "", lista);
	}
}
