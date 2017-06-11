package co.cdmunoz.marvelsuperheroes.model;

import com.google.gson.annotations.SerializedName;

public class Character {

  @SerializedName("id") private int id;
  @SerializedName("name") private String name;
  @SerializedName("description") private String description;
  @SerializedName("thumbnail") private Image thumbnail = new Image();

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Image getThumbnail() {
    return thumbnail;
  }

  public void setThumbnail(Image thumbnail) {
    this.thumbnail = thumbnail;
  }

  public Character() {
  }
}
