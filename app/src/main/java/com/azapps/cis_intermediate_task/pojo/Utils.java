package com.azapps.cis_intermediate_task.pojo;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Utils {

    public static void replaceFragments(Fragment fragment, FragmentManager fragmentManager, int container) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(container, fragment)
                .commit();
    }
}
