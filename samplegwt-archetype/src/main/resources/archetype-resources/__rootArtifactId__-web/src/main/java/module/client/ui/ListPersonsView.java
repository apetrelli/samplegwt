#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.module.client.ui;

import java.util.List;

import ${package}.module.client.requestfactory.proxy.PersonProxy;
import com.github.apetrelli.gwtintegration.web.client.ui.MvpView;

public interface ListPersonsView extends MvpView<ListPersonsView.Presenter> {
	
	void setPersons(List<PersonProxy> persons);
	
	public interface Presenter extends MvpView.Presenter {
	}
}
