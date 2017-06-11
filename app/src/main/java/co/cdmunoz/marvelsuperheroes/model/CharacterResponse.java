package co.cdmunoz.marvelsuperheroes.model;

import com.google.gson.annotations.SerializedName;

public class CharacterResponse {

  @SerializedName("data") private Characters data = new Characters();

  public Characters getData() {
    return data;
  }

  public void setData(Characters data) {
    this.data = data;
  }
}
