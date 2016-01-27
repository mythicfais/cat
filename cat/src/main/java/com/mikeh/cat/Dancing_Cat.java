package com.mikeh.cat;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.DialogInterface;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;


public class Dancing_Cat extends Activity {
    /**
    public String center = "@drawable/catcenter";
    public String left = "@drawable/catleft";
    public String right = "@drawable/catright";
    public String current = center;
     **/
    int current = 250;

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dancing__cat);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
        ImageView cat = (ImageView)findViewById(R.id.cat);
        ImageView catleft = (ImageView)findViewById(R.id.catleft);
        ImageView catright = (ImageView)findViewById(R.id.catright);

        Button buttonleft = (Button)findViewById(R.id.buttonleft);
        Button buttonright = (Button)findViewById(R.id.buttonright);


    }




    public void leftclick(View v)
    {
        final ImageView cat = (ImageView)findViewById(R.id.cat);
        final ImageView catleft = (ImageView)findViewById(R.id.catleft);
        final ImageView catright = (ImageView)findViewById(R.id.catright);

        catleft.setVisibility(catleft.VISIBLE);
        catright.setVisibility(catright.INVISIBLE);
        cat.setVisibility(cat.INVISIBLE);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(current);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        catleft.setVisibility(catleft.INVISIBLE);
                        cat.setVisibility(cat.VISIBLE);
                    }
                });
            }
        }).start();
    }

    public void rightclick(View v)
    {
        final ImageView cat = (ImageView)findViewById(R.id.cat);
        final ImageView catleft = (ImageView)findViewById(R.id.catleft);
        final ImageView catright = (ImageView)findViewById(R.id.catright);

        catleft.setVisibility(catleft.INVISIBLE);
        catright.setVisibility(catright.VISIBLE);
        cat.setVisibility(cat.INVISIBLE);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(current);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        catright.setVisibility(catleft.INVISIBLE);
                        cat.setVisibility(cat.VISIBLE);
                    }
                });
            }
        }).start();
    }

    public void faster(View w) {
        current -= 25;
    }

    public void slower(View w) {
        current += 25;
    }

    public void changepic(int a) {
        if (a == 1) {
            current = 1;
        }
        else if (a == 2) {
            current = 2;
        }
        else {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dancing__cat, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_dancing__cat, container, false);
            return rootView;
        }
    }


}
