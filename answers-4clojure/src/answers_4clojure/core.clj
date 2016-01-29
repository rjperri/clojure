(ns answers-4clojure.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

;1) Nothing but the truth
(= true true)

;2) Simple Math
(= (- 10 (* 2 3)) 4)

;3) Intor to Strings
(= "HELLO WORLD" (.toUpperCase "hello world"))

;4) Intro to Lists
(= (list :a :b :c) '(:a :b :c))

;5) Lists: conj
(= '(1 2 3 4) (conj '(2 3 4) 1))
(= '(1 2 3 4) (conj '(3 4) 2 1))

;6) Intro to Vectors
(= [:a :b :c] (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c))

;7) Vectors; conj
(= [1 2 3 4] (conj [1 2 3] 4))
(= [1 2 3 4] (conj [1 2] 3 4))

;8) Intro to Sets
(= #{:a :b :c :d} (set '(:a :a :b :c :c :c :c :d :d)))
(= #{:a :b :c :d} (clojure.set/union #{:a :b :c} #{:b :c :d}))

;9) Sets: conj
(= #{1 2 3 4} (conj #{1 4 3} 2))

;10) intro to MAPS
(= 20 ((hash-map :a 10, :b 20, :c 30) :b))
(= 20 (:b {:a 10, :b 20, :c 30}))

;11) Maps: conj
(= {:a 1, :b 2, :c 3} (conj {:a 1} [:b 2] [:c 3]))

;12) Intro to Sequences
(= 3 (first '(3 2 1)))
(= 3 (second [2 3 4]))
(= 3 (last (list 1 2 3)))

;13) Sequences: rest
(= [20 30 40] (rest [10 20 30 40]))

;14) Intro to Functions
(= 8 (( fn add-five [x] (+ x 5)) 3))
(= 8 ((fn [x] (+ x 5)) 3))
(= 8 (#(+ % 5) 3))
(= 8 ((partial + 5) 3))

;15) Double Down
(= (* 2 2) 4)
(= (* 2 3) 6)

;16) Hello World
;(= (_ "Dave") "hello, Dave!")
;(= (_ "Jenn") "hello, Jenn!")
;(= (_ "Rhea") "hello, Rhea!")
(fn [x] (str "Hello, " x "!"))
#(str "Hello, " % /!)

;17) Sequences: map
(= '(6 7 8) (map #(+ % 5) '(1 2 3)))

;18) Sequences: filter
(= '(6 7) (filter #(> % 5) '(3 4 5 6 7)))

;19) last Element
;(= (_ [1 2 3 4 5]) 5)
;(= (_ '5 4 3)) 3)
;(= (_ ["b' "c" "d"]) "d')
reduce #(identity %2)
#(-> % reverse first)

;20)Penultimate Element
;write a function which returns the second to the last element from a sequence
;(= (_ (list 1 2 3 4 5)) 4)
;(= (_ ["a" "b" "c"]) "b")
;(= (_ [[1 2] [3 4]]) [1 2])
#(let [[x y & z] (reverse %)] y)
(comp second reverse)
#(-> % reverse second)

;36) Let it Be
;(= 10 (let _ (+ x y)))
;(= 4 (let _ (+ y z)))
;(= 1 (let _ z))
[z 1 y 3 x 7]

;37)Regular Expressions
(= "ABC" (apply str (re-seq #"[A-Z]+" "bA1B3Ce ")))

;64) Intro to Reduce
(= 15 (reduce + [1 2 3 4 5])) 

;57) Simple Recursion
(= '(5, 4, 3, 2, 1)
   ((fn foo
      [x]
      (when (> x 0)
        (conj (foo (dec x)) x))) 5))

;71) Rearranging Code: -> Thread first
(= (last (sort (rest (reverse [2 5 4 1 3 6]))))
   (-> [2 5 4 1 3 6]
       (reverse)
       (rest)
       (sort)
       (last))
   5)

;68) Recurring Theme
(= [7 6 5 4 3]
   (loop [x 5
          result []]
     (if (> x 0)
       (recur (dec x) (conj result (+ 2 x)))
       result)))

;72) Rearranging code: ->> Thread last
(= (reduce + (map inc (take 3 (drop 2 [2 5 4 1 3 6]))))
   (->> [2 5 4 1 3 6]
        (drop 2)
        (take 3)
        (map inc)
        (reduce +))
   11)




 


