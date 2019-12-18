package com.j4mt.github.search.util;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArgParserTest {

    @Test
    public void testArgParser_ParseArgs() {

        String[] argv = new String[]{"--searchUser", "TestNG"};
        ArgParser argParser = new ArgParser();
        argParser.parse(argv);

        assertThat(argParser.get("--searchUser"), is("TestNG"));
    }

    @Test
    public void testArgParser_ParseArgs_EmptyArgs() {

        String[] argv = new String[]{};
        ArgParser argParser = new ArgParser();
        argParser.parse(argv);

        assertThat(argParser.get("--searchUser"), is(nullValue()));
        assertThat(argParser.isValid(),is(false));
    }

    @Test
    public void testArgParser_ParseArgs_UnevenArgs() {

        String[] argv = new String[]{"--searchUser"};
        ArgParser argParser = new ArgParser();

        assertThrows(ArgParserException.class, () -> {

            argParser.parse(argv);
        });
    }
}
