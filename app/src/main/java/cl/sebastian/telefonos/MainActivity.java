package cl.sebastian.telefonos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/*
****Requerimientos****
* 1. MVVM
* 2. Consumo de API (https://github.com/Himuravidal/FakeAPIdata/blob/main/db.json).
* 3. LiveData.
* 4. ViewBinding.
* 5. RecyclerView.
* 6. Glide (Imagenes).
* 7. Test Unitario.
*
Lista de tareas
[] Crear y subir a GitHub.
[] Adpater.
[] Retrofit.
[] Activar ViewBinding e implementar().
[] POJO.
[] Layout (el o los).
[] Implemetar Adapter y RecyclerView.
[] Test unitarios a modelo y ViewModel
[] Crear clase ViewModel

 */

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}