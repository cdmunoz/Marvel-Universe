package co.cdmunoz.marvelsuperheroes.screens.details.dagger;

import co.cdmunoz.marvelsuperheroes.api.HeroApi;
import co.cdmunoz.marvelsuperheroes.model.Character;
import co.cdmunoz.marvelsuperheroes.screens.details.HeroDetailsActivity;
import co.cdmunoz.marvelsuperheroes.screens.details.core.HeroDetailsModel;
import co.cdmunoz.marvelsuperheroes.screens.details.core.HeroDetailsPresenter;
import co.cdmunoz.marvelsuperheroes.screens.details.core.HeroDetailsView;
import dagger.Module;
import dagger.Provides;

@Module public class HeroDetailsModule {

  HeroDetailsActivity detailsContext;
  //Hero hero;
  HeroApi heroApi;
  Character character;

  /*public HeroDetailsModule(HeroDetailsActivity context, Hero aHero) {
    this.detailsContext = context;
    this.hero = aHero;
  }*/

  public HeroDetailsModule(HeroDetailsActivity context, Character character) {
    this.detailsContext = context;
    this.character = character;
  }

  /*@Provides HeroDetailsView provideView() {
    return new HeroDetailsView(detailsContext, hero);
  }*/
  @Provides HeroDetailsView provideView() {
    return new HeroDetailsView(detailsContext, character);
  }

  @Provides HeroDetailsModel provideModel(HeroApi heroApi) {
    return new HeroDetailsModel(detailsContext, heroApi);
  }

  @Provides HeroDetailsPresenter providePresenter(HeroDetailsView view, HeroDetailsModel model) {
    return new HeroDetailsPresenter(view, model);
  }

  @Provides HeroDetailsActivity provideContext() {
    return detailsContext;
  }

  @Provides HeroApi provideHeroApi() {
    return heroApi;
  }
}
