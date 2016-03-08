(ns codewars.affinity)

(defn vector-affinity
  [a b]
  (let [max-sz (max (count a) (count b))]
    (if (zero? max-sz)
      1.0
      (float (/ (count (filter true? (map #(= %1 %2) a b))) max-sz)))))



(max 4 4)
(/ 3 4)
(true? true)

(count (filter true? (map #(= %1 %2) [1 2 3] [1 3 4 9  8 9])))

(vector-affinity [1 2 3 4] [1 2 3 5]);; 0.75))
(vector-affinity [] [1 2 3 4 5]);; 0.0))
(vector-affinity [6 6 6 6 6 6] [6 nil nil 6 6 nil]);; (float (/ 3 6))))
(vector-affinity [6 6 6 6 6 6] [6]);; (float (/ 1 6)))))
(vector-affinity [] []) ;; 1.0
