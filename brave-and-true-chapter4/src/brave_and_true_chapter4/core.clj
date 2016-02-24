(ns brave-and-true-chapter4.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

;; sequences
(seq '(1 2 3))
(seq [1 2 3])
(seq #{1 2 3})
(seq {:name "Bill Compton" :occupation "Dead man walking"})
(into {} (seq {:a 1 :b 2 :c 3}))

;; map
(map inc [1 2 3])
(map str ["a" "b" "c"] ["A" "B" "C" "D"])
(list (str "a" "A") (str "b" "B") (str "c" "C"))

;; using map to make a sequences of Maps
(def human-consumption [8.1 7.3 6.6 5.0])
(def critter-consumption [0.0 0.2 0.3 1.1])
(defn unify-diet-data
  [human critter]
  {:human human
   :critter critter})
(map unify-diet-data human-consumption critter-consumption)


;; map passing a collection of functions
(def sum #(reduce + %))
(def avg #(/ (sum %) (count %)))
(defn stats
  [numbers]
  (map #(% numbers) [sum count avg]))
(stats [3 4 10])
(stats [80 1 44 13 6])

;; using map to retrieve the value associated with a keyword in a Map
(def identities
  [{:alias "Batman" :real "Bruce Wayne"}
   {:alias "Superman" :real "Clark Clent"}
   {:alias "Santa" :real "Your mom"}
   {:alias "Easter Bunny" :real "Your Dad"}])
(map :real identities)

;; reduce
;; reduce treats map like a sequence of vectors ([:max 30] [:min 10])
(reduce (fn [new-map [key val]]
          (assoc new-map key (inc val)))
        {}
        {:max 30 :min 10})
(assoc (assoc {} :max (inc 30))
  :min (inc 10))

;; reduce to filter out keys based on values
(reduce (fn [new-map [key val]]
          (if (> val 4)
            (assoc new-map key val)
            new-map))
        {}
        {:human 4.1 :critter 3.9})


;; take, drop, take-while, drop-while
(take 3 [1 2 3 4 5])
(drop 3 [1 2 3 4 5])

(def food-journal
  [{:month 1 :day 1 :human 5.3 :critter 2.3}
   {:month 1 :day 2 :human 5.1 :critter 2.0}
   {:month 2 :day 1 :human 4.9 :critter 2.1}
   {:month 2 :day 2 :human 5.0 :critter 2.5}
   {:month 3 :day 1 :human 4.2 :critter 3.3}
   {:month 3 :day 2 :human 4.0 :critter 3.8}
   {:month 4 :day 1 :human 3.7 :critter 3.9}
   {:month 4 :day 2 :human 3.7 :critter 3.6}])

(take-while #(< (:month %) 3) food-journal)
(drop-while #(< (:month %) 3) food-journal)
(take-while #(< (:month %) 4)
            (drop-while #(< (:month %) 2) food-journal))

;; filter and some
(filter #(< (:human %) 5) food-journal)
(some #(> (:critter %) 5) food-journal)
(some #(> (:critter %) 3) food-journal)


;; sort and sort-by
(sort [3 2 1])
(sort-by count ["aaa" "bb" "c"])

;; concat
(concat [1 2] [3 4])
(concat {:a 1} {:b 2})
;; not the same as into
(into {:a 1} {:b 2})
;; not the same as assoc
(assoc {} {:a 1} {:b 2})

;; assoc
(assoc {} :a 3 :b 4)
(assoc {:a 3} :a 4 :b 5)

;; Lazy Seqs
(def vampire-database
  {0 {:makes-blood-puns? false, :has-pulse? true  :name "McFishwich"}
   1 {:makes-blood-puns? false, :has-pulse? true  :name "McMackson"}
   2 {:makes-blood-puns? true,  :has-pulse? false :name "Damon Salvatore"}
   3 {:makes-blood-puns? true,  :has-pulse? true  :name "Mickey Mouse"}})

(defn vampire-related-details
  [social-security-number]
  (Thread/sleep 1000)
  (get vampire-database social-security-number))

(defn vampire?
  [record]
  (and (:makes-blood-puns? record)
       (not (:has-pulse? record))
       record))

(defn identify-vampire
  [social-security-numbers]
  (first (filter vampire?
                 (map vampire-related-details social-security-numbers))))

(time (vampire-related-details 0))
(time (def mapped-details (map vampire-related-details (range 0 1000000000))))
(time (first mapped-details))
(time (identify-vampire (range 0 1000000000)))

;; Infinite Sequences
(concat (take 8 (repeat "na")) ["Batman!"])
(take 3 (repeatedly (fn [] (rand-int 10))))

(defn even-numbers
  ([] (even-numbers 0))
  ([n] (cons n (lazy-seq (even-numbers (+ n 2))))))
(take 10 (even-numbers))

;; Fibanacci using lazy-seq
(defn fib
  ([] (fib 1 1))
  ([a b]
   (lazy-seq (cons a (fib b (+ b a))))))
(take 5 (fib))
(take 11 (fib))
(take 27 (fib))
(cons 1 '(2 3 4))



























