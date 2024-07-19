package com.ntndev.basicspringboot.model;


import lombok.Builder;
import lombok.Data;

@Data // full option(getter, setter,toString,........)
@Builder // = constructor
public class Greeting {
    private long id;
    private String content;
}
