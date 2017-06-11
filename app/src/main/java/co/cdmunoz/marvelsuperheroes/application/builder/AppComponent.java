package co.cdmunoz.marvelsuperheroes.application.builder;

import android.content.Context;
import co.cdmunoz.marvelsuperheroes.api.HeroApi;
import co.cdmunoz.marvelsuperheroes.utils.rx.RxSchedulers;
import dagger.Component;

@AppScope @Component(modules = {
    NetworkModule.class, AppContextModule.class, RxModule.class, HeroesApiServiceModule.class
}) public interface AppComponent {

  Context getAppContext();

  RxSchedulers rxSchedulers();

  HeroApi apiService();

  // void inject(MainActivity activity);
  //Retrofit provideNetworkApi();
}
