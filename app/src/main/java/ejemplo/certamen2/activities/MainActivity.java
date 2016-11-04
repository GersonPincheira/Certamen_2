package ejemplo.certamen2.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ejemplo.certamen2.R;
import ejemplo.certamen2.presenters.MainPresenterImpl;
import ejemplo.certamen2.presenters.contract.MainPresenter;

public class MainActivity extends AppCompatActivity {
    EditText peticion;
    Button boton;
    MainPresenter mainPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        peticion =(EditText) findViewById(R.id.editText);
        boton =(Button) findViewById(R.id.button);
        mainPresenter = new MainPresenterImpl(this,peticion);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainPresenter.onClick(view);
            }
        });
    }
}
