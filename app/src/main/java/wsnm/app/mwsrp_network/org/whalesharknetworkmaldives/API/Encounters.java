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

import java.util.ArrayList;

public class Encounters
{
    // JSON KEYS
    public static String ENCOUNTERS_KEY_ID                  = "id";
    public static String ENCOUNTERS_KEY_TIME                = "encounter_time";
    public static String ENCOUNTERS_KEY_NORTHING            = "northing";
    public static String ENCOUNTERS_KEY_EASTING             = "easting";
    public static String ENCOUNTERS_KEY_NORTHING_APROX      = "northing_approx";
    public static String ENCOUNTERS_KEY_EASTING_APROX       = "easting_approx";
    public static String ENCOUNTERS_KEY_SHARK_ID            = "shark_id";
    public static String ENCOUNTERS_KEY_LENGTH_EST          = "length_est";
    public static String ENCOUNTERS_KEY_LENGTH_TAPE         = "length_tape";
    public static String ENCOUNTERS_KEY_LENGTH_LZR          = "length_lzr";
    public static String ENCOUNTERS_KEY_SHARK_HEADING       = "shark_heading";
    public static String ENCOUNTERS_KEY_BEHAVIOUR           = "behaviour";
    public static String ENCOUNTERS_KEY_TRIP_DATE           = "trip_date";
    public static String ENCOUNTERS_KEY_USER_ID             = "user_id";
    public static String ENCOUNTERS_KEY_CONTRIBUTOR         = "contributor";
    public static String ENCOUNTERS_KEY_SHARK_NAME          = "shark_name";
    public static String ENCOUNTERS_KEY_LOCATION_NAME       = "location_name";
    public static String ENCOUNTERS_KEY_CONTRIBUTOR_IMAGE   = "contributor_image";
    public static String ENCOUNTERS_KEY_LOCATION_TITLE      = "location_tile";
    public static String ENCOUNTERS_KEY_MEDIA               = "media";
    public static String ENCOUNTERS_KEY_FEATURES            = "distinguishing_features";



    // Private fields
    private Integer mId;
    private String mTime;
    private String mNorthing;
    private String mEasting;
    private Double mNorthingApprox;
    private Double mEastingApprox;
    private String mSharkId;
    private String mBehaviour;
    private String mTripDate;
    private Integer mUserId;
    private String mContributor;
    private String mSharkName;
    private String mLocationName;
    private String mContributorImage;
    private String mLocationTile;



    private ArrayList<Media> mMediaList;
    private ArrayList<Feature> mFeatureList;

    public Encounters(Integer id, String time, String northing, String easting,
                      Double northingApprox, Double eastingApprox, String sharkId,
                      String behaviour, String tripDate, Integer userId, String contributor,
                      String sharkName, String locationName, String contributorImage,
                      String locationTile) {
        this.mId = id;
        this.mTime = time;
        this.mNorthing = northing;
        this.mEasting = easting;
        this.mNorthingApprox = northingApprox;
        this.mEastingApprox = eastingApprox;
        this.mSharkId = sharkId;
        this.mBehaviour = behaviour;
        this.mTripDate = tripDate;
        this.mUserId = userId;
        this.mContributor = contributor;
        this.mSharkName = sharkName;
        this.mLocationName = locationName;
        this.mContributorImage = contributorImage;
        this.mLocationTile = locationTile;

        this.mMediaList = new ArrayList<Media>();
        this.mFeatureList = new ArrayList<Feature>();

    }

    public void addMedia (ArrayList<Media> media)
    {
        this.mMediaList = new ArrayList<Media>(media);
    }

    public void addFeature (Feature feature)
    {
        this.mFeatureList.add(feature);
    }


    public Integer getId() {
        return mId;
    }

    public String getTime() {
        return mTime;
    }

    public String getNorthing() {
        return mNorthing;
    }

    public String getEasting() {
        return mEasting;
    }

    public Double getNorthingApprox() {
        return mNorthingApprox;
    }

    public Double getEastingApprox() {
        return mEastingApprox;
    }

    public String getSharkId() {
        return mSharkId;
    }

    public String getBehaviour() {
        return mBehaviour;
    }

    public String getTripDate() {
        return mTripDate;
    }

    public Integer getUserId() {
        return mUserId;
    }

    public String getContributor() {
        return mContributor;
    }

    public String getSharkName() {
        return mSharkName;
    }

    public String getLocationName() {
        return mLocationName;
    }

    public String getContributorImage() {
        return mContributorImage;
    }

    public String getLocationTile() {
        return mLocationTile;
    }

    public ArrayList<Media> getMediaList() {
        return mMediaList;
    }

    public ArrayList<Feature> getFeatureList() {
        return mFeatureList;
    }
}