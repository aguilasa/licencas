package br.com.furb.repository;

import br.com.furb.entity.FuncaoEntity;

public class FuncaoRepository extends Repository<FuncaoEntity> {


	public FuncaoRepository() {
        super();
    }

    public FuncaoEntity findById(Integer id) {
		try {
			FuncaoEntity instance = entityManager.find(FuncaoEntity.class, id);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
