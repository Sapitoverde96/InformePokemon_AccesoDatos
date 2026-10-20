package com.cesur.informepokemon.service;

import com.cesur.informepokemon.models.Pokemon;

import com.cesur.informepokemon.models.PokemonManager;
import tools.jackson.core.JacksonException;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.file.Path;
import java.util.List;

public class FileService {
    private final String FILE_NAME_JSON;
    private final String FILE_NAME_TXT;
    private final ConfigService CONFIG_SERVICE;

    /**
     * Crea una instancia de FileService para realizar operaciones con archivos del reporte de Pokemon.
     * @param configService Servicio de configuración para obtener el nombre del archivo sobre el que operar.
     * @version 1.0
     */
    public FileService(ConfigService configService) {
        this.CONFIG_SERVICE = configService;
        this.FILE_NAME_JSON = this.CONFIG_SERVICE.getProperty("filename");
        this.FILE_NAME_TXT = this.CONFIG_SERVICE.getProperty("report");
    }

    /**
     * Carga la lista de Pokémon desde un archivo JSON.
     * @param filename El nombre del archivo desde el que se va a cargar.
     * @return La lista de Pokémon cargada desde el archivo.
     * @version 1.0
     */
    public List<Pokemon> loadFromJson() {
        checkValidFilename(this.FILE_NAME_JSON);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new FileReader(this.FILE_NAME_JSON), new TypeReference<List<Pokemon>>() {});
        } catch (FileNotFoundException exception) {
            throw new RuntimeException("File not found: " + this.FILE_NAME_JSON, exception);
        } catch (JacksonException exception) {
            throw new RuntimeException("Error reading JSON file", exception);
        }
    }

    /**
     * Guarda la lista de Pokémon en un archivo JSON.
     * @param filename El nombre del archivo al que se va a guardar.
     * @param pokemonList La lista de Pokémon que se va a guardar.
     * @version 1.0
     */
    public void saveToJson(List<Pokemon> pokemonList) {
        checkValidFilename(this.FILE_NAME_JSON);
        checkValidPokemonList(pokemonList);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(Path.of(this.FILE_NAME_JSON), pokemonList);
        } catch (JacksonException exception) {
            throw new RuntimeException("Error writing JSON file", exception);
        }
    }

    /**
     * Guarda la lista de Pokémon en un archivo TXT.
     * @param filename El nombre del archivo al que se va a guardar.
     * @param pokemonList La lista de Pokémon que se va a guardar.
     * @version 1.0
     */
    public void saveToText(List<Pokemon> pokemonList) {
        checkValidFilename(this.FILE_NAME_TXT);
        checkValidPokemonList(pokemonList);
        PokemonManager pkmManager = new PokemonManager(pokemonList);
        try (BufferedWriter bufWriter = new BufferedWriter(new FileWriter(this.FILE_NAME_TXT))) {
            bufWriter.write("--- POKEMON REPORT ---\n");
            bufWriter.write("Total Pokemon: " + pkmManager.getTotalPokemonOnList(pokemonList) + "\n");
            bufWriter.write("Average level: " + pkmManager.getAverageLevelOnList(pokemonList) + "\n");
            bufWriter.write("Average health points: " + pkmManager.getAverageHealthPointsOnList(pokemonList) + "\n");
            bufWriter.write("Highest level pokemon:\n" +
                    pkmManager.getPokemonHigherLevelOnList(pokemonList).getName() + "(LVL " +
                    pkmManager.getPokemonHigherLevelOnList(pokemonList).getLevel() + ")\n");
            bufWriter.write("Highest health points pokemon:\n" +
                    pkmManager.getPokemonHigherHealthPointsOnList(pokemonList).getName() + "(HP " +
                    pkmManager.getPokemonHigherHealthPointsOnList(pokemonList).getHealthPoints() + ")\n");
            bufWriter.write("POKEMON BY TYPE:\n");
            // todo Hacer lo que queda de saveToText()
        } catch (IOException exception) {
            throw new RuntimeException("Error writing text file", exception);
        }
    }

    // Métodos helper
    /**
     * Verifica que el nombre del archivo no sea nulo ni este vacío
     * @param filename El nombre del archivo.
     * @version 1.0
     */
    private void checkValidFilename(String filename) {
        if (filename == null || filename.isEmpty()) {
            throw new IllegalArgumentException("Filename cannot be null or empty");
        }
    }

    /**
     * Verifica que la lista de Pokémon no sea nula ni esté vacía
     * @param pokemonList La lista de Pokémon.
     * @version 1.0
     */
    private void checkValidPokemonList(List<Pokemon> pokemonList) {
        if (pokemonList == null || pokemonList.isEmpty()) {
            throw new IllegalArgumentException("Pokemon list cannot be null or empty");
        }
    }
}
