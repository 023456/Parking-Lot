package org.example.Models;

import java.time.LocalTime;

public class BaseModel {
    private  Long id;
    private LocalTime created_at;
    private LocalTime updated_at;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalTime created_at) {
        this.created_at = created_at;
    }

    public LocalTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalTime updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "BaseModel{" +
                "id=" + id +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
