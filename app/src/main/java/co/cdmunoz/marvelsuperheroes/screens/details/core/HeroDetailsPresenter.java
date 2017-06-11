package co.cdmunoz.marvelsuperheroes.screens.details.core;

import co.cdmunoz.marvelsuperheroes.model.Character;
import co.cdmunoz.marvelsuperheroes.model.Characters;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class HeroDetailsPresenter {

  HeroDetailsView view;
  HeroDetailsModel model;
  Character character;

  public HeroDetailsPresenter(HeroDetailsView view, HeroDetailsModel model) {
    this.view = view;
    this.model = model;
  }

  public void onCreate(String characterId) {
    getCharacterDetail(characterId);
  }

  public void onDestroy() {
    view = null;
  }

  private Subscription getCharacterDetail(String characterId) {
    return model.isNetworkAvailable()
        .filter(isAvailable -> true)
        .flatMap(isAvailable -> model.provideCharacterDetail(characterId))
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread()).subscribe(characterResponse -> {
          Characters characters = characterResponse.getData();
          character = characters.getResults().get(0);
          //view.setCharacter(characters.getResults().get(0));
        });
  }

  public Character getCharacter() {
    return character;
  }
}
