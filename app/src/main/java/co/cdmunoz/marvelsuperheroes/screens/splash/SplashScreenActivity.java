package co.cdmunoz.marvelsuperheroes.screens.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import co.cdmunoz.marvelsuperheroes.application.AppController;
import co.cdmunoz.marvelsuperheroes.screens.heroes.HeroesListActivity;
import co.cdmunoz.marvelsuperheroes.screens.splash.core.SplashPresenter;
import co.cdmunoz.marvelsuperheroes.screens.splash.core.SplashView;
import co.cdmunoz.marvelsuperheroes.screens.splash.dagger.DaggerSplashComponent;
import co.cdmunoz.marvelsuperheroes.screens.splash.dagger.SplashContextModule;
import javax.inject.Inject;

public class SplashScreenActivity extends AppCompatActivity {

  @Inject SplashView view;
  @Inject SplashPresenter splashPresenter;

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    DaggerSplashComponent.builder().
        appComponent(AppController.getNetComponent()).
        splashContextModule(new SplashContextModule(this)).
        build().inject(this);

    setContentView(view.constructView());
    splashPresenter.onCreate();
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    splashPresenter.onDestroy();
  }

  public void showHeroesListActivity() {
    Log.d("loaded", "ok showed");
    Intent i = new Intent(this, HeroesListActivity.class);
    startActivity(i);
  }
}
