package br.com.furb.repository;

import br.com.furb.entity.CotacaoEntity;
import br.com.furb.entity.CotacaoId;

public class CotacaoRepository extends Repository<CotacaoEntity> {

	public CotacaoRepository() {
        super();
    }

    public CotacaoEntity findById(CotacaoId id) {
		try {
			CotacaoEntity instance = entityManager.find(CotacaoEntity.class, id);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
