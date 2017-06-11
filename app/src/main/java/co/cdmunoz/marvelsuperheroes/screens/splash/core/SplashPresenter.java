package co.cdmunoz.marvelsuperheroes.screens.splash.core;

import android.util.Log;
import co.cdmunoz.marvelsuperheroes.utils.UiUtils;
import co.cdmunoz.marvelsuperheroes.utils.rx.RxSchedulers;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public class SplashPresenter {

  private SplashModel model;
  private RxSchedulers rxSchedulers;
  private CompositeSubscription subscriptions;

  public SplashPresenter(SplashModel model, RxSchedulers schedulers,
      CompositeSubscription subscriptions) {
    this.model = model;
    this.rxSchedulers = schedulers;
    this.subscriptions = subscriptions;
  }

  public void onCreate() {
    subscriptions.add(getHeroesList());
  }

  public void onDestroy() {
    subscriptions.clear();
  }

  private Subscription getHeroesList() {

    return model.isNetworkAvailable().doOnNext(networkAvailable -> {
      if (!networkAvailable) {
        Log.d("no conn", "no connexion");
        // Show Snackbar can't use app
      }
    }).
        filter(isNetworkAvailable -> true).
        flatMap(isAvailable -> model.isNetworkAvailable()).
        subscribeOn(rxSchedulers.internet()).
        observeOn(rxSchedulers.androidThread()).subscribe(aBoolean -> {

      model.gotoHeroesListActivity();
    }, throwable -> {

      UiUtils.handleThrowable(throwable);
    });
  }
}
