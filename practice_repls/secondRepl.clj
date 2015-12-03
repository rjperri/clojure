;; Shires next top model

;; create an asymetrical hobbit body
(def asym-hobbit-body-parts [{:name "head" :size 3}
                             {:name "left-eye" :size 1}
                             {:name "left-ear" :size 1}
                             {:name "mouth" :size 1}
                             {:name "nose" :size 1}
                             {:name "neck" :size 2}
                             {:name "left-shoulder" :size 3}
                             {:name "left-upper-arm" :size 3}
                             {:name "chest" :size 10}
                             {:name "back" :size 10}
                             {:name "left-forearm" :size 3}
                             {:name "abdomen" :size 6}
                             {:name "left-kidney" :size 1}
                             {:name "left-hand" :size 2}
                             {:name "left-knee" :size 2}
                             {:name "left-thigh" :size 4}
                             {:name "left-lower-leg" :size 3}
                             {:name "left-achilles" :size 1}
                             {:name "left-foot" :size 2}])

;;generate a right side body part
(defn matching-part
  [part]
  {:name (clojure.string/replace (:name part) #"^left-" "right-") :size (:size part)})

(defn symmetrize-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  (loop [remaining-asym-parts asym-body-parts
         final-body-parts []]
    (if (empty? remaining-asym-parts)
      final-body-parts
      (let [[part & remaining] remaining-asym-parts]
        (recur remaining
               (into final-body-parts
                     (set [part (matching-part part)])))))))

;;call the function!
(symmetrize-body-parts asym-hobbit-body-parts)
(matching-part {:name "left-boy" :size 42})
(matching-part {:name "face" :size 42})
(matching-part {:name "right-boy" :size 42})
(matching-part {:nam "left-boy" :siz 42})

(def parts [])
(def part1 {:name "head" :size 42})
part1
(into parts (set [part1 (matching-part part1)]))

(def part2 {:name "left-boy" :size 42})
part2
(into parts (set [part2 (matching-part part2)]))
parts


;;loop and recursion
(defn bad_power
  [x y]
  (if (= y 0)
    1
    (* x (bad_power x (- y 1)))))
(bad_power 2 4)

(defn tail_power
  ([x y] (tail_power x y 1))
  ([x y result]
   (if (= y 0)
     result
     (tail_power x (- y 1) (* x result)))))
(tail_power 2 4)

(defn recur_power
  ([x y] (recur_power x y 1.0))
  ([x y result]
   (if (= y 0)
     result
     (recur x (- y 1) (* x result)))))
(recur_power 2 500)

(defn loop_power
  [x y]
  (loop [exponent y
         current 1.0]
    (if (= exponent 0)
      current
      (recur (- exponent 1) (* x current)))))
(loop_power 2 5000)



;(defn better-symmetrize-body-parts
 ; [asym-body-parts]





















;;Time to break it down
;;let binds a var to value in new scope
(let [x 1]
  (+ 1 x))

(def dog-list
  ["pug" "buster" "puppy" "tootie" "corky"])
(let [dogs (take 2 dog-list)]
  dogs)

(def person "mort")
(let [person "bob"]
  person)
person

(def x 1)
(let [x (+ 1 x)]
      (+ 1 x))
x

(let [[dog & dogs-left] dog-list]
  [dog dogs-left])


(def g 5)
g

(let [g g h g]
  g
  h)
g


(def names ["bob" "jesus" "coke" "germane" "pepsi"])
names

(let [[first_name second_name & rest_names] names]
  first_name
  second_name
  rest_names)






























