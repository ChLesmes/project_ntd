/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.project1.ntd.ejb;

import co.konrad.project1.ntd.ejb.exceptions.NonexistentEntityException;
import co.konrad.project1.ntd.ejb.exceptions.PreexistingEntityException;
import co.konrad.project1.ntd.ejb.exceptions.RollbackFailureException;
import co.konrad.project1.ntd.entities.ProductoEntity;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;

/**
 *
 * @author PC
 */
public class ProductoEntityJpaController implements Serializable {

    public ProductoEntityJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ProductoEntity productoEntity) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(productoEntity);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findProductoEntity(productoEntity.getId()) != null) {
                throw new PreexistingEntityException("ProductoEntity " + productoEntity + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ProductoEntity productoEntity) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            productoEntity = em.merge(productoEntity);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = productoEntity.getId();
                if (findProductoEntity(id) == null) {
                    throw new NonexistentEntityException("The productoEntity with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            ProductoEntity productoEntity;
            try {
                productoEntity = em.getReference(ProductoEntity.class, id);
                productoEntity.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The productoEntity with id " + id + " no longer exists.", enfe);
            }
            em.remove(productoEntity);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ProductoEntity> findProductoEntityEntities() {
        return findProductoEntityEntities(true, -1, -1);
    }

    public List<ProductoEntity> findProductoEntityEntities(int maxResults, int firstResult) {
        return findProductoEntityEntities(false, maxResults, firstResult);
    }

    private List<ProductoEntity> findProductoEntityEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ProductoEntity.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public ProductoEntity findProductoEntity(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ProductoEntity.class, id);
        } finally {
            em.close();
        }
    }

    public int getProductoEntityCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ProductoEntity> rt = cq.from(ProductoEntity.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
