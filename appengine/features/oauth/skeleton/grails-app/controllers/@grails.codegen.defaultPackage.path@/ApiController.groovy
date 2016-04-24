package @grails.codegen.defaultPackage@

import org.springframework.security.access.annotation.Secured
import grails.rest.*
import grails.converters.*

class ApiController {

    def index() { }

    def springSecurityService

    @Secured('ROLE_USER')
    def username(){
        [
                username : springSecurityService?.principal?.username,
                roles : springSecurityService?.principal?.authorities
        ]
    }
}
