package com.ilionx.carapp.retrofit;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class Post {
    private long id;
    private long userId;
    private String title;
    private String body;
}
