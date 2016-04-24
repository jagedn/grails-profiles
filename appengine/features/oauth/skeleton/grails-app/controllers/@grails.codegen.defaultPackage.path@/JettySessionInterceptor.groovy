package @grails.codegen.defaultPackage@

import javax.servlet.http.HttpSession

/**
 * Created by jorge on 20/04/16.
 */
class JettySessionInterceptor {

    JettySessionInterceptor(){
        matchAll().excludes(controller: 'ah')
    }

    void afterView() {
        try {
            HttpSession httpSession = request.session as HttpSession
            httpSession.save()
        }catch(e){

        }
    }

}
