;; # Bienvenido
(ns main
  (:require [nextjournal.clerk :as clerk]))

(require '[meta-csv.core :as csv])
(require '[nextjournal.clerk :as clerk])


(def parsed (csv/read-csv "./execution_1_parsed.csv"))

(def data (->> parsed
               (map #(sorted-map :id (get % :FunctionId)
                                 :duration (get % :FunctionDuration)
                                 :delay (get % :InvocationDelay)))))

(clerk/table data)

(clerk/vl
 {:data {:values data}
  :width 500
  :height 500
  :mark {:type "point"}
  :encoding {:x {:field :id
                  :type "quantitative"}
              :y {:field :duration
                  :type "quantitative"}}})
