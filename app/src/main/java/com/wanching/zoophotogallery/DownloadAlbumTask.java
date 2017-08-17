package com.wanching.zoophotogallery;

import android.content.AsyncTaskLoader;
import android.os.AsyncTask;
import android.util.JsonReader;
import android.util.Log;

import org.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by WanChing on 17/8/2017.
 */

public class DownloadAlbumTask extends AsyncTask<Void, Void, ArrayList<Album>> {

    private static final String ALBUM_URL = "https://jamesooi.com/photos/album/get-albums-json";

    @Override
    protected ArrayList<Album> doInBackground(Void... voids) {

        ArrayList<Album> albums = null;

        try{
            albums = downloadAlbums();
        }catch (IOException ex){
            Log.e("IOEXCEPTION", ex.toString());
        }

        return albums;
    }

    @Override
    protected void onPostExecute(ArrayList<Album> alba) {
        super.onPostExecute(alba);
    }

    private ArrayList<Album> downloadAlbums() throws IOException{
        InputStream inputStream = null;

        try{
            URL url = new URL(ALBUM_URL);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.connect();

            int responseCode = conn.getResponseCode();
            if(responseCode == 200 || responseCode == 304){
                inputStream = conn.getInputStream();

                ArrayList<Album> albums = readInputStream(inputStream);
                return albums;
            }else{
                Log.e("HTTP_ERROR", Integer.toString(responseCode));
                return null;
            }

        }catch (Exception ex){
            Log.e("EXCEPTION", ex.toString());
        }finally {
            if(inputStream != null){
                inputStream.close();
            }
        }
    }

    private ArrayList<Album> readInputStream (InputStream inputStream)
        throws IOException{

        JsonReader reader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"));



    }
}
