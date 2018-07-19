package com.retroex.retroexample;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class MyApi {
    public static final String key = "1aed007425064b03b0775b67c7186589";
    public static  final String url = "https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=1aed007425064b03b0775b67c7186589/";
    public static PostService postService = null;
    public static PostService getService(){
        if ((postService == null)){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            postService = retrofit.create(PostService.class);
        }
        return postService;
    }
    public  interface PostService{
        @GET("?key=" + key)
        Call<PostList> getPostList();
    }
}
