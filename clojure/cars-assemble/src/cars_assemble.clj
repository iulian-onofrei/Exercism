(ns cars-assemble)

(def items-per-hour 221)

(defn production-rate [speed]
  (cond (and (>= speed 1) (<= speed 4)) (* 221 speed) 
        (and (>= speed 5) (<= speed 8)) (* 0.9 (* 221 speed)) 
        (= speed 9) (* 0.8 (* 221 speed))
        (= speed 10) (* 0.77 (* 221 speed))
        :else 0)
  )

(defn working-items [speed]
  (int (/ (production-rate speed) 60)))
