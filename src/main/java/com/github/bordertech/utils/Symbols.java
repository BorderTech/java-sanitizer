package com.github.bordertech.utils;

import org.apache.commons.lang3.text.translate.CharSequenceTranslator;
import org.apache.commons.lang3.text.translate.LookupTranslator;


/**
 * @author Rick Brown on 2017-06-08.
 */
public final class Symbols {

	/**
	 * Used to substitute commonly encountered "symbols" with ascii representations.
	 */
	private static final CharSequenceTranslator SYMBOLS = new LookupTranslator(
		new String[][]{
			{"\u201C", "\""},  // LEFT DOUBLE QUOTATION MARK
			{"\u201D", "\""},  // RIGHT DOUBLE QUOTATION MARK
			{"\u201E", "\""},  // DOUBLE LOW-9 QUOTATION MARK
			{"\u201F", "\""},  // DOUBLE HIGH-REVERSED-9 QUOTATION MARK
			{"\u2018", "'"},  // LEFT SINGLE QUOTATION MARK
			{"\u2019", "'"},  // RIGHT SINGLE QUOTATION MARK
			{"\u201A", "'"},  // SINGLE LOW-9 QUOTATION MARK
			{"\u201B", "'"},  // SINGLE HIGH-REVERSED-9 QUOTATION MARK
			{"\u2013", "-"},  // EN DASH
			{"\u2014", "-"},  // EM DASH
			{"\u2024", "."},  // ONE DOT LEADER
			{"\u2025", ".."},  // TWO DOT LEADER
			{"\u2026", "..."},  // HORIZONTAL ELLIPSIS
			{"\u00BD", "1/2"},  // VULGAR FRACTION ONE HALF
			{"\u00BC", "1/4"},  // VULGAR FRACTION ONE QUARTER
			{"\u00BE", "3/4"},  // VULGAR FRACTION THREE QUARTERS
			{"\u00A9", "(C)"},  // COPYRIGHT SIGN
			{"\u00AE", "(R)"},  // REGISTERED SIGN
			{"\u2122", "(TM)"},  // TRADE MARK SIGN
			{"\u02C6", "^"},  // MODIFIER LETTER CIRCUMFLEX ACCENT
			{"\u2039", "<"},  // SINGLE LEFT-POINTING ANGLE QUOTATION MARK
			{"\u203A", ">"},  // SINGLE RIGHT-POINTING ANGLE QUOTATION MARK
			{"\u02DC", "~"},  // SMALL TILDE
			{"\u00A0", " "},  // NO-BREAK SPACE
			{"\u1680", " "},  // OGHAM SPACE MARK
			{"\u180E", ""},  // MONGOLIAN VOWEL SEPARATOR
			{"\u2000", " "},  // EN QUAD
			{"\u2001", " "},  // EM QUAD
			{"\u2002", " "},  // EN SPACE
			{"\u2003", " "},  // EM SPACE
			{"\u2004", " "},  // THREE-PER-EM SPACE
			{"\u2005", " "},  // FOUR-PER-EM SPACE
			{"\u2006", " "},  // SIX-PER-EM SPACE
			{"\u2007", " "},  // FIGURE SPACE
			{"\u2008", " "},  // PUNCTUATION SPACE
			{"\u2009", " "},  // THIN SPACE
			{"\u200A", " "},  // HAIR SPACE
			{"\u200B", ""},  // ZERO WIDTH SPACE
			{"\u202F", " "},  // NARROW NO-BREAK SPACE
			{"\u205F", " "},  // MEDIUM MATHEMATICAL SPACE
			{"\u3000", " "},  // IDEOGRAPHIC SPACE
			{"\uFEFF", ""},  // ZERO WIDTH NO-BREAK SPACE
			{"\uff08", "("},  // FULLWIDTH LEFT PARENTHESIS
			{"\uff09", ")"},  // FULLWIDTH RIGHT PARENTHESIS
			{"\uff3b", "["},  // FULLWIDTH LEFT SQUARE BRACKET
			{"\uff3d", "]"},  // FULLWIDTH RIGHT SQUARE BRACKET
			{"\uff5b", "{"},  // FULLWIDTH LEFT CURLY BRACKET
			{"\uff5d", "}"},  // FULLWIDTH RIGHT CURLY BRACKET
			{"\uff5f", "("},  // FULLWIDTH LEFT WHITE PARENTHESIS
			{"\uff60", ")"}  // FULLWIDTH RIGHT WHITE PARENTHESIS
		});

	/**
	 * Prevent instantiation of static utility class.
	 */
	private Symbols() {

	}

	/**
	 * Special symbols in user input will be substituted for plain ascii characters.
	 *
	 * The most common scenario is sanitizing user input which has been copied and pasted from Microsoft Word
	 * before being passed to a system that was either built or configured in the 1980s \uD83D\uDE1B.
	 *
	 * Note: some input characters will be replaced with MULTIPLE output characters (e.g. ellipsis).
	 *
	 * Warning: you should perform any escape or encode routines AFTER calling this method.
	 *
	 * @param input The input text to asciify.
	 * @return The input text, asciified.
	 */
	public static String asciifySymbol(final String input) {
		if (input == null || input.length() == 0) {
			return input;
		}
		return SYMBOLS.translate(input);
	}
}
