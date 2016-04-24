package @grails.codegen.defaultPackage@

import groovy.transform.Canonical
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Canonical
class GCloudUserDetails implements UserDetails{

    String password
    String username
    boolean accountNonExpired = true
    boolean accountNonLocked = true
    boolean credentialsNonExpired = true
    boolean enabled = true
    Collection<? extends GrantedAuthority> authorities = [

    ]

}
