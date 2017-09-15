package fr.aberwag.family.exception.local;

import java.util.Locale;

/**
 * Use of a threadLocal variable to store the current locale. The CurrentLocale
 * is used when building FMK exception messages
 *
 * @author Boubker ABERWAG
 */
public class CurrentLocale {

	private static final ThreadLocal<Locale> locale = new ThreadLocal<Locale>() {
	};

	/**
	 * Return the current locale. If current locale has not been set in thread
	 * local, the default Locale.ENGLISH is returned
	 *
	 * @return
	 */
	public static Locale getCurrentLocale() {
		Locale loc = locale.get();
		if (loc == null) {
			loc = Locale.ENGLISH;
		}
		return loc;
	}

	/**
	 * Set the current locale in thread local
	 *
	 * @param loc
	 */
	public static void setCurrentLocale(Locale loc) {
		locale.set(loc);
	}

}