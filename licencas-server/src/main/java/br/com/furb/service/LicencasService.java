package br.com.furb.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.furb.entity.LicencaEntity;
import br.com.furb.entity.UsoLicencaEntity;
import br.com.furb.model.Adquire;
import br.com.furb.model.Atualiza;
import br.com.furb.model.Licenca;
import br.com.furb.model.Renova;
import br.com.furb.model.response.LicencaResponseList;
import br.com.furb.repository.LicencaRepository;

@Path("/licencas")
public class LicencasService {

	private final LicencaRepository repository = new LicencaRepository();

	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/listar")
	public LicencaResponseList getLicencas() {

		try {
			List<Licenca> licencas = new ArrayList<>();

			List<LicencaEntity> lista = repository.getLicencas();

			for (LicencaEntity entity : lista) {
				licencas.add(new Licenca(entity.getId(), entity.getNome()));
			}

			LicencaResponseList response = new LicencaResponseList(1, null, licencas);
			response.setVazio(licencas.isEmpty());
			return response;
		} catch (Exception e) {
			LicencaResponseList response = new LicencaResponseList(0, null, e.getMessage(), null);
			response.setVazio(true);
			return response;
		}
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/adquire")
	public Adquire adquire() {
		Adquire adquire = new Adquire();

		UsoLicencaEntity disponivel = repository.getDisponivel();
		if (disponivel != null) {
			adquire.setExpiraEm(disponivel.getExpiraEm());
			adquire.setLicenca(new Licenca(disponivel.getLicenca().getId(), disponivel.getLicenca().getNome()));
		}

		return adquire;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/renova/{id}")
	public Renova renova(@PathParam("id") Integer id) {
		Renova renova = new Renova();
		UsoLicencaEntity usoLicencaEntity = repository.renova(id);
		if (usoLicencaEntity != null) {
			renova.setExpiraEm(usoLicencaEntity.getExpiraEm());
		}
		return renova;
	}

	@POST
	@Produces("application/json; charset=UTF-8")
	@Path("/atualiza/{id}")
	public Atualiza atualiza(@PathParam("id") Integer id) {
		Atualiza atualiza = new Atualiza(repository.atualiza(id));
		return atualiza;
	}

}
