package ejemplo.certamen2.presenters.contract;



import android.os.AsyncTask;

import java.util.List;

import ejemplo.certamen2.Models.DatosGit;

/**
 * Created by gerson on 17-10-16.
 */

public interface RepositorioPresenter {

    public List<DatosGit> getLista(String Result);

    public AsyncTask<Void, Void, String> Extraerdatos();

    public void ConnectarAdapter(String result);


}
