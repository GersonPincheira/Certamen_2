package ejemplo.certamen2.presenters;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import ejemplo.certamen2.Models.HttpServerConnection;
import ejemplo.certamen2.Models.DatosGit;
import ejemplo.certamen2.Models.UIAdapter;
import ejemplo.certamen2.activities.MainActivity;
import ejemplo.certamen2.presenters.contract.RepositorioPresenter;

/**
 * Created by gerson on 17-10-16.
 */

public class RepositorioPresenterImpl implements RepositorioPresenter {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private String usuario;
    private Activity activity;

    public RepositorioPresenterImpl(String usuario, RecyclerView recyclerview, Activity activity) {
        this.usuario=usuario;
        this.recyclerView = recyclerview;
        this.activity=activity;
    }

    @Override
    public List<DatosGit> getLista(String Result) {
        List<DatosGit> listadatos = new ArrayList<DatosGit>();
        try {
            JSONArray lista = new JSONArray(Result);

            int size = lista.length();
            for (int i = 0; i < size; i++) {
                DatosGit dt = new DatosGit();
                JSONObject objeto = lista.getJSONObject(i);

                dt.setTitulo(objeto.getString("name"));
                dt.setDescripcion(objeto.getString("description"));
                dt.setActualizacion(objeto.getString("updated_at"));
                dt.setUrl(objeto.getString("html_url"));

                listadatos.add(dt);
            }
            return listadatos;
        } catch (JSONException e) {
            e.printStackTrace();
            return listadatos;
        }
    }

    @Override
    public AsyncTask<Void, Void, String> Extraerdatos() {
        AsyncTask<Void,Void,String> task = new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... voids) {
                String repositorios = new HttpServerConnection().connectToServer("https://api.github.com/users/" + usuario + "/repos", 15000);
                return repositorios;
            }

            @Override
            protected void onPostExecute(String s) {

                ConnectarAdapter(s);
            }
        };
        return task;
    }

    @Override
    public void ConnectarAdapter(String result) {
        if (result != null)
        {
            this.adapter = new UIAdapter(getLista(result),activity);
            recyclerView.setAdapter(adapter);

        }else{
            Toast toast = Toast.makeText(activity,"Usuario No Encontrado",Toast.LENGTH_SHORT);
            toast.show();
            Intent i = new Intent(activity, MainActivity.class );
            activity.startActivity(i);
        }


    }


}

