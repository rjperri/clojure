(ns codewars.the-shell-game)

(defn swapum-ball [pos [a b]]
  (cond
    (= pos a) b
    (= pos b) a
    :else pos))

(defn find-the-ball
  [pos swaps]
  (reduce swapum-ball pos swaps))



(find-the-ball 5 []) ;; 5
(find-the-ball 0 [[0 1] [2 1] [0 1]]) ;; 2
