(defproject {{name}} "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [http-kit "2.1.19"]
                 [com.stuartsierra/component "0.3.0"]
                 [reloaded.repl "0.2.1"]
                 [metosin/palikka "0.3.0"]
                 [metosin/kekkonen "0.1.0-SNAPSHOT"]]
  :profiles {:uberjar {:aot [{{name}}.main]
                       :main {{name}}.main
                       :uberjar-name "{{name}}.jar"}})
