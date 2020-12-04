package cl.sebastian.telefonos.viewmodel;

import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import cl.sebastian.telefonos.api.RetrofitClient;
import cl.sebastian.telefonos.model.DetalleProducto;
import cl.sebastian.telefonos.model.Producto;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TelefonosViewModel extends ViewModel {
    private static final String TAG ="ViewModel" ;



    //Se comunica con el modelo (en este caso RetrofitClient) para obtener los datos
    private MutableLiveData<List<Producto>> listaLProducto = new MutableLiveData<>();

    private MutableLiveData<DetalleProducto> detalleProducto = new MutableLiveData<>();

    public LiveData<List<Producto>> getListaLProducto() {
        return listaLProducto;
    }

    public LiveData<DetalleProducto> getDetalleProducto() {
        return detalleProducto;
    }

    //Se comunica con el modelo (en este caso RetrofitClient) para obtener los datos
    // Se comunica con la vista para que haga algo con esos datos

    public void loadInfo(){
        Log.d(TAG, "loadInfo: Ocupando loadinfo");
        RetrofitClient.getRetrofitInstance().getAllProducts().enqueue(new Callback<List<Producto>>() {
            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {
                Log.d(TAG, "onResponse: Obteniendo List<product>"+response.body());
                listaLProducto.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Producto>> call, Throwable t) {
                Log.d(TAG, "onResponse: Fallo de conexión" + t.toString());
            }
        });
    }

    public void loadDetail(int id){
        RetrofitClient.getRetrofitInstance().getDetail(id).enqueue(new Callback<DetalleProducto>() {
            @Override
            public void onResponse(Call<DetalleProducto> call, Response<DetalleProducto> response) {
                if(response.isSuccessful()) {
                    detalleProducto.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<DetalleProducto> call, Throwable t) {
                Log.d(TAG, "onResponse detail: Fallo de conexión" + t.toString());
            }
        });
    }

}
