(ns elyses-destructured-enchantments)

(defn first-card
  [deck]
    (let [[frst] deck]
      frst))

(defn second-card
  [deck]
    (let [[_ scnd] deck]
      scnd))

(defn swap-top-two-cards
  [deck]
    (let [[frst scnd & rst] deck]
      (into [] (concat [scnd frst] rst))))

(defn discard-top-card
  [deck]
    (let [[frst & rst] deck]
      [frst rst]))

(def face-cards
  ["jack" "queen" "king"])

(defn insert-face-cards
  [deck]
    (let [[frst & rst] deck]
      (into [] (remove nil?
                 (concat [frst] face-cards rst)))))
