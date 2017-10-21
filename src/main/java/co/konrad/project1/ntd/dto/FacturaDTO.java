/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.project1.ntd.dto;

import co.konrad.project1.ntd.entities.FacturaEntity;
import co.konrad.project1.ntd.entities.MetodoPagoEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dairo
 */
public class FacturaDTO {
    
    private Long id;
    
    private Date fecha;
    
    private Long valorTotal;
    
    private MetodoPagoEntity metodoPago;

    public FacturaDTO(FacturaEntity factura) {
        this.id = factura.getId();
        this.fecha = factura.getFecha();
        this.valorTotal = factura.getValorTotal();
        this.metodoPago = factura.getMetodoPago();
    }

    public FacturaEntity toEntity(){
        FacturaEntity factura = new FacturaEntity();
        factura.setId(this.id);
        factura.setFecha(this.fecha);
        factura.setValorTotal(this.valorTotal);
        factura.setMetodoPago(this.metodoPago);
        
        return factura;
    }
    
    public static List<FacturaDTO> toFacturaList(List<FacturaEntity> facturaList) {
        List<FacturaDTO> listaFactura = new ArrayList<>();
        for (int i = 0; i < facturaList.size(); i++) {
            listaFactura.add(new FacturaDTO(facturaList.get(i)));
        }
        return listaFactura;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Long getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Long valorTotal) {
        this.valorTotal = valorTotal;
    }

    public MetodoPagoEntity getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPagoEntity metodoPago) {
        this.metodoPago = metodoPago;
    }
    
    
    
    
    
}
