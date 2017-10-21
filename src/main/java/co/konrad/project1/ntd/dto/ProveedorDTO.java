/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.project1.ntd.dto;

import co.konrad.project1.ntd.entities.ProveedorEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dairo
 */
public class ProveedorDTO {
    
    private Long id;
    
    private String nombre;
    
    private String direccion;
    
    private String telefono;
    
    private String email;

    public ProveedorDTO(ProveedorEntity proveedor) {
        this.id = proveedor.getId();
        this.nombre = proveedor.getNombre();
        this.direccion = proveedor.getDireccion();
        this.telefono = proveedor.getTelefono();
        this.email = proveedor.getEmail();
    }
    
    public ProveedorEntity toEntity(){
        ProveedorEntity proveedor = new ProveedorEntity();
        proveedor.setId(this.id);
        proveedor.setNombre(this.nombre);
        proveedor.setDireccion(this.direccion);
        proveedor.setTelefono(this.telefono);
        proveedor.setEmail(this.email);
        
        return proveedor;
    }
    
    
    public static List<ProveedorDTO> toProveedorList(List<ProveedorEntity> proveedorList) {
        List<ProveedorDTO> listaProveedor = new ArrayList<>();
        for (int i = 0; i < proveedorList.size(); i++) {
            listaProveedor.add(new ProveedorDTO(proveedorList.get(i)));
        }
        return listaProveedor;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
    
    
    
}
