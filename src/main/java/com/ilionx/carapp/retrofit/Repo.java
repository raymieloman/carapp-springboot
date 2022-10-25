package com.ilionx.carapp.retrofit;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonAnyGetter
public class Repo {
    // fields
    private String name;
    private String id;

    // getters
    public String getName(){ return this.name; }
}
