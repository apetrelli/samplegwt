#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.module.server.security;

import org.springframework.security.core.GrantedAuthority;

public class SampleAuthority implements GrantedAuthority {

	private static final long serialVersionUID = -4504114106906301183L;

	private String authority;
	
	public static final SampleAuthority READER = new SampleAuthority("READER");

	public static final SampleAuthority WRITER = new SampleAuthority("WRITER");

	private SampleAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String getAuthority() {
		return authority;
	}

}
