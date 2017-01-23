package com.example.enclaveit.appquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.enclaveit.appquiz.adapter.DrawerAdapter;
import com.example.enclaveit.appquiz.bean.DrawerItem;
import com.example.enclaveit.appquiz.fragment.BootstrapFragment;
import com.example.enclaveit.appquiz.fragment.CSSFragment;
import com.example.enclaveit.appquiz.fragment.HTMLFragment;
import com.example.enclaveit.appquiz.fragment.HomeFragment;
import com.example.enclaveit.appquiz.fragment.JQueryFragment;
import com.example.enclaveit.appquiz.fragment.JavaScriptFragment;
import com.example.enclaveit.appquiz.fragment.PHPFragment;
import com.example.enclaveit.appquiz.fragment.SQLFragment;
import com.example.enclaveit.appquiz.fragment.SettingFragment;
import com.example.enclaveit.appquiz.fragment.SupportFragment;
import com.example.enclaveit.appquiz.fragment.XMLFragment;

public class HomeActivity extends AppCompatActivity{

    private ListView mDrawerList;
    private String[] mNavigationDrawerItemTitles;
    private NavigationView navigationView;
    private Toolbar toolbar;

    private DrawerLayout mDrawerLayout;

    // Declaring vairable
    private CharSequence mDrawerTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setupToolbar();

        // Let 's  establish s a lot of widgets android, avoid NullPointerException
        establishWidgetsAndroid();
        // I just downloaded a lot of fonts and I want to set these fonts for text
        establishFontsWidgetAndroid();

         // I will set all of data DrawerItem for Adapter
        setDataForAdapterDrawer();

        // I will set NavigationDrawer
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.setScrimColor(getResources().getColor(android.R.color.transparent));
        setupDrawerToggle();

        // Get information that setting in navigation drawer
        getInformationNavigationDrawer();
    }

    private void getInformationNavigationDrawer() {
        mNavigationDrawerItemTitles = getResources().getStringArray(R.array.navigation_drawer_items_array);
    }

    private void setDataForAdapterDrawer() {
        mDrawerList.setAdapter(new DrawerAdapter(this,R.layout.item_menu_navigation,getDrawerItem()));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        // How do I remove lines between ListViews on Android
        mDrawerList.setDivider(null);
        mDrawerList.setDividerHeight(0);
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
                fragment = new HTMLFragment();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            setTitle(mNavigationDrawerItemTitles[position]);
            mDrawerLayout.closeDrawer(mDrawerList);
        } else {
            Log.e("MainActivity", "Error in creating fragment");
        }
    }

    @Override
    public void setTitle(CharSequence title) {
        mDrawerTitle = title;
        getSupportActionBar().setTitle(mDrawerTitle);
    }

    private DrawerItem[] getDrawerItem() {
        /**
         *  Do you have something to declare ?
         *  - Create data for object DrawerItem.
         * - So I 'm preparing for that:
         *  * icon png for menu navigation
         *  * array-string that definite in string.xml
         */
        DrawerItem[] drawerItems = new DrawerItem[11];
        drawerItems[0] = new DrawerItem(R.drawable.ic_home,"Home");
        drawerItems[1] = new DrawerItem(R.drawable.ic_html,"HTML");
        drawerItems[2] = new DrawerItem(R.drawable.ic_css,"CSS");
        drawerItems[3] = new DrawerItem(R.drawable.ic_js,"JavaScript");
        drawerItems[4] = new DrawerItem(R.drawable.ic_bootstrap,"Bootstrap");
        drawerItems[5] = new DrawerItem(R.drawable.ic_jquery,"JQuery");
        drawerItems[6] = new DrawerItem(R.drawable.ic_php,"PHP");
        drawerItems[7] = new DrawerItem(R.drawable.ic_sql,"SQL");
        drawerItems[8] = new DrawerItem(R.drawable.ic_xml,"XML");
        drawerItems[9] = new DrawerItem(R.drawable.ic_setting,"Setting");
        drawerItems[10] = new DrawerItem(R.drawable.ic_support,"Support");
        return drawerItems;
    }

    private void establishWidgetsAndroid() {
        // establish list of menu in DrawerLayout
        mDrawerList = (ListView)this.findViewById(R.id.menuList);
    }

    private void establishFontsWidgetAndroid() {
        //
    }

    private void setupDrawerToggle() {
        toolbar.setNavigationIcon(R.drawable.ic_menu);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(Gravity.LEFT);
            }
        });
    }

    private void setupToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.setSupportActionBar(toolbar);
    }
}
