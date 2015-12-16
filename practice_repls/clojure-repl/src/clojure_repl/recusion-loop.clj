;; recursion & looping
;;factorial
(defn fac
  "Factorial function"
  [x]
  (if (= x 0)
    1
    (* x (fac (- x 1)))))
(fac 5)

(defn fac_tail
  "Factorial function using tail recursion"
  ([x] (fac_tail (- x 1) x))
  ([x y]
   (if (= x 0)
    y
    (fac_tail (- x 1) (* y x)))))
(fac_tail 5)

(defn fac_recur
  "Factorial function using recur"
  ([x] (fac_recur x (dec x)))
  ([current x]
   (if (= x 0)
     current
     (recur (* x current) (dec x)))))
(fac_recur 5)

(defn fac_loop
  "Factorial function using loop"
  [x]
  (loop [current x
         count (dec x)]
    (if (= count 0)
      current
      (recur (* current count) (dec count)))))
(fac_loop 5)

(defn fac_reduce
  "Factorial using reduce"
  [x]
  (reduce * x (drop 1 (range x))))
(fac_reduce 5)

(defn fac_reduce_thread
  "Factorial using reduce"
  [x]
  (->> x
       (range)
       (drop 1)
       (reduce * x)))
(fac_reduce_thread 5)


