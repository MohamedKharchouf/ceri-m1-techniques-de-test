package fr.univavignon.pokedex.api;

import org.junit.Assert;

import org.mockito.Mockito;

public class RocketPokemonFactoryTest {
	
	Pokemon bulbizarre;
    Pokemon aquali ;

    RocketPokemonFactory rocketPokemonFactoryTest;
    
    public RocketPokemonFactoryTest(){
    	aquali = new Pokemon(133, "Aquali", 186, 186, 260, 2729, 202, 5000, 4, 100);
        bulbizarre =  new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
    }
    
    /*@Test
    public void rocketCreatePokemonTest() throws PokedexException {
    	
    	
    //On verifie que le pokemon crée renvoie bien le bon HP
        Assert.assertEquals(aquali.getHp(), rocketPokemonFactoryTest.createPokemon(133,2729, 202, 5000, 4).getHp());
        Assert.assertEquals(bulbizarre.getHp(), rocketPokemonFactoryTest.createPokemon(0, 613, 64, 4000, 4).getHp());
        
      //On verifie que le pokemon crée renvoie bien le bon IV
        Assert.assertEquals(aquali.getIv(), rocketPokemonFactoryTest.createPokemon(133,2729, 202, 5000, 4).getIv(), 0.0);
        Assert.assertEquals(bulbizarre.getIv(), rocketPokemonFactoryTest.createPokemon(0, 613, 64, 4000, 4).getIv(), 0.0);
        
        
        //On verifie
        Assert.assertThrows(PokedexException.class, () -> rocketPokemonFactoryTest.createPokemon(150,2729, 202, 5000, 4));
        Assert.assertThrows(PokedexException.class, () -> rocketPokemonFactoryTest.createPokemon(-50,2729, 202, 5000, 4));
        
        
    }*/

}
