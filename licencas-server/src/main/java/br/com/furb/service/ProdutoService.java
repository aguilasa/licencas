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
import br.com.furb.entity.ProdutoEntity;
import br.com.furb.model.Categoria;
import br.com.furb.model.Produto;
import br.com.furb.model.response.ProdutoResponse;
import br.com.furb.model.response.ProdutoResponseList;
import br.com.furb.repository.CategoriaRepository;
import br.com.furb.repository.ProdutoRepository;

@Path("/produto")
public class ProdutoService {

	private final ProdutoRepository produtoRepository = new ProdutoRepository();
	private final CategoriaRepository categoriaRepository = new CategoriaRepository();

	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/cadastrar")
	public ProdutoResponse cadastrar(Produto produto) {

		ProdutoEntity entity = new ProdutoEntity();

		try {
			CategoriaEntity categoria = categoriaRepository.getCategoria(produto.getCategoria().getId());
			
			entity.setId(null);
			entity.setCategoria(categoria);
			entity.setNome(produto.getNome());

			produtoRepository.persist(entity);

			produto.setId(entity.getId());

			return new ProdutoResponse(1, "Produto cadastrado com sucesso.", produto);
		} catch (Exception e) {
			return new ProdutoResponse(0, "Erro ao cadastrar o produto.", e.getMessage(), produto);
		}
	}

	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterar")
	public ProdutoResponse alterar(Produto produto) {

		ProdutoEntity entity = produtoRepository.getProduto(produto.getId());

		try {
			CategoriaEntity categoria = categoriaRepository.getCategoria(produto.getCategoria().getId());
			
			entity.setId(produto.getId());
			entity.setCategoria(categoria);
			entity.setNome(produto.getNome());

			produtoRepository.persist(entity);

			return new ProdutoResponse(1, "Produto alterado com sucesso.", produto);
		} catch (Exception e) {
			return new ProdutoResponse(0, "Erro ao alterar o produto.", e.getMessage(), produto);
		}
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/produtos")
	public ProdutoResponseList getCategorias() {

		try {
			List<Produto> produtos = new ArrayList<>();

			List<ProdutoEntity> lista = produtoRepository.getProdutos();

			for (ProdutoEntity entity : lista) {
				Categoria categoria = new Categoria(entity.getCategoria().getId(), entity.getCategoria().getCategoria());
				produtos.add(new Produto(entity.getId(), categoria, entity.getNome()));
			}

			ProdutoResponseList response = new ProdutoResponseList(1, null, produtos);
			response.setVazio(produtos.isEmpty());
			return response;
		} catch (Exception e) {
			ProdutoResponseList response = new ProdutoResponseList(0, null, e.getMessage(), null);
			response.setVazio(true);
			return response;
		}
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/produto/{id}")
	public Produto getProduto(@PathParam("id") Integer id) {

		ProdutoEntity entity = produtoRepository.getProduto(id);

		if (entity != null) {
			Categoria categoria = new Categoria(entity.getCategoria().getId(), entity.getCategoria().getCategoria());
			return new Produto(entity.getId(), categoria, entity.getNome());
		}

		return null;
	}

	@DELETE
	@Produces("application/json; charset=UTF-8")
	@Path("/excluir/{id}")
	public ProdutoResponse excluir(@PathParam("id") Integer id) {
		try {
			produtoRepository.removeById(id);
			return new ProdutoResponse(1, "Produto excluído com sucesso.", null);
		} catch (Exception e) {
			return new ProdutoResponse(0, "Erro ao excluir o Produto.", e.getMessage(), null);
		}
	}
}
