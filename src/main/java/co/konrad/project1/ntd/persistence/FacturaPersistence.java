/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.project1.ntd.persistence;

import co.konrad.project1.ntd.entities.FacturaEntity;
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
public class FacturaPersistence {
    
    
    @PersistenceContext(unitName = "Project1-NTDPU")
    protected EntityManager em;
    
    /**
     * Método para encontrar un objeto de la clase factura a través de un id
     *
     * @param id
     * @return factura *
     */
    public FacturaEntity find(Long id) {
        FacturaEntity factura = em.find(FacturaEntity.class, id);
        return factura;
    }
    
    
    /**
     * Obtener todos los objetos encontrados en la tabla factura
     *
     * @return listado de datos de la tabla
     *
     */
    public List<FacturaEntity> findAll() {
        Query todos = em.createQuery("select u from FacturaEntity u");
        return todos.getResultList();
    }
    
    
    /**
     * Creación de un nuevo registro
     *
     * @param factura
     * @return factura
     *
     */
    public FacturaEntity create(FacturaEntity factura) {
        em.persist(factura);
        return factura;
    }
    
    /*Actualización de la entidad
        @param 
        @return merge entity*/
    public FacturaEntity update(FacturaEntity entity) {

        return em.merge(entity);
    }
    
    /**
     * Eliminar un objeto de la entidad
     *
     * @param id
     * @return facturaUpdate*
     */
    public void delete(Long id) {
        FacturaEntity facturaDelete = em.find(FacturaEntity.class, id);
        em.remove(facturaDelete);
    }
    
    
}
