package ru.payts.youpics.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UsrProfile {
    @Expose
    @SerializedName("login")
    public String login; // example : "JakeWharton",
    @Expose
    @SerializedName("id")
    public String id; // example : 66577,
    @Expose
    @SerializedName("node_id")
    public String node_id; // example : "MDQ6VXNlcjY2NTc3",
    @Expose
    @SerializedName("avatar_url")
    public String avatar_url; // example : "https://avatars0.githubusercontent.com/u/66577?v=4",
    @Expose
    @SerializedName("gravatar_id")
    public String gravatar_id; // example : "",
    @Expose
    @SerializedName("url")
    public String url; // example : "https://api.github.com/users/JakeWharton",
    @Expose
    @SerializedName("html_url")
    public String html_url; // example : "https://github.com/JakeWharton",
    @Expose
    @SerializedName("followers_url")
    public String followers_url; // example : "https://api.github.com/users/JakeWharton/followers",
    @Expose
    @SerializedName("following_url")
    public String following_url; // example : "https://api.github.com/users/JakeWharton/following{/other_user}",
    @Expose
    @SerializedName("gists_url")
    public String gists_url; // example : "https://api.github.com/users/JakeWharton/gists{/gist_id}",
    @Expose
    @SerializedName("starred_url")
    public String starred_url; // example : "https://api.github.com/users/JakeWharton/starred{/owner}{/repo}",
    @Expose
    @SerializedName("subscriptions_url")
    public String subscriptions_url; // example : "https://api.github.com/users/JakeWharton/subscriptions",
    @Expose
    @SerializedName("organizations_url")
    public String organizations_url; // example : "https://api.github.com/users/JakeWharton/orgs",
    @Expose
    @SerializedName("repos_url")
    public String repos_url; // example : "https://api.github.com/users/JakeWharton/repos",
    @Expose
    @SerializedName("events_url")
    public String events_url; // example : "https://api.github.com/users/JakeWharton/events{/privacy}",
    @Expose
    @SerializedName("received_events_url")
    public String received_events_url; // example : "https://api.github.com/users/JakeWharton/received_events",
    @Expose
    @SerializedName("type")
    public String type; // example : "User",
    @Expose
    @SerializedName("site_admin")
    public String site_admin; // example : false,
    @Expose
    @SerializedName("name")
    public String name; // example : "Jake Wharton",
    @Expose
    @SerializedName("company")
    public String company; // example : "Google, Inc.",
    @Expose
    @SerializedName("blog")
    public String blog; // example : "http://jakewharton.com",
    @Expose
    @SerializedName("location")
    public String location; // example : "Pittsburgh, PA, USA",
    @Expose
    @SerializedName("email")
    public String email; // example : null,
    @Expose
    @SerializedName("hireable")
    public String hireable; // example : null,
    @Expose
    @SerializedName("bio")
    public String bio; // example : null,
    @Expose
    @SerializedName("public_repos")
    public String public_repos; // example : 109,
    @Expose
    @SerializedName("public_gists")
    public String public_gists; // example : 54,
    @Expose
    @SerializedName("followers")
    public String followers; // example : 56823,
    @Expose
    @SerializedName("following")
    public String following; // example : 12,
    @Expose
    @SerializedName("created_at")
    public String created_at; // example : "2009-03-24T16:09:53Z",
    @Expose
    @SerializedName("updated_at")
    public String updated_at; // example : "2020-03-10T15:08:35Z"
}
