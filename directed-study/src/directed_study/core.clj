(ns directed-study.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

;;;;;;;;;;;;;;;;;; Level 1 - Basic syntax and defining a function

;;;;;;; -, +, <, >, *, /, and = Functions
; In Clojure mathematical symbols like +, =, -,<, and > come before their arguments.
; Unlike infix notation that is most commonly used, e.g. 2 + 3.
; This is called prefix notation and it's the same notation used in Racket.

(= (+ 2 3) 5)
(= (- 2 3) -1)
(= true (> 5 3))
(= (* 5 5) 25)
(= 6 (/ 30 5))

(= (- 5 (* 2 3)) n); Exercise: replace n with an integer to make the expression evaluate to true.

;((2 * 3) - 3); Exercise: change this to prefix notation.

;;;;; def for variable

;;;;;;; defn Function
; Clojure is a functional language.
; Meaning most of the code is built on functions that take an input and return an output.
; Functions in Clojure operate same as mathematical functions.
; They take an input and return an output.
; A mathematical function like f(x)= x + 3 can be written in Clojure like this:
(defn add-three [x] (+ x 3))
; The “defn” is defining the function add-three that takes an input [x] and adds it to 3.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;; defining functions in racket is different
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;; more practice

; Exercise: define a function called timesfour that multiplies an input x by four

;;;;;;;; cond Statement
; A cond statement is made up of pairs of test and expressions. If the test evaluates to true for the input.
; It evaluates the expression and returns it's value.
(defn pos-neg-else-zero [n]
  (cond
    (< n 0) "negative"
    (> n 0) "positive"
    :else "zero"))

; Write a function similar to pos-neg-else-zero that uses a cond. It returns an

;;;;;;; if Statement
; An if statement evaluates an expression.
; If that expression evaluates to true


;;;;;;;; count Function
(=  5 (count "hello"))
; Exercise: fill in the blank
(=  11 (count "hello world"))

;;;;;;;;;;;;;;;;; Level 2 - Collections and functions that take collections as an input
; A hashmap (also called just "map") is a collection that maps keys to values.
; They’re a way of associating a value with another value.
; A key can be anything it typically starts with a colon.
; For example :a, :7, :hello, and :h7 are all keys

;;;; Explain nil
; When you look for something in a collections and can't find it

;;;;;;; hashmap Collection
(= 12 (:banana {:apple 1, :banana 12, :cat 34}))
; Exercise: replace n with an integer to make the expression evaluate to true.
(= n (:apple {:apple 1, :banana 12, :cat 34}))


;;;;;;; vector Collection
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;; Do we need to introduce lists and vectors?
; Or just choose one and stick with it.



;;;;;;;;;; first Function
; Takes a collection and returns the first item in that collection.
(= 1 (first [1 2 3]))
; Exercise: replace n with an integer to make the expression evaluate to true.
(= n (first ["apple" "cat"]))

;;;;;;;;;;; rest Function
; Takes a collection and returns a sequence of the elements after the first element.

;;;;;;;;;;; empty? Function
; Takes a collection and returns true if it's empty and false if it's not empty.
; Example:
(= [2 3]  (rest [1 2 3] ))
; Exercise: replace n with an integer to make the expression evaluate to true.
(= n (rest ["apple" "cat"]))

;;;;;;;;;; conj Function
; Takes a collection and an element and returns a new collection with the
; element inserted at the beginning or the end depending if its a vector or a
; list.

;;;;;;;;;;;;;;;;;;Level 3 - Writing more complex functions

;;;;;;;;;; avoid when use if or cond instead
; remove println

;;;;;;; loop and recur problem
(loop [x 10]
  (when (> x 1)
    (println x)
    (recur (- x 2))))

;;;;;;;; Recursion Problems
; Write a function to return the last element in a vector

(defn f[x]
(if
  (empty? (rest x))
  (first x)
  (f (rest x))))


; Write a function to sum up all elements in a vector using, first, empty?, and rest
(defn sum-vector [s]
  (if (empty? s)
    0
    (+ (first s) (sum-vector (rest s)))))

(defn sum-vector [s]
  (loop [ls s, acc 0]
    (if (empty? ls)
      acc
    (recur (rest ls) (+ acc (first ls))))))

;;;;;;;;;;;;;;;;;;;;Level 4 - Higher order functions

;;;;;;;;;; Let
; Let takes;;;;;;;;;;;;;;;;;; Level 1 - Basic syntax and defining a function

;;;;;;; -, +, <, >, *, /, and = Functions
; In Clojure mathematical symbols like +, =, -,<, and > come before their arguments.
; Unlike infix notation that is most commonly used, e.g. 2 + 3.
; This is called prefix notation and it's the same notation used in Racket.

(= (+ 2 3) 5)
(= (- 2 3) -1)
(= true (> 5 3))
(= (* 5 5) 25)
(= 6 (/ 30 5))

(= (- 5 (* 2 3)) n); Exercise: replace n with an integer to make the expression evaluate to true.

;((2 * 3) - 3); Exercise: change this to prefix notation.

;;;;; def for variable

;;;;;;; defn Function
; Clojure is a functional language.
; Meaning most of the code is built on functions that take an input and return an output.
; Functions in Clojure operate same as mathematical functions.
; They take an input and return an output.
; A mathematical function like f(x)= x + 3 can be written in Clojure like this:
(defn add-three [x] (+ x 3))
; The “defn” is defining the function add-three that takes an input [x] and adds it to 3.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;; defining functions in racket is different
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;; more practice

; Exercise: define a function called timesfour that multiplies an input x by four

;;;;;;;; cond Statement
; A cond statement is made up of pairs of test and expressions. If the test evaluates to true for the input.
; It evaluates the expression and returns it's value.
(defn pos-neg-else-zero [n]
  (cond
    (< n 0) "negative"
    (> n 0) "positive"
    :else "zero"))

; Write a function similar to pos-neg-else-zero that uses a cond. It returns an

;;;;;;; if Statement
; An if statement evaluates an expression.
; If that expression evaluates to true


;;;;;;;; count Function
(=  5 (count "hello"))
; Exercise: fill in the blank
(=  11 (count "hello world"))

;;;;;;;;;;;;;;;;; Level 2 - Collections and functions that take collections as an input
; A hashmap (also called just "map") is a collection that maps keys to values.
; They’re a way of associating a value with another value.
; A key can be anything it typically starts with a colon.
; For example :a, :7, :hello, and :h7 are all keys

;;;; Explain nil
; When you look for something in a collections and can't find it

;;;;;;; hashmap Collection
(= 12 (:banana {:apple 1, :banana 12, :cat 34}))
; Exercise: replace n with an integer to make the expression evaluate to true.
(= n (:apple {:apple 1, :banana 12, :cat 34}))


;;;;;;; vector Collection
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;; Do we need to introduce lists and vectors?
; Or just choose one and stick with it.



;;;;;;;;;; first Function
; Takes a collection and returns the first item in that collection.
(= 1 (first [1 2 3]))
; Exercise: replace n with an integer to make the expression evaluate to true.
(= n (first ["apple" "cat"]))

;;;;;;;;;;; rest Function
; Takes a collection and returns a sequence of the elements after the first element.

;;;;;;;;;;; empty? Function
; Takes a collection and returns true if it's empty and false if it's not empty.
; Example:
(= [2 3]  (rest [1 2 3] ))
; Exercise: replace n with an integer to make the expression evaluate to true.
(= n (rest ["apple" "cat"]))

;;;;;;;;;; conj Function
; Takes a collection and an element and returns a new collection with the
; element inserted at the beginning or the end depending if its a vector or a
; list.

;;;;;;;;;;;;;;;;;;Level 3 - Writing more complex functions

;;;;;;;;;; avoid when use if or cond instead
; remove println

;;;;;;; loop and recur problem
(loop [x 10]
  (when (> x 1)
    (println x)
    (recur (- x 2))))

;;;;;;;; Recursion Problems
; Write a function to return the last element in a vector

(defn f[x]
(if
  (empty? (rest x))
  (first x)
  (f (rest x))))


; Write a function to sum up all elements in a vector using, first, empty?, and rest
(defn sum-vector [s]
  (if (empty? s)
    0
    (+ (first s) (sum-vector (rest s)))))

(defn sum-vector [s]
  (loop [ls s, acc 0]
    (if (empty? ls)
      acc
    (recur (rest ls) (+ acc (first ls))))))

;;;;;;;;;;;;;;;;;;;;Level 4 - Higher order functions

;;;;;;;;;; Let
; Let takes a vector containing pairs and binds values to variables.
;Examples:
(let [x 0] x)
(= 10 (let [x 5 y 5] (+ x y)))


;;;;;;;;;;;; Suffix problem
; Write a function that takes a list and returns every suffix of that list. Starting with the longest suffix and ending with the shortest suffix

;(defn suffix[list]
;  (if (empty? list)
; (conj list suffix[(rest list)]))

