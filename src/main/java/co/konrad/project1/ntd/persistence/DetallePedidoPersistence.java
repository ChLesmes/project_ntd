/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.project1.ntd.persistence;


import co.konrad.project1.ntd.entities.DetallePedidoEntity;
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

public class DetallePedidoPersistence {
    
    
    @PersistenceContext(unitName = "Project1-NTDPU")
    protected EntityManager em;
    
    /**
     * Método para encontrar un objeto de la clase detallePedido a través de un id
     *
     * @param id
     * @return detallePedido *
     */
    public DetallePedidoEntity find(Long id) {
        DetallePedidoEntity detallePedido = em.find(DetallePedidoEntity.class, id);
        return detallePedido;
    }
    
    
    /**
     * Obtener todos los objetos encontrados en la tabla detallePedido
     *
     * @return listado de datos de la tabla
     *
     */
    public List<DetallePedidoEntity> findAll() {
        Query todos = em.createQuery("select u from DetallePedidoEntity u");
        return todos.getResultList();
    }
    
    
    /**
     * Creación de un nuevo registro
     *
     * @param detallePedido
     * @return detallePedido
     *
     */
    public DetallePedidoEntity create(DetallePedidoEntity detallePedido) {
        em.persist(detallePedido);
        return detallePedido;
    }
    
    /*Actualización de la entidad
        @param 
        @return merge entity*/
    public DetallePedidoEntity update(DetallePedidoEntity entity) {

        return em.merge(entity);
    }
    
    /**
     * Eliminar un objeto de la entidad
     *
     * @param id
     * @return detallePedidoUpdate*
     */
    public void delete(Long id) {
        DetallePedidoEntity detallePedidoDelete = em.find(DetallePedidoEntity.class, id);
        em.remove(detallePedidoDelete);
    }
    
    
    
}
