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

package wsnm.app.mwsrp_network.org.whalesharknetworkmaldives.API;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Api
{
    public static String MWSRP_URL = "https://mwsrp-network.org/";
    public static String MWSRP_ENCOUNTERS_URL = MWSRP_URL + "encounters?req_hash=c940e540de630e5f7ff14ded10aba37082323e7ac5104ea5eb08e96d40967541c6bc708093daf9434343352a4b4d8063bf219e323ff38bdce9f0296a87c6e160";
    public static String MWSRP_ENCOUNTERS_URL_2 = MWSRP_URL + "encounters?";
    public static String MWSRP_ENCOUNTERS_PERIOD_URL = MWSRP_URL + "encounters?date_from=2016-10-01&date_to=2016-12-31";

    private String TAG = "API";

    public Api()
    {

    }

    public ArrayList<Encounters> getEncounters (JSONArray jsonArray)
    {

        ArrayList<Encounters> lencounters = new ArrayList<Encounters>();
        ArrayList<Media> lmedia = new ArrayList<Media>();

        Integer id = 0;
        String time="", northing="", easting="";
        Double northingApprox=0.0, eastingApprox=0.0;
        String sharkId="", behaviour="", tripDate="";
        Integer userId=0;
        String contributor="", sharkName="", locationName="", contributorImage="", locationTile="";

        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                JSONObject jObject = jsonArray.getJSONObject(i);
                if (jObject.has(Encounters.ENCOUNTERS_KEY_ID))
                    id = jObject.getInt(Encounters.ENCOUNTERS_KEY_ID);
                if (jObject.has(Encounters.ENCOUNTERS_KEY_TIME))
                    time = jObject.getString(Encounters.ENCOUNTERS_KEY_TIME);
                if (jObject.has(Encounters.ENCOUNTERS_KEY_NORTHING))
                    northing = jObject.getString(Encounters.ENCOUNTERS_KEY_NORTHING);
                if (jObject.has(Encounters.ENCOUNTERS_KEY_EASTING))
                    easting = jObject.getString(Encounters.ENCOUNTERS_KEY_EASTING);
                if (jObject.has(Encounters.ENCOUNTERS_KEY_NORTHING_APROX)) {
                    try {
                        northingApprox = Double.parseDouble(jObject.getString(Encounters.ENCOUNTERS_KEY_NORTHING_APROX));
                    }
                    catch (NumberFormatException e) {
                        northingApprox = 0.0;
                    }
                }
                if (jObject.has(Encounters.ENCOUNTERS_KEY_EASTING_APROX)){
                    try {
                        eastingApprox = Double.parseDouble(jObject.getString(Encounters.ENCOUNTERS_KEY_EASTING_APROX));
                    }
                    catch (NumberFormatException e) {
                        eastingApprox = 0.0;
                    }
                }
                if (jObject.has(Encounters.ENCOUNTERS_KEY_SHARK_ID))
                    sharkId = jObject.getString(Encounters.ENCOUNTERS_KEY_SHARK_ID);
                if (jObject.has(Encounters.ENCOUNTERS_KEY_BEHAVIOUR))
                    behaviour = jObject.getString(Encounters.ENCOUNTERS_KEY_BEHAVIOUR);
                if (jObject.has(Encounters.ENCOUNTERS_KEY_TRIP_DATE))
                    tripDate = jObject.getString(Encounters.ENCOUNTERS_KEY_TRIP_DATE);
                if (jObject.has(Encounters.ENCOUNTERS_KEY_USER_ID))
                    userId = jObject.getInt(Encounters.ENCOUNTERS_KEY_USER_ID);
                if (jObject.has(Encounters.ENCOUNTERS_KEY_CONTRIBUTOR))
                    contributor = jObject.getString(Encounters.ENCOUNTERS_KEY_CONTRIBUTOR);
                if (jObject.has(Encounters.ENCOUNTERS_KEY_SHARK_NAME))
                    sharkName = jObject.getString(Encounters.ENCOUNTERS_KEY_SHARK_NAME);
                if (jObject.has(Encounters.ENCOUNTERS_KEY_LOCATION_NAME))
                    locationName = jObject.getString(Encounters.ENCOUNTERS_KEY_LOCATION_NAME);
                if (jObject.has(Encounters.ENCOUNTERS_KEY_CONTRIBUTOR_IMAGE))
                    contributorImage = jObject.getString(Encounters.ENCOUNTERS_KEY_CONTRIBUTOR_IMAGE);
                if (jObject.has(Encounters.ENCOUNTERS_KEY_LOCATION_TITLE))
                    locationTile = jObject.getString(Encounters.ENCOUNTERS_KEY_LOCATION_TITLE);

                if (jObject.has(Encounters.ENCOUNTERS_KEY_MEDIA)) {
                    lmedia = getMedia(jObject.getJSONArray(Encounters.ENCOUNTERS_KEY_MEDIA));
                }
                /*
                if (jObject.has(Encounters.ENCOUNTERS_KEY_FEATURES))
                    sharkName = jObject.getString(Encounters.ENCOUNTERS_KEY_FEATURES);
                */

                Encounters encounter = new Encounters(id, time, northing,easting,northingApprox,eastingApprox,sharkId,behaviour,tripDate,userId,contributor,sharkName,locationName,contributorImage,locationTile);
                encounter.addMedia(lmedia);
                lencounters.add (encounter);


            }
            catch (JSONException e)
            {
                Log.e(TAG, "Item not added - " + e.getMessage());
            }
        }

        return lencounters;

    }

    public ArrayList<Media> getMedia (JSONArray jsonArray)
    {
        Integer id=0;
        String type="", thumUrl="", url="", credit="";

        ArrayList<Media> lmedia = new ArrayList<Media>();

        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                JSONObject jObject = jsonArray.getJSONObject(i);
                if (jObject.has(Media.MEDIA_KEY_ID))
                    id = jObject.getInt(Media.MEDIA_KEY_ID);
                if (jObject.has(Media.MEDIA_KEY_TYPE))
                    type = jObject.getString(Media.MEDIA_KEY_TYPE);
                if (jObject.has(Media.MEDIA_KEY_THUMB_URL))
                    thumUrl = jObject.getString(Media.MEDIA_KEY_THUMB_URL);
                if (jObject.has(Media.MEDIA_KEY_URL))
                    url = jObject.getString(Media.MEDIA_KEY_URL);
                if (jObject.has(Media.MEDIA_KEY_CREDIT))
                    credit = jObject.getString(Media.MEDIA_KEY_CREDIT);

                lmedia.add( new Media(id,type,thumUrl,url,credit));
            }
            catch (JSONException e)
            {
                Log.e(TAG, e.getMessage());
            }
        }

        return lmedia;


    }



}