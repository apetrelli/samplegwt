#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.module.client.i18n;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.i18n.client.Messages;

public interface MainMessages extends Messages {

	public static final MainMessages INSTANCE = GWT.create(MainMessages.class);
	
	String title();
	
	String welcomeText();
	
	String persons();
	
	String footer();
	
	String add();
	
	String save();
	
	String delete();
	
	String personalTitle();
	
	String firstName();
	
	String lastName();
	
	String birthDate();
	
	String annualIncome();
}
