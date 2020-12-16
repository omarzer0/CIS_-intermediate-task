package com.azapps.cis_intermediate_task.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.azapps.cis_intermediate_task.R;
import com.azapps.cis_intermediate_task.adapter.ItemAdapter;
import com.azapps.cis_intermediate_task.adapter.OnFoodItemClick;
import com.azapps.cis_intermediate_task.adapter.ViewPagerAdapter;
import com.azapps.cis_intermediate_task.pojo.FoodItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements OnFoodItemClick {
    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    private RecyclerView sellsRecyclerView;
    private RecyclerView offersRecyclerView;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initViews(view);
        setUpSlider();
        setUpSellsRV();
        setUpOffersRV();
        return view;
    }

    private void initViews(View view) {
        sellsRecyclerView = view.findViewById(R.id.best_sells_rv);
        offersRecyclerView = view.findViewById(R.id.offers_rv);
        viewPager = view.findViewById(R.id.pager);
        tabLayout = view.findViewById(R.id.tab_dots);
    }

    private void setUpSlider() {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private ArrayList<FoodItem> generateFakeData(int number, boolean hasOffer) {
        ArrayList<FoodItem> foodItems = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            foodItems.add(new FoodItem(R.drawable.pizza, "Pizza", 15.0, 10.0, 5.0, hasOffer));
        }
        return foodItems;
    }

    private void setUpSellsRV() {
        LinearLayoutManager sellsLayoutManger = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        sellsRecyclerView.setLayoutManager(sellsLayoutManger);
        sellsRecyclerView.hasFixedSize();
        ItemAdapter sellsAdapter = new ItemAdapter(this);
        ArrayList<FoodItem> sellsItemArrayList = generateFakeData(10, false);
        sellsAdapter.submitList(sellsItemArrayList);
        sellsRecyclerView.setAdapter(sellsAdapter);
    }

    private void setUpOffersRV() {
        LinearLayoutManager offersLayoutManger = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        offersRecyclerView.setLayoutManager(offersLayoutManger);
        offersRecyclerView.hasFixedSize();
        ItemAdapter offersAdapter = new ItemAdapter(this);
        ArrayList<FoodItem> offersItemArrayList = generateFakeData(10, true);
        offersAdapter.submitList(offersItemArrayList);
        offersRecyclerView.setAdapter(offersAdapter);
    }

    @Override
    public void onFoodClick(int position) {
        Toast.makeText(getActivity(), "Clicked position#"+position, Toast.LENGTH_SHORT).show();
    }
}