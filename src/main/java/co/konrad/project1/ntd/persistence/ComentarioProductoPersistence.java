/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.project1.ntd.persistence;

import co.konrad.project1.ntd.entities.ComentarioProductoEntity;
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
public class ComentarioProductoPersistence {
    
    @PersistenceContext(unitName = "Project1-NTDPU")
    protected EntityManager em;
    
    /**
     * Método para encontrar un objeto de la clase comentarioProducto a través de un id
     *
     * @param id
     * @return comentarioProducto *
     */
    public ComentarioProductoEntity find(Long id) {
        ComentarioProductoEntity comentarioProducto = em.find(ComentarioProductoEntity.class, id);
        return comentarioProducto;
    }
    
    
    /**
     * Obtener todos los objetos encontrados en la tabla comentarioProducto
     *
     * @return listado de datos de la tabla
     *
     */
    public List<ComentarioProductoEntity> findAll() {
        Query todos = em.createQuery("select u from ComentarioProductoEntity u");
        return todos.getResultList();
    }
    
    
    /**
     * Creación de un nuevo registro
     *
     * @param comentarioProducto
     * @return comentarioProducto
     *
     */
    public ComentarioProductoEntity create(ComentarioProductoEntity comentarioProducto) {
        em.persist(comentarioProducto);
        return comentarioProducto;
    }
    
    /*Actualización de la entidad
        @param 
        @return merge entity*/
    public ComentarioProductoEntity update(ComentarioProductoEntity entity) {

        return em.merge(entity);
    }
    
    /**
     * Eliminar un objeto de la entidad
     *
     * @param id
     * @return comentarioProductoUpdate*
     */
    public void delete(Long id) {
        ComentarioProductoEntity comentarioProductoDelete = em.find(ComentarioProductoEntity.class, id);
        em.remove(comentarioProductoDelete);
    }
    
    
}
