package @grails.codegen.defaultPackage@

import grails.plugin.springsecurity.rest.token.storage.TokenNotFoundException
import grails.plugin.springsecurity.rest.token.storage.TokenStorageService
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException


class GCloudUserDetailsService implements UserDetailsService{


    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        println "loadUserByUsername $username"
        new GCloudUserDetails(
                username:username,
                password: 'N/A',
                authorities: [ new SimpleGrantedAuthority('ROLE_USER') ]
        )
    }
}
