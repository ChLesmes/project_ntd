/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.project1.ntd.dto;

import co.konrad.project1.ntd.entities.ProductoEntity;
import co.konrad.project1.ntd.entities.PromocionEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dairo
 */
public class PromocionDTO {
    
    private Long id;
    
    private String nombre;
    
    private String descripcion;
    
    private ProductoEntity producto;

    public PromocionDTO(PromocionEntity promocion) {
        this.id = promocion.getId();
        this.nombre = promocion.getNombre();
        this.descripcion = promocion.getDescripcion();
        this.producto = promocion.getProducto();
    }
    
    public PromocionEntity toEntity(){
        PromocionEntity promocion = new PromocionEntity();
        promocion.setId(this.id);    
        promocion.setNombre(this.nombre);
        promocion.setDescripcion(this.descripcion);
        promocion.setProducto(this.producto);
        
        return promocion;
    }
    
    
    public static List<PromocionDTO> toPromocionList(List<PromocionEntity> promocionList) {
        List<PromocionDTO> listaPromocion = new ArrayList<>();
        for (int i = 0; i < promocionList.size(); i++) {
            listaPromocion.add(new PromocionDTO(promocionList.get(i)));
        }
        return listaPromocion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ProductoEntity getProducto() {
        return producto;
    }

    public void setProducto(ProductoEntity producto) {
        this.producto = producto;
    }
    
    
    
    
}
