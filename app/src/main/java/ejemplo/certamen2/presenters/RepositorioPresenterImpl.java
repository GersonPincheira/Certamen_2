package ejemplo.certamen2.presenters;

import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import connection.HttpServerConnection;
import ejemplo.certamen2.DatosGit;
import ejemplo.certamen2.UIAdapter;
import ejemplo.certamen2.presenters.contract.RepositorioPresenter;

/**
 * Created by gerson on 17-10-16.
 */

public class RepositorioPresenterImpl implements RepositorioPresenter {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private String usuario;

    public RepositorioPresenterImpl(String usuario, RecyclerView recyclerview, RecyclerView.Adapter adapter) {
        this.usuario=usuario;
        this.recyclerView = recyclerview;
        this.adapter = adapter;
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
    public String Extraerdatos() {
        String repositorios = new HttpServerConnection().connectToServer("https://api.github.com/users/" + usuario + "/repos", 15000);
        return repositorios;
    }

    @Override
    public void ConnectarAdapter(String result) {
        if (result != null) {
            System.out.println();
            adapter = new UIAdapter(getLista(result));
            recyclerView.setAdapter(adapter);
            }

        }
    }

