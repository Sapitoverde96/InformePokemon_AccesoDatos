package com.cesur.informepokemon.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigService {
    public final Properties PROPERTIES = new Properties();

    /**
     * Crea una instancia de ConfigService y carga las propiedades desde el archivo "config.properties".
     * @throws RuntimeException Si no se encuentra el archivo o sucede un error al cargar el archivo de configuración.
     * @version 1.0
     */
    public ConfigService() {
        try {
            PROPERTIES.load(new FileReader("config.properties"));
        } catch (FileNotFoundException exception) {
            throw new RuntimeException("config.properties file was not found: " + exception.getMessage());
        } catch (IOException exception) {
            throw new RuntimeException("Unexpected error loading the config file: " + exception.getMessage());
        }
    }

    /**
     * Devuelve el valor de la propiedad asociada a la clave proporcionada.
     * @param key La clave de la propiedad a obtener.
     * @return El valor asociado a dicha clave
     * @version 1.0
     */
    public String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }
}
