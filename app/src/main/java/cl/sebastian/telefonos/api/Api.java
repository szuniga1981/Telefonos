package cl.sebastian.telefonos.api;

import java.util.List;


import cl.sebastian.telefonos.model.DetalleProducto;
import cl.sebastian.telefonos.model.Producto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {
    @GET("products")
    Call <List<Producto>> getAllProducts();
    @GET("details/{id}")
    Call <DetalleProducto> getDetail(@Path("id") int id);
}
