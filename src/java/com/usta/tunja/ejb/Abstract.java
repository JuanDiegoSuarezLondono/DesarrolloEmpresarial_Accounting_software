package com.usta.tunja.ejb;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public abstract class Abstract<T> {

    private final Class<T> entidad;

    protected abstract EntityManager getAdmEntidad();

    public Abstract(Class<T> entidad) {
        this.entidad = entidad;
    }

    public void grabar(T entidad) {
        getAdmEntidad().persist(entidad);
    }

    public List<T> listar() {
        CriteriaBuilder cb = getAdmEntidad().getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(entidad);
        cq.select(cq.from(entidad));
        List<T> allData = getAdmEntidad().createQuery(cq).getResultList();
        return allData;
    }

    public void borrar(T entidad) {
        getAdmEntidad().remove(getAdmEntidad().merge(entidad));
    }

    public void actualizar(T entidad) {
        getAdmEntidad().merge(entidad);
    }

    public T buscar(Object id) {
        return getAdmEntidad().find(entidad, id);
    }
}
