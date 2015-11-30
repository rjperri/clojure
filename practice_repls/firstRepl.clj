;; Anything you type in here will be executed
;; immediately with the results shown on the
;; right.
(+ 1 2 3)
(str "It was the panda " "in the thing " "with the thing")
(if true
  "By Zeus's Hammer"
  "By Aquwaman's trident")
(if false
  "By Zeus's Hammer"
  "By Aquwaman's trident")
(if false
  "By odin's bow?")
(if true
  (do (println "success!")
    "By Zeuses hammer!")
  (do (println "Failer!")
    "By Aquwaman's trident"))
(when true
  (println "success, moron!")
  "abracdaw")
(nil? 1)
(nil? nil)
(nil? false)
(if nil
  "hi"
  "false?")
(= 1 1)
(if (= 1 1)
  "you'r kind of getting this"
  "nope you aint got this")
(= true false)
(= false false)
(= true nil)
(= false nil)
(= nil nil)
(or 1 2)
(and 1 2)
(or 2 1)
(or (= 1 1) (= 2 2))
(or (= 1 1) (= 1 2))
(and (= 1 2) (= 1 2))
(or nil 1 2 false)
(or nil :bob)
(nil? :bob)

;;def
(def failed-protagonist-names
  ["Larrt Potter" "thing mcready" "incredible bluk"])
failed-protagonist-names

;;its not best practice to change a vars value like this
(def severity :mild)
(def error-message "OH GAWdf it be hottern")
(if (= severity :mild)
  (def error-message (str error-message "meh not really"))
  (def error-message (str error-message "um yeah it is!!!!!!!!!!!")))
error-message

;;Here's a more functional way of doing it
(defn error-message
  [severity]
  (str "OH GOWDS IT be hotten "
       (if (= severity :mild)
         "meh not realy"
         "AHHHH we're all gonna die")))
(error-message :mild)

;;Data Structures
(def name "chewbacca")
(str "\"Rawgggggggg\" - " name)
{}
{:first-name "Bob"
 :last-name "Mrphy"}
{"string-key" +}
{:name {:first "John" :middle "jacob" :last "thingkgjgk"}}
(hash-map :a 1 :b 2)
(get {:a 0 :b 1} :b)
(get {:a 0 :b {:c "hom um"}} :b)
(get {:a 0 :b 1} :c)
(get {:a 0 :b 1} :c "unicorns!")
(get-in {:a 0 :b {:c "ho hum"}} [:b :c])
({:name "thing"} :name)
({:a 0 :b 1} :b)
;;Keywords
:a
:rumplejrklj
:34
:_?
;;use keyword as function to get value in map perfferd way
(:a {:a 1 :b 2 :c 3}) ;;Equvolent to (get {:a 1 :b 2 :c 3} :a} or ({:a 1 :b 2 :c 3} :a)
(:d {:a 1 :b 2 :c 3} "didn't find nuttin")
;;vectors
[3 2 1]
(get [3 2 1] 0)
(get ["a" {:name "thingy"} "c"] 1)
(vector "bob" "thing" "is")
(conj [1 2 3] 4)
;;lists
'(1 2 3)
(nth '(:a :b :c) 0)
(list 1 "two" {3 4})
(conj '(1 2 3) 4)
;;sets
#{"kurt" 20 :thing}
(hash-set 1 1 2 2)
(conj #{:a :b} :b)
(set [1 2 3 3 3])
(contains? #{:a :b} :a)
(contains? #{:a :b} 3)
(contains? #{nil} nil)
(:a #{:a :b})
(get #{:a :b} :a)
(get #{:a nil} nil)
(get #{:a :b} "thing")

;;functions
(+ 1 2 3 4)
(* 1 2 3 4)
(first [1 2 3 4])
(or + -)
((or + -) 1 2 3)
((and (= 1 1) +) 1 2 3)
((first [+ 0]) 1 2 3)
(1 2 3 4)
("test" 1 2 3)
(inc 1.1)
(map inc [1 2 3])
(+ (inc 199) (/ 100 (- 7 2)))
;;function forms
(defn too-enthusiastic
  "return a cheer that might be too entuhsiastic"
  [name]
  (str "Oh, My, God! " name " you are most defientltuu lti the be "))
(too-enthusiastic "bob")
;;arity
(defn no-parms
  []
  "Me take no params")
(defn one-param
  [x]
  (str "Me take one param " x))
(defn two-params
  [x y]
  (str "me take 2 params " x y))
(two-params 1 2)
(defn multi-arity
  ;; 3-arity argument and body
  ([x y z]
     (str x " " y " " z))
  ;; 1-arity
  ([x]
     (str x " is it")))
(multi-arity 1 2 3)
(multi-arity 1)
(defn x-chop
  ([name chop-type]
     (str "I " chop-type " chop " name "! >SLAP<"))
  ([name]
     (x-chop name "ninja")))
(x-chop "bob")
(x-chop "bob" "judie")
;;rest parameter uses
(defn codger-communication
  [whippersnapper]
  (str "get off my lwan " whippersnapper "!!!"))
(defn codger
  [& whippersnappers]
  (map codger-communication whippersnappers))
(codger "bob" "Loyd" "germain")
(defn favorite-things
  [name & things]
  (str "Hi " name "Here are my things: "
       (clojure.string/join ", " things)))
(favorite-things "Bob" "food" "garbage" "lamp" "toothpasts")
;;destrcure
(defn my-first
  [[first-thing]]
  first-thing)
(my-first ["oven" "boy" "ball"])
(my-first '("oven" "boy" "ball"))
(defn chooser
  [[first-choice second-choice & rest-choice]]
  (println (str "first is : " first-choice))
  (println (str "second is : " second-choice))
  (println (str "rest is : "
                (clojure.string/join ", " rest-choice))))
(chooser ["bob", "alice", "muppets", "babies", "toothpaste"])
(defn announce-treasure-location
  [{lat :lat lng :lng}]
  (str "lat : " lat ", lng : " lng))
(announce-treasure-location {:lat 23 :lng 57})
(defn annonc-location
  [{:keys [lat lng]}]
  (str "lat : " lat ", lng : " lng))
(annonc-location {:lat "thing" :lng 67})
(defn another-location
  [{:keys [lat lng] :as treas-loca}]
  (str "lat : " lat " & " (:lat treas-loca)))
(another-location {:lat 6 :lng 5})
;;function body
(defn illustrative-function
  []
  (+ 1 304)
  30
  "Joe")
(illustrative-function)
(defn number-comment
  [x]
  (if (> x 6)
    "Big number!"
    "Phht small than 6, eh not really"))
(number-comment 5)
(number-comment 7)
(number-comment 6)
;;Anonymous Functions
(map (fn [name] (str "Hi, " name))
     ["Darth Vador" "Mr. Magoo"])
((fn [x] (* x 3)) 8)
(def my-special-multiplier (fn [x] (* x 3)))
(my-special-multiplier 8)
(#(* % 3) 8)
(map #(str "Hi, " %)
     ["Narf Thardor" "Thing Man Cometh"])
(#(str %1 " and " %2) "THing1" "thing2")
(#(identity %&) 1 "blarg" :yip)
(defn inc-maker
  "create   a custom incrementor"
  [inc-by]
  #(+ % inc-by))
(def inc3 (inc-maker 3))
(inc3 7)











































































































