(ns coordinate-transformation)

(defn translate2d 
  [dx dy]
    (fn [lx ly]
      [(+ dx lx) (+ dy ly)]))

(defn scale2d 
  [sx sy]
    (fn [lx ly]
      [(* sx lx) (* sy ly)]))

(defn compose-transform
  [f g]
    (fn [x y]
      (apply g (f x y))))
    

(def ts2d (translate2d 2 0))
(def sc2d (scale2d 2 2))
(def cmp (compose-transform ts2d sc2d))
(def res (cmp 0 1))
res

(defn memoize-transform
  [f]
    (let [memo (atom {
                      :x nil 
                      :y nil 
                      :res nil})]
      (fn [x y]
        (if (and
              (= x (:x @memo))
              (= y (:y @memo)))
          (:res @memo)
            (let [res (f x y)]
              (reset! memo {:x x :y y :res res})
              res)))))
        
