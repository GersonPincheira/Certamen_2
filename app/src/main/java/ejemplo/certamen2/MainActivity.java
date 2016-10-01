package ejemplo.certamen2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText peticion;
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        peticion =(EditText) findViewById(R.id.editText);
        boton =(Button) findViewById(R.id.button);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ejecutar(view);
            }
        });

    }
    public void ejecutar(View view) {
        Intent i = new Intent(this, Respuesta.class );
        i.putExtra("usuario", peticion.getText().toString());
        startActivity(i);
    }
}
