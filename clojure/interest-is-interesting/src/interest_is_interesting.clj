(ns interest-is-interesting)

(defn interest-rate
  [balance]
  (cond 
    (< balance 0) -3.213
    (< balance 1000) 0.5
    (< balance 5000) 1.621
    :else 2.475))

(defn annual-balance-update
  [balance]
    (+ balance 
      (* 
        1/100
        balance
        (bigdec (Math/abs (interest-rate balance))))))

(defn amount-to-donate
  [balance tax-free-percentage]
    (if (not (neg? balance))
      (int (* 2 balance (/ tax-free-percentage 100))) 
      0))
