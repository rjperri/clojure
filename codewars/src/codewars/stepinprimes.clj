(ns codewars.stepinprimes)

(defn is-prime? [n]
  (cond
    (< n 2) false
    (or (= n 2) (= n 3)) true
    (even? n) false
    :else (let [max (Math/sqrt n)]
            (loop [val 3]
              (cond
                (zero? (mod n val)) false
                (> val max) true
                :else (recur (+ 2 val)))))))
(def mem-is-prime? (memoize is-prime?))

(is-prime? 23984570237)

(mod 5 4)

(range 10 (inc 13))

(defn next-prime? [p n]
  (is-prime? (+ p n)))

(defn step [g m n]
  (let [prime-list (filter mem-is-prime? (range m (inc n)))]
    (loop [[prime & rest-prime-list] prime-list]
      (cond
        (nil? prime) nil
        (is-prime? (+ prime g)) [prime (+ prime g)]
        :else (recur rest-prime-list)))))



(time (step 1 3 1000000))

(let [[t & v] []]
  t)
