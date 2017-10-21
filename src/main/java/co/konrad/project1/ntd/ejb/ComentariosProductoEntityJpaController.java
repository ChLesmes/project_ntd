/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.project1.ntd.ejb;

import co.konrad.project1.ntd.ejb.exceptions.NonexistentEntityException;
import co.konrad.project1.ntd.ejb.exceptions.PreexistingEntityException;
import co.konrad.project1.ntd.ejb.exceptions.RollbackFailureException;
import co.konrad.project1.ntd.entities.ComentarioProductoEntity;
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
public class ComentariosProductoEntityJpaController implements Serializable {

    public ComentariosProductoEntityJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ComentarioProductoEntity comentariosProductoEntity) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(comentariosProductoEntity);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findComentarioProductoEntity(comentariosProductoEntity.getId()) != null) {
                throw new PreexistingEntityException("ComentarioProductoEntity " + comentariosProductoEntity + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ComentarioProductoEntity comentariosProductoEntity) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            comentariosProductoEntity = em.merge(comentariosProductoEntity);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = comentariosProductoEntity.getId();
                if (findComentarioProductoEntity(id) == null) {
                    throw new NonexistentEntityException("The comentarioProductoEntity with id " + id + " no longer exists.");
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
            ComentarioProductoEntity comentariosProductoEntity;
            try {
                comentariosProductoEntity = em.getReference(ComentarioProductoEntity.class, id);
                comentariosProductoEntity.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The comentarioProductoEntity with id " + id + " no longer exists.", enfe);
            }
            em.remove(comentariosProductoEntity);
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

    public List<ComentarioProductoEntity> findComentarioProductoEntityEntities() {
        return findComentarioProductoEntityEntities(true, -1, -1);
    }

    public List<ComentarioProductoEntity> findComentarioProductoEntityEntities(int maxResults, int firstResult) {
        return findComentarioProductoEntityEntities(false, maxResults, firstResult);
    }

    private List<ComentarioProductoEntity> findComentarioProductoEntityEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ComentarioProductoEntity.class));
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

    public ComentarioProductoEntity findComentarioProductoEntity(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ComentarioProductoEntity.class, id);
        } finally {
            em.close();
        }
    }

    public int getComentarioProductoEntityCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ComentarioProductoEntity> rt = cq.from(ComentarioProductoEntity.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
