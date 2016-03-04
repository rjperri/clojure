(ns codewars.revrot)
(require '[clojure.string :as str])

 (+ 1 2 4 5 6 7)

(seq "12345")
(into [] (map #(Character/getNumericValue %) "1234529324892384903093"))


(let [length 6]
  (loop [v (into [] (map #(Character/getNumericValue %) "123456987654")) coll []]
    (if (empty? v)
      coll
      (recur (drop length v) (conj coll (take length v))))))

(defn break-string [strng sz]
  (loop [v (into [] (map #(Character/getNumericValue %) strng)) coll []]
    (if (or (empty? v) (> sz (count v)))
      coll
      (recur (drop sz v) (conj coll (into [] (take sz v)))))))

(break-string "123456987653" 6)

(even? (reduce + (map #(* % % %) [9 8 7 6 5 4])))

(reduce + (map #(* % % %) [9 8 7 6 5 4]))

(map #(* % % %) [9 8 7 6 5 4])

(defn rotate [v]
  (concat (rest v) [(first v)]))

(defn cubetrans [v]
  (if (even? (reduce + (map #(* % % %) v)))
         (reverse v)
         (rotate v)))



(defn revrot [strng sz]
  (let [v (break-string strng sz)]
     (apply str (reduce concat '() (map cubetrans v)))))

(revrot "" 6)


(rotate [1 2 3 4 5 6])

(let [f [1 2 3 4]]
  (concat (rest f) [(first f)]))

(concat '(1 2 3) '(4 5 6))
