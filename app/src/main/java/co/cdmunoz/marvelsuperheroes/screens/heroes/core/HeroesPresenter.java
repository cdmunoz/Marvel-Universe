package co.cdmunoz.marvelsuperheroes.screens.heroes.core;

import android.util.Log;
import co.cdmunoz.marvelsuperheroes.model.Character;
import co.cdmunoz.marvelsuperheroes.model.Characters;
import co.cdmunoz.marvelsuperheroes.model.Hero;
import co.cdmunoz.marvelsuperheroes.utils.UiUtils;
import co.cdmunoz.marvelsuperheroes.utils.rx.RxSchedulers;
import java.util.ArrayList;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public class HeroesPresenter {

  HeroesView view;
  HeroesModel model;
  RxSchedulers rxSchedulers;
  CompositeSubscription subscriptions;
  ArrayList<Hero> heros = new ArrayList<>();
  ArrayList<Character> listCharacters = new ArrayList<>();

  public HeroesPresenter(RxSchedulers schedulers, HeroesModel model, HeroesView view,
      CompositeSubscription sub) {
    this.rxSchedulers = schedulers;
    this.view = view;
    this.model = model;
    this.subscriptions = sub;
  }

  public void onCreate() {
    Log.d("enter to presenter", "oki");
    //subscriptions.add(getHeroesList());
    //subscriptions.add(getCharactersList());
    subscriptions.add(getCharactersList());
    subscriptions.add(respondToClick());
  }

  public void onDestroy() {
    subscriptions.clear();
  }

  private Subscription respondToClick() {
    return view.itemClicks()
        .subscribe(integer -> model.gotoHeroDetailsActivity(integer));
  }

  private Subscription getHeroesList() {
    return model.isNetworkAvailable().doOnNext(networkAvailable -> {
      if (!networkAvailable) {
        Log.d("no conn", "no connexion");
        // UiUtils.showSnackbar();
        // Show Snackbar can't use app
      }
    }).
        filter(isNetworkAvailable -> true).
        flatMap(isAvailable -> model.provideListHeroes()).
        subscribeOn(rxSchedulers.internet()).
        observeOn(rxSchedulers.androidThread()).subscribe(heroes -> {
      //view.swapAdapter((ArrayList<Hero>) heroes.getElements());
      heros = (ArrayList<Hero>) heroes.getElements();
    }, UiUtils::handleThrowable);
  }

  private Subscription getCharactersList() {
    return model.isNetworkAvailable()
        .doOnNext(aBoolean -> {
          if (!aBoolean) {
            Log.d("no conn", "no connexion");
            // UiUtils.showSnackbar();
            // Show Snackbar can't use app
          }
        })
        .filter(aBoolean -> true)
        .flatMap(aBoolean -> model.provideListCharacters())
        .subscribeOn(rxSchedulers.io())
        .observeOn(rxSchedulers.androidThread())
        .subscribe(characterResponse -> {
          Characters characters = characterResponse.getData();
          listCharacters = (ArrayList<Character>) characters.getResults();
          view.swapAdapter(listCharacters);
        }, UiUtils::handleThrowable);
  }
}
