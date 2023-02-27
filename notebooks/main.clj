;; # Bienvenido
(ns main)

(require '[meta-csv.core :as csv])
(require '[nextjournal.clerk :as clerk])


(def parsed (csv/read-csv "./execution_1_parsed.csv"))

(clerk/table parsed)
