package co.cdmunoz.marvelsuperheroes.screens.splash.dagger;

import co.cdmunoz.marvelsuperheroes.application.builder.AppComponent;
import co.cdmunoz.marvelsuperheroes.screens.splash.SplashScreenActivity;
import dagger.Component;

@SplashScope
@Component(modules = { SplashContextModule.class, SplashModule.class }, dependencies = {
    AppComponent.class
}) public interface SplashComponent {

  void inject(SplashScreenActivity activity);
}
