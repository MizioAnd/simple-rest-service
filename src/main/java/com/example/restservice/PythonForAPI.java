package com.example.restservice;

import org.python.util.PythonInterpreter;

// import org.junit.Test;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.List;
import java.util.stream.Collectors;

public class PythonForAPI{

    // public PythonForAPI() {}

    // public String pythonWrapper() {
    //     try (PythonInterpreter pyInterp = new PythonInterpreter()) {
    //         StringWriter output = new StringWriter();
    //         pyInterp.setOut(output);

    //         pyInterp.exec("print('hello from python')");
    //         return output.toString(); 
    //     }
    // }

    // @Test
    public String givenPythonScript_whenPythonProcessInvoked_thenSuccess() throws Exception {
        ProcessBuilder processBuilder = new ProcessBuilder("python", resolvePythonScriptPath("hello.py"));
        processBuilder.redirectErrorStream(true);

        Process process = processBuilder.start();
        List<String> results = readProcessOutput(process.getInputStream());

        System.out.println(results);

        return results.toString();
        // assertThat("Results should not be empty", results, is(not(empty())));
        // assertThat("Results should contain output of script: ", results, hasItem(
        //   containsString("Hello Baeldung Readers!!")));

        // int exitCode = process.waitFor();
        // assertEquals("No errors should be detected", 0, exitCode);
    }

    private List<String> readProcessOutput(InputStream inputStream) throws IOException {
        try (BufferedReader output = new BufferedReader(new InputStreamReader(inputStream))) {
            return output.lines()
                .collect(Collectors.toList());
        }
    }

    private String resolvePythonScriptPath(String filename) {
        File file = new File("src/test/resources/" + filename);
        return file.getAbsolutePath();
    }
}