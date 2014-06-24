#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.module.server.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class SampleUserDetailsService implements UserDetailsService, AuthenticationUserDetailsService<Authentication>{

    @Override
    public UserDetails loadUserDetails(Authentication token)
            throws UsernameNotFoundException {
        return loadUserByUsername(token.getName());
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        List<SampleAuthority> authorities = new ArrayList<SampleAuthority>();
        if ("reader".equals(username)) {
            authorities.add(SampleAuthority.READER);
        } else if ("writer".equals(username)) {
            authorities.add(SampleAuthority.WRITER);
        } else {
            throw new UsernameNotFoundException(username);
        }
        return new SimpleUserDetails(username, authorities);
    }
}
