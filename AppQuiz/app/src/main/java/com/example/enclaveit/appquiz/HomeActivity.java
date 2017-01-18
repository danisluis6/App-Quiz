package com.example.enclaveit.appquiz;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.enclaveit.appquiz.adapter.DrawerAdapter;
import com.example.enclaveit.appquiz.bean.DrawerItem;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeActivity extends AppCompatActivity{

    private TextView navHeaderAuthorName;
    private TextView navHeaderAuthorDescription;
    private CircleImageView navHeaderAuthorAvatar;

    private ListView mDrawerList;
    private String[] mNavigationDrawerItemTitles;
    private NavigationView navigationView;


    private DrawerLayout mDrawerLayout;

    // Declaring vairable
    private CharSequence mDrawerTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.setSupportActionBar(toolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.setDrawerListener(toggle);
        mDrawerLayout.setScrimColor(getResources().getColor(android.R.color.transparent));
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);

        // Let 's  establish s a lot of widgets android, avoid NullPointerException
        establishWidgetsAndroid();
        // I just downloaded a lot of fonts and I want to set these fonts for text
        establishFontsWidgetAndroid();

         // I will set all of data DrawerItem for Adapter
        setDataForAdapterDrawer();

        // Get information that setting in navigation drawer
        getInformationNavigationDrawer();
    }

    private void getInformationNavigationDrawer() {
        mDrawerTitle = getTitle();
        mNavigationDrawerItemTitles = getResources().getStringArray(R.array.navigation_drawer_items_array);
        this.getSupportActionBar().setTitle(mDrawerTitle);

        Log.d("title",String.valueOf(mDrawerTitle));
    }

    private void setDataForAdapterDrawer() {
        mDrawerList.setAdapter(new DrawerAdapter(this,R.layout.list_view_item_row,getDrawerItem()));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    private void selectItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_view, fragment).commit();
            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            setTitle(mNavigationDrawerItemTitles[position]);
            mDrawerLayout.closeDrawer(mDrawerList);
        } else {
            Log.e("MainActivity", "Error in creating fragment");
        }
    }

    private DrawerItem[] getDrawerItem() {
        /**
         *  Do you have something to declare ?
         *  - Create data for object DrawerItem.
         * - So I 'm preparing for that:
         *  * icon png for menu navigation
         *  * array-string that definite in string.xml
         */
        DrawerItem[] drawerItems = new DrawerItem[7];
        drawerItems[0] = new DrawerItem(R.drawable.ic_menu_home,"Home");
        drawerItems[1] = new DrawerItem(R.drawable.ic_menu_math,"Math");
        drawerItems[2] = new DrawerItem(R.drawable.ic_menu_physic,"Physical");
        drawerItems[3] = new DrawerItem(R.drawable.ic_menu_chemistry,"Chemistry");
        drawerItems[4] = new DrawerItem(R.drawable.ic_menu_biology,"Biology");
        drawerItems[5] = new DrawerItem(R.drawable.ic_menu_setting,"Setting");
        drawerItems[6] = new DrawerItem(R.drawable.ic_menu_support,"Support");
        return drawerItems;
    }

    private void establishWidgetsAndroid() {
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navHeaderAuthorAvatar = (CircleImageView)this.findViewById(R.id.nav_header_author_avatar);
        navHeaderAuthorName = (TextView)this.findViewById(R.id.nav_header_author_name) ;
        navHeaderAuthorDescription = (TextView)this.findViewById(R.id.nav_header_author_description);

        // establish list of menu in DrawerLayout
        mDrawerList = (ListView)this.findViewById(R.id.menuList);
    }

    private void establishFontsWidgetAndroid() {
        navHeaderAuthorName.setTypeface(Typeface.createFromAsset(this.getAssets(),"fonts/Roboto-Light.ttf"));
        navHeaderAuthorDescription.setTypeface(Typeface.createFromAsset(this.getAssets(),"fonts/Roboto-Light.ttf"));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
