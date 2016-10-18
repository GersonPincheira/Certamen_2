package ejemplo.certamen2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


/**
 * Created by gerson on 30-09-16.
 */

public class UIAdapter extends RecyclerView.Adapter<UIAdapter.ViewHolder> {
    private List<DatosGit> lista;
    Context mContext;

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView TextTitulo;
        public TextView TextDescrip;
        public TextView TextActual;
        public CardView cardView;

        public ViewHolder(View v) {
            super(v);
            TextTitulo = (TextView) v.findViewById(R.id.textTitulo);
            TextDescrip = (TextView) v.findViewById(R.id.textDescricion);
            TextActual = (TextView) v.findViewById(R.id.textActualizado);
            cardView = (CardView)   v.findViewById(R.id.cv);


        }

    }
    public UIAdapter(List<DatosGit> datos) {
        lista = datos;
    }

    @Override
    public UIAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.vista_items, parent, false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(UIAdapter.ViewHolder holder, int position) {
        final DatosGit dato = lista.get(position);
        holder.TextTitulo.setText(dato.getTitulo());
        if(dato.getDescripcion().equals("null")){
            holder.TextDescrip.setText("No hay informacion");
        }else{
            holder.TextDescrip.setText(dato.getDescripcion());
        }
        holder.TextActual.setText(dato.getActualizacion());
    }


    @Override
    public int getItemCount() {
        return lista.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}

