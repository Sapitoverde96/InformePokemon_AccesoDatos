package com.cesur.informepokemon.models;

public class Pokemon {
    private Long id;
    private String name;
    private String type;
    private Integer level;
    private Integer healthPoints;

    public Pokemon() {}

    public Pokemon(Long id, String name, String type, Integer level, Integer healthPoints) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.level = level;
        this.healthPoints = healthPoints;
    }

    public long getId() { return id; }
    public String getName() { return name; }
    public String getType() { return type; }
    public Integer getLevel() { return level; }
    public Integer getHealthPoints() { return healthPoints; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setType(String type) { this.type = type; }
    public void setLevel(Integer level) { this.level = level; }
    public void setHealthPoints(Integer healthPoints) { this.healthPoints = healthPoints; }

    @Override
    public String toString() {
        return String.format("Pokemon %d: %s { %s, %d, %d }", id, name, type, level, healthPoints);
    }
}
