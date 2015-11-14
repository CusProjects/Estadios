package recupracion.proyect.estadios.servicios;

import java.util.ArrayList;

import recupracion.proyect.estadios.modelos.Estadio;
import retrofit.Callback;
import retrofit.http.GET;


public interface EstadiosService {

    @GET("/nflapi-static.json")
    public void getEstadios(Callback<ArrayList<Estadio>> callback);
}
