package br.com.furb.repository;

import br.com.furb.entity.ItemProdutoEntity;
import br.com.furb.entity.ItemProdutoId;

public class ItemProdutoRepository extends Repository<ItemProdutoId> {

	public ItemProdutoRepository() {
        super();
    }

    public ItemProdutoEntity findById(ItemProdutoId id) {
		try {
			ItemProdutoEntity instance = entityManager.find(ItemProdutoEntity.class, id);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
