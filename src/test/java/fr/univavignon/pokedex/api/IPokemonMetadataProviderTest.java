package fr.univavignon.pokedex.api;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.Assert;
import org.junit.Test;

public class IPokemonMetadataProviderTest {
	
	
	@Mock
	IPokemonMetadataProvider testProvider;
	
	PokemonMetadata bulbizarre, aquali;
	
	public IPokemonMetadataProviderTest(){
		this.testProvider = Mockito.mock(IPokemonMetadataProvider.class);
		this.aquali = new PokemonMetadata(133, "Aquali", 186, 168, 260);
		this.bulbizarre = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
	}
	
	@Test
    public void getPokemonMetadataTest() throws PokedexException {
		//on renvoie bulbizarre lorsque on met l'index 0
        Mockito.doReturn(this.bulbizarre).when(this.testProvider).getPokemonMetadata(0);
      //on renvoie bulbizarre lorsque on met l'index 133
        Mockito.doReturn(this.aquali).when(this.testProvider).getPokemonMetadata(133);
      //on lance lexception lorsque l'index nest pas situé entre 0 et 150
        Mockito.doThrow(new PokedexException("Un pokemon avec un tel index n'existe pas ! Tu n'es pas concentré ... ")).when(testProvider).getPokemonMetadata(Mockito.intThat(index -> index < 0 || index > 150));
        //on verifie que nous avons bulbizarre lorsque on met l'index 0
        Assert.assertEquals(this.bulbizarre, this.testProvider.getPokemonMetadata(0));
        //on verifie que nous avons aquali lorsque on met l'index 133
        Assert.assertEquals(this.aquali, this.testProvider.getPokemonMetadata(133));
        //on verifie que nous avons une exception lorsque nous mettons un index hors de 0 et 150
        Assert.assertThrows(PokedexException.class, () -> testProvider.getPokemonMetadata(-151));
    }
	
	
	
	

}
