package com.example.practicafinalandroid_josevinas_paulacabello.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practicafinalandroid_josevinas_paulacabello.R;
import com.example.practicafinalandroid_josevinas_paulacabello.entidades.Cancion;

import java.util.List;

//Se implementa el OnClickListener con los métodos correspondientes
public class MusicaAdapter extends RecyclerView.Adapter<MusicaAdapter.MusicaViewHolder> implements View.OnClickListener {

    private List<Cancion> canciones;
//    private LayoutInflater inflater;
    private Context context;
    //Se declara un listener para poder ejecutar posteriormente el OnClick
    private View.OnClickListener listener;

    public MusicaAdapter(List<Cancion> canciones, Context context) {
        this.canciones = canciones;
        this.context = context;
    }

    //Se infla la vista que se va a utilizar
    @NonNull
    @Override
    public MusicaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.musica_cardview, parent, false);
        view.setOnClickListener(this);
        return new MusicaViewHolder(view);
    }

    //Se realiza la inserción de los contenidos de cada elemento
    @Override
    public void onBindViewHolder(@NonNull MusicaViewHolder holder, int position) {

//        holder.pasarDatos(canciones.get(position));
        introduceDatos(holder, position);
        //Se añade animación a los cardview
        holder.cardView.setAnimation(AnimationUtils.loadAnimation(context, R.anim.slade));
    }

    @Override
    public int getItemCount() {
        return canciones.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if (listener != null) {
            listener.onClick(view);
        }
    }

    public class MusicaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imagen;

        private TextView nombreCancion;
        private TextView nombreCantante;
        private CardView cardView;

        public MusicaViewHolder(@NonNull View itemView) {
            super(itemView);
            imagen = (ImageView) itemView.findViewById(R.id.img_cancion);
            nombreCancion = (TextView) itemView.findViewById(R.id.tv_nombreCancion);
            nombreCantante = (TextView) itemView.findViewById(R.id.tv_nombreCantante);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }

    private void introduceDatos(@NonNull MusicaViewHolder holder, int position) {
        holder.imagen.setImageResource(canciones.get(position).getImagen());
        holder.nombreCancion.setText(canciones.get(position).getNombre());
        holder.nombreCantante.setText(canciones.get(position).getAutor());
    }
}