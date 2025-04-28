(ns card-games)

(defn rounds
  [n]
  (let [[next-one next-two] [(inc n) (+ n 2)]]
`(~n ~next-one ~next-two)))

(defn concat-rounds 
  [l1 l2]
  (concat l1 l2))

(defn contains-round? 
  [l n]
  (.contains l n))

(defn card-average
  [hand]
  (double (/ (reduce + hand) (count hand))))

(defn median
  [hand]
  (double (nth hand (quot (count hand) 2))))

(defn frst-lst-avg
  [l]
    (double (/ (+ (first l) (last l)) 2)))

(defn approx-average?
  [hand]
  (let [avg (card-average hand)]
    (or
      (= avg (median hand))
      (= avg (frst-lst-avg hand)))))

(defn odd-index
  [l]
  (take-nth 2 (rest l)))

(defn even-index
  [l]
  (take-nth 2 l))

(defn average-even-odd?
  [hand]
  (=
    (card-average (odd-index hand))
    (card-average (even-index hand))))

(defn maybe-double-last
  [hand]
  (if
    (= 11 (last hand))
    (concat (drop-last hand) '(22))
    hand))
