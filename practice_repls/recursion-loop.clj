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