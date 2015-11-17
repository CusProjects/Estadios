package recupracion.proyect.estadios.adaptadores;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import recupracion.proyect.estadios.DetallesActivity;
import recupracion.proyect.estadios.R;
import recupracion.proyect.estadios.modelos.Estadio;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.EstadiosViewHolder> {

    private ArrayList<Estadio> estadios;

    public static class EstadiosViewHolder extends RecyclerView.ViewHolder {
        private CardView cv;
        private Button btnCompartir;
        private TextView tvName;
        private TextView tvCity;
        private TextView tvPhone;
        private View context;

        EstadiosViewHolder(View itemView){
            super(itemView);
            cv =  (CardView)itemView.findViewById(R.id.cv);
            btnCompartir = (Button)itemView.findViewById(R.id.btnCompartir);
            tvName = (TextView)itemView.findViewById(R.id.tvName);
            tvCity = (TextView)itemView.findViewById(R.id.tvCity);
            tvPhone = (TextView)itemView.findViewById(R.id.tvPhone);
            context = itemView;

        }
    }

    public RVAdapter(ArrayList<Estadio> estadios){
        this.estadios = estadios;
    }

    @Override
    public int getItemCount() {
        return estadios.size();
    }

    @Override
    public EstadiosViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        EstadiosViewHolder pvh = new EstadiosViewHolder(v);
        return pvh;
    }
    @Override
    public void onBindViewHolder(final EstadiosViewHolder estadiosViewHolder, final int i) {
        estadiosViewHolder.tvName.setText(estadios.get(i).getName());
        estadiosViewHolder.tvCity.setText(estadios.get(i).getCity());
        estadiosViewHolder.tvPhone.setText(estadios.get(i).getPhone());

        estadiosViewHolder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(estadiosViewHolder.context.getContext(), DetallesActivity.class);
                intent.putExtra("estadio", estadios.get(i).getId());
                estadiosViewHolder.context.getContext().startActivity(intent);
            }
        });

        estadiosViewHolder.btnCompartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Nombre: " + estadios.get(i).getName() + "\n <br/>" + "direccion: " + estadios.get(i).getAddress());
                sendIntent.setType("text/plain");
                estadiosViewHolder.context.getContext().startActivity(sendIntent);
            }
        });
    }

}