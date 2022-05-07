package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex{

	ArrayList<Pokemon> listPokemons;
	IPokemonMetadataProvider metadataProvider = null;
	IPokemonFactory pokemonFactory = null;

	public Pokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
		this.listPokemons = new ArrayList<>();
		this.metadataProvider = metadataProvider;
		this.pokemonFactory = pokemonFactory; 
	}
	
	@Override
	public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
		// TODO Auto-generated method stub
		return metadataProvider.getPokemonMetadata(index);
	}

	@Override
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
		// TODO Auto-generated method stub
		return  pokemonFactory.createPokemon(index, cp, hp, dust, candy);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return listPokemons.size();
	}

	@Override
	public int addPokemon(Pokemon pokemon) {
		// TODO Auto-generated method stub
		listPokemons.add(pokemon);
		return listPokemons.size()-1;
	}

	@Override
	public Pokemon getPokemon(int id) throws PokedexException {
		// TODO Auto-generated method stub
		if(id > 150 || id < 0)
		{
			throw new PokedexException("L'id n'est pas compris entre 0 et 150 !");
		}
		return listPokemons.get(id);
	}

	@Override
	public List<Pokemon> getPokemons() {
		// TODO Auto-generated method stub
		return listPokemons;
	}

	@Override
	public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
		// TODO Auto-generated method stub
		List<Pokemon> listTrierByOrder = new ArrayList<>(this.listPokemons);
		listTrierByOrder.sort(order);
		return listTrierByOrder;
	}

}
