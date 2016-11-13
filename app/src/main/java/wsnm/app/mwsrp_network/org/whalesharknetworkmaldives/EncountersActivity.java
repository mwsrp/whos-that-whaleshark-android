/*
 *  Copyright (C) Maldives Whale Shark Research Program
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see http://www.gnu.org/licenses/.
 *
 *  Author : Roberto Calvo Palomino <rocapal at gmail dot com>
 *
 */

package wsnm.app.mwsrp_network.org.whalesharknetworkmaldives;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONArray;

import java.util.ArrayList;

import wsnm.app.mwsrp_network.org.whalesharknetworkmaldives.API.Api;
import wsnm.app.mwsrp_network.org.whalesharknetworkmaldives.API.Encounters;
import wsnm.app.mwsrp_network.org.whalesharknetworkmaldives.API.PrivateKey;
import wsnm.app.mwsrp_network.org.whalesharknetworkmaldives.Tools.MySingleton;

public class EncountersActivity extends AppCompatActivity {

    private ListView mListView = null;
    private EncountersAdapter mAdapter = null;
    private ArrayList<Encounters> mEncountersList = null;

    private ImageLoader mImageLoader;

    private String TAG = this.getClass().getSimpleName();
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.encounters);
        mListView = (ListView) findViewById(R.id.encountersListView);

        mImageLoader = MySingleton.getInstance(this).getImageLoader();

        RequestQueue queue = Volley.newRequestQueue(this);

        String hashUrl = PrivateKey.getHashUrl(Api.MWSRP_ENCOUNTERS_PERIOD_URL);
        Log.d("Encounters", hashUrl);

        JsonArrayRequest getRequest = new JsonArrayRequest(Request.Method.GET, hashUrl, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("Response", response.toString());
                        Api api = new Api();
                        mEncountersList = api.getEncounters(response);
                        Log.d("Response", "Encounters Size: " + String.valueOf(mEncountersList.size()));

                        mAdapter = new EncountersAdapter(EncountersActivity.this, mEncountersList, mImageLoader);
                        mListView.setAdapter(mAdapter);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("ResponseError", error.toString());
                    }
                }
        );

        queue.add(getRequest);


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Encounters Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }


    public static class EncountersAdapter extends BaseAdapter {

        private Context mContext;
        private ImageLoader mImageLoader;

        private ArrayList<Encounters> mEncountersList = null;

        private String TAG = this.getClass().getSimpleName();

        public EncountersAdapter(Context context, ArrayList<Encounters> list, ImageLoader imageLoader) {
            mContext = context;
            mEncountersList = list;
            mImageLoader = imageLoader;
        }

        @Override
        public int getCount() {
            return mEncountersList.size();
        }

        @Override
        public Object getItem(int i) {
            return mEncountersList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup viewGroup) {

            View view = null;

            if (convertView == null) {

                LayoutInflater inflater = (LayoutInflater) mContext
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                view = inflater.inflate(R.layout.encounters_item, null);
            } else
                view = convertView;

            NetworkImageView encounterImage = (NetworkImageView) view.findViewById(R.id.encounter_image);

            if (!mEncountersList.get(i).getMediaList().isEmpty()) {
                Log.d(TAG, mEncountersList.get(i).getMediaList().get(0).getUrl());

                //mImageLoader.get(mEncountersList.get(i).getMediaList().get(0).getUrl(),
                //        ImageLoader.getImageListener(encounterImage, android.R.drawable.stat_notify_error, android.R.drawable.stat_notify_error), 600, 600);
                encounterImage.setImageUrl(mEncountersList.get(i).getMediaList().get(0).getThumUrl(), mImageLoader);
            }

            return view;
        }
    }
}
