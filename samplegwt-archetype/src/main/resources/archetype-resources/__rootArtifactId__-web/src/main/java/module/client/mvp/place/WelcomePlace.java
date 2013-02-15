#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.module.client.mvp.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * Place for Welcome.
 */
public class WelcomePlace extends Place {
	
	/**
	 * Implementation of Tokenizer for this class.
	 */
	public static class Tokenizer implements PlaceTokenizer<WelcomePlace> {

		@Override
		public WelcomePlace getPlace(String token) {
			return new WelcomePlace();
		}

		@Override
		public String getToken(WelcomePlace place) {
			return "";
		}
		
	}

}
