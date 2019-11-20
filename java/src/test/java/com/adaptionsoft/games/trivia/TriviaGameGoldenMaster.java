package com.adaptionsoft.games.trivia;

import static org.junit.Assert.*;

import com.adaptionsoft.games.trivia.runner.GameRunner;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;

public class TriviaGameGoldenMaster {

    @Test
    public void output_should_match_golden_master() throws IOException {
        var previousOut = System.out;
        File f = File.createTempFile("null", "null");
        System.setOut(new PrintStream(new FileOutputStream(f)));

        GameRunner gameRunner = new GameRunner();
        gameRunner.main(null);

        System.setOut(previousOut);
        assertEquals(Files.readString(new File("./src/test/resources/expectedOutput").toPath()), (Files.readString(f.toPath())));
    }


}
