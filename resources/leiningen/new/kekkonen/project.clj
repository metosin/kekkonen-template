(defproject {{name}} "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [http-kit "2.1.19"]
                 [com.stuartsierra/component "0.3.0"]
                 [org.danielsz/system "0.1.9"]
                 [metosin/kekkonen "0.1.0-SNAPSHOT"]]
  :profiles {:dev {:dependencies [[reloaded.repl "0.2.0"]]}
       	     :uberjar {:aot [{{name}}.main]
                       :main {{name}}.main
                       :uberjar-name "{{name}}.jar"}})
