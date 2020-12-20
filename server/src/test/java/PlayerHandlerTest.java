import cs.checkers.gamelogic.board.Corner;
import cs.checkers.server.Player;
import cs.checkers.server.PlayerHandler;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import static org.junit.Assert.assertEquals;


public class PlayerHandlerTest {
    private Socket clientSocket = null;
    private ServerSocket server = null;
    private PlayerHandler handler = null;
    private Socket accepted = null;
    private DataInputStream in = null;
    private Player player;

    @Before
    public void setUp()  throws IOException {
        if (accepted != null)
        accepted.close();
        if (in != null)
        in.close();
        server = new ServerSocket(8080);
        clientSocket = new Socket("localhost", 8080);
        accepted = server.accept();
        in = new DataInputStream(new BufferedInputStream(accepted.getInputStream()));
        handler = new PlayerHandler(clientSocket);
    }

    @Test
    public void testPlayer() throws IOException {
        player = new Player(new Corner());
        handler.setPlayer(player);
        assertEquals(player, handler.getPlayer());
    }
}
