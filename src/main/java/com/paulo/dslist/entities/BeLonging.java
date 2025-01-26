package com.paulo.dslist.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "tb_BeLonging")
public class BeLonging {

    @EmbeddedId
    private BeLongingPK id;

    private  Integer position;

    public BeLonging(){
    }

    public BeLonging(Game game, GameList list, Integer position){
        id.setGame(game);
        id.setList(list);
        this.position = position;
    }

    public BeLongingPK getId() {
        return id;
    }

    public void setId(BeLongingPK id) {
        this.id = id;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BeLonging beLonging = (BeLonging) o;
        return Objects.equals(id, beLonging.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
