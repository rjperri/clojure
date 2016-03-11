(ns codewars.product-of-fib)

(defn product-fib [prod]
  ; your code
  nil)

(defn fib [n]
  (cond
    (zero? n) 0
    (= 1 n) 1
    :else (+ (fib (dec n)) (fib (- n 2)))))

(fib 2)
(fib 2)
(fib 3)
(fibm 3)

(cons 1 ())

(* (bigint 4) (bigint 4))

(defn neg-range
  ([] (neg-range 0))
  ([n]
   (lazy-seq (cons n (neg-range (dec n))))))

(nth (neg-range) 129384098)


(defn fib-array
  ([] (fib-array (bigint 0) 1))
  ([a b]
    (lazy-seq (cons a (fib-array b (+ b a))))))



(nth (fib-array) 100)

(nth '(1 2 3 4) 1)

(defn product-fib [prod]
  (loop [prev (bigint 0) cur (bigint 1)]
    (let [mult (* cur prev)]
      (cond
        (= prod mult) [prev cur true]
        (< prod mult) [prev cur false]
        :else (recur cur (+ prev cur))))))

(product-fib 4895) ;; [55N 89N true]
(product-fib 5895) ;; [89, 144, false]

