import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class EnkeltUI extends BrukerGrensesnitt{

    public void skrivUtSpillersRunde(Spiller spiller){
        System.out.println(spiller.getSpillersNavn() +
                " Kastet "+ Terning.sisteTerningkast +
                " og gikk til rute nr -> " + spiller.hentSpillersRutePlassering() +
                " som er av type: " + spiller.hentRute().getClass().toString());
    }

    public void lagVindu() throws IOException {
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        Screen screen = new TerminalScreen(terminal);
        TextGraphics tg = screen.newTextGraphics();
        screen.startScreen();
        tg.putString(10,10, "Hello world");
        screen.refresh();
        screen.readInput();
        screen.stopScreen();


    }


}
