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

public class Feature
{
    private Integer mId;
    private String mFeature;
    private String mBodyPart;
    private String mSide;
    private String mSeverity;
    private String mInjureType;

    public Integer getId() {
        return mId;
    }

    public String getFeature() {
        return mFeature;
    }

    public String getBodyPart() {
        return mBodyPart;
    }

    public String getSide() {
        return mSide;
    }

    public String getSeverity() {
        return mSeverity;
    }

    public String getInjureType() {
        return mInjureType;
    }

    public Feature(Integer id, String feature, String bodyPart, String side, String severity, String injureType) {
        this.mId = id;
        this.mFeature = feature;
        this.mBodyPart = bodyPart;
        this.mSide = side;
        this.mSeverity = severity;
        this.mInjureType = injureType;
    }
}