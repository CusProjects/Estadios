package recupracion.proyect.estadios;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import recupracion.proyect.estadios.adaptadores.RVAdapter;
import recupracion.proyect.estadios.ayudadores.RecyclerItemClickListener;
import recupracion.proyect.estadios.controladores.EstadiosController;
import recupracion.proyect.estadios.modelos.Estadio;
import recupracion.proyect.estadios.servicios.EstadiosService;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends ActionBarActivity {

    private RecyclerView rvEstadios;
    private RestAdapter restAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvEstadios = (RecyclerView) findViewById(R.id.rvEstadios);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rvEstadios.setLayoutManager(layoutManager);

        restAdapter = new RestAdapter.Builder().setEndpoint("https://s3.amazonaws.com/jon-hancock-phunware").build();
        EstadiosService servicio = restAdapter.create(EstadiosService.class);

        servicio.getEstadios(new Callback<ArrayList<Estadio>>() {
            @Override
            public void success(ArrayList<Estadio> estadios, Response response) {
                EstadiosController.setEstadios(estadios);
                RVAdapter adapter = new RVAdapter(estadios);
                rvEstadios.setAdapter(adapter);
            }
            @Override
            public void failure(RetrofitError retrofitError) {
                Toast.makeText(getApplicationContext(), retrofitError.getMessage(), Toast.LENGTH_LONG).show();
            }
        });


        //rvEstadios.setAdapter(new CustomAdapter());


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
