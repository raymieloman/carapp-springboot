package com.ilionx.carapp.retrofit;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface GitHubService {
    @GET("{posts}")
    Call<List<Post>> listAllPosts(@Path("posts") String posts);

    @GET("users/{userId}/posts")
    Call<List<Post>> listPostsForUserId(@Path("userId") String userId);
}