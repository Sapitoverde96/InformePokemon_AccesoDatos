package com.cesur.informepokemon.service;

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
}
