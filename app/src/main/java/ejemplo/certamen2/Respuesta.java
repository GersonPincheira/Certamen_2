package ejemplo.certamen2;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import connection.HttpServerConnection;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

public class Respuesta extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TextView encabezado;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private String usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respuesta);
        Bundle bundle = getIntent().getExtras();
        usuario = bundle.getString("usuario");
        encabezado = (TextView)findViewById(R.id.textView2);
        encabezado.setText("Lista de repositorio del usuario "+usuario);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        AsyncTask<Void, Void, String> task = new AsyncTask<Void, Void, String>() {


            @Override
            protected String doInBackground(Void... voids) {
                String resultado = new HttpServerConnection().connectToServer("https://api.github.com/users/" + usuario + "/repos", 15000);
                //String resultado = new HttpServerConnection().connectToServer("http://www.mocky.io/v2/57eee3822600009324111202", 15000);
                return resultado;
            }

            @Override
            protected void onPostExecute(String Result) {
                if (Result != null) {
                    System.out.println();
                    if(getLista(Result).isEmpty()) {
                        encabezado.setText("NO EXISTE USUARIO INGRESADO");
                    }else{
                        adapter = new UIAdapter(getLista(Result));
                        recyclerView.setAdapter(adapter);
                    }

                }
            }
        };
        task.execute();
    }

    private List<DatosGit> getLista(String Result) {
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

}


        //texto = (TextView) findViewById(R.id.textView2);
        //Bundle bundle = getIntent().getExtras();
        //texto.setText(bundle.getString("usuario"));

