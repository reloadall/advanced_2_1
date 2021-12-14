Authorization: Basic '...'

'...' -> base64('username:password') -> encoded

BasicAuthnFilter -> Authorization: Basic (username:password)
TokenAuthnFilter -> X-Token: ...

authnManager.authentication(new TokenAuthentication(token, null))
authnManager.authentication(new UsernamePasswordAuthentication(username, password))

getCookies

JDK 11-16: 
$ java -XX:StartFlightRecording:filename=m.jfr -version 
$ jfr metadata m.jfr. 

JDK 17, and later: 
$ jfr metadata
