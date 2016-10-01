package ejemplo.certamen2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebActivity extends AppCompatActivity {
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        webView=(WebView)findViewById(R.id.web);
        Bundle bundle = getIntent().getExtras();
        String dato=bundle.getString("url");
        webView.loadUrl(dato);
    }
}
