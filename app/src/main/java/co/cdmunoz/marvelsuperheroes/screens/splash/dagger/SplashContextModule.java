package co.cdmunoz.marvelsuperheroes.screens.splash.dagger;

import co.cdmunoz.marvelsuperheroes.screens.splash.SplashScreenActivity;
import dagger.Module;
import dagger.Provides;

@Module public class SplashContextModule {

  SplashScreenActivity splashContext;

  public SplashContextModule(SplashScreenActivity context) {
    this.splashContext = context;
  }

  @SplashScope @Provides SplashScreenActivity provideSplashContext() {
    return splashContext;
  }
}
