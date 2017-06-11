package co.cdmunoz.marvelsuperheroes.screens.heroes.core;

import co.cdmunoz.marvelsuperheroes.api.HeroApi;
import co.cdmunoz.marvelsuperheroes.model.Character;
import co.cdmunoz.marvelsuperheroes.model.CharacterResponse;
import co.cdmunoz.marvelsuperheroes.model.Characters;
import co.cdmunoz.marvelsuperheroes.model.Hero;
import co.cdmunoz.marvelsuperheroes.model.Heroes;
import co.cdmunoz.marvelsuperheroes.screens.heroes.HeroesListActivity;
import co.cdmunoz.marvelsuperheroes.utils.NetworkUtils;
import rx.Observable;

public class HeroesModel {

  HeroesListActivity context;
  HeroApi api;

  public HeroesModel(HeroesListActivity context, HeroApi api) {
    this.api = api;
    this.context = context;
  }

  Observable<Heroes> provideListHeroes() {
    return api.getHeroes();
  }

  Observable<Boolean> isNetworkAvailable() {
    return NetworkUtils.isNetworkAvailableObservable(context);
  }

  /*public void gotoHeroDetailsActivity(Hero hero) {
    context.goToHeroDetailsActivity(hero);
  }*/

  public void gotoHeroDetailsActivity(int character) {
    context.goToHeroDetailsActivity(character);
  }

  Observable<CharacterResponse> provideListCharacters() {
    return api.getMarvelCharacters("1491605703437", "MARVEL_API_KEY",
        "HASH", "17486", "name", 20, 0);
  }
}
