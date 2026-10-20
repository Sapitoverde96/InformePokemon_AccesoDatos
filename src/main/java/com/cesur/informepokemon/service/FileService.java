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
        this.FILE_NAME = configService.getProperty("filename");
    }

    public List<Pokemon> loadFromJson(String filename) {
        if (filename == null || filename.isEmpty()) {
            throw new IllegalArgumentException("Filename cannot be null or empty");
        }
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new FileReader(filename), new TypeReference<List<Pokemon>>() {});
        } catch (FileNotFoundException exception) {
            throw new RuntimeException("File not found: " + filename, exception);
        } catch (JacksonException exception) {
            throw new RuntimeException("Error reading JSON file", exception);
        }
    }

    public void saveToJson(String filename, List<Pokemon> pokemonList) {
        if (filename == null || filename.isEmpty()) {
            throw new IllegalArgumentException("Filename cannot be null or empty");
        }
        if (pokemonList == null || pokemonList.isEmpty()) {
            throw new IllegalArgumentException("Pokemon list cannot be null or empty");
        }
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(Path.of(filename), pokemonList);
        } catch (JacksonException exception) {
            throw new RuntimeException("Error writing JSON file", exception);
        }
    }

    public void saveToText(String filename, List<Pokemon> pokemonList) {
        if (filename == null || filename.isEmpty()) {
            throw new IllegalArgumentException("Filename cannot be null or empty");
        }
        if (pokemonList == null || pokemonList.isEmpty()) {
            throw new IllegalArgumentException("Pokemon list cannot be null or empty");
        }
        // todo hacer método saveToText
    }
}
