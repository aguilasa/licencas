package br.com.furb.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.furb.entity.CategoriaEntity;
import br.com.furb.model.Categoria;
import br.com.furb.model.response.CategoriaResponse;
import br.com.furb.model.response.CategoriaResponseList;
import br.com.furb.repository.LicencaRepository;

@Path("/categoria")
public class LicencasService {

	private final LicencaRepository repository = new LicencaRepository();

	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/cadastrar")
	public CategoriaResponse cadastrar(Categoria categoria) {

		CategoriaEntity entity = new CategoriaEntity();

		try {
			entity.setId(null);
			entity.setCategoria(categoria.getCategoria());

			repository.persist(entity);

			categoria.setId(entity.getId());

			return new CategoriaResponse(1, "Categoria cadastrada com sucesso.", categoria);
		} catch (Exception e) {
			return new CategoriaResponse(0, "Erro ao cadastrar a categoria.", e.getMessage(), categoria);
		}
	}

	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterar")
	public CategoriaResponse alterar(Categoria categoria) {

		CategoriaEntity entity = repository.getLicenca(categoria.getId());

		try {
			entity.setCategoria(categoria.getCategoria());

			repository.persist(entity);

			return new CategoriaResponse(1, "Categoria alterada com sucesso.", categoria);
		} catch (Exception e) {
			return new CategoriaResponse(0, "Erro ao alterar a categoria.", e.getMessage(), categoria);
		}
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/categorias")
	public CategoriaResponseList getCategorias() {

		try {
			List<Categoria> categorias = new ArrayList<>();

			List<CategoriaEntity> lista = repository.getLicencas();

			for (CategoriaEntity entity : lista) {
				categorias.add(new Categoria(entity.getId(), entity.getCategoria()));
			}

			CategoriaResponseList response = new CategoriaResponseList(1, null, categorias);
			response.setVazio(categorias.isEmpty());
			return response;
		} catch (Exception e) {
			CategoriaResponseList response = new CategoriaResponseList(0, null, e.getMessage(), null);
			response.setVazio(true);
			return response;
		}
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/categoria/{id}")
	public Categoria getCategoria(@PathParam("id") Integer id) {

		CategoriaEntity entity = repository.getLicenca(id);

		if (entity != null)
			return new Categoria(entity.getId(), entity.getCategoria());

		return null;
	}

	@DELETE
	@Produces("application/json; charset=UTF-8")
	@Path("/excluir/{id}")
	public CategoriaResponse excluir(@PathParam("id") Integer id) {
		try {
			repository.removeById(id);
			return new CategoriaResponse(1, "Categoria excluída com sucesso.", null);
		} catch (Exception e) {
			return new CategoriaResponse(0, "Erro ao excluir a Categoria.", e.getMessage(), null);
		}
	}
}
