/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.project1.ntd.persistence;


import co.konrad.project1.ntd.entities.ProveedorEntity;
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
public class ProveedorPersistence {
    
    @PersistenceContext(unitName = "Project1-NTDPU")
    protected EntityManager em;
    
    /**
     * Método para encontrar un objeto de la clase proveedor a través de un id
     *
     * @param id
     * @return proveedor *
     */
    public ProveedorEntity find(Long id) {
        ProveedorEntity proveedor = em.find(ProveedorEntity.class, id);
        return proveedor;
    }
    
    
    /**
     * Obtener todos los objetos encontrados en la tabla proveedor
     *
     * @return listado de datos de la tabla
     *
     */
    public List<ProveedorEntity> findAll() {
        Query todos = em.createQuery("select u from ProveedorEntity u");
        return todos.getResultList();
    }
    
    
    /**
     * Creación de un nuevo registro
     *
     * @param proveedor
     * @return proveedor
     *
     */
    public ProveedorEntity create(ProveedorEntity proveedor) {
        em.persist(proveedor);
        return proveedor;
    }
    
    /*Actualización de la entidad
        @param 
        @return merge entity*/
    public ProveedorEntity update(ProveedorEntity entity) {

        return em.merge(entity);
    }
    
    /**
     * Eliminar un objeto de la entidad
     *
     * @param id
     * @return proveedorUpdate*
     */
    public void delete(Long id) {
        ProveedorEntity proveedorDelete = em.find(ProveedorEntity.class, id);
        em.remove(proveedorDelete);
    }
    
    
    
}
