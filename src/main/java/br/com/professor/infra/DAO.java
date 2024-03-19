package br.com.professor.infra;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public abstract class DAO<E> {
    protected static EntityManagerFactory entityManagerFactory;
    protected EntityManager entityManager;
    private Class<E> entityClass;

    static{
        entityManagerFactory = Persistence
                                .createEntityManagerFactory("chamada-aula");
    }

    public DAO(Class<E> entityClass){
        this.entityManager = entityManagerFactory
                            .createEntityManager();
        this.entityClass = entityClass;
    }

    public DAO() {
        this(null);
    }

    public DAO<E> startTransaction(){
        this.entityManager.getTransaction().begin();
        return this;
    }

    public DAO<E> commitTransaction(){
        this.entityManager.getTransaction().commit();
        return this;
    }

    public DAO<E> addTransaction(E entity){
        this.entityManager.persist(entity);
        return this;
    }

    public DAO<E> mergeTransaction(E entity){
        this.entityManager.merge(entity);
        return this;
    }

    public DAO<E> addAtomicTransaction(E entity){
        return this.startTransaction().addTransaction(entity).commitTransaction();
    }

    public DAO<E> updateAtomicTransaction(E entity){
        return this.startTransaction().mergeTransaction(entity).commitTransaction();
    }

    public void close(){
        this.entityManager.close();
    }

    public abstract E getById(Object id);
}
