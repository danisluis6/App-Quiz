package com.example.enclaveit.appquiz.listener;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.enclaveit.appquiz.HomeActivity;
import com.example.enclaveit.appquiz.R;
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

/**
 * Created by enclaveit on 07/02/2017.
 */

public class DrawerItemClickListener implements ListView.OnItemClickListener {

    private HomeActivity mainActivity;
    private static  final String TAG = "MainActivity";

    public DrawerItemClickListener(Context context){
        if(context instanceof HomeActivity){
            this.mainActivity = (HomeActivity) context;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        selectItem(position);
    }

    private void selectItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new HomeFragment();
                break;
            case 1:
                fragment = new HTMLFragment();
                break;
            case 2:
                fragment = new CSSFragment();
                break;
            case 3:
                fragment = new JavaScriptFragment();
                break;
            case 4:
                fragment = new BootstrapFragment();
                break;
            case 5:
                fragment = new JQueryFragment();
                break;
            case 6:
                fragment = new PHPFragment();
                break;
            case 7:
                fragment = new SQLFragment();
                break;
            case 8:
                fragment = new XMLFragment();
                break;
            case 9:
                fragment = new SettingFragment();
                break;
            case 10:
                fragment = new SupportFragment();
                break;
            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
            /**
             *  @author: Lorence
             *  Close Navigation when user click i
             */
            mainActivity.closeNavigationDrawer(position);
        } else {
            Log.e(TAG, "Error in creating fragment");
        }
    }
}
