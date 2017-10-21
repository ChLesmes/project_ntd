/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.project1.ntd.persistence;


import co.konrad.project1.ntd.entities.MetodoPagoEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Dairo
 */
@Stateless
public class MetodoPagoPersistence {
    
    
        @PersistenceContext(unitName = "Project1-NTDPU")
    protected EntityManager em;
    
    /**
     * Método para encontrar un objeto de la clase metodoPago a través de un id
     *
     * @param id
     * @return metodoPago *
     */
    public MetodoPagoEntity find(Long id) {
        MetodoPagoEntity metodoPago = em.find(MetodoPagoEntity.class, id);
        return metodoPago;
    }
    
    
    /**
     * Obtener todos los objetos encontrados en la tabla metodoPago
     *
     * @return listado de datos de la tabla
     *
     */
    public List<MetodoPagoEntity> findAll() {
        Query todos = em.createQuery("select u from MetodoPagoEntity u");
        return todos.getResultList();
    }
    
    
    /**
     * Creación de un nuevo registro
     *
     * @param metodoPago
     * @return metodoPago
     *
     */
    public MetodoPagoEntity create(MetodoPagoEntity metodoPago) {
        em.persist(metodoPago);
        return metodoPago;
    }
    
    /*Actualización de la entidad
        @param 
        @return merge entity*/
    public MetodoPagoEntity update(MetodoPagoEntity entity) {

        return em.merge(entity);
    }
    
    /**
     * Eliminar un objeto de la entidad
     *
     * @param id
     * @return metodoPagoUpdate*
     */
    public void delete(Long id) {
        MetodoPagoEntity metodoPagoDelete = em.find(MetodoPagoEntity.class, id);
        em.remove(metodoPagoDelete);
    }
    
}
