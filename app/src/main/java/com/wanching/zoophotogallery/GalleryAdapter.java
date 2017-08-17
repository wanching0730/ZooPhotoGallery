package com.wanching.zoophotogallery;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by WanChing on 17/8/2017.
 */

public class GalleryAdapter extends ArrayAdapter<Album> {

    public GalleryAdapter(Activity context, ArrayList<Album> albums){
        super(context, 0, albums);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        final Album currentAlbum = getItem(position);

        TextView tvTitle = (TextView) convertView.findViewById(R.id.title);
        TextView tvCount = (TextView) convertView.findViewById(R.id.photoCount);

        tvTitle.setText(currentAlbum.getTitle());
        tvCount.setText(Integer.toString(currentAlbum.getPhotoCount()));

        return convertView;
    }
}
