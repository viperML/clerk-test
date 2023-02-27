(ns run)
(require '[nextjournal.clerk :as clerk])

;; start Clerk's built-in webserver on the default port 7777, opening the browser when done
(clerk/serve! {
               :browse? true
               :watch-paths ["notebooks" "src"]})

(clerk/show! "notebooks/main.clj")
;; either call `clerk/show!` explicitly
;; (clerk/show! "src/notebook.clj")

(defn -main [])
