package com.example.submission2.Response;

import android.os.Parcel;
import android.os.Parcelable;


import com.google.gson.annotations.SerializedName;

public class User implements Parcelable {


    @SerializedName("location")
    private String location;

    protected User(Parcel in) {
        location = in.readString();
        name = in.readString();
        gistsUrl = in.readString();
        reposUrl = in.readString();
        followingUrl = in.readString();
        starredUrl = in.readString();
        login = in.readString();
        followersUrl = in.readString();
        type = in.readString();
        url = in.readString();
        subscriptionsUrl = in.readString();
        score = in.readDouble();
        receivedEventsUrl = in.readString();
        avatarUrl = in.readString();
        eventsUrl = in.readString();
        htmlUrl = in.readString();
        siteAdmin = in.readByte() != 0;
        id = in.readInt();
        gravatarId = in.readString();
        nodeId = in.readString();
        organizationsUrl = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(location);
        dest.writeString(name);
        dest.writeString(gistsUrl);
        dest.writeString(reposUrl);
        dest.writeString(followingUrl);
        dest.writeString(starredUrl);
        dest.writeString(login);
        dest.writeString(followersUrl);
        dest.writeString(type);
        dest.writeString(url);
        dest.writeString(subscriptionsUrl);
        dest.writeDouble(score);
        dest.writeString(receivedEventsUrl);
        dest.writeString(avatarUrl);
        dest.writeString(eventsUrl);
        dest.writeString(htmlUrl);
        dest.writeByte((byte) (siteAdmin ? 1 : 0));
        dest.writeInt(id);
        dest.writeString(gravatarId);
        dest.writeString(nodeId);
        dest.writeString(organizationsUrl);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public void setLocation(String location){
        this.location = location;
    }

    public String getLocation(){
        return location;
    }


    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }


    @SerializedName("name")
    private String name;

    @SerializedName("gists_url")
    private String gistsUrl;

    @SerializedName("repos_url")
    private String reposUrl;

    @SerializedName("following_url")
    private String followingUrl;

    @SerializedName("starred_url")
    private String starredUrl;

    @SerializedName("login")
    private String login;

    @SerializedName("followers_url")
    private String followersUrl;

    @SerializedName("type")
    private String type;

    @SerializedName("url")
    private String url;

    @SerializedName("subscriptions_url")
    private String subscriptionsUrl;

    @SerializedName("score")
    private double score;

    @SerializedName("received_events_url")
    private String receivedEventsUrl;

    @SerializedName("avatar_url")
    private String avatarUrl;

    @SerializedName("events_url")
    private String eventsUrl;

    @SerializedName("html_url")
    private String htmlUrl;

    @SerializedName("site_admin")
    private boolean siteAdmin;

    @SerializedName("id")
    private int id;

    @SerializedName("gravatar_id")
    private String gravatarId;

    @SerializedName("node_id")
    private String nodeId;

    @SerializedName("organizations_url")
    private String organizationsUrl;
    public  User(){

    }

    public void setGistsUrl(String gistsUrl){
        this.gistsUrl = gistsUrl;
    }

    public String getGistsUrl(){
        return gistsUrl;
    }

    public void setReposUrl(String reposUrl){
        this.reposUrl = reposUrl;
    }

    public String getReposUrl(){
        return reposUrl;
    }

    public void setFollowingUrl(String followingUrl){
        this.followingUrl = followingUrl;
    }

    public String getFollowingUrl(){
        return followingUrl;
    }

    public void setStarredUrl(String starredUrl){
        this.starredUrl = starredUrl;
    }

    public String getStarredUrl(){
        return starredUrl;
    }

    public void setLogin(String login){
        this.login = login;
    }

    public String getLogin(){
        return login;
    }

    public void setFollowersUrl(String followersUrl){
        this.followersUrl = followersUrl;
    }

    public String getFollowersUrl(){
        return followersUrl;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }

    public void setUrl(String url){
        this.url = url;
    }

    public String getUrl(){
        return url;
    }

    public void setSubscriptionsUrl(String subscriptionsUrl){
        this.subscriptionsUrl = subscriptionsUrl;
    }

    public String getSubscriptionsUrl(){
        return subscriptionsUrl;
    }

    public void setScore(double score){
        this.score = score;
    }

    public double getScore(){
        return score;
    }

    public void setReceivedEventsUrl(String receivedEventsUrl){
        this.receivedEventsUrl = receivedEventsUrl;
    }

    public String getReceivedEventsUrl(){
        return receivedEventsUrl;
    }

    public void setAvatarUrl(String avatarUrl){
        this.avatarUrl = avatarUrl;
    }

    public String getAvatarUrl(){
        return avatarUrl;
    }

    public void setEventsUrl(String eventsUrl){
        this.eventsUrl = eventsUrl;
    }

    public String getEventsUrl(){
        return eventsUrl;
    }

    public void setHtmlUrl(String htmlUrl){
        this.htmlUrl = htmlUrl;
    }

    public String getHtmlUrl(){
        return htmlUrl;
    }

    public void setSiteAdmin(boolean siteAdmin){
        this.siteAdmin = siteAdmin;
    }

    public boolean isSiteAdmin(){
        return siteAdmin;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setGravatarId(String gravatarId){
        this.gravatarId = gravatarId;
    }

    public String getGravatarId(){
        return gravatarId;
    }

    public void setNodeId(String nodeId){
        this.nodeId = nodeId;
    }

    public String getNodeId(){
        return nodeId;
    }

    public void setOrganizationsUrl(String organizationsUrl){
        this.organizationsUrl = organizationsUrl;
    }

    public String getOrganizationsUrl(){
        return organizationsUrl;
    }

    @Override
    public String toString(){
        return
                "ItemsItem{" +
                        "gists_url = '" + gistsUrl + '\'' +
                        ",repos_url = '" + reposUrl + '\'' +
                        ",following_url = '" + followingUrl + '\'' +
                        ",starred_url = '" + starredUrl + '\'' +
                        ",login = '" + login + '\'' +
                        ",followers_url = '" + followersUrl + '\'' +
                        ",type = '" + type + '\'' +
                        ",url = '" + url + '\'' +
                        ",subscriptions_url = '" + subscriptionsUrl + '\'' +
                        ",score = '" + score + '\'' +
                        ",received_events_url = '" + receivedEventsUrl + '\'' +
                        ",avatar_url = '" + avatarUrl + '\'' +
                        ",events_url = '" + eventsUrl + '\'' +
                        ",html_url = '" + htmlUrl + '\'' +
                        ",site_admin = '" + siteAdmin + '\'' +
                        ",id = '" + id + '\'' +
                        ",gravatar_id = '" + gravatarId + '\'' +
                        ",node_id = '" + nodeId + '\'' +
                        ",organizations_url = '" + organizationsUrl + '\'' +
                        "}";
    }

}
