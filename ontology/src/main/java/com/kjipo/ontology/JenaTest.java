package com.kjipo.ontology;


import com.google.common.collect.Lists;
import org.apache.jena.rdf.model.*;
import org.apache.jena.vocabulary.RDFS;

public class JenaTest {



    private void createOntology() {
        Model model = ModelFactory.createDefaultModel();

        Resource resource = model.createResource();



        String NS = "urn:x-hp-jena:eg/";

// Build a trivial example data set
        Model rdfsExample = ModelFactory.createDefaultModel();
        Property p = rdfsExample.createProperty(NS, "p");
        Property q = rdfsExample.createProperty(NS, "q");
        rdfsExample.add(p, RDFS.subPropertyOf, q);
        rdfsExample.createResource(NS+"a").addProperty(p, "foo");


        InfModel inf = ModelFactory.createRDFSModel(rdfsExample);  // [1]


        Resource a = inf.getResource(NS+"a");
        System.out.println("Statement: " + a.getProperty(q));














    }



    public static void main(String args[]) {
        JenaTest jenaTest = new JenaTest();

        jenaTest.createOntology();




    }





}
