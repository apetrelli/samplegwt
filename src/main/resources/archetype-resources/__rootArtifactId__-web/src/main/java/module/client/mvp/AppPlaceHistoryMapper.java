#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.module.client.mvp;

import ${package}.module.client.mvp.place.ListPersonsPlace;
import ${package}.module.client.mvp.place.PersonDetailPlace;
import ${package}.module.client.mvp.place.WelcomePlace;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

/**
 * Mapping all Tokenizer of places.
 *
 */
@WithTokenizers({ WelcomePlace.Tokenizer.class, ListPersonsPlace.Tokenizer.class, PersonDetailPlace.Tokenizer.class})
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {

}
