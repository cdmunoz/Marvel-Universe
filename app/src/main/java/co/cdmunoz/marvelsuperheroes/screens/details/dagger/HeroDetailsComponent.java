package co.cdmunoz.marvelsuperheroes.screens.details.dagger;

import co.cdmunoz.marvelsuperheroes.screens.details.HeroDetailsActivity;
import co.cdmunoz.marvelsuperheroes.screens.details.core.HeroDetailsModel;
import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = { HeroDetailsModule.class }) public interface HeroDetailsComponent {
  void inject(HeroDetailsActivity context);
  void inject(HeroDetailsModel model);
}
