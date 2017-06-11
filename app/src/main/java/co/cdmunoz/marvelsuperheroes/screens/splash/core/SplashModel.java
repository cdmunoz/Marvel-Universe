package co.cdmunoz.marvelsuperheroes.screens.splash.core;

import co.cdmunoz.marvelsuperheroes.api.HeroApi;
import co.cdmunoz.marvelsuperheroes.model.Heroes;
import co.cdmunoz.marvelsuperheroes.screens.splash.SplashScreenActivity;
import co.cdmunoz.marvelsuperheroes.utils.NetworkUtils;
import rx.Observable;

public class SplashModel {

  HeroApi api;
  SplashScreenActivity splashContext;

  public SplashModel(HeroApi api, SplashScreenActivity splashCtx) {
    this.api = api;
    this.splashContext = splashCtx;
  }

  Observable<Heroes> provideListHeroes() {
    return api.getHeroes();
  }

  Observable<Boolean> isNetworkAvailable() {
    return NetworkUtils.isNetworkAvailableObservable(splashContext);
  }

  public void gotoHeroesListActivity() {
    splashContext.showHeroesListActivity();
  }
}
