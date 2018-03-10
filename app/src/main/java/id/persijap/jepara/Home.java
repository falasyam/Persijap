package id.persijap.jepara;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import id.persijap.jepara.R;

/**
 * Created by mitracomp on 22/10/2017.
 */

public class Home extends AppCompatActivity {

    private Toolbar tb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sejarah);
        Toolbar();
        TextView textView = (TextView)findViewById(R.id.textpsjp);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"font/edo.ttf");
        textView.setTypeface(typeface);
    }

    private void Toolbar() {
        //Tampilkan Toolbar
        tb = (android.support.v7.widget.Toolbar) findViewById(R.id.tbsejarah);
        setSupportActionBar(tb);
        tb.setTitle(R.string.app_name);
        tb.setNavigationIcon(R.drawable.ic_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
