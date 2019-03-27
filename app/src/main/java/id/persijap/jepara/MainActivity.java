package id.persijap.jepara;

import android.app.*;
import android.os.*;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.support.design.widget.Snackbar;
import android.support.design.widget.*;
import android.view.*;
import android.support.design.widget.BottomNavigationView;
import android.widget.*;
import android.content.*;
import android.view.View.*;
import android.view.View;
import android.widget.Button;
import android.support.v4.widget.*;
import android.webkit.*;
import android.net.*;
import android.graphics.*;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private Toolbar tb;
    private NavigationView nv;
    private DrawerLayout dl;
    private TextView mTextMessage;
    Button btnberita, btnJadwal, btnKlasemen, btnPtv, btnGallery, btnAbout;
    private ViewPager vp;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.home:
                    return true;
                case R.id.berita:
                    return true;
                case R.id.gallery:
                    return true;
                case R.id.pemain:
                    return true;
                case R.id.ptv:
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
        loadFragment(new Home());

    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            showDialog();
        }

        return super.onKeyDown(keyCode, event);
    }

    private void showDialog() {
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);

        alertDialogBuilder.setTitle("Perhatian!");
        alertDialogBuilder
                .setMessage("Yakin Ingin Keluar dari Aplikasi Ini ?")
                .setIcon(R.drawable.ic_launcher)
                .setCancelable(false)
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MainActivity.this.finish();
                    }
                })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;

        switch (menuItem.getItemId()){
            case R.id.home:
                fragment = new Home();
                break;
            case R.id.berita:
                fragment = new Berita();
                break;
            case R.id.gallery:
                fragment = new Berita();
                break;
            case R.id.pemain:
                fragment = new Pemain();
                break;
            case R.id.persijaptv:
                fragment = new Persijaptv();
                break;
        }
        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, fragment).commit();
            return true;
        }
        return false;
    }
}
