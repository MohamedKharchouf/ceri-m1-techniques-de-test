package fr.univavignon.pokedex.api;

import java.util.List;

public class PokemonMetadataProvider implements IPokemonMetadataProvider{
	
	private List<PokemonMetadata> listMetadata; 


	@Override
	public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
		// TODO Auto-generated method stub
		if(index < 0 || index > 150)
		{
			throw new PokedexException("index n'est pas compris entre 0 et 150");
		}
		return listMetadata.get(index);
	}

}