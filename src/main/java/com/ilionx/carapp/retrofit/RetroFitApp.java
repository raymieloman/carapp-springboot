package com.ilionx.carapp.retrofit;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.List;

public class RetroFitApp {

    public static void main(String[] args) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        GitHubService service = retrofit.create(GitHubService.class);
        Call<List<Post>> posts = service.listAllPosts("posts");

        Response<List<Post>> listResponse = posts.execute();
        if (listResponse.isSuccessful()) {
            for (Post post : listResponse.body()) {
                System.out.println(post.getTitle());
            }
        }

        System.err.println("Below for user id: 1");
        Call<List<Post>> listPostsForUserId = service.listPostsForUserId("1");
        listResponse = listPostsForUserId.execute();
        if (listResponse.isSuccessful()) {
            for (Post post : listResponse.body()) {
                System.out.println(post.getTitle());
            }
        }
    }
}
