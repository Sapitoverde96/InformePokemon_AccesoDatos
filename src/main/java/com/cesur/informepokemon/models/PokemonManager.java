package com.cesur.informepokemon.models;

import java.util.List;

public class PokemonManager {
    private List<Pokemon> pokemonList;

    public PokemonManager(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

    public List<Pokemon> getPokemonList() { return pokemonList; }

    public void setPokemonList(List<Pokemon> pokemonList) { this.pokemonList = pokemonList; }

    public int getTotalPokemonOnList() {
        return pokemonList.size();
    }
}
