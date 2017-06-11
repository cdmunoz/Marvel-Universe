package co.cdmunoz.marvelsuperheroes.screens.heroes.dagger;

import co.cdmunoz.marvelsuperheroes.api.HeroApi;
import co.cdmunoz.marvelsuperheroes.screens.heroes.HeroesListActivity;
import co.cdmunoz.marvelsuperheroes.screens.heroes.core.HeroesModel;
import co.cdmunoz.marvelsuperheroes.screens.heroes.core.HeroesPresenter;
import co.cdmunoz.marvelsuperheroes.screens.heroes.core.HeroesView;
import co.cdmunoz.marvelsuperheroes.utils.rx.RxSchedulers;
import dagger.Module;
import dagger.Provides;
import rx.subscriptions.CompositeSubscription;

@Module public class HeroesModule {

  HeroesListActivity heroesListContext;

  public HeroesModule(HeroesListActivity context) {
    this.heroesListContext = context;
  }

  @HeroesScope @Provides HeroesView provideView() {
    return new HeroesView(heroesListContext);
  }

  @HeroesScope @Provides HeroesPresenter providePresenter(RxSchedulers schedulers, HeroesView view,
      HeroesModel model) {
    CompositeSubscription subscriptions = new CompositeSubscription();
    return new HeroesPresenter(schedulers, model, view, subscriptions);
  }

  @HeroesScope @Provides HeroesListActivity provideContext() {
    return heroesListContext;
  }

  @HeroesScope @Provides HeroesModel provideModel(HeroApi api) {
    return new HeroesModel(heroesListContext, api);
  }
}
