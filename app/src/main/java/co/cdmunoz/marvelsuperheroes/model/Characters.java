package co.cdmunoz.marvelsuperheroes.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class Characters {

  @SerializedName("results") private List<Character> results = new ArrayList<>();

  public List<Character> getResults() {
    return results;
  }

  public void setResults(List<Character> results) {
    this.results = results;
  }
}
