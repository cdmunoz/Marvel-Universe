package co.cdmunoz.marvelsuperheroes.screens.details.core;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import co.cdmunoz.marvelsuperheroes.R;
import co.cdmunoz.marvelsuperheroes.model.Character;
import co.cdmunoz.marvelsuperheroes.screens.details.HeroDetailsActivity;
import com.bumptech.glide.Glide;

public class HeroDetailsView {

  @BindView(R.id.hero_details_activity_image) ImageView imageHero;
  @BindView(R.id.hero_details_activity_intro) TextView introduction;
  @BindView(R.id.hero_details_activity_text) TextView text;

  View view;
  Character character;

  public HeroDetailsView(HeroDetailsActivity activity, Character character) {
    FrameLayout layout = new FrameLayout(activity);
    layout.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.MATCH_PARENT));

    view = LayoutInflater.from(activity).inflate(R.layout.activity_hero_details, layout, true);
    ButterKnife.bind(this, view);

    Glide.with(activity)
        .load(character.getThumbnail().getPath() + "." + character.getThumbnail().getExtension())
        .into(imageHero);
    introduction.setText(TextUtils.isEmpty(character.getName()) ? "no intro" : character.getName());
    text.setText(TextUtils.isEmpty(character.getDescription()) ? "no text" : character.getDescription());
  }

  public View view() {
    return view;
  }

  public void setCharacter(Character character) {
    this.character = character;
  }
}
