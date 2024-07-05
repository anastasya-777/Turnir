package ru.topacademy.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import ru.topacademy.javaqa.NotRegisteredException;
import ru.topacademy.javaqa.Player;
import ru.topacademy.javaqa.Game;


public class GameTest {
    Game game = new Game();

    @BeforeEach
    public void setUp() {
        game = new Game();
    }

    @Test
    public void testWinFirstPlayer() {
        Player player1 = new Player(5, "Роман", 75);
        Player player2 = new Player(7, "Вова", 50);
        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Роман", "Вова");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testDraw() {
        Player player1 = new Player(5, "Роман", 50);
        Player player2 = new Player(7, "Вова", 50);
        game.register(player1);
        game.register(player2);

        int expected = 0;
        int actual = game.round("Роман", "Вова");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testNotRegisteredPlayer() {
        Player player1 = new Player(5, "Роман", 50);
        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Роман", "Вова");
        });
    }

    @Test
    void notRegisteredPlayer1ThrowsException() {
        Game game = new Game();
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("PlayerNotExists", "Player2"));
    }

    @Test
    void shouldReturn2WhenPlayer2Stronger() {
        Game game = new Game();
        game.register(new Player(5,"Player1", 10));
        game.register(new Player(7,"Player2", 20));

        Assertions.assertEquals(2, game.round("Player1", "Player2"));
    }

    @Test
    void getIdShouldReturnCorrectId() {
        Player player = new Player(1,"PlayerName", 1);
        Assertions.assertEquals(1, player.getId());
    }
}
