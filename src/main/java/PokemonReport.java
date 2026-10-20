import com.cesur.informepokemon.models.Pokemon;
import com.cesur.informepokemon.service.ConfigService;
import com.cesur.informepokemon.service.FileService;

void main(String[] args) {
    ConfigService configService = new ConfigService();
    FileService fileService = new FileService(configService);
    var pokemonList = fileService.loadFromJson();
    fileService.saveToText(pokemonList);
}