package com.paulo.dslist.dto;


import com.paulo.dslist.entities.Game;
import com.paulo.dslist.projection.GameMinProjection;

public class GameMinDTO {

    private Long Id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;

    public GameMinDTO(){

    }

    public GameMinDTO(Game entity) {
        Id = entity.getId();
        title = entity.getTitle();
        year = entity.getYear();
        imgUrl = entity.getImgUrl();
        shortDescription = entity.getShortDescription();
    }

    public GameMinDTO(GameMinProjection projection) {
        Id = projection.getId();
        title = projection.getTitle();
        year = projection.getgameYear();
        imgUrl = projection.getImgUrl();
        shortDescription = projection.getShortDescription();
    }

    public Long getId() {
        return Id;
    }

    public String getTitle() {
        return title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public Integer getYear() {
        return year;
    }

    public String getShortDescription() {
        return shortDescription;
    }
}