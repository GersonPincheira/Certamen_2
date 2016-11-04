package ejemplo.certamen2.presenters.contract;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by gerson on 04-11-16.
 */

public interface MainPresenter extends View.OnClickListener {

    public void ejecutar(Activity activity, EditText editText);

    @Override
    void onClick(View view);


}
