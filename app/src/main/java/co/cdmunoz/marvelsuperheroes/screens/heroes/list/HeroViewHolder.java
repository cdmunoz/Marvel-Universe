package co.cdmunoz.marvelsuperheroes.screens.heroes.list;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import co.cdmunoz.marvelsuperheroes.R;
import co.cdmunoz.marvelsuperheroes.model.Character;
import com.bumptech.glide.Glide;
import rx.subjects.PublishSubject;

public class HeroViewHolder extends ViewHolder {

  View view;

  @BindView(R.id.item_hero_image) ImageView imageHero;
  @BindView(R.id.item_hero_name) TextView nameHero;
  @BindView(R.id.item_hero_year) TextView dateReleaseHero;
  @BindView(R.id.item_hero_separator) View separatorHero;
  @BindView(R.id.item_hero_text) TextView descriptionHero;

  public HeroViewHolder(View itemView, PublishSubject<Integer> clickSubject) {
    super(itemView);
    this.view = itemView;
    ButterKnife.bind(this, view);
    //view.setOnClickListener(v -> clickSubject.onNext(getAdapterPosition()));
  }

  /*void bind(Hero hero) {
    Glide.with(view.getContext()).load(hero.getImage()).into(imageHero);

    nameHero.setText(TextUtils.isEmpty(hero.getTitle()) ? "missing title" : hero.getTitle());
    dateReleaseHero.setText(TextUtils.isEmpty(hero.getYear()) ? "missing year" : hero.getYear());
    descriptionHero.setText(TextUtils.isEmpty(hero.getIntro()) ? "missing text" : hero.getIntro());
    separatorHero.setBackgroundColor(Color.parseColor(hero.getColor()));
  }*/
  void bind(Character character) {
    Glide.with(view.getContext())
        .load(character.getThumbnail().getPath() + "." + character.getThumbnail().getExtension())
        .into(imageHero);

    nameHero.setText(TextUtils.isEmpty(character.getName()) ? "missing title" : character.getName());
    dateReleaseHero.setText(
        TextUtils.isEmpty(character.getDescription()) ? "missing year" : character.getDescription());
    descriptionHero.setText(
        TextUtils.isEmpty(character.getDescription()) ? "missing text" : character.getDescription());
    separatorHero.setBackgroundColor(Color.parseColor("#697431"));
  }
}
