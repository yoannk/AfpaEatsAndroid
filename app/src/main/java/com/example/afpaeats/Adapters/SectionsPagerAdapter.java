package com.example.afpaeats.Adapters;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.afpaeats.Fragments.CuisinesFragment;
import com.example.afpaeats.Fragments.RestosFragment;
import com.example.afpaeats.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private final Context _context;

    String _typeCuisinesJson;
    String _restosJson;

    public void setTypeCuisinesJson(String typeCuisinesJson) {
        this._typeCuisinesJson = typeCuisinesJson;
    }

    public void setRestosJson(String restosJson) {
        this._restosJson = restosJson;
    }

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        _context = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        Fragment fragment = null;

        switch (position) {
            case 1:
                fragment = RestosFragment.newInstance(_restosJson, "");
                break;
            case 2:
                fragment = CuisinesFragment.newInstance(_typeCuisinesJson);
                break;
            default:
                fragment = RestosFragment.newInstance(_restosJson, "");
                break;
        }

        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return _context.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 2;
    }
}