package id.persijap.jepara;

import android.app.*;
import android.os.*;
import android.support.annotation.NonNull;
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

public class MainActivity extends AppCompatActivity {

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
                case R.id.klub:
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
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Toolbar();

        btnberita = (Button) findViewById(R.id.btnBerita);
        btnberita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Berita.class));
            }
        });

        btnJadwal = (Button) findViewById(R.id.btnJadwal);
        btnJadwal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Jadwal.class));
            }
        });
        btnKlasemen = (Button) findViewById(R.id.btnKlasemen);
        btnKlasemen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Klasemen.class));
            }
        });
        btnPtv = (Button) findViewById(R.id.btnPTV);
        btnPtv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Persijaptv.class));
            }
        });
        btnGallery = (Button) findViewById(R.id.btnGallery);
        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Gallery.class));
            }
        });


    }

    private void Toolbar() {
        //Tampilkan Toolbar
        tb = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(tb);
        tb.setTitle(R.string.app_name);
        tb.setNavigationIcon(R.drawable.ic_menu);

        //Tampilkan Drawer Layout
        dl = (DrawerLayout) findViewById(R.id.drawer_layout);
        dl.setDrawerListener(new ActionBarDrawerToggle(this, dl, tb, R.string.drawer_open, R.string.drawer_close));

        //Tampilkan NavigationView
        nv = (NavigationView) findViewById(R.id.navigation_view);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                if (menuItem.isChecked()) menuItem.setChecked(false);
                else menuItem.setChecked(true);

                dl.closeDrawers();

                switch (menuItem.getItemId()) {
                    case R.id.drawer_home:
                        startActivity(new Intent(MainActivity.this, Home.class));
                        return true;
                    case R.id.drawer_jadwal:
                        startActivity(new Intent(MainActivity.this, Jadwal.class));
                        return true;
                    case R.id.drawer_berita:
                        startActivity(new Intent(MainActivity.this, Berita.class));
                        return true;
                    case R.id.drawer_klasemen:
                        startActivity(new Intent(MainActivity.this, Klasemen.class));
                        return true;
                    case R.id.drawer_ptv:
                        startActivity(new Intent(MainActivity.this, Persijaptv.class));
                        return true;
                    case R.id.drawer_tentang:
                        startActivity(new Intent(MainActivity.this, About.class));
                        return true;
                    case R.id.drawer_exit:
                        showDialog();
                    default:
                        return true;

                }

            }


        });
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

}
