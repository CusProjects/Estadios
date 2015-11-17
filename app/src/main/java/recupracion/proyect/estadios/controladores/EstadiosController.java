package recupracion.proyect.estadios.controladores;

import java.util.ArrayList;

import recupracion.proyect.estadios.modelos.Estadio;

public class EstadiosController {

    private static ArrayList<Estadio> estadios = new ArrayList<Estadio>();

    public static void setEstadios(ArrayList<Estadio> response){
        estadios = response;
    }
    public static ArrayList<Estadio> getEstadios(){
        return estadios;
    }

    public static Estadio getEstadio(int id){
        for(Estadio estadio: estadios){
            if(estadio.getId() == id){
                return estadio;
            }
        }
        return null;
    }
}