package recupracion.proyect.estadios;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import recupracion.proyect.estadios.ayudadores.ImagenLoader;
import recupracion.proyect.estadios.controladores.EstadiosController;
import recupracion.proyect.estadios.modelos.Estadio;
import recupracion.proyect.estadios.modelos.Schedule;


public class DetallesActivity extends ActionBarActivity {

    private ImageView ivImagen;
    private TextView tvName, tvPhone,tvAddress, tvDescription, tvZip, tvCity, tvSchedule;
    private Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);
        Estadio estadio = EstadiosController.getEstadio(getIntent().getIntExtra("estadio", 0));
        ivImagen = (ImageView)findViewById(R.id.ivImagen);
        tvName = (TextView)findViewById(R.id.tvName);
        tvPhone = (TextView)findViewById(R.id.tvPhone);
        tvAddress = (TextView)findViewById(R.id.tvAddress);
        tvDescription = (TextView)findViewById(R.id.tvDescription);
        tvZip = (TextView)findViewById(R.id.tvZip);
        tvCity = (TextView)findViewById(R.id.tvCity);
        tvSchedule= (TextView)findViewById(R.id.tvSchedule);

        ImagenLoader imagenLoader = new ImagenLoader(getApplicationContext());
        ImagenLoader.loadUrl(ivImagen, estadio.getImage_url());

        tvName.setText(estadio.getName());
        tvPhone.setText(estadio.getPhone());
        tvAddress.setText(estadio.getAddress());
        tvDescription.setText(estadio.getDescription());
        tvZip.setText(estadio.getZip());
        tvCity.setText(estadio.getCity());
        tvSchedule.setText("");
        for(Schedule schedule : estadio.getSchedule()){
            String strSchedule = schedule.getStart_date() + " - " + schedule.getEnd_date() + "\n";
            tvSchedule.setText(tvSchedule.getText() + strSchedule);
        }

        mToolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detalles, menu);
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
