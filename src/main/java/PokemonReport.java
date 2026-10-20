import com.cesur.informepokemon.models.Pokemon;
import com.cesur.informepokemon.service.ConfigService;
import com.cesur.informepokemon.service.FileService;

void main(String[] args) {
    ConfigService configService = new ConfigService();

    FileService fileService = new FileService(configService);

    // El siguiente código solo se ha usado para generar el JSON del ejercicio
    List<Pokemon> pokemonList = new ArrayList<>();
    pokemonList.add(new Pokemon(1L, "Bulbasaur", "Poison", 5, 20));
    pokemonList.add(new Pokemon(2L, "Charmander", "Fire", 10, 31));
    pokemonList.add(new Pokemon(3L, "Squirtle", "Water", 8, 26));
    pokemonList.add(new Pokemon(4L, "Pikachu", "Electric", 15, 42));
    pokemonList.add(new Pokemon(5L, "Jigglypuff", "Normal", 12, 55));
    pokemonList.add(new Pokemon(6L, "Meowth", "Normal", 14, 38));
    pokemonList.add(new Pokemon(7L, "Abra", "Psychic", 9, 24));
    pokemonList.add(new Pokemon(8L, "Gastly", "Poison", 11, 29));
    pokemonList.add(new Pokemon(9L, "Eevee", "Normal", 20, 58));
    pokemonList.add(new Pokemon(10L, "Snorlax", "Normal", 35, 160));
    pokemonList.add(new Pokemon(11L, "Dragonite", "Dragon", 55, 182));
    pokemonList.add(new Pokemon(12L, "Mewtwo", "Psychic", 70, 248));
    pokemonList.add(new Pokemon(13L, "Chikorita", "Grass", 6, 22));
    pokemonList.add(new Pokemon(14L, "Cyndaquil", "Fire", 7, 24));
    pokemonList.add(new Pokemon(15L, "Totodile", "Water", 5, 21));
    pokemonList.add(new Pokemon(16L, "Tyranitar", "Rock", 55, 190));
    pokemonList.add(new Pokemon(17L, "Treecko", "Grass", 8, 25));
    pokemonList.add(new Pokemon(18L, "Torchic", "Fire", 9, 27));
    pokemonList.add(new Pokemon(19L, "Mudkip", "Water", 10, 32));
    pokemonList.add(new Pokemon(20L, "Lucario", "Steel", 40, 118));
    fileService.saveToJson(pokemonList);
}