(ns run)
(require '[nextjournal.clerk :as clerk])

(defn -main []
  (clerk/serve! {:watch-paths ["notebooks" "src"]})
  (clerk/show! "notebooks/main.clj"))
