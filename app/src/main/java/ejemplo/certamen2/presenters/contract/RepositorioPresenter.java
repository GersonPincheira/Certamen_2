package ejemplo.certamen2.presenters.contract;

import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import ejemplo.certamen2.DatosGit;

/**
 * Created by gerson on 17-10-16.
 */

public interface RepositorioPresenter {

    public List<DatosGit> getLista(String Result);

    public String Extraerdatos();

    public void ConnectarAdapter(String result);


}
