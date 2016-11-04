package ejemplo.certamen2.presenters;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import android.widget.EditText;


import ejemplo.certamen2.activities.RepositorioActivity;
import ejemplo.certamen2.presenters.contract.MainPresenter;

/**
 * Created by gerson on 04-11-16.
 */

public class MainPresenterImpl implements MainPresenter {
    Activity activity;
    EditText editText;

    public MainPresenterImpl(Activity activity,EditText editText){
        this.activity=activity;
        this.editText=editText;
    }


    @Override
    public void onClick(View view) {
        ejecutar(activity,editText);
    }

    @Override
    public void ejecutar(Activity activity, EditText editText) {
        Intent i = new Intent(activity, RepositorioActivity.class );
        i.putExtra("usuario", editText.getText().toString());
        activity.startActivity(i);

    }
}
