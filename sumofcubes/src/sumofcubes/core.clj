(ns sumofcubes.core
  (:gen-class))

(defn int-val? [n]
  (zero?  (- n (Math/floor n))))

(defn abs [n]
  (max n (- n)))

(defn float=
  ([x y] (float= x y 0.0001))
  ([x y epsilon]
   (let [scale (if (or (zero? x) (zero? y)) 1 (abs x))]
     (<= (abs (- x y)) (* scale epsilon)))))

(defn newt-sqrt
  ([n] (newt-sqrt n 1e-15))
  ([n epsilon]
   (loop [t (bigdec n)]
     (if (float= t (with-precision 15 (/ n t)) epsilon)
       t
       (recur (with-precision 15 (/ (+ t (/ n t)) 2)))))))

(defn quad-form [n]
  (/ (+ -1 (newt-sqrt (- 1 (* 4 (* -2 (newt-sqrt n)))))) 2))

(defn find-nb1 [m]
  (let [n (quad-form m)]
    (if (int-val? n)
      (bigint n)
      -1)))

(newt-sqrt 4)

(quad-form 100)

(int-val? (quad-form 100))

(Math/floor (quad-form 100))

(= 4 4.0)

(quad-form 36)

(find-nb1 36)
(find-nb1 4183059834009)
(find-nb1 24723578342962) ;; -1
(find-nb1 135440716410000)
(find-nb1 40539911473216)
(find-nb1 10252519345963644753026N) ;; -1

(type 10252519345963644753026N)

(type 4183059834009)

(find-nb 4183059834009)

(quad-form 10252519345963644753026N)



(*' 8)


(defn perfect-square? [n]
  (let [x (bigint(Math/sqrt n))]
    (= (*' x x) n)))

(defn find-nb-sol [m]
 (if (perfect-square? m)
   (->> (bigint m)
        Math/sqrt
        (*' 8)
        (+' 1)
        Math/sqrt
        (+' -1)
        (*' 0.5)
        bigint
   )
   -1)
)

(find-nb-sol 36)
(find-nb-sol 25)
(find-nb-sol 1)
(find-nb-sol 9)
(find-nb-sol 49)

(defn find-nb-sol2 [m]
  ; start from a large n to save time but not to large to stay under the result
  ; the aproximation is good for large but not very large numbers
  (loop [n (bigint (Math/pow m (/ 1.0 3.922)))]
    (let [actual (/ (* n n (+ n 1) (+ n 1)) 4)]
      (cond
        (== actual m) n
        (> actual m) -1
        :else (recur (inc n))))))
(find-nb-sol2 36)
(find-nb-sol2 25)
(find-nb-sol2 10252519345963644753026N)
(find-nb-sol2 4183059834009)


;;New attempt at this

(defn sum-of-cube [n]
  (/ (* (* n (inc n) (* n (inc n)))) 4))

(def mem-cube (memoize sum-of-cube))

(defn find-nba [m]
  (loop [n (bigint (Math/pow m (/ 1.00 3.92)))]
    (let [sum (mem-cube n)]
      (cond
        (== sum m) n
        (> sum m) -1
        :else (recur (inc n))))))

(time (find-nba 36))
(find-nb 25)
(time (find-nba 4183059834009))
(time (find-nba 10252519345963644753026N))












