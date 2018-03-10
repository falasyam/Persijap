package id.persijap.jepara;

import android.support.v7.app.*;
import android.os.*;
import android.support.v7.widget.*;
import android.view.LayoutInflater;
import android.view.*;

public class About extends AppCompatActivity {
    private Toolbar tb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        Toolbar();
    }

    private void Toolbar() {
        tb = (Toolbar) findViewById(R.id.toolbar_ab);
        setSupportActionBar(tb);
        tb.setTitle(R.string.app_name);
        tb.setNavigationIcon(R.drawable.ic_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
