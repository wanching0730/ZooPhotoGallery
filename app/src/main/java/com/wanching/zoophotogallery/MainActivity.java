package com.wanching.zoophotogallery;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private GalleryAdapter adapter;
    private ArrayList<Album> albums;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        albums = new ArrayList<Album>();
        listView = (ListView) findViewById(R.id.list_view);
        adapter = new GalleryAdapter(this, albums);


    }

    @Override
    protected void onResume() {
        super.onResume();

        ConnectivityManager connMgr = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if(networkInfo != null && networkInfo.isConnected()) {
            new DownloadImageTask(MainActivity.this).execute();
        }
        else {
            Toast toast = Toast.makeText(MainActivity.this, "network unavailable", Toast.LENGTH_LONG);
            toast.show();
        }
    }
}
