package academy.devdojo.maratonajava.javacore.ZZKJunit.dominio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MangaTest {
    private Manga manga1;
    private Manga manga2;
    @BeforeEach
    public void setup(){
        manga1 = new Manga("Kimetsu no Yaiba", 24);
        manga2 = new Manga("Kimetsu no Yaiba", 24);
    }

    @Test
    public void acessores_ReturnData_QuandoInicializados(){
        assertEquals("Kimetsu no Yaiba", manga1.nome());
        assertEquals(24, manga1.episodios());
    }

    @Test
    public void equals_ReturnTrue_QuandoOsObjetosSaoOsMesmos(){
        assertEquals(manga1,manga2);
    }

    @Test
    public void hashCode_ReturnTrue_QuandoOsObjetosSaoOsMesmos(){
        assertEquals(manga1.hashCode(),manga2.hashCode());
    }

    @Test
    public void constructor_ThrowNullPointerException_QuandoNomeENull(){
        assertThrows(NullPointerException.class, () -> new Manga(null, 12));
    }

    @Test
    public void isRecord_ReturnTrue_QuandoChamadoDeManga(){
        assertTrue(Manga.class.isRecord());
    }

}