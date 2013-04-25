package it.pkg.module.client.mvp.activity;

import java.util.List;

import it.pkg.module.client.ClientFactory;
import it.pkg.module.client.requestfactory.ApplicationRequestFactory;
import it.pkg.module.client.requestfactory.proxy.PersonProxy;
import it.pkg.module.client.ui.ListPersonsView;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.requestfactory.shared.Receiver;

public class ListPersonsActivity extends BaseActivity implements ListPersonsView.Presenter {

	public ListPersonsActivity(ApplicationRequestFactory requestFactory, ClientFactory clientFactory) {
		super(requestFactory, clientFactory);
	}

	@Override
	public void start(final AcceptsOneWidget panel, EventBus eventBus) {
		requestFactory.personRequest().findAllPersons().fire(new Receiver<List<PersonProxy>>() {

			@Override
			public void onSuccess(List<PersonProxy> response) {
				ListPersonsView view = clientFactory.getListPersonsView();
				view.setPresenter(ListPersonsActivity.this);
				view.setPersons(response);
				panel.setWidget(view);
			}
		});
	}
}
