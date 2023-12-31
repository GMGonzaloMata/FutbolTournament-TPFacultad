import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.game.Equipo;
import com.game.Estadio;
import com.game.Jugador;
import com.game.Partido;
import com.game.TarjetaAmarilla;
import com.game.Tarjeta;
import com.game.TarjetaRoja;

public class TarjetaTest {
    @Test
    public void torneo_sacar_tarjeta_roja_a_un_jugador_en_un_partido_parcial_ejercicio_ejemplo_04()
    {        
        Equipo boca = new Equipo("Boca Juniors", "BOC");        
        Equipo palmeiras = new Equipo("Palmeiras", "PAL");        
        
        Jugador jugador10 = new Jugador("Edinson Cavani", 10);   
        Jugador jugador19 = new Jugador("Valentin Barco", 19);
  
        boca.agregar(jugador10);         
        boca.agregar(jugador19); 

        Partido partidoIda = new Partido(palmeiras, boca, "Semifinal Partido Ida");    

        Tarjeta tarjetaRojaParaJugador10DeBoca = new Tarjeta("ROJA", jugador10){};

        partidoIda.agregar(tarjetaRojaParaJugador10DeBoca);

        assertEquals(1, partidoIda.tarjetasCantidad());          
        
        assertEquals("ROJA", partidoIda.getTarjetas().get(0).getColor());           
        assertEquals("Edinson Cavani", partidoIda.getTarjetas().get(0).getJugador().getName());   
    }

    @Test
    public void tarjeta_roja_y_amarilla_parcial_ejercicio_ejemplo_07()
    {        
        Equipo boca = new Equipo("Boca Juniors", "BOC");        
        Equipo palmeiras = new Equipo("Palmeiras", "PAL");        
       
        Jugador jugadorBoca6 = new Jugador("Marcos Rojo", 6);
        Jugador jugadorBoca10 = new Jugador("Edinson Cavani", 10);  
        Jugador jugadorBoca19 = new Jugador("Valentin Barco", 19);


        boca.agregar(jugadorBoca6);            
        boca.agregar(jugadorBoca10);      
        boca.agregar(jugadorBoca19);        


        Jugador jugadorPalmeiras10 = new Jugador("Rony", 10);


        palmeiras.agregar(jugadorPalmeiras10);


        Estadio estadioBombonera = new Estadio("La Bombonera", "Buenos Aires", "Argentina");
       
        Partido partido = new Partido(estadioBombonera, boca, palmeiras, "Semifinal Partido Vuelta");    


        TarjetaRoja tarjetaRojaParaJugador6DeBoca = new TarjetaRoja(jugadorBoca6);      
        TarjetaAmarilla tarjetaAmarillaParaJugador10DeBoca = new TarjetaAmarilla(jugadorBoca10);        
        TarjetaAmarilla tarjetaAmarillaParaJugador10DePalmeiras = new TarjetaAmarilla(jugadorPalmeiras10);

        partido.agregar(tarjetaRojaParaJugador6DeBoca);
        partido.agregar(tarjetaAmarillaParaJugador10DeBoca);
        partido.agregar(tarjetaAmarillaParaJugador10DePalmeiras);

        assertEquals(3, partido.tarjetasCantidad());    


        assertEquals("ROJA", partido.getTarjetas().get(0).getColor());  
        assertEquals(6, partido.getTarjetas().get(0).getJugador().getNumero());                
        assertEquals("Marcos Rojo", partido.getTarjetas().get(0).getJugador().getName());
        assertEquals("Tarjeta ROJA para Marcos Rojo", tarjetaRojaParaJugador6DeBoca.toString());  
         
         
        assertEquals("AMARILLA", partido.getTarjetas().get(1).getColor());  
        assertEquals(10, partido.getTarjetas().get(1).getJugador().getNumero());                
        assertEquals("Edinson Cavani", partido.getTarjetas().get(1).getJugador().getName());


         
        assertEquals("AMARILLA", partido.getTarjetas().get(2).getColor());  
        assertEquals(10, partido.getTarjetas().get(2).getJugador().getNumero());                
        assertEquals("Rony", partido.getTarjetas().get(2).getJugador().getName());
 


    }

}
