package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class IPokemonFactoryTest {
	
	@Mock
    IPokemonFactory testPokemonFactory;
    Pokemon aquali = new Pokemon(133, "Aquali", 186, 186, 260, 2729, 202, 5000, 4, 100.0);

	
	public IPokemonFactoryTest() {
		//on mock la classe IPokemonFactory
		this.testPokemonFactory = Mockito.mock(IPokemonFactory.class);
	}
	
	 @Test
	 public void  createPokemonTest () {
		 //on renvoie ici aquali lorsque on entre les données qui lui sont identiques
	    Mockito.when(this.testPokemonFactory.createPokemon(133,2729, 202, 5000, 4)).thenReturn(aquali);
	    //on verifi que que nous avons bien une instance de la classe pokemon lorsque on cree un pokemon avec les memes caracteristiques
        Assert.assertEquals(this.aquali, testPokemonFactory.createPokemon(133,2729, 202, 5000, 4));

	 }


}
