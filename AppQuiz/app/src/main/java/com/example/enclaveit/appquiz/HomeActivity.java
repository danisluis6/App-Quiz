package com.example.enclaveit.appquiz;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.enclaveit.appquiz.adapter.DrawerAdapter;
import com.example.enclaveit.appquiz.bean.DrawerItem;
import com.example.enclaveit.appquiz.listener.DrawerItemClickListener;

public class HomeActivity extends AppCompatActivity{

    private String[] mNavigationDrawerItemTitles;
    private NavigationView navigationView;
    private Toolbar toolbar;

    private ListView mDrawerList;
    private DrawerLayout mDrawerLayout;

    private static final String TAG = "HomeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if(establishWidgetsAndroid()){
            setDataForAdapterDrawer();

            // I will set NavigationDrawer
            mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
            mDrawerLayout.setScrimColor(getResources().getColor(android.R.color.transparent));
            setupDrawerToggle();

            // Get information that setting in navigation drawer
            getInformationNavigationDrawer();
        }

    }

    private void getInformationNavigationDrawer() {
        mNavigationDrawerItemTitles = getResources().getStringArray(R.array.navigation_drawer_items_array);
    }

    private void setDataForAdapterDrawer() {
        mDrawerList.setAdapter(new DrawerAdapter(this,R.layout.item_menu_navigation,getDrawerItem()));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener(HomeActivity.this));
        // How do I remove lines between ListViews on Android
        mDrawerList.setDivider(null);
        mDrawerList.setDividerHeight(0);
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

    /**
     *   @author: Lorence
     *   establish wigets android by findViewById
     *   Example: ListView or Toolbar,...
     *
     *   Especial: there are some setting for toobar such as: DisplayHomeAsUpEnabled...
     */

    private boolean establishWidgetsAndroid() {
        boolean valid = true;
        try{
            mDrawerList = (ListView)this.findViewById(R.id.menuList);
            toolbar = (Toolbar)this.findViewById(R.id.toolbar);
        }catch(Exception ex){
            valid = false;
            Log.d(TAG,"Null Pointer Exception Widget Android");
        }

        /**
         * @author: Definition
         * Writting Exception to catch error "Null Pointer Exception"
         */
        if(valid){
            try{
                this.setSupportActionBar(toolbar);
                this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }catch (Exception ex){
                valid = false;
                Log.d(TAG,"DisplayHomeAsUpEnabled  - Null Pointer Exception");
            }
        }
        return valid;
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

    /**
     * @author: Lorence
     * @param position
     * Close Navigation Drawer
     */
    public void closeNavigationDrawer(int position) {
        mDrawerList.setItemChecked(position, true);
        mDrawerList.setSelection(position);
        Toast.makeText(this,"Result is "+position,Toast.LENGTH_LONG).show();
        mDrawerLayout.closeDrawer(Gravity.LEFT);
    }
}
