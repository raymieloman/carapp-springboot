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
                .baseUrl("https://api.github.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        GitHubService service = retrofit.create(GitHubService.class);
        Call<List<Repo>> repos = service.listRepos("octocat");

        Response<List<Repo>> listResponse = repos.execute();
        if (listResponse.isSuccessful()) {
            for (Repo repo : listResponse.body()) {
                System.out.println(repo.getName());

            }
        }

    }
}
