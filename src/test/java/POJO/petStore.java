package POJO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class petStore {
    private Integer id;
    private petCategory category;
    private String name;
    private String[] photoUrls;
    private petTags[] tags;
    private String status;



    public petStore(Integer id, petCategory category, String name, String[] photoUrls, petTags[] tags, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    public petStore() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public petCategory getCategory() {
        return category;
    }

    public void setCategory(petCategory category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(String[] photoUrls) {
        this.photoUrls = photoUrls;
    }

    public petTags[] getTags() {
        return tags;
    }

    public void setTags(petTags[] tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        String s = "PetStore{" +
                "id=" + id +
                ", category=" + category +
                ", name='" + name + '\'' +
                ", photoUrls=" + Arrays.toString(photoUrls) +
                ", tags=" + Arrays.toString(tags) +
                ", status='" + status + '\'' +
                '}';
        return s;
    }
}
