;; # Bienvenido
(ns main
  (:require clojure.set
            [meta-csv.core :as csv]))

(require '[meta-csv.core :as csv])
(require '[nextjournal.clerk :as clerk])


(defn parse-data [data, origin] (->> data
                                     (csv/read-csv)
                                     (map #(sorted-map :id (get % :FunctionId)
                                                       :duration (get % :FunctionDuration)
                                                       :delay (get % :InvocationDelay)
                                                       :origin origin))))

(def aws (parse-data "./execution_1_parsed.csv", :aws))
(def ibm (parse-data "./execution_2_parsed.csv", :ibm))

(def data (concat aws ibm))

(clerk/vl
 {:data {:values data}
  :width 500
  :height 500
  :mark {:type "point"
         :clip true}
  :encoding {:x {:field :id
                 :type "quantitative"
                 :scale {:domain [0 400]}}
             :y {:field :duration
                 :type "quantitative"}
             :color {:field :origin}}})
