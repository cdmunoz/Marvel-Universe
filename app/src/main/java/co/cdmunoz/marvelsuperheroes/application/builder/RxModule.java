package co.cdmunoz.marvelsuperheroes.application.builder;

import co.cdmunoz.marvelsuperheroes.utils.rx.AppRxSchedulers;
import co.cdmunoz.marvelsuperheroes.utils.rx.RxSchedulers;
import dagger.Module;
import dagger.Provides;

@Module public class RxModule {

  @Provides RxSchedulers provideRxSchedulers() {
    return new AppRxSchedulers();
  }
}
