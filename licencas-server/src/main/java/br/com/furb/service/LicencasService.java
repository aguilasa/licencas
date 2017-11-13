package br.com.furb.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.furb.entity.LicencaEntity;
import br.com.furb.entity.UsoLicencaEntity;
import br.com.furb.model.Adquire;
import br.com.furb.model.Licenca;
import br.com.furb.model.Renova;
import br.com.furb.model.response.LicencaResponseList;
import br.com.furb.repository.LicencaRepository;
import br.com.furb.util.DateUtils;

@Path("/licencas")
public class LicencasService {

	private final LicencaRepository repository = new LicencaRepository();

	// @POST
	// @Consumes("application/json; charset=UTF-8")
	// @Produces("application/json; charset=UTF-8")
	// @Path("/cadastrar")
	// public LicencaResponse cadastrar(Licenca categoria) {
	//
	// CategoriaEntity entity = new CategoriaEntity();
	//
	// try {
	// entity.setId(null);
	// entity.setCategoria(categoria.getCategoria());
	//
	// repository.persist(entity);
	//
	// categoria.setId(entity.getId());
	//
	// return new LicencaResponse(1, "Categoria cadastrada com sucesso.",
	// categoria);
	// } catch (Exception e) {
	// return new LicencaResponse(0, "Erro ao cadastrar a categoria.",
	// e.getMessage(), categoria);
	// }
	// }
	//
	// @PUT
	// @Produces("application/json; charset=UTF-8")
	// @Consumes("application/json; charset=UTF-8")
	// @Path("/alterar")
	// public LicencaResponse alterar(Licenca categoria) {
	//
	// CategoriaEntity entity = repository.getLicenca(categoria.getId());
	//
	// try {
	// entity.setCategoria(categoria.getCategoria());
	//
	// repository.persist(entity);
	//
	// return new LicencaResponse(1, "Categoria alterada com sucesso.",
	// categoria);
	// } catch (Exception e) {
	// return new LicencaResponse(0, "Erro ao alterar a categoria.",
	// e.getMessage(), categoria);
	// }
	// }

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

	// @GET
	// @Produces("application/json; charset=UTF-8")
	// @Path("/categoria/{id}")
	// public Licenca getCategoria(@PathParam("id") Integer id) {
	//
	// CategoriaEntity entity = repository.getLicenca(id);
	//
	// if (entity != null)
	// return new Licenca(entity.getId(), entity.getCategoria());
	//
	// return null;
	// }
	//
	// @DELETE
	// @Produces("application/json; charset=UTF-8")
	// @Path("/excluir/{id}")
	// public LicencaResponse excluir(@PathParam("id") Integer id) {
	// try {
	// repository.removeById(id);
	// return new LicencaResponse(1, "Categoria excluída com sucesso.", null);
	// } catch (Exception e) {
	// return new LicencaResponse(0, "Erro ao excluir a Categoria.",
	// e.getMessage(), null);
	// }
	// }
}
