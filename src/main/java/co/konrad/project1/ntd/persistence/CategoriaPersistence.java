/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.project1.ntd.persistence;

import co.konrad.project1.ntd.entities.CategoriaEntity;
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

public class CategoriaPersistence {
    
    
    @PersistenceContext(unitName = "Project1-NTDPU")
    protected EntityManager em;
    
    /**
     * Método para encontrar un objeto de la clase categoria a través de un id
     *
     * @param id
     * @return categoria *
     */
    public CategoriaEntity find(Long id) {
        CategoriaEntity categoria = em.find(CategoriaEntity.class, id);
        return categoria;
    }
    
    
    /**
     * Obtener todos los objetos encontrados en la tabla categoria
     *
     * @return listado de datos de la tabla
     *
     */
    public List<CategoriaEntity> findAll() {
        Query todos = em.createQuery("select u from CategoriaEntity u");
        return todos.getResultList();
    }
    
    
    /**
     * Creación de un nuevo registro
     *
     * @param categoria
     * @return categoria
     *
     */
    public CategoriaEntity create(CategoriaEntity categoria) {
        em.persist(categoria);
        return categoria;
    }
    
    /*Actualización de la entidad
        @param 
        @return merge entity*/
    public CategoriaEntity update(CategoriaEntity entity) {

        return em.merge(entity);
    }
    
    /**
     * Eliminar un objeto de la entidad
     *
     * @param id
     * @return categoriaUpdate*
     */
    public void delete(Long id) {
        CategoriaEntity categoriaDelete = em.find(CategoriaEntity.class, id);
        em.remove(categoriaDelete);
    }
    
    
}
