package com.cesur.informepokemon.models;

import java.util.List;

public class PokemonManager {
    private List<Pokemon> pokemonList;

    public PokemonManager(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

    public List<Pokemon> getPokemonList() { return pokemonList; }

    public void setPokemonList(List<Pokemon> pokemonList) { this.pokemonList = pokemonList; }

    public int getTotalPokemonOnList(List<Pokemon> pokemonList) {
        return pokemonList.size();
    }

    public int getAverageLevelOnList(List<Pokemon> pokemonList) {
        int totalLevel = 0;
        for (Pokemon pokemon : pokemonList) {
            totalLevel += pokemon.getLevel();
        }
        return totalLevel / pokemonList.size();
    }

    public int getAverageHealthPointsOnList(List<Pokemon> pokemonList) {
        int totalHealthPoints = 0;
        for (Pokemon pokemon : pokemonList) {
            totalHealthPoints += pokemon.getHealthPoints();
        }
        return totalHealthPoints / pokemonList.size();
    }

    public Pokemon getPokemonHigherLevelOnList(List<Pokemon> pokemonList) {
        int higherLevel = 0;
        Pokemon pokemonWithHigherLevel = null;
        for (Pokemon pokemon : pokemonList) {
            if (pokemon.getLevel() > higherLevel) {
                higherLevel = pokemon.getLevel();
                pokemonWithHigherLevel = pokemon;
            }
        }
        return pokemonWithHigherLevel;
    }

    public Pokemon getPokemonHigherHealthPointsOnList(List<Pokemon> pokemonList) {
        int higherHealthPoints = 0;
        Pokemon pokemonWithHigherHealthPoints = null;
        for (Pokemon pokemon : pokemonList) {
            if (pokemon.getHealthPoints() > higherHealthPoints) {
                higherHealthPoints = pokemon.getHealthPoints();
                pokemonWithHigherHealthPoints = pokemon;
            }
        }
        return pokemonWithHigherHealthPoints;
    }

    public int getPokemonsByType(List<Pokemon> pokemonList, String pokemonType) {
        int count = 0;
        for (Pokemon pokemon : pokemonList) {
            if (pokemon.getType().equals(pokemonType)) {
                count++;
            }
        }
        return count;
    }
}
