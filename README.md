# grails-profiles
Profiles for Grails framework

- appengine: profile for Google AppEngine flexible environment
```console
  git clone https://github.com/jagedn/grails-profiles
  cd grails-profiles/appengine
  gradle install
  cd ..
  grails create-app test-appengine --profile appengine
  cd test-appengine
  gradle assemble
  cd build/libs
  gcloud preview app deploy
  ```
  
  
