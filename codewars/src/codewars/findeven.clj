(ns codewars.findeven)

(defn find-even-index [arr]
  (loop [pivot 0]
    (if (> pivot (count arr))
      -1
      (let [a (take pivot arr)
            b (drop (inc pivot) arr)]
        (if (= (reduce + a) (reduce + b))
          pivot
          (recur (inc pivot)))))))

(reduce + ())

(take 3 [1 2 3 4 5])
(get [1 2 3 4 5] (dec 3))

(let [v [1,2,3,4,3,2,1]]
  (loop [pivot 0]
    (if (> pivot (count v)) -1
    (let [a (take pivot v) b (drop (inc pivot) v)]
      (if (= (reduce + a) (reduce + b)) pivot
        (recur (inc pivot)))))))



(find-even-index [1,2,3,4,3,2,1]); 3
(find-even-index [1,100,50,-51,1,1]); 1
(find-even-index [1,2,3,4,5,6]); -1
(find-even-index [20,10,30,10,10,15,35]); 3
