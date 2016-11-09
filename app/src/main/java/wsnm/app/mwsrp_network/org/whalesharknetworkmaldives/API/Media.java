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

public class Media {

    public Media(Integer id, String type, String thumUrl, String url, String credit) {
        this.mId = id;
        this.mType = type;
        this.mThumUrl = thumUrl;
        this.mUrl = url;
        this.mCredit = credit;
    }

    private Integer mId;
    private String mType;
    private String mThumUrl;
    private String mUrl;
    private String mCredit;

    public Integer getId() {
        return mId;
    }

    public String getType() {
        return mType;
    }

    public String getThumUrl() {
        return mThumUrl;
    }

    public String getUrl() {
        return mUrl;
    }

    public String getCredit() {
        return mCredit;
    }
}