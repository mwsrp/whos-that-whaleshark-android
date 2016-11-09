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

        this.mMediaList.clear();
        this.mFeatureList.clear();
    }

    public void addMedia (Media media)
    {
        this.mMediaList.add(media);
    }

    public void addFeature (Feature feature)
    {
        this.mFeatureList.add(feature);
    }


}