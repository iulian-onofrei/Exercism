(ns annalyns-infiltration)

(def knight-awake? true)

(defn can-fast-attack?
  [knight-awake?]
    (not knight-awake?))

(defn can-spy?
  [knight-awake? archer-awake? prisoner-awake?]
    (or knight-awake? archer-awake? prisoner-awake?))

(defn can-signal-prisoner?
  [archer-awake? prisoner-awake?]
    (and (not archer-awake?) prisoner-awake?))

(defn can-free-prisoner?
  [knight-awake? archer-awake? prisoner-awake? dog-present?]
    (or 
      (and (not archer-awake?) dog-present?)
      (and prisoner-awake? (not knight-awake?) (not archer-awake?))))
