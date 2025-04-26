(ns log-levels
  (:require [clojure.string :as str]))

(defn message
  [s]
    (str/trim 
      (str/replace s #".*:" "")))

(defn log-level
  [s]
    (str/lower-case 
      (re-find #"(?<=\[).*(?=\])" s)))

(defn reformat
  [s]
    (str (message s) " (" (log-level s) ")"))
