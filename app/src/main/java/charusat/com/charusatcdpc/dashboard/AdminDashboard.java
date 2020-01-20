package charusat.com.charusatcdpc.dashboard;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import charusat.com.charusatcdpc.admin.ViewSelectedStudents;
import charusat.com.charusatcdpc.authentication.LoginActivityFirebase;
import charusat.com.charusatcdpc.authentication.LogoutActivity;
import charusat.com.charusatcdpc.student.AcademicData;
import charusat.com.charusatcdpc.admin.AddCompanyDetails;
import charusat.com.charusatcdpc.admin.CdpcActivities;
import charusat.com.charusatcdpc.student.PersonalData;
import charusat.com.charusatcdpc.admin.PlacementData;
import charusat.com.charusatcdpc.R;


public class AdminDashboard extends AppCompatActivity {

    ImageView img_add_personal_data;
    ImageView img_add_academic_data;
   // ImageView img_vew_details ;
    ImageView img_add_company_details ;
    ImageView img_placement_data ;
    ImageView img_cdpc_activities ;
    ImageView img_selected_students;


    //private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);

        setContentView(R.layout.activity_admin_dashboard);

        img_add_personal_data = (ImageView) findViewById(R.id.img_add_personal_data);
        img_add_academic_data = (ImageView) findViewById(R.id.img_add_academic_data);
       // img_vew_details = (ImageView) findViewById(R.id.img_view_details);
        img_add_company_details = (ImageView) findViewById(R.id.img_add_company_details);
        img_placement_data = (ImageView) findViewById(R.id.img_placement_data);
        img_cdpc_activities = (ImageView) findViewById(R.id.img_cdpc_activities);
        img_selected_students = (ImageView) findViewById(R.id.img_selected_students);

       /* DrawerLayout mDrawerlayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        assert mDrawerlayout != null;
        mToggle = new ActionBarDrawerToggle(this, mDrawerlayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerlayout.addDrawerListener(mToggle);
        mToggle.syncState();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);*/

        img_placement_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminDashboard.this,PlacementData.class);
                startActivity(intent);
            }
        });

        img_cdpc_activities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent = new Intent(AdminDashboard.this,CdpcActivities.class);
                startActivity(myintent);
            }
        });

        img_add_personal_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent myintent = new Intent(AdminDashboard.this,PersonalData.class);
                startActivity(myintent);
            }
        });

        img_add_academic_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent = new Intent(AdminDashboard.this,AcademicData.class);
                startActivity(myintent);
            }
        });

        img_add_company_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent = new Intent(AdminDashboard.this,AddCompanyDetails.class);
                startActivity(myintent);
            }
        });

        img_selected_students.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent = new Intent(AdminDashboard.this,ViewSelectedStudents.class);
                startActivity(myintent);
            }
        });



    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        // show menu only when home fragment is selected
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main_navigation_drawer,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
    /*    if (id == R.id.action_logout) {
            Toast.makeText(getApplicationContext(), "Logout user!", Toast.LENGTH_LONG).show();
            return true;
        }

        // user is in notifications fragment
        // and selected 'Mark all as Read'
        if (id == R.id.action_mark_all_read) {
            Toast.makeText(getApplicationContext(), "All notifications marked as read!", Toast.LENGTH_LONG).show();
        }
*/
        // user is in notifications fragment
        // and selected 'Clear All'
        if (id == R.id.nav_logout) {
            Toast.makeText(getApplicationContext(), "Logout", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(AdminDashboard.this,LogoutActivity.class);
            startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }


  /*  @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/
}


    /* Toolbar toolbar = findViewById(R.id.toolbar);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        setSupportActionBar(toolbar);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        setUpNavigationView();

    }

    // show or hide the fab
    private void toggleFab() {
        if (navItemIndex == 0)
            fab.show();
        else
            fab.hide();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

            getMenuInflater().inflate(R.menu.activity_main_navigation_drawer, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.nav_logout) {
            Toast.makeText(getApplicationContext(), "Logout user!", Toast.LENGTH_LONG).show();
            return true;
        }

        // user is in notifications fragment
        // and selected 'Mark all as Read'
        if (id == R.id.nav_contact_us) {
            Toast.makeText(getApplicationContext(), "Contact Us!", Toast.LENGTH_LONG).show();
        }

        // user is in notifications fragment
        // and selected 'Clear All'
        if (id == R.id.nav_dashboard) {
            Toast.makeText(getApplicationContext(), "To the Dashboard!", Toast.LENGTH_LONG).show();
        }

        if (id == R.id.nav_my_profile) {
            Toast.makeText(getApplicationContext(), "My profile!", Toast.LENGTH_LONG).show();
        }

        if (id == R.id.nav_quit) {
            Toast.makeText(getApplicationContext(), "Quit the App!", Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }

    private void setUpNavigationView() {
        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()) {
                    //Replacing the main content with ContentFragment Which is our Inbox View;
                    case R.id.nav_dashboard:
                        navItemIndex = 0;

                        break;
                    case R.id.nav_contact_us:
                        navItemIndex = 1;

                        break;
                    case R.id.nav_my_profile:
                        navItemIndex = 2;
                        break;
                    case R.id.nav_logout:
                        navItemIndex = 3;
                        break;
                    case R.id.nav_quit:
                        navItemIndex = 4;
                        break;
                    default:
                        navItemIndex = 0;
                }

                //Checking if the item is in checked state or not, if not make it in checked state
                if (menuItem.isChecked()) {
                    menuItem.setChecked(false);
                } else {
                    menuItem.setChecked(true);
                }
                menuItem.setChecked(true);

                return true;
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawer.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessary or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    public boolean onNavigationItemSelected(MenuItem item){

        int id = item.getItemId();
        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        if (id == R.id.nav_dashboard) {
            Toast.makeText(this, "Dashboard Clicked", Toast.LENGTH_SHORT).show();
        }else if (id == R.id.nav_contact_us) {
            startActivity(new Intent(this, ContactUsActivity.class));
        }else if (id == R.id.nav_my_profile) {
            Intent i = new Intent(this, MyProfileActivity.class);
            startActivity(i);
            navigationView.getMenu().getItem(0).setChecked(true);
        } else if (id == R.id.nav_logout) {

        } else if (id == R.id.nav_quit) {
            Toast.makeText(this, "Quit Clicked", Toast.LENGTH_SHORT).show();
            System.exit(0);
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }*/

