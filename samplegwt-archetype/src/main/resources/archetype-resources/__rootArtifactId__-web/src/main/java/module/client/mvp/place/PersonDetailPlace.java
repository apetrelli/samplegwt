#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.module.client.mvp.place;

import com.github.utilgwt.web.shared.StringUtils;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * Place for Welcome.
 */
public class PersonDetailPlace extends Place {
	
	private Long id;
	
	public PersonDetailPlace() {
		this(null);
	}
	
	public PersonDetailPlace(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	/**
	 * Implementation of Tokenizer for this class.
	 */
	public static class Tokenizer implements PlaceTokenizer<PersonDetailPlace> {

		@Override
		public PersonDetailPlace getPlace(String token) {
			Long id = null;
			if (!StringUtils.isBlank(token)) {
				id = Long.decode(token);
			}
			return new PersonDetailPlace(id);
		}

		@Override
		public String getToken(PersonDetailPlace place) {
			return place.id != null ? place.id.toString() : "";
		}
		
	}

}
