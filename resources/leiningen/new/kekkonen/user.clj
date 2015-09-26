(ns user
  (:require [reloaded.repl :refer [system init start stop go reset]]
            [{{name}}.system :refer [new-system]]))

(reloaded.repl/set-init! #(new-system {:port 3000}))