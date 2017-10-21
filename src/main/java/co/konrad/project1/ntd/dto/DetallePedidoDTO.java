/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.project1.ntd.dto;

import co.konrad.project1.ntd.entities.DetallePedidoEntity;
import co.konrad.project1.ntd.entities.FacturaEntity;
import co.konrad.project1.ntd.entities.ProductoEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dairo
 */
public class DetallePedidoDTO {
    
    private Long id;
    private Date fechaPedido;
    private ProductoEntity producto;
    private FacturaEntity factura;

    /**
     * Constructor
     *
     * @param detalle
     */
    public DetallePedidoDTO(DetallePedidoEntity detalle) {
        this.id = detalle.getId();
        this.fechaPedido = detalle.getFechaPedido();
        this.producto = detalle.getProducto();
        this.factura = detalle.getFactura();
    }
    
    public DetallePedidoEntity toEntity(){
        DetallePedidoEntity detalle = new DetallePedidoEntity();
        detalle.setId(this.id);
        detalle.setFechaPedido(this.fechaPedido);
        detalle.setProducto(this.producto);
        detalle.setFactura(this.factura);        
        return detalle;
    }
    
    
    public static List<DetallePedidoDTO> toDetalleList(List<DetallePedidoEntity> detalleList) {
        List<DetallePedidoDTO> listaDetalle = new ArrayList<>();
        for (int i = 0; i < detalleList.size(); i++) {
            listaDetalle.add(new DetallePedidoDTO(detalleList.get(i)));
        }
        return listaDetalle;
    }
    
    
    /**
     * Metodos get y est de la entidad DetallePedido
     *
     * @return
     */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public ProductoEntity getProducto() {
        return producto;
    }

    public void setProducto(ProductoEntity producto) {
        this.producto = producto;
    }

    public FacturaEntity getFactura() {
        return factura;
    }

    public void setFactura(FacturaEntity factura) {
        this.factura = factura;
    }
    
    
    
    
    
    
    
    
}
