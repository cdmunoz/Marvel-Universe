package co.cdmunoz.marvelsuperheroes.screens.details;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import co.cdmunoz.marvelsuperheroes.model.Character;
import co.cdmunoz.marvelsuperheroes.screens.details.core.HeroDetailsPresenter;
import co.cdmunoz.marvelsuperheroes.screens.details.core.HeroDetailsView;
import co.cdmunoz.marvelsuperheroes.screens.details.dagger.DaggerHeroDetailsComponent;
import co.cdmunoz.marvelsuperheroes.screens.details.dagger.HeroDetailsModule;
import javax.inject.Inject;

public class HeroDetailsActivity extends AppCompatActivity {

  @Inject HeroDetailsView view;
  @Inject HeroDetailsPresenter presenter;

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    //Hero hero = (Hero) getIntent().getExtras().get("hero");
    int characterId = (int) getIntent().getExtras().get("character");

    DaggerHeroDetailsComponent.builder()
        .heroDetailsModule(new HeroDetailsModule(this, new Character()))
        .build()
        .inject(this);
    presenter.onCreate(String.valueOf(characterId));

    setContentView(view.view());
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    presenter.onDestroy();
  }
}
