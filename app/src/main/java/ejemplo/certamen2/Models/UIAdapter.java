package ejemplo.certamen2.Models;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ejemplo.certamen2.R;


/**
 * Created by gerson on 30-09-16.
 */

public class UIAdapter extends RecyclerView.Adapter<UIAdapter.ViewHolder> {
    private List<DatosGit> lista;
    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView TextTitulo;
        public TextView TextDescrip;
        public TextView TextActual;
        public CardView cardView;
        List<DatosGit> list;
        Context mContext;

        public ViewHolder(View v,List<DatosGit> list,Context mContext) {
            super(v);
            this.list=list;
            this.mContext = mContext;
            v.setOnClickListener(this);
            TextTitulo = (TextView) v.findViewById(R.id.textTitulo);
            TextDescrip = (TextView) v.findViewById(R.id.textDescricion);
            TextActual = (TextView) v.findViewById(R.id.textActualizado);
            cardView = (CardView) v.findViewById(R.id.cv);

        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            DatosGit dato = list.get(position);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(dato.getUrl()));
            this.mContext.startActivity(intent);
        }
    }
    public UIAdapter(List<DatosGit> datos,Context context) {
        lista = datos;
        this.context = context;
    }

    @Override
    public UIAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.vista_items, parent, false);
        return new ViewHolder(v,lista,context);
    }

    @Override
    public void onBindViewHolder(UIAdapter.ViewHolder holder, int position) {

            final DatosGit dato = lista.get(position);
            holder.TextTitulo.setText(dato.getTitulo());
            if (dato.getDescripcion().equals("null")) {
                    holder.TextDescrip.setText("No hay informacion");
            } else {
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

