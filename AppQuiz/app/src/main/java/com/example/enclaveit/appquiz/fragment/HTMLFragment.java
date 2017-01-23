package com.example.enclaveit.appquiz.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.enclaveit.appquiz.R;
import com.example.enclaveit.appquiz.ScreenSlideActivity;


public class HTMLFragment extends Fragment {

    private Button start;

    public HTMLFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = (ViewGroup)inflater.inflate(R.layout.fragment_html, container, false);
        start = (Button)rootView.findViewById(R.id.start);
        return rootView;
    }

    public void onActivityCreated(@Nullable Bundle saveInstanceState){
        super.onActivityCreated(saveInstanceState);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ScreenSlideActivity.class);
                startActivity(intent);
            }
        });
    }
}
