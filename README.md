# errigal751.cljrepl

Convenience wrapper to start a clojure nrepl in a Java application.

This is not really a library, just a complete example of how to do it and package it for use in Java apps.

## Usage

*clojure*: 

Just use the tools.nrepl package directly and not this.

*Java*:

```java

import errigal751.cljrepl.NRepl;
...

// start an NRepl server host port
// If host or port values are null, defaults are applied (localhost, 9999)
// port may either be a String, Integer, or, Long.

// start Server examples
NRepl.startServer(null, null); // defaults localhost:9999
NRepl.startServer("hostname", "9456") // starts nrepl on hostname:9456
NRepl.startServer("hostname", 9456) // starts nrepl on hostname:9456


NRepl.stopServer(); // stop NRepl instance

```

To connect to an nrepl started as above using leiningen:

```
lein repl :connect hostname:9456
```

## Credits
``clojure/tools.nrepl`` as this is nothing more than a 
packaged version of the **Embedding NRepl, starting a server** example in the
``clojure/tools.nrepl`` readme.


## License

Copyright © 2016 Ted McFadden

Distributed under the Eclipse Public License same as ``clojure/tools.nrepl``.


