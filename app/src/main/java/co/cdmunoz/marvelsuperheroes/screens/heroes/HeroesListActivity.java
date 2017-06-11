package co.cdmunoz.marvelsuperheroes.screens.heroes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import co.cdmunoz.marvelsuperheroes.application.AppController;
import co.cdmunoz.marvelsuperheroes.model.Character;
import co.cdmunoz.marvelsuperheroes.screens.details.HeroDetailsActivity;
import co.cdmunoz.marvelsuperheroes.screens.heroes.core.HeroesPresenter;
import co.cdmunoz.marvelsuperheroes.screens.heroes.core.HeroesView;
import co.cdmunoz.marvelsuperheroes.screens.heroes.dagger.DaggerHeroesComponent;
import co.cdmunoz.marvelsuperheroes.screens.heroes.dagger.HeroesModule;
import java.io.Serializable;
import javax.inject.Inject;

public class HeroesListActivity extends AppCompatActivity {

  @Inject HeroesView view;
  @Inject HeroesPresenter presenter;

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    DaggerHeroesComponent.builder()
        .appComponent(AppController.getNetComponent())
        .heroesModule(new HeroesModule(this))
        .build()
        .inject(this);
    setContentView(view.view());
    presenter.onCreate();
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    presenter.onDestroy();
  }

  /*public void goToHeroDetailsActivity(Hero hero) {
    Intent in = new Intent(this, HeroDetailsActivity.class);
    in.putExtra("hero", (Serializable) hero);
    startActivity(in);
  }*/

  public void goToHeroDetailsActivity(int character) {
    Intent in = new Intent(this, HeroDetailsActivity.class);
    in.putExtra("character", character);
    startActivity(in);
  }
}
