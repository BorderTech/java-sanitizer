package com.github.bordertech.utils;

import com.github.bordertech.utils.Symbols;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Rick Brown on 2017-06-08.
 */
public class SymbolsTest {

	@Test
	public void testAsciifySymbol() {
		String in = "\u02C6 hat \u02DC tilde";
		String out = "^ hat ~ tilde";
		Assert.assertEquals("Translate symbols", out, Symbols.asciifySymbol(in));
	}

	@Test
	public void testAsciifySymbolWithQuotes() {
		String in = "\u201Cfancy quotes\u201D and \u201E plus \u201F";
		String out = "\"fancy quotes\" and \" plus \"";
		Assert.assertEquals("Quotes not handled correctly", out, Symbols.asciifySymbol(in));
	}

	@Test
	public void testAsciifySymbolWithSingleQuotes() {
		String in = "\u2018fancy single quotes\u2019 plus \u201A and \u201B";
		String out = "'fancy single quotes' plus ' and '";
		Assert.assertEquals("Single quotes not handled correctly", out, Symbols.asciifySymbol(in));
	}

	@Test
	public void testAsciifySymbolWithNbspDashesAndEllipsis() {
		String in = "\u8230\u2013\u2013\u2013\u8230\u00A0\u8230\u2014\u2014\u2014\u8230";
		String out = "...---... ...---...";
		Assert.assertEquals("ellipsis endash emdash nbsp", out, Symbols.asciifySymbol(in));
	}

	@Test
	public void testAsciifySymbolWithOtherEllipsisAndPeriods() {
		String in = "\u2024 \u2025 \u2026";
		String out = ". .. ...";
		Assert.assertEquals("period double period ellipsis", out, Symbols.asciifySymbol(in));
	}

	@Test
	public void testAsciifySymbolWithFractions() {
		String in = "Glass \u00BD full. \u00BC + \u00BE = 1";
		String out = "Glass 1/2 full. 1/4 + 3/4 = 1";
		Assert.assertEquals("ellipsis endash emdash nbsp", out, Symbols.asciifySymbol(in));
	}

	@Test
	public void testAsciifySymbolWithAngleBrackets() {
		String in = "\u2039script src='malicious.js'\u203A\u2039/script\u203A";
		String out = "<script src='malicious.js'></script>";
		Assert.assertEquals("LT and GT", out, Symbols.asciifySymbol(in));
	}

	@Test
	public void testAsciifySymbolWithMarks() {
		String in = "\u00A9 \u00AE \u2122";
		String out = "(C) (R) (TM)";
		Assert.assertEquals("Translate mark symbols", out, Symbols.asciifySymbol(in));
	}

	@Test
	public void testAsciifyAllTheWhiteSpace() {
		String in = "\u00A0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200A\u202F\u205F\u3000";
		String out = "                ";
		Assert.assertEquals("Translate whitespace symbols", out, Symbols.asciifySymbol(in));
	}

	@Test
	public void testAsciifyAllTheBlancSpace() {
		String in = "\u180E\u200B\uFEFF";
		String out = "";
		Assert.assertEquals("Translate no-space symbols", out, Symbols.asciifySymbol(in));
	}

	@Test
	public void testAsciifyBracketsAndRelated() {
		String in = "\uff08\uff09 \uff3b\uff3d \uff5b\uff5d \uff5f\uff60";
		String out = "() [] {} ()";
		Assert.assertEquals("Translate brackets and related symbols", out, Symbols.asciifySymbol(in));
	}

}
