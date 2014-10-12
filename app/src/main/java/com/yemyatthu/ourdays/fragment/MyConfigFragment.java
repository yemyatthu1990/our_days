package com.yemyatthu.ourdays.fragment;


import android.app.Fragment;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RemoteViews;

import com.yemyatthu.ourdays.R;
import com.yemyatthu.ourdays.widget.LoveWidgetProvider;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class MyConfigFragment extends Fragment {
    private EditText loveText;
    private Button loveButton;


    public MyConfigFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_my_config,container,false);
        loveText = (EditText) v.findViewById(R.id.set_love_text);
        loveButton = (Button) v.findViewById(R.id.update_text_button);
        loveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getActivity();
                AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
                RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_layout);
                ComponentName thisWidget = new ComponentName(context,LoveWidgetProvider.class);
                remoteViews.setTextViewText(R.id.together_text, loveText.getText().toString());
                appWidgetManager.updateAppWidget(thisWidget, remoteViews);
            }
        });
        return v;
    }


}
