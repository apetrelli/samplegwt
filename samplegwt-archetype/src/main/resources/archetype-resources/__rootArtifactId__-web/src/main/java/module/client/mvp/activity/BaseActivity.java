#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.module.client.mvp.activity;

import ${package}.module.client.ClientFactory;
import ${package}.module.client.requestfactory.ApplicationRequestFactory;
import com.github.utilgwt.web.client.ui.impl.AbstractPresenter;

public abstract class BaseActivity extends AbstractPresenter {

	protected ApplicationRequestFactory requestFactory;
	protected ClientFactory clientFactory;

	public BaseActivity(ApplicationRequestFactory requestFactory,
			ClientFactory clientFactory) {
		super(clientFactory.getPlaceController());
		this.requestFactory = requestFactory;
		this.clientFactory = clientFactory;
	}

}