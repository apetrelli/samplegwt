#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.module.client.ui.impl;

import ${package}.module.client.ui.WelcomeView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 * Unique implementation of view welcome.
 * Define and management the element of page.
 *
 */
public class WelcomeViewImpl extends Composite implements WelcomeView {
	
	private static WelcomeViewImplUiBinder uiBinder = GWT
			.create(WelcomeViewImplUiBinder.class);

	/**
	 * Bridge to view and UiBinder xml.
	 *
	 */
	interface WelcomeViewImplUiBinder extends UiBinder<Widget, WelcomeViewImpl> {
	}

	/**
	 * Constructor.
	 */
	public WelcomeViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@Override
	public void setPresenter(Presenter presenter) {
		// Does nothing for the moment.
	}
}
