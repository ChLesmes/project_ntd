/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.project1.ntd.resources;

import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author Dairo
 */
@ApplicationPath("/api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(co.konrad.project1.ntd.resources.CarritoEntityFacadeREST.class);
        resources.add(co.konrad.project1.ntd.resources.CategoriaEntityFacadeREST.class);
        resources.add(co.konrad.project1.ntd.resources.ClienteEntityFacadeREST.class);
        resources.add(co.konrad.project1.ntd.resources.ComentarioProductoEntityFacadeREST.class);
        resources.add(co.konrad.project1.ntd.resources.DetallePedidoEntityFacadeREST.class);
        resources.add(co.konrad.project1.ntd.resources.EnvioEntityFacadeREST.class);
        resources.add(co.konrad.project1.ntd.resources.FacturaEntityFacadeREST.class);
        resources.add(co.konrad.project1.ntd.resources.MetodoPagoEntityFacadeREST.class);
        resources.add(co.konrad.project1.ntd.resources.ProductoEntityFacadeREST.class);
        resources.add(co.konrad.project1.ntd.resources.PromocionEntityFacadeREST.class);
        resources.add(co.konrad.project1.ntd.resources.ProveedorEntityFacadeREST.class);
    }
    
}
