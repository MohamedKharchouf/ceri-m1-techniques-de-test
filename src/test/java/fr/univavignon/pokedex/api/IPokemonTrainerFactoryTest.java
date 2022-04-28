package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class IPokemonTrainerFactoryTest {
	
	@Mock
	IPokedex testpokedex;
	@Mock
    IPokedexFactory testpokedexfactory;
	@Mock
    IPokemonTrainerFactory testpokemontrainerfactory;

    
    public IPokemonTrainerFactoryTest() {
    	//on mock la class IPokedex pour la reutiliser dans la fonction de test
    	this.testpokedex = Mockito.mock(IPokedex.class);
    	//on mock la class IPokedexFactory pour la reutiliser dans la fonction de test
    	this.testpokedexfactory = Mockito.mock(IPokedexFactory.class);
    	//on mock la class IPokedexTrainerFactory pour la reutiliser dans la fonction de test
    	this.testpokemontrainerfactory = Mockito.mock(IPokemonTrainerFactory.class);
    }
    

    @Test
    public void createTrainerTest() {
    	//on cree linstance de la classe pokemontrainer qui va nous servir lors du doReturn
    	PokemonTrainer pokemonTrainerTest = new PokemonTrainer("Testtrainer", Team.VALOR, this.testpokedex);
    	//on renvoie le pokemonTrainer lors de lapelle a la fonction createTrainer
        Mockito.doReturn(pokemonTrainerTest).when(this.testpokemontrainerfactory).createTrainer("Testtrainer", Team.VALOR, this.testpokedexfactory);
        // on verifie que nous avons bien une instance de la classe pokemon trainer 
        Assert.assertEquals(pokemonTrainerTest.getClass(), this.testpokemontrainerfactory.createTrainer("Testtrainer", Team.VALOR, this.testpokedexfactory).getClass());
        // on verifie bien que le nom que nous avons correspond bien a "Testtrainer"
        Assert.assertEquals("Testtrainer", this.testpokemontrainerfactory.createTrainer("Testtrainer", Team.VALOR, this.testpokedexfactory).getName());
    }
}
