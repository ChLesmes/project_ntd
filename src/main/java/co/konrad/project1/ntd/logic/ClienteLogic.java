/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.project1.ntd.logic;


import co.konrad.project1.ntd.entities.ClienteEntity;
import co.konrad.project1.ntd.persistence.ClientePersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * 
 * @author Dairo, Fabian, Cristian
 * 
 */
@Stateless
public class ClienteLogic {
    
        /*
    Inyección del persistence de la entidad
     */
    @Inject
    private ClientePersistence clientePersistence;
    
    
    /**
     * Obtener todos lo clientes
     *
     * @return cliente
     */
    public List<ClienteEntity> getClientes() {
        List<ClienteEntity> clientes = clientePersistence.findAll();
        return clientes;
    }
    
    
    /**
     * Ontener un cliente a partir de su id
     *
     * @param id
     * @return cliente
     */
    public ClienteEntity getCliente(Long id) {
        ClienteEntity cliente = clientePersistence.find(id);
        if (cliente == null) {
            throw new IllegalArgumentException("El cliente solicitado no existe");
        }
        return cliente;
    }
    
    
    
    /**
     * Crear un nuevo cliente
     *
     * @param entity
     * @return entity
     */
    public ClienteEntity createCliente(ClienteEntity entity) {

        clientePersistence.create(entity);
        return entity;
    }
    
    
    /**
     * Metodo para actualizar un objeto de la entidad cliente
     *
     * @param id
     * @param entity
     * @return cliente
     */
    public ClienteEntity updateCliente(Long id, ClienteEntity entity) {
        ClienteEntity cliente = clientePersistence.update(entity);
        return cliente;
    }
    
    
    /**
     * Metodo para eliminar un objeto de la entidad cliente
     *
     * @param id
     */
    public void deleteCliente(Long id) {
        clientePersistence.delete(id);
    }
}
