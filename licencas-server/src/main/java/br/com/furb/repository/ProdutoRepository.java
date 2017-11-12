package br.com.furb.repository;

import java.util.List;

import br.com.furb.entity.ProdutoEntity;

public class ProdutoRepository extends Repository<ProdutoEntity> {

	public ProdutoRepository() {
		super();
	}

	@SuppressWarnings("unchecked")
	public List<ProdutoEntity> getProdutos() {
		return this.entityManager.createQuery("SELECT p FROM ProdutoEntity p ORDER BY p.id").getResultList();
	}

	public ProdutoEntity getProduto(Integer id) {
		return this.entityManager.find(ProdutoEntity.class, id);
	}

	public void removeById(Integer id) {
		ProdutoEntity produto = getProduto(id);
		remove(produto);
	}
}
