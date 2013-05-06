#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.module.client.util;

import java.math.BigDecimal;

import com.github.apetrelli.gwtintegration.editor.client.text.BigDecimalParser;
import com.github.apetrelli.gwtintegration.editor.client.text.NumberFormatRenderer;
import com.github.apetrelli.gwtintegration.editor.client.widget.ValueDateBox;
import com.github.apetrelli.gwtintegration.editor.client.widget.ValueDateBox.ParsingFormat;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.text.shared.Parser;
import com.google.gwt.text.shared.Renderer;

public class ViewUtils {
	
	private static DateTimeFormat dateFormat = DateTimeFormat.getFormat("dd/MM/yyyy");

	private static ParsingFormat dateFormatForDateBox = new ValueDateBox.DefaultParsingFormat(dateFormat); 
	
	private static NumberFormat moneyFormat = NumberFormat.getFormat("${symbol_pound}0.00");
	
	private static Renderer<BigDecimal> moneyRenderer = new NumberFormatRenderer<BigDecimal>(moneyFormat);

	private static Parser<BigDecimal> moneyParser = BigDecimalParser.instance();
	
	private ViewUtils() {}
	
	public static DateTimeFormat getDateFormat() {
		return dateFormat;
	}
	
	public static ParsingFormat getDateFormatForDateBox() {
		return dateFormatForDateBox;
	}
	
	public static NumberFormat getMoneyFormat() {
		return moneyFormat;
	}
	
	public static Parser<BigDecimal> getMoneyParser() {
		return moneyParser;
	}
	
	public static Renderer<BigDecimal> getMoneyRenderer() {
		return moneyRenderer;
	}
}
