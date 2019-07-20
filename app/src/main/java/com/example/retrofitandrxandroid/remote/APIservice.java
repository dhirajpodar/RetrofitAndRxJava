package com.example.retrofitandrxandroid.remote;

        import com.example.retrofitandrxandroid.model.Hero;

        import java.util.List;

        import io.reactivex.Observable;
        import retrofit2.http.GET;

public interface APIservice {

    @GET("marvel/")
    Observable<List<Hero>> getHerolist();
}
