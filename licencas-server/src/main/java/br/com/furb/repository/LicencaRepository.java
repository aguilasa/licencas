package br.com.furb.repository;

import java.util.List;

import br.com.furb.entity.LicencaEntity;

public class LicencaRepository extends Repository<LicencaEntity> {

	public LicencaRepository() {
		super();
	}

	@SuppressWarnings("unchecked")
	public List<LicencaEntity> getLicencas() {
		return this.entityManager.createQuery("SELECT c FROM LicencaEntity c ORDER BY c.id").getResultList();
	}

	public LicencaEntity getLicenca(Integer id) {
		return this.entityManager.find(LicencaEntity.class, id);
	}

	public void removeById(Integer id) {
		LicencaEntity categoria = getLicenca(id);
		remove(categoria);
	}

	public LicencaEntity findById(Integer id) {
		try {
			LicencaEntity instance = entityManager.find(LicencaEntity.class, id);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}

}
