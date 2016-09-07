; Wrapped convenience methods for starting and stopping an nrepl
; from java in a java app
;

(ns errigal751.cljrepl.core
  (:require [clojure.tools.nrepl.server :as nrserver]))

; Java interop to start and stop an nrepl server
;; import errigal751.cljrepl.NRepl;
;; NRepl.startServer("localhost", 9453)
;; NRepl.stopServer();
;;
;; NRepl.startServerEnv();
(gen-class
  :name errigal751.cljrepl.NRepl
  :prefix "cljrepl-"
  :methods [^:static [startServer [String Object] void]
            ^:static [stopServer [] void]])

(def server nil)

(defn cljrepl-stopServer
  "Stop nrepl server if it is running."
  []
  (alter-var-root
    #'server
    (fn [oserver]
      (when oserver (nrserver/stop-server oserver))
      nil)))

(defn cljrepl-startServer
  "Start nrepl server on specified bindhost and port.
   Stop existing nrepl server first if any."
  [bindhost port]
  (alter-var-root
    #'server
    (fn [oserver]
      (let [bindhost (or bindhost "localhost")
            port (cond (instance? Long port) port
                       (instance? Integer port) (Long/valueOf port)
                       (instance? String port) (Long/valueOf port)
                       :default 9999)]
        (when oserver (nrserver/stop-server oserver))
        (nrserver/start-server :bind bindhost :port port)))))






