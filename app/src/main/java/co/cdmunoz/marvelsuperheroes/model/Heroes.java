package co.cdmunoz.marvelsuperheroes.model;

import com.google.gson.annotations.Expose;
import java.util.List;

public class Heroes {

  @Expose private List<Hero> elements;

  public List<Hero> getElements() {
    return elements;
  }

  public void setElements(List<Hero> elements) {
    this.elements = elements;
  }
}
