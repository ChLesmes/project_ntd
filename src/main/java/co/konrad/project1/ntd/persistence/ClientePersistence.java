/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.project1.ntd.persistence;

import co.konrad.project1.ntd.entities.ClienteEntity;
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
public class ClientePersistence {
    
    
    @PersistenceContext(unitName = "Project1-NTDPU")
    protected EntityManager em;
    
    /**
     * Método para encontrar un objeto de la clase cliente a través de un id
     *
     * @param id
     * @return cliente *
     */
    public ClienteEntity find(Long id) {
        ClienteEntity cliente = em.find(ClienteEntity.class, id);
        return cliente;
    }
    
    
    /**
     * Obtener todos los objetos encontrados en la tabla cliente
     *
     * @return listado de datos de la tabla
     *
     */
    public List<ClienteEntity> findAll() {
        Query todos = em.createQuery("select u from ClienteEntity u");
        return todos.getResultList();
    }
    
    
    /**
     * Creación de un nuevo registro
     *
     * @param cliente
     * @return cliente
     *
     */
    public ClienteEntity create(ClienteEntity cliente) {
        em.persist(cliente);
        return cliente;
    }
    
    /*Actualización de la entidad
        @param 
        @return merge entity*/
    public ClienteEntity update(ClienteEntity entity) {

        return em.merge(entity);
    }
    
    /**
     * Eliminar un objeto de la entidad
     *
     * @param id
     * @return clienteUpdate*
     */
    public void delete(Long id) {
        ClienteEntity clienteDelete = em.find(ClienteEntity.class, id);
        em.remove(clienteDelete);
    }
    
}
