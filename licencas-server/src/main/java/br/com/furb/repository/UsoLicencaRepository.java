package br.com.furb.repository;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.furb.entity.LicencaEntity;
import br.com.furb.entity.UsoLicencaEntity;

public class UsoLicencaRepository extends Repository<UsoLicencaEntity> {

	public UsoLicencaRepository() {
		super();
	}

	@SuppressWarnings("unchecked")
	public List<UsoLicencaEntity> getLicencas() {
		return this.entityManager.createQuery("SELECT c FROM UsoLicencaEntity c ORDER BY c.id").getResultList();
	}

	public UsoLicencaEntity getUsoLicenca(Integer id) {
		return this.entityManager.find(UsoLicencaEntity.class, id);
	}

	public void removeById(Integer id) {
		UsoLicencaEntity categoria = getUsoLicenca(id);
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

	public UsoLicencaEntity findByLicencaEntity(LicencaEntity licencaEntity) {
		TypedQuery<UsoLicencaEntity> query = this.entityManager.createQuery(
				"SELECT u FROM UsoLicencaEntity u WHERE u.licencaEntity = :licencaEntity", UsoLicencaEntity.class);
		query.setParameter("licencaEntity", licencaEntity);

		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
		}

		return null;
	}

}
