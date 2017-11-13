package br.com.furb.repository;

import java.util.List;

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
		return this.entityManager.createQuery("SELECT l FROM LicencaEntity l ORDER BY l.id").getResultList();
	}

	public UsoLicencaEntity getDisponivel() {
		List<?> lista = this.entityManager
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
