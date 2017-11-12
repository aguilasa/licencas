package br.com.furb.repository;

import java.util.List;

import br.com.furb.entity.CategoriaEntity;

public class CategoriaRepository extends Repository<CategoriaEntity> {

    public CategoriaRepository() {
        super();
    }
    
    @SuppressWarnings("unchecked")
	public List<CategoriaEntity> getCategorias() {
        return this.entityManager.createQuery("SELECT c FROM CategoriaEntity c ORDER BY c.id").getResultList();
    }

    public CategoriaEntity getCategoria(Integer id) {
        return this.entityManager.find(CategoriaEntity.class, id);
    }

    public void removeById(Integer id) {
        CategoriaEntity categoria = getCategoria(id);
        remove(categoria);
    }

}
