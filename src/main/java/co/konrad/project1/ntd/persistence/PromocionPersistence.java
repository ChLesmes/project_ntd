/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.project1.ntd.persistence;


import co.konrad.project1.ntd.entities.PromocionEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * 
 * @author Dairo, Fabian, Cristian
 * 
 */
@Stateless
public class PromocionPersistence {
    
    
    @PersistenceContext(unitName = "Project1-NTDPU")
    protected EntityManager em;
    
    /**
     * Método para encontrar un objeto de la clase promocion a través de un id
     *
     * @param id
     * @return promocion *
     */
    public PromocionEntity find(Long id) {
        PromocionEntity promocion = em.find(PromocionEntity.class, id);
        return promocion;
    }
    
    
    /**
     * Obtener todos los objetos encontrados en la tabla promocion
     *
     * @return listado de datos de la tabla
     *
     */
    public List<PromocionEntity> findAll() {
        Query todos = em.createQuery("select u from PromocionEntity u");
        return todos.getResultList();
    }
    
    
    /**
     * Creación de un nuevo registro
     *
     * @param promocion
     * @return promocion
     *
     */
    public PromocionEntity create(PromocionEntity promocion) {
        em.persist(promocion);
        return promocion;
    }
    
    /*Actualización de la entidad
        @param 
        @return merge entity*/
    public PromocionEntity update(PromocionEntity entity) {

        return em.merge(entity);
    }
    
    /**
     * Eliminar un objeto de la entidad
     *
     * @param id
     * @return promocionUpdate*
     */
    public void delete(Long id) {
        PromocionEntity promocionDelete = em.find(PromocionEntity.class, id);
        em.remove(promocionDelete);
    }
    
    
}
