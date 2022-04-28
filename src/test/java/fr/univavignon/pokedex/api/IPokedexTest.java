package fr.univavignon.pokedex.api;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokedexTest {
	
	IPokedex testPokedex;
	ArrayList<Pokemon> listPokemons;
	
	public IPokedexTest() {
		this.testPokedex = Mockito.mock(IPokedex.class);
		//on va instancier notre liste de pokemon
		this.listPokemons = new ArrayList();
		//on cree nos Pokemons
		Pokemon mohamed = new Pokemon(10, "Mohamed", 300, 300, 300, 1000, 100, 8000, 10, 100.0);
		Pokemon aquali = new Pokemon(133, "Aquali", 186, 186, 260, 2729, 202, 5000, 4, 100.0);
		Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0);
		//on les ajoute a notre liste de pokemons
		this.listPokemons.add(mohamed);this.listPokemons.add(aquali);this.listPokemons.add(bulbizarre);
	}
	
	@Test
	public void sizeTest(){
		//on renvoie la taille de notre liste lorsqu'on apelle la fonction size
		Mockito.doReturn(this.listPokemons.size()).when(this.testPokedex).size();
		//on verifie que nous avons bien 3 lorsqu'on apelle la fonction
		Assert.assertEquals(3, testPokedex.size());
	}
	
	@Test
	public void addPokemonTest() {
		//creation pokemon qui va etre ajoute avec mock
		Pokemon moha = new Pokemon(100, "moha", 100, 100, 100, 100, 100, 100, 100, 100.0);
		//on fait +1 car on "ajoute" un pokemon
		Mockito.doReturn(this.listPokemons.size()+1).when(this.testPokedex).addPokemon(Mockito.any(Pokemon.class));
		//on attend la taille + 1
		Assert.assertEquals(this.listPokemons.size()+1, this.testPokedex.addPokemon(moha));
		
	}

	@Test
	public void getPokemonTest() throws PokedexException {
		//on renvoie le pokemon mohamed quand on met lindice 0
		Mockito.doReturn(this.listPokemons.get(0)).when(this.testPokedex).getPokemon(10);
		//on renvoie le pokemon aquali quand on met lindice 1
		Mockito.doReturn(this.listPokemons.get(1)).when(this.testPokedex).getPokemon(0);
		//on renvoie le pokemon bulbizarre quand on met lindice 2
		Mockito.doReturn(this.listPokemons.get(2)).when(this.testPokedex).getPokemon(133);
		//on lance exception si la tranche pour l'index n'est pas respectée
        Mockito.doThrow(new PokedexException("Un pokemon avec un tel index n'existe pas ! Tu n'es pas concentré ...")).when(this.testPokedex).getPokemon(Mockito.intThat(index -> index < 0 || index > 150));
        // si on met l'index 10 on retourne le pokement moha
        Assert.assertEquals(this.listPokemons.get(0), this.testPokedex.getPokemon(10));
        // si on met l'index 0 on retourne le pokement aquali
        Assert.assertEquals(this.listPokemons.get(1), this.testPokedex.getPokemon(0));
     // si on met l'index 2 on retourne le pokement bulbizarre
        Assert.assertEquals(this.listPokemons.get(2), this.testPokedex.getPokemon(133));
        // Ici on verifie que l'exception fonctionne bien
        Assert.assertThrows(PokedexException.class, () -> this.testPokedex.getPokemon(151));
     // Ici on verifie que l'exception fonctionne bien
        Assert.assertThrows(PokedexException.class, () -> this.testPokedex.getPokemon(-1));
	}
	
	@Test
	public void getPokemonsTest() {
		//on declare une liste non modifiable a laide de la librairie collection et on donne en arg notre liste
		List<Pokemon> listeNonModifiable = Collections.unmodifiableList(this.listPokemons);
		//on retourne la liste precedente (mock)
        Mockito.doReturn(listeNonModifiable).when(this.testPokedex).getPokemons();
        // on verifie que nous avons vien une instance de la classe 'liste non modifiable" lorsqu'on apelle la methode
        Assert.assertEquals(listeNonModifiable.getClass(), this.testPokedex.getPokemons().getClass());
        // on verifie que nous avons bien la meme liste
        Assert.assertEquals(3, this.testPokedex.getPokemons().size());
	}
	
	@Test
	public void getPokemons() {
		
		//On instancie nos comparators a laide de la classe PokemonComparators
		PokemonComparators name = PokemonComparators.NAME;
        PokemonComparators index = PokemonComparators.INDEX;
        PokemonComparators cp = PokemonComparators.CP;
        //On crée nos 3 listes qui seront "sort" a laide des pokemon comparators
        //donc un par nom, un avec l'index et la derniere avec le cp
        List<Pokemon> listeTrieParCP = new ArrayList<>(this.listPokemons);
        listeTrieParCP.sort(cp);
        List<Pokemon> listeTrieParNom = new ArrayList<>(this.listPokemons);
        listeTrieParNom.sort(name);
        List<Pokemon> listeTrieParIndex = new ArrayList<>(this.listPokemons);
        listeTrieParIndex.sort(index);
        //on fait nos mockito return et on retourne nos 3 liste en fonction du parametre donne a la fonction (de type 
        //pokemon comparator)
        //on renvoie la liste non modifiable trie par cp lors de lapelle a la fonction avec le comparator cp
        Mockito.doReturn(Collections.unmodifiableList(listeTrieParCP)).when(this.testPokedex).getPokemons(cp);
        //on renvoie la liste non modifiable trie par index lors de lapelle a la fonction avec le comparator index
        Mockito.doReturn(Collections.unmodifiableList(listeTrieParIndex)).when(this.testPokedex).getPokemons(index);
        //on renvoie la liste non modifiable trie par name lors de lapelle a la fonction avec le comparator name
        Mockito.doReturn(Collections.unmodifiableList(listeTrieParNom)).when(this.testPokedex).getPokemons(name);     
        // On verifie quon a bien une "unmmodifiableList" lors de lappel a la fonction
        Assert.assertEquals(Collections.unmodifiableList(new ArrayList<>()).getClass(), this.testPokedex.getPokemons(index).getClass());
        // on verifie que Bulbizarre est le premier quand on trie par index
        Assert.assertEquals("Bulbizarre", this.testPokedex.getPokemons(index).get(0).getName());
        // on verifie que Aquali est le premier prenom lorsque on trie par "name"
        Assert.assertEquals("Aquali", this.testPokedex.getPokemons(name).get(0).getName());
        // on verifie que Bulbizarre est le premier quand on trie par cp
        Assert.assertEquals("Bulbizarre", this.testPokedex.getPokemons(cp).get(0).getName());
	}

	

}
