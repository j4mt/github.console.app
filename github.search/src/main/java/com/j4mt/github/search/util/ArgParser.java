package com.j4mt.github.search.util;

import java.util.HashMap;
import java.util.Map;

public class ArgParser {

    private final Map<String, String> map = new HashMap<>();;

    public void parse(String... argv) {
        if (argv.length % 2 != 0)
            throw new ArgParserException("In correct number of parameters passed");

        for (int i = 0; i < argv.length - 1; i = i + 2)
            map.put(argv[i], argv[i + 1]);
    }

    public String get(String s) {
        return map.get(s);
    }

    @Override
    public String toString() {
        return String.format("ArgParser{map=%s}", map);
    }
}
