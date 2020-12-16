package com.azapps.cis_intermediate_task.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.azapps.cis_intermediate_task.R;

public class ScreenSlidePageFragment extends Fragment {
    public ScreenSlidePageFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.screen_slide_page_fragment, container, false);
        ImageView bgImage = view.findViewById(R.id.view_pager_img);
        int position = getArguments().getInt("msg");
        if (position == 0) bgImage.setImageResource(R.drawable.sales_st);
        else bgImage.setImageResource(R.drawable.sales_ed);
        return view;
    }
}
