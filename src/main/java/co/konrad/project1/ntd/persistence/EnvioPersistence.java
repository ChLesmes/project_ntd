/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.project1.ntd.persistence;


import co.konrad.project1.ntd.entities.EnvioEntity;
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
public class EnvioPersistence {
    
    @PersistenceContext(unitName = "Project1-NTDPU")
    protected EntityManager em;
    
    /**
     * Método para encontrar un objeto de la clase envio a través de un id
     *
     * @param id
     * @return envio *
     */
    public EnvioEntity find(Long id) {
        EnvioEntity envio = em.find(EnvioEntity.class, id);
        return envio;
    }
    
    
    /**
     * Obtener todos los objetos encontrados en la tabla envio
     *
     * @return listado de datos de la tabla
     *
     */
    public List<EnvioEntity> findAll() {
        Query todos = em.createQuery("select u from EnvioEntity u");
        return todos.getResultList();
    }
    
    
    /**
     * Creación de un nuevo registro
     *
     * @param envio
     * @return envio
     *
     */
    public EnvioEntity create(EnvioEntity envio) {
        em.persist(envio);
        return envio;
    }
    
    /*Actualización de la entidad
        @param 
        @return merge entity*/
    public EnvioEntity update(EnvioEntity entity) {

        return em.merge(entity);
    }
    
    /**
     * Eliminar un objeto de la entidad
     *
     * @param id
     * @return envioUpdate*
     */
    public void delete(Long id) {
        EnvioEntity envioDelete = em.find(EnvioEntity.class, id);
        em.remove(envioDelete);
    }
    
    
    
}
