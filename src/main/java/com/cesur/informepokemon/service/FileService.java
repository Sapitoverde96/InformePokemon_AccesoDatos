package com.cesur.informepokemon.service;

import com.cesur.informepokemon.models.Pokemon;

import com.cesur.informepokemon.models.PokemonManager;
import tools.jackson.core.JacksonException;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.List;

public class FileService {
    private final String FILE_NAME;
    private final ConfigService CONFIG_SERVICE;

    /**
     * Crea una instancia de FileService para realizar operaciones con archivos del reporte de Pokemon.
     * @param configService Servicio de configuración para obtener el nombre del archivo sobre el que operar.
     * @version 1.0
     */
    public FileService(ConfigService configService) {
        this.CONFIG_SERVICE = configService;
        this.FILE_NAME = this.CONFIG_SERVICE.getProperty("filename");
    }

    /**
     * Carga la lista de Pokémon desde un archivo JSON.
     * @param filename El nombre del archivo desde el que se va a cargar.
     * @return La lista de Pokémon cargada desde el archivo.
     * @version 1.0
     */
    public List<Pokemon> loadFromJson() {
        checkValidFilename(this.FILE_NAME);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new FileReader(this.FILE_NAME), new TypeReference<List<Pokemon>>() {});
        } catch (FileNotFoundException exception) {
            throw new RuntimeException("File not found: " + this.FILE_NAME, exception);
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
    public void saveToJson(String filename, List<Pokemon> pokemonList) {
        checkValidFilename(filename);
        checkValidPokemonList(pokemonList);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(Path.of(filename), pokemonList);
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
    public void saveToText(String filename, List<Pokemon> pokemonList) {
        checkValidFilename(filename);
        checkValidPokemonList(pokemonList);
        // todo hacer método saveToText
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
