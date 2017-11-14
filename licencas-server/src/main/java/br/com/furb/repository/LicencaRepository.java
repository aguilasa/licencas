package br.com.furb.repository;

import java.util.List;

import javax.persistence.Query;

import br.com.furb.entity.LicencaEntity;
import br.com.furb.entity.UsoLicencaEntity;
import br.com.furb.util.DateUtils;

public class LicencaRepository extends Repository<LicencaEntity> {

	private UsoLicencaRepository usoLicencaRepository = null;

	public LicencaRepository() {
		super();
	}

	private UsoLicencaRepository getUsoLicencaRepository() {
		if (usoLicencaRepository == null) {
			usoLicencaRepository = new UsoLicencaRepository();
		}
		return usoLicencaRepository;
	}

	@SuppressWarnings("unchecked")
	public List<LicencaEntity> getLicencas() {
		return entityManager.createQuery("SELECT l FROM LicencaEntity l ORDER BY l.id").getResultList();
	}

	public UsoLicencaEntity getDisponivel() {
		liberar();
		List<?> lista = entityManager
				.createQuery(
						"SELECT l FROM LicencaEntity l WHERE l NOT IN (SELECT u.licencaEntity FROM UsoLicencaEntity u) ORDER BY l.id")
				.getResultList();

		LicencaEntity licencaEntity = !lista.isEmpty() ? (LicencaEntity) lista.get(0) : null;

		if (licencaEntity != null) {
			UsoLicencaEntity usoLicencaEntity = new UsoLicencaEntity();
			usoLicencaEntity.setLicenca(licencaEntity);
			usoLicencaEntity.setExpiraEm(DateUtils.getExpiraEm());
			getUsoLicencaRepository().persist(usoLicencaEntity);
			return usoLicencaEntity;
		}

		return null;
	}

	public UsoLicencaEntity renova(Integer idLicenca) {
		liberar();
		LicencaEntity licencaEntity = getLicenca(idLicenca);

		if (licencaEntity != null) {
			UsoLicencaEntity usoLicencaEntity = getUsoLicencaRepository().findByLicencaEntity(licencaEntity);
			usoLicencaEntity.setExpiraEm(DateUtils.getExpiraEm());
			getUsoLicencaRepository().persist(usoLicencaEntity);
			return usoLicencaEntity;
		}

		return null;
	}

	public boolean atualiza(Integer idLicenca) {
		liberar();
		LicencaEntity licencaEntity = getLicenca(idLicenca);

		if (licencaEntity != null) {
			UsoLicencaEntity usoLicencaEntity = getUsoLicencaRepository().findByLicencaEntity(licencaEntity);

			if (usoLicencaEntity != null) {
				getUsoLicencaRepository().remove(usoLicencaEntity);
				return true;
			}
		}

		return false;
	}

	public LicencaEntity getLicenca(Integer id) {
		return entityManager.find(LicencaEntity.class, id);
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

	private void liberar() {
		try {
			entityManager.getTransaction().begin();
			Query query = entityManager.createQuery("delete from UsoLicencaEntity u where u.expiraEm < :expira");
			query.setParameter("expira", DateUtils.getLimite());
			query.executeUpdate();
			entityManager.flush();
			entityManager.getTransaction().commit();
		} catch (RuntimeException re) {
			entityManager.getTransaction().rollback();
			throw re;
		}
	}

}
