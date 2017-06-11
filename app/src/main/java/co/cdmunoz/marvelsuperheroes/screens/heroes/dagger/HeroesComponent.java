package co.cdmunoz.marvelsuperheroes.screens.heroes.dagger;

import co.cdmunoz.marvelsuperheroes.application.builder.AppComponent;
import co.cdmunoz.marvelsuperheroes.screens.heroes.HeroesListActivity;
import dagger.Component;

@HeroesScope @Component(dependencies = { AppComponent.class }, modules = { HeroesModule.class })
public interface HeroesComponent {

  void inject(HeroesListActivity heroesActivity);
}
