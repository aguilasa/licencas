package br.com.furb.repository;

import br.com.furb.entity.EstoqueEntity;
import br.com.furb.entity.EstoqueId;

public class EstoqueRepository extends Repository<EstoqueEntity> {

    public EstoqueRepository() {
        super();
    }

    public EstoqueEntity findById(EstoqueId id) {
        try {
            EstoqueEntity instance = entityManager.find(EstoqueEntity.class, id);
            return instance;
        } catch (RuntimeException re) {
            throw re;
        }
    }
}
