#!/usr/bin/env bash

export XJC_OPTS=-Djavax.xml.accessExternalSchema=all
xjc -cp lib/jaxb-impl.jar -d ../../java/com/kjipo -disableXmlSecurity
#-b ~/workspace/EarTraining/musicXml/src/main/resources/bindings.xjb ~/workspace/EarTraining/musicXml/src/main/resources/musicxml30/musicxml.xsd

xjc -d ../java/com/kjipo -disableXmlSecurity -b bindings.xjb mathml3/mathml3.xsd