package com.example.springbbs.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long parentsId;
    private String contents;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentsId() {
        return parentsId;
    }

    public void setParentsId(Long parentsId) {
        this.parentsId = parentsId;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "Item (id=" + id + ", parentsId=" + parentsId + ", contents=" + contents + ")";
    }

}
