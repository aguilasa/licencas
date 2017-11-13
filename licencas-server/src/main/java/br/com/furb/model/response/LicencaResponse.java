package br.com.furb.model.response;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import br.com.furb.model.Licenca;

@XmlRootElement
@XmlSeeAlso(Licenca.class)
public class LicencaResponse extends Response<Licenca> {

	public LicencaResponse() {
	}

	public LicencaResponse(int tipo, String mensagem, String erro, Licenca licenca) {
		super(tipo, mensagem, erro, licenca);
	}

	public LicencaResponse(int tipo, String mensagem, Licenca licenca) {
		super(tipo, mensagem, licenca);
	}

}
