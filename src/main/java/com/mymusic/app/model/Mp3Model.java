package com.mymusic.app.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "mp3s")
public class Mp3Model {
    @Id
    private String id;
    @Field("image")
    private String image;
    @Field("folder")
    private String folder;
    @Field("list")
    private List<Object> list;


    public Mp3Model() {
    }

    public Mp3Model(String id, String image, String folder, List<Object> list) {
        this.id = id;
        this.image = image;
        this.folder = folder;
        this.list = list;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFolder() {
        return this.folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public List<Object> getList() {
        return this.list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public Mp3Model id(String id) {
        setId(id);
        return this;
    }

    public Mp3Model image(String image) {
        setImage(image);
        return this;
    }

    public Mp3Model folder(String folder) {
        setFolder(folder);
        return this;
    }

    public Mp3Model list(List<Object> list) {
        setList(list);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", image='" + getImage() + "'" +
            ", folder='" + getFolder() + "'" +
            ", list='" + getList() + "'" +
            "}";
    }

}
