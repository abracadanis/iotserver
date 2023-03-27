package com.example.demo.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "device")
@SequenceGenerator(name = "generator", allocationSize = 1, sequenceName = "seq")
public class Device {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "generator")
    private Long id;

    @Column(name = "key")
    private String key;

    @Column(name = "value")
    private Boolean value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }
}
