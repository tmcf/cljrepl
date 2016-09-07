(defproject errigal751/cljrepl "0.1.0"
  :description "Convenience wrapper to launch nrepl from Java"
  :url "http://github.com/tmcf/cljrepl"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/tools.nrepl "0.2.11"]]
  :aot [errigal751.cljrepl.core])
