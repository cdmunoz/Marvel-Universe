package co.cdmunoz.marvelsuperheroes.api;

import co.cdmunoz.marvelsuperheroes.model.CharacterResponse;
import co.cdmunoz.marvelsuperheroes.model.Heroes;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface HeroApi {

  @GET("test-mobile/iOS/json/test2.json") Observable<Heroes> getHeroes();

  @GET("characters") Observable<CharacterResponse> getMarvelCharacters(
      @Query(value = "ts") String timeStamp, @Query("apikey") String apikey,
      @Query("hash") String hash, @Query("comics") String comics, @Query("orderBy") String orderBy,
      @Query("limit") int limit, @Query("offset") int offset);

  @GET("characters/{id}") Observable<CharacterResponse> getMarvelCharacterDetail(
      @Path("id") String id, @Query(value = "ts") String timeStamp, @Query("apikey") String apikey,
      @Query("hash") String hash);
}
