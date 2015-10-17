package com.example.samarthvasishta.sjbitportal;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

/**
 * Created by Karthik on 10/3/2015.
 */
public class NotificationFragment extends Fragment{
    Context applicationContext = MainActivity.getContextOfApplication();
    String ErrorMessage = "Error 404 : Data NotificationActivity Found";
    ListView mDrawerListView ;
    String message1 = PreferenceManager.getDefaultSharedPreferences(applicationContext).getString("message1", ErrorMessage);
    String message2 = PreferenceManager.getDefaultSharedPreferences(applicationContext).getString("message2", ErrorMessage);
    String message3 = PreferenceManager.getDefaultSharedPreferences(applicationContext).getString("message3", ErrorMessage);
    String message4 = PreferenceManager.getDefaultSharedPreferences(applicationContext).getString("message4", ErrorMessage);
    String message5 = PreferenceManager.getDefaultSharedPreferences(applicationContext).getString("message5", ErrorMessage);
    String subject1 = PreferenceManager.getDefaultSharedPreferences(applicationContext).getString("subject1",ErrorMessage);
    String subject2 = PreferenceManager.getDefaultSharedPreferences(applicationContext).getString("subject2",ErrorMessage);
    String subject3 = PreferenceManager.getDefaultSharedPreferences(applicationContext).getString("subject3",ErrorMessage);
    String subject4 = PreferenceManager.getDefaultSharedPreferences(applicationContext).getString("subject4",ErrorMessage);
    String subject5 = PreferenceManager.getDefaultSharedPreferences(applicationContext).getString("subject5",ErrorMessage);
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle)  {
        super.onCreate(bundle);
        mDrawerListView = (ListView) inflater.inflate(R.layout.fragment_navigation_drawer, container, false);

        /**
         * Showing Swipe Refresh animation on activity create
         * As animation won't start on onCreate, post runnable is used
         */

        mDrawerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectItem(position);
            }
        });
        ArrayList<String> MyArray=new ArrayList<>();

        if(!subject1.equals(ErrorMessage)&&!subject1.equals("null")&&subject1!=null)
        MyArray.add(subject1);
        else
        MyArray.add("No New Notifications . Try Refreshing to Check for New Notifications");
        if(!subject2.equals(ErrorMessage)&&!subject2.equals("null")&&subject2!=null)
            MyArray.add(subject2);
        if(!subject3.equals(ErrorMessage)&&!subject3.equals("null")&&subject3!=null)
            MyArray.add(subject3);
        if(!subject4.equals(ErrorMessage)&&!subject4.equals("null")&&subject4!=null)
            MyArray.add(subject4);
        if(!subject5.equals(ErrorMessage)&&!subject5.equals("null")&&subject5!=null)
            MyArray.add(subject5);

        mDrawerListView.setAdapter(new ArrayAdapter<String>(
                getActionBar().getThemedContext(),
                android.R.layout.simple_expandable_list_item_1,
                android.R.id.text1, MyArray));

        PreferenceManager.getDefaultSharedPreferences(applicationContext).edit()
                .putBoolean("firstTime", false).commit();
        return mDrawerListView;
    }


    protected void selectItem(int position) {
        Intent intent;
        switch(position)
        {
            case 0:
            {
                intent = new Intent(getActivity(),NotificationActivity.class);
                intent.putExtra("message", message1);
                intent.putExtra("subject",subject1);
                startActivity(intent);
            }break;
            case 1:
            {
                intent = new Intent(getActivity(),NotificationActivity.class);
                intent.putExtra("message", message2);
                intent.putExtra("subject",subject2);
                startActivity(intent);
            }break;
            case 2:
            {
                intent = new Intent(getActivity(),NotificationActivity.class);
                intent.putExtra("message", message3);
                intent.putExtra("subject",subject3);
                startActivity(intent);
            }break;
            case 3:
            {
                intent = new Intent(getActivity(),NotificationActivity.class);
                intent.putExtra("message", message4);
                intent.putExtra("subject",subject4);
                startActivity(intent);
            }break;
            case 4:
            {
                intent = new Intent(getActivity(),NotificationActivity.class);
                intent.putExtra("message", message5);
                intent.putExtra("subject",subject5);
                startActivity(intent);
            }break;
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // If the drawer is open, show the global app actions in the action bar. See also
        // showGlobalContextActionBar, which controls the top-left area of the action bar.
            inflater.inflate(R.menu.notification, menu);
            showGlobalContextActionBar();
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
           return super.onOptionsItemSelected(item);
    }

    /**
     * Per the navigation drawer design guidelines, updates the action bar to show the global app
     * 'context', rather than just what's in the current screen.
     */
    private void showGlobalContextActionBar() {
        android.support.v7.app.ActionBar actionBar = getActionBar();
        try {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle("Notifications");
        }
        catch(NullPointerException e)
        {
        }
    }

    private android.support.v7.app.ActionBar getActionBar() {
        return ((AppCompatActivity) getActivity()).getSupportActionBar();
    }


}
