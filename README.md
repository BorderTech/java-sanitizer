# java-sanitizer

Java utilities to perform common sanitization tasks on (user) input, e.g. translate "special symbols" to plain ascii characters.

The most common intended use case is sanitizing input which has been copied and pasted from Microsoft Word before being passed to a system architected in the second millenium of the Common Era.

## Status

[![javadoc.io](https://javadoc.io/badge2/com.github.bordertech.sanitizer/sanitizer/javadoc.io.svg)](https://javadoc.io/doc/com.github.bordertech.sanitizer/sanitizer)
[![Build Status](https://travis-ci.com/BorderTech/java-sanitizer.svg?branch=master)](https://travis-ci.com/BorderTech/java-sanitizer)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/328a4c7e60104557a442a456e7e7e33e)](https://www.codacy.com/app/BorderTech/java-sanitizer?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=BorderTech/java-sanitizer&amp;utm_campaign=Badge_Grade)

## Usage

In your pom.xml:

```xml
<dependency>
  <groupId>com.github.bordertech.sanitizer</groupId>
  <artifactId>sanitizer</artifactId>
  <version>1.0.1</version>
</dependency>
```

Example usage:

```java
String in = "Glass \u00BD full. \u00BC + \u00BE = 1";
System.out.println(Symbols.asciifySymbol(in));
// prints "Glass 1/2 full. 1/4 + 3/4 = 1"
```

See the unit tests for more examples: [SymbolsTest.java](src/test/java/com/github/bordertech/utils/SymbolsTest.java)

## Building

If you wish to build this project you will need [Apache Maven](https://maven.apache.org/) installed.

Run these commands to fetch the source and build:

1. `git clone https://github.com/bordertech/java-sanitizer.git`
2. `cd java-sanitizer`
3. `mvn install`
