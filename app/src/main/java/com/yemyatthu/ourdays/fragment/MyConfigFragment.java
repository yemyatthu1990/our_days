package com.yemyatthu.ourdays.fragment;


import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RemoteViews;

import com.cengalabs.flatui.FlatUI;
import com.yemyatthu.ourdays.R;
import com.yemyatthu.ourdays.widget.LoveWidgetProvider;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class MyConfigFragment extends Fragment {
    @InjectView(R.id.set_love_text) EditText loveText;
    @InjectView(R.id.update_text_button) Button loveButton;
    @InjectView(R.id.main_male)ImageView mainMale;
    @InjectView(R.id.main_female) ImageView mainFemale;


    public MyConfigFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FlatUI.initDefaultValues(getActivity());
        FlatUI.setDefaultTheme(R.array.candy);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_my_config,container,false);
        ButterKnife.inject(this,v);
        mainMale.setImageResource(R.drawable.doge);
        mainFemale.setImageResource(R.drawable.doge);
        loveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getActivity();
                AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
                RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_layout);
                ComponentName thisWidget = new ComponentName(context, LoveWidgetProvider.class);
                remoteViews.setTextViewText(R.id.together_text, loveText.getText().toString());
                remoteViews.setImageViewResource(R.id.main_male, R.drawable.doge);
                remoteViews.setImageViewResource(R.id.main_female,R.drawable.doge);
                appWidgetManager.updateAppWidget(thisWidget, remoteViews);
            }
        });
        return v;
    }



}
