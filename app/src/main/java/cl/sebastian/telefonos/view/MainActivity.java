package cl.sebastian.telefonos.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import cl.sebastian.telefonos.R;
import cl.sebastian.telefonos.viewmodel.TelefonosViewModel;

/*
****Requerimientos****
* 1. MVVM
* 2. Consumo de API (http://my-json-server.typicode.com/Himuravidal/FakeAPIdata/products
).
* 3. LiveData.
* 4. ViewBinding.
* 5. RecyclerView.
* 6. Glide (Imagenes).
* 7. Test Unitario.
*
Lista de tareas
[x] Crear y subir a GitHub.

[x] Adpater.
[x] Retrofit (Retrofit Client, Api Interface (@GET)). Añadir permisos internet Manifest
[] Activar ViewBinding e implementar().
[] POJO
*   [x] lista
*   [] detalle
[] Layout (el o los).
*   [x] layout lista
*   [x] layout elemento
*   [] layout detalle
[x] Implemetar Adapter y RecyclerView.
[] Test unitarios a modelo y ViewModel
[x] Crear clase ViewModel
*   [] Implementar ViewModel

 */

public class MainActivity extends AppCompatActivity {

    TelefonosViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(TelefonosViewModel.class);
        viewModel.loadInfo();
        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout, ListFragment.newInstance("", "")).commit();
    }
}