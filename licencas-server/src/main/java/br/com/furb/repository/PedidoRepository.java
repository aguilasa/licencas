package br.com.furb.repository;

import br.com.furb.entity.PedidoEntity;

public class PedidoRepository extends Repository<PedidoEntity> {

	public PedidoRepository() {
        super();
    }

    public PedidoEntity findById(Integer id) {
		try {
			PedidoEntity instance = entityManager.find(PedidoEntity.class, id);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
