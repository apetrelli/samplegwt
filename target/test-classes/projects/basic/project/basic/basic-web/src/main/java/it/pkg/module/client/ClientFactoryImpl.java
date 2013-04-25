package it.pkg.module.client;

import it.pkg.module.client.ui.ListPersonsView;
import it.pkg.module.client.ui.PersonDetailView;
import it.pkg.module.client.ui.basicmoduleTemplate;
import it.pkg.module.client.ui.WelcomeView;
import it.pkg.module.client.ui.impl.ListPersonsViewImpl;
import it.pkg.module.client.ui.impl.PersonDetailViewImpl;
import it.pkg.module.client.ui.impl.WelcomeViewImpl;
import com.github.apetrelli.gwtintegration.mvp.client.ui.HasBody;
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
		template = new basicmoduleTemplate();
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
