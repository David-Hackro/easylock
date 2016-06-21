package hackathon.app.lock.easy.easylock.Activities;

import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import hackathon.app.lock.easy.easylock.Fragments.MainFragment;
import hackathon.app.lock.easy.easylock.Fragments.RegitrarseCompletoFragment;
import hackathon.app.lock.easy.easylock.R;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    TextView toolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        setSupportActionBar(toolbar);
       // getSupportActionBar().setDisplayShowTitleEnabled(false);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
       // toolbarTitle = (TextView) findViewById(R.id.toolbartitle);


        MainFragment mainFragment = new MainFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame,mainFragment);
        transaction.commit();

    }


    public void Registrar(){
        RegitrarseCompletoFragment regitrarseCompletoFragment = new RegitrarseCompletoFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame,regitrarseCompletoFragment);
        transaction.commit();
        //Toast.makeText(getApplicationContext(),"Hi",Toast.LENGTH_SHORT).show();

    }
}
