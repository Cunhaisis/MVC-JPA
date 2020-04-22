package br.devisis.mvcjpa.dao;

import br.devisis.mvcjpa.entity.Pessoa;
import br.devisis.mvcjpa.util.JPAUtil;
import com.sun.org.glassfish.gmbal.ManagedAttribute;
import jdk.nashorn.internal.runtime.linker.LinkerCallSite;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

public abstract class GenericDAO<T extends Serializable> {

    private Class aClass;

    protected GenericDAO(Class aClass) {
        this.aClass = aClass;

    }

    protected EntityManager getEntityManager() {
        return JPAUtil.getInstance().getEntityManager();
    }

    /* Metodo de salvar (inserir)*/
    public void save(T entity) {
        EntityManager manager = getEntityManager();
        manager.getTransaction().begin();
        manager.persist(entity);
        manager.getTransaction().commit();
        manager.close();

    }
    /* Método de Atualizar */

    public void update(T entity) {
        EntityManager manager = getEntityManager();
        manager.getTransaction().begin();
        manager.merge(entity);
        manager.getTransaction().commit();
        manager.close();

    }

    /* Método Deletar */
    public void delete(Long id) {
        EntityManager manager = getEntityManager();
        manager.getTransaction().begin();
        manager.remove(manager.getReference(aClass, id));
        manager.getTransaction().commit();
        manager.close();

    }

    /* Método de Buscar por ID */
    public T findById(Long id) {
        EntityManager manager = getEntityManager();
        manager.getTransaction().begin();

        T entity = (T) manager.find(aClass, id);

        manager.getTransaction().commit();
        manager.close();
        return entity;


    }

    /* Método de busca geral */
    @SuppressWarnings("unchecked")
    public List<T> findall() {
        EntityManager manager = getEntityManager();
        manager.getTransaction().begin();

        Query query = manager.createQuery("SELECT p FROM Pessoa p", Pessoa.class);

        List<T> pessoas = query.getResultList();
        manager.getTransaction().commit();
        manager.close();

        return pessoas;
    }

    /* Busca por Parametro */

    @SuppressWarnings("unchecked")
    public List<T> find(String jpql, Object... params) {
        EntityManager manager = getEntityManager();
        manager.getTransaction().begin();

        Query query = manager.createQuery(jpql);

        for (int i = 0; i < params.length; i++) {
            query.setParameter(i + 1, params[i]);
        }
        List<T> pessoas = query.getResultList();
        manager.getTransaction().commit();
        manager.close();

        return pessoas;
    }

     /* Busca um por um */
    @SuppressWarnings("unchecked")
    public T findOne(String jpql, Object... params) {
        EntityManager manager = getEntityManager();
        manager.getTransaction().begin();

        Query query = manager.createQuery(jpql);

        for (int i = 0; i < params.length; i++) {
            query.setParameter(i + 1, params[i]);
        }
        T entity = (T) query.getSingleResult();
        manager.getTransaction().commit();
        manager.close();

        return entity;

    }
    public long count(){
        EntityManager manager = getEntityManager();
        manager.getTransaction().begin();

        Query query = manager.createQuery("select count(c) from " + aClass.getSimpleName() + " c ");

        long count = (Long) query.getSingleResult();

        manager.getTransaction().commit();
        manager.close();

        return count;
    }

}