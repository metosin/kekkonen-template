(ns {{name}}.main
  (:require [com.stuartsierra.component :as component]
            [reloaded.repl :refer [set-init! go]])
  (:gen-class))

(defn -main [& [port]]
  (let [port (if port (Integer/parseInt port) 3000)]
    (require '{{name}}.system)
    (set-init! #((resolve '{{name}}.system/new-system) {:port port}))
    (go) (println "server running in port" port)))
