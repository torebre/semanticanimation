package com.kjipo.mathml3;

import org.junit.Test;

import javax.xml.bind.*;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.stream.Collectors;

public class ParseMathMlTest {

    @Test
    public void parseTest() throws JAXBException {
        String testData = "<math><msqrt><mn>2</mn></msqrt><msqrt><mn>2</mn></msqrt><msqrt><mn>2</mn><mi id=\"1\">y</mi></msqrt></math>";

        JAXBContext jaxbContext = JAXBContext.newInstance("com.kjipo.mathml3");
//        Marshaller marshaller = jaxbContext.createMarshaller();
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        InputStream inputStream = new ByteArrayInputStream(testData.getBytes(StandardCharsets.UTF_8));
        Source schemaSource = new StreamSource(inputStream);

        Math mathData = unmarshaller.unmarshal(schemaSource, Math.class).getValue();

        System.out.println("Unmarshalled object: " + mathData);
        System.out.println("Data: " + mathData.getChildren());
    }


    @Test
    public void writeEquationTest() throws JAXBException, IOException, InterruptedException {
        Math math = new Math();

        Mi mi = new Mi();
        mi.setvalue("a");
        mi.setId("1");

        math.getChildren().add(mi);

        JAXBContext jaxbContext = JAXBContext.newInstance("com.kjipo.mathml3");
        Marshaller marshaller = jaxbContext.createMarshaller();

        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(math, stringWriter);

        System.out.println("Result: " + stringWriter);

        String mathMlData = stringWriter.toString().substring(stringWriter.toString().indexOf("<math>"));

        // export NODE_PATH=/home/student/.nvm/versions/node/v8.9.4/lib/node_modules
        ///home/student/.nvm/versions/node/v8.9.4/bin/node testFormula.js > equation_svg.svg
        Path equationFile = Files.createTempFile("equation", ".svg");


        String script = String.format("var mjAPI = require(\"mathjax-node\");\n" +
                "mjAPI.config({\n" +
                "    MathJax: {\n" +
                "        // traditional MathJax configuration\n" +
                "    }\n" +
                "});\n" +
                "mjAPI.start();\n" +
                "\n" +
                "var yourMath = \"%s\";\n" +
                "mjAPI.typeset({\n" +
                "    math: yourMath,\n" +
                "    format: \"MathML\"," +
                "    svg:true\n" +
                "}, function (data) {\n" +
                "    if (!data.errors) {console.log(data.svg)}\n" +
                "});", mathMlData.replace("\"", "\\\""));

        Files.write(equationFile, script.getBytes(StandardCharsets.UTF_8), StandardOpenOption.TRUNCATE_EXISTING);

        ProcessBuilder processBuilder = new ProcessBuilder("/home/student/.nvm/versions/node/v8.9.4/bin/node", equationFile.toAbsolutePath().toString());
        Map<String, String> environment = processBuilder.environment();
        environment.put("NODE_PATH", "/home/student/.nvm/versions/node/v8.9.4/lib/node_modules");
        Process start = processBuilder.start();


        start.waitFor();

        String output;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(start.getInputStream()))) {
            output = bufferedReader.lines().collect(Collectors.joining("\n"));
        }

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(start.getErrorStream()))) {
            bufferedReader.lines().forEach(System.err::println);
        }

        System.out.println("Output: " + output);

    }


}
