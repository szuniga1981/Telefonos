package cl.sebastian.telefonos.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {


    private static final  String BASE_URL="http://my-json-server.typicode.com/Himuravidal/FakeAPIdata/";
    private static Retrofit retrofit=null;


    private RetrofitClient (){

    }

    public static Api getRetrofitInstance(){
        if (retrofit == null){
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(Api.class);
    }




}
