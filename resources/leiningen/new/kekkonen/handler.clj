(ns {{name}}.handler
  (:require [plumbing.core :refer [defnk]]
            [kekkonen.cqrs :refer :all]
            [schema.core :as s]))

(s/defschema Pizza
  {:name s/Str
   (s/optional-key :description) s/Str
   :size (s/enum :S :M :L)
   :origin {:country (s/enum :FI :PO)}})

;;
;; Handlers
;;

(defnk ^:query ping []
  (success {:ping "pong"}))

(defnk ^:command echo-pizza
  "Echoes a pizza"
  {:responses {:default {:schema Pizza}}}
  [data :- Pizza]
  (success data))

(defnk ^:query plus
  "playing with data"
  [[:data x :- s/Int, y :- s/Int]]
  (success (+ x y)))

(defnk ^:command inc!
  "a stateful counter"
  [counter]
  (success (swap! counter inc)))

;;
;; Application
;;

(defnk create [state]
  (cqrs-api
    {:swagger {:ui "/api-docs"
               :spec "/swagger.json"
               :data {:info {:title "Kekkonen {{name}} API"
                             :description "created with http://kekkonen.io"}}}
     :core {:handlers {:pizza #'echo-pizza
                       :math [#'inc! #'plus]
                       :ping #'ping}
            :context state}}))
