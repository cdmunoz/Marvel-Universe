package co.cdmunoz.marvelsuperheroes.application.builder;

import co.cdmunoz.marvelsuperheroes.api.HeroApi;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module public class HeroesApiServiceModule {

  //private static final String BASE_URL = "http://coemygroup.fr/";
  private static final String BASE_URL = "http://gateway.marvel.com/v1/public/";

  @AppScope @Provides HeroApi provideApiService(OkHttpClient client, GsonConverterFactory gson,
      RxJavaCallAdapterFactory rxAdapter) {
    Retrofit retrofit =
        new Retrofit.Builder().client(client).baseUrl(BASE_URL).addConverterFactory(gson).
            addCallAdapterFactory(rxAdapter).build();

    return retrofit.create(HeroApi.class);
  }
}
