/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.project1.ntd.dto;

import co.konrad.project1.ntd.entities.CarritoEntity;
import co.konrad.project1.ntd.entities.FacturaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * DTO para el mapeo objeto relacional de la entidad Carrito
 *
 * @author Dairo, Fabian, Cristian
 * 
 */
public class CarritoDTO {
    
    private Long id;
    
    private FacturaEntity factura;

    /**
     * Constructor
     *
     * @param carrito
     */
    public CarritoDTO(CarritoEntity carrito) {
        this.id = carrito.getId();
        this.factura = carrito.getFactura();
    }
    
    public CarritoEntity toEntity(){
        CarritoEntity carrito = new CarritoEntity();
        carrito.setId(this.id);
        carrito.setFactura(this.factura);        
        return carrito;
    }

    public static List<CarritoDTO> toCarritoList(List<CarritoEntity> carritoList) {
        List<CarritoDTO> listaCarritos = new ArrayList<>();
        for (int i = 0; i < carritoList.size(); i++) {
            listaCarritos.add(new CarritoDTO(carritoList.get(i)));
        }
        return listaCarritos;
    }
    
    
    /**
     * Metodos get y est de la entidad Carrito
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FacturaEntity getFactura() {
        return factura;
    }

    public void setFactura(FacturaEntity factura) {
        this.factura = factura;
    }
    
    
    
    
}
