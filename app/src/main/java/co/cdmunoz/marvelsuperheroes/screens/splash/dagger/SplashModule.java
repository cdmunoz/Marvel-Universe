package co.cdmunoz.marvelsuperheroes.screens.splash.dagger;

import co.cdmunoz.marvelsuperheroes.api.HeroApi;
import co.cdmunoz.marvelsuperheroes.screens.splash.SplashScreenActivity;
import co.cdmunoz.marvelsuperheroes.screens.splash.core.SplashModel;
import co.cdmunoz.marvelsuperheroes.screens.splash.core.SplashPresenter;
import co.cdmunoz.marvelsuperheroes.screens.splash.core.SplashView;
import co.cdmunoz.marvelsuperheroes.utils.rx.RxSchedulers;
import dagger.Module;
import dagger.Provides;
import rx.subscriptions.CompositeSubscription;

@Module public class SplashModule {

  @SplashScope @Provides SplashPresenter providePresenter(RxSchedulers schedulers,
      SplashModel model) {
    CompositeSubscription compositeSubscription = new CompositeSubscription();
    return new SplashPresenter(model, schedulers, compositeSubscription);
  }

  @SplashScope @Provides SplashView provideSplashView(SplashScreenActivity context) {
    return new SplashView(context);
  }

  @SplashScope @Provides SplashModel provideSplashModel(HeroApi api, SplashScreenActivity ctx) {
    return new SplashModel(api, ctx);
  }
}

