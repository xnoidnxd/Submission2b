package com.example.submission2.Response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FollowersResponse implements Parcelable {

    @SerializedName("login")
    @Expose
    private String login;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("node_id")
    @Expose
    private String nodeId;
    @SerializedName("avatar_url")
    @Expose
    private String avatarUrl;
    @SerializedName("gravatar_id")
    @Expose
    private String gravatarId;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("html_url")
    @Expose
    private String htmlUrl;
    @SerializedName("followers_url")
    @Expose
    private String followersUrl;
    @SerializedName("following_url")
    @Expose
    private String followingUrl;
    @SerializedName("gists_url")
    @Expose
    private String gistsUrl;
    @SerializedName("starred_url")
    @Expose
    private String starredUrl;
    @SerializedName("subscriptions_url")
    @Expose
    private String subscriptionsUrl;
    @SerializedName("organizations_url")
    @Expose
    private String organizationsUrl;
    @SerializedName("repos_url")
    @Expose
    private String reposUrl;
    @SerializedName("events_url")
    @Expose
    private String eventsUrl;
    @SerializedName("received_events_url")
    @Expose
    private String receivedEventsUrl;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("site_admin")
    @Expose
    private Boolean siteAdmin;

    protected FollowersResponse(Parcel in) {
        login = in.readString();
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        nodeId = in.readString();
        avatarUrl = in.readString();
        gravatarId = in.readString();
        url = in.readString();
        htmlUrl = in.readString();
        followersUrl = in.readString();
        followingUrl = in.readString();
        gistsUrl = in.readString();
        starredUrl = in.readString();
        subscriptionsUrl = in.readString();
        organizationsUrl = in.readString();
        reposUrl = in.readString();
        eventsUrl = in.readString();
        receivedEventsUrl = in.readString();
        type = in.readString();
        byte tmpSiteAdmin = in.readByte();
        siteAdmin = tmpSiteAdmin == 0 ? null : tmpSiteAdmin == 1;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(login);
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        dest.writeString(nodeId);
        dest.writeString(avatarUrl);
        dest.writeString(gravatarId);
        dest.writeString(url);
        dest.writeString(htmlUrl);
        dest.writeString(followersUrl);
        dest.writeString(followingUrl);
        dest.writeString(gistsUrl);
        dest.writeString(starredUrl);
        dest.writeString(subscriptionsUrl);
        dest.writeString(organizationsUrl);
        dest.writeString(reposUrl);
        dest.writeString(eventsUrl);
        dest.writeString(receivedEventsUrl);
        dest.writeString(type);
        dest.writeByte((byte) (siteAdmin == null ? 0 : siteAdmin ? 1 : 2));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<FollowersResponse> CREATOR = new Creator<FollowersResponse>() {
        @Override
        public FollowersResponse createFromParcel(Parcel in) {
            return new FollowersResponse(in);
        }

        @Override
        public FollowersResponse[] newArray(int size) {
            return new FollowersResponse[size];
        }
    };

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getGravatarId() {
        return gravatarId;
    }

    public void setGravatarId(String gravatarId) {
        this.gravatarId = gravatarId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public String getFollowersUrl() {
        return followersUrl;
    }

    public void setFollowersUrl(String followersUrl) {
        this.followersUrl = followersUrl;
    }

    public String getFollowingUrl() {
        return followingUrl;
    }

    public void setFollowingUrl(String followingUrl) {
        this.followingUrl = followingUrl;
    }

    public String getGistsUrl() {
        return gistsUrl;
    }

    public void setGistsUrl(String gistsUrl) {
        this.gistsUrl = gistsUrl;
    }

    public String getStarredUrl() {
        return starredUrl;
    }

    public void setStarredUrl(String starredUrl) {
        this.starredUrl = starredUrl;
    }

    public String getSubscriptionsUrl() {
        return subscriptionsUrl;
    }

    public void setSubscriptionsUrl(String subscriptionsUrl) {
        this.subscriptionsUrl = subscriptionsUrl;
    }

    public String getOrganizationsUrl() {
        return organizationsUrl;
    }

    public void setOrganizationsUrl(String organizationsUrl) {
        this.organizationsUrl = organizationsUrl;
    }

    public String getReposUrl() {
        return reposUrl;
    }

    public void setReposUrl(String reposUrl) {
        this.reposUrl = reposUrl;
    }

    public String getEventsUrl() {
        return eventsUrl;
    }

    public void setEventsUrl(String eventsUrl) {
        this.eventsUrl = eventsUrl;
    }

    public String getReceivedEventsUrl() {
        return receivedEventsUrl;
    }

    public void setReceivedEventsUrl(String receivedEventsUrl) {
        this.receivedEventsUrl = receivedEventsUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getSiteAdmin() {
        return siteAdmin;
    }

    public void setSiteAdmin(Boolean siteAdmin) {
        this.siteAdmin = siteAdmin;
    }

    @Override
    public String toString() {
        return "FollowersResponse{" +
                "login='" + login + '\'' +
                ", id=" + id +
                ", nodeId='" + nodeId + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", gravatarId='" + gravatarId + '\'' +
                ", url='" + url + '\'' +
                ", htmlUrl='" + htmlUrl + '\'' +
                ", followersUrl='" + followersUrl + '\'' +
                ", followingUrl='" + followingUrl + '\'' +
                ", gistsUrl='" + gistsUrl + '\'' +
                ", starredUrl='" + starredUrl + '\'' +
                ", subscriptionsUrl='" + subscriptionsUrl + '\'' +
                ", organizationsUrl='" + organizationsUrl + '\'' +
                ", reposUrl='" + reposUrl + '\'' +
                ", eventsUrl='" + eventsUrl + '\'' +
                ", receivedEventsUrl='" + receivedEventsUrl + '\'' +
                ", type='" + type + '\'' +
                ", siteAdmin=" + siteAdmin +
                '}';
    }
}
