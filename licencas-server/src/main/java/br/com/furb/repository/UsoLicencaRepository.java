package br.com.furb.repository;

import java.util.List;

import br.com.furb.entity.UsoLicencaEntity;

public class UsoLicencaRepository extends Repository<UsoLicencaEntity> {

	public UsoLicencaRepository() {
		super();
	}

	@SuppressWarnings("unchecked")
	public List<UsoLicencaEntity> getLicencas() {
		return this.entityManager.createQuery("SELECT c FROM UsoLicencaEntity c ORDER BY c.id").getResultList();
	}

	public UsoLicencaEntity getLicenca(Integer id) {
		return this.entityManager.find(UsoLicencaEntity.class, id);
	}

	public void removeById(Integer id) {
		UsoLicencaEntity categoria = getLicenca(id);
		remove(categoria);
	}

	public UsoLicencaEntity findById(Integer id) {
		try {
			UsoLicencaEntity instance = entityManager.find(UsoLicencaEntity.class, id);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}

}
