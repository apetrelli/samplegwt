#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.module.client;

import ${package}.module.client.ui.ListPersonsView;
import ${package}.module.client.ui.PersonDetailView;
import ${package}.module.client.ui.${moduleName}Template;
import ${package}.module.client.ui.WelcomeView;
import ${package}.module.client.ui.impl.ListPersonsViewImpl;
import ${package}.module.client.ui.impl.PersonDetailViewImpl;
import ${package}.module.client.ui.impl.WelcomeViewImpl;
import com.github.apetrelli.gwtintegration.web.client.ui.HasBody;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

/**
 * Unique implementation of ClientFactory
 */
public class ClientFactoryImpl implements ClientFactory {
	
	private EventBus eventBus;
	
	private PlaceController placeController;
	
	private HasBody template;
	
	private WelcomeView welcomeView;
	
	private ListPersonsView listPersonsView;
	
	private PersonDetailView personDetailView;
	
	/**
	 * Constructor.
	 */
	public ClientFactoryImpl() {
		eventBus = new SimpleEventBus();
		placeController = new PlaceController(eventBus);
		welcomeView = new WelcomeViewImpl();
		template = new ${moduleName}Template();
		listPersonsView = new ListPersonsViewImpl();
		personDetailView = new PersonDetailViewImpl();
	}
	
	@Override
	public EventBus getEventBus() {
		return eventBus;
	}

	@Override
	public PlaceController getPlaceController() {
		return placeController;
	}
	
	@Override
	public HasBody getTemplate() {
		return template;
	}
	
	@Override
	public WelcomeView getWelcomeView() {
		return welcomeView;
	}
	
	@Override
	public ListPersonsView getListPersonsView() {
		return listPersonsView;
	}
	
	@Override
	public PersonDetailView getPersonDetailView() {
		return personDetailView;
	}
}
