package ejemplo.certamen2.activities;

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
import ejemplo.certamen2.DatosGit;
import ejemplo.certamen2.R;
import ejemplo.certamen2.UIAdapter;
import ejemplo.certamen2.presenters.RepositorioPresenterImpl;
import ejemplo.certamen2.presenters.contract.RepositorioPresenter;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

public class RepositorioActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TextView encabezado;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private String usuario;
    private RepositorioPresenter repositorioPresenter;

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
        repositorioPresenter = new RepositorioPresenterImpl(usuario,recyclerView,adapter);
        AsyncTask<Void, Void, String> task = new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... voids) {
               return repositorioPresenter.Extraerdatos();
            }

            @Override
            protected void onPostExecute(String Result) {
             repositorioPresenter.ConnectarAdapter(Result);
            }
        };
        task.execute();
    }


}




