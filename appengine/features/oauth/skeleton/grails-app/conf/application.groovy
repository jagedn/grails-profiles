
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
        [pattern: '/',               access: ['permitAll']],
        [pattern: '/error',          access: ['permitAll']],
        [pattern: '/index',          access: ['permitAll']],
        [pattern: '/index.gsp',      access: ['permitAll']],
        [pattern: '/shutdown',       access: ['permitAll']],
        [pattern: '/assets/**',      access: ['permitAll']],
        [pattern: '/**/js/**',       access: ['permitAll']],
        [pattern: '/**/css/**',      access: ['permitAll']],
        [pattern: '/**/images/**',   access: ['permitAll']],
        [pattern: '/**/favicon.ico', access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
        //Stateless chain
        [
                pattern: '/api/**',
                filters: 'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter,-rememberMeAuthenticationFilter'
        ],

        //Traditional, stateful chain
        [
                pattern: '/stateful/**',
                filters: 'JOINED_FILTERS,-restTokenValidationFilter,-restExceptionTranslationFilter'
        ]
]

grails {
        plugin {
                springsecurity {
                        rest {
                                oauth {
                                        frontendCallbackUrl = { String tokenValue ->
                                                String host = System.getenv('serverURL') ?: 'http://localhost:8080'
                                                "$host/#?token=${tokenValue}"
                                        }
                                        google {
                                                client = org.pac4j.oauth.client.Google2Client
                                                key = System.getenv('googleKey')
                                                secret = System.getenv('googleSecret')
                                                scope = org.pac4j.oauth.client.Google2Client.Google2Scope.EMAIL_AND_PROFILE
                                                defaultRoles = ['ROLE_USER', 'ROLE_GOOGLE']
                                        }
                                }
                        }
                }
        }
}
