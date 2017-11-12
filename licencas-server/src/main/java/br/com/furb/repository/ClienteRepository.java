package br.com.furb.repository;

import br.com.furb.entity.ClienteEntity;

public class ClienteRepository extends Repository<ClienteEntity> {

	public ClienteRepository() {
        super();
    }

    public ClienteEntity findById(Integer id) {
		try {
			ClienteEntity instance = entityManager.find(ClienteEntity.class, id);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
