package co.cdmunoz.marvelsuperheroes.screens.heroes.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import co.cdmunoz.marvelsuperheroes.R;
import co.cdmunoz.marvelsuperheroes.model.Character;
import co.cdmunoz.marvelsuperheroes.model.Hero;
import java.util.ArrayList;
import rx.Observable;
import rx.subjects.PublishSubject;

public class HeroesAdapter extends RecyclerView.Adapter<HeroViewHolder> {

  private final PublishSubject<Integer> itemClicks = PublishSubject.create();
  ArrayList<Hero> listHeroes = new ArrayList<>();
  ArrayList<Character> listCharacters = new ArrayList<>();

  /*public void swapAdapter(ArrayList<Hero> heroes) {
    this.listHeroes.clear();
    this.listHeroes.addAll(heroes);
    notifyDataSetChanged();
  }*/

  public void swapAdapter(ArrayList<Character> characters) {
    this.listCharacters.clear();
    this.listCharacters.addAll(characters);
    notifyDataSetChanged();
  }

  public Observable<Integer> observeClicks() {
    return itemClicks;
  }

  @Override public HeroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hero, parent, false);
    return new HeroViewHolder(view, itemClicks);
  }

  @Override public void onBindViewHolder(HeroViewHolder holder, int position) {

    /*Hero hero = listHeroes.get(position);
    holder.bind(hero);*/
    Character character = listCharacters.get(position);
    holder.bind(character);
  }

  @Override public int getItemCount() {
    /*if (listHeroes != null && listHeroes.size() > 0) {
      return listHeroes.size();
    } else {
      return 0;
    }*/
    if (listCharacters != null && listCharacters.size() > 0) {
      return listCharacters.size();
    } else {
      return 0;
    }
  }
}
