import com.cesur.informepokemon.service.ConfigService;
import com.cesur.informepokemon.service.FileService;

void main(String[] args) {
    ConfigService configService = new ConfigService();
    FileService fileService = new FileService(configService);
}