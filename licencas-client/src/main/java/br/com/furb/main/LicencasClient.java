package br.com.furb.main;

import br.com.furb.licencas.GerenciadorLicencas;

public class LicencasClient {

	public static void main(String[] args) {
		try {
			GerenciadorLicencas.getInstancia().adquire();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
