package recupracion.proyect.estadios.adaptadores;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import recupracion.proyect.estadios.R;
import recupracion.proyect.estadios.modelos.Estadio;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.EstadiosViewHolder> {

    private ArrayList<Estadio> estadios;

    public static class EstadiosViewHolder extends RecyclerView.ViewHolder {
        private CardView cv;
        private TextView tvName;
        private TextView tvCity;
        private TextView tvPhone;
        private ImageView ivImagen;

        EstadiosViewHolder(View itemView){
            super(itemView);
            cv =  (CardView)itemView.findViewById(R.id.cv);
            tvName = (TextView)itemView.findViewById(R.id.tvName);
            tvCity = (TextView)itemView.findViewById(R.id.tvCity);
            tvPhone = (TextView)itemView.findViewById(R.id.tvPhone);
            ivImagen = (ImageView)itemView.findViewById(R.id.ivImagen);
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
    public void onBindViewHolder(EstadiosViewHolder estadiosViewHolder, int i) {
        estadiosViewHolder.tvName.setText(estadios.get(i).getName());
        estadiosViewHolder.tvCity.setText(estadios.get(i).getCity());
        estadiosViewHolder.tvPhone.setText(estadios.get(i).getPhone());
        //estadiosViewHolder.personPhoto.setImageResource(persons.get(i).photoId);
    }

}