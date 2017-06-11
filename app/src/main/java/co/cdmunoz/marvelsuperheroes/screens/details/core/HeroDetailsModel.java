package co.cdmunoz.marvelsuperheroes.screens.details.core;

import co.cdmunoz.marvelsuperheroes.api.HeroApi;
import co.cdmunoz.marvelsuperheroes.model.Character;
import co.cdmunoz.marvelsuperheroes.model.CharacterResponse;
import co.cdmunoz.marvelsuperheroes.screens.details.HeroDetailsActivity;
import co.cdmunoz.marvelsuperheroes.utils.NetworkUtils;
import rx.Observable;

public class HeroDetailsModel {

  HeroDetailsActivity context;
  HeroApi api;

  public HeroDetailsModel(HeroDetailsActivity context, HeroApi api) {
    this.api = api;
    this.context = context;
  }

  Observable<CharacterResponse> provideCharacterDetail(String characterId) {
    return api.getMarvelCharacterDetail(characterId, "1491605703437", "MARVEL_API_KEY",
        "HASH");
  }

  Observable<Boolean> isNetworkAvailable() {
    return NetworkUtils.isNetworkAvailableObservable(context);
  }
}
