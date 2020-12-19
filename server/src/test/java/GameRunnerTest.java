import cs.checkers.common.BoardTypes;
import cs.checkers.server.GameRunner;
import cs.checkers.server.PlayerHandler;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameRunnerTest {
    private ServerSocket mockServerSocket;
    private Socket mockClientSocket1;
    private Socket mockClientSocket2;
    private GameRunner gameRunner;
    private PlayerHandler player1;
    private PlayerHandler player2;
    private ByteArrayInputStream input1;
    private ByteArrayInputStream input2;
    private ByteArrayOutputStream output1;
    private ByteArrayOutputStream output2;
    private Scanner scanner1;
    private Scanner scanner2;

    @Before
    public void setUp() {
        String ok = "OK";
        mockServerSocket = mock(ServerSocket.class);
        mockClientSocket1 = mock(Socket.class);
        mockClientSocket2 = mock(Socket.class);
        player1 = mock(PlayerHandler.class);
        player2 = mock(PlayerHandler.class);
        output1 = new ByteArrayOutputStream();
        output2 = new ByteArrayOutputStream();
        input1 = new ByteArrayInputStream(ok.getBytes());
        input2 = new ByteArrayInputStream(ok.getBytes());
        try {
            when(mockServerSocket.getLocalPort()).thenReturn(4999);
            when(mockClientSocket1.getInputStream()).thenReturn(input1);
            when(mockClientSocket2.getInputStream()).thenReturn(input2);
            when(mockClientSocket1.getOutputStream()).thenReturn(output1);
            when(mockClientSocket2.getOutputStream()).thenReturn(output2);
        }
        catch (IOException ex) {

        }
        gameRunner = new GameRunner(BoardTypes.TwoPlayerChineseCheckers, mockServerSocket);
    }

    @Test
    public void initializeTest() {
        try {
            when(mockServerSocket.accept()).thenReturn(mockClientSocket1, mockClientSocket2);
        }
        catch (IOException ex) {

        }
        gameRunner.initialize();

       // gameRunner.run();
    }
}
