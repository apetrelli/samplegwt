#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.module.client.mvp.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * Place for Welcome.
 */
public class ListPersonsPlace extends Place {
	
	/**
	 * Implementation of Tokenizer for this class.
	 */
	public static class Tokenizer implements PlaceTokenizer<ListPersonsPlace> {

		@Override
		public ListPersonsPlace getPlace(String token) {
			return new ListPersonsPlace();
		}

		@Override
		public String getToken(ListPersonsPlace place) {
			return "";
		}
		
	}

}
