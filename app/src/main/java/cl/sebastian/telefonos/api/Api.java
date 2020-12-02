package cl.sebastian.telefonos.api;

import java.util.List;

import cl.sebastian.telefonos.model.Producto;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("products")
    Call <List<Producto>> getAllProducts();
}
